package DistanceQuadrantHandler;

import HelperClasses.PointDouble;

abstract class Quadrant implements DistanceQuadrant{

    private double dir;

    public Quadrant(double dir){
        setDir(dir);
    }

    public void setDir(double dir){
        if (isCorrectInterval(dir))
            this.dir = dir;
        else
            throw new IllegalArgumentException("given angle is not in correct interval for quadrant");
    }

    public double getDistance(PointDouble pos, double width, double height){

        double sy = numeratorY(pos, width, height) / Math.sin(Math.toRadians(dir));
        double sx = numeratorX(pos, width, height) / Math.cos(Math.toRadians(dir));

        if (Double.isInfinite(sy)){
            return sx;
        }

        else if (Double.isInfinite(sx)){
            return sy;
        }

        else {
            return Math.min(sy, sx);
        }

    }

    abstract double numeratorY(PointDouble pos,double width, double height);

    abstract double numeratorX(PointDouble pos,double width, double height);

    public abstract boolean isCorrectInterval(double dir);



}
