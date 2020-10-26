public class Camera {
    Point center;
    Double distance;
    Direction direction;

    Camera(Point center0, Double distance0, Direction direction0) {
        center = center0;
        distance = distance0;
        direction = direction0;
        double width = 0.1920;
        double height = 0.1080;
    }
}
