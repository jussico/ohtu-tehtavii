package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    private Matcher query;

    public static void main(String[] args) {
        Statistics stats = new Statistics(
                new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        // Matcher m = query.build();

        // Matcher m = query.playsIn("NYR").build();
        // Matcher m = query.hasAtLeast(5, "goals").build();

        // Matcher m = query.playsIn("NYR").hasAtLeast(5, "goals").build();

        // Matcher m = query.playsIn("NYR")
        // .hasAtLeast(5, "goals")
        // .hasFewerThan(10, "goals").build();

        
        Matcher m1 = query.playsIn("EDM").hasAtLeast(40, "points").build();
        Matcher m2 = query.playsIn("PHI").hasAtLeast(10, "assists").hasFewerThan(5, "goals").build();
        // Matcher m2 = query.playsIn("EDM").hasAtLeast(40, "points").build();
        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }

    public QueryBuilder() {
        this.query = new All();
    }

    public Matcher build() {
        return this.query;
    }

    public QueryBuilder playsIn(String team) {
        this.query = new And(this.query, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.query = new And(this.query, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.query = new And(this.query, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher aa, Matcher bee) {
        Or as = new Or(this.query, aa);
        Or bs = new Or(this.query, bee);
        Matcher oneOf = new Matcher() {
            final Or a = as;
            final Or b = bs;
            @Override
            public boolean matches(Player p) {
                return a.matches(p) || b.matches(p);
            }
        };
        this.query = oneOf;
        return this;
    }

}
