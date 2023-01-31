package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    // Clear
    MemoryMemberRepository memberRepository;

    // 테스트를 시작하기 전에
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    // 테스트는 과감하게 한글 이름으로 만들어도 된다.
    // 실제 코드에 포함되는 코드가 아니기 때문이다.
    @Test
    void 회원가입() {
        // given -> 입력
        Member member = new Member();
        member.setName("hello");

        // when -> 동작
        Long saveId = memberService.join(member);

        // then -> 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // memberService.join에 member2를 넣었을 때, 설정해놓은 오류가 똑같이 발생하면 성공
        // join에 중복이면 IllegalStateException을 발생시키게 만들었다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            // member1에서 이미 "spring"이 있기 때문에 중복 에러가 발생한다.
            memberService.join(member2);
            fail();
        } catch(IllegalStateException e) {
            // 에러 발생시 발생하는 문구와 똑같아야 통과된다. 뒤에 123123 등을 추가하면 에러가 발생한다.
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
         */

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}