import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        StringManipulator stringManipulator = new StringManipulator();
        String mov = stringManipulator.getMovie();

        // first prompt
        System.out.println("I have chosen a movie: "+ mov);

        // Now comes the actual game logic
        System.out.println("Guess the movie: " + stringManipulator.generateDashes(mov));

        // Accept one character
        System.out.println("Enter one character: ");
        char ch = sc.next(".").charAt(0);

        // now generate the string of dashes
        String dashes = stringManipulator.generateDashes(mov, ch);

    }
}
