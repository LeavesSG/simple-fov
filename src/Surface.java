public class Surface {
    public Point point1, point2, point3, point4;

    Surface(Point point_1, Point point_2, Point point_3, Point point_4) {
        this.point1 = point_1;
        this.point2 = point_2;
        this.point3 = point_3;
        this.point4 = point_4;
    }

    Point[] getPoints() {
        return new Point[]{point1, point2, point3, point4};
    }
}
