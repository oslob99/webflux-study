package webflux.study.chapter7;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
public class Example7_1 {
  public static void main(String[] args){

    Flux<String> coldFlux = Flux
        .fromIterable(Arrays.asList("KOREA", "JAPAN", "CHINA"))
        .map(String::toLowerCase);

    coldFlux.subscribe(country -> System.out.println("country 1 "+country));
    try {
      Thread.sleep(2000L);
      coldFlux.subscribe(country -> System.out.println("country 2 "+country));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
