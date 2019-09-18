var Review = /** @class */ (function () {
    function Review(score) {
        this.score = score;
    } //end constructor
    Review.prototype.toString = function () {
        return "Review Details\n" + "Score: " + this.score;
    }; //end setScore
    return Review;
}()); //end class
