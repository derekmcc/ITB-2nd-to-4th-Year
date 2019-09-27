import bs4 as bs
import urllib.request
import re
import csv
import nltk
import math
from nltk.stem.porter import PorterStemmer
from nltk.corpus import wordnet
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer
import sklearn
from sklearn import cluster
from pandas.plotting import parallel_coordinates
from pandas import DataFrame
from sklearn.cluster import KMeans
from scipy.cluster.hierarchy import dendrogram, linkage
from sklearn.model_selection import train_test_split as tt

import ClasificationAlgorithms as ca

def retriveDataFromUrls(url):
	source = urllib.request.urlopen(url).read()
	soup = bs.BeautifulSoup(source,'lxml')
	return soup

def retriveMainText(soup):
	titles = soup.find_all(re.compile('^h[1-6]$'))
	h1s = [str(h1) for h1 in soup.find_all('h1')]
	h1s = [re.sub(r'</?h1>', '', h1) for h1 in h1s]
	paragraphs = [str(p) for p in soup.find_all('p')]
	mainParagraphs = [p for p in paragraphs if p.startswith('<p>')]
	mainParagraphs = [re.sub(r'<.+?>', '', p) for p in mainParagraphs]
	return ' '.join(mainParagraphs)
	
def writeToCSV(textData):
	# write the data to a csv file
    with open('data.csv', 'w', newline='', encoding='utf-8') as csvFile:
        attributes = ['label', 'doc']
        writer = csv.DictWriter(csvFile, fieldnames=attributes)
        writer.writeheader()
        writer.writerows(textData)
    csvFile.close()

def englisFootballURLs():
	englishFootball = [
        "https://www.skysports.com/football/news/11667/11669109/ole-gunnar-solskjaer-could-rue-manchester-united8217s-fa-cup-exit",
        "https://www.skysports.com/football/news/11679/11669236/pep-guardiola-hopes-his-man-city-players-return-from-international-break-unscathed",
        "https://www.skysports.com/football/news/11667/11668024/ole-gunnar-solskjaer-says-manchester-uniteds-fa-cup-exit-was-poorest-performance-since-he-took-over",
        "https://www.skysports.com/football/news/11667/11669275/manchester-united-had-helicopter-ready-for-gareth-bale-says-david-moyes",
        "https://www.skysports.com/football/news/29328/11668881/eden-hazard-situation-creates-big-conundrum-for-chelsea-says-graeme-souness",
        "https://www.skysports.com/football/news/11095/11669256/football-association-investigating-three-new-incidents-of-supporter-pitch-invasions",
        "https://www.skysports.com/football/news/11095/11668461/maurizio-sarri-baffled-by-strange-shift-in-chelsea-mentality",
        "https://www.skysports.com/football/news/11669/11668747/sadio-mane-has-stepped-up-for-liverpool-in-the-title-run-in",
        "https://www.skysports.com/football/news/11675/11668955/tottenham-chairman-daniel-levy-says-stadium-costs-will-not-affect-transfer-spending",
        "https://www.skysports.com/football/news/11095/11668751/tottenham-to-play-crystal-palace-in-first-game-at-new-stadium",
        "https://www.skysports.com/football/news/11670/11668215/arsenal-an-option-for-antonio-valencia-after-manchester-united-exit-claims-agent",
        "https://www.skysports.com/football/news/11667/11669087/nemanja-matic-urges-manchester-united-not-to-let-top-four-finish-slip-away",
        "https://www.skysports.com/football/wolves-vs-man-utd/406343",
        "https://www.skysports.com/football/news/11699/11668028/nuno-espirito-santo-on-fa-cup-win-over-manchester-united-wolves-boss-pleased-to-give-back-joy",
        "https://www.skysports.com/football/news/11095/11667410/javi-gracia-says-andre-grays-winner-was-no-surprise-and-tips-watford-to-reach-fa-cup-final",
        "https://www.skysports.com/football/news/11685/11667730/manuel-pellegrini-hails-west-ham-character-after-huddersfield-victory",
        "https://www.skysports.com/football/news/11095/11667898/brendan-rodgers-toasts-incredible-leicester-win",
        "https://www.skysports.com/football/burnley-vs-leicester/391059",
        "https://www.skysports.com/football/news/11671/11668455/everton-boss-marco-silva-admits-he-never-doubted-philosophy-after-chelsea-win",
        "https://www.skysports.com/football/news/11678/11668196/peter-beardsley-says-hes-not-a-bully-not-a-racist-amid-fa-investigation",
        "https://www.skysports.com/football/news/11706/11667426/roy-hodgson-unsure-on-wilfried-zaha-return-after-international-break",
        "https://www.skysports.com/football/news/34651/11668343/neil-harris-believes-millwall-were-better-than-brighton-in-fa-cup-loss",
        "https://www.skysports.com/football/news/11700/11665481/yan-valery-signs-southampton-contract-extension-until-2023",
        "https://www.skysports.com/football/news/11708/11667929/harry-maguire-red-card-shocked-burnley-says-sean-dyche",
        "https://www.skysports.com/football/news/11681/11668283/scott-parker-gutted-for-fulham-players-after-liverpool-defeat"
    ]
	
	return englishFootball

