import { Vector } from './vector'
// define the point on a 3-dim space


export class Point{

    constructor(public x:number, public y: number, public z: number){
        // (Constructor:) initialize the point object
    }

    public distanceToPoint(otherpoint: Point) {
        // (Number:) return the distance between two points
        return Math.sqrt(Math.pow(this.x - otherpoint.x, 2) + Math.pow(this.y - otherpoint.y, 2) + Math.pow(this.z - otherpoint.z, 2));
    }

    public isSame(otherpoint: Point) {
        // (Boolean:) return whether two points are the same
        return this.x == otherpoint.x && this.y == otherpoint.y && this.z == otherpoint.z;
    }

}

export class Vertice extends Point{
    private speed: Vector

    constructor(public x:number, public y: number, public z: number){
        super(x, y ,z)
        this.speed = new Vector(0,0,0)
    }
}