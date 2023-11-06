package webflux.study.chapter6;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpHeaders;

public class Example6_1 {
  public static void main(String[] args){
    URI worldTimeUrl = UriComponentsBuilder.newInstance().scheme("http")
        .host("worldtimeapi.org")
        .port(80)
        .path("/api/timezone/Asia/Seoul")
        .build()
        .encode()
        .toUri();
  }

  RestTemplate restTemplate = new RestTemplate();

}
