import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Створюємо новий об'єкт класу Library
        Library library = new Library();

        // Додаємо предмети до бібліотеки
        Book book1 = new Book("Feeling nature book", "Fridrigh Velikiy", "1379");
        Book book2 = new Book("How to know programming book", "Alexa Fridman", "1459");
        DVD dvd1 = new DVD("Survival tutorial book", "Fridman Dobght",  112);
        library.add(book1);
        library.add(book2);
        library.add(dvd1);

        //Видаляем предмети з бібліотеки.
        library.remove(book2);

        // Реєструємо читачів
        Patron patron1 =  new Patron("\nMykola", "\n5214567700");
        Patron patron2 = new Patron("\nAlex", "\n3175543010");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // Виводимо список доступних предметів
        System.out.println("\nДоступні предмети:");
        library.listAvailable();

        System.out.println("\nСписок читачiв:");

        library.listPatrons();

        // Видаємо предмет читачеві
        library.lendItem(library.patrons.get(0), library.items.get(0));
        library.lendItem(library.patrons.get(1), library.items.get(1));

        //Повертаємо предмет у бібліотеку
        library.returnItem(library.patrons.get(0), library.items.get(0));

        // Виводимо список взятих у борг предметів знову
        System.out.println("\nВзяті у борг предмети після повернення:");
        library.listBorrowed();

        System.out.println("\nДоступнi предмети пiсля боргу");
        library.listAvailable();
    }



}