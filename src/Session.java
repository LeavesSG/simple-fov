import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;


public class Session {
    public static Obstacle[] obstacles = {};
    public static Camera camera;
    public static Segment[] currentframe = {};
    public static Segment[] lastframe = {};

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
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();

    }

    public static void updateScreen() {
        for (Obstacle obs : obstacles) {
            Segment[] Segments = obs.renderSegmentsOnScreen(camera);
            lastframe = currentframe;
            currentframe = Segments;
            StdDraw.setPenColor(obs.color);

            drawSegments(currentframe);
        }
    }

    public static void drawSegments(Segment[] Segments) {
        for (Segment Segment : Segments) {
            StdDraw.line(Segment.point1.x, Segment.point1.y, Segment.point2.x, Segment.point2.y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Color[] colors = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.RED, StdDraw.GREEN, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.PINK, StdDraw.BOOK_LIGHT_BLUE};
        Session.setupCamera(new Point(12, -20, 0), 0.5, new Direction(-9, 0, -0.5));
        System.out.println(Session.camera.toString());
        Point[] p1 = {new Point(1, 1, 1), new Point(1, 0, 0), new Point(2, 1, 0), new Point(1, 2, 0),
                new Point(0, 1, 0), new Point(1, 1, -1)};
        Segment[] e1 = {new Segment(new Point(1, 1, 4), new Point(1, -3, 0)), new Segment(new Point(1, 1, 4), new Point(5, 1, 0)),
                new Segment(new Point(1, 1, 4), new Point(1, 5, 0)), new Segment(new Point(1, 1, 4), new Point(-3, 1, 0)),
                new Segment(new Point(1, 1, -4), new Point(1, -3, 0)), new Segment(new Point(1, 1, -4), new Point(5, 1, 0)),
                new Segment(new Point(1, 1, -4), new Point(1, 5, 0)), new Segment(new Point(1, 1, -4), new Point(-3, 1, 0)),
                new Segment(new Point(1, -3, 0), new Point(5, 1, 0)), new Segment(new Point(1, 5, 0), new Point(-3, 1, 0)),
                new Segment(new Point(1, -3, 0), new Point(-3, 1, 0)), new Segment(new Point(5, 1, 0), new Point(1, 5, 0)),
        };
        Obstacle o1 = new Obstacle(StdDraw.BLUE);
        o1.defineSegments(e1);
        Obstacle axes = new Obstacle(StdDraw.BLACK);
        axes.defineSegments(new Segment[]{new Segment(new Point(0, 0, 0), new Point(10, 0, 0)),
                new Segment(new Point(0, 0, 0), new Point(0, 10, 0)), new Segment(new Point(0, 0, 0), new Point(0, 0, 10))});
//        Session.addObstacle(o1);
        Session.addObstacle(axes);
        Point center = new Point(0, -20, 0);
        while (center.y < 20) {
            int length = Math.random() > 0.5 ? 1 : 2;
            double width = Math.floor(Math.random() * 4) + 1;
            double height = Math.floor(Math.random() * 10) + 1;
            Color color = colors[(int) Math.floor(Math.random() * 8)];
            Session.addObstacle(new Cuboid(new Point(center.x - width / 2, center.y, center.z + height / 2), width, length, height, color));
            center.y += length + 2;
        }
        int i = 0;
        do {
            i++;
            Session.loop();
            System.out.println(i);
        } while (i < 10000);

    }


}

