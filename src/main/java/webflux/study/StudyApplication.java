package webflux.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import webflux.study.chapter3.Book;
import webflux.study.example1.KindProgramming;
import webflux.study.example2.FluxExample1;

import java.net.URI;
import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class StudyApplication {
//	private URI baseUri = UriComponentsBuilder.newInstance().scheme("http")
//			.host("localhost")
//			.port(8080)
//			.path("/v1/books")
//			.build()
//			.encode().toUri();
	public static void main(String[] args) {

		SpringApplication.run(StudyApplication.class, args);

//		// 명령형, 선언형 비교
//		KindProgramming kindProgramming = new KindProgramming();
//		kindProgramming.orderExample1();
//		kindProgramming.declareExample2();
//
//		//Upstream, Downstream 이해
//		FluxExample1 fluxExample1 = new FluxExample1();
//		fluxExample1.example1();

		Flux<String> sequence = Flux.just("Hello", "Reactor");
		sequence.map(String::toLowerCase)
				.subscribe(System.out::println);

	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
//
//	@Bean
//	public CommandLineRunner run(){
//		return (String... args) -> {
//			log.info("# 요청 시작 시간 : {}", LocalTime.now());
//
//			for (int i = 1; i <= 5; i++) {
//				Book book = this.getBook(i);
//				log.info("{} : bookname : {}", LocalTime.now(), book.getTitle());
//
//			}
//		};
//	}
//
//	private Book getBook(long bookId){
//		RestTemplate restTemplate = new RestTemplate();
//
//		URI getBookUri = UriComponentsBuilder.fromUri(baseUri)
//				.path("/{book-id}")
//				.build()
//				.expand(bookId)
//				.encode()
//				.toUri();
//		ResponseEntity<Book> response = restTemplate.getForEntity(getBookUri, Book.class);
//
//		Book book =response.getBody();
//
//		return book;
//	}

}
