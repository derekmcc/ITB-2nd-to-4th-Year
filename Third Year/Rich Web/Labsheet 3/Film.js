var Film = /** @class */ (function () {
    function Film(filmID, title, synopsis, price, genre, score) {
        this.addGenre = "";
        this.counter = 1;
        this.filmID = filmID;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.genre = genre;
        this.score = score;
    } //end constructor
    Film.prototype.setFilmID = function (id) {
        this.filmID = id;
    }; //end setFilmID
    Film.prototype.getFilmID = function () {
        return this.filmID;
    }; //end getFilmID
    Film.prototype.setTitle = function (title) {
        this.title = title;
    }; //end setTitle
    Film.prototype.getTitle = function () {
        return this.title;
    }; //end getTitle
    Film.prototype.setSynopsis = function (synopsis) {
        this.synopsis = synopsis;
    }; //end setsynopsis
    Film.prototype.getSynopsis = function () {
        return this.synopsis;
    }; //end getSynopsis
    Film.prototype.setPrice = function (price) {
        this.price = price;
    }; //end setPrice
    Film.prototype.getPrice = function () {
        return this.price;
    }; //end getPrice
    Film.prototype.setGenre = function (genre) {
        this.genre = genre;
    }; //end setGenre
    Film.prototype.getGenre = function () {
        return this.genre;
    }; //end getGenre
    Film.prototype.setScore = function (score) {
        this.score = score;
        this.counter++;
    }; //end setScore
    Film.prototype.getScore = function () {
        return this.score;
    }; //end getScore
    Film.prototype.addGenres = function () {
        var newGenre = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            newGenre[_i] = arguments[_i];
        }
        for (var i = 0; i < newGenre.length; i++) {
            this.addGenre += ", " + newGenre[i];
        } //end for
    }; //end addGenres
    Film.prototype.genresAsString = function () {
        return this.genre += this.addGenre;
    }; //end genresAsString
    Film.prototype.rate = function (newScore) {
        this.score += newScore;
        this.counter++;
    }; //end rate
    Film.prototype.averageScore = function () {
        return this.score / this.counter;
    }; //end averageScore
    Film.prototype.toString = function () {
        return "\t\t\tFilm Details\n" + "ID: " + this.filmID + "'Title: " + this.title + "\nSynopsis: " + this.synopsis + "\nPrice: " + this.price + "\nGenre: " + this.genre + "\nScore: " + this.score + "\nAverage Score: " + this.averageScore() + "\n\n";
    }; //end toString
    return Film;
}()); //end class
var fm1 = new Film(1, "John Wick", "An ex-hitman comes out of retirement to track down the gangsters that took everything from him.", 5, "Action", 5);
console.log(fm1.toString());
fm1.addGenres("Thriller", "Crime");
fm1.genresAsString();
fm1.rate(4);
console.log(fm1.toString());
fm1.rate(3);
sourceMappingURL=Film.js.map