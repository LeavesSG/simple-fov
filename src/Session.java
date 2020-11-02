import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


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

    public static void loop() {

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
        for (Obstacle obs : obstacles) {
            System.out.println(Arrays.toString(obs.edges));
            Edge[] edges = obs.renderEdgesOnScreen(camera);

            drawEdges(edges);
        }
    }

    public static void drawEdges(Edge[] edges) {
        for (Edge edge : edges) {
            System.out.println(edge.point1.toString() + ", " + edge.point2.toString());
            StdDraw.line(edge.point1.x, edge.point1.y, edge.point2.x, edge.point2.y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Color[] colors = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.RED, StdDraw.GREEN, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.BLACK, StdDraw.BOOK_LIGHT_BLUE};
        Session.setupCamera(new Point(10, 0, 0), 0.2, new Direction(-10, 0, 0));
        System.out.println(Session.camera.toString());
        Point[] p1 = {new Point(1, 1, 1), new Point(1, 0, 0), new Point(2, 1, 0), new Point(1, 2, 0),
                new Point(0, 1, 0), new Point(1, 1, -1)};
        Edge[] e1 = {new Edge(new Point(1, 1, 4), new Point(1, -3, 0)), new Edge(new Point(1, 1, 4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, 4), new Point(1, 5, 0)), new Edge(new Point(1, 1, 4), new Point(-3, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, -3, 0)), new Edge(new Point(1, 1, -4), new Point(5, 1, 0)),
                new Edge(new Point(1, 1, -4), new Point(1, 5, 0)), new Edge(new Point(1, 1, -4), new Point(-3, 1, 0)),};
        Obstacle o1 = new Obstacle(e1);
        Session.addObstacle(o1);
//        Session.updateScreen();
        Edge[] edges = o1.renderEdgesOnScreen(camera);
//        System.out.println(Arrays.toString(edges));
        for (int i = 0; i < edges.length; i++) {
            StdDraw.setPenColor(colors[i]);
            StdDraw.line(edges[i].point1.x, edges[i].point1.y, edges[i].point2.x, edges[i].point2.y);
            TimeUnit.SECONDS.sleep(1);

        }


    }

}
