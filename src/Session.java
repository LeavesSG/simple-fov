import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;


public class Session {
    public static Obstacle[] obstacles = {};
    public static Camera camera;

    public static void setupCamera(Point center, double distance, Direction direction) {
        camera = new Camera(center, distance, direction);
        initCanvas();
    }

    public static void start() {

    }

    public static void stop() {

    }

    public static void loop() throws InterruptedException {

        updateScreen();
        camera.moveTo(new Direction(1, 10, 2), 0.1);
        Thread.sleep(20);

    }

    public static void addObstacle(Obstacle obs) {
        int N = obstacles.length;
        Obstacle[] newList = Arrays.copyOf(obstacles, N + 1);
        newList[N] = obs;
        obstacles = newList;

    }

    public static void initCanvas() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);

    }

    public static void updateScreen() {
        StdDraw.clear();
        for (Obstacle obs : obstacles) {
            Edge[] edges = obs.renderEdgesOnScreen(camera);

            drawEdges(edges);
        }
    }

    public static void drawEdges(Edge[] edges) {
        for (Edge edge : edges) {
            StdDraw.line(edge.point1.x, edge.point1.y, edge.point2.x, edge.point2.y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Color[] colors = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.RED, StdDraw.GREEN, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.BLACK, StdDraw.BOOK_LIGHT_BLUE};
        Session.setupCamera(new Point(10, -2, -2), 0.5, new Direction(-9, 0, -0.5));
        System.out.println(Session.camera.toString());
        Point[] p1 = {new Point(1, 1, 1), new Point(1, 0, 0), new Point(2, 1, 0), new Point(1, 2, 0),
                new Point(0, 1, 0), new Point(1, 1, -1)};
        Edge[] e1 = {new Edge(new Point(1, 1, 4), new Point(1, -3, 0)), new Edge(new Point(1, 1, 4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, 4), new Point(1, 5, 0)), new Edge(new Point(1, 1, 4), new Point(-3, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, -3, 0)), new Edge(new Point(1, 1, -4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, 5, 0)), new Edge(new Point(1, 1, -4), new Point(-3, 1, 0)),
                new Edge(new Point(1, -3, 0), new Point(5, 1, 0)), new Edge(new Point(1, 5, 0), new Point(-3, 1, 0)),
                new Edge(new Point(1, -3, 0), new Point(-3, 1, 0)), new Edge(new Point(5, 1, 0), new Point(1, 5, 0)),};
        Obstacle o1 = new Obstacle(e1);
        Session.addObstacle(o1);

        for (int i = 0; i < 1000; i++) {
            Session.loop();
            System.out.println(i);
        }

    }


}

