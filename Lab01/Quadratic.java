import javax.swing.JOptionPane;

public class Quadratic {
    public static void main(String[] args) {
        String strA = JOptionPane.showInputDialog("Enter coefficient a:");
        String strB = JOptionPane.showInputDialog("Enter coefficient b:");
        String strC = JOptionPane.showInputDialog("Enter constant c:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        if (a == 0) {
            // If a = 0, it becomes a first-degree equation bx + c = 0
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinitely many solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution.");
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "Single root: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "No real solution.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Dang Phuong Nam 20225892\nx1 = " + x1 + "; x2 = " + x2);
            }
        }
    }
}
