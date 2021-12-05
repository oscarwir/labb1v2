package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

public interface DistanceQuadrantHandler {

    double getDistance(PointDouble pos, double width, double height);

    static DistanceQuadrantHandler getDistanceQuadrant(double dir){


        if (dir > 0 && dir <= 90)
            return new FirstQuadrant(dir);

        else if (dir > 90 && dir <= 180)
            return new SecondQuadrant(dir);

        else if (dir > 180 && dir <= 270)
            return new ThirdQuadrant(dir);

        else if (dir > 270 && dir <= 360)
            return new FourthQuadrant(dir);

        else
            throw new IllegalArgumentException("given angle is not in interval 0 <= angle <= 360");
    }


}
