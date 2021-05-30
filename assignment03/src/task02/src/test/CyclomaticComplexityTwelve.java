package cz.muni.fi.pv260.a03.t02.brainmethod;

import java.util.Random;

/**
 * Cyclomatic complexity is 12 here
 */
public class CyclomaticComplexityTwelve {

    public CyclomaticComplexityTwelve(){
        Random rand = new Random();
        int a = rand.nextInt(200)-10;

        int b = rand.nextInt(250)-10;

        if(a<0){
            System.out.println("Less than zero");
        }
        else if(a<=5){
            System.out.println("Between 0 a 5");
        }
        else {
            System.out.println("Bigger than 5");
        }

        if(b<0){
            System.out.println("Less than zero");
        }
        if(b>=0 && b<=5){
            System.out.println("Between 0 and 5");
        }
        if(b>5 && b <= 10){
            System.out.println("Bigger than 5 and equal or lower than 10");
        }
        if(b>10){
            System.out.println("Bigger than 10");
        }

    }


}
