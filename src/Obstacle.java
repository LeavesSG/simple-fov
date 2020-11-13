// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class to define an Obstacle

import java.awt.*;
import java.util.Arrays;

public class Obstacle {
    public Face[] Faces;
    public Segment[] segments = {};
    public Point[] points = {};
    public Color color;
    public double SegmentWidth;

    Obstacle(Color Color) {
        color = Color;
    }

    void defineFaces(Face[] FaceList) {
        Faces = FaceList;
        points = getPoints();
        segments = getSegments();
    }

    void defineSegments(Segment[] SegmentList) {
        segments = SegmentList;
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

    private void singlePushCheck(Segment item, Segment[] list) {
        int N = list.length;
        if (N == 0) {
            Segment[] newList = Arrays.copyOf(list, N + 1);
            newList[N] = item;
            segments = newList;
        } else {
            boolean inList = false;
            for (Segment t : list) {
                if (item.isSame(t)) {
                    inList = true;
                    break;
                }
            }
            if (!inList) {
                segments = Arrays.copyOf(list, N + 1);
                segments[N] = item;
            }
        }
    }

    public void pushItems(Point[] itemList) {
        for (Point point : itemList) {
            singlePushCheck(point, points);
        }
    }

    public void pushItems(Segment[] itemList) {
        for (Segment Segment : itemList) {
            singlePushCheck(Segment, segments);
        }
    }

    public Point[] getPoints() {
        for (Face s0 : Faces) {
            pushItems(s0.getPoints());
        }
        return points;
    }

    public Segment[] getSegments() {
        for (Face s0 : Faces) {
            pushItems(s0.getSegments());
        }
        return segments;
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

    public Segment[] renderSegmentsOnScreen(Camera camera) {
        Segment[] linesOnScreen = new Segment[segments.length];
        for (int i = 0; i < segments.length; i++) {
//            System.out.println("OBS" + camera.positionOnScreen(Segments[i].point2.positionOnScreen(camera)));
            linesOnScreen[i] = new Segment(camera.positionOnScreen(segments[i].point1.positionOnScreen(camera)), camera.positionOnScreen(segments[i].point2.positionOnScreen(camera)));
        }
        return linesOnScreen;
    }

    public static void main(String[] args) {
//        Face s1 = new Face(new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0), new Point(0, 1, 0));
//        Face s2 = new Face(new Point(1, 1, 1), new Point(1, 1, 2), new Point(1, 2, 2), new Point(1, 2, 1));
//        Face[] Faces = {s1, s2};
//        Obstacle o1 = new Obstacle(Faces);
//        Camera c1 = new Camera(new Point(10, 0, 0), 0.1, new Direction(-1, 0, 0));
//        System.out.println(Arrays.toString(o1.renderOnScreen(c1)));

    }


}
