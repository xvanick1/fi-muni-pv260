package cz.muni.fi.pv260.a01;

import java.util.List;

public class OperationsCSV {
    public static List<String[]> FilterCSV(List<String[]> csvFile, List<String> methods) throws Exception {
        List<String[]> filteredCSV = null;
        if (methods.contains("filtering")){
            filteredCSV = removeNulls(csvFile);
        }
        if (methods.contains("analytical")){
            //TODO
        }
        else{
            throw new Exception("Error: Unknown method, or method input syntax."); // proč to krici?
        }

        return filteredCSV;
    }

    private static List<String[]> removeNulls(List<String[]> csvFile){
        String[] line;
        for (int i = 0; i<csvFile.size(); i++){
            line = csvFile.get(i);
            for (int j = 0; j < line.length; j++){
                if ((line[j]).isBlank() || (line[j]).isEmpty() || line[j] == null){
                    csvFile.remove(i);
                    i--;
                    break;
                }
            }
        }
        return csvFile;
    }
}
