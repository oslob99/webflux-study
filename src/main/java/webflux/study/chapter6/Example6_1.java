package webflux.study.chapter6;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

public class Example6_1 {
  public static void main(String[] args) {
    URI worldTimeUrl = UriComponentsBuilder.newInstance().scheme("http")
        .host("worldtimeapi.org")
        .port(80)
        .path("/api/timezone/Asia/Seoul")
        .build()
        .encode()
        .toUri();

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    Mono.just(
            restTemplate
                .exchange(worldTimeUrl,
                    HttpMethod.GET,
                    new HttpEntity<String>(headers),
            String.class)
        )
        .map(response -> {
          DocumentContext jsonContext = JsonPath.parse(response);
          return jsonContext.<String>read("$.datetime");
        })
        .subscribe(
            data -> System.out.println("# emitted data: " + data),
            System.out::println,
            () -> System.out.println("# emitted onComplete signal")
        );

  }

}
