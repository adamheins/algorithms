package tutorialExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSort {


    public static void main(String[] args) {
        String[] words = {"adam", "dog", "tree", "god", "mada", "beer", "red", 
                          "der"};
        List<String> sortedList = anagramSort(Arrays.asList(words));
        for (String word : sortedList)
            System.out.println(word);
    }


    public static List<String> anagramSort(List<String> list) {

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String word : list) {

            // Sort the characters in the string.
            char [] charSeq = word.toCharArray();
            Arrays.sort(charSeq);
            String sortedWord = new String(charSeq);

            // If the sorted word is already a key in the map, get its value 
            // list and add the unsorted word to it. Otherwise, create a new 
            // list with the unsorted word as the first value, and put the list
            // in the map with the sorted word as the key.
            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> keyValues = new ArrayList<String>();
                keyValues.add(word);
                map.put(sortedWord, keyValues);
            }
        }

        List<String> sortedList = new ArrayList<String>();

        // Add the values from each key to the anagram-sorted list. The values 
        // in each key are anagrams of each other.
        for (List<String> anagrams : map.values()) {
            for (String word : anagrams)
                sortedList.add(word);
        }

        return sortedList;
    }
}
