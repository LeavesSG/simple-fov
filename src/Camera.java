// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This the the class that define the "Camera", which is point of this "one point perspective" system.

public final class Camera {
    Point center;
    Double distance;
    Direction direction;
    double width, height;

    // Point center0: the center of the camera;
    // Double distance0: the distance between the perspective center and the screen.
    // Direction direction0: the direction which the camera is facing. Probably better if using matrix.
    Camera(Point center0, Double distance0, Direction direction0) {
        center = center0;
        distance = distance0;
        direction = direction0;
        width = 0.1920;
        height = 0.1080;
    }

    // Get the center point of the Screen surface.
    public Point getScreenCenter() {
        return center.getNewPos(direction, distance);
    }

    // Get the Plane object of Screen.
    public Plane getScreenPlane() {
        return new Plane(getScreenCenter(), direction);
    }

    // Get the Line object of top edge of the screen.(might not be used)
    public Line getScreenTop() {
        double C = direction.C == 0 ? 0 : -(Math.pow(direction.A, 2) + Math.pow(direction.B, 2)) / direction.C;
        return new Line(getScreenCenter().getNewPos(new Direction(direction.A, direction.B,
                C), height / 2),
                new Direction(-direction.B, direction.A, 0));
    }

    // Get the Line object of the left edge of the screen.(might not be used)
    public Line getScreenLeft() {
        double C = direction.C == 0 ? 0 : (Math.pow(direction.A, 2) + Math.pow(direction.B, 2)) / -direction.C;
        return new Line(getScreenCenter().getNewPos(new Direction(-direction.B, direction.A, 0), width / 2),
                new Direction(direction.A, direction.B,
                        C));
    }

    // Instantly move the camera center towards a certain direction by a certain distance.
    public void moveTo(Direction direction, double distance) {
        center.moveTo(direction, distance);
    }

    // Return the Transforming Matrix from Normal axes to the camera axes.
    private double[][] getTransformMatrix() {
        double A = direction.A;
        double A2 = Math.pow(A, 2);
        double B = direction.B;
        double B2 = Math.pow(B, 2);
        double C = direction.C;
        double C2 = Math.pow(C, 2);
        double K1 = Math.sqrt((A2 + B2) * (A2 + B2 + C2));
        double K2 = Math.sqrt(A2 + B2);
        double K3 = Math.sqrt(A2 + B2 + C2);
        double[] matrix1 = new double[]{-A * C / K1, -B * C / K1, (A2 + B2) / K1};
        double[] matrix2 = new double[]{-B / K2, A / K2, 0};
        double[] matrix3 = new double[]{A / K3, B / K3, C / K3};
        return new double[][]{matrix1, matrix2, matrix3};
    }

    // Calculate a projection of other point on the Screen.
    public Point positionOnScreen(Point otherPoint) {
        double[][] matrix = getTransformMatrix();
        double x0 = otherPoint.x - getScreenCenter().x;
        double y0 = otherPoint.y - getScreenCenter().y;
        double z0 = otherPoint.z - getScreenCenter().z;
        double y1 = matrix[0][0] * x0 + matrix[0][1] * y0 + matrix[0][2] * z0 + 0.5;
        double x1 = matrix[1][0] * x0 + matrix[1][1] * y0 + matrix[1][2] * z0 + 0.5;
        double z1 = matrix[2][0] * x0 + matrix[2][1] * y0 + matrix[2][2] * z0;
        return new Point(x1, y1, z1);
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
