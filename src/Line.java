public class Line {
    public Point point;
    public Direction dirVector;

    Line(Point Point, Direction DirVector) {
        point = Point;
        dirVector = DirVector;
    }

    public Point intersectWithPlane(Plane plane) {
        double A, B, C, D, E, F, m, n, p, x, y, z, identifier;

        Point p0 = plane.point;
        A = plane.normalVector.A;
        B = plane.normalVector.A;
        C = plane.normalVector.C;
        m = dirVector.A;
        n = dirVector.B;
        p = dirVector.C;
        D = (A * p0.x + B * p0.y + C * p0.z);
        E = (p * point.y - n * point.z);
        F = (p * point.x - m * point.z);
        identifier = A * m + B * n + C * p;
        if (identifier == 0) {
            return null;
        }
//        double[] doubles = {A, B, C, D, E, F, m, n, p};
//        System.out.println(plane.point.Print());
//        System.out.println(point.Print());
//        System.out.println(Arrays.toString(doubles));
        z = -(A * F - p * D + B * E) / (identifier);
        if (p != 0) {
            y = (E + n * z) / p;
            x = (F + m * z) / p;
        } else {
            E = (m * point.z - p * point.x);
            F = (m * point.y - n * point.x);
            x = (B * F - m * D + C * E) / (identifier);
            E = (n * point.x - p * point.y);
            F = (n * point.z - n * point.y);
            y = (A * F - n * D + C * E) / (identifier);

        }

        return new Point(x, y, z);

    }

    public boolean pointOn(Point otherPoint) {
        if (otherPoint == null) {
            return false;
        }
        Direction otherDirVector =
                new Direction(point.x - otherPoint.x, point.y - otherPoint.y, point.z - otherPoint.z);
        return (dirVector.A * otherDirVector.B == dirVector.B * otherDirVector.A
                && dirVector.B * otherDirVector.C == dirVector.C * otherDirVector.B
                && dirVector.A * otherDirVector.C == dirVector.C * otherDirVector.A);
    }

    public static void main(String[] Args) {
        Line line = new Line(new Point(0, 0, 5), new Direction(0, 0, -1));
        Plane plane = new Plane(new Point(0, 0, 0), new Direction(0, 0, 4));
        Point result = line.intersectWithPlane(plane);
        System.out.print(result.toString());
        System.out.print(line.pointOn(new Point(4, 0, 1)));
    }


}
