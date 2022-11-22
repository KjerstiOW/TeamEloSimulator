import Handlers.CSVHandler;

import java.io.File;
import java.util.ArrayList;

public class RankPlayers {
    /*public static final boolean RANK_DEV_DATA = false;

    public static void printRankings(ArrayList<Team> rankedPlayers, int type) {
        switch(type) {
            case 0:
                for (int i = 0; i < rankedPlayers.size(); i++) {
                    Team currentPlayer = rankedPlayers.get(i);

                    System.out.println("\t" + (i + 1) + ": " + currentPlayer.getName() + ", " + currentPlayer.getImposterElo());
                }
                break;
            case 1:
                for (int i = 0; i < rankedPlayers.size(); i++) {
                    Team currentPlayer = rankedPlayers.get(i);

                    System.out.println("\t" + (i + 1) + ": " + currentPlayer.getName() + ", " + currentPlayer.getCrewElo());
                }
                break;
            case 2:
                for (int i = 0; i < rankedPlayers.size(); i++) {
                    Team currentPlayer = rankedPlayers.get(i);
                    int combinedElo = currentPlayer.getCrewElo() + currentPlayer.getImposterElo();
                    combinedElo /= 2;

                    System.out.println("\t" + (i + 1) + ": " + currentPlayer.getName() + ", " + combinedElo);
                }
                break;
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        File csvFile;

        if (RANK_DEV_DATA) {
            csvFile = new File(Main.devEloPath);
        } else {
            csvFile = new File(Main.eloFilePath);
        }

        ArrayList<String> rawData = CSVHandler.csvToRawData(csvFile);
        rawData.remove(0);
        Global.players = DataHandler.getPlayersFromRaw(rawData);

        ArrayList<Team> rankedImposters = DataHandler.rankImposterElo(Global.players);
        ArrayList<Team> rankedCrew = DataHandler.rankCrewElo(Global.players);
        ArrayList<Team> rankedCombined = DataHandler.rankCombinedElo(Global.players);

        System.out.println("Top Imposters");
        printRankings(rankedImposters, 0);
        System.out.println("Top Crew");
        printRankings(rankedCrew, 1);
        System.out.println("Top Combined");
        printRankings(rankedCombined, 2);

    }*/
}
