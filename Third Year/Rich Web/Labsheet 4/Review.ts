abstract class Review {
	private score: number;

	constructor (score: number) {
		this.score = score;
	}//end constructor

	toString(): string {
		return "Review Details\n" + "Score: " + this.score;
	}//end setScore

	getScore() {
		return this.score;
	}//end getScore
}//end class