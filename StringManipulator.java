/**
 * This class contains a set of methods useful in games like hangman and dumb-charades - games that involve string manipulation.
 * This code is free to use, modify and re-distribute.
 * 
 * @author Jonathan Gerard (jona2jef@gmail.com)
 * @version 0.1.0
 */

class StringManipulator {
    
    /**
     * Remove all spaces and special characters in a string
     * 
     * @param str A string value which is to be filtered.
     */
    String removeSpaces(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++ ) {
            if (Character.isLetterOrDigit(str.toCharArray()[i]))
                newStr = newStr + String.valueOf(str.toCharArray()[i]);
        }
        return newStr;
    }
    
    /**
     * Generate a string of dashes whose length is equivalent to a given string.
     * @param str A string value
     */
    String generateDash(String str) {
        String dashes = "";
        for (int i = 0; i < this.removeSpaces(str).length(); i++)
            dashes = dashes + "_";
        return dashes;
    }
    
    /**
     * Reveal a character in a string of dashes using the help of the original string.
     * 
     * @param str the String currently being handled.
     * @param ch The character that must be revealed.
     */
    String reveal(String str, char ch) {
        String newStr = "";
        str = this.removeSpaces(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.toCharArray()[i] == ch)
                newStr = newStr + String.valueOf(ch);
            else
                newStr = newStr + "_";
        }
        return newStr;
    }
    
    /**
     * Combine two strings of the same length.
     * Parameters can be interchanged, but must definitely be of SAME LENGTH.
     * @param str Original string (or first string)
     * @param other Other string (or second string)
     */
    String combine(String str, String other) {
        String newStr = ""; // empty default
        if (str.length() != other.length()) // immediately exit if both string have unequal lengths
            return "";
        char[] str1 = str.toCharArray();    // convert the strings into arrays
        char[] str2 = other.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetterOrDigit(str1[i])) { // if the character in str1 is not a letter or digit
                if (!Character.isLetterOrDigit(str2[i])) // and same for str2
                    newStr = newStr + String.valueOf(str1[i]);  // then simply append whatever is there in str1 in the current place
                else {
                    newStr = newStr + String.valueOf(str2[i]);  // else if the character in str2 is a letter/digit, append it
                }
            }
            else {  // if character in str1 is a letter/digit
                newStr = newStr + String.valueOf(str1[i]);  // append it
            }
        }
        return newStr;
    }
}