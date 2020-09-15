import java.util.*;

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if (a.score > b.score)
            return -1;
        else if (a.score < b.score)
            return 1;
        else if (a.score == b.score)
            if (Integer.valueOf(a.name.compareToIgnoreCase(b.name)) > 0)
                return 1;
            else if(Integer.valueOf(a.name.compareToIgnoreCase(b.name)) < 0)
                return -1;
        return 0;
    }
}