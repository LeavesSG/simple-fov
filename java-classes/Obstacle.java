// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class to define an Obstacle

import java.awt.*;
import java.util.Arrays;

public class Obstacle {
    public Point center;
    public Face[] Faces;
    public Segment[] segments = {};
    public Point[] points = {};
    public Color color;
    public double SegmentWidth;
    SpaceVector accelerate = new SpaceVector(0, 0, 0);
    SpaceVector speed = new SpaceVector(0, 0, 0);

    Obstacle(Color Color) {
        color = Color;
    }

    // Please use this constructor!
    void defineFaces(Point center0, Face[] FaceList) {
        center = center0;
        Faces = FaceList;
        points = getPoints();
        segments = getSegments();
    }

    void defineSegments(Point center0, Segment[] SegmentList) {
        center = center0;
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

            positions[i] = camera.positionOnScreen(points[i].positionOnScreen(camera));
        }
        return positions;
    }

    public Segment[] renderSegmentsOnScreen(Camera camera) {
        Segment[] linesOnScreen = new Segment[segments.length];
        for (int i = 0; i < segments.length; i++) {
            if (!segments[i].point1.onSameSideWithP(camera.center, camera.getScreenPlane())
                    && !segments[i].point2.onSameSideWithP(camera.center, camera.getScreenPlane())) {
                linesOnScreen[i] = new Segment(camera.positionOnScreen(segments[i].point1.positionOnScreen(camera)),
                        camera.positionOnScreen(segments[i].point2.positionOnScreen(camera)));
            } else if (segments[i].point1.onSameSideWithP(camera.center, camera.getScreenPlane())
                    && segments[i].point2.onSameSideWithP(camera.center, camera.getScreenPlane())) {
                linesOnScreen[i] = null;
            } else if (segments[i].point1.onSameSideWithP(camera.center, camera.getScreenPlane())) {
                linesOnScreen[i] = new Segment(camera.positionOnScreen(new Segment(segments[i].point1, segments[i].point2).intersectWithPlane(camera.getScreenPlane())),
                        camera.positionOnScreen(segments[i].point2.positionOnScreen(camera)));
            } else {
                linesOnScreen[i] = new Segment(camera.positionOnScreen(segments[i].point1.positionOnScreen(camera)),
                        camera.positionOnScreen(new Segment(segments[i].point1, segments[i].point2).intersectWithPlane(camera.getScreenPlane())));
            }
        }
        return linesOnScreen;

    }


    // Give the point some accelerate;
    public void setAccelerate(SpaceVector accelerate0) {
        accelerate = accelerate0;
    }

    // Give the point some speed;
    public void setSpeed(SpaceVector speed0) {
        speed = speed0;
    }

    // Calculate the speed of this object in the next frame;
    public void newSpeed() {
        speed.add(accelerate);
    }

    // Calculate the new Position of this object in the next frame;
    public void newPos() {
        newSpeed();
        center.x += speed.x;
        center.y += speed.y;
        center.z += speed.z;
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
