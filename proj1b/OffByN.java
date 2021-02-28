public class OffByN implements CharacterComparator {

    private int diff;

    public OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int actualDiff = Math.abs(x - y);
        if (actualDiff == diff) {
            return true;
        }
        return false;
    }
 }
