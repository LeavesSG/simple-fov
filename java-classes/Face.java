// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class to define a face in 3-dim space.

public final class Face extends Plane {
    public Point point1, point2, point3, point4;
    public Segment[] segments;

    Face(Point point_1, Point point_2, Point point_3, Point point_4) {
        super(point_1, new Direction(point_1.y * point_2.z - point_2.y * point_1.z,
                point_1.y * point_2.z - point_2.y * point_1.z, point_1.y * point_2.z - point_2.y * point_1.z));
        point1 = point_1;
        point2 = point_2;
        point3 = point_3;
        point4 = point_4;
        segments = new Segment[]{new Segment(point1, point2), new Segment(point2, point3), new Segment(point3, point4), new Segment(point4, point1)};

    }

    // Move the space towards some direction by some distance;
    public void moveTo(Direction direction, double distance) {
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
        point1.moveTo(direction, distance);
    }

    // Return the 4 points that form the space.
    Point[] getPoints() {
        return new Point[]{point1, point2, point3, point4};
    }

    Segment[] getSegments() {
        return segments;
    }
}
