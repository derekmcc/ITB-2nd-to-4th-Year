from flask import Flask
import requests
import pika
import ZODB, ZODB.FileStorage
import persistent
import transaction
from flask import request
import xmlrpc.client
import datetime
import time
import logging
import inspect
app = Flask(__name__)

class Student(persistent.Persistent):
    #variables to hold student details
    studentFirstName = ''
    studentLastName = ''
    studentNumber = ''

    #setters and getters for the student details
    def setStudentFirstName(self, sFirstName):
        self.studentFirstName = sFirstName
    def setStudentLastName(self, sLastName):
        self.studentLastName = sLastName
    def setStudentNumber(self, sNumber):
        self.studentNumber = sNumber
    def getStudentFirstName(self):
        return self.studentFirstName
    def getStudentLastName(self):
        return self.studentLastName
    def getStudentNumber(self):
        return self.studentNumber

@app.route("/")
def hello():
    #log the name of function 
    callsLog(str(inspect.stack()[0][3]))

    #return hello
    return "Hello World!"

@app.route('/justweather')
def justweather_call():
    #log the name of function 
    callsLog(str(inspect.stack()[0][3]))

    #make a request to the select address for weather 
    x = requests.get('http://kylegoslin1.pythonanywhere.com/').json()
    
    #placeholder for the forecast
    forecast = x['forecast']

    #return the forecast
    return '{forecast:" ' + forecast + '"}'

@app.route('/updates')
def justupdates_call():
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #open the text file
    f = open('updates.txt', 'r')
    
    #read in the text
    x = f.readlines()
    
    #add an curly brace
    output = '{'
    
    #print the text and type
    print(type(x))
    print(x)

    #loop through the text
    for item in x:
        #wrap the text in cury braces
        output = output + '"line": "' + item + '",'
    
    #close the connection
    f.close()

    # remove trailing comma
    output = output[:-1] 
    output = output + '}'

    #print the outputted json dat from the text file
    print(output)

    #return the text data in json format
    return output

buffer = ''
def callback(ch, method, properties, body):
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))
    global buffer
    buffer = body
    print(" [x] Received %r" % body)

@app.route('/insert')
def login():
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #catch the variables from the GET and extract them
    firstName = request.args.get('firstname')
    lastName = request.args.get('lastname')
    studentid = request.args.get('studentid')

    #open a connection to the local DB and save the details as an object
    storage = ZODB.FileStorage.FileStorage('mydata.fs')
    db = ZODB.DB(storage)
    connection = db.open()
    root = connection.root

    # saving the data
    root.s1 = Student()

    # set the data into the node
    root.s1.setStudentFirstName(firstName)
    root.s1.setStudentLastName(lastName)
    root.s1.setStudentNumber(studentid)

    # save the changes!
    transaction.commit()

    #close the connection
    connection.close()
    db.close()

    #log the users info
    userDetails = 'First Name: ' + firstName + ' Last Name: ' + lastName + 'Student ID: ' + studentid
    userLog(userDetails)

    #return the data
    return firstName + '-' + lastName + '-' + studentid

@app.route('/view')
def view():
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #open a connection to the local DB and save the details as an object
    storage = ZODB.FileStorage.FileStorage('mydata.fs')
    db = ZODB.DB(storage)
    connection = db.open()
    root = connection.root

    #return the student details
    return root.s1.getStudentFirstName() + '-' + root.s1.getStudentLastName() + '-' + root.s1.getStudentNumber()

@app.route('/read')
def readRabbit():
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #make a connection to the localhost
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    
    #connect to the channel
    channel = connection.channel()

    #declare the queue
    channel.queue_declare(queue='hello')

    #declare the channel for listening for callbacks 
    channel.basic_consume(callback,
                          queue='hello',
                          no_ack=True)

    #print message
    print(' [*] Waiting for messages. To exit press CTRL+C')
    
    #start listening for callbacks
    channel.start_consuming()
    #return the global buffer
    global buffer
    return buffer

@app.route("/callClient/<temp>")
def call_client(temp):
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #variable to hold temp
    content = ''

    #if the temp is between 0 and 10 set content to cold
    if (int(temp) >= 0 and int(temp) <= 10):
        content = 'cold'
    #else if the temp is between 11 and 20 set content to warm
    elif (int(temp) >= 11 and int(temp) <= 20):
        content = 'warm'
    #else return the temp as its int value
    else:
        content = str(temp)
    with xmlrpc.client.ServerProxy("http://localhost:8001/") as proxy:
        content = str(proxy.is_even(content))

    #return the content
    return content

@app.route("/ping")
def pingPong():
    #log the name of function
    callsLog(str(inspect.stack()[0][3]))

    #get the time
    ts = time.time()

    #get the date and time in human readable format
    st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

    #variable to hold the word pong and time
    ping = 'Pong ' + str(st)

    #return the ping variable
    return ping

def userLog(userInfo):
    #get the time
    ts = time.time()

    #get the date and time in human readable format
    st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

    #create/set the log file name 
    logging.basicConfig(filename='users.log',level=logging.INFO)

    #add the info and time to the log
    logging.info(userInfo + ' Time: ' + str(st))

def callsLog(functionName):
    #get the time
    ts = time.time()

    #get the date and time in human readable format
    st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

    #create/set the log file name
    logging.basicConfig(filename='calls.log',level=logging.INFO)

    #add the info and time to the log
    logging.info('Function Called: ' + functionName + ' Time: ' + str(st))