import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;


public class Session {
    public static Obstacle[] obstacles = {};
    public static Camera camera;
    public static Edge[] currentframe = {};
    public static Edge[] lastframe = {};

    public static void setupCamera(Point center, double distance, Direction direction) {
        camera = new Camera(center, distance, direction);
        initCanvas();
    }

    public static void start() {

    }

    public static void stop() {

    }

    public static void loop() throws InterruptedException {
        StdDraw.clear();
        updateScreen();
        StdDraw.show();
        camera.moveTo(new Direction(2, 10, 2), 0.1);
        StdDraw.pause(20);

    }

    public static void addObstacle(Obstacle obs) {
        int N = obstacles.length;
        Obstacle[] newList = Arrays.copyOf(obstacles, N + 1);
        newList[N] = obs;
        obstacles = newList;

    }

    public static void initCanvas() {
        StdDraw.setPenRadius(0.0025);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();

    }

    public static void updateScreen() {
        for (Obstacle obs : obstacles) {
            Edge[] edges = obs.renderEdgesOnScreen(camera);
            lastframe = currentframe;
            currentframe = edges;

            drawEdges(currentframe);
        }
    }

    public static void drawEdges(Edge[] edges) {
        for (Edge edge : edges) {
            StdDraw.line(edge.point1.x, edge.point1.y, edge.point2.x, edge.point2.y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Color[] colors = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.RED, StdDraw.GREEN, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.BLACK, StdDraw.BOOK_LIGHT_BLUE};
        Session.setupCamera(new Point(12, -5, 0), 0.5, new Direction(-9, 0, -0.5));
        System.out.println(Session.camera.toString());
        Point[] p1 = {new Point(1, 1, 1), new Point(1, 0, 0), new Point(2, 1, 0), new Point(1, 2, 0),
                new Point(0, 1, 0), new Point(1, 1, -1)};
        Edge[] e1 = {new Edge(new Point(1, 1, 4), new Point(1, -3, 0)), new Edge(new Point(1, 1, 4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, 4), new Point(1, 5, 0)), new Edge(new Point(1, 1, 4), new Point(-3, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, -3, 0)), new Edge(new Point(1, 1, -4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, 5, 0)), new Edge(new Point(1, 1, -4), new Point(-3, 1, 0)),
                new Edge(new Point(1, -3, 0), new Point(5, 1, 0)), new Edge(new Point(1, 5, 0), new Point(-3, 1, 0)),
                new Edge(new Point(1, -3, 0), new Point(-3, 1, 0)), new Edge(new Point(5, 1, 0), new Point(1, 5, 0)),
        };
        Obstacle o1 = new Obstacle(e1);
        Obstacle axices = new Obstacle(new Edge[]{new Edge(new Point(0, 0, 0), new Point(10, 0, 0)),
                new Edge(new Point(0, 0, 0), new Point(0, 10, 0)), new Edge(new Point(0, 0, 0), new Point(0, 0, 10))});
        Session.addObstacle(o1);
        Session.addObstacle(axices);
        int i = 0;
        do {
            i++;
            Session.loop();
            System.out.println(i);
        } while (i < 10000);

    }


}