def notEnglishFootballURLs():
    notEnglishFootball = [
        "https://news.sky.com/story/brexit-the-seven-options-mps-could-vote-on-and-what-they-mean-11672852",
        "https://news.sky.com/story/theresa-may-set-for-showdown-with-mps-after-hinting-at-third-vote-on-deal-11676551",
        "https://news.sky.com/story/dup-prefer-long-brexit-delay-to-pms-deal-sky-sources-11675614",
        "https://news.sky.com/story/theresa-may-tells-mps-she-cannot-commit-to-alternate-brexit-strategy-11674856",
        "https://news.sky.com/story/pm-fights-to-retain-power-as-mps-look-to-seize-control-of-brexit-11674589",
        "https://news.sky.com/story/may-faces-cabinet-coup-as-ministers-warn-she-has-days-left-11673877",
        "https://news.sky.com/story/theresa-may-could-drop-vote-on-brexit-deal-if-it-lacks-support-11672888",
        "https://news.sky.com/story/us-signals-new-space-race-trump-wants-astronauts-back-on-the-moon-within-five-years-11676176",
        "https://news.sky.com/story/mueller-report-putin-ready-to-improve-us-ties-after-trump-cleared-of-collusion-11674840",
        "https://news.sky.com/story/trump-questions-will-remain-until-full-mueller-report-is-revealed-11674570",
        "https://news.sky.com/story/donald-trumps-golan-policy-change-is-illegal-and-unnacceptable-11672382",
        "https://news.sky.com/story/trump-under-fire-over-bizarre-john-mccain-funeral-comments-11671442",
        "https://news.sky.com/story/donald-trump-attacks-the-husband-of-kellyanne-conway-one-of-his-closest-aides-11670943",
        "https://news.sky.com/story/president-trump-has-vetoed-congress-decision-to-end-his-national-emergency-11666719",
        "https://news.sky.com/story/revealed-what-super-jupiter-129-light-years-from-earth-is-like-11676420",
        "https://news.sky.com/story/anne-mcclain-female-astronaut-at-centre-of-nasa-spacesuit-row-speaks-out-11676621",
        "https://news.sky.com/story/black-hole-radio-jet-pointed-almost-directly-at-earth-11614684",
        "https://news.sky.com/story/far-side-of-the-moon-chinas-lunar-probes-take-pictures-of-each-other-11604801",
        "https://news.sky.com/story/barnards-star-b-frozen-super-earth-found-six-light-years-away-could-support-life-experts-say-11554317",
        "https://news.sky.com/story/nasa-probe-gets-closer-to-the-sun-than-any-spacecraft-in-history-11546524",
        "https://www.skysports.com/football/news/11661/11676254/louis-van-gaal-says-managing-tottenham-might-have-been-better-than-manchester-united",
        "https://www.skysports.com/football/news/11679/11673434/ilkay-gundogans-manchester-city-form-covering-loss-of-fernandinho",
        "https://www.skysports.com/football/news/11667/11675567/victor-lindelof-keen-for-ole-gunnar-solskjaer-to-stay-at-man-utd",
        "https://www.skysports.com/football/news/11667/11674975/ander-herrera-unsure-of-manchester-united-future",
        "https://www.skysports.com/football/news/11667/11674923/juan-mata-hails-retired-louis-van-gaal-and-thanks-him-for-time-at-manchester-united"
    ]
    return notEnglishFootball

def clean_corpus(corpus, to_replace_list, replacement=''):
    for regex in to_replace_list:
        corpus = [re.sub(regex, replacement, doc) for doc in corpus]
    return corpus

