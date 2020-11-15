public class SpaceVector {
    public double x, y, z;

    SpaceVector(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public void set(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public void add(SpaceVector spacevector) {
        x += spacevector.x;
        y += spacevector.y;
        z += spacevector.z;
    }
}
