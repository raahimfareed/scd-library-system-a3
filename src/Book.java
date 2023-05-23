public class Book {
    private int id;
    private String name;
    private String genre;
    private double price;
    private Integer issuedTo;

    public Book(int id, String name, String genre, double price, Integer issuedTo) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.issuedTo = issuedTo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public Integer getIssuedTo() {
        return issuedTo;
    }
}
