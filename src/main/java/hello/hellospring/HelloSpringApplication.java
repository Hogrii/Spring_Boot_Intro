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

	// 현재 클래스의 패키지인 hello.hellospring 아래에 있는 클래스에서만 어노테이션을 찾아서 빈에 등록
	// 따라서, hello.hellospring과 같은 라인의 패키지가 있다면 그 패키지에서는 어노테이션을 찾지 않음
}
