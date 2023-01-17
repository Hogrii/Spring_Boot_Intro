package hello.hellospring.domain;

public class Member {
    // 비지니스 요구사항 정리

    // 일반적인 웹 애플리케이션 계층 구조
    // 컨트롤러 -> 서비스 -> 리포지토리 -> DB
    //              ↓
    //    └>      도메인     <┘
    // 컨트롤러 : 웹 MVC 컨트롤러
    // 서비스 : 핵심 비지니스 로직 구현
    // 리포지토리 : DB에 접근, 도메인 객체를 DB에 저장하고 관리
    // 도메인 : 비지니스 도메인 객체, EX) 회원, 주문, 쿠폰 등등 DB에 저장하고 관리됨

    // 클래스 의존관계
    //                      interface
    // MemberService -> MemberRepository <-- Memory MemberRepository

    // id는 시스템이 정해주는 값
    private Long id;
    // name은 사용자가 입력하는 값
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
