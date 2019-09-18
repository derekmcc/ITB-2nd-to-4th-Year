function calcTotalSalary(basic: number, 
                         bonus: number = 0.0, 
                         director: boolean = false,
                         offshoreSlushFund?: number) : number {

    var earnings: number = basic + bonus;

    if (offshoreSlushFund) {
        earnings += offshoreSlushFund;
    }

    if (director) {
        earnings *= 2;
    }

    return earnings;
}
