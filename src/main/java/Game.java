import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        StringManipulator stringManipulator = new StringManipulator();
        String mov = stringManipulator.getMovie();

        // first prompt
        System.out.println("I have chosen a movie: "+ mov);
        // get the size of the movie string
        int size = mov.length();
        String dashes1 = stringManipulator.generateDashes(mov);
        int wrong_words = 0, points = 0, lettersRevealed = 0;


        // Now comes the actual game logic
        System.out.println("Guess the movie: " + dashes1);

        String dashes2 = "";

        String forChecking = dashes1;
        while(true) {
            // Accept one character
            System.out.println("Enter one character: ");
            char ch = sc.next(".").charAt(0);

            // now generate the string of dashes
            dashes2 = stringManipulator.reveal(mov, ch);

            // if the string is just dashes, it means the user didn't guess the correct letter
            if (dashes2.equals(dashes1))
                wrong_words++;
            else
                dashes2 = stringManipulator.merge(dashes2, dashes1);

            System.out.println("You entered: " + dashes2);

            System.out.println("You have guessed: " + wrong_words + " wrong letters");

            // keep track of the number of letters revealed
            for (char c:
                    dashes2.toCharArray()) {
                if (Character.isLetterOrDigit(c))
                    lettersRevealed++;
            }

            // now check if wrong words is 3stringManipulator.generateDashes(mov)
            // if it is, player loses
            if(wrong_words == 3) {
                System.out.println("You lose!");
                break;
            } else if (lettersRevealed == size) {
                System.out.println("You win!");
                break;
            }
            dashes1 = stringManipulator.merge(dashes2, dashes1);
        }

    }
}
