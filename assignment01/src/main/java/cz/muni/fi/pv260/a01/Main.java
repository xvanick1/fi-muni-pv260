package cz.muni.fi.pv260.a01;


import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main( String[] args ) {
        System.out.println("Hello World!");
        System.out.println(args.length+"\n");

        for (String s: args) {
            System.out.println(s);
        }

        Options options = new Options();

    }
}
