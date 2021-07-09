// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class that define a point in the 3-dim axes.

public final class Point {
    double x, y, z;
    SpaceVector accelerate = new SpaceVector(0, 0, 0);
    SpaceVector speed = new SpaceVector(0, 0, 0);

    Point(double x0, double y0, double z0) {
        x = x0;
        y = y0;
        z = z0;
    }

    // Get the distance between this point and an other point.
    public double distanceBetween(Point point2) {
        return Math.sqrt(Math.pow(x - point2.x, 2) + Math.pow(y - point2.y, 2) + Math.pow(z - point2.z, 2));
    }

    // Return boolean value whether this point is same with another point.
    boolean isSame(Point point2) {
        return x == point2.x && y == point2.y && z == point2.z;
    }

    boolean onSameSideWithP(Point otherPoint, Plane plane) {
        if (isSame(otherPoint)) {
            return true;
        } else {
            return (plane.normalVector.A * (x - plane.point.x)
                    + plane.normalVector.B * (y - plane.point.y)
                    + plane.normalVector.C * (z - plane.point.z))
                    * (plane.normalVector.A * (otherPoint.x - plane.point.x)
                    + plane.normalVector.B * (otherPoint.y - plane.point.y)
                    + plane.normalVector.C * (otherPoint.z - plane.point.z)) >= 0;
        }

    }

    // Return the double distance between this point and a line.
    public double distanceToLine(Line line) {
        double m, n, p, x1, y1, z1;
        m = line.dirVector.A;
        n = line.dirVector.B;
        p = line.dirVector.C;
        x1 = line.point.x;
        y1 = line.point.y;
        z1 = line.point.z;
        double t = (m * (x - x1) + n * (y - y1) + p * (z - z1)) / (Math.pow(m, 2) + Math.pow(n, 2) + Math.pow(p, 2));
        double xc = m * t + x1;
        double yc = n * t + y1;
        double zc = p * t + z1;
        return Math.sqrt(Math.pow(x - xc, 2) + Math.pow(y - yc, 2) + Math.pow(z - zc, 2));
    }

    // Return the position of a new point by moving this point towards some direction by some distance.
    public Point getNewPos(Direction direction, double distance) {
        double commonFactor = distance / Math.sqrt(
                Math.pow(direction.A, 2) + Math.pow(direction.B, 2) + Math.pow(direction.C, 2));

        return new Point(x + commonFactor * direction.A, y + commonFactor * direction.B, z + commonFactor * direction.C);
    }

    // Move this point towards some direction by some distance.
    public void moveTo(Direction direction, double distance) {
        double commonFactor = distance / Math.sqrt(
                Math.pow(direction.A, 2) + Math.pow(direction.B, 2) + Math.pow(direction.C, 2));

        x = x + commonFactor * direction.A;
        y = y + commonFactor * direction.B;
        z = z + commonFactor * direction.C;
    }

    // Return the intersection of the line from this point to the perspective center and the camera screen.
    public Point positionOnScreen(Camera camera) {
        Segment lightRoute = new Segment(this, camera.center);
        return lightRoute.intersectWithPlane(camera.getScreenPlane());


    }

    // Give the point some accelerate;
    public void setAccelerate(SpaceVector accelerate0) {
        accelerate = accelerate0;
    }

    // Give the point some speed;
    public void setSpeed(SpaceVector speed0) {
        speed = speed0;
    }

    // Calculate the speed of this object in the next frame;
    public void newSpeed() {
        speed.add(accelerate);
    }

    // Calculate the new Position of this object in the next frame;
    public void newPos() {
        x += speed.x;
        y += speed.y;
        z += speed.z;
    }


    @Override
    public String toString() {
        return "Point(" + x + ',' + y + ',' + z + ')';
    }

    public static void main(String[] args) {
//        System.out.print(new Point(0, 0, 0).distanceBetween(new Point(1, 1, 1)));
        Point p1 = new Point(1, 1, 1);
        Point p2 = new Point(2, 3, -4);
        Plane p0 = new Plane(new Point(0, 0, 0), new Direction(0, 0, 10));
        System.out.println(p1.onSameSideWithP(p2, p0));
    }

}
