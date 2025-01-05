//Leetcode problem - https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05

/*
 Q.- You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.
	Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').
	Return the final string after all such shifts to s are applied.
 */

//Learning - Adding at start starts the effect, and subtracting at end + 1 stops it. The cumulative sum propagates the shift within the range [start, end].

//Solution-

public class ShiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1]; // Extra space for prefix sum adjustment

        // Build the shiftArray based on shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int shiftValue = (direction == 1) ? 1 : -1;

            shiftArray[start] += shiftValue;
            shiftArray[end + 1] -= shiftValue;
        }

        // Compute the cumulative shifts
        int cumulativeShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftArray[i]; // Add current shift to cumulative
            int shiftAmount = (cumulativeShift % 26 + 26) % 26; // Handle negative shifts
            result[i] = shiftCharacter(result[i], shiftAmount); // Update character
        }

        return new String(result); // Return the updated string
    }

    // Function to shift a character by a given amount
    private char shiftCharacter(char c, int shift) {
        int originalIndex = c - 'a'; // Get 0-based index of the character
        int newIndex = (originalIndex + shift) % 26; // Compute new index
        return (char) ('a' + newIndex); // Convert back to character
    }

    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();

        // Example use case
        String s = "abc";
        int[][] shifts = {
            {0, 1, 1}, // Shift 'a' and 'b' forward
            {1, 2, 0}  // Shift 'b' and 'c' backward
        };

        String result = sl.shiftingLetters(s, shifts);
        System.out.println("Final String: " + result);
    }
}
