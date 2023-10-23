import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }
    public void remove(String uniqueID) {
        items.removeIf(item -> item.getUniqueID().equals(uniqueID));
    }

}
