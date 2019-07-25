public class Palindrome extends  OffByOne{
    public Deque<Character> wordToDeque(String word){
        Deque A = new LinkedListDeque<Character>();
        for(int i =0; i<word.length(); i++ ) {
            A.addLast(word.charAt(i));
        }
        return A;
    }

    /**
     * make sure whether word is Palindrome.
     */
    public boolean isPalindrome(String word){
      /**  iterate solution:
       * Deque A =wordToDeque(word);
        while (true) {
            if (A.size() <= 1) {
                return true;
            } else {
                if (A.removeFirst() != A.removeLast()) {
                    return false;
                }
            }

        }*/
      // recursion solution:
        Deque A = wordToDeque(word);
        return help(A);

    }
    public  boolean help (Deque Q) {
        if (Q.size() <=1) {
            return true;
        } else if (Q.removeFirst() ==Q.removeLast()) {
           return help (Q);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque A = wordToDeque(word);
        return help (A,cc);
    }
    public  boolean help (Deque Q,CharacterComparator cc) {
        if (Q.size() <=1) {
            return true;
        } else if (cc.equalChars((char)Q.removeFirst(),(char)Q.removeLast())) {
            return help (Q,cc);
        } else {
            return false;
        }
    }



}
