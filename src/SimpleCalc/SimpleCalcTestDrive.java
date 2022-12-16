package SimpleCalc;
import javax.swing.*;

public class SimpleCalcTestDrive {
    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.getCalcPanel());
        app.setTitle("Simple Calculator");
        app.setSize(550, 300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
