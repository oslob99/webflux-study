package webflux.study.chapter5;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example5_1 {
  public static void main(String[] args){
    Flux<String> sequence = Flux.just("Hello", "Reactor");
    sequence.map(String::toLowerCase)
        .subscribe(System.out::println);

  }


}
