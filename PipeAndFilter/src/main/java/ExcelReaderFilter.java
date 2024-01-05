import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderFilter implements Filter<List<List<String>>> {

    private String filePath;

    public ExcelReaderFilter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<List<String>> execute(List<?> input) {
        List<List<String>> excelData = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            // Assuming data is in the first sheet
            Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();

                // Iterate over each cell in the row
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData.add(cell.toString());
                }

                excelData.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return excelData;
    }


//    public static void main(String[] args) {
//
//        // Example usage of ExcelReaderFilter with file in resources folder
//        String resourceFilePath = "convertcsv.xlsx"; // Change this to your file name
//
//        // Get the URL of the resource
//        URL resourceUrl = ExcelReaderFilter.class.getClassLoader().getResource(resourceFilePath);
//
//        if (resourceUrl != null) {
//            String excelFilePath = resourceUrl.getFile();
//            ExcelReaderFilter excelReader = new ExcelReaderFilter(excelFilePath);
//
//            List<List<String>> excelData = excelReader.execute(new ArrayList<>());
//
//            // Display the extracted Excel data
//            for (List<String> row : excelData) {
//                System.out.println(row);
//            }
//        } else {
//            System.err.println("File not found in resources folder: " + resourceFilePath);
//        }
//    }

}