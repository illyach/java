import java.util.List;
import java.util.Map;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "illya ");
        User user2 = new User(2, "alex");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product_iphone = new Product(1, "Iphone", 800, 10);
        Product product_tv = new Product(2, "TV", 300, 15);
        Product product_laptop = new Product(3, "Laptop", 1300, 3);

        platform.addProduct(product_iphone);
        platform.addProduct(product_tv);
        platform.addProduct(product_laptop);

        //юзер1 добавляем товари
        user1.addToCart(product_iphone, 2);
        user1.addToCart(product_tv, 3);
        user1.addToCart(product_laptop, 3);

        //юзер2 добавляем товари
        user2.addToCart(product_tv, 3);
        user2.addToCart(product_laptop, 5);
        user2.addToCart(product_iphone, 2);


//видаляемо для user1 айфон з кошика  User 2 Cart
        user1.removeFromCart(product_iphone, 2);

        //видаляемо для user2 айфон та тв з кошика  User 2 Cart
        user2.removeFromCart(product_iphone, 5);
        user2.removeFromCart(product_tv, 5);

        System.out.println("User 1 Cart: " + user1.toString());
        System.out.println("User 2 Cart: " + user2.toString());

        Map<Product, Integer> orderDetails1 = user1.getCart();
        platform.createOrder(user1.getId(), orderDetails1);

        Map<Product, Integer> orderDetails2 = user2.getCart();
        platform.createOrder(user2.getId(), orderDetails2);

        System.out.println("Orders: " + platform.getOrders());

        System.out.println("Available Products: " + platform.getAvailableProducts());

        displayProductsSortedByName(platform);
        displayProductsSortedByPrice(platform);
        displayProductsSortedByStock(platform);
        filterProductsByStock(platform, 5);
    }

    // Відображення та фільтрація товарів



    // (Інші методи, що вже є в ECommerceDemo)

    // Функція для відображення списку товарів, відсортованих за назвою
    public static void displayProductsSortedByName(ECommercePlatform platform) {
        List<Product> sortedProductsByName = platform.getSortedProductsByName();
        System.out.println("Товари, відсортовані за назвою: " + sortedProductsByName);
    }

    // Функція для відображення списку товарів, відсортованих за ціною
    public static void displayProductsSortedByPrice(ECommercePlatform platform) {
        List<Product> sortedProductsByPrice = platform.getSortedProductsByPrice();
        System.out.println("Товари, відсортовані за ціною: " + sortedProductsByPrice);
    }

    // Функція для відображення списку товарів, відсортованих за запасами
    public static void displayProductsSortedByStock(ECommercePlatform platform) {
        List<Product> sortedProductsByStock = platform.getSortedProductsByStock();
        System.out.println("Товари, відсортовані за запасами: " + sortedProductsByStock);
    }

    // Функція для фільтрації товарів за наявністю на складі
    public static void filterProductsByStock(ECommercePlatform platform, int stockThreshold) {
        List<Product> filteredProductsByStock = platform.filterProductsByStock(stockThreshold);
        System.out.println("Товари з наявністю більше " + stockThreshold + ": " + filteredProductsByStock);
    }
}


