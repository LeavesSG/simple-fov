public class Edge {
    Point point1, point2;

    Edge(Point point_1, Point point_2) {
        point1 = point_1;
        point2 = point_2;
    }

    public Direction getDirVector() {
        return new Direction(point1.x - point2.x, point1.y - point2.y, point1.z - point2.z);
    }

    public Point getMiddlePoint() {
        return new Point((point2.x + point1.x) / 2, (point2.y + point1.y) / 2, (point2.z + point1.z) / 2);
    }

    public static void main(String[] args) {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(1, 1, 1);
        System.out.print(new Edge(point1, point2).getDirVector().Print());
        System.out.print(new Edge(point1, point2).getMiddlePoint().Print());

    }

}
