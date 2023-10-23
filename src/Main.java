import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем объект библиотеки
        Library library = new Library();

        // Создаем книгу и DVD
        Book book1 = new Book("Say yes to life", "B004", "Victor Franckl");
        DVD dvd1 = new DVD("How to be stoic", "D004", 148);

        // Добавляем созданные предметы в библиотеку
        library.add(book1);
        library.add(dvd1);

        // Проверим, что предметы добавлены в библиотеку
        List<Item> availableItems = library.listAvailable();
        System.out.println("Доступные предметы в библиотеке:");
        for (Item item : availableItems) {
            System.out.println(item.getTitle());
        }
    }
}
