/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

import Model.criteria.Price;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Pricetab extends JPanel {

    private JTextField priceField = new JTextField(5);
    private final JButton addButton = new JButton("Add Price Limit");
    private final JButton removeButton = new JButton("Remove Price Limit");
    private final JPanel buttonsPanel = new JPanel();
    private Float chosenPrice;

    public Pricetab() {
        this.setLayout(new FlowLayout());
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        this.add(priceField);
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        this.add(buttonsPanel);

        // Document Listener
        priceField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                chosenPrice = Float.parseFloat(priceField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public Price getPrice() {
        return new Price(chosenPrice);

    }

}
