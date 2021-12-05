package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

class FirstQuadrant extends Quadrant implements DistanceQuadrantHandler{

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




}
