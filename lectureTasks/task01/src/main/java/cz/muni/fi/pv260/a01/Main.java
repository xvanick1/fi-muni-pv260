package cz.muni.fi.pv260.a01;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main( String[] args ) throws Exception {
        if(args.length != 7){
            throw new ParseException("Error: Incorrect number of arguments.");
        }

        if (!(args[0].equals("-d") && args[2].equals("-m") && args[4].equals("-o"))){
            throw new ParseException("Error: Illegal arguments detected.");
        }
        if (!((args[5].equals("json")) || (args[5].equals("xml")) || (args[5].equals("plain")))){
            throw new ParseException("Error: Invalid argument value " + args[5]);
        }

        String inputPath = args[1];
        String extension = args[5];
        String outputPath = args[6];
        List<String> methods = new ArrayList<String>(Arrays.asList(args[3].split(","))); //upraviť načítanie metód
        System.out.println(methods);
        List<String []> csv = FetchCSV.fetchCSV(inputPath);

        outputPath = OutputOperations.checkPathExtension(extension, outputPath);


        List<String []> finalCSV = OperationsCSV.FilterCSV(csv, methods);


        OutputOperations.saveResult(extension, outputPath, finalCSV);
        System.out.println("Result successfully saved to " + outputPath);

    }
}
