package webflux.study.chapter6;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example6_4 {
  public static void main(String[] args){

    Flux<String> flux =
        Mono.justOrEmpty("Steve")
            .concatWith(Mono.justOrEmpty("jobs"));
    flux.subscribe(System.out::println  );

  }
}
