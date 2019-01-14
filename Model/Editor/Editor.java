/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Editor;

import javax.swing.*;
import java.util.Date;
import com.mysql.jdbc.Driver;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Model.Editor.Exceptions.IncorrectFormatException;
import Model.Editor.Exceptions.FieldsMissingException;
import Model.Editor.SQLGameAdder;
import Model.Game;
import Model.criteria.Categories;
import Model.criteria.Company;
import Model.criteria.Console;
import Model.criteria.ESRB_Rating;
import Model.criteria.Price;
import Model.criteria.ReleaseDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Editor extends JFrame {

    private JPanel panel = new JPanel();

    private String vname;
    private String vcompany;
    private ArrayList<String> categoryList = new ArrayList<>();
    private Float vprice;
    private String vesrb_rating;
    private String vrelease_date;
    private Boolean vavailable = true;
    private String vconsole;
    private SQLGameAdder gameAdder = new SQLGameAdder();

    private ArrayList<Boolean> fieldsEntered = new ArrayList<>();
    private Boolean nameAdded = false;
    private Boolean companyAdded = false;
    private Boolean priceAdded = false;
    private Boolean categoriesAdded = false;
    private Boolean esrbAdded = false;
    private Boolean releaseDateAdded = false;
    private Boolean consoleAdded = false;
    
    private Boolean formatIncorrect = false;
    
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

    public Editor(){
        this.setBounds(0, 0, 500, 500);
        this.setPreferredSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel lname = new JLabel("Game Name:");
        JLabel lcompany = new JLabel("Company:");
        JLabel lprice = new JLabel("Price:");
        JLabel lcategory = new JLabel("Category:");
        JLabel lesrb_rating = new JLabel("ESRB Rating:");
        JLabel lavailable = new JLabel("Available");
        JLabel lrelease_date = new JLabel("Release Date:");
        JLabel lconsole = new JLabel("Console:");

        JTextField name = new JTextField(20);
        JTextField company = new JTextField(20);
        JTextField price = new JTextField(4);
        JTextField category = new JTextField(30);
        JTextField esrb_rating = new JTextField(5);
        JCheckBox available = new JCheckBox("Available", true);
        JTextField release_date = new JTextField(8);
        JTextField console = new JTextField(12);

        JButton add_article = new JButton("ADD");

        //begin Document Listeners 
        //name 
        name.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                getName();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getName();
            }

            public void getName() {
                vname = name.getText();
                nameAdded = true;

            }
        });

        // company
        company.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                getCompany();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getCompany();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getCompany();
            }

            public void getCompany() {
                vcompany = company.getText();
                companyAdded = true;
            }
        });

        // list of Categories
        category.getDocument().addDocumentListener(new DocumentListener() {

            // todo verify that the Category is a valid Category
            @Override
            public void insertUpdate(DocumentEvent e) {
                splitWithSpaces();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            public void splitWithSpaces() {

                ArrayList<String> list = new ArrayList<>();
                String categories;
                categories = category.getText();
                ArrayList<String> aList= new ArrayList(Arrays.asList(categories.split(",")));
                
                
                
        
                // Verify Categories entered belong to Valide Categories
                ArrayList<String> modValidCategories = new ArrayList<>();
                boolean categoryCheck = false;
                for (String modCategory : aList) {
                    for (String validCategory : validCategories) {
                        if (modCategory.equals(validCategory)) {
                            categoryCheck = true;
                            break;
                        }
                    }
                    if(categoryCheck)
                        modValidCategories.add(modCategory);
                    categoryCheck = false;    
                }
                categoryList = modValidCategories;
                if (!list.isEmpty())
                       categoriesAdded = true;

            }
        });

        price.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                getFloat();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getFloat();
            }

            public void getFloat()  {
                try{
                vprice = Float.parseFloat(price.getText());
                if(!(vprice instanceof Float)){
                    formatIncorrect = true;
                }
                
                else
                    priceAdded = true;
                } catch (NumberFormatException e){
                    
                }
            }
        });

        esrb_rating.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                getRating();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getRating();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getRating();
            }

            public void getRating() {
                vesrb_rating = esrb_rating.getText();
                esrbAdded = true;
            }
        });

        release_date.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                getDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getDate();
            }

            public void getDate() {
                vrelease_date = release_date.getText();
                releaseDateAdded = true;
                
            }
        });

        available.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                vavailable = available.isSelected();
            }

        });

        console.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getConsole();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getConsole();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getConsole();
            }
            public void getConsole(){
                vconsole = console.getText();
                consoleAdded = true;
                
            }

        });

        // End Document-Event Listeners
        // button Event
        add_article.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addGame();
                } catch (FieldsMissingException ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        panel.setLayout(new GridBagLayout());

        addComp(lname, 0, 0, 3, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
        addComp(name, 3, 0, 5, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);

        addComp(lcompany, 0, 1, 3, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
        addComp(company, 3, 1, 5, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);

        addComp(lprice, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
        addComp(price, 4, 2, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        //addComp(price,)
        addComp(lcategory, 0, 3, 3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(category, 3, 3, 5, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        addComp(lesrb_rating, 0, 4, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(esrb_rating, 6, 4, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        addComp(available, 0, 5, 8, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        addComp(lrelease_date, 0, 6, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(release_date, 3, 6, 5, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        addComp(lconsole, 0, 7, 4, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(console, 3, 7, 4, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(add_article, 5, 7, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        this.add(panel);

    }

    private void addComp(JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int anchor, int fill) {

        GridBagConstraints gridC = new GridBagConstraints();

        gridC.gridx = xPos;
        gridC.gridy = yPos;
        gridC.gridwidth = compWidth;
        gridC.gridheight = compHeight;
        gridC.weightx = 0;
        gridC.weighty = 0;
        gridC.insets = new Insets(0, 0, 0, 0);
        gridC.anchor = anchor;

        gridC.fill = fill;

        panel.add(comp, gridC);

    }
    
    public void addGame() throws FieldsMissingException {
        for(Boolean b : fieldsEntered)
            if (b = false)
                throw new FieldsMissingException("A Field is missing");
        // test //
        Integer id = null;
            String gameName = vname;
            Company company = new Company(vcompany);
            Price price = new Price(vprice);
            ESRB_Rating rating = new ESRB_Rating(vesrb_rating);
            ReleaseDate releaseDate = new ReleaseDate(gameAdder.parseDate(vrelease_date));
            Boolean available = vavailable;
            Console console = new Console(vconsole);
            Categories categories = new Categories(categoryList);
            
            Game g = new Game(id,gameName,company,price,rating,releaseDate,available,console,categories);
            // end test 
            System.out.println(g);
            gameAdder.insertGameIntoDatabase(vname, vcompany, vprice, vesrb_rating, vrelease_date, vavailable, vconsole, categoryList);
            
            
        
        
    }

}
