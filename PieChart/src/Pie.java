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

//    private Slice[] slices = new Slice[size];

    /*public Pie() {
        Random rnd = new Random();
        x = rnd.nextInt(40);
        y = rnd.nextInt(40);
        for (int i = 0; i < size; i++) {
            slices[i] = new Slice();
            total += slices[i].getValue();
            slices[i].setStartAngle(curValue * 360 / total);
            slices[i].setArcAngle((int) (slices[i].getValue() * 360 / total));
            curValue += slices[i].getValue();
        }
    }

    public Pie(int x, int y) {
        this.x = x;
        this.y = y;
        for (int i = 0; i < size; i++) {
            slices[i] = new Slice();
            total += slices[i].getValue();
            slices[i].setStartAngle(curValue * 360 / total);
            slices[i].setArcAngle((int) (slices[i].getValue() * 360 / total));
            curValue += slices[i].getValue();
        }
    }*/



    public Pie(int x, int y) {
        this.x = x;
        this.y = y;
//        slices.add(new Slice(50));
        setTotal(getValue());
    }

    public double getTotal() {
        return total;
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
        setAngles(getSize());
    }

    public void setAngles(int j) {
//        setTotal(getTotal() + slices.get(getSize() - 1).getValue());
//        slices.get(getSize() - 1).setStartAngle((slices.get(getSize() - 2).getValue()
//                + slices.get(getSize() - 1).getValue()) * 360 / getTotal());
//        slices.get(getSize() - 1).setArcAngle((int) (slices.get(getSize() - 1).getValue() * 360 / getTotal()));
        for (int i = 0; i < j; i++) {
//            setTotal(slices.get(i).getValue() + getTotal());
            slices.get(i).setStartAngle(curValue * 360 / getTotal());
            slices.get(i).setArcAngle((slices.get(i).getValue() * 360 / getTotal()));
            curValue += slices.get(i).getValue();
        }

        /*slices.get(0).setStartAngle(0);
        slices.get(0).setArcAngle(120);
        slices.get(1).setStartAngle(120);
        slices.get(1).setArcAngle(240);
        slices.get(2).setStartAngle(240);
        slices.get(2).setArcAngle(120);*/

    }

}
