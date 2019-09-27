
import tensorflow as tf
import time
import csv

NUM_EXAMPLES = 4000 # Number of training or evaluation examples
NUM_FEATURES = 2 # Number of input features
NUM_LABELS = 3	# Number of output features or class labels
NUM_HIDDEN = 3 # Number of hidden/middle layer nodes
LEARNING_RATE = 10 # Speed of learning
NUM_EPOCHS = 15000 # Present the training data this number of times
OUTPUT = 1000 # Test the model and do some output every X epochs
TOLERANCE = 0.1

# Path to the network training, evaluation data and model
INPUT_FILE = "./data/train.csv"
MODEL_PATH = "./model.ckpt"


# Array for the input features
trainx = []
# Array for the output labels/features
trainy = []

# Load inputs and labels from disk
# NOTE: assumes 2 inputs followed by 1 label
# NOTE: files assumed to be located in a data directory
# Limit the examples
with open(INPUT_FILE, 'rt') as csvfile:
    input_data = csv.reader(csvfile, delimiter=',')
    for row in input_data:
        trainx.append([float(row[0]), float(row[1])])
        trainy.append([float(row[2]), float(row[3]), float(row[4])])

# Define the input layer placeholders
x_ = tf.placeholder(tf.float32, shape=[NUM_EXAMPLES, NUM_FEATURES], name = 'inputs')
# Define the desired/target output placeholders
y_ = tf.placeholder(tf.float32, shape=[NUM_EXAMPLES, NUM_LABELS], name = 'labels')

# Define weights
Weights1 = tf.Variable(tf.random_uniform([NUM_FEATURES, NUM_HIDDEN], -1, 1), name = "Weights1")
Weights2 = tf.Variable(tf.random_uniform([NUM_HIDDEN, NUM_LABELS], -1, 1), name = "Weights2")


# Define the BIAS node
Bias1 = tf.Variable(tf.zeros([NUM_HIDDEN]), name = "Bias1")
Bias2 = tf.Variable(tf.zeros([NUM_LABELS]), name = "Bias2")

# Feed forward to the hidden layer
H1 = tf.sigmoid(tf.matmul(x_, Weights1) + Bias1)

# Feedforward to the output layer - Hypothesis is what the
# neural network thinks it should output for a
# given input.
Hypothesis = tf.sigmoid(tf.matmul(H1, Weights2) + Bias2)

# Setup the cost function and set the traning method
# We are using the squared error (ACTUAL - DESIRED)
#cost = tf.reduce_sum(tf.square(Hypothesis - y_))
cost = tf.losses.mean_squared_error(labels=y_, predictions=Hypothesis)

# Choose a training approach - effectively backprop
train_step = tf.train.GradientDescentOptimizer(LEARNING_RATE).minimize(cost)

# Initialise the variables and create a session
init = tf.global_variables_initializer()

# 'Saver' op to save and restore all the variables
saver = tf.train.Saver()

sess = tf.Session()

# Initialise the session
sess.run(init)

# Start the training loop
t_start = time.clock()
print("Running for " + str(NUM_EPOCHS) + " Epochs.")
for i in range(NUM_EPOCHS):
    # Run the training
    sess.run(train_step, feed_dict={x_: trainx, y_: trainy})
    # Do some output ever OUTPUT epochs
    if i % OUTPUT == 0:
        # Run the model and show the cost
        hp, ct = sess.run([Hypothesis,cost], feed_dict={x_: trainx, y_: trainy})
        print('Epoch ', i)
        print("Cost = ", ct)

# run the model and check to see how many patterns are within the 0.01 tolerance
hp, ct = sess.run([Hypothesis,cost], feed_dict={x_: trainx, y_: trainy})
numCorrect = 0
for i in range(len(hp)):
    if (abs(hp[i][0] - trainy[i][0]) < TOLERANCE) and (abs(hp[i][1] - trainy[i][1]) < TOLERANCE) and (abs(hp[i][2] - trainy[i][2]) < TOLERANCE):
        numCorrect = numCorrect + 1

#print hp[i], '\t', trainy[i]
print("Number of patterns correct = " + str(numCorrect))

t_end = time.clock()
print('Elapsed time is', t_end - t_start)

# Save model weights to disk
save_path = saver.save(sess, MODEL_PATH)
print("Model saved in file: %s" % save_path)