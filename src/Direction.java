public class Direction {
    double A, B, C;

    Direction(double x0, double y0, double z0) {
        A = x0;
        B = y0;
        C = z0;
    }

    @Override
    public String toString() {
        return "Vector(" + A + ',' + B + ',' + C + ')';
    }

    public static void main(String[] args) {
        System.out.print(new Direction(1, 1, 1).toString());
    }
}
