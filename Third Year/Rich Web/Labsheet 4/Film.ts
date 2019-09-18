class Film {
    private filmID: number;
    private title: string;
    private synopsis: string;
    private price: number;
    private genre: string;
    private score: number;
    private addGenre: string = "";
    private counter: number = 0;

    constructor(filmID: number, title: string, synopsis: string, price: number, genre: string, score: number){
        this.filmID = filmID;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.genre = genre;
        this.score = score;
    }//end constructor

    setFilmID(id: number): void {
        this.filmID = id;
    }//end setFilmID

    getFilmID(): number {
        return this.filmID;
    }//end getFilmID

    setTitle(title: string): void {
        this.title = title;
    }//end setTitle

    getTitle(): string {
        return this.title;
    }//end getTitle

    setSynopsis(synopsis: string): void {
        this.synopsis = synopsis
    }//end setsynopsis

    getSynopsis(): string {
        return this.synopsis;
    }//end getSynopsis

    setPrice(price: number): void {
        this.price = price;
    } //end setPrice

    getPrice(): number {
        return this.price;
    }//end getPrice

    setGenre(genre: string) {
        this.genre = genre;
    }//end setGenre

    getGenre(): string {
        return this.genre;
    }//end getGenre

    setScore(score: number): void {
        this.score = score;
        this.counter++;
    }//end setScore

    getScore(): number {
        return this.score;
    }//end getScore

    addGenres(...newGenre: string[]) {
        for (var i = 0; i < newGenre.length; i++) {
            this.addGenre += ", " + newGenre[i];
        }//end for
    }//end addGenres

    genresAsString(): string {
        return this.genre += this.addGenre;
    }//end genresAsString

    review(...review: Review[]) {
        for (var i = 0; i < review.length; i++) {
            console.log(review[i].toString());
        }//end for
    }//end rate

    averageScore(...review: Review[]): number {
        var average: number = 0;
        var count: number = 0;
        for (var i = 0; i < review.length; i++) {
            average += review[i].getScore();
            count++;
        }//end for
        return average/count;
    }//end averageScore

    reviewsAsString(...review: Review[]): string {
        var reviewString: string = "";
        for (var i = 0; i < review.length; i++) {
        	reviewString += review[i].toString() + "\n";
        }//end for
        return reviewString;
    }//end reviewAsString

    toString(): string {
        return "\t\t\tFilm Details\n" + "ID: " + this.filmID + "'Title: " + this.title + "\nSynopsis: " + this.synopsis + "\nPrice: " + this.price + "\nGenre: " + this.genre + "\nScore: " + this.score + "\nAverage Score: " + this.averageScore() + "\n\n";
    }//end toString

}//end class

abstract class Review {
	private score: number;

	constructor (score: number) {
		this.score = score;
	}//end constructor

	toString(): string {
		return "\nReview Details\n" + "Score: " + this.score;
	}//end setScore

	getScore() {
		return this.score;
	}//end getScore
}//end class

class BriefReview extends Review  {

	private comment: string;

	constructor(score: number, comment: string) {
		super(score);
		this.comment = comment;
	}//end constructor

	setComment(comment: string) {
		this.comment = comment;
	}//end setComment

	getComment() {
		return this.comment;
	}//end getComment

	toString(): string {
		return super.toString() + "\nComments: " + this.comment;
	}//end setScore

	getScore() {
		return super.getScore();
	}//end getScore
}//end class

class CriticalReview extends Review  {

	private companyName: string;
	private comment: string;

	constructor(score: number, companyName: string, comment: string) {
		super(score);
		this.companyName = companyName;
		this.comment = comment;
	}//end constructor

	setCompanyName(companyName: string) {
		this.companyName = companyName;
	}//end setCompanyName

	getCompanyName() {
		return this.companyName;
	}//end getCompanyName

	setComment(comment: string) {
		this.comment = comment;
	}//end setComment

	getComment() {
		return this.comment;
	}//end getComment

	getScore() {
		return super.getScore();
	}//end getScore

	toString(): string {
		return super.toString() + "\nCompany: "+ this.companyName + "\nComments: " +  this.comment;
	}//end setScore
}//end class

