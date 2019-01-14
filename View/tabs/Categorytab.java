/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

import Model.criteria.Categories;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Categorytab extends JPanel {

    private JTextField categoryField = new JTextField(25);
    private JButton addCategoriesButton = new JButton("Add");
    private JButton removeCategoriesButton = new JButton("Remove");
    private Categories categoryList = new Categories();
    private String[] validCategories = {
        "ACTION",
        "RPG",
        "SIMULATION",
        "STRATEGY",
        "RACING",
        "PARTY",
        "MUSIC",
        "HORROR",
        "FPS",
        "SHOOTER",
        "FIGHTING",
        "ADVENTURE",
        "PUZZLE"
    };

    public Categorytab() {

        // Layout
        this.setLayout(new FlowLayout());
        this.add(categoryField);
        this.add(addCategoriesButton);
        this.add(removeCategoriesButton);

        // get Categories
        categoryField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Categories categories= new Categories();
                List<String> list = new ArrayList<>();
                list = Arrays.asList(categoryField.getText().split(","));
                // Verify Categories entered belong to Valide Categories
                boolean categoryCheck = false;
                for (String userCategory : list) {
                    for (String validCategory : validCategories) {
                        if (userCategory.equals(validCategory)) {
                            categoryCheck = true;
                            break;
                        }
                    }
                    if(categoryCheck)
                        categories.addCategory(userCategory);
                    categoryCheck = false;    
                }
                
                categoryList = categories;
                
                System.out.println(categories);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

    }

    public Categories getCategories() {
        return categoryList;
    }

    public JButton getAddButton() {
        return addCategoriesButton;
    }

    public JButton getRemoveButton() {
        return removeCategoriesButton;
    }
}
