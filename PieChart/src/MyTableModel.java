import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created by alex on 25.12.16.
 */
public class MyTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return 10;
    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "da";
            case 1:
                return "da1";
            case 2:
                return "da2";
            default:
                return "sos";
        }
    }
}
