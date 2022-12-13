import java.util.ArrayList;
import java.util.Scanner;
public class Assignment2 {
    static class Caesar {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        public Caesar() {
            for(char letter='a';letter<='z';letter++) {
                alphabet.add(letter);
            }
        }
        public int position_of_char(char letter){
            boolean found = false;
            int j=0;
            for(int i = 0;i < alphabet.size();i++) {
                if (alphabet.get(i) == letter){
                    found = true;
                    break;
                }
                j++;
            }
            if (found == false){
                return 0;
            }
            else return j;
        }
        public char letter_at_pos(int index){
            return alphabet.get(index);
        }
        public char encrypt_char(char letter){
            int index = position_of_char(letter) + 3;
            if (index >= 26){
                index -= 26;
            }
           return letter_at_pos(index);
        }
        public char  decrypt_char(char letter){
            int index = position_of_char(letter) - 3;
            if (index < 0){
                index += 26;
            }
            return letter_at_pos(index);
        }
        public String encrypt(String string){
            String ciphertext = "";
            for (int i = 0; i < string.length(); i++){
                ciphertext = ciphertext + encrypt_char(string.charAt(i));
            }
            return ciphertext;
        }
        public String decrypt(String string){
            String ciphertext = "";
            for (int i = 0; i < string.length(); i++){
                ciphertext = ciphertext + decrypt_char(string.charAt(i));
            }
            return ciphertext;
        }
    }
    public static void main(String[] args){
        Caesar ceaser = new Caesar();
        Scanner scan = new Scanner(System.in);
        String message = null;
        int choice=0;
        do {
        System.out.println("1 Encrypt a message\n2 Decrypt a message\n3 Quit");
        choice = Integer.parseInt(scan.nextLine());
        switch (choice){
            case 1:
                System.out.println("What is the message to encrypt?");
                message = scan.nextLine().toLowerCase();
                System.out.println("Encrypted: " + ceaser.encrypt(message));
                break;
            case 2:
                System.out.println("What is the encrypted message?");
                message = scan.nextLine().toLowerCase();
                System.out.println("Plaintext: " + ceaser.decrypt(message));
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        } while (choice != 3);
    }
}