import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Assignment7 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        String file = "", line;
        ArrayList<String> filelines = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Character> chars = new ArrayList<Character>();
        try {
            System.out.println("Enter a filename: ");
            file = scan.nextLine();
            File myFile = new File(file);
            scan = new Scanner(myFile);
            while (scan.hasNextLine()){
                line = scan.nextLine();
                filelines.add(line);
            }
            for (String e : filelines) {
                String[] word = e.split(" ");
                for (String a : word) {
                    words.add(a);
                    char[] characters = a.toCharArray();
                    for (Character c: characters) {
                        if (Character.isLetter(c))
                        chars.add(c);
                    }
                }
            }
            System.out.println("Lines: " + filelines.size());
            System.out.println("Words: " + words.size());
            System.out.println("Chars: " + chars.size());
        } catch (FileNotFoundException e) {
            System.out.println("File error: " + file + " (No such file or directory)");
        } finally {
            scan.close();
        }
    }
}
