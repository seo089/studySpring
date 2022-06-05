package hello.hellospring; // 이 하위 패키지만 컴포넌트 스캔 한다 (외부 패키지에 클래스는 어노테이션 해도 스캔 안함 별도 설정 필요)

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
