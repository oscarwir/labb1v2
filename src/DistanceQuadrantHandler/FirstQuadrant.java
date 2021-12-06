package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

class FirstQuadrant extends Quadrant {

    FirstQuadrant(double dir){
        super(dir);
    }

    @Override
    double numeratorY(PointDouble pos,double width, double height){
        return 0 - pos.getY();
    }

    @Override
    double numeratorX(PointDouble pos,double width, double height){
        return width - pos.getX();
    }

    @Override
    public boolean isCorrectInterval(double dir){
        return (dir > 270 && dir <= 360);
    }




}
