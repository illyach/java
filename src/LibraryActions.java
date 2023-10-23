import java.util.List;
public interface LibraryActions {
    void add(Item item);

    void remove(Item item);

    List<Item> listAvailable();

    List<Item> listBorrowed();
}
