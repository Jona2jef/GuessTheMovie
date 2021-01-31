import java.io.FileNotFoundException;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        StringManipulator stringManipulator = new StringManipulator();
        String mov = stringManipulator.getMovie();

        // for testing purpose
        System.out.println(mov);

        // Now comes the actual game logic

        // First get the string of dashes

        String dashes = "";
        for (int i = 0; i < mov.length(); i++) {
            dashes += "_";
        }

        System.out.println(dashes);

    }
}
