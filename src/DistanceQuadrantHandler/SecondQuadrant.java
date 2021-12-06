package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

class SecondQuadrant extends Quadrant {

    SecondQuadrant(double dir){
        super(dir);
    }

    @Override
    double numeratorY(PointDouble pos,double width, double height){
        return 0 - pos.getY();
    }

    @Override
    double numeratorX(PointDouble pos,double width, double height){
        return 0 - pos.getX();
    }

    @Override
    public boolean isCorrectInterval(double dir){
        return (dir > 180 && dir <= 270);
    }



}
