package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 프로그램이 동작하면서 Configuration에서 Bean에 등록해준다.
@Configuration
public class SpringConfig {
    // Spring Bean 등록하기
    // MemberService와 MemoryMmeberRepository에 있는 @Service, @Repository를 사용하지 않을 때의 방법
    // Java 코드로 직접 Bean에 추가하는 방법이다.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

// 과거에는 xml 문서로 설정했다.