var fm1 = new Film(1,"John Wick","An ex-hitman comes out of retirement to track down the gangsters that took everything from him.",5,"Action",5);
var rv: Review[];
var cr = new CriticalReview(4, "The Guardian", "It is a perfect marriage of artist and repertoire. Keanu Reeves, fit, trim and 50, starring in an action-first,"+
"story-second movie that years ago would have knocked ’em dead at the drive-in. John Wick is a slick, propulsive"+ 
"and ridiculous crime picture that strides like an automatic machine gun and has just as much subtlety."+
"But its confidence and élan allow the story to take surrealist turns: more Boorman’s Point Blank than Bigelow’s Point Break."+

"John Wick begins with a cool montage that almost apes the “sad Keanu” meme. Our leading man, John Wick "+
"(who is almost always referred to by his full name – and why not, when it’s that cool?) is mourning the loss of his"+
"spouse in a modern suburban home that looks primed for a photo shoot in Dwell magazine. Before succumbing to disease,"+ 
"his wife organized the delivery of a puppy (cinema’s most adorable pet since almighty Uggie) to give him something to"+
"love as he tries to heal. When John Wick later runs afoul of some Russian gangsters who want to take his car, he tells"+ 
"them to buzz off in their native tongue. The thugs (led by Game of Thrones’ Alfie Allen) invade his home late at night,"+ 
"give him a beat down, steal his wheels and kill the pooch. One phone call later John Wick lets everyone know that the demon is out of the bottle."+

"What Allen’s bratty-ass punk Iosef didn’t realize was that John Wick used to be the top hit-man for his father Viggo"+ 
"(Michael Nyqvist). John Wick had effectively bought himself a right to a peaceful retirement through Herculean levels of"+ 
"mob enforcement, and now that that quiet has been shattered by the whimper of dead doggie, look out!"+

"Veteran stuntmen and second unit directors Chad Stahelski and David Leitch, making their debut as feature directors, stage the action with a"+ 
"fierce clarity. John Wick kills his way through neon nightclubs, art deco-inspired hotel rooms and eerily lit churches. Unlike, say, the work"+ 
"of John Woo, there isn’t a reliance on slow-motion, which affords the blunt, direct to the head gun-fu – a “holy cow, did he just do that?”"+ 
"shock value. When you think you’ve seen John Wick twist in the most acrobatic way to blast the baddie sneaking up behind him, he’ll strike another pose that tops it."+

"Of course, a movie about a relentless vengeance machine can only go so far. John Wick ups its game by stopping in for the night at a hotel"+ 
"for contract killers, opening a door into a criminal underworld that in lesser hands would seem silly. (Like, for example, Frank Miller and"+ 
"Robert Rodriguez’s recent Sin City: A Dame To Kill For.) In the urban environment of John Wick, an entire service industry of drivers, cleaners"+ 
"and bellman live by night and a code of ethics that, naturally, can be bent for the right price. One of the best things I can say about John Wick"+ 
"is that I’d really love to see more movies set in this world, and they don’t necessarily have to star these characters. But hopefully from the same"+ 
"directors, as their handle on this milieu feels refreshing and new."+

"From the use of colour and music to the scenery-chomping by supporting players Willem Dafoe and Ian McShane, these are guys bursting with a"+ 
"love for genre cinema but aren’t too enslaved by affection to let in a little air. There’s a wonderful free spirit with the use of New York"+ 
"City locations that ditches verisimilitude for storytelling. The Surrogates’ Courthouse downtown is actually a Bosch-ian dance club with an"+
"interior of Scarface-esque hot tubs? Who in their right mind would disagree!"+

"So much recent action cinema feels the need to be gritty, realistic and dark. John Wick is the fun alternative we’ve been waiting for."); 
var br = new BriefReview(5, "John Wick works because of its sleek, artisanal dovetailing of style and sincerity.");
rv = [cr, br];
console.log(fm1.reviewsAsString(rv[0],rv[1]));
console.log("\nAverage Score : " + fm1.averageScore(rv[0],rv[1]));
