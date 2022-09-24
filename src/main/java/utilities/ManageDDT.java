package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

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

    public static Object [][] getDataFromCSVTwoColumns(String filepath){
        List <String> csvData = readCSV(filepath);
        Object[][] data = new Object[csvData.size()][2];
        for (int i =0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

    @DataProvider (name = "data-provider-users")
    public Object [][] getDataObject() {
            return getDataFromCSVTwoColumns(getData("DDTFileUsers"));
    }
}
