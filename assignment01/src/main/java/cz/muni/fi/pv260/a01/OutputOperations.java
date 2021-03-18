package cz.muni.fi.pv260.a01;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.SystemUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputOperations {

    public static String checkPathExtension(String extension, String outputPath) throws Exception {
        if (outputPath.endsWith(".xml") || outputPath.endsWith(".json"))
            return outputPath;

        String filename = "";
        try {
            if (SystemUtils.IS_OS_WINDOWS) filename = outputPath.substring(outputPath.lastIndexOf('\\'));
            else filename = outputPath.substring(outputPath.lastIndexOf('/'));
        }
        catch (Exception e) {
            if (outputPath.contains(".")){
                throw new Exception("Error: Detected unsupported save format of output file.");
            }
        }
        if (filename.contains(".")){
            throw new Exception("Error: Detected unsupported save format of output file.");
        }

        if(extension.equals("plain")){
            return outputPath;
        }
        return outputPath + "." + extension;
    }

    public static void saveResult(String extension, String outputPath, List<String[]> csv) throws Exception {
        try {
            if (extension.equals("json")){
                modifyToJSON(csv, outputPath);
            }
            if (extension.equals("xml")){
                //TODO
            }
            if (extension.equals("plain")){
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath));
                writer.writeNext(new String[]{"order_id", "order_date", "customer_email", "customer_address", "total_price", "order_status"});
                writer.writeAll(csv);
                writer.close();
            }

        }
        catch (Exception e){
            throw new Exception("Error: Could not successfully create output file.");
        }

    }

    private static void modifyToJSON(List<String[]> csv, String outputPath) throws IOException {
        //TODO
        FileWriter json = new FileWriter(outputPath);
        try {
            json.write(new Gson().toJson(csv));
        }
        catch (IOException e) {
            throw new IOException("Error: Could not create output JSON file.");
        }
        finally {
            json.flush();
            json.close();
        }

    }
    private static void modifyToXML(){

    }
}
