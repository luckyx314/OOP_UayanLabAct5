package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NegativeYearException extends Exception {
    @Override
    public String getMessage() {
        return "Year cannot be negative. Please try again!";
    }
}

class ZeroYearException extends Exception {
    @Override
    public String getMessage() {
        return "Year cannot be zero. Please try again!";
    }
}

public class LeapYearGUI extends JFrame{
    private JPanel leapYearPanel;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Not a leap year";
                int year = 0;
                try {
                    try {
                        year = Integer.parseInt(tfYear.getText());

                        if (year == 0)
                            throw new ZeroYearException();
                        if (year < 0)
                            throw new NegativeYearException();

                        if (leapYearChecker(year))
                            message = "Leap Year";

                        JOptionPane.showMessageDialog(leapYearPanel, message);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(leapYearPanel, "Invalid input. A year should be an integer. Please try again!");
                    }

                } catch (NegativeYearException | ZeroYearException err) {
                    JOptionPane.showMessageDialog(leapYearPanel, err.getMessage());
                }
            }
        });
    }

    public JPanel getPnlMain() {
        return leapYearPanel;
    }

    public boolean leapYearChecker(int year) {
        return (year%4 == 0 && year%100 != 0) || year %400 == 0;
    }
}
