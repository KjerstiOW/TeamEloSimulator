package Handlers;

import Comparators.EloComparator;
import Objects.Global;
import Objects.Match;
import Objects.StringErrorException;
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

    public static Team getTeamFromName(String teamName, ArrayList<Team> teamList) throws StringErrorException{
        for (Team team: teamList) {
            if (teamName.equals(team.getName())) {
                return team;
            }
        }

        throw new StringErrorException("ERROR 69420: couldnt get Team from String, " + teamName);
    }

    public static Team generateTeam(String teamName, ArrayList<Team> teamList) {
        for (Team team: teamList) {
            if (teamName.equals(team.getName())) {
                return team;
            }
        }

        Team newTeam = new Team(teamName, Global.BASE_ELO);
        Global.teamList.add(newTeam);

        return newTeam;
    }

    public static ArrayList<Match> getMatchesFromRaw(ArrayList<String> rawData) throws StringErrorException{
        ArrayList<Match> matches = new ArrayList<>();

        for (String line: rawData) {
            if (!line.equals("")) {
                String[] matchData = line.split(",");

                Team teamOne = generateTeam(matchData[0], Global.teamList);
                Team teamTwo = generateTeam(matchData[1], Global.teamList);


                Match match = new Match(teamOne, teamTwo, true);

                matches.add(match);
            }
        }

        return matches;
    }
}
