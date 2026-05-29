// Online Java - IDE, Code Editor, Compiler

// Online Java is a quick and easy tool that helps you to build, compile, test your programs online.

// Write your Java code here
import java.util.*;
public class Main {
  public static void main(String[] args) {
      runTests();
  }
  
  // --- TEST CASES ENGINE ---
    static void runTests() {
        
        System.out.println("--- STARTING LEETCODE 271 TESTS ---\n");

        // Test Case 1: Standard Strings
        verify(Arrays.asList("hello", "world"), "Test 1: Standard strings");

        // Test Case 2: Empty List
        verify(new ArrayList<>(), "Test 2: Completely empty list");

        // Test Case 3: List containing empty strings (This tests your -1 split fix!)
        verify(Arrays.asList("", "hello", "", "world", ""), "Test 3: Trailing and leading empty strings");

        // Test Case 4: Strings containing common delimiters like symbols, spaces, and hashes
        verify(Arrays.asList("C# is cool", "hello, world", "split/me:now"), "Test 4: Strings with special symbols");

        // Test Case 5: Single Item List
        verify(Arrays.asList("standalone"), "Test 5: Single item list");
    }

    static void verify(List<String> input, String testName) {
        String encoded = encode(input);
        List<String> decoded = decode(encoded);

        System.out.println(testName);
        System.out.println("-> Input  : " + input);
        System.out.println("-> Encoded: " + encoded.replace((char)257, '|')
                                                  .replace((char)258, '∅') + " (Delimiters visualized)");
        System.out.println("-> Decoded: " + decoded);
        
        if (input.equals(decoded)) {
            System.out.println("Result    : ✅ PASSED\n");
        } else {
            System.out.println("Result    : ❌ FAILED\n");
        }
    }
  
  
  static String encode(List<String> strs){
      if(strs.size()==0){
          // unique character that will almost be used in normal text
          return Character.toString((char)258);
      }else{
          String delimiter = Character.toString((char)257);
          StringBuilder sb = new StringBuilder();
          
          for(String s:strs){
              sb.append(s);
              sb.append(delimiter);
          }
          
          sb.deleteCharAt(sb.length() -1  );
          
          return sb.toString();
      }
  }
  
  static List<String> decode(String s){
      if(s.equals(Character.toString((char)258))){
          return Collections.emptyList();
      }else{
          String delimiter = Character.toString((char)257);
         return Arrays.asList(s.split(delimiter,-1));
      }
  }
}
