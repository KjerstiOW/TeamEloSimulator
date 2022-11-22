import Handlers.CSVHandler;
import Handlers.DataHandler;
import Objects.Global;
import Objects.Team;

import java.io.File;
import java.util.ArrayList;

public class ResetElo {
    public static void main(String[] args) throws Exception{
        File csvFile = new File(Main.eloFilePath);

        ArrayList<String> rawData = CSVHandler.csvToRawData(csvFile);
        rawData.remove(0);
        Global.teamList = DataHandler.getTeamsFromRaw(rawData);

        for (Team team: Global.teamList) {
            team.setElo(1200);
        }

        String toWrite = DataHandler.allTeamDataToString(Global.teamList);
        CSVHandler.stringToCSV(toWrite, new File(Main.eloFilePath));

        System.out.println("Team data reset");
    }
}
