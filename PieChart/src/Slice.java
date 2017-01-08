import java.util.Random;

/**
 * Created by alex on 18.12.16.
 */
public class Slice extends Circle {

    private double value;
    private double startAngle = 0;
    private double arcAngle = 360;

    public Slice(double value) {
        super();
        this.value = value;
    }

    public Slice() {
        super(350);
//        Random rnd = new Random();
//        value = rnd.nextInt(50) + 50;

    }

    public double getValue() {
        return value;
    }

    public double getStartAngle() {
        return startAngle;
    }

    public double getArcAngle() {
        return arcAngle;
    }

    public void setStartAngle(double startAngle) {
        this.startAngle = startAngle;
    }

    public void setArcAngle(double arcAngle) {
        this.arcAngle = arcAngle;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
