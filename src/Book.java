public class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            this.isBorrowed = true;
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            this.isBorrowed = false;
        }
    }
}