package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class NoOrderException extends Exception {
    @Override
    public String getMessage() {
        return "Please pick at least one (1) order.";
    }
}

public class FoodOrderGUI extends JFrame{
    private JPanel foodOrderingPanel;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    public FoodOrderGUI() {
        ButtonGroup rbGroup = new ButtonGroup();
        rbGroup.add(rb5);
        rbGroup.add(rb10);
        rbGroup.add(rb15);
        rbGroup.add(rbNone);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0;

                try {
                    if (cPizza.isSelected())
                        totalPrice += 100;
                    else if (cBurger.isSelected())
                        totalPrice+=80;
                    else if (cFries.isSelected())
                        totalPrice+=65;
                    else if (cSoftDrinks.isSelected())
                        totalPrice+=55;
                    else if (cTea.isSelected())
                        totalPrice+=50;
                    else if (cSundae.isSelected())
                        totalPrice+=40;
                    else
                        throw new NoOrderException();

                    int result = JOptionPane.NO_OPTION;
                    boolean withDiscount = true;

                    if (rb5.isSelected())
                        totalPrice -= (totalPrice * .05);
                    else if (rb10.isSelected())
                        totalPrice -= (totalPrice * .10);
                    else if (rb15.isSelected())
                        totalPrice -= (totalPrice * .15);
                    else if (!rbNone.isSelected()) {
                        result = JOptionPane.showConfirmDialog(foodOrderingPanel, "You have not selected a discount option. Do you wish to continue?");
                        if (result == JOptionPane.NO_OPTION || result == JOptionPane.CANCEL_OPTION)
                            withDiscount = false;
                    }

                    if (result == JOptionPane.YES_OPTION || withDiscount)
                        JOptionPane.showMessageDialog(foodOrderingPanel, "The total price is Php " + String.format("%.2f", totalPrice));

                } catch (NoOrderException err) {
                    JOptionPane.showMessageDialog(foodOrderingPanel, err.getMessage());
                }
            }
        });
    }

    public JPanel getFoodOrderingPanel() {
        return foodOrderingPanel;
    }
}
