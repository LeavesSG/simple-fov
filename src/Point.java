public class Point {
    double x, y, z;

    Point(double x0, double y0, double z0) {
        x = x0;
        y = y0;
        z = z0;
    }

    public double distanceBetween(Point point2) {
        return Math.sqrt(Math.pow(x - point2.x, 2) + Math.pow(y - point2.y, 2) + Math.pow(z - point2.z, 2));
    }


    boolean isSame(Point point2) {
        return x == point2.x && y == point2.y && z == point2.z;
    }

    public double distanceToLine(Line line) {
        return 0.0;
    }

    public Point moveTo(Direction direction, double distance) {
        double commonFactor = distance * Math.sqrt(
                Math.pow(direction.A, 2) + Math.pow(direction.B, 2) + Math.pow(direction.C, 2));

        return new Point(x + commonFactor * direction.A, y + commonFactor * direction.B, z + commonFactor * direction.C);
    }

    public Point positionOnScreen(Camera camera) {
        Edge lightRoute = new Edge(this, Camera.center);
        return lightRoute.intersectWithPlane(camera.getScreenPlane());


    }

    @Override
    public String toString() {
        return "Point(" + x + ',' + y + ',' + z + ')';
    }

    public static void main(String[] args) {
        System.out.print(new Point(0, 0, 0).distanceBetween(new Point(1, 1, 1)));
    }

}
