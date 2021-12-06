package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

class ThirdQuadrant extends Quadrant {


    public ThirdQuadrant(double dir) {
        super(dir);
    }

    @Override
    double numeratorY(PointDouble pos,double width, double height){
        return height - pos.getY();
    }

    @Override
    double numeratorX(PointDouble pos,double width, double height){
        return 0 - pos.getX();
    }

    @Override
    public boolean isCorrectInterval(double dir){
        return (dir > 90 && dir <= 180);
    }


}
