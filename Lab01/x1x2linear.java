import javax.swing.JOptionPane;

public class x1x2linear {
    public static void main(String[] args) {
        String strA11 = JOptionPane.showInputDialog("Enter a11:");
        String strA12 = JOptionPane.showInputDialog("Enter a12:");
        String strB1 = JOptionPane.showInputDialog("Enter b1:");

        String strA21 = JOptionPane.showInputDialog("Enter a21:");
        String strA22 = JOptionPane.showInputDialog("Enter a22:");
        String strB2 = JOptionPane.showInputDialog("Enter b2:");

        double a11 = Double.parseDouble(strA11);
        double a12 = Double.parseDouble(strA12);
        double b1 = Double.parseDouble(strB1);

        double a21 = Double.parseDouble(strA21);
        double a22 = Double.parseDouble(strA22);
        double b2 = Double.parseDouble(strB2);

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "No solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Dang Phuong Nam 20225892\nThe solutions: x1 = " + x1 + "; x2 = " + x2);
        }
    }
}
