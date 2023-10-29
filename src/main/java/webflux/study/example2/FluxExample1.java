package webflux.study.example2;

import reactor.core.publisher.Flux;

public class FluxExample1 {

    public void example1(){
        Flux
                .just(1,2,3,4,5,6)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .subscribe(System.out::println);

    }
}
