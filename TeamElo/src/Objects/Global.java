package Objects;

import java.util.ArrayList;

public class Global {
    public static final boolean devMode = false;

    public static ArrayList<Team> teamList;
    public static ArrayList<Match> matchList;

    public static final int BASE_ELO = 1200;
    public static int averageElo = 0;
    public static int ELO_CONSTANT = 32;
    public static boolean CONSTANT_ELO = false;
    public static int CONSTANT = 25;

    public static final String PATH = "C:/Users/gant/Documents/IntelliJ/TeamElo/src";

    public static final Team testTeamOne = new Team("Polaris", 1200);
    public static final Team testTeamTwo = new Team("Shikigami", 1200);
    public static final ArrayList<Team> testTeams = new ArrayList<>(){
        {
            add(testTeamOne);
            add(testTeamTwo);
        }
    };
    public static final boolean testTeamOneVictory = true;
}
