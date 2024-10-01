import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Dang Phuong Nam\nPlease enter your name:");
        JOptionPane.showMessageDialog(null, "Hi "+result+"!");
        System.exit(0);
    }
}
