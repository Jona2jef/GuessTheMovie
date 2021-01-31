import java.io.File;
import java.io.FileNotFoundException;

public class StringManipulator {
    public String getMovie() throws FileNotFoundException {
        Logic l = new Logic();
        File f = new File("C:\\Users\\win10\\Desktop\\movies.txt");
        // get the contents of the file
        String str = l.contentsInFile(f);

        // print out the statement for testing purpose
        //System.out.println(str);

        // get the number of lines in the file
        // in this case, you need a predefined size fot creating the movies array
        int lines = l.countLinesInFile(f);

        // generate the array of movie strings
        String[] movies = l.generateArrayFromFile(f);

        // pick a random movie
        String mov = l.chooseRandomFromArray(movies);

        // for testing purposes only
        //System.out.println(mov);

        // remove all special characters from the String
        mov = l.removeSpecial(mov);

        // display it for testing purpose
        //System.out.println(mov);

        return mov;
    }
}
