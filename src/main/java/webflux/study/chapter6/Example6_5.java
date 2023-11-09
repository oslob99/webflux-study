package webflux.study.chapter6;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example6_5 {
  public static void main(String[] args){

    Flux.concat(
        Flux.just("nano", "gada", "jib"),
        Flux.just("nodo", "nudo", "jib"),
        Flux.just("woori", "do", "jib")
    ).collectList()
        .subscribe(System.out::println  );

  }
}
