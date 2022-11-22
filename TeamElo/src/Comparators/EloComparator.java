package Comparators;

import Objects.Team;

import java.util.Comparator;

public class EloComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        Team teamOne = (Team) o1;
        Team teamTwo = (Team) o2;

        if (teamOne.getElo() == teamTwo.getElo())
            return teamTwo.getName().compareTo(teamOne.getName());

        return Integer.compare(teamOne.getElo(), teamTwo.getElo());
    }
}
