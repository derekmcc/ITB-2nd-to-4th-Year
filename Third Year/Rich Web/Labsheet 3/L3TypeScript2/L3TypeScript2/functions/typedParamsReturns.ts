function calcTotalSalary(basic: number, 
                         bonus: number, 
                         director: boolean) : number {

    var earnings: number = basic + bonus;

    if (director) {
        earnings *= 2;
    }

    return earnings;
}
