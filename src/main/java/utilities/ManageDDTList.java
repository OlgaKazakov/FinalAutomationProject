package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDTList extends CommonOps{

    public static List<String> readCSV (String CSVFile){
        List <String> lines = null;
        File file = new File(CSVFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error in reading of file .csv. See details: "+e);;
        }
        return lines;
    }


    public static Object [][] getDataFromCSVOneColumn(String filepath){
        List <String> csvData = readCSV(filepath);
        Object[][] data = new Object[csvData.size()][1];
        for (int i =0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i);
        }
        return data;
    }

    @DataProvider(name = "data-provider-tasks")
    public Object [][] getDataObject() {
            return getDataFromCSVOneColumn(getData("DDTFileTasks"));
    }
}
