import java.util.Random;
public class Task1 {
    public static void main(String[] args) {
        int length = 8; 
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }
    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
