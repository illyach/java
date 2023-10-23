import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();


        Book book1 = new Book("Say yes to life", "B004", "Victor Franckl");
        DVD dvd1 = new DVD("How to be stoic", "D004", 148);


        library.add(book1);
        library.add(dvd1);
        library.remove("B004"); //remove item

        List<Item> availableItems = library.listAvailable();
        System.out.println("Доступные предметы в библиотеке:");
        for (Item item : availableItems) {
            System.out.println(item.getTitle());
        }
    }
}
