class CriticalReview extends Review  {

	private companyName: string;
	private comment: string;

	constructor(score: number, companyName: string, comment, string) {
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