package Model;

import Model.criteria.*;
/**
 * 
 * @author pacomebondetdelabernardie
 */
public class Game implements Article {
    // will make the correspondance between the 
    // Java model and the Database model 
    private Integer id;
    
    private String gameName;
    private Company company;
    private Price price;
    private ESRB_Rating rating;
    private ReleaseDate releaseDate;
    private Boolean available;
    private Console console;
    private Categories categories;
    
    
    
    
    public Game(Integer id,
            String gameName,
            Company company,
            Price price, 
            ESRB_Rating rating,
            ReleaseDate releaseDate,
            Boolean available,
            Console console, 
            Categories categories
            ){
        this.id = id;
        this.gameName = gameName;
        this.company = company;
        this.price = price;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.available = available;
        this.console = console;
        this.categories = categories;
    }
    
    public Integer getId(){
        return id;
    }
    
    public String getName(){
        return gameName;
    }
    public void toggleAvailable(){
        setAvailable(!isAvailable());
    }
    public Article order(){
        return this;
    }
    public Boolean tryOrder(){
        return isAvailable();
    }
    public void showInfo(){
        // todo
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param gameName the gameName to set
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return the rating
     */
    public ESRB_Rating getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(ESRB_Rating rating) {
        this.rating = rating;
    }

    /**
     * @return the releaseDate
     */
    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the console
     */
    public Console getConsole() {
        return console;
    }

    /**
     * @param console the console to set
     */
    public void setConsole(Console console) {
        this.console = console;
    }

    /**
     * @return the categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    
    @Override
    public String toString(){
        return "[" + gameName + "],[" 
                + company + "],[" 
                + price + "],["
                + rating + "],[" 
                + releaseDate + "],[" 
                + available + "],[" 
                + console + "],[" 
                + categories + "]\n";
                
             
    }
    

  
}

