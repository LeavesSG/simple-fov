import java.awt.*;
import java.util.Arrays;

public class Obstacle {
    public Surface[] surfaces;
    public Edge[] edges = {};
    public Point[] points = {};
    public Color color;
    public double edgeWidth;

    Obstacle(Color Color) {
        color = Color;
    }

    void defineSurfaces(Surface[] surfaceList) {
        surfaces = surfaceList;
        points = getPoints();
        edges = getEdges();
    }

    void defineEdges(Edge[] edgeList) {
        edges = edgeList;
    }


    private void singlePushCheck(Point item, Point[] list) {
        int N = list.length;
        if (N == 0) {
            Point[] newList = Arrays.copyOf(list, N + 1);
            newList[N] = item;
            points = newList;
        } else {
            boolean inList = false;
            for (Point t : list) {
                if (item.isSame(t)) {
                    inList = true;
                    break;
                }
            }
            if (!inList) {
                points = Arrays.copyOf(list, N + 1);
                points[N] = item;
            }
        }
    }

    private void singlePushCheck(Edge item, Edge[] list) {
        int N = list.length;
        if (N == 0) {
            Edge[] newList = Arrays.copyOf(list, N + 1);
            newList[N] = item;
            edges = newList;
        } else {
            boolean inList = false;
            for (Edge t : list) {
                if (item.isSame(t)) {
                    inList = true;
                    break;
                }
            }
            if (!inList) {
                edges = Arrays.copyOf(list, N + 1);
                edges[N] = item;
            }
        }
    }

    public void pushItems(Point[] itemList) {
        for (Point point : itemList) {
            singlePushCheck(point, points);
        }
    }

    public void pushItems(Edge[] itemList) {
        for (Edge edge : itemList) {
            singlePushCheck(edge, edges);
        }
    }

    public Point[] getPoints() {
        for (Surface s0 : surfaces) {
            pushItems(s0.getPoints());
        }
        return points;
    }

    public Edge[] getEdges() {
        for (Surface s0 : surfaces) {
            pushItems(s0.getEdges());
        }
        return edges;
    }

    public Point[] renderOnScreen(Camera camera) {
        Point[] positions = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
//            System.out.println(i);
//            System.out.println(points[i].positionOnScreen(camera));
            positions[i] = camera.positionOnScreen(points[i].positionOnScreen(camera));
        }
        return positions;
    }

    public Edge[] renderEdgesOnScreen(Camera camera) {
        Edge[] linesOnScreen = new Edge[edges.length];
        for (int i = 0; i < edges.length; i++) {
//            System.out.println("OBS" + camera.positionOnScreen(edges[i].point2.positionOnScreen(camera)));
            linesOnScreen[i] = new Edge(camera.positionOnScreen(edges[i].point1.positionOnScreen(camera)), camera.positionOnScreen(edges[i].point2.positionOnScreen(camera)));
        }
        return linesOnScreen;
    }

    public static void main(String[] args) {
//        Surface s1 = new Surface(new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0), new Point(0, 1, 0));
//        Surface s2 = new Surface(new Point(1, 1, 1), new Point(1, 1, 2), new Point(1, 2, 2), new Point(1, 2, 1));
//        Surface[] surfaces = {s1, s2};
//        Obstacle o1 = new Obstacle(surfaces);
//        Camera c1 = new Camera(new Point(10, 0, 0), 0.1, new Direction(-1, 0, 0));
//        System.out.println(Arrays.toString(o1.renderOnScreen(c1)));

    }


}
