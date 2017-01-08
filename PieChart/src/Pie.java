import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alex on 18.12.16.
 */
public class Pie extends Slice {

    private int x, y;
    private double total = 0.0D;
    private double curValue;
    private ArrayList<Slice> slices = new ArrayList<Slice>();

    public Pie(int x, int y) {
        this.x = x;
        this.y = y;
//        slices.add(new Slice(50));
//        setTotal(getValue());
    }

    public double getTotal() {
        return total;
    }

    public double getValue(int i) {
        return slices.get(i).getValue();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getStartAngle(int i) {
        return slices.get(i).getStartAngle();
    }

    public double getArcAngle(int i) {
        return slices.get(i).getArcAngle();
    }

    public int getSize() {
        return slices.size();
    }

    public Color getColor(int i) {
        return slices.get(i).getColor();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void addSlice() {
        Random rnd = new Random();
        slices.add(new Slice(rnd.nextInt(50) + 50));
        setTotal(getTotal() + slices.get(getSize() - 1).getValue());
        setAngles();
    }

    public void removeSlice() {
        if(!slices.isEmpty()) {
            setTotal(getTotal() - slices.get(getSize() - 1).getValue());
            slices.remove(getSize() - 1);
        }
        setAngles();
    }

    public void clearPie() {
        setTotal(0);
        slices.clear();
        setAngles();
    }

    public void setAngles() {

        for (int i = 0; i < getSize(); i++) {
//            setTotal(getTotal() + slices.get(getSize() - 1).getValue());
            slices.get(i).setStartAngle(curValue * 360 / getTotal());
            slices.get(i).setArcAngle((slices.get(i).getValue() * 360 / getTotal()));
            curValue += slices.get(i).getValue();
        }
    }

    public void setValue(double value, int i) {
        setTotal(getTotal() - slices.get(i).getValue() + value);
        slices.get(i).setValue(value);
        setAngles();
    }

    public void setColor(int i, int i1, int i2, int i3) {
        slices.get(i3).setColor(i, i2, i3);
    }

}