def build_bow (tokenized_docs):
    freq_dists = []
    for tokenized_doc in tokenized_docs:
        d = {}
        for token in tokenized_doc:
            if token in d.keys():
                d[token] += 1
            else:
                d[token] = 1
        freq_dists.append(pd.Series(d))
    return pd.DataFrame(freq_dists)

# read in the data from the csv
def readCsvFile():
    data = pd.read_csv('data.csv')
    return data

# tokenize the data
def tokenizeText(data):
    tokenizedDocs = [nltk.word_tokenize(doc) for doc in docs]
    return tokenizedDocs

# tokenize the data
def tagTokenizeText(data):
    taggedCorpus = [nltk.pos_tag(doc) for doc in data]
    return taggedCorpus

def removePOS(taggedCorpus, data):
    new_tagged_corpus = []
    for doc in taggedCorpus:
        new_doc = []
        for pair in doc:
            if pair[1] not in data:
                new_doc.append(pair)
        new_tagged_corpus.append(new_doc)
    return new_tagged_corpus

def countCdPartOfSpeech(newTaggedCorpus):
    cdDistributions = []
    for doc in newTaggedCorpus:
        count = 0 
        for pair in doc: 
            if pair[1] == 'CD':
                count += 1 
        cdDistributions.append(count)
    return cdDistributions

def visualizeCdDistributions(cdDistributions):
    plt.rcdefaults()
    # we named the docs according to their order in the corpus
    docs = ['1', '2', '3', '4', '5', '6','7','8', '9', '10', '11', '12', '13','14','15', '16', '17', '18', '19', '20',
    '21','22', '23', '24', '25', '26', '27','28','29', '30', '31', '32', '33', '34','35','36', '37', '38',
    '39', '40', '41','42','43','44', '45', '46', '47', '48', '49','50'] 
    y_pos = np.arange(len(docs))
    plt.bar(y_pos, cdDistributions, align='center', alpha=0.5)
    plt.xticks(y_pos, docs)
    plt.ylabel('CD count')
    plt.xlabel('Document Number')
    plt.title('Number of times CD appears across documents')
    plt.show()

def buildNewCorpus(newTaggedCorpus):
    newTokenizedCorpus = []
    for doc in newTaggedCorpus:
        newTokenizedCorpus.append([pair[0] for pair in doc])
    #print(newTokenizedCorpus)<<<<<<<<<--------------Add print outs for report
    # apply case transformation:
    newTokenizedCorpus = [ [word.lower() for word in doc]
        for doc in newTokenizedCorpus]
    return newTokenizedCorpus

def removeStopWords(newTokenizedCorpus):
    stopWords = nltk.corpus.stopwords.words('english')
    newTokenizedCorpus = [[word for word in doc if word not in stopWords]
        for doc in newTokenizedCorpus]
    
    # list of custom stop words to be removed
    customStopWords = ['solskjaer', 'premier', 'manchester', 'united', 'league', 'said',
    'first', 'will', 'players', 'chelsea', 'city', 'wolves','team', 'get', 'president',
    'prime', 'deal', 'brexit', 'minister', 'trump', 'mps','house', 'mrs', 'government',
    'vote', 'support']
    newTokenizedCorpus  = [ [ word for word in doc if word not in customStopWords ] 
        for doc in newTokenizedCorpus ]
    return newTokenizedCorpus

def porterStemming(newTokenizedCorpus):
    stemmer = nltk.PorterStemmer()
    stemmedCorpus = [[stemmer.stem(word) for word in doc]
        for doc in newTokenizedCorpus]
    return stemmedCorpus

def plotMeanOfStats(stats):
    means = stats['mean']
    means.plot()
    plt.show()

def findSynonym(data):
    tokens = tokenizeText(data)
    synonyms = []
    for syn in wordnet.synsets(token):
        for lm in syn.lemmas():
            synonyms.append(lm.name())
    return synonyms

def compute_idfs(bow):
    ## n = the number of rows/docs
    N = len(bow.index)
    ## the list of how many docs a terms occurs in
    nis = []
    ## go through each term/column
    for ti in bow.columns:
        ni = 0
        ## go through each row
        for row in range(N):
            ## check that the entry for that term in the given rowis > 0
            ## which means it occurs in a doc
            if bow[ti].iloc[row] > 0:
                ## if it occurs, simply increase the ni by 1
                ni += 1
        ## append the ni to the nis list        
        nis.append(ni)
    ## compute the logs using the nis list and N
    return [math.log2(N/ni) for ni in nis]

def build_tfidf_bow (bow, idfs):
    ##go through each column and each idf
    for i in range( len(idfs)):
        idf = idfs[i]
        column = bow.columns[i]
        ## go through each value in the row
        for row in bow.index:
            ## replace each value with the tf-idf weight
            bow[column].iloc[row] = bow[column].iloc[row]  * idf
    return bow

def build_tf_bow (bow, total_counts):
    ##go through each row and total
    for i in range( len(total_counts)):
        total = total_counts[i]
        row = bow.iloc[i]
        ## go through each value in the row
        for col in row.index:
            ## replace each value with the tf weight
            row[col] = row[col] / total

def kMeansClustering(data):
    A = data.copy()
 
    for k in range (1, 11):
     
        # Create a kmeans model on our data, using k clusters.  random_state helps ensure that the algorithm returns the same results each time.
        kmeans_model = KMeans(n_clusters=k, random_state=1).fit(A.iloc[:, :])
        
        # These are our fitted labels for clusters -- the first cluster has label 0, and the second has label 1.
        labels = kmeans_model.labels_
     
        # Sum of distances of samples to their closest cluster center
        interia = kmeans_model.inertia_
        print("k:",k, " cost:", interia)
    print("")

def display_dendrogram(df, method='single'):
    Z = linkage(df, method)
    plt.figure(figsize=(25, 10))
    plt.title('Hierarchical Clustering Dendrogram')
    plt.xlabel('Documents/Observations')
    plt.ylabel('Distance')
    dendrogram(Z, labels=df.index, leaf_rotation=90)
    plt.show()

def clustering_agglomerative(data):
    model = cluster.AgglomerativeClustering(
        affinity='cosine',linkage='single')
    model.fit(data)
    cluster_labels = model.labels_ + 1
    return cluster_labels

def clustering_k_means(data, k=2):
    model = cluster.KMeans(k)
    model.fit(data)
    clust_labels = model.predict(data)
    centers = model.cluster_centers_
    return (clust_labels, centers)

def display_k_centers(df, cluster_centers, cluster_labels):
    centers_df = pd.DataFrame(cluster_centers,
                    index=['Means1', 'Means2'],
                    columns=list(df.columns))
    centers_df['cluster'] = [1, 2]
    print(centers_df)
    plt.figure(figsize=(7, 5))
    plt.title('Clusters 1 and 2 means along 5 terms')
    parallel_coordinates(centers_df, 'cluster',
                         color=['blue', 'red'], marker='o')
    plt.show()

englishFootball = englisFootballURLs()
notEnglishFootball = notEnglishFootballURLs()

# get the data/soups
englishFootballsoups = [retriveDataFromUrls(url) for url in englishFootball]
notEnglishFootballsoups = [retriveDataFromUrls(url) for url in notEnglishFootball]

# retrieve main paragraphs'texts for both types of docs
englishFootballDocs = [retriveMainText(soup) for soup in englishFootballsoups]
notEnglishFootballDocs = [retriveMainText(soup) for soup in notEnglishFootballsoups]

# put the data into a list of dictionaries
data = [{'label':'englishFootball','doc': doc} for doc in englishFootballDocs] +  [{'label':'notEnglishFootballDocs','doc': doc} for doc in notEnglishFootballDocs]
writeToCSV(data)

# get the data from file
data = readCsvFile()

dataCopy = data['doc'].copy()
# get the labels from the file
labels = data['label'].copy()

# fill in empty values
docs = [row for row in dataCopy.fillna("")]
# replace ISO-8859-1 encodings, references, quotes, and multiple white spaces with a single space
docs = clean_corpus(docs, [r'\x09', r'\xa0', r'\x96', r'\[\d+\]', r'[\'"]+', r'\s{2,}'], ' ')
# remove space before a comma
docs = clean_corpus(docs,[r'\s+,'],',')
# replace actual digits with the word DIGITS
docs = [re.sub(r'\d+', " DIGITS ", row) for row in dataCopy]
# replace punctuation with a space
docs = [re.sub(r'[\'\.\?!,;:\\/å£*"]+', " ", row) for row in dataCopy]
# replace repeating white spaces with a single space
docs = [re.sub(r'\s{2,}', " ", row) for row in dataCopy]
# tokenize the data
tokens = tokenizeText(docs)

