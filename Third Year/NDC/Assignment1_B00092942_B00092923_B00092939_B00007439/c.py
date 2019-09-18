
# Echo client program
import socket
import hashlib
import time
import datetime

HOST = '127.0.0.1'    # The remote host
PORT = 50007          # The same port as used by the server

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

# prompt the user for their name
print "What is your name:"
name = raw_input()
nameOutput = '<cmd><name>'+ name+'</name></cmd>'

# send the name to the server
s.sendall(nameOutput)

# add the recieved data to the variable data
data = s.recv(80000)

# breaking apart the data we get back.
response = data.split(':')

# loop through the response 
for x in response:
    print "Response:" + str(x)
s.close

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

# prompt the user to enter a comment
print "type input:"
text = raw_input()

# if the word ping is in the text
if "ping" in text:
    # start timer 
    startTime = time.time()
    print "Ping start time " + str(startTime)

# hash the users input
hash = hashlib.sha224(text+'18').hexdigest()

# holder for command
output = '<cmd>' + name + 's message:'+text+'-'+hash+'</cmd>' 
#print output;

# when we send data to the server, we are using a colon
# at the end of a sentence to mark the end of the current sentence
# later when the input comes back, we will then be breaking the input
# into individual parts using the colon : to separate the lines
if "ping" in text:
    output = "<cmd>ping</cmd>"
elif "name" in text:
    output = '<cmd>'+text+'</cmd>'
s.sendall(output + ":")

data = s.recv(80000)

# breaking apart the data we get back.
response = data.split(':')

for x in response:
    print "Response:" + str(x)

# if the word pong is in the response from the server
# print the stop time and total lenght of time
if "pong" in response:
	stopTime = time.time()  
	print "Stop time " + str(stopTime)
	totalTime = stopTime - startTime
	print "Total time " + str(totalTime)

# if time is in the response print the current time	
if "time" in response:
    print "\n The current time is : " + str(datetime.datetime.now().time())

# close the connection to the socket    
s.close()
