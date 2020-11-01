public class Camera {
    static Point center;
    static Double distance;
    static Direction direction;

    Camera(Point center0, Double distance0, Direction direction0) {
        center = center0;
        distance = distance0;
        direction = direction0;
        double width = 0.1920;
        double height = 0.1080;
    }

    public Point getScreenCenter() {
        return center.moveTo(direction, distance);
    }

    public Plane getScreenPlane() {
        return new Plane(getScreenCenter(), direction);
    }

//    public Line getScreenTop() {
//        return new Line(center, direction);
//    }
//
//    public Line getScreenLeft() {
//        return new Line(center, direction);
//    }

    public static void main(String[] args) {
        Camera c0 = new Camera(new Point(0, 0, 0), 2.0, new Direction(1, 1, 0));
        System.out.print(c0.getScreenCenter().Print());

    }
}
