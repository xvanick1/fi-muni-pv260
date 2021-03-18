package cz.muni.fi.pv260.a01;

import com.opencsv.CSVWriter;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputOperations {

    //Potreba skontrolovat funkcionalitu
    public static String checkPathExtension(String extension, String outputPath) throws Exception {
        if (outputPath.endsWith(".xml") || outputPath.endsWith(".json") || outputPath.endsWith(".txt"))
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

        return outputPath + "." + extension;
    }

    public static void saveResult(String extension, String outputPath, List<String[]> csv) throws Exception {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(outputPath));
            writer.writeNext(new String[]{"order_id", "order_date", "customer_email", "customer_address", "total_price", "order_status"});
            writer.writeAll(csv);
            writer.close();
        }
        catch (Exception e){
            throw new Exception("Error: Could not successfully create output file.");
        }
        finally {
            System.out.println("Result successfully saved to " + outputPath);
        }
    }

    private static void saveAsXML(String extension){

    }

    private static void saveAsJSON(String extension){

    }

    private static void saveAsPlain(String extension){

    }
}
