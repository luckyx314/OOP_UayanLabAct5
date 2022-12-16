package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class NumberTooLarge extends Exception {
    @Override
    public String getMessage() {
        return "Number is too large. Try again!";
    }
}

public class SimpleCalcGUI extends JFrame{
    private JPanel calcPanel;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lbResult;

    public SimpleCalcGUI() {
        lbResult.setEditable(false);
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String operation = (String) cbOperations.getSelectedItem();
                    double n1 = Integer.parseInt(tfNumber1.getText());
                    double n2 = Integer.parseInt(tfNumber2.getText());
                    double res = 0;

                    if (n1 >= 999999999 || n2 >= 999999999)
                        throw new NumberTooLarge();

                    switch (Objects.requireNonNull(operation)) {
                        case "+":
                            res = n1 + n2;
                            break;
                        case "-":
                            res = n1 - n2;
                            break;
                        case "*":
                            res = n1 * n2;
                            break;
                        case "/":
                            res = n1 / n2;
                            if (n2 == 0)
                                throw new ArithmeticException();
                            break;
                    }

                    String finalRes = String.valueOf(String.format("%,.4f", res));
                    if (res % 1 == 0)
                        finalRes = String.valueOf(String.format("%,.0f", res));

                    lbResult.setText(finalRes);
                } catch (NumberTooLarge err) {
                    JOptionPane.showMessageDialog(calcPanel, err.getMessage());
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(calcPanel, "Invalid input. Please enter a valid number.");
                } catch (ArithmeticException err) {
                    JOptionPane.showMessageDialog(calcPanel, "Cannot divide a number by zero. Try again!");
                }
            }
        });
    }

    public JPanel getCalcPanel() {
        return calcPanel;
    }

    public void clearInputs() {
        tfNumber1.setText("");
        tfNumber2.setText("");
        lbResult.setText("");
    }
}
