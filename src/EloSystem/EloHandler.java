package EloSystem;

public class EloHandler {
    public static double Probability(double rating1, double rating2) {
        return 1.0 / (1 + (float) (Math.pow(10, (rating1 - rating2) / 400)));
    }

    public static double[] calculateElo(double teamOneElo, double teamTwoElo, int K, boolean teamOneVictory) {
        double Pb = Probability(teamOneElo, teamTwoElo);
        double Pa = Probability(teamTwoElo, teamOneElo);

        //Player 1 wins
        if (teamOneVictory) {
            teamOneElo += K * (1 - Pa);
            teamTwoElo += K * (0 - Pb);
        } else {
            //Player 2 wins
            teamOneElo += K * (0 - Pa);
            teamTwoElo += K * (1 - Pb);
        }

        double[] output = new double[2];
        output[0] = Math.round(teamOneElo * 1000000.0) / 1000000.0;
        output[1] = Math.round(teamTwoElo * 1000000.0) / 1000000.0;

        return output;
    }
}