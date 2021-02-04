import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

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

    /**
     * Creates a string of dashes
     * @param str Actual String itself
     * @param ch Character to reveal
     * @return New formatted String
     */
    public String reveal(String str, char ch) {
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

        return newStr;
    }

    /**
     * Generates a String of dashes ("_") equal whose size is definite
     * @param str The String itself
     * @return A string of dashes whose size is same as the string
     */
    public String generateDashes(String str)
    {
        String newStr = "";
        for (int count = 0; count < str.length(); count++) {
            newStr = newStr.concat("_");
        }
        return newStr;
    }

    public String fromCharArray(char [] arr) {
        String str = "";
        for (char ch:
             arr) {
            str = str.concat(String.valueOf(ch));
        }
        return str;
    }

    public String merge(String str1, String str2) {
        String newStr = "";
        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();
        char [] arr3 = new char[str1.length()]; // can be str2.length as well

        // first check if both the string sizes are equal
        if (arr1.length != arr2.length) {
            System.out.println("Strings must be of same length.");
            System.exit(1);
        }

        int count = 0;
        // first combine string 1
        for (char ch:
             arr1) {
            arr3[count] = ch;
            count++;
        }

        // reset count
        count = 0;

        // then combine string 2
        for (char ch:
             arr2) {
            arr3[count] = ch;
            count++;
        }

        return this.fromCharArray(arr3);
    }

}
