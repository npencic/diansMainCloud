import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReplaceValueFilter implements Filter<List<?>> {

    @Override
    public List<?> execute(List<?> input) {
        List<Object> filteredData = new ArrayList<>();

        for (Object row : input) {
            if (row instanceof List) {
                List<?> listRow = (List<?>) row;

                // Check if the ninth value is 'yes' and replace it with 'undefined'
                if (listRow.size() >= 9) {
                    List<Object> modifiedRow = new ArrayList<>(listRow);
                    if ("yes".equalsIgnoreCase(modifiedRow.get(8).toString().trim())) {
                        modifiedRow.set(8, "undefined");
                    }
                    filteredData.add(modifiedRow);
                }
            }
        }

        return filteredData;
    }

//    public static void main(String[] args) {
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
//            ReplaceValueFilter replaceValueFilter = new ReplaceValueFilter();
//            List<?> filteredData = replaceValueFilter.execute(excelData);
//
//            // Display the filtered data
//            System.out.println("\nFiltered Data:");
//            for (Object row : filteredData) {
//                System.out.println(row);
//            }
//        } else {
//            System.err.println("File not found in resources folder: " + resourceFilePath);
//        }
//    }
}
