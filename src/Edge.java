public class Edge extends Line {
    Point point1, point2;
    Direction direction;

    Edge(Point point_1, Point point_2) {
        super(point_1, new Direction(point_2.x - point_1.x, point_2.y - point_1.y, point_2.z - point_1.z));
        direction = new Direction(point_2.x - point_1.x, point_2.y - point_1.y, point_2.z - point_1.z);
        point1 = point_1;
        point2 = point_2;

    }

    public Direction getDirVector() {
        return new Direction(point1.x - point2.x, point1.y - point2.y, point1.z - point2.z);
    }

    public Point getMiddlePoint() {
        return new Point((point2.x + point1.x) / 2, (point2.y + point1.y) / 2, (point2.z + point1.z) / 2);
    }


    @Override
    public boolean pointOn(Point otherPoint) {
        if (!super.pointOn(otherPoint)) {
            return false;
        } else {
            if (otherPoint.x > (Math.max(point1.x, point2.x))) {
                return false;
            }
            if (otherPoint.x < (Math.min(point1.x, point2.x))) {
                return false;
            }
            if (otherPoint.y > (Math.max(point1.y, point2.y))) {
                return false;
            }
            if (otherPoint.y < (Math.min(point1.y, point2.y))) {
                return false;
            }
            if (otherPoint.z > (Math.max(point1.z, point2.z))) {
                return false;
            }
            return !(point.z < (Math.min(point1.z, point2.z)));


        }
    }

    public Point intersectWithPlane(Plane plane) {
//        System.out.println(pointOn(super.intersectWithPlane(plane)));
        return pointOn(super.intersectWithPlane(plane)) ? super.intersectWithPlane(plane) : null;

    }

    @Override
    public String toString() {
        return "Edge( " + point1.toString() + ", " + point2.toString() + " )";
    }

    public static void main(String[] args) {
//        Point point1 = new Point(0, 0, 0);
//        Point point2 = new Point(1, 1, 1);
//        System.out.print(new Edge(point1, point2).getDirVector().Print());
//        System.out.print(new Edge(point1, point2).getMiddlePoint().Print());
        Edge line = new Edge(new Point(0, 0, 5), new Point(0, 0, -1));
        Plane plane = new Plane(new Point(0, 0, 0), new Direction(0, 0, 4));
        Point result = line.intersectWithPlane(plane);
        System.out.print(result.toString());

    }

}
