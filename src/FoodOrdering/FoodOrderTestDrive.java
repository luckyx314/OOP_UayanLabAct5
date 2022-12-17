package FoodOrdering;

import javax.swing.*;

public class FoodOrderTestDrive {
    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.getFoodOrderingPanel());
        app.setTitle("Food Ordering System");
        app.setVisible(true);
        app.setSize(500, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
