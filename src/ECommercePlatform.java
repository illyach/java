import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        Order order = new Order(generateOrderId(), userId, orderDetails);
        orders.put(order.getId(), order);
        updateStocks(orderDetails);
    }

    public List<Product> getAvailableProducts() {
        return products.values().stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
    }

    public List<Product> getSortedProductsByName() {
        return products.values().stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> getSortedProductsByPrice() {
        return products.values().stream()
                .sorted(Product.PriceComparator)
                .collect(Collectors.toList());
    }

    public List<Product> getSortedProductsByStock() {
        return products.values().stream()
                .sorted(Comparator.comparingInt(Product::getStock))
                .collect(Collectors.toList());
    }

    public List<Product> filterProductsByStock(int stockThreshold) {
        return products.values().stream()
                .filter(product -> product.getStock() >= stockThreshold)
                .collect(Collectors.toList());
    }

    public List<Product> filterProductsByPrice(double priceThreshold) {
        return products.values().stream()
                .filter(product -> product.getPrice() <= priceThreshold)
                .collect(Collectors.toList());
    }

    private void updateStocks(Map<Product, Integer> orderDetails) {
        orderDetails.forEach((product, quantity) ->
                product.setStock(product.getStock() - quantity));
    }

    private Integer generateOrderId() {
        return orders.size() + 1;
    }

    public String getOrders() {
        return orders.values().toString();
    }

    // Додайте інші методи за потреби
}