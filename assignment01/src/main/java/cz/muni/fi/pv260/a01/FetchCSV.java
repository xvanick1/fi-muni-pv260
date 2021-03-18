package cz.muni.fi.pv260.a01;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FetchCSV {
    public static List<String[]> fetchCSV(String path) throws Exception {
        List<String[]> csvFile = null;
        if (path.startsWith("http://") || path.startsWith("https://")){
            try {
                csvFile = downloadCSV(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                csvFile = readCSV(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (csvFile == null){
            throw new Exception("Error: Failed to fetch file.");
        }

        Files.deleteIfExists(Paths.get("./temp.da-tool"));
        return csvFile;
    }

    private static List<String[]> downloadCSV(String tempFilePath) throws Exception {
        try {
            InputStream inputStream = new URL(tempFilePath).openStream();
            Files.copy(inputStream, Paths.get("./temp.da-tool"), StandardCopyOption.REPLACE_EXISTING);
        }
        catch(java.io.IOException exception) {
            throw new Exception("Error: Could not retrieve datasource file.");
        }
        return readCSV("./temp.da-tool");
    }

    private static List<String[]> readCSV(String path) throws Exception {
        List<String[]> r;
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            r = reader.readAll();
        } catch (Exception e) {
            throw new Exception("Error: File not found.");
        }
        return r;
    }
}
