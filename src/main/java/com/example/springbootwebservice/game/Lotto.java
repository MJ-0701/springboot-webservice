package com.example.springbootwebservice.game;


import java.util.Arrays;
import java.util.Random;

public class Lotto {

    public String lotto(){
         int[] lotto = new int[7];

         Random random = new Random();

        for(int i =0; i<7; i++){
            lotto[i] = random.nextInt(45)+1;
            for(int j = 0; j<i; j++){
                if(lotto[i] == lotto[j]){
                    i--;
                    System.out.println("중복 다시 시작");
//                    break;
                }
                if(lotto[i] < lotto[j]){
                    int switching = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = switching;
                }
            }

        }

//        for(int lottoarray :lotto ){
//            System.out.println(lottoarray);
//        }
        return Arrays.toString(lotto);
    }

}
