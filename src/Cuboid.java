// Project simple-fov by Natsuha_SG;
// Github: https://github.com/LeavesSG/simple-fov;
// This is the class to define a cuboid.

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;

public class Cuboid extends Obstacle {
    Point center;
    Point[] points;
    Face[] Faces;

    double length, width, height;
    Face topS, botS, leftS, rightS, frontS, backS;
    Point topleftfrontP, toprightfrontP, topleftbackP, toprightbackP, botleftfrontP, botrightfrontP, botleftbackP, botrightbackP;

    // Point Center: center of the cuboid;
    Cuboid(Point Center, double Length, double Width, double Height, Color Color) {
        super(Color);
        initPoints(Center, Length, Width, Height);
        getFaceList();
        defineFaces(Faces);
    }

    // Initialize the 6 Faces of the cuboid.
    void getFaceList() {

        topS = new Face(points[0], points[1], points[3], points[2]);
        botS = new Face(points[4], points[5], points[7], points[6]);
        leftS = new Face(points[0], points[2], points[6], points[4]);
        rightS = new Face(points[1], points[3], points[7], points[5]);
        frontS = new Face(points[0], points[1], points[3], points[2]);
        backS = new Face(points[4], points[5], points[7], points[6]);
        Faces = new Face[]{topS, botS, leftS, rightS, frontS, backS};
    }

    // Initialize the 8 points of a cuboid.
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
        System.out.println(Arrays.toString(c1.segments));
    }
}
