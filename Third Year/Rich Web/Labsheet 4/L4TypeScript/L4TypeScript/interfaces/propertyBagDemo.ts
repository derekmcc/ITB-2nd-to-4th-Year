interface IShapeConfig {
    cx: number;   // Required.
    cy: number;   // Required
    w: number;    // Required.
    h?: number;   // Optional.
}

class Shape {
    constructor(public x0: number, public x1: number, public y0: number, public y1: number) {}
    
    toString() : string {
        return `L: ${this.x0} R: ${this.x1} T: ${this.y0} B: ${this.y1}`;
    }
}

function createShape(config: IShapeConfig) : Shape {
    if (!config.h) {
        config.h = config.w;
    }
    
    return new Shape(
        config.cx - config.w/2,
        config.cx + config.w/2,
        config.cy - config.h/2,
        config.cy + config.h/2)
}

let shape1 = createShape({cx: 10, cy: 20, w: 5});
console.log(shape1);

let shape2 = createShape({cx: 100, cy: 200, w: 50, h: 25});
console.log(shape2);


