// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is a class to define the vector in 3-dim space.

public final class Direction {
    double A, B, C, module;

    Direction(double x0, double y0, double z0) {
        normalization(x0, y0, z0);
    }

    // Normalize the Vector to make sure the module is always 1.
    private void normalization(double x0, double y0, double z0) {
        module = Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2) + Math.pow(z0, 2));
        A = x0 / module;
        B = y0 / module;
        C = z0 / module;
    }

    @Override
    public String toString() {
        return "Vector(" + A + ',' + B + ',' + C + ')';
    }

    public static void main(String[] args) {
        System.out.print(new Direction(1, 1, 1).toString());
    }
}
