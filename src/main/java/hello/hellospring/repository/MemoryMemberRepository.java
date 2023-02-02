package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// Repository -> 데이터 저장
//@Repository // @Component 어노테이션이 선언되어 있음
public class MemoryMemberRepository implements MemberRepository {
    // Alt + Enter로 Implements Methods

    private static Map<Long, Member> store = new HashMap<>();
    // 시퀀스는 key값을 의미함
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // id 저장
        member.setId(++sequence);
        // Map에 id(key)와 member(value)를 저장
        store.put(member.getId(), member);
        // 저장된 member 반환
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // store.get(id)의 값이 없으면 null이 반환될 가능성이 있다.
        // 이때 Optional.ofNullable()로 감싸주면 ()의 값이  null일지라도 사용할 수 있다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // store에서 value를 filter로 이용해 걸러낸다.
        // filter : member에서 member.getName()이 현재 매개변수로 넘어온 name과 같다면 필터링
        // findAny() : 찾아서 Optional로 반환한다. 만약 없으면 Optional에 null이 반환된다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store에 있는 value들을 List로 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
