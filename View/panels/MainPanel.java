/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.panels;

import Model.Game;
import Model.criteria.Categories;
import Model.criteria.Company;
import Model.criteria.Console;
import Model.criteria.ESRB_Rating;
import Model.criteria.Price;
import View.tabs.Categorytab;
import View.tabs.Companytab;
import View.tabs.Consoletab;
import View.tabs.CriteriaButton;
import View.tabs.ESRBtab;
import View.tabs.Pricetab;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class MainPanel extends JPanel {

    private JPanel searchPanel = new JPanel();
    private JTextField searchField = new JTextField(20);
    private JButton searchButton = new JButton("Search");
    
    private String searchString = "";
    
    

    // Game to send to Comparator
    private Game blankGame = new Game(null, null, null, null, null, null, null, null, null);

    // Booleans for added/removed tags
    boolean ratingAdded = false;
    boolean categoriesAdded = false;
    boolean priceAdded = false;
    boolean companyAdded = false;
    boolean consoleAdded = false;

    //buttons
    JButton addRatingButton;
    JButton removeRatingButton;

    JButton addCategoriesButton;
    JButton removeCategoriesButton;

    JButton addPriceButton;
    JButton removePriceButton;

    JButton addCompanyButton;
    JButton removeCompanyButton;

    JButton addConsoleButton;
    JButton removeConsoleButton;

    //Custom tags
    CriteriaButton ratingTag;
    CriteriaButton categoriesTag;
    CriteriaButton priceTag;
    CriteriaButton companyTag;
    CriteriaButton consoleTag;

    //tabbed Panel
    CriteriaTabsPanel tabbedPanel = new CriteriaTabsPanel();

    public MainPanel() {
        //setTitle("Search A Game");
        //setBounds(150,150,520,300);
        this.setPreferredSize(new Dimension(520, 300));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(tabbedPanel, BorderLayout.NORTH);

        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        this.add(searchPanel, BorderLayout.CENTER);

        // Buttons of Tabs
        addRatingButton = tabbedPanel.ratingsTab.getAddButton();
        removeRatingButton = tabbedPanel.ratingsTab.getRemoveButton();

        addCategoriesButton = tabbedPanel.categoriesTab.getAddButton();
        removeCategoriesButton = tabbedPanel.categoriesTab.getRemoveButton();

        addPriceButton = tabbedPanel.priceTab.getAddButton();
        removePriceButton = tabbedPanel.priceTab.getRemoveButton();

        addCompanyButton = tabbedPanel.companyTab.getAddButton();
        removeCompanyButton = tabbedPanel.companyTab.getRemoveButton();

        addConsoleButton = tabbedPanel.consoleTab.getAddButton();
        removeConsoleButton = tabbedPanel.consoleTab.getRemoveButton();

        // ActionListeners
        //Rating
        //ADD
        addRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rating Add");
                if (!ratingAdded) {
                    ESRB_Rating rating = tabbedPanel.ratingsTab.getSelectedRating();
                    ratingTag = new CriteriaButton(rating);
                    blankGame.setRating(rating);
                    searchPanel.add(ratingTag);

                    ratingAdded = true;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        //Remove
        removeRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rating Remove");
                if (ratingAdded) {
                    searchPanel.remove(ratingTag);

                    blankGame.setRating(null);
                    ratingAdded = false;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        // Categories
        // ADD
        addCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Categories Add");
                if (!categoriesAdded && !tabbedPanel.categoriesTab.getCategories().isEmpty()) {
                    Categories categories = tabbedPanel.categoriesTab.getCategories();
                    categoriesTag = new CriteriaButton(categories);
                    blankGame.setCategories(categories);
                    searchPanel.add(categoriesTag);
                    searchPanel.revalidate();
                    categoriesAdded = true;
                    repaint();
                }

            }
        });
        //Remove
        removeCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Categories Remove");
                if (categoriesAdded) {
                    searchPanel.remove(categoriesTag);
                    searchPanel.revalidate();

                    blankGame.setCategories(null);

                    categoriesAdded = false;
                    repaint();
                }

            }
        });
        //Price
        // ADD
        addPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Price price = tabbedPanel.priceTab.getPrice();
                if (!priceAdded && price.getPrice() != null) {
                    System.out.println("Price Add");

                    priceTag = new CriteriaButton(price);
                    blankGame.setPrice(price);
                    searchPanel.add(priceTag);
                    searchPanel.revalidate();
                    priceAdded = true;
                    repaint();
                }

            }
        });
        //Remove
        removePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Price Remove");
                if (priceAdded) {
                    searchPanel.remove(priceTag);
                    searchPanel.revalidate();

                    blankGame.setPrice(null);

                    priceAdded = false;
                    repaint();
                }

            }
        });
        //Company
        //ADD
        addCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Company Add");
                if (!companyAdded) {
                    Company company = tabbedPanel.companyTab.getSelectedCompany();
                    companyTag = new CriteriaButton(company);
                    blankGame.setCompany(company);
                    searchPanel.add(companyTag);

                    companyAdded = true;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        //Remove
        removeCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Company Remove");
                if (companyAdded) {
                    searchPanel.remove(companyTag);

                    blankGame.setCompany(null);
                    companyAdded = false;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        // Console 
        //Add
        addConsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Console Add");
                if (!consoleAdded) {
                    Console console = tabbedPanel.consoleTab.getSelectedConsole();
                    consoleTag = new CriteriaButton(console);
                    blankGame.setConsole(console);
                    searchPanel.add(consoleTag);

                    consoleAdded = true;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        //Remove
        removeConsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Console Remove");
                if (consoleAdded) {
                    searchPanel.remove(consoleTag);

                    blankGame.setConsole(null);
                    consoleAdded = false;
                    searchPanel.revalidate();
                    repaint();
                }

            }
        });
        searchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(searchField.getText().equals(""))
                    blankGame.setGameName(null);
                blankGame.setGameName(searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
            
        
    }

    public class CriteriaTabsPanel extends JPanel {

        private JTabbedPane tabs = new JTabbedPane();
        public ESRBtab ratingsTab = new ESRBtab();
        public Categorytab categoriesTab = new Categorytab();
        public Pricetab priceTab = new Pricetab();
        public Companytab companyTab = new Companytab();
        public Consoletab consoleTab = new Consoletab();

        public CriteriaTabsPanel() {
            tabs.addTab("ESRB Rating", ratingsTab);
            tabs.addTab("Categories", categoriesTab);
            tabs.addTab("Price", priceTab);
            tabs.addTab("Company", companyTab);
            tabs.addTab("Console", consoleTab);
            this.add(tabs);
        }

    }

    public Game getBlankGame() {
        return blankGame;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
