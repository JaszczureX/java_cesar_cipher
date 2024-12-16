import java.util.Scanner;

public class CaesarCipher {
    // Metoda do szyfrowania tekstu
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Sprawdź czy znak jest literą
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                // Przesuń literę w alfabecie
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result.append(ch);
        }
        
        return result.toString();
    }

    // Metoda do deszyfrowania tekstu
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // Odwrotne przesunięcie
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tekst do zaszyfrowania:");
        String text = scanner.nextLine();

        System.out.println("Podaj klucz przesunięcia:");
        int shift = scanner.nextInt();

        // Szyfrowanie
        String encrypted = encrypt(text, shift);
        System.out.println("Zaszyfrowany tekst: " + encrypted);

        // Deszyfrowanie
        String decrypted = decrypt(encrypted, shift);
        System.out.println("Odszyfrowany tekst: " + decrypted);
    }
}