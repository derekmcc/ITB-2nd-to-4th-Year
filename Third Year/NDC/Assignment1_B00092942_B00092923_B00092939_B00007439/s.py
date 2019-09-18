import socket
import threading, Queue
import hashlib
import datetime

HOST = '127.0.0.1'        
PORT = 50007              
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))


    
# This is the buffer string
# when input comes in from a client it is added
# into the buffer string to be relayed later
# to different clients that have connected
# Each message in the buffer is separated by a colon :
buffer = ""   

# global variable to keep hold of the number of items on the buffer
totalMsg = 0

# protocol to send the username to the clients of newly joind clients
def introduceNewUser(command):
    print conn.send("\n"+command+" has just joined the chat session")

# custom say hello command
def sayHello():
    print "\nThe hello function was called\n"

# protocol to send the number of items stored on the buffer
def total():
    print "\nThe total messages in the buffer is " + str(totalMsg)
    # send the total to the client
    conn.send("\nThe total messages in the buffer is " + str(totalMsg))

# protocol to sent the time to a client upon request
def time():
    print "\nThe current time is " + str(datetime.datetime.now().time())
    conn.send("time")

# send pong back to client
def pong():
    print "Sending pong..."
    conn.send("pong")

# parse the inputted command from the user
def parseMessage(command):
    print "parsing message..."
    # removing the word message (8 chars)
    keyvaluePair = command[8:len(command)]    
    
    print keyvaluePair#see entire string

    dashPosition = keyvaluePair.index('-')

    hash = keyvaluePair[dashPosition+1:len(keyvaluePair)]

    message = keyvaluePair[0:dashPosition]
    # hash the message
    hashMessage = hashlib.sha224(message+'18').hexdigest()
    
    # check if the hash's match.
    # also check if the total and time commands were calles if they were
    # call the relevent function
    if hash in hashMessage:
        print "Match's all Ok"
    if "total" in command:
        total()
    elif "time" in command:
    	time()

# sample parser function. The job of this function is to take some input
# data and search to see if a command is present in the text. If it finds a 
# command it will then need to extract the command.
def parseInput(data):
    print "parsing..."
    print str(data)
    
    # Checking for <cmd> commands
    if "cmd" in data:
        print "command in data.."
        
        # find the start position index of the command
        start = data.index('<cmd>')
        # Add 5 on for the length of the <cmd>
        start = start + 5
        # chop up remving start and end. 
        command = data[5:-7] #-7 chops of the end of the tag </cmd>
        
        # Once we find a command, we will then check if a specific command
        # is inside, if we find the word "hello" we are telling the server
        # to call the sayHello() function.
        if "hello" in command:
            sayHello()
        elif "message" in command:
            parseMessage(command)
        elif "ping" in command:
            print "Pinging..."
            pong()
        elif "total" in command:
            print "Total messages in buffer" + str(totalMsg)
            total()    
        elif "name" in command:
             # find the start position index of the command
            start = data.index('<name>')
            # Add 11 on for the length of the <cmd><name>
            start = start + 11
            # chop up remving start and end. 
            command = data[11:-13] #-13 chops of the end of the tag </name></cmd>
            introduceNewUser(command)
        
        
    
# we a new thread is started from an incoming connection
# the manageConnection funnction is used to take the input
# and print it out on the server
# the data that came in from a client is added to the buffer.
    
def manageConnection(conn, addr):
    global buffer, totalMsg
    print 'Connected by', addr
   
	# increment the total number of item on the buffer by one   
    totalMsg = totalMsg + 1
    data = conn.recv(1024)
    
    parseInput(data)# Calling the parser
    
    print "rec:" + str(data)
    buffer += str(data)
    
    # send the buffer to the clients
    conn.send(str(buffer))
    # close the connection    
    conn.close()


while 1:
    s.listen(1)
    conn, addr = s.accept()
    # after we have listened and accepted a connection coming in,
    # we will then create a thread for that incoming connection.
    # this will prevent us from blocking the listening process
    # which would prevent further incoming connections
    t = threading.Thread(target=manageConnection, args = (conn,addr))
    
    t.start()
    
    


