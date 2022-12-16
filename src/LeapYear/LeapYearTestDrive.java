package LeapYear;

import javax.swing.*;
import java.util.Scanner;

public class LeapYearTestDrive {
    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.getPnlMain());
        app.setTitle("Leap Year Checker");
        app.setSize(300, 300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}