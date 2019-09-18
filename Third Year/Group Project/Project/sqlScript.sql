################################################# STEP 1 ##########################################################
drop table users;
drop table singles;
drop table albums;
drop table artists;
drop table charts;

################################################# STEP 2 ##########################################################

CREATE TABLE users (
    userId int NOT NULL AUTO_INCREMENT,
    firstName varchar(50),
    lastName varchar(50),
    userName varchar(50),
    userRole int NOT NULL,
    userImage text(255),
    userEmail varchar(90),
    userPassword text(255),
    PRIMARY KEY(userId)
);

CREATE TABLE artists (
    artistID int NOT NULL AUTO_INCREMENT,
    artistName varchar(70) NOT NULL,
    artistImage text(255) NOT NULL,
    artistBio text(255) NOT NULL,
    artistLabel varchar(70) NOT NULL,
    artistCat varchar(70) NOT NULL,
    PRIMARY KEY(artistID)
);

CREATE TABLE albums (
    albumID int NOT NULL AUTO_INCREMENT,
    albumName varchar(70) NOT NULL,
    albumImage text(255) NOT NULL,
    albumRelease varchar(70) NOT NULL,
    albumVideo text(255) NOT NULL,
    albumPrice float NOT NULL,
    artistID int NOT NULL, 
    albumCat varchar(70) NOT NULL,
    PRIMARY KEY(albumID),
    CONSTRAINT albums_artistID_FK FOREIGN KEY (artistID) REFERENCES artists(artistID)
);

CREATE TABLE singles (
	songID int NOT NULL AUTO_INCREMENT,
    songTrackNo int,
    songName varchar(70) NOT NULL,
    songWriter text(255),
    songLength varchar (70),
    songImage text(255),
    songPrice float NOT NULL,
    songCat varchar (70) NOT NULL,
    artistID int,
    albumID int, 
    PRIMARY KEY(songID),
    CONSTRAINT songs_artistID_FK FOREIGN KEY (artistID) REFERENCES artists(artistID),
    CONSTRAINT songs_albumID_FK FOREIGN KEY (albumID) REFERENCES albums(albumID)
);

create table charts (
	chartID int NOT NULL AUTO_INCREMENT,
    chartAlbum varchar(70) NOT NULL,
    chartArtist varchar(70) NOT NULL,
    chartWeeks int NOT NULL,
    PRIMARY KEY(chartID)
);

