import javax.swing.JOptionPane;

public class y_ax_b {
    public static void main(String[] args) {
        String strA = JOptionPane.showInputDialog("Enter coefficient a:");
        String strB = JOptionPane.showInputDialog("Enter constant b:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        if (a == 0) {
            if (b == 0) JOptionPane.showMessageDialog(null, "Dang Phuong Nam 20225892\nInfinitely many solutions.");
            else JOptionPane.showMessageDialog(null, "Dang Phuong Nam 20225892\nNo solution.");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Dang Phuong Nam 20225892\nx = " + x);
        }
    }
}
