import java.util.Scanner;

public class Main {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char upper = Character.isLowerCase(ch) ? 'a' : 'A';

                ch = (char) ((ch - upper + shift) % 26 + upper);
            }
            result.append(ch);
        }
        
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tekst do zaszyfrowania ");
        String text = scanner.nextLine();

        System.out.println("Podaj klucz przesunięcia ");
        int shift = scanner.nextInt();

        String encrypted = encrypt(text, shift);
        System.out.println("Zaszyfrowany tekst " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Odszyfrowany tekst " + decrypted);
    }
}