insert into artists (artistName, artistImage, artistBio, artistLabel, artistCat) VALUES
('Fozzy', 'images/artists/fozzyprofile.png',"
<p>FOZZY has always been about a heavy groove and a good time. And when you have two high-energy performers like Rich Ward and Chris Jericho
(it’s debatable on who jumps higher onstage) in the band, grooves and good times come easy; but these guys aren’t just entertainers. Ward is one of the 
most versatile and underrated riffers in rock and metal today, who has created his own style of heavy riffs, melodic choruses and the Duke groove...oh 
that crushing groove! And Jericho's singing ability and overall passion for music makes one wonder just how he is able to find the time to excel in pretty 
much everything he does. It was these qualities that pushed the band to become one of the hottest up and coming rock acts of the past five years.<br><br>
After the release of 4 studio albums, each more successful and critically acclaimed than the last, it wasn’t until 2012’s 'Sin & Bones' that the band started 
to hit their stride. Jericho was winding down his involvement with the WWE, the band was touring more, with their live show reputation growing stronger than 
ever. The entertainment, the fun factor, the showmanship and most importantly, THE SONGS, were all there in full force. After touring all of 2012-13 with 
Metallica, Shinedown, Avenged Sevenfold and Saxon, the band saw their fanbase grow and diversify.<br><br>
After their hugest charting (#54 on the Billboard 200) and most successful record, 2014's 'Do You Wanna Start A War' and subsequent tour finished at the end 
of 2015, the band began focusing on taking their future to a new level creatively and enlisted critically acclaimed song writer Johnny Andrews to produce 
the new record. With Andrews, Ward and Jericho (the team who created FOZZY's highest charting single 'Lights Go Out') at the helm, FOZZY spent 2016 crafting 
their new masterpiece for a spring 2017 release.<br><br>
'After the huge success of the Do You Wanna Start A War record and the tour that followed that saw us share the stage w such incredible bands as Kiss, 
Slash & Myles Kennedy, BuckCherry and Theory Of A Deadman, we decided to take 2016 off to recharge and write songs. But now WE'RE BACK with our best 
album EEEVVVEEERRR and are so excited to destroy stages all across the globe again! There is nothing like playing FOZZY rock n roll to our amazing 
friends worldwide and watching you guys smile, laugh and have a blast...after all, isn't that what rock n roll is all about? We believe that there's 
only three things you can count on in life: death, taxes and the fact that if you come to a FOZZY show, you are GOING to have a great time!! That's the 
FOZZY money back guarantee...'- Chris Jericho.</p>
<h3>MEMBERS</h3>
<p>Chris Jericho (<i>Vocals</i>)<br>
Rich Ward (<i>Guitar, Vocals</i>)<br>
Billy Grey (<i>Guitar</i>)<br>
Paul DiLeo (<i>Bass</i>)<br>
Frank Fontsere (<i>Drums</i>)</p>",'Megaforce','Heavy Metal'),
('Jamie Cullum','images/artists/jamiecullumprofile.png',"
<p>With a Grammy, two Golden Globe, two GQ Man of the Year, three Brit, three Sony Radio and numerous other nominations and awards under his belt, 
Jamie Cullum is a success story around the planet. The most successful UK jazz artist ever, having sold over 10 million albums worldwide.<br><br>

It's through jazz that Jamie first made his mark, with the multi platinum Twentysomething LP, but it is his knowledge and love of all music that has helped 
propel him onto the world stage.<br><br>

The sensational musician has the ability and versatility to blur musical genres with his unique take on jazz, pop and rock and his success is truly global, 
taking him from Seoul to Sao Paulo, FujiRock to Glastonbury and from Hamburg to Hollywood where he achieved great acclaim collaborating with Clint Eastwood 
on the Golden Globe nominated score for Gran Torino. Jamie has not just written for the London West End Stage but also for BBC Television and has presented 
TV shows on VH-1, Sky and the BBC. He has hosted several documentaries for BBC Radio’s 4 and 2 featuring such eminent subjects as Blue Note Records, Herbie 
Hancock, Jimi Hendrix and Quincy Jones. He currently presents his own award winning weekly prime time show for BBC Radio 2, the highest rated station in 
Europe and is proud to have been the first DJ to play the new stars of jazz, Gregory Porter and Laura Mvula. Jamie’s radio show has won two New York Radio 
Awards and the prestigious Gold Sony Radio Award in the UK and is now licensed to stations across the dial.<br><br>

Alongside his songwriting ability, flair as a performer, and natural aptitude as a broadcaster, Jamie has taken his long term love of photography a step 
further by teaming up with Leica cameras to produce all the shots for Interlude’s deluxe artwork which can be been on display at Leica’s galleries in 
Germany and London as well as in the booklet for the album itself. The musician has also turned magazine publisher. Inspired by Dave Eggars’ 
Timothy McSweeney’s Quarterley Concern, Jamie created The 88, ‘an occasional magazine for the adventurous thinker’ the heavyweight journal is a 
collection of words and pictures curated by Jamie, featuring contributions from his friends.</p>",'Deckdisc','Jazz'),
('Iron Maiden', 'images/artists/ironmaidenprofile.png',"
<p>Iron Maiden are an institution. Over the course of nearly 40 years they have come to embody a spirit of fearless creative independence, ferocious dedication to their fans, and a cheerful indifference to their critics that’s won them a following that spans every culture, generation, and time-zone. A story of gritty determination and courageous defiance of the naysayers, theirs has been an adventure like no other, and with the rapturous receipt of their 16th studio album they’re showing no signs of slowing down. Their 16th, and most recent studio album, neatly encapsulates Iron Maiden’s huge creative range, The Book Of Souls is nothing less than a 92-minute masterpiece - a cannon-blast of exuberant, anthemic bravado that serves as cast-iron confirmation of just how much they have left in the tank. From the infectious, stadium-skewering hooks of The Red And The Black to the lofty ambition of the 18-minute Empire Of The Clouds, it’s the artistic summation of everything that’s given Iron Maiden such deep resonance and universal appeal. Like the breathless excitement and scale of their stage shows, their remarkable new double-album is emblematic of a stout-hearted refusal to do anything by half-measures and an irrepressible sense of fun.<br><br>

Founded by bassist Steve Harris in the mid ‘70s, Iron Maiden were already firmly established as heavy metal’s brightest hopes when they stormed the world with their third album (and first with vocalist Bruce Dickinson) The Number Of The Beast in 1982. It would kick off a decade of classic releases and dogged touring that would come to epitomise the unrelenting, uncompromising, unswerving commitment they are now so well known for. That marvellous decade would also yield seven new studio albums, one live album, seven World Tours, as well as the creation of Eddie - one of the most iconic and recognisable figureheads of our age and the calling card of the most impassioned fan-bases anywhere.</p>
<h3>MEMBERS</h3>
<p>Bruce Dickinson(<i>Vocals, Piano</i>)<br>
Dave Murray (<i>Guitar</i>)<br>
Janick Gears (<i>Guitar</i>)<br>
Adrian Smith (<i>Guitar, Backing Vocals</i>)<br>
Steve Harris (<i>Bass, Backing Vocals</i>)<br>
Nicko McBrain (<i>Drums</i>)</p>",'EMI','Heavy Metal'),
('Drake Bell', 'images/artists/drakebellprofile.png',"
<p>Though he had been acting since he was five, when he was filmed in his first commercial, Drake Bell (born Jared Drake Bell in Orange County, California) 
didn’t start playing the guitar until he was cast in the 2001 TV movie Chasing Destiny, also starring the Who’s Roger Daltrey, who gave the young performer 
his initial lessons. As a teenager, though Bell was focusing on acting, he continued to play music and write songs on the side, and after a program he was in, 
Nickelodeon’s The Amanda Show, was canceled in 2002, and a spinoff, The Drake and Josh Show, was started (it first aired in 2004), Bell was able to finally 
show off his chops onscreen, writing the theme song, “Found a Way,” and playing an exaggerated version of his guitarist self named Drake Parker.<br><br>

Heavily influenced by the Beatles and the Beach Boys, Bell released his debut, Telegraph, independently in 2005; soon after he signed to Universal, 
who put out his sophomore record, It’s Only Time, the following year. The live album, Drake Bell in Concert, appeared in 2008 and it wouldn’t be until 
2011 that Bell would release any new material, with the stopgap EP A Reminder.<br><br>

Returning to the studio some two years later with childhood hero Brian Setzer, Bell released his third album, the rockabilly-inspired Ready Steady Go! on 
Surfdog Records in 2014. With music being his first love, Drake made the most rockin’ and exciting album of his career.  Wait ’til you hear this collection 
of melodic pop, and at the same time hard-hitting rock n roll.  Drake’s millions of fans around the world have been very happy with what they have heard.</p>",'Motown', 'Pop'),
('P!nk', 'images/artists/pink.png',"
<p>Since her debut in 2000, P!nk has released 7 albums, sold over 40 million albums, 65 million singles, over 1 million DVDs worldwide and has had 14 
singles in the top 10 on the Billboard Hot 100 Chart (4 at #1).</p>

<p>In addition, 15 of P!nk’s singles have reached #1 in at least 1 or more countries. She is the recipient of 3 Grammy Awards, 3 Billboard Music Awards, 
6 MTV Video Music Awards, 2 MTV Europe Awards, 2 People’s Choice Awards, and many more. P!nk’s most recent effort, The Truth About Love debuted at #1 
on the Billboard Top 200 as well as in 6 other countries. The album marks P!nk’s first #1 debut in the US and a personal first week sales best. The 
album is certified platinum in the US and was nominated for a 2013 Grammy for Best Pop Vocal Album. The Truth About Love produced the smash singles 
“Blow Me (One Last Kiss)”, “Try” and “Just Give Me A Reason” ft. Nate Reuss which marks P!nk’s 12th, 13th and 14th Top 10 hit on the Billboard Hot 100. 
“Just Give Me A Reason” has sold over 4.5 million singles, makes P!nk’s fourth #1 on the Billboard Hot 100 and was nominated for 2 2014 Grammy Awards 
for the coveted Song of The Year category and Best Pop Duo/Group. P!nk recently wrapped her The Truth About Love World tour after playing 140 shows 
in 13 countries. In December 2013, P!nk received the honor of being named Billboard’s Woman of the Year.</p>
<p>
She is currently a spokesperson for COVERGIRL, made her acting debut in Lionsgate’s Thanks For Sharing alongside Gwyneth paltrow and Mark Ruffalo 
and is a huge supporter of various charities including Ronald McDonald’s House, Make A Wish Foundation, PETA, Autism Speaks, Human Rights Campaign, 
and Save the Children.</p>",'Jive','Pop'),
('Demi Lovato', 'images/artists/demi.png',"
<p>
DEMI LOVATO IS A GRAMMY NOMINATED AND MULTI-PLATINUM SINGER, SONGWRITER, ACTRESS, ADVOCATE, PHILANTHROPIST, AND BUSINESS WOMAN.
In addition, she’s one of the biggest names on social media, with an engaged combined following of over 145 million.</p>
<p>
Demi's highly-anticipated fifth studio album, CONFIDENT, was released in 2015. Within hours of the release of the first single, 
'Cool for the Summer', the anthem trended worldwide and hit #1 on iTunes in 37 countries. Her previous album, 2013's DEMI, hit #1 
on iTunes in over 50 countries around the world - with the lead single 'Heart Attack' earning Platinum status just ten weeks after 
its release. 'Heart Attack' was followed by the top 5 radio smash and platinum single 'Neon Lights,' and her top 10 single 'Really 
Don't Care.' The album supported two headlining tours (NEON LIGHTS and DEMI WORLD TOUR) which made stops throughout North America, 
Europe, Asia, Australia and New Zealand.</p>
<p>
In April 2017, Demi played the voice of Smurfette in the Sony animated film, 'Smurfs: The Lost Village.' Additionally, beyond 
the stage and the screen, in 2013, her book Staying Strong: 365 Days a Year, became a New York Times best-seller, and in 2014 she 
became a global ambassador for Sketchers. In 2015, Lovato partnered with Episode, a leading mobile storytelling network, to make 
Demi Lovato: Path to Fame. Since launching, her story has been read over 225 million times. In 2016, Demi took on a new venture 
and was announced as the first-ever collaboration with Fabletics, the innovative active wear brand co-founded by Kate Hudson.</p>
<p>
As a result of her long-time commitment to raising awareness around LGBT issues and causes, in 2016, Demi became the recipient of 
GLAAD's Vanguard award. She continues to be a global advocate for Mental Health, and in 2017 was honored by Semel Institute for 
Neuroscience and Human Behavior at UCLA, with the Artistic Award for Courage for her work in mental health. In addition, also in 
2017, she was named by Global Citizen as the organization's official ambassador for mental health, with a special focus on vulnerable 
communities around the world.</p>
<p>
In July 2017, she released the first single off her upcoming album Tell Me You Love Me, which instantly flew into the Top 5 on 
the iTunes Charts. 'Sorry Not Sorry', which has garnered over 195 million streams and climbed to #1 on the viral charts. Demi's sixth 
studio album will be available globally September 29.</p>",'Island Records', 'Pop'),
('Drake', 'images/artists/drake.png',"
<p>
Aubrey 'Drake' Graham is a Grammy-Award winning, platinum-selling recording artist and multi-faceted entertainer.</p>
<p>
Born in Toronto on October 24th, 1986, Drake is the son of Sandi and Dennis Graham, a drummer who worked with Jerry 
Lee Lewis. His father is African American, a native of Memphis, Tennessee and his mother is Jewish Canadian. Drake’s 
interest in performing began at an early age. From summers spent with his dad in Memphis, he gained an appreciation and 
understanding for music that would later influence the sound he would create in years to come.</p>
<p>
Since first being recognized for his role on the highly-successful television series Degrassi: The Next Generation, and 
going on the road with rap star Lil Wayne after hearing Drake’s music in the summer of 2008, Drake has asserted himself 
as a trailblazer in the creative world. Drake released his mixtape So Far Gone in 2009 and his massive influence in the 
hip-hop and contemporary music space has commanded the market since, with no end in sight. Drake now holds the record for 
the most number one hits on Billboard’s R&B/Hip-Hop Chart.</p>
<p>
As The New York Times Jon Caramanica writes, “So it’s gone with Drake, hip-hop’s current center of gravity, his success a 
reminder of so many of the victories hip-hop has won in the last couple of decades: the right to be decadent, sure, but 
also the right to reimagine any style of music, the right to be emotionally complicated, the right to be unusual. He confounds 
expectations. He raps about soft things, sings about hard things. Thanks to his versatility, he is the glue that binds 
together all of urban radio.”</p>
<p>
Drake has catapulted into stardom not only as an artist, but as a cultural maven with October’s Very Own. Sharing the story 
of the thriving music scene in Toronto, Drake has built out OVO from a small-scale blog about his crew to an all-encompassing 
lifestyle brand, including his clothing company, his record label OVOSOUND and his annual OVOFEST.</p>
<p>
Drake has reached great heights in recent years and he continues to create and dominate the global market. As Drake says, 
'It’s about the experience. If the city isn’t talking about it five, six, seven days later, or if people don’t remember it 
for years to come, then I haven’t done my job…I’m going to find out what comes after this, but there’s definitely another 
evolution of Drake.'</p>",'Jive','Rap'),
('2 Chainz', 'images/artists/2Chainz.png',"<p>
Tauheed Epps (born September 10, 1976), better known by his stage name 2 Chainz, formerly known as Tity Boi 
or Wain Beezy, is an American rapper from College Park, Georgia. He was previously signed to Ludacris' record 
label Disturbing tha Peace with Dolla Boy as Playaz Circle. He is currently signed to Def Jam.</p>",'Def Jam','Rap'),
('Khalid', 'images/artists/khalid.png',"<p>
Khalid Amhearst Robinson, who is widely popular among music lovers as Khalid, is an American singer-songwriter, 
born in 1998. He works in two main styles such as pop and R&B. The young singer became most popular with his first 
released single ‘Location’ that became a super hit in the American ‘Billboard chart’ in 2016. It was sold so many 
times that finally got a platinum certificate which is a great achievement for any rising star. By 2017 Khalid has 
released six more singles and a studio album ‘American Teen’. He also did a number of collaborations with Calvin 
Harris and other popular musicians.</p> ",'Columbia Records', 'Rap'),
('Chris Brown', 'images/artists/cb.png',"
<p>
Christopher “Chris” Brown is a talented R&B entertainer who gave the music world hits like ‘Run It!’, ‘Kiss Kiss’ and 
‘Forever’. The versatile performer is not just a singer cum dancer; he is also an actor who has made appearances in 
several films. The singer with a silky smooth voice cites Michael Jackson as his biggest inspiration. A music lover from a 
young age, he is basically a self-taught entertainer who listened to soul music for years before moving on to hip-hop. 
With the encouragement of his mother he sang in his church choir and participated in several local talent shows. Recognizing his 
talents, his mother began looking for a record deal ultimately getting the young teenager to sign with Jive Records. His self-titled 
debut album ‘Chris Brown’ was released in 2005 which became a huge commercial success and sold three million copies worldwide. 
He followed up the success of his album with ‘The Up Close and Personal Tour’ giving more than 30 performances all over the country. 
The popularity of the teen sensation led to offers of television and film roles, and he made his foray into movies with ‘Stomp the Yard’. 
The musician turned actor has won numerous awards including a Grammy and American Music Awards.</p> ",'Jive','R&B'),
('Ed Sheeran', 'images/artists/ed.png',"
<p>
Inspired by an interview with James Morrison in which the pop crooner claimed to have played 200 gigs in a year, 
budding singer-songwriter Ed Sheeran went on a frantic mission to beat Morrison's record. Cutting his teeth in front of 
just handfuls of people, he finished 2009 having played 312 shows. His next adventure led him to Los Angeles where he was 
spotted at an open mic night by Hollywood actor Jamie Foxx who invited him to stay at his house and record. A series of 
self-released tracks led to a keen online following, before Sheeran's EP 'No. 5 Collaborations Project', released in 2011 
with tracks featuring rappers Wiley, Sway and Ghetts, shot to number two on the iTunes Chart. His single 'The A Team' became 
an even bigger hit, reaching number three in the UK and winning him the Ivor Novello Award for Best Song Musically and Lyrically, 
paving the way for debut album '+' ('plus') which headed straight to number one.</p>
<p>
Sheeran was quickly making his name and presence known in the industry, with big names seeking him out for collaborations. 
In 2012, after receiving a co-writing request from Taylor Swift, the two penned 'Everything Has Changed' which appears on 
Swift's album 'Red'. After opening for Taylor Swift on tour, Sheeran went on to sell-out three headline shows at New York's 
Madison Square Garden. His second album 'x' ('multiply') went to number one in the UK and the US and he went out on a world tour. 
'Thinking Out Loud' was the third single released from 'x' and became his second number one . With an Ivor Novello Award for 
Songwriter of the Year, two Grammys for Song of the Year and Best Pop Solo Performance, both for 'Thinking Out Loud', Sheeran 
decided to take a break from the business and went off the grid for a year.</p>
<p>
In 2017 Sheeran announced the release of his third album '÷' ('divide'). The album went straight to number one in the UK and 
became the fastest-selling album by a male solo artist in the UK. He released two singles from the album: 'Shape of You' and 
'Castle On the Hill'. The singles entered the UK Singles Chart at number one and two respectively, making history as the first 
artist to ever achieve the top two positions at the same time. He then released 'How Would You Feel (Paean)' as a promotional 
single and it charted at number two. 'Galway Girl' was then released as the third official single and this also went to number two. 
These releases, on top of the fact that streaming tracks are counted in the singles charts, meant that Sheeran celebrated holding 
nine of the top ten songs in the UK Singles Chart in one week, with all 16 songs from the album also entering the top 20.</p>",'Atlantic Records', 'Pop'),
('Gucci Mane', 'images/artists/gm.png',"
<p>
As one of the biggest talents of the mid-2000s hip-hop scene, Gucci Mane's woozy, syrupy style helped popularise 'trap' music 
and led a resurgence in Southern rap; but the Atlanta star had a tormented history of drugs, violence, mental health problems 
and also spent time in prison. Born Radric Davis, he grew up in East Atlanta and after discovering a natural talent for poetry, 
he began rapping at the age of 14. Cutting his teeth on the local underground scene, his collaborative track Icy with Young Jeezy 
brought him to wider attention in 2005 and his debut album Trap House captured his trademark mix of gangsta grit, dance floor 
synths and slowed-down, psychedelic beats. Just as things seemed to be taking off, a vicious dispute with Jeezy led to the shooting 
of a man who had broken into his house. Although a murder charge was eventually dropped, his lifestyle was embedded in a culture 
that involved heavy amounts of drink and drugs. Despite paranoia, chaos and regular stints in jail, his prolific work rate saw him 
release the acclaimed US top ten albums The State Vs Radric Davis and The Appeal: Georgia's Most Wanted. Things did come to a head 
though in 2013 when, while serving a three-year sentence, he finally gave up drink and drugs and took to improving his education. 
He even managed to release around 30 mix tapes while incarcerated and promoted young stars such as Waka Flocka Flame and Young Thug. 
Upon his release in 2016, his album Everybody Looking reached number two in the US charts and sparked the most successful period of 
his career.</p> ",'Jive', 'Rap'),
('Imagine Dragons', 'images/artists/imagineDragons.png',"
<p>
Cutting their teeth in dingy little casinos on the edge of Las Vegas' famous strip, Imagine Dragons have gone on to follow in the 
footsteps of the likes of The Killers and Maroon 5 and take their brand of soaring, earnest, indie pop into the mainstream charts. 
Led by front man Dan Reynolds, the band's reputation grew on college radio through a series of self-released EPs before their 
breakthrough single 'It's Time' was used on the TV show 'Glee' and shot to number 15 in the US Charts. Their debut album 'Night Visions', 
released in 2012, went on to reach number two in the US and UK and win praise for its emotional, anthemic melodies and stadium rock 
ambition, while hit single 'Radioactive' sold over five million copies and reached number three in the US Charts on the back of huge radio play.</p>
<p>
One of the most downloaded acts of 2013, the four-piece went on to support Muse and headline their own sold-out tour across America. 
During their final concert of the tour, they announced that they were taking a break to work on their second album. Towards the end 
of 2014 they revealed the title of the album as 'Smoke + Mirrors' and it was officially released in early 2015. As well as several 
singles from the album - 'I Bet My Life', 'Gold', 'Shots' and 'Dream' - the band also released two non-album singles onto iTunes - 
'Roots' and 'I Was Me'. After touring to promote the album, and recording songs for the films 'Suicide Squad' ('Sucker for Pain') 
and 'Passengers' ('Levitate'), the band decided to take another short break before their hugely anticipated third album would be released.</p>
<p>
In early 2017 Imagine Dragons released 'Believer', the first single from their third album. 'Thunder' came next with the announcement 
of the album title 'Evolve'. Later in 2017 the band embarked on a US tour.</p> 
<!-- ************* -->
<h3>MEMBERS</h3>
<p>Dan Reynolds (<i>Vocals</i>)<br>
Wayne Sermon  (<i>Guitar, Drums</i>)<br>
Ben McKee  (<i>Bass, Drums</i>)<br>
Daniel Platzman (<i>Drums</i>)</p>",'Interscope','Rock'),
('Kendrick Lamar', 'images/artists/kl.png',"
<p>
Raised in Compton, Los Angeles, Kendrick Lamar took inspiration from the legendary gangsta rap stars who originated from his 
tough neighbourhood, such as Ice Cube, Tupac Shakur and Eazy-E, and crafted a style that talked about the harsh realities of 
his upbringing with an honest lack of machismo. Originally calling himself K-Dot, he was made to freestyle for two hours at 
his audition for Top Dawg Entertainment because label bosses couldn't believe that a 16-year-old could come up with such talented 
rhymes. Eventually they believed and signed him up, and his reputation grew with mixtapes Training Day (2005), C4 (2009) and Overly 
Dedicated (2010), before a video of him taking on Charles Hamilton in an impromptu freestyle rap battle set the hip hop community 
on alert. He featured on tracks by Game and formed the collective Black Hippy with Jay Rock, Ab-Soul and Schoolboy Q, before debut 
album Section.80 (2011) took on themes of racism, politics and gang crime. Produced by Dr Dre, follow-up Good Kid, M.A.A.D. City (2012) 
proved his big commercial breakthrough, reaching Number 2 in the US charts and producing the Top 20 single Swimming Pools (Drank). 
Marked as one of rap's biggest young talents, Kendrick has also worked with Dido, ASAP Rocky, LL Cool J and 50 Cent.</p> ",'Interscope', 'Rap');

insert into albums (albumName, albumImage, albumRelease, albumVideo, albumPrice, artistID, albumCat) VALUES
('Judas', 'images/albums/fozzyjudas.png','13/10/2017', 'https://www.youtube.com/embed/lqURPBtGJzg', 9.99, 1,'Heavy Metal'),
('Do You Wanna Start a War', 'images/albums/fozzywar.png', '21/07/2014', 'https://www.youtube.com/embed/mbrqAFxb4pE', 9.99, 1,'Heavy Metal'),
('Sin and Bones', 'images/albums/fozzysin.png', '13/08/2012', 'https://www.youtube.com/embed/fEbXnhgYYYs', 9.99, 1,'Heavy Metal'),
('Chasing the Grail', 'images/albums/fozzygrail.png', '26/01/2010', 'https://www.youtube.com/embed/D3aVN_gyhok', 9.99, 1,'Heavy Metal'),
('All That Remains', 'images/albums/fozzyremains.png', '18/01/2005', 'https://www.youtube.com/embed/L9h16JTxOUU', 9.99, 1,'Heavy Metal'),
('Happenstance', 'images/albums/fozzyhappenstance.png', '30/07/2002', 'https://www.youtube.com/embed/sExcknaQj-Q', 9.99, 1,'Heavy Metal'),
('Fozzy', 'images/albums/fozzyalbum.png', '24/10/2000', 'https://www.youtube.com/embed/Xv_3xEH-axs', 9.99, 1,'Heavy Metal'),
('Interlude', 'images/albums/interlude.png', '06/10/2014', 'https://www.youtube.com/embed/y76kW4vMWk4', 9.99, 2,'Jazz'),
('Momentum', 'images/albums/momentum.png', '20/05/2013', 'https://www.youtube.com/embed/_Z5F9BYacfs', 9.99, 2,'Jazz'),
('The Pursuit', 'images/albums/pursuit.png', '10/11/2009', 'https://www.youtube.com/embed/L-XJylC3zs8', 9.99, 2,'Jazz'),
('Catching Tales', 'images/albums/catchingtales.png', '26/09/2005', 'https://www.youtube.com/embed/m0xk-UZcfrg', 9.99, 2,'Jazz'),
('Twentysomething', 'images/albums/twentysomething.png', '20/10/2003', 'https://www.youtube.com/embed/QzeC5bDfHAI', 9.99, 2,'Jazz'),
('Pointless Nostalgic', 'images/albums/pointless.png', '15/07/2002', 'https://www.youtube.com/embed/KtubVj0cWOA', 9.99, 2,'Jazz'),
('Ready Steady Go!', 'images/albums/readysteadygo.png', '22/04/2014', 'https://www.youtube.com/embed/rQYBVPVeQn0', 9.99, 4,'Pop'),
('The Ballad of Tom and Cindy', 'images/albums/ballad.png', '27/07/2012', 'https://www.youtube.com/embed/cO13lv-mXbQ', 9.99, 4,'Pop'),
('Its Only Time', 'images/albums/itsonlytime.png', '05/12/2006', 'https://www.youtube.com/embed/IHPTi-SX_2s', 9.99, 4,'Pop'),
('Telegraph', 'images/albums/telegraph.png', '23/08/2005', 'https://www.youtube.com/embed/mYMLFiBRD3U', 9.99, 4,'Pop'),
('The Book of Souls', 'images/albums/bookofsouls.png', '04/09/2015', 'https://www.youtube.com/embed/-F7A24f6gNc', 9.99, 3,'Heavy Metal'),
('The Final Frontier', 'images/albums/finalfrontier.png', '13/08/2010', 'https://www.youtube.com/embed/8S0QcINRYJs', 9.99, 3,'Heavy Metal'),
('A Matter of Life and Death', 'images/albums/matteroflife.png', '25/08/2006', 'https://www.youtube.com/embed/jvnfCfWnybY', 9.99, 3,'Heavy Metal'),
('Dance of Death', 'images/albums/danceofdeath.png', '02/09/2003', 'https://www.youtube.com/embed/fX5aMvCd7JE', 9.99, 3,'Heavy Metal'),
('Brave New World', 'images/albums/bravenewworld.png', '29/05/2000', 'https://www.youtube.com/embed/-sQ3Af3DpeM', 9.99, 3,'Heavy Metal'),
('Virtual XI', 'images/albums/virtualxi.png', '23/03/1998', 'https://www.youtube.com/embed/IhlRyxWU21s', 9.99, 3,'Heavy Metal'),
('The X Factor', 'images/albums/xfactor.png', '02/10/1995', 'https://www.youtube.com/embed/iS7qykdXX8Q', 9.99, 3,'Heavy Metal'),
('Fear of the Dark', 'images/albums/fearofthedark.png', '11/05/1992', 'https://www.youtube.com/embed/0c9iYZdsZMM', 9.99, 3,'Heavy Metal'),
('No Prayer For the Dying', 'images/albums/noprayer.png', '01/10/1990', 'https://www.youtube.com/embed/m0J7XnbUN5o', 9.99, 3,'Heavy Metal'),
('Seventh Son of a Seventh Son', 'images/albums/seventhson.png', '11/04/1988', 'https://www.youtube.com/embed/Kvqr366Op3k', 9.99, 3,'Heavy Metal'),
('Somewhere in Time', 'images/albums/somewhereintime.png', '29/09/1986', 'https://www.youtube.com/embed/Ij99dud8-0A', 9.99, 3,'Heavy Metal'),
('Powerslave', 'images/albums/powerslave.png', '03/09/1984', 'https://www.youtube.com/embed/9qbRHY1l0vc', 9.99, 3,'Heavy Metal'),
('Piece of Mind', 'images/albums/pieceofmind.png', '16/05/1983', 'https://www.youtube.com/embed/X4bgXH3sJ2Q', 9.99, 3,'Heavy Metal'),
('The Number of the Beast', 'images/albums/numberof.png', '22/03/1982', 'https://www.youtube.com/embed/86URGgqONvA', 9.99, 3,'Heavy Metal'),
('Killers', 'images/albums/killers.png', '02/02/1981', 'https://www.youtube.com/embed/__j55hsCxk0', 9.99, 3,'Heavy Metal'),
('Iron Maiden', 'images/albums/ironmaidenalbum.png', '14/04/1980','https://www.youtube.com/embed/b2krumHkU10', 9.99, 3,'Heavy Metal');

insert into singles(songTrackNo, songName,  songWriter, songLength, songImage, songPrice, artistID, albumID, songCat) VALUES
(1, 'Judas', 'Rich Ward, Johnny Andrews, Justin Cordle', '4:10', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(2,	'Drinkin With Jesus', 'Rich Ward, Johnny Andrews', '3:56', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(3,	'Painless',	'Rich Ward, Johnny Andrews', '4:00',  'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(4,	'Weight of My World', 'Rich Ward, Johnny Andrews','3:18', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(5,	'Wordsworth Way', 'Chris Jericho, Rich Ward, Johnny Andrews', '4:48', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(6,	'Burn Me Out',	'Rich Ward, Johnny Andrews', '4:04', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(7,	'Three Days in Jail', 'Chris Jericho, Rich Ward, Johnny Andrews, Hyro Da Hero',	'4:17', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(8,	'Elevator',	'Rich Ward, Johnny Andrews, Matt Walst, Simon Olds', '2:50', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(9,	'Running With the Bulls', 'Chris Jericho, Rich Ward, Johnny Andrews', '3:51', 'images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(10, 'Capsized', 'Rich Ward, Johnny Andrews', '4:16','images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(11, 'Wolves at Bay', 'Rich Ward, Johnny Andrews',	'3:09','images/albums/fozzyjudas.png', 0.99, 1 , 1,'Heavy Metal'),
(1,	'Do You Wanna Start a War','Chris Jericho, Rich Ward', '3:41', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(2,	'Bad Tattoo', 'Chris Jericho, Rich Ward', '4:00', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(3,	'Lights Go Out', 'Johnny Andrews, Rich Ward', '3:12', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(4,	'Died With You', 'Chris Jericho, Rich Ward', '3:32', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(5,	'Tonight',	'Rich Ward', '3:31', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(6,	'Brides of Fire', 'Chris Jericho, Rich Ward', '4:02', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(7,	'One Crazed Anarchist',	'Chris Jericho, Rich Ward', '3:58', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(8,	'Unstoppable','Chris Jericho, Rich Ward', '3:51', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(9,	'Scarecrow', 'Rich Ward', '3:37', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(10,'No Good Way', 'Johnny Andrews, Rich Ward',	'3:46', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(11,'SOS', 'Björn Ulvaeus, Benny Andersson, Stig Anderson',	'3:17', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(12, 'Witchery', 'Chris Jericho, Rich Ward', '4:50', 'images/albums/fozzywar.png', 0.99, 1, 2,'Heavy Metal'),
(1,	'Spider in My Mouth', 'Chris Jericho, Rich Ward', '4:47', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(2,	'Sandpaper', 'Chris Jericho, Rich Ward', '3:12', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(3,	'Blood Happens', 'Chris Jericho, Rich Ward', '4:07', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(4,	'Inside My Head', 'Chris Jericho, Rich Ward, Billy Grey', '4:02', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(5,	'Sin and Bones', 'Chris Jericho, Rich Ward', '3:36', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(6,	'A Passed Life', 'Chris Jericho, Rich Ward', '6:55', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(7,	"She's My Addiction", 'Chris Jericho, Rich Ward', '3:22', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(8, 'Shine Forever', 'Chris Jericho, Rich Ward', '5:45', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(9, 'Dark Passenger', 'Chris Jericho, Rich Ward, Billy Grey, Terry Chism', '4:23', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(10, 'Storm the Beaches','Chris Jericho, Rich Ward, Billy Grey, Terry Chism', '11:35', 'images/albums/fozzysin.png', 0.99, 1, 3,'Heavy Metal'),
(1, 'Under Blackened Skies', 'Chris Jericho, Rich Ward, Eric Sanders',	'5:32', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(2,	'Marty No More', 'Chris Jericho, Rich Ward', '4:36', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(3,	'Grail', 'Chris Jericho, Rich Ward', '5:09', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(4,	'Broken Soul', 'Chris Jericho, Rich Ward',	'4:09', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(5,	'Let the Madness Begin', 'Chris Jericho, Rich Ward', '3:47', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(6,	'Pray for Blood', 'Chris Jericho, Rich Ward', '5:11', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(7,	"New Day's Dawn", 'Chris Jericho, Rich Ward', '4:34', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(8,	'God Pounds His Nails',	 'Chris Jericho, Rich Ward', '4:20', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(9,	'Watch Me Shine', 'Chris Jericho, Rich Ward', '3:38', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(10, "Paraskavedekatriaphobia (Friday the 13)",	'Chris Jericho, Rich Ward',	'5:26', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(11, 'Revival',	'Rich Ward', '4:47', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'), 
(12, 'Wormwood', 'Chris Jericho, Mike Martin', '13:53', 'images/albums/fozzygrail.png', 0.99, 1, 4,'Heavy Metal'),
(1,	'Nameless Faceless', 'Chris Jericho, Rich Ward, Ed Aborn', '3:30', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(2, 'Enemy', 'Rich Ward, Rick Beato', '4:28', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(3,	'Wanderlust', 'Chris Jericho, Rich Ward', '4:16', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(4,	'All That Remains',	'Chris Jericho, Rich Ward, Ed Aborn', '4:35', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(5,	'The Test',	'Rich Ward', '3:08', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(6,	"It's a Lie",'Chris Jericho, Rich Ward, Ed Aborn', '4:28', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(7,	'Daze of the Weak',	'Chris Jericho, Rich Ward, Ed Aborn', '4:20', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(8,	'The Way I Am',	'Rich Ward', '4:12', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(9,	'Lazarus', 'Chris Jericho, Rich Ward, Ed Aborn', '4:03', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'),
(10, 'Born of Anger', 'Chris Jericho, Rich Ward, Ed Aborn, Frank Fontsere',	'4:42', 'images/albums/fozzyremains.png', 0.99, 1, 5,'Heavy Metal'), 
(1, 'Whitechapel 1888',	'Scott Banks', '1:00', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(2, 'To Kill a Stranger', 'Chris Jericho, Rich Ward', '4:00', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(3, 'Happenstance',	'Chris Jericho, Rich Ward',	'5:01', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(4, 'Freewheel Burning', 'Glenn Tipton, Rob Halford, K. K. Downing', '4:48', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(5, 'The Mob Rules', 'Ronnie James Dio, Geezer Butler, Tony Iommi', '3:19', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(6, 'Big City Nights', 'Klaus Meine, Rudolf Schenker', '4:25', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(7, 'Crucify Yourself',	'Chris Jericho, Rich Ward', '4:30', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(8, 'L.O.V.E. Machine', 'Blackie Lawless', '4:11', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(9, 'Balls to the Wall', 'Peter Baltes, Udo Dirkschneider, Wolf Hoffmann, Stefan Kaufmann, Deaffy',	'5:46', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(10, 'With the Fire', 'Chris Jericho, Rich Ward, Keith Watson', '3:09', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(11, 'Where Eagles Dare', 'Steve Harris', '6:19', 'images/albums/fozzyhappenstance.png', 0.99, 1, 6,'Heavy Metal'), 
(1, 'Stand Up and Shout', 'Ronnie James Dio, Jimmy Bain', '3:39', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(2,	'Eat the Rich',	'Butch Stone, Marc Storace, Fernando von Arb, Chris von Rohr', '4:05', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(3,	'Stay Hungry', 'Dee Snider', '2:57', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(4, 'The Prisoner', 'Adrian Smith, Steve Harris', '6:19', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(5, 'Live Wire', 'Nikki Sixx', '3:15', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(6, 'End of Days', 'Chris Jericho, Rich Ward', '3:55', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(7, 'Over the Mountain', 'Ozzy Osbourne, Randy Rhoads, Bob Daisley, Lee Kerslake', '4:32', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(8,	'Blackout', 'Sonja Kittelsen, Klaus Meine, Herman Rarebell, Rudolf Schenker', '3:39', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(9,	'Feel the Burn', 'Chris Jericho, Rich Ward', '4:24', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'), 
(10,'Riding on the Wind', 'Glenn Tipton, Rob Halford, K. K. Downing', '3:09', 'images/albums/fozzyalbum.png', 0.99, 1, 7,'Heavy Metal'),
(1, 'Interlude', 'Dizzy Gillespie, Raymond Leven, Frank Paparelli', '3:27', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(2, "Don't You Know", 'Ray Charles', '2:56', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(3, "The Seer's Tower", 'Sufjan Stevens', '3:55', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(4, 'Walkin', 'Richard Carpenter', '2:42', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(5, 'Good Morning Heartache', 'Ervin Drake, Dan Fisher, Irene Higginbotham', '3:32', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(6, "Sack O'Woe", 'Cannonball Adderley, Jon Hendricks', '3:45', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(7, "Don't Let Me Be Misunderstood", 'Bennie Benjamin, Gloria Caldwell, Sol Marcus', '2:58', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(8, 'My One and Only Love', 'Robert Mellin, Guy B. Wood', '4:32', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(9, 'Lovesick Blues', 'Cliff Friend, Irving Mills', '3:07', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(10, 'Losing You', 'Randy Newman', '3:24', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(11, 'Out of this World', 'Harold Arlen, Johnny Mercer', '5:51', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(12, 'Make Someone Happy', 'Betty Comden, Adolph Green, Jule Styne', '3:30', 'images/albums/interlude.png', 0.99, 2, 8,'Jazz'),
(1, 'The Same Things', 'Ben Cullum, Jamie Cullum', '3:46', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(2, 'Edge of Something', 'Jamie Cullum, Steve Booker', '4:40', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(3, "Everything You Didn't Do", 'Jamie Cullum', '3:48', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(4, 'When I Get Famous', 'Jamie Cullum', '4:34', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(5, 'Love for $ale', 'Cole Porter, Rodney Smith', '5:20', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(6, 'Pure Imagination', 'Leslie Bricusse, Anthony Newley', '5:09', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(7, 'Anyway', 'Iyiola Babalola, Jamie Cullum, Darren Lewis, Jackie Members Poindexter, Richard Poindexter', '3:54', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(8, 'Sad, Sad World', 'Jamie Cullum', '4:28', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(9, 'Take Me Out (Of Myself)', 'Jamie Cullum', '3:51', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(10, 'Save Your Soul', 'Ben Cullum, Jamie Cullum', '4:19', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(11, 'Get a Hold of Yourself', 'Jamie Cullum', '3:39', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(12, "You're Not the Only One", 'Ben Cullum, Jamie Cullum', '4:29', 'images/albums/momentum.png', 0.99, 2, 9,'Jazz'),
(1, 'Just One of Those Things', 'Cole Porter', '4:35', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(2, "I'm All Over It", 'Jamie Cullum, Ricky Ross', '3:40', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(3, 'Wheels', 'Jamie Cullum', '3:43', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(4, 'If I Ruled the World', 'Leslie Bricusse, Cyril Ornadel', '4:36', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(5, 'You and Me Are Gone', 'Jamie Cullum, Geoff Gascoyne, Sebastian de Krom', '5:05', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(6, "Don't Stop the Music", 'Tor Erik Hermansen, Mikkel Stroleer Eriksen, Frankie Storm, Michael Jackson', '4:49', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(7, "Love Ain't Gonna Let You Down", 'Jamie Cullum', '3:57', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(8, 'Mixtape', 'Ben Cullum, Jamie Cullum', '4:58', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(9, 'I Think, I Love', 'Jamie Cullum', '4:16', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(10, 'We Run Things', 'Jamie Cullum', '3:31', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(11, "Not While I'm Around", 'Stephen Sondheim', '3:32', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(12, 'Music Is Through', 'Ben Cullum, Jamie Cullum', '7:07', 'images/albums/pursuit.png', 0.99, 2, 10,'Jazz'),
(1, 'Get Your Way', 'Allen Toussaint, Jamie Cullum, Dan Nakamura', '4:01', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(2, 'London Skies', 'Jamie Cullum, Guy Chambers', '3:43', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(3, 'Photograph', 'Jamie Cullum', '5:47', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(4, 'I Only Have Eyes for You', 'Al Dublin, Harry Warren', '3:58', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(5, 'Nothing I Do', 'Jamie Cullum', '5:03', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(6, 'Mind Trick', 'Ben Cullum, Jamie Cullum', '4:05', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(7, '21st Century Kid', 'Jamie Cullum', '4:00', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(8, "I'm Glad There Is You", 'Jimmy Dorsey, Paul Mertz', '4:09', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(9, 'Oh God', 'Jamie Cullum, Guy Chambers', '3:38', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(10, 'Catch the Sun', 'Jimi Goodwin, Jez Williams, Andy Williams,', '3:46', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(11, '7 Days to Change Your Life', 'Jamie Cullum', '5:37', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(12, 'Our Day Will Come', 'Mort Garson, Bob Hilliard', '3:55', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(13, 'Back to the Ground', 'Jamie Cullum, Ed Harcourt', '4:37', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(14, 'Fascinating Rhythm', 'George Gershwin, Ira Gershwin', '4:49', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(15, 'My Yard', 'Ben Cullum, Jamie Cullum, Teron Beal', '4:09', 'images/albums/catchingtales.png', 0.99, 2, 11,'Jazz'),
(1, 'What a Difference a Day Made', 'Stanley Adams, María Grever', '5:09', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(2, 'These Are the Days', 'Ben Cullum', '3:21', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(3, "Singin' In the Rain", 'Arthur Freed, Nacio Herb Brown', '4:07', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(4, 'Twentysomething', 'Jamie Cullum', '3:40', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(5, 'But For Now', 'Bob Dorough', '3:55', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(6, 'Old Devil Moon', 'Burton Lane, Yip Harburg', '4:11', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(7, 'I Could Have Danced All Night', 'Alan Jay Lerner, Frederick Loewe', '3:24', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(8, 'Blame It on My Youth', 'Oscar Levant, Edward Heyman', '3:10', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(9, 'I Get a Kick Out of You', 'Cole Porter', '4:10', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(10, 'All At Sea', 'Jamie Cullum', '4:32', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(11, 'The Wind Cries Mary', 'Jimi Hendrix', '3:36', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(12, 'Lover, You Should Have Come Over', 'Jeff Buckley', '4:48', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(13, "It's About Time", 'Ben Cullum', '4:07', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(14, 'Next Year Baby', 'Jamie Cullum', '4:58', 'images/albums/twentysomething.png', 0.99, 2, 12,'Jazz'),
(1, 'You and the Night and the Music', 'Howard Dietz, Arthur Schwartz', '4:09', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(2, "I Can't Get Started", 'Vernon Duke, Ira Gershwin', '5:15', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(3, 'Devil May Care', 'Bob Dorough', '3:24', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(4, "You're Nobody Till Somebody Loves You", 'James Cavanaugh, Russ Morgan, Larry Stock', '3:43', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(5, 'Pointless Nostalgic', 'Ben Cullum, Jamie Cullum', '4:03', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(6, 'In the Wee Small Hours of the Morning', 'Bob Hilliard, David Mann', '6:28', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(7, "Well, You Needn't", 'Thelonious Monk', '3:21', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(8, "It Ain't Necessarily So", 'George Gershwin, Ira Gershwin', '4:31', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(9, 'High and Dry', "Colin Greenwood, Ed O'Brien, Jonny Greenwood, Philip Selway, Thom Yorke", '4:54', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(10, 'Too Close For Comfort', 'Jerry Bock, Larry Holofcener, George David Weiss', '3:25', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(11, 'A Time for Love', 'Johnny Mandel, Paul Francis Webster', '5:06', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(12, "Lookin' Good", 'Dave Frishberg', '3:10', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(13, 'I Want to Be a Popstar', 'Jamie Cullum', '4:02', 'images/albums/pointless.png', 0.99, 2, 13,'Jazz'),
(1, 'Sunny Afternoon', 'Ray Davies', '3:21', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(2, 'Bull', 'Mitchell Belch, Kevin Boldwin, Jonathan Howes, Edward Llerena, Bonnie Parks, Joseph Wyatt', '2:38', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(3, "I Won't Stand In Your Way", 'Brian Setzer', '4:06', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(4, 'Bitchcraft', 'Drake Bell, Brett Boyett', '3:00', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(5, 'Runaway Boys', 'Brian Setzer, James McDonnell', '3:38', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(6, 'Makes Me Happy', 'Drake Bell, Michael Corcoran, CJ Abraham', '2:51', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(7, "It's Still Rock and Roll to Me", 'Billy Joel', '2:56', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(8, 'Melina', 'Adam Traub', '3:18', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(9, 'Crazy Little Thing Called Love', 'Freddie Mercury', '2:57', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(10, 'California Man', 'Roy Wood', '3:07', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(11, 'Back of My Hand', 'John Adler, Nicholas Watkinson', '3:20', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(12, 'Give Me a Little More Time', 'Drake Bell, Daniel Kalisher, Will Herrington', '3:55', 'images/albums/readysteadygo.png', 0.99, 4, 14,'Pop'),
(1, "Yesterday's Fool", 'Drake Bell, William James McAuley III', '3:25', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(2, 'Our Love', 'Drake Bell, Michael Corcoran, CJ Abraham', '2:59', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(3, 'Unbelievable', 'Drake Bell, Michael Corcoran, CJ Abraham', '4:02', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(4, 'All Alone at the Disco', 'Drake Bell, Michael Corcoran', '3:46', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(5, 'Modern Times', 'Michael Corcoran, CJ Abraham', '3:38', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(6, 'Shades of Grey', 'Drake Bell, Michael Corcoran, CJ Abraham', '3:29', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(7, 'What You Need', 'Drake Bell', '3:05', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(8, 'Samantha', 'Michael Corcoran', '3:48', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(9, 'Terrific', 'Drake Bell', '3:24', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(10, "You're Not Thinking", 'Drake Bell, Mike Daly, Teddy Geiger, Heather Mitchell', '3:13', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(11, 'Big Shot', 'Drake Bell, Alex Harlan Silverman', '3:14', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(12, 'Speak My Mind', 'Scott Simmons', '4:13', 'images/albums/ballad.png' , 0.99, 4, 15,'Pop'),
(1, 'Up Periscope', 'Drake Bell, Michael Corcoran, CJ Abraham', '3:15', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(2, 'I Know', 'Drake Bell, Michael Corcoran, CJ Abraham','3:45', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(3, 'Do What You Want', 'Drake Bell, Michael Corcoran, CJ Abraham','3:25', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(4, "It's Only Time", 'Drake Bell, Michael Corcoran, CJ Abraham','3:59', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(5, 'Found A Way [Acoustic]', 'Drake Bell, Michael Corcoran','3:02', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(6, 'Makes Me Happy', 'Drake Bell, Michael Corcoran, CJ Abraham','2:07', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(7, 'Fool the World', 'Drake Bell, Michael Corcoran, CJ Abraham','4:42', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(8, 'Fallen For You', 'Drake Bell, Michael Corcoran','3:16', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(9, 'Rusted Silhouette', 'Drake Bell, Michael Corcoran, CJ Abraham','3:08', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(10, 'Break Me Down', 'Drake Bell, Michael Corcoran, CJ Abraham','2:06', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(11, 'End It Good', 'Drake Bell, Michael Corcoran, CJ Abraham','1:45', 'images/albums/itsonlytime.png', 0.99, 4, 16,'Pop'),
(1,'Intro','Drake Bell','0:27','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(2,'Found a Way','Drake Bell, Michael Corcoran','3:02','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(3,'Circles','Drake Bell','4:06','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(4,'Somehow','Drake Bell, Michael Corcoran','4:40','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(5,'In the End','Drake Bell, Michael Corcoran','4:24','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(6,"Don't Preach",'Drake Bell, Michael Corcoran, CJ Abraham','3:24','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(7,'Hollywood Girl','Drake Bell, Michael Corcoran, Graham Petersen','2:53','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(8,'Golden Days	Drake','Bell, Daniel Tashian, George Garner','3:43','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(9,'Down We Fall','Drake Bell, Michael Corcoran','5:50','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(10,'The Backhouse','Drake Bell','0:19','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(11,'Highway to Nowhere','Drake Bell, Shane William Bennett, Martin Shallman','4:04','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(12,'Telegraph','Drake Bell, Michael Corcoran','3:39','images/albums/telegraph.png', 0.99, 4, 17,'Pop'),
(1,'If Eternity Should Fail','Bruce Dickinson','8:28', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(2,'Speed of Light','Adrian Smith, Bruce Dickinson','5:01', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(3,'The Great Unknown','Adrian Smith, Steve Harris','6:37', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(4,'The Red and the Black','Steve Harris','13:33', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(5,'When the River Runs Deep','Adrian Smith, Steve Harris','5:52', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(6,'The Book of Souls','Janick Gers, Steve Harris','10:27', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(7,'Death or Glory','Adrian Smith, Bruce Dickinson','5:13', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(8,'Shadows of the Valley','Janick Gers, Steve Harris','7:32', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(9,'Tears of a Clown','Adrian Smith, Steve Harris','4:59', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(10,'The Man of Sorrows','Dave Murray, Steve Harris','6:28', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(11,'Empire of the Clouds','Bruce Dickinson','18:01', 'images/albums/bookofsouls.png', 0.99, 3, 18,'Heavy Metal'),
(1,'Satellite 15... The Final Frontier','Adrian Smith, Steve Harris','8:40', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(2,'El Dorado','Adrian Smith, Bruce Dickinson, Steve Harris','6:49', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(3,'Mother of Mercy','Adrian Smith, Steve Harris','5:20', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(4,'Coming Home','Adrian Smith, Bruce Dickinson, Steve Harris','5:52', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(5,'The Alchemist','Bruce Dickinson, Janick Gers, Steve Harris','4:29', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(6,'Isle of Avalon','Adrian Smith, Steve Harris','9:06', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(7,'Starblind','Adrian Smith, Bruce Dickinson, Steve Harris','7:48', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(8,'The Talisman','Janick Gers, Steve Harris','9:03', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(9,'The Man Who Would Be King','Dave Murray, Steve Harris','8:28', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(10,'When the Wild Wind Blows','Steve Harris','10:59', 'images/albums/finalfrontier.png',0.99, 3, 19,'Heavy Metal'),
(1,'Different World','Adrian Smith, Steve Harris','4:17', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(2,"These Colours Don't Run",'Adrian Smith, Bruce Dickinson, Steve Harris','6:52', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(3,'Brighter Than a Thousand Suns','Adrian Smith, Bruce Dickinson, Steve Harris','8:44', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(4,'The Pilgrim','Janick Gers, Steve Harris','5:07', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(5,'The Longest Day','Adrian Smith, Bruce Dickinson, Steve Harris','7:48', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(6,'Out of the Shadows','Bruce Dickinson, Steve Harris','5:36', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(7,'The Reincarnation of Benjamin Breeg','Dave Murray, Steve Harris','7:21', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(8,'For the Greater Good of God','Steve Harris','9:23', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(9,'Lord of Light','Adrian Smith, Bruce Dickinson, Steve Harris','7:25', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(10,'The Legacy','Janick Gers, Steve Harris','9:20', 'images/albums/matteroflife.png',0.99, 3, 20,'Heavy Metal'),
(1,'Wildest Dreams','Adrian Smith, Steve Harris','3:52', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(2,'Rainmaker','Bruce Dickinson, Dave Murray, Steve Harris','3:48', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(3,'No More Lies','Steve Harris','7:21', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(4,'Montségur','Bruce Dickinson, Janick Gers, Steve Harris','5:50', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(5,'Dance of Death','Janick Gers, Steve Harris','8:36', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(6,'Gates of Tomorrow','Bruce Dickinson, Janick Gers, Steve Harris','5:12', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(7,'New Frontier','Adrian Smith, Bruce Dickinson, Nicko McBrain','5:04', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(8,'Paschendale','Adrian Smith, Steve Harris','8:37', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(9,'Face in the Sand','Adrian Smith, Bruce Dickinson, Steve Harris','6:31', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(10,'Age of Innocence','Dave Murray, Steve Harris','6:10', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(11,'Journeyman','Adrian Smith, Bruce Dickinson, Steve Harris','7:06', 'images/albums/danceofdeath.png',0.99, 3, 21,'Heavy Metal'),
(1,'The Wicker','Man	Adrian Smith, Bruce Dickinson, Steve Harris','4:35', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(2,'Ghost of the Navigator','Bruce Dickinson, Janick Gers, Steve Harris','6:50', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(3,'Brave New World','Bruce Dickinson, Dave Murray, Steve Harris','6:18', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(4,'Blood Brothers','Steve Harris','7:14', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(5,'The Mercenary','Janick Gers, Steve Harris','4:42', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(6,'Dream of Mirrors','Janick Gers, Steve Harris','9:21', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(7,'The Fallen Angel','Adrian Smith, Steve Harris','4:00', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(8,'The Nomad','Dave Murray, Steve Harris','9:06', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(9,'Out of the Silent Planet','Bruce Dickinson, Janick Gers, Steve Harris','6:25', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(10,'The Thin Line Between Love and Hate','Dave Murray, Steve Harris','8:26', 'images/albums/bravenewworld.png',0.99, 3, 22,'Heavy Metal'),
(1,'Futureal','Blaze Bayley, Steve Harris','3:00','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(2,'The Angel and the Gambler','Steve Harris','9:51','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(3,'Lightning Strikes Twice','Dave Murray, Steve Harris','4:49','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(4,'The Clansman','Steve Harris','9:06','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(5,'When Two Worlds Collide','Blaze Bayley, Dave Murray, Steve Harris','6:13','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(6,'The Educated Fool','Steve Harris','6:46','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(7,"Don't Look to the Eyes of a Stranger",'Steve Harris','8:11','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(8,'Como Estais Amigos','Blaze Bayley, Janick Gers','5:26','images/albums/virtualxi.png',0.99, 3, 23,'Heavy Metal'),
(1,'Sign of the Cross','Steve Harris','11:18','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(2,'Lord of the Flies','Janick Gers, Steve Harris','5:04','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(3,'Man on the Edge','Blaze Bayley, Janick Gers','4:13','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(4,'Fortunes of War','Steve Harris','7:24','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(5,'Look for the Truth','Blaze Bayley, Janick Gers, Steve Harris','5:10','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(6,'The Aftermath','Blaze Bayley, Janick Gers, Steve Harris','6:21','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(7,'Judgement of Heaven','Steve Harris','5:12','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(8,"Blood on the World's Hands",'Steve Harris','5:58','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(9,'The Edge of Darkness','Blaze Bayley, Janick Gers, Steve Harris','6:39','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(10,'2 A.M.','Blaze Bayley, Janick Gers, Steve Harris','5:38','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(11,'The Unbeliever','Janick Gers, Steve Harris','8:10','images/albums/xfactor.png',0.99, 3, 24,'Heavy Metal'),
(1,'Be Quick or Be Dead','Bruce Dickinson, Janick Gers','3:21','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(2,'From Here to Eternity','Steve Harris','3:35','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(3,'Afraid to Shoot Strangers','Steve Harris','6:52','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(4,'Fear Is the Key','Bruce Dickinson, Janick Gers','5:30','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(5,"Childhood's End",'Steve Harris','4:37','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(6,'Wasting Love','Bruce Dickinson, Janick Gers','5:46','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(7,'The Fugitive','Steve Harris','4:52','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(8,'Chains of Misery','Bruce Dickinson, Dave Murray','3:33','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(9,'The Apparition','Janick Gers, Steve Harris','3:53','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(10,'Judas Be My Guide','Bruce Dickinson, Dave Murray','3:06','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(11,'Weekend Warrior','Janick Gers, Steve Harris','5:37','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(12,'Fear of the Dark','Steve Harris','7:16','images/albums/fearofthedark.png',0.99, 3, 25,'Heavy Metal'),
(1,'Tailgunner','Bruce Dickinson, Steve Harris','4:13','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(2,'Holy Smoke','Bruce Dickinson, Steve Harris','3:47','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(3,'No Prayer For the Dying','Steve Harris','4:22','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(4,'Public Enema Number One','Dave Murray','4:03','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(5,'Fates Warning','Dave Murray, Steve Harris','4:09','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(6,'The Assassin','Steve Harris','4:16','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(7,'Run Silent Run Deep','Bruce Dickinson, Steve Harris','4:34','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(8,'Hooks in You','Adrian Smith, Bruce Dickinson','4:06','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(9,'Bring Your Daughter... to the Slaughter','Bruce Dickinson','4:42','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(10,'Mother Russia','Steve Harris','5:30','images/albums/noprayer.png',0.99, 3, 26,'Heavy Metal'),
(1,'Moonchild','Adrian Smith, Bruce Dickinson','5:38','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(2,'Infinite Dreams','Steve Harris','6:08','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(3,'Can I Play with Madness','Adrian Smith, Bruce Dickinson, Steve Harris','3:30','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(4,'The Evil That Men Do','Adrian Smith, Bruce Dickinson, Steve Harris','4:33','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(5,'Seventh Son of a Seventh Son','Steve Harris','9:52','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(6,'The Prophecy','Dave Murray, Steve Harris','5:04','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(7,'The Clairvoyant','Steve Harris','4:26','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(8,'Only the Good Die Young','Bruce Dickinson, Steve Harris','3:35','images/albums/seventhson.png',0.99, 3, 27,'Heavy Metal'),
(1,'Caught Somewhere in Time','Steve Harris','7:22','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(2,'Wasted Years','Adrian Smith','5:06','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(3,'Sea of Madness','Adrian Smith','5:42','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(4,'Heaven Can Wait','Steve Harris','7:24','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(5,'The Loneliness of the Long Distance Runner','Steve Harris','6:31','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(6,'Stranger in a Strange Land','Steve Harris','5:43','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(7,'Deja-Vu','Dave Murray, Steve Harris','4:55','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(8,'Alexander the Great','Steve Harris','8:35','images/albums/somewhereintime.png',0.99, 3, 28,'Heavy Metal'),
(1,'Aces High','Steve Harris','4:31','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(2,'2 Minutes to Midnight','Adrian Smith, Bruce Dickinson','6:04','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(3,"Losfer Words (Big 'Orra)",'Steve Harris','4:15','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(4,'Flash of the Blade','Bruce Dickinson','4:05','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(5,'The Duellists','Steve Harris','6:18','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(6,'Back in the Village','Adrian Smith, Bruce Dickinson','5:02','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(7,'Powerslave','Bruce Dickinson','7:12','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(8,'Rime of the Ancient Mariner','Steve Harris','13:45','images/albums/powerslave.png',0.99, 3, 29,'Heavy Metal'),
(1,'Where Eagles Dare','Steve Harris','6:08','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(2,'Revelations','Bruce Dickinson','6:51','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(3,'Flight of Icarus','Adrian Smith, Bruce Dickinson','3:49','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(4,'Die With Your Boots On','Adrian Smith, Bruce Dickinson, Steve Harris','5:22','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(5,'The Trooper','Steve Harris','4:10','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(6,'Still Life','Dave Murray, Steve Harris','4:27','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(7,'Quest for Fire','Steve Harris','3:40','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(8,'Sun and Steel','Adrian Smith, Bruce Dickinson','3:25','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(9,'To Tame a Land','Steve Harris','7:26','images/albums/pieceofmind.png',0.99, 3, 30,'Heavy Metal'),
(1,'Invaders','Steve Harris','3:20','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(2,'Children of the Damned','Steve Harris','4:34','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(3,'The Prisoner','Adrian Smith, Steve Harris','5:35','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(4,'22 Acacia Avenue','Adrian Smith, Steve Harris','6:34','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(5,'The Number of the Beast','Steve Harris','4:25','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(6,'Run to the Hills','Steve Harris','3:50','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(7,'Gangland','Clive Burr, Steve Harris','3:46','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(8,'Hallowed Be Thy Name','Steve Harris','7:08','images/albums/numberof.png',0.99, 3, 31,'Heavy Metal'),
(1,'The Ides of March','Steve Harris','1:48','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(2,'Wrathchild','Steve Harris','2:54','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(3,'Murders in the Rue Morgue','Steve Harris','4:14','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(4,'Another Life','Steve Harris','3:22','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(5,'Genghis Khan','Steve Harris','3:02','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(6,'Innocent Exile','Steve Harris','3:50','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(7,'Killers',"Steve Harris, Paul Di'Anno",'4:58','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(8,'Prodigal Son','Steve Harris','6:05','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(9,'Purgatory','Steve Harris','3:18','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(10,'Drifter','Steve Harris','4:47','images/albums/killers.png',0.99, 3, 32,'Heavy Metal'),
(1,'Prowler','Steve Harris','3:55','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(2,'Remember Tomorrow',"Steve Harris, Paul Di'Anno",'5:27','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(3,'Running Free', "Steve Harris, Paul Di'Anno",'3:16','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(4,'Phantom of the Opera','Steve Harris','7:20','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(5,'Transylvania','Steve Harris','4:05','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(6,'Strange World','Steve Harris','5:45','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(7,'Charolotte the Harlot','Dave Murray','4:12','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal'),
(8,'Iron Maiden','Steve Harris','3:35','images/albums/ironmaidenalbum.png',0.99, 3, 33,'Heavy Metal');


insert into charts (chartAlbum, chartArtist, chartWeeks) VALUES
('Judas', '	Fozzy', 3),
('Heartbreak On A Full Moon', 'Chris Brown', 1),
('Do You Wanna Start a War', 'Fozzy', 19),
('Momentum', 'Jamie Cullum', 3),
('Tell Me You Love Me', 'Demi Lovato', 6),
('Mr. Davis', 'Gucci Mane', 4),
('American teen', 'Khalid', 38),
('Divide', 'Ed Sheeran', 36),
('Pretty Girls Like Trap Music', '2 Chainz', 21),
('The Ballad of Tom and Cindy', 'Drake Bell', 2),
('More Life', 'Drake', 19),
('Evolve', 'Imagine Dragon', 3),
('The Book of Souls', 'Iron Maiden', 6),
('DAMN.', 'Kendrick Lamar', 4),
('Beautiful', 'P!nk', 38);

#######################################################################################################################
#Dont mind below sql thats for testing
#######################################################################################################################
SELECT * FROM artists;
SELECT * FROM albums where artistID= 3;
select * from singles;
UPDATE albums SET albumName = 'Judas', albumPrice = 9.99, albumRelease = '13/10/2017', albumVideo = 'https://www.youtube.com/embed/lqURPBtGJzg',
        artistID = 1 WHERE albumID=1;
UPDATE singles SET songName = '$songName', songCat = '$songCat', songTrackNo = 1, albumID = 3,
        songCat = '$songCat',songWriter = '$songWriter',songLength = '$songLength',songPrice = 3.5, artistID = 2 WHERE songID = 3;
        INSERT into albums (songName, songPrice, songTrackNo, songCat, songWriter, songLength, artistID, albumID, songImage) VALUES ('$songName',1,1,'$songCat','$songWriter','$songLength',17,46,'images/singles/$songImage');
SELECT *, 'art' as type FROM artists WHERE artistName LIKE 'fozzy';

(SELECT *, 'art' as type FROM artists WHERE artistName LIKE 'fozzy')
        UNION
        (SELECT *, 'alb' as type FROM albums WHERE albumName LIKE 'fozzy')
        UNION
        (SELECT *, 'son' as type FROM singles WHERE songName LIKE 'fozzy');
        
select * from artists where artistName = 'P!nk';
#########################################################################################################################

