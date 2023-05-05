package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//구현체로 설정해서 큰 수정이 필요하지 않게 한다.
//OCP 개방폐쇄원칙 : 확장에는 열려있고, 수정(변경)에는 닫혀있다.
//-> 기존코드는 손대지 않고 설정(SpringConfig)만으로 구현 클래스를 변경할 수 있다.
public interface MemberRepository {

    Member save(Member member); // MemoryMemberRepository 가 구현체로 있으니까 거기가 @Repository

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

}
