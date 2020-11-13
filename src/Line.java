// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class that define a line

public class Line {
    public Point point;
    public Direction dirVector;

    // Point Point: some point on the line;
    // Direction DirVector: direction vector of the line;
    Line(Point Point, Direction DirVector) {
        point = Point;
        dirVector = DirVector;
    }

    // Return the Point intersection of this line and a plane.
    public Point intersectWithPlane(Plane plane) {
        double A, B, C, D, E, F, m, n, p, x, y, z, identifier;

        Point p0 = plane.point;
        Point p1 = point;
        A = plane.normalVector.A;
        B = plane.normalVector.B;
        C = plane.normalVector.C;
        m = dirVector.A;
        n = dirVector.B;
        p = dirVector.C;
        double t;
        identifier = A * m + B * n + C * p;
        if (identifier == 0) {
            System.out.println("identifier is 0");
            return null;
        } else {
            t = (A * (p0.x - p1.x) + B * (p0.y - p1.y) + C * (p0.z - p1.z)) / (identifier);
            x = p1.x + m * t;
            y = p1.y + n * t;
            z = p1.z + p * t;
            return new Point(x, y, z);
        }
    }

    // Return boolean whether another point is on this line or not.
    public boolean pointOn(Point otherPoint) {
        if (otherPoint == null) {
            return false;
        }
        Direction otherDirVector =
                new Direction(point.x - otherPoint.x, point.y - otherPoint.y, point.z - otherPoint.z);

        return (proxiSame(dirVector.A * otherDirVector.B, dirVector.B * otherDirVector.A)
                && proxiSame(dirVector.B * otherDirVector.C, dirVector.C * otherDirVector.B)
                && proxiSame(dirVector.A * otherDirVector.C, dirVector.C * otherDirVector.A));
    }

    // Determine whether two double value is proximately the same(to avoid some mysterious issues).
    public boolean proxiSame(Double a, Double b) {
        if (a <= 0.01 && b <= 0.01) {
            return true;
        } else return a / b < 1.01 && a / b > 0.99;
    }

    // Move the line towards some direction by some distance.
    // Caution: it will do nothing if the direction is the same with the direction vector of this line.
    public void moveTo(Direction direction, double distance) {
        point.moveTo(direction, distance);
    }


    @Override
    public String toString() {
        return "Line( " + point.toString() + ", " + dirVector.toString() + " )";
    }

    public static void main(String[] Args) {

    }


}
