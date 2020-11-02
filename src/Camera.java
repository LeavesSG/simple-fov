public class Camera {
    static Point center;
    static Double distance;
    static Direction direction;
    double width, height;

    Camera(Point center0, Double distance0, Direction direction0) {
        center = center0;
        distance = distance0;
        direction = direction0;
        width = 0.1366;
        height = 0.0768;
    }

    public Point getScreenCenter() {
        return center.moveTo(direction, distance);
    }

    public Plane getScreenPlane() {
        return new Plane(getScreenCenter(), direction);
    }

    public Line getScreenTop() {
        double C = direction.C == 0 ? 0 : (Math.pow(direction.A, 2) + Math.pow(direction.B, 2)) / direction.C;
//        System.out.println("getscreen!!!!!" + new Direction(direction.A, direction.B, C).toString());
        return new Line(getScreenCenter().moveTo(new Direction(direction.A, direction.B,
                C), height / 2),
                new Direction(direction.B, direction.A, 0));
    }

    public Line getScreenLeft() {
        double C = direction.C == 0 ? 0 : (Math.pow(direction.A, 2) + Math.pow(direction.B, 2)) / direction.C;
        return new Line(getScreenCenter().moveTo(new Direction(direction.B, direction.A, 0), width / 2),
                new Direction(direction.A, direction.B,
                        C));
    }

    public Point positionOnScreen(Point otherPoint) {
//        System.out.println("camera" + getScreenLeft().toString() + ", " + getScreenTop().toString());
        return new Point(otherPoint.distanceToLine(getScreenLeft()) * 1000 / 1920, otherPoint.distanceToLine(getScreenTop()) * 1000 / 1080, 0);
    }

    @Override
    public String toString() {
        return "Camera( " + center.toString() + ", " + getScreenPlane().toString() + " )";
    }

    public static void main(String[] args) {
        Camera c0 = new Camera(new Point(10, 0, 0), 0.5, new Direction(-1, 0, 0));
//        System.out.println(c0.getScreenTop().toString());
//        System.out.println(c0.getScreenLeft().toString());

    }
}
