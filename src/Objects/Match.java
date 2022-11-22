package Objects;

public class Match {
    public Team teamOne;
    public Team teamTwo;
    public boolean teamOneVictory;

    public Match(Team teamOne, Team teamTwo, boolean teamOneVictory) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneVictory = teamOneVictory;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public boolean isTeamOneVictory() {
        return teamOneVictory;
    }
}
