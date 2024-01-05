import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String resourceFilePath = "finalno.xlsx";

        // Get the URL of the resource
        URL resourceUrl = Main.class.getClassLoader().getResource(resourceFilePath);

        if (resourceUrl != null) {
            String excelFilePath = resourceUrl.getFile();
            ExcelReaderFilter excelReader = new ExcelReaderFilter(excelFilePath);

            // Read data from Excel file
            List<List<String>> excelData = excelReader.execute(new ArrayList<>());

            RemoveRowFilter removeRowFilter=new RemoveRowFilter();
            excelData= (List<List<String>>) removeRowFilter.execute(excelData);
            ReplaceValueFilter replaceValueFilter=new ReplaceValueFilter();
            excelData= (List<List<String>>) replaceValueFilter.execute(excelData);

            // Display the filtered data
            System.out.println("\nFiltered Data:");
            for (List<?> row : excelData) {
                System.out.println(row);
            }
            String csvFilePath = "/Users/lunadelevska/Downloads/PipeAndFilter/src/main/resources/Untitled spreadsheet - Sheet1.csv";
            writeDataToCsv(csvFilePath, excelData);
        } else {
            System.err.println("File not found in resources folder: " + resourceFilePath);
        }
         // Replace with your desired CSV file path


    }
    private static void writeDataToCsv(String csvFilePath, List<List<String>> data) {
        try (FileWriter fileWriter = new FileWriter(csvFilePath)) {
            for (List<String> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    fileWriter.append(escapeSpecialCharacters(row.get(i)));
                    if (i < row.size() - 1) {
                        fileWriter.append(",");
                    }
                }
                fileWriter.append("\n");
            }
            System.out.println("Data written to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String escapeSpecialCharacters(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            // If the value contains special characters, enclose it in double quotes
            return "\"" + value.replace("\"", "\"\"") + "\"";
        } else {
            return value;
        }
    }
}
