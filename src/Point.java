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

    String Print() {
        return "Point(" + x + ',' + y + ',' + z + ')';
    }

    boolean isSame(Point point2) {
        return x == point2.x && y == point2.y && z == point2.z;
    }

    public Edge lightRoute(Camera camera) {
        return new Edge(this, Camera.center);
    }

    public static void main(String[] args) {
        System.out.print(new Point(0, 0, 0).distanceBetween(new Point(1, 1, 1)));
    }
    
}
