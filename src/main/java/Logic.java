import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class takes care of the important logic required for the game.
 * These methods are not present in the standard library.
 *
 * @author Jonathan_Gerard
 * @version 0.1.0
 */
public final class Logic {
    /**
     *
     * @param file The file that you want to read the contents of.
     * @return Returns a String containing the contents of the file.
     * @throws FileNotFoundException If file isn't found.
     */
    public String contentsInFile(File file) throws FileNotFoundException {
        String str = "";
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            str = str.concat(sc.nextLine() + "\n");
        sc.close();
        return str;
    }

    /**
     *
     * @param file The file to be processed.
     * @return The number of lines in the file.
     */
    public int countLinesInFile(File file) throws FileNotFoundException {
        int lines = 0;
        String str = this.contentsInFile(file);
        char[] arr = str.toCharArray();
        for (char ch: arr) {
            if (ch == '\n')
                lines++;
        }
        return lines;
    }


    /**
     *
     * @param arr Array from which a random element must be selected.
     * @return Returns a random element
     */
    public String chooseRandomFromArray(String[] arr) {
        String chosen = "";
        chosen = arr[(int)(Math.random() * arr.length)];
        return chosen;
    }

    /**
     *
     * @param file File whose lines are to be put in the array
     * @return A string array containing the file's lines as its elements
     * @throws FileNotFoundException In case file is not found.
     */
    public String[] generateArrayFromFile(File file) throws FileNotFoundException {
        String[] arr = new String[this.countLinesInFile(file)];
        Scanner sc = new Scanner(file);

        int counter = 0;
        while (sc.hasNextLine()){
            arr[counter] = sc.nextLine();
            counter++;
        }
        return arr;
    }

    /**
     * This function removes spaces and any other special characters from a String.
     * @param str The String itself which has to be formatted.
     * @return Returns a new String with all special characters removed.
     */
    public String removeSpecial(String str) {
        String newStr = "";
        char[] strArr = str.toCharArray();
        for (char ch:
             strArr) {
            if (Character.isLetterOrDigit(ch))
                newStr = newStr.concat(String.valueOf(ch));
        }
        return newStr;
    }



}
