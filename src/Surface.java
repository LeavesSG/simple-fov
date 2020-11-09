public class Surface extends Plane {
    public Point point1, point2, point3, point4;

    Surface(Point point_1, Point point_2, Point point_3, Point point_4) {
        super(point_1, new Direction(point_1.y * point_2.z - point_2.y * point_1.z,
                point_1.y * point_2.z - point_2.y * point_1.z, point_1.y * point_2.z - point_2.y * point_1.z));
        point1 = point_1;
        point2 = point_2;
        point3 = point_3;
        point4 = point_4;

    }

    public void moveTo(Direction direction, double distance) {
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
    }

    Point[] getPoints() {
        return new Point[]{point1, point2, point3, point4};
    }
}
