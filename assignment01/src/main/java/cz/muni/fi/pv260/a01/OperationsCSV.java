package cz.muni.fi.pv260.a01;

import java.util.List;

public class OperationsCSV {
    public static List<String[]> FilterCSV(List<String[]> csvFile, List<String> methods){
        List<String[]> filteredCSV = null;
        if (methods.contains("filtering")){
            filteredCSV = removeNulls(csvFile);
        }
        if (methods.contains("analytical")){

        }

        return filteredCSV;
    }

    private static List<String[]> removeNulls(List<String[]> csvFile){
        String[] line;
        for (int i = 0; i<csvFile.size(); i++){
            line = csvFile.get(i);
            for (int j = 0; j < line.length; j++){
                System.out.print(":" + line[j] + ": ");
                if ((line[j]).isBlank() || (line[j]).isEmpty() || line[j] == null){
                    System.out.println("Here, deleting " + i);
                    csvFile.remove(i);
                    i--;
                    break;
                }
            }
        }
        return csvFile;
    }
}
