//lab 4.1
public class Main {
    public static void main(String[] args) {
        String word = "sos";

        if (isPalindrome(word)) {
            System.out.println(word + " є паліндромом.");
        } else {
            System.out.println(word + " не є паліндромом.");
        }
    }

    public static boolean isPalindrome(String str) {
        // Видаляємо з рядка пробіли і робимо всі літери малими для порівняння
        String cleanStr = str.replaceAll("\\s", "").toLowerCase();

        // Порівнюємо рядок з його оберненим варіантом
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }
}