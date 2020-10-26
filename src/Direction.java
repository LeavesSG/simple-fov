public class Direction {
    double x, y, z;

    Direction(double x0, double y0, double z0) {
        x = x0;
        y = y0;
        z = z0;
    }

    String Print() {
        return "Vector(" + x + ',' + y + ',' + z + ')';
    }

    public static void main(String[] args) {
        System.out.print(new Direction(1, 1, 1).Print());
    }
}
