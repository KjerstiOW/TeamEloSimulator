package Objects;

public class Team {
    public String name;
    public int elo;

    public Team(String name) {
        this.name = name;
        this.elo = Global.BASE_ELO;
    }

    public Team(String name, int elo) {
        this.name = name;
        this.elo = elo;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName() + "," + this.getElo();
    }
}
