package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}
	// 터미널로 build
	// cmd를 이용해 hello-spring 폴더로 이동
	// gradlew.bat 실행 안되면 gradlew clean build 실행
	// hello-spring/build/libs 폴더로 이동
	// java -jar hello-spring-0.0.1-SNAPSHOT.jar 실행
	// localhost에서 실행 확인

}
