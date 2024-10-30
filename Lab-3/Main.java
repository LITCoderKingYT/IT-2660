public class Main 
{
  public static void main(String[] args) 
  {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Best case: pattern is an empty string (should match at index 0)
    String bestCase = "";
    long startTime = System.nanoTime(); // Initialize startTime here
    int index = match(text, bestCase);
    long endTime = System.nanoTime(); // Initialize endTime here
    long elapsedTime = endTime - startTime; // Calculate elapsedTime here

    if (index >= 0)
      System.out.println("best-case input matched at index " + index + ", elapsed time: " + elapsedTime + " ns");
    else
      System.out.println("best-case input unmatched, elapsed time: " + elapsedTime + " ns");

    // Worst case: pattern is not found (pattern longer than text)
    String worstCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789ABC";
    startTime = System.nanoTime(); // Initialize startTime here
    index = match(text, worstCase);
    endTime = System.nanoTime(); // Initialize endTime here
    elapsedTime = endTime - startTime; // Calculate elapsedTime here

    if (index >= 0)
      System.out.println("worst-case input matched at index " + index + ", elapsed time: " + elapsedTime + " ns");
    else
      System.out.println("worst-case input unmatched, elapsed time: " + elapsedTime + " ns");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) 
  {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++)
    {
      if (isMatched(i, text, pattern))
        return i;
    }
    return -1;
  }

  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, String pattern) 
  {
    for (int k = 0; k < pattern.length(); k++) 
    {
      if (pattern.charAt(k) != text.charAt(i + k)) 
      {
        return false;
      }
    }
    return true;
  }
}
