package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

interface DistanceQuadrant {

    double getDistance(PointDouble pos, double width, double height);

    void setDir(double dir);

    boolean isCorrectInterval(double dir);

}
