import java.util.Random;

/**
 *
 * max number of nesting = 5
 * max number of LOC = 16
 * max number of variables in 1 method = 10
 * max number of cyclomatic complexity = 12
 */
public class AllConstraintsBroken {

    public AllConstraintsBroken(){
      methodLong16LOC();
      numberOfVariables10();
      cyclomaticComplexityTwelve();
      nestingFive();
    }

    private void methodLong16LOC(){
        int a=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        a+=1;
        System.out.println(a);
    }

    private void numberOfVariables10() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        int h = 8;
        int i = 9;
        int j = 10;
        System.out.println(a+b+c+d+e+f+g+h+i+j);
    }

    private void cyclomaticComplexityTwelve(){
        Random rand = new Random();
        int a = rand.nextInt(200)-10;
        int b = rand.nextInt(250)-10;
        if(a<0)
            System.out.println("Less than zero");
        else if(a<=5)
            System.out.println("Between 0 a 5");
        else
            System.out.println("Bigger than 5");
        if(b<0)
            System.out.println("Less than zero");
        if(b>=0 && b<=5)
            System.out.println("Between 0 and 5");
        if(b>5 && b <= 10)
            System.out.println("Bigger than 5 and equal or lower than 10");
        if(b>10)
            System.out.println("Bigger than 10");
    }

    private void nestingFive(){
        int a=5;
        while(a<10){
            for(;a<9;){
                if(a<8){
                    if(a<7){
                        if(a<6){
                            System.out.println(a);
                            a=100;
                        }
                    }
                }
            }
        }
    }
}
