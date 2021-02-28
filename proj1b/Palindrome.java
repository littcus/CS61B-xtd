public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            char c = word.charAt(i);
            result.addLast(c);
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> lst = wordToDeque(word);
        return helper(lst);
    }

    /** a helper func that checks if the 2 characters at the 2 ends of the list the same */
    public boolean helper(Deque<Character> lst) {
        if (lst.size() == 0 || lst.size() == 1) {
            return true;
        } else {
            Character first = lst.removeFirst();
            Character last = lst.removeLast();
            return first == last && helper(lst);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> lst = wordToDeque(word);
        return helper2(lst, cc);
    }


    public boolean helper2(Deque<Character> lst, CharacterComparator cc) {
        if (lst.size() == 0 || lst.size() == 1) {
            return true;
        } else {
            Character first = lst.removeFirst();
            Character last = lst.removeLast();
            return cc.equalChars(first, last) && helper2(lst, cc);
        }
    }



}
