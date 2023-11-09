package webflux.study.chapter7;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class Example7_2 {
  public static void main(String[] args){

    String[] singers = {"Singer A","Singer B","Singer C","Singer D","Singer E"};

    log.info("# Begin concert:");

    Flux<String> concertFlux = Flux.fromArray(singers)
        .delayElements(Duration.ofSeconds(1))
        .share();

    concertFlux.subscribe(
        singer -> log.info("Subsciber 1 {}", singer)
    );

    try {
      Thread.sleep(2000L);

      concertFlux.subscribe(
          singer -> log.info("Subscriber 2 {}", singer)
      );

      Thread.sleep(3000L);

    } catch (InterruptedException e) {
    }
  }
}
