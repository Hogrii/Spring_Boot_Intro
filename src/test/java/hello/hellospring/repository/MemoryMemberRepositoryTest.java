package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// Test하고자하는 Class뒤에 Test만 붙이는 것이 관례
// 어디에서 사용할 것이 아니기 때문에 public 빼도 됨
// class에서 Run을 하면 전체를 한꺼번에 테스트한다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // Test 순서가 findAll() -> findByName() -> save() 순으로 진행되며 고정이 안된다.
    // 따라서, 테스트가 끝나면 데이터를 깔끔하게 클리어시켜야 한다.
    @AfterEach
    public void afterEach() {
        // AfterEach는 Test가 끝날때마다 실행시키는 코드이다.
        // clearStore()를 이용해서 Map에 저장된 값을 깔끔하게 클리어시킨다.
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // repository.findById(member.getId())로 꺼낸 값이  Optional 타입
        // Optional 타입의 값은 get()을 이용해 꺼낼 수 있다.
        Member result = repository.findById(member.getId()).get();
        
        // 결과 검증 : member와 result가 같으면 true, 아니면 false
        // 방법 1 -> org.assertj.core.api
//        Assertions.assertEquals(member, result);
        // 방법 2 -> org.junit.jupiter.api
        // Alt + Enter -> Add on-demand static import for '~'을 이용해  static으로 만들면 Assertions를 생략 가능하다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
