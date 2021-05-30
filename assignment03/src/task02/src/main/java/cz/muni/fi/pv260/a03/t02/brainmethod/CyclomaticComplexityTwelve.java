package cz.muni.fi.pv260.a03.t02.brainmethod;

/**
 * Cyclomatic complexity is 12 here
 */
public class CyclomaticComplexityTwelve {

    public CyclomaticComplexityTwelve(){
        int a = 2;
        int b = 3;
        int c = 4;
        int d = 5;

        if(a<0){
            System.out.println("Less than zero");
        }
        else if(a<=5 && a>=0){
            System.out.println("Between 0 a 5");
        }
        else if (a>5){
            System.out.println("Bigger than 5");
        }

        if(b<0){
            System.out.println("Less than zero");
        }
        if(b>=0 && b<=5){
            System.out.println("Between 0 and 5");
        }
        if(b>5 && b <= 10){
            System.out.println("Between 5 and 10");
        }
        if(b>10){
            System.out.println("Bigger than 10");
        }


    }


}
