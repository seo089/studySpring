package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //Autowired 처럼 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        //일반적으로 컴포넌트 스캔이 더 편리하지만 여기서 설정파일만 갈아끼면 되는 경우가 발생할 때 편리할 수 있음
    }

    //요즘은 xml 보다 java code로 많이 작성함
}
