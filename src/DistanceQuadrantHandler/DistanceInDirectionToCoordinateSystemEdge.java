package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

public interface DistanceInDirectionToCoordinateSystemEdge {

    DistanceQuadrant[] distanceQuadrants = {new FirstQuadrant(315), new SecondQuadrant(225), new ThirdQuadrant(135), new FourthQuadrant(45)};

    static double getDistance(double dir, PointDouble pos, double width, double height){

        for (DistanceQuadrant distanceQuadrant : distanceQuadrants){
            if (distanceQuadrant.isCorrectInterval(dir)){
                distanceQuadrant.setDir(dir);
                return distanceQuadrant.getDistance(pos, width, height);
            }
        }

        throw new IllegalArgumentException("given angle is not in interval 0 <= angle <= 360" + " " + dir);

    }


}
