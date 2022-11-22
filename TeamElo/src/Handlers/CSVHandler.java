package Handlers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVHandler {
    public static ArrayList<String> csvToRawData(File csvFile) throws FileNotFoundException {
        Scanner reader = new Scanner(csvFile);
        ArrayList<String> lines = new ArrayList<>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            lines.add(data);
        }

        reader.close();

        return lines;
    }

    public static void stringToCSV(String data, File csvFile) throws IOException {
        FileWriter myWriter = new FileWriter(csvFile);
        myWriter.write(data);
        myWriter.close();
    }

    public static void appendDataToCSV(String data, File csvFile) throws IOException{

        try(FileWriter fw = new FileWriter(csvFile, true);
            BufferedWriter writer = new BufferedWriter(fw)) {

            writer.write(data);
        }
    }
}
