import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;

public class Cuboid extends Obstacle {
    Point center;
    Point[] points;
    Surface[] surfaces;

    double length, width, height;
    Surface topS, botS, leftS, rightS, frontS, backS;
    Point topleftfrontP, toprightfrontP, topleftbackP, toprightbackP, botleftfrontP, botrightfrontP, botleftbackP, botrightbackP;

    Cuboid(Point Center, double Length, double Width, double Height, Color Color) {
        super(Color);
        initPoints(Center, Length, Width, Height);
        getSurfaceList();
        defineSurfaces(surfaces);
    }

    void getSurfaceList() {

        topS = new Surface(points[0], points[1], points[3], points[2]);
        botS = new Surface(points[4], points[5], points[7], points[6]);
        leftS = new Surface(points[0], points[2], points[6], points[4]);
        rightS = new Surface(points[1], points[3], points[7], points[5]);
        frontS = new Surface(points[0], points[1], points[3], points[2]);
        backS = new Surface(points[4], points[5], points[7], points[6]);
        surfaces = new Surface[]{topS, botS, leftS, rightS, frontS, backS};
    }

    private void initPoints(Point Center, double Length, double Width, double Height) {
        center = Center;
        length = Length;
        width = Width;
        height = Height;
        topleftfrontP = new Point(center.x - length / 2, center.y - width / 2, center.z + height / 2);
        toprightfrontP = new Point(center.x + length / 2, center.y - width / 2, center.z + height / 2);
        topleftbackP = new Point(center.x - length / 2, center.y + width / 2, center.z + height / 2);
        toprightbackP = new Point(center.x + length / 2, center.y + width / 2, center.z + height / 2);
        botleftfrontP = new Point(center.x - length / 2, center.y - width / 2, center.z - height / 2);
        botrightfrontP = new Point(center.x + length / 2, center.y - width / 2, center.z - height / 2);
        botleftbackP = new Point(center.x - length / 2, center.y + width / 2, center.z - height / 2);
        botrightbackP = new Point(center.x + length / 2, center.y + width / 2, center.z - height / 2);
        points = new Point[]{topleftfrontP, toprightfrontP, topleftbackP, toprightbackP,
                botleftfrontP, botrightfrontP, botleftbackP, botrightbackP};
    }

    public static void main(String[] args) {
        Cuboid c1 = new Cuboid(new Point(0, 0, 0), 4, 4, 4, StdDraw.BLACK);
        System.out.println(Arrays.toString(c1.edges));
    }
}
