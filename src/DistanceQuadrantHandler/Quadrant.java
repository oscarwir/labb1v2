package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

abstract class Quadrant implements DistanceQuadrantHandler{

    double dir;

    public Quadrant(double dir){
        this.dir = dir;
    }

    public double getDistance(PointDouble pos, double width, double height){

        double sy;
        double sx;

        try {
            sy = numeratorY(pos, width, height) / Math.sin(Math.toRadians(dir));
        }

        catch (ArithmeticException e){
            return numeratorX(pos, width, height)/(Math.cos(Math.toRadians(dir)));
        }

        try {
            sx = numeratorX(pos, width, height)/(Math.cos(Math.toRadians(dir)));
        }

        catch (ArithmeticException e){
            return numeratorY(pos, width, height) / Math.sin(Math.toRadians(dir));
        }

        return Math.min(sy, sx);

    }

    abstract double numeratorY(PointDouble pos,double width, double height);


    abstract double numeratorX(PointDouble pos,double width, double height);



}
