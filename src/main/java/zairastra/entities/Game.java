package zairastra.entities;

public abstract class Game {
    //ATTRIBUTI
    private String id;
    private String title;
    private int year;
    private double price;

    //COSTRUTTORI
    public Game(String id, String title, int year, double price) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    //METODI


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
