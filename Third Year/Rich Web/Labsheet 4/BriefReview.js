var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var BriefReview = /** @class */ (function (_super) {
    __extends(BriefReview, _super);
    function BriefReview(score, comment) {
        var _this = _super.call(this, score) || this;
        _this.comment = comment;
        return _this;
    } //end constructor
    BriefReview.prototype.setComment = function (comment) {
        this.comment = comment;
    }; //end setComment
    BriefReview.prototype.getComment = function () {
        return this.comment;
    }; //end getComment
    BriefReview.prototype.toString = function () {
        return _super.prototype.toString.call(this) + "\nComments: " + this.comment;
    }; //end setScore
    return BriefReview;
}(Review)); //end class
