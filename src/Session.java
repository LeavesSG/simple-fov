import java.util.Arrays;

public class Session {
    public static Obstacle[] obstacles;
    public static Camera camera;

    public static void setupCamera(Point center, double distance, Direction direction) {
        camera = new Camera(center, distance, direction);
    }

    public static void start() {

    }

    public static void stop() {

    }

    public static void loop() {

    }

    public static void addObstacle(Obstacle obs) {
        int N = obstacles.length;
        Obstacle[] newList = Arrays.copyOf(obstacles, N + 1);
        newList[N] = obs;
        obstacles = newList;
        
    }

}
