import EloSystem.EloHandler;
import Handlers.CSVHandler;
import Handlers.DataHandler;
import Objects.Global;
import Objects.Match;
import Objects.StringErrorException;
import Objects.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static final String eloFilePath = Global.PATH + "/EloData/elodata.csv";
    public static final String matchFilePath = Global.PATH + "/EloData/matchdata.csv";
    public static final String resultsFilePath = Global.PATH + "/EloData/results.csv";

    public static void init() throws FileNotFoundException, StringErrorException{
        File csvTeamFile;
        File csvMatchFile;

        csvTeamFile = new File(eloFilePath);
        csvMatchFile = new File(matchFilePath);

        ArrayList<String> rawTeamData = CSVHandler.csvToRawData(csvTeamFile);
        ArrayList<String> rawMatchData = CSVHandler.csvToRawData(csvMatchFile);

        rawTeamData.remove(0);
        rawMatchData.remove(0);
        Global.teamList = DataHandler.getTeamsFromRaw(rawTeamData);
        Global.matchList = DataHandler.getMatchesFromRaw(rawMatchData);
    }

    public static void printRankedTeams(ArrayList<Team> teamList) {
        ArrayList<Team> rankedTeams = DataHandler.rankTeamElo(teamList);

        for (Team team: rankedTeams) {
            System.out.println(team.getName() + ", " + team.getElo());
        }
    }

    public static void updateElo(Team teamOne, Team teamTwo, boolean teamOneVictory) {
        double[] newElo = EloHandler.calculateElo(teamOne.getElo(), teamTwo.getElo(), Global.K_CONSTANT, teamOneVictory);

        int diffInTeamOneElo = (int) newElo[0] - teamOne.getElo();
        int diffInTeamTwoElo = (int) newElo[1] - teamTwo.getElo();

        if (Global.ENABLE_CONSTANT_ELO) {
            if (diffInTeamOneElo > 0) {
                diffInTeamOneElo = Global.CONSTANT_ELO_DIFFERENCE;
                diffInTeamTwoElo = -Global.CONSTANT_ELO_DIFFERENCE;
            } else {
                diffInTeamOneElo = -Global.CONSTANT_ELO_DIFFERENCE;
                diffInTeamTwoElo = Global.CONSTANT_ELO_DIFFERENCE;
            }
        }

        teamOne.setElo(teamOne.getElo() + diffInTeamOneElo);
        teamTwo.setElo(teamTwo.getElo() + diffInTeamTwoElo);
    }

    public static void printRankedTeams() {
        ArrayList<Team> rankedTeams = DataHandler.rankTeamElo(Global.teamList);

        System.out.println("Rank: Team Name, Elo");

        for (int i = 0; i < rankedTeams.size(); i++) {
            Team team = rankedTeams.get(i);

            System.out.println("#"+ (i+1) + ": " + team.getName() + ", " + team.getElo());
        }
    }

    public static void runMatch(Match match) {
        Team teamOne = match.getTeamOne();
        Team teamTwo = match.getTeamTwo();
        boolean teamOneVictory = match.isTeamOneVictory();

        updateElo(teamOne, teamTwo, teamOneVictory);
    }

    public static void runAllMatches(ArrayList<Match> matches) {
        for (Match match: matches) {
            runMatch(match);
        }
    }

    public static void saveData() throws IOException {
        String toWrite = DataHandler.allTeamDataToString(Global.teamList);

        CSVHandler.stringToCSV(toWrite, new File(resultsFilePath));
    }

    public static void main (String[] args) throws IOException {
        try {
            init();
        } catch (StringErrorException e) {
            e.printStackTrace();
        }
        runAllMatches(Global.matchList);
        printRankedTeams();
        saveData();
    }
}
