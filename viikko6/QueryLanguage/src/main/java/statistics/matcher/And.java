package statistics.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import statistics.Player;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    public And(Matcher matcher, Matcher[] matchers) {
        List<Matcher> asList = new ArrayList<Matcher>(Arrays.asList(matchers));
        asList.add(matcher);
        this.matchers = asList.toArray(new Matcher[]{});
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
