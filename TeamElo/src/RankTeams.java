import Handlers.CSVHandler;
import Handlers.DataHandler;
import Objects.Team;

import java.io.File;
import java.util.ArrayList;

public class RankTeams {
    public static void printRankings(ArrayList<Team> rankedTeams) {
        for (int i = 0; i < rankedTeams.size(); i++) {
            Team currentTeam = rankedTeams.get(i);

            System.out.println("\t" + (i + 1) + ": " + currentTeam.getName() + ", " + currentTeam.getElo());
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        File csvFile;

        csvFile = new File(Main.eloFilePath);

        ArrayList<String> rawData = CSVHandler.csvToRawData(csvFile);
        rawData.remove(0);

        ArrayList<Team> rankedTeams = DataHandler.rankTeamElo(DataHandler.getTeamsFromRaw(rawData));

        System.out.println("Top Teams:");
        printRankings(rankedTeams);
    }
}
