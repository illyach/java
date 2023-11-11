import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {

    List<Item> items = new ArrayList<>();
    List<Patron> patrons = new ArrayList<>();

    @Override
    public void add(Item item) {
        this.items.add(item);
    }

    @Override
    public void remove(Item item) {
        this.items.remove(item);
    }

    @Override
    public void listAvailable() {
        for (Item item : this.items) {
            if (!item.isBorrowed) {
                System.out.println(item.title);
            }
        }
    }

    @Override
    public void listBorrowed() {
        for (Patron patron : this.patrons) {
            for (Item item : patron.borrowedItems) {
                System.out.println(item.title + ", Читатель: " + patron.name);
            }
        }
    }

    public void registerPatron(Patron patron) {
        this.patrons.add(patron);
    }

    public void listPatrons() {
        for (Patron patron : this.patrons) {
            System.out.println(patron.name + patron.ID);
        }
    }

    public void lendItem(Patron patron, Item item) {
        patron.borrowedItems.add(item);
        item.isBorrowed = true;
    }

    public void returnItem(Patron patron, Item item) {
        patron.borrowedItems.remove(item);
        item.isBorrowed = false;
    }

}