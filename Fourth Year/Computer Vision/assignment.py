import cv2 as cv
import numpy as np
import time
import matplotlib.pyplot as plt
from array import *
import Stack as stack
import queue

# Function to perform the image threshold
def threshold (img, thresh):
    #traverse the image
    for x in range(0, img.shape[0]):
        for y in range(0, img.shape[1]):
            #if the pixel is greather than the threshold
            if img[x,y] > thresh:
                #set the pixel to white
                img[x,y] = 255
            else:
                #set the pixel to black
                img[x,y] = 0
   # dImage = imageDilation(img)
   # eImage = imageErosion(dImage)
    return img

# Function to create histogram
def imhist(img):
    #create an array of zeros
    hist = np.zeros(256)
    #traverse the image
    for x in range(0, img.shape[0]):
        for y in range(0, img.shape[1]):
            #increment the histogram cell
            hist[img[x,y]]+=1
    return hist

# Function to find the threshold
def findT(hist):
    max = 0
    for i in range(256):
        if hist[i] > max:
            max = hist[i]
            peak = i
    T = peak - 50
    return T

# Function to perform image dialation
def imageDilation(img):
    # copy the image
    dialatedImage = img.copy()

    # loop through image pixels
    for x in range(1, img.shape[0]-1):
        for y in range(1, img.shape[1]-1):

            # apply structuring element
            xNeighbors = getXaxisNeighbours(x)
            yNeighbors = getYaxisNeighbours(y)

            # loop through structuring element
            for n in range(len(xNeighbors)): 

                # if the neighbouring pixel is white
                if img[xNeighbors[n], yNeighbors[n]] == 255:

                    # set the pixel to white
                    dialatedImage[x, y] = 255
    # return the dialated image                
    return dialatedImage

# Function for the coordinates of the X axis structuring element
def getXaxisNeighbours(x):
    xNeighbors = [
            x - 1,  # Top Left
            x,      # Top Middle
            x + 1,  # Top Right
            x - 1,  # Middle Left
            x,      # Middle
            x + 1,  # Middle Right
            x - 1,  # Bottom Left
            x,      # Bottom Middle 
            x + 1]  # Bottom Right
    return xNeighbors

# Function for the coordinates of the Y axis structuring element
def getYaxisNeighbours(y):
    yNeighbors = [
            y - 1,  # Top Left
            y - 1,  # Top Middle
            y - 1,  # Top Right
            y,      # Middle Left
            y,      # Middle
            y,      # Middle Right
            y + 1,  # Bottom Left
            y + 1,  # Bottom Middle
            y + 1]  # Bottom Right
    return yNeighbors

# Function to perform image erosion
def imageErosion(img):
    # copy the image
    erodedImage = img.copy()
    
    # loop through image pixels
    for x in range(1, img.shape[0]-1):
        for y in range(1, img.shape[1]-1):
            
            # apply structuring element
            xNeighbors = getXaxisNeighbours(x)
            yNeighbors = getYaxisNeighbours(y)
            
            # loop through structuring element
            for n in range(len(xNeighbors)): 
                
                # if the neighbouring pixel is white
                if img[xNeighbors[n], yNeighbors[n]] == 0:
                    # set the pixel to black
                    erodedImage[x, y] = 0
    return erodedImage

# Function to label the image
def connectedComponentLabelling(img):
    #local variables
    currLabel = 1
    label = np.zeros((img.shape[0],img.shape[1]))
    q = queue.Queue()

    #traverse image
    for x in range(1, img.shape[0]-1):
        for y in range(1, img.shape[1]-1):
            #check pixel is a foreground pixel and is not labeled
            if (img[x,y] == 0 and label[x,y] == 0):
                #increment the label
                currLabel += 1
                #add the image pixel to the queue
                q.put(img[x,y])
                #assign the label to the current pixel
                label[x,y] = currLabel

                #while the queue is not empty
                while not q.empty():
                    #dequeue from the queue
                    coordinates = q.get()
                    #check the pixels neighbours(3x3 cell)
                    xNeighbors = getXaxisNeighbours(x)
                    yNeighbors = getYaxisNeighbours(y)
                    #travers the neighbours
                    for n in range(len(xNeighbors)):
                        #check pixel is a foreground pixel and is not labeled 
                        if(img[xNeighbors[n]][yNeighbors[n]] == 0 and label[xNeighbors[n]][yNeighbors[n]] == 0):
                            #add the image pixel to the queue
                            q.put(img[xNeighbors[n], yNeighbors[n]])
                            #assign the label to the current pixel
                            label[xNeighbors[n], yNeighbors[n]] = currLabel
    return label

# Function to check if the image passed or fails
def checkBoundary(img):
    #local variables
    label = connectedComponentLabelling(img)
    topHalf = 0
    bottomHalf = 0
    highX = 0
    lowX = 0
    lowY = 0
    highY = 0
    firstXandY = 1
    margin = 0

    #get the highest/lowest x and y position on the o-ring
    for x in range(0, img.shape[0]):
            for y in range(0, img.shape[1]):
                if img[x,y] == 0:
                    if x >= highX:
                        highX = x
                    if y >= highY:
                        highY = y
                    if firstXandY == 1:
                        lowX = x
                        lowY = y
                    firstXandY = 2
                    if y <= lowY:
                        lowY = y
                    if x <= lowX:
                        lowX = x

    xHighPlusXlow = highX + lowX
    xMidPoint = xHighPlusXlow / 2
    
    #top half of o-ring
    for x in range(lowX, int(xMidPoint)):
        for y in range(lowY, highY+1):
            if(img[x][y] == 0 and label[x,y] != 0):
                topHalf += 1

    ##bottom half of o-ring
    for x in range(int(xMidPoint), highX + 1):
        for y in range(lowY, highY + 1):
            if(img[x][y] == 0 and label[x,y] != 0):
                bottomHalf += 1
    
    if topHalf > bottomHalf:
        margin = topHalf - bottomHalf
    elif bottomHalf > topHalf:
        margin = bottomHalf - topHalf
    else:
        margin = topHalf - bottomHalf

    #check if the image passed or failed
    if margin <= 90:
        img = cv.putText(img, 'Pass', (10, 200), cv.FONT_HERSHEY_SIMPLEX, 1,(0, 255, 0))
    else:
        img = cv.putText(img, 'Fail', (10, 200), cv.FONT_HERSHEY_SIMPLEX, 1,(0, 255, 0))

    return img

#NOT BEING USED
def getOutline(img):
    outline = img.copy()
    for x in range(1, img.shape[0]-1):
        for y in range(1, img.shape[1]-1):
            if (outline[x,y-1] == 0 or outline[x-1,y] == 0 or outline[x+1,y] == 0 or outline[x,y+1] == 0):
                outline[x,y] = 1
            else:
                outline[x,y] = 0
            #xNeighbors = getXaxisNeighbours(x)
           # yNeighbors = getYaxisNeighbours(y)
            #if img[x,y] == 0:
               # for n in range(len(xNeighbors)): 
                    #if img[xNeighbors[n], yNeighbors[n]] == 255:
                        #outline[x,y] = 1
                    #else:
                       # outline[x,y] = 0
                    
    return outline

#read in images
for i in range(15):
    #read in an image into memory
    img = cv.imread('C:\\Users\\Derek\\OneDrive\\ITB Year 4\\Semester 2\\Computer Vision\\Orings\\Oring' + str(i+1) + '.jpg',0)
    copy = img.copy()
    before = time.process_time()
    hist = imhist(img)
    T = findT(hist) 
    plt.plot(hist)
    plt.plot((T, T), (0, 500), 'g')
    plt.show()

    img = threshold(copy, T)
    after = time.process_time()

    print("Time taken to process hand coded thresholding: " + str(after-before))

    beforeMorphology = time.process_time()
    imgDilate = imageDilation(img)
    imgDilate = imageDilation(imgDilate)
    imgErode = imageErosion(imgDilate)
    imgErode = imageErosion(imgErode)
    imgErode = imageErosion(imgErode)
    checkImage = checkBoundary(imgErode) 
    afterMorphology = time.process_time()
    
    print("Time taken to process hand coded image morphology: " + str(afterMorphology-beforeMorphology))
    totalTime = afterMorphology-beforeMorphology
    checkImage = cv.putText(checkImage, 'Total Time ' + str(totalTime) + '\'s', (30, 213), cv.FONT_HERSHEY_SIMPLEX, 0.5,(0, 255, 0))
    cv.imshow('thresholded image 2',img)
    cv.imshow('Image Dilation & Erosion', checkImage)
    cv.waitKey(0)
cv.destroyAllWindows()