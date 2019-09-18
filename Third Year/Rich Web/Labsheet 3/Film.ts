class Film {
    private filmID: number;
    private title: string;
    private synopsis: string;
    private price: number;
    private genre: string;
    private score: number;
    private addGenre: string = "";
    private counter: number = 1;

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

    rate(newScore: number): void{
        this.score += newScore;
        this.counter++;
    }//end rate

    averageScore(): number {
        return this.score/this.counter;
    }//end averageScore

    toString(): string {
        return "\t\t\tFilm Details\n" + "ID: " + this.filmID + "'Title: " + this.title + "\nSynopsis: " + this.synopsis + "\nPrice: " + this.price + "\nGenre: " + this.genre + "\nScore: " + this.score + "\nAverage Score: " + this.averageScore() + "\n\n";
    }//end toString

}//end class
var fm1 = new Film(1,"John Wick","An ex-hitman comes out of retirement to track down the gangsters that took everything from him.",5,"Action",5);
console.log(fm1.toString());
fm1.addGenres("Thriller","Crime");
fm1.genresAsString();
fm1.rate(4);
console.log(fm1.toString());
fm1.rate(3);