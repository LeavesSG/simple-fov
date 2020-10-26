import java.util.Arrays;

public class Obstacle {
    public Surface[] surfaces;
    public Edge[] edges = {};
    public Point[] points = {};

    Obstacle(Surface[] surfaceList) {
        surfaces = surfaceList;
        System.out.print(Arrays.toString(points));

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

    public void pushItems(Point[] itemList) {
        for (Point point : itemList) {
            singlePushCheck(point, points);
        }
    }

    public Point[] getPoints() {
        for (Surface s0 : surfaces) {
            pushItems(s0.getPoints());
        }
        return points;
    }

    public static void main(String[] args) {
        Surface s1 = new Surface(new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0), new Point(0, 1, 0));
        Surface[] slist = {s1};
        Obstacle o1 = new Obstacle(slist);
        System.out.print(Arrays.toString(o1.getPoints()));

    }


}
