import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Назва книги 1", "Автор 1", "1234567890", 2020);
        Book book2 = new Book("Назва книги 2", "Автор 2", "0987654321", 2018);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        List<Book> allBooks = library.getAllBooks();
        System.out.println("Всі книги в бібліотеці:");
        for (Book book : allBooks) {
            System.out.println("Назва: " + book.getTitle() +
                    ", Автор: " + book.getAuthor() +
                    ", ISBN: " + book.getIsbn() +
                    ", Рік видання: " + book.getPublicationYear());
        }

        String searchTitle = "Назва книги 1";
        Book foundBook = library.searchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("\nЗнайдена книга за назвою \"" + searchTitle + "\": " + foundBook.getTitle());
        } else {
            System.out.println("\nКнига з назвою \"" + searchTitle + "\" не знайдена.");
        }

        String isbnToDelete = "0987654321";
        library.removeBookByIsbn(isbnToDelete);
        System.out.println("\nВидалили книгу з ISBN " + isbnToDelete);

        System.out.println("\nОновлений список книг в бібліотеці:");
        allBooks = library.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Назва: " + book.getTitle() +
                    ", Автор: " + book.getAuthor() +
                    ", ISBN: " + book.getIsbn() +
                    ", Рік видання: " + book.getPublicationYear());
        }
    }
}
