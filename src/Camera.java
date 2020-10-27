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
        double commonFactor = distance * Math.sqrt((Math.pow(direction.A, 2) + Math.pow(direction.B, 2) + Math.pow(direction.C, 2))
                / Math.pow(direction.A, 2));

        return new Point(commonFactor, commonFactor * direction.B / direction.A, commonFactor * direction.C / direction.A);
    }

    public Plane getScreenPlane() {
        return new Plane(getScreenCenter(), direction);
    }

    public static void main(String[] args) {
        Camera c0 = new Camera(new Point(0, 0, 0), 2.0, new Direction(1, 1, 0));
        System.out.print(c0.getScreenCenter().Print());

    }
}
