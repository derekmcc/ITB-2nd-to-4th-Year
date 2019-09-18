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

	//getScore() {
	//	return this.score;
	//}//end getScore
}//end class