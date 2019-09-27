import numpy as np
import cv2
from PIL import ImageGrab

# define the region of interest we want to check
def roi(frame, vertices):
	# create a mask of zeros the size of the frame
	mask = np.zeros_like(frame)
	# fill the area bounded by several polygonal contours
	cv2.fillPoly(mask, vertices, 255)
	# calculate the per-element bit-wise conjunction of two arrays or an array and a scalar
	masked = cv2.bitwise_and(frame, mask)
	# return the masked frame
	return masked

# import the video
video = cv2.VideoCapture('C:\\Users\\Derek\\OneDrive\\ITB Year 4\\Semester 2\\Computer Vision\\StayingInLane.avi')

# while the video is being played 
while True:
	# get the frame from the video
    ret, orig_frame = video.read()

    # if theres no frame 
    if not ret:
    	# re-import the video
        video = cv2.VideoCapture('C:\\Users\\Derek\\OneDrive\\ITB Year 4\\Semester 2\\Computer Vision\\StayingInLane.avi')
        # break continue with the program
        continue

    # convert the frame to grayscale     
    grayscale = cv2.cvtColor(orig_frame, cv2.COLOR_BGR2GRAY)
    # copy the frame
    frame = grayscale.copy()

    # apply canny edge detection to the frame, by adjusting the lower and upper threshold can increase/decrease the clarity and lines
    # of the frame. In this case 80 and 180 seemed to work best 
    edges = cv2.Canny(frame, 80, 180)

    # smooth the image edges by applying a filter 
    edges = cv2.GaussianBlur(edges, (5, 5), 0)

    # create an array of vertices with the co-ordinates for the custom Region Of Interest ROI
    vertices = np.array([[80, 160],[300,40], [320,50], [360,50], [500,80], [600,150]], np.int32)
    # apply the ROI to the frame
    position = roi(edges, [vertices])

    # set the min line length and the max gap
    lines = cv2.HoughLinesP(position, 1, np.pi/180, 80, maxLineGap=5)
    
    # if there is a line
    if lines is not None:
    	# iterate through the lines
        for line in lines:
        	# get the X and Y coordinates of the line
            x1, y1, x2, y2 = line[0]
            # add a green line the frame, with a thickness of 2 pixels
            cv2.line(orig_frame, (x1, y1), (x2, y2), (180, 105, 255), 2)
 	
 	# show the video with the lines overlay
    cv2.imshow("frame", orig_frame)
    # show the video with the canny edges
    cv2.imshow("edges", edges)
    # show the grayscale video
    cv2.imshow("grayscale", grayscale)
    
    # display the frame for specified milliseconds
    key = cv2.waitKey(25)

    # if the key is 27 milliseconds
    if key == 27:
    	# break from the playing of the video
        break
        
# close the opend video file
video.release()
# destroy the window which was created
cv2.destroyAllWindows()