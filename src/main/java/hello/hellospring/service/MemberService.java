package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 검증
//        Optional<Member> result = memberRepository.findByName(member.getName());
        // ifPresent는 Optional 안에 값이 존재할 경우를 의미한다.
        // Optional에서 바로 값을 꺼낼 수도 있지만 권장은 안한다. -> result.get();
//        result.ifPresent(m -> {
//            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
//        });
        // 아래와 같이 사용해도 된다.
        // Ctrl + Alt + M -> Extra Method를 이용해 메소드로 만들어줄 수 있다.
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                        });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
