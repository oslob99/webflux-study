package webflux.study.chapter6;

import reactor.core.publisher.Flux;

public class Example6_2 {
  public static void main(String[] args){

    Flux.just(6,9,13)
        .map(num -> num %2)
        .subscribe(System.out::println);

  }
}
