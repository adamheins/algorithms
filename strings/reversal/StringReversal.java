public class StringReversal {
    
    /**
     * Checks if a string is a palindrome.
     * 
     * @param sequence The string to check.
     * 
     * @return True if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String sequence) {
        int n = sequence.length();
        
        // Compare the ith character to the ith-from-the-end character.
        for (int i = 0; i < n / 2; i++) {
            if (sequence.charAt(i) != sequence.charAt(n - 1 - i))
                return false;
        }
        return true;
    }
    
    
    /**
     * Reverses the order of an array of characters.
     * 
     * @param sequence The array of characters being reversed.
     */
    public static void reverseCharArray(char [] sequence) {
        int n = sequence.length;
        
        // Swap the ith character with the ith-from-the-end character.
        for (int i = 0; i < n / 2; i++) {
            char temp = sequence[i];
            sequence[i] = sequence[n - 1 - i];
            sequence[n - 1 - i] = temp;
        }
    }
    
    
    /**
     * Reverses the order of a subsequence of an array of characters, 
     * from the character at startIndex to the character at endIndex - 1.
     * 
     * @param sequence The array of characters.
     * @param start The starting index, inclusive.
     * @param end The ending index, exclusive.
     */
    public static void reverseCharArray(char [] sequence, int startIndex,
            int endIndex) {
        
        // Swap the ith character with the ith-from-the-end character.
        for (int i = 0; i < (endIndex - startIndex) / 2; i++) {
            char temp = sequence[startIndex + i];
            sequence[startIndex + i] = sequence[endIndex - 1 - i];
            sequence[endIndex - 1 - i] = temp;
        }
    }
    
    
    /**
     * Reverses the order of the characters in each word in an array of
     * characters. A word is defined as a subsequence of array delimited
     * by the delimiter character.
     * 
     * @param phrase The character array.
     * @param delimiter The character that delimits separate words.
     */
    public static void reverseWordsInCharArray(char [] phrase,
            char delimiter) {
        
        // Keeps track of the location of the previous index of the delimiter.
        int start = 0;
        
        // Search the character array for the delimiter character.
        // Reverse the sequence between two delimiters.
        for (int i = 0; i < phrase.length; i++) {
            if (phrase[i] == delimiter) {
                reverseCharArray(phrase, start, i);
                start = ++i;
            }
        }
        
        // Reverse the characters between the last delimiter and the end of the phrase.
        reverseCharArray(phrase, start, phrase.length);
    }
}
