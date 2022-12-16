package LeapYear;

import javax.swing.*;

public class LeapYearTestDrive {
    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.getPnlMain());
        app.setTitle("Leap Year Cheker");
        app.setSize(300, 300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
