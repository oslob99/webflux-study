package webflux.study.example1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KindProgramming {
    public void orderExample1(){

        List<Integer> numbers = Arrays.asList(1,3,21,10,8,11);
        int sum = 0;
        for(int number : numbers){
            if (number > 6 && (number % 2 != 0)){
                sum += number;
            }
            System.out.println("합계 : " + sum);
    }
    }

    public void declareExample2(){
        List<Integer> numbers = Arrays.asList(1,3,21,10,8,11);
        int sum = numbers.stream().filter(
                        number -> number > 6 && (number % 2 != 0)
                ).mapToInt(number -> number)
                .sum();
//
//        List<Boolean> sum = numbers.stream().map(
//                number -> number > 6 && (number % 2 != 0)
//        ).toList();


        System.out.println("합계2 : "+sum);

    }

}
