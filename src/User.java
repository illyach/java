import java.util.HashMap;
import java.util.Map;

class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    // Гетери та сетери

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) - quantity);
        if (cart.get(product) <= 0) {
            cart.remove(product);
        }
    }

    // Реалізація toString для виведення кошика
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', cart=" + cart + '}';
    }


}
