package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
// config에 쓰는게 일반적이지만 예제는 Component로~
public class TimeTraceAop {

    // AOP를 통해 핵심 관심사항과 공통 관심사항을 분리! -> 유지보수 용이

    @Around("execution(* hello.hellospring..*(..))") // 경로 설정, 보통 패키지 레벨로 많이 쓴다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        // ProceedingJoinPoint 호출이 될 때마다 조인포인트를 통해서 여러가지로 조작해서 사용할 수 있다.
        long start = System.currentTimeMillis();
        System.out.println("START: "+ joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("END: "+ joinPoint.toString() + " " + timeMs + "ms");
        }
    }
    /* 로그를 통해 확인할 수 있다!
    START: execution(String hello.hellospring.controller.HomeController.home())
    END: execution(String hello.hellospring.controller.HomeController.home()) 4ms
    START: execution(String hello.hellospring.controller.MemberController.list(Model))
    START: execution(List hello.hellospring.service.MemberService.findMembers())
    START: execution(List org.springframework.data.jpa.repository.JpaRepository.findAll())
    Hibernate: select member0_.id as id1_0_, member0_.name as name2_0_ from member member0_
    END: execution(List org.springframework.data.jpa.repository.JpaRepository.findAll()) 126ms
    END: execution(List hello.hellospring.service.MemberService.findMembers()) 131ms
    END: execution(String hello.hellospring.controller.MemberController.list(Model)) 153ms*/
}