# keep only tokens longer than 3 chars
tokens = [[token for token in doc if len(token)>3] for doc in tokens]

# attach a POS tag to the token
taggedTokens = tagTokenizeText(tokens)

# POS tags to be removed
posToRemove = ['DT', 'MD', 'CC', 'IN', 'TO', 'PRP', 'PRP$', ',', '.', ')', '(', ':', '']
# corpus with tags we want to retain
newTaggedCorpus = removePOS(taggedTokens, posToRemove)

# count the CD part of speech for each document and place it into a list
cdDistributions = countCdPartOfSpeech(newTaggedCorpus)

# show bar chart of the CD distributions throughout the 50 documents
visualizeCdDistributions(cdDistributions)

# build the bag of words
baselineBow = build_bow(tokens)

# replace NaN values with 0 in the bag of words
refinedBow = baselineBow.fillna(0)

# build a new corpus of docs (tokenized) by extracted from the
# tagged one only the first element of each tuple in each document, that is, each token
newTokenizedCorpus = buildNewCorpus(newTaggedCorpus)

# remove stop words
stopWordsRemoved = removeStopWords(newTokenizedCorpus)

# new bag of words after removingStopWords
stopWordsRemovedBow = build_bow(stopWordsRemoved)
stopWordsRemovedBow = stopWordsRemovedBow.fillna(0)
print("Stop Words Bow")
print(stopWordsRemovedBow)

# apply Porter stemming, then build a new bow
stemmed = porterStemming(stopWordsRemoved)
stemmedBow = build_bow(stemmed)
stemmedBow = stemmedBow.fillna(0)
print("Stemmed Bow")
print(stemmedBow)

# get the stats of the BOW
stats = stemmedBow.describe()
# transpose stats for better view
stats = stats.T
# plot the mean of the stats
plotMeanOfStats(stats)
print(stats)

# --------------- Word vectors --------------------------

# copy BOW
normalizedBow = stemmedBow.copy()
totalCounts = [len(doc) for doc in docs]

# simple counts 
simpleCountBow = stemmedBow.copy()
print(simpleCountBow)

# apply tf weigthing to the BOW
build_tf_bow(normalizedBow, totalCounts)
print(normalizedBow)

# copy BOW
copyBow = stemmedBow.copy()

# compute the idfs for the docs in the collection
idfs = compute_idfs(copyBow)
print(idfs)

tfidfBow = build_tfidf_bow(copyBow, idfs)
print(tfidfBow)

# ---------------END WORD VECTORS -----------------------

# ----------------Clustering Algorithms -----------------

# k means clustering - Method 1
kMeansClustering(tfidfBow)

# k means clustering - Method 2
df = pd.DataFrame(tfidfBow)

cluster_labels, cluster_centers = clustering_k_means(df)
print(cluster_labels, cluster_centers)

df['cluster'] = list(cluster_labels)
print(df)
print("Cluster Distance Ratio: ",sklearn.metrics.davies_bouldin_score(df, cluster_labels))

collection = tfidfBow.copy()
df = pd.DataFrame(collection)
cluster_labels = clustering_agglomerative(df)
print(cluster_labels)
display_dendrogram(df)


# ---------------- End Clustering Algorithms ------------

# ----------------Clasification Algorithms --------------
# SVM Algorithm
# classify with simple counts
print("With Simple Counts")
ca.classificationVectorisedOperationSVM(labels, simpleCountBow)
print()
# classify with normalized counts
print("With Normalized Counts")
ca.classificationVectorisedOperationSVM(labels, normalizedBow)
print()
# classify with tfidf
print("With TFIDF")
ca.classificationVectorisedOperationSVM(labels, tfidfBow)

print("With Simple Counts")
ca.classificationVectorisedOperationNaiveBayes(labels, simpleCountBow)
print()
# classify with normalized counts
print("With Normalized Counts")
ca.classificationVectorisedOperationNaiveBayes(labels, normalizedBow)
print()
# classify with tfidf
print("With TFIDF")
ca.classificationVectorisedOperationNaiveBayes(labels, tfidfBow)

# ----------------End Clasification Algorithms ----------

#print(refinedBow)
#print(sorted(list(stemmedBow.columns)))
#print(stats)
#print(tfidfBow)




