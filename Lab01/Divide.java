import javax.swing.JOptionPane;

public class Divide {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Enter the first number:");
        String strNum2 = JOptionPane.showInputDialog("Enter the second number:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1*num2;

        String text = "Dang Phuong Nam 20225892\nSum: "+sum +"\n"+ "Difference: " + difference + "\n" + "Product: " + product + "\n";

        if (num2 != 0) {
            double quotient = num1/num2;
            text += "Quotient: " + quotient;
        } else {
            text += "Cannot divide by zero";
        }
        JOptionPane.showMessageDialog(null, text);
    }
}
