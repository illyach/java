import java.util.ArrayList;
import java.util.List;

class Patron {
    String name;
    String ID;
    List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrow(Item item) {
        this.borrowedItems.add(item);
        item.isBorrowed = true;
    }

    public void returnItem(Item item) {
        this.borrowedItems.remove(item);
        item.isBorrowed = false;
    }
}
