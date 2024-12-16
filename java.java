import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';

                ch = (char) ((ch - base + shift) % 26 + base);
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


        System.out.println("Podaj klucz przesunięcia:");
        int shift = scanner.nextInt();

        czytText();

        String encrypted = encrypt(text, shift);
        System.out.println("Zaszyfrowany tekst: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Odszyfrowany tekst: " + decrypted);
    }
    
    public static void czytText(){
        System.out.println("Podaj tekts to zaszyfrowania:");
        String text = scanner.nextLine();
    }
}
