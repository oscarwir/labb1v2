package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

class FourthQuadrant extends Quadrant{
    public FourthQuadrant(double dir) {
        super(dir);
    }

    @Override
    double numeratorY(PointDouble pos,double width, double height){
        return height - pos.getY();
    }


    @Override
    double numeratorX(PointDouble pos,double width, double height){
        return width - pos.getX();
    }


}
