public class TruckPlatform {

    private double angle;
    private double angleStep = 1.0;
    private double[] interval;

    public TruckPlatform(double topRange, double botRange, double angleStep){
        interval = new double[] {topRange, botRange};
        this.angleStep = angleStep;
        angle = 0;
    }


}
