
package ohtu;

public class Player {

    // Henrik Borgstrom team FLA goals 0 assists 0

    private String name;

    private String team;

    private Integer goals;

    private Integer assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;    
    }

    public Integer getAssists() {
        return assists;
    }
    
    //Aleksander Barkov   FLA   2 + 15 = 17

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " + " + assists + " = " + (goals+assists);
    }
      
}
