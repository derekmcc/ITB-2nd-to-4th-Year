function getFullName(fname: string, ...othernames: string[]) {
    return fname + " " + othernames.join(" ");
}
