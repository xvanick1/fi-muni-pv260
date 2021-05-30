package cz.muni.fi.pv260.a03.t02.brainmethod;

/**
 * Number of nesting = 5
 */
public class NestingFive {
    public NestingFive(){
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
