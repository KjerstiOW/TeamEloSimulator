package Handlers;

import Comparators.EloComparator;
import Objects.Global;
import Objects.Match;
import Objects.Team;

import java.util.ArrayList;

public class DataHandler {
    public static ArrayList<Team> getTeamsFromRaw(ArrayList<String> rawData) {
        ArrayList<Team> teams = new ArrayList<>();

        for (String line: rawData) {
            String[] teamData = line.split(",");

            teams.add(new Team(teamData[0], Integer.parseInt(teamData[1])));
        }

        return teams;
    }

    public static int getAverageElo(ArrayList<Team> teamList) {
        int totalElo = 0;

        for (Team team: teamList) {
            totalElo += team.getElo();
        }

        return totalElo/teamList.size();
    }

    public static ArrayList<Team> reverseList(ArrayList<Team> list) {
        ArrayList<Team> revArrayList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            revArrayList.add(list.get(i));
        }

        return revArrayList;
    }


    public static ArrayList<Team> rankTeamElo(ArrayList<Team> teamList) {
        teamList.sort(new EloComparator());

        return reverseList(teamList);
    }

    public static String allTeamDataToString(ArrayList<Team> teamList) {
        String total = "Team Name,Team Elo,\n";

        teamList = rankTeamElo(teamList);

        for (Team team: teamList) {
            total += team.getName() + "," + team.getElo()+ ",\n";
        }

        return total;
    }

    public static Team getTeamFromName(String teamName, ArrayList<Team> teamList) {
        for (Team team: teamList) {
            if (teamName.equals(team.getName())) {
                return team;
            }
        }
        System.out.println("ERROR couldn't find teamName from String. teamName = " + teamName);
        return null;
    }

    public static ArrayList<Match> getMatchesFromRaw(ArrayList<String> rawData) {
        ArrayList<Match> matches = new ArrayList<>();

        for (String line: rawData) {
            String[] matchData = line.split(",");

            Team teamOne = getTeamFromName(matchData[0], Global.teamList);
            Team teamTwo = getTeamFromName(matchData[1], Global.teamList);

            boolean teamOneVictory = Boolean.parseBoolean(matchData[2]);

            Match match = new Match(teamOne, teamTwo, teamOneVictory);

            matches.add(match);
        }

        return matches;
    }
}
