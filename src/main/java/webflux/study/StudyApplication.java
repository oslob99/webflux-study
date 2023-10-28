package webflux.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webflux.study.example1.KindProgramming;

@SpringBootApplication
public class StudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);

		KindProgramming kindProgramming = new KindProgramming();
		kindProgramming.orderExample1();
		kindProgramming.declareExample2();
	}
}
