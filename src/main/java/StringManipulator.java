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

    public String generateDashes(String str, char ch) {
        String dashes = "_".repeat(str.length());

        String newStr = "";
        // find a match
        for (char c:
                str.toCharArray()) {
            if (c == ch) {
                newStr = newStr.concat(String.valueOf(c));
            }
            else {
                newStr = newStr.concat("_");
            }
        }

        // print the new string of dashes
        System.out.println(newStr);

        return newStr;
    }

    public String generateDashes(String str)
    {
        String newStr = "";
        for (int count = 0; count < str.length(); count++) {
            newStr = newStr.concat("_");
        }
        return newStr;
    }
}
