public class Plane {
    public Point point;
    public Direction normalVector;

    Plane(Point Point, Direction NormalVector) {
        point = Point;
        normalVector = NormalVector;
    }

    public void moveTo(Direction direction, double distance) {
        point.moveTo(direction, distance);
    }

    @Override
    public String toString() {
        return "Plane( " + point.toString() + ", " + normalVector.toString() + ')';
    }

    public static void main(String[] args) {
        Plane p1 = new Plane(new Point(0, 0, 0), new Direction(1, 1, 1));
        System.out.println(p1.toString());
    }
}
