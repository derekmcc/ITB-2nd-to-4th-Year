function calcTotalSalary(basic: number, 
                         bonus: number = 0.0, 
                         director: boolean = false) : number {

    var earnings: number = basic + bonus;

    if (director) {
        earnings *= 2;
    }

    return earnings;
}
