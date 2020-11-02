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
        B = plane.normalVector.B;
        C = plane.normalVector.C;
        m = dirVector.A;
        n = dirVector.B;
        p = dirVector.C;
        D = (A * p0.x + B * p0.y + C * p0.z);
        E = (p * point.y - n * point.z);
        F = (p * point.x - m * point.z);
        identifier = A * m + B * n + C * p;
        if (identifier == 0) {
            System.out.println("identifier is 0");
            return null;
        }
        double[] doubles = {A, B, C, D, E, F, m, n, p};
//        System.out.println(plane.point.Print());
//        System.out.println(point.Print());
//        System.out.println(Arrays.toString(doubles));
        z = -(A * F - p * D + B * E) / (identifier);
        if (p != 0) {
            System.out.println("1st");
            y = (E + n * z) / p;
            x = (F + m * z) / p;
        } else {
            System.out.println("2st");
            E = (m * point.z - p * point.x);
            F = (m * point.y - n * point.x);
            x = -(B * F - m * D + C * E) / (identifier);
            E = (n * point.x - m * point.y);
            F = (n * point.z - p * point.y);
            y = -(C * F - n * D + B * E) / (identifier);

        }

        return new Point(x, y, z);

    }

    public boolean pointOn(Point otherPoint) {
        if (otherPoint == null) {
            return false;
        }
        Direction otherDirVector =
                new Direction(point.x - otherPoint.x, point.y - otherPoint.y, point.z - otherPoint.z);
//        System.out.println(otherDirVector.toString() + ",, " + dirVector.toString());
//        System.out.println(otherPoint.toString());
//        System.out.println(toString());
        return (proxiSame(dirVector.A * otherDirVector.B, dirVector.B * otherDirVector.A)
                && proxiSame(dirVector.B * otherDirVector.C, dirVector.C * otherDirVector.B)
                && proxiSame(dirVector.A * otherDirVector.C, dirVector.C * otherDirVector.A));
    }

    public boolean proxiSame(Double a, Double b) {
        if (a <= 0.01 && b <= 0.01) {
            return true;
        } else return a / b < 1.01 && a / b > 0.99;
    }


    @Override
    public String toString() {
        return "Line( " + point.toString() + ", " + dirVector.toString() + " )";
    }

    public static void main(String[] Args) {
        Edge edge = new Edge(new Point(1, 1, 3), new Point(0, 1, 10));
        Line line = new Line(new Point(1, 1, 3), new Direction(10, -1, -1));
        Plane plane = new Plane(new Point(9.9, 0, 0), new Direction(-10, 0, 0));
        Point result = line.intersectWithPlane(plane);
        System.out.println(result.toString());
        Camera c1 = new Camera(new Point(10, 0, 0), 0.05, new Direction(-10, 0, 0));
        System.out.println(c1.toString());
        System.out.println(c1.getScreenTop());
        System.out.println(c1.getScreenLeft());
        System.out.println(c1.positionOnScreen(result));

    }


}
