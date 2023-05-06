package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    //인터페이스를 통한 기본적인 CRUD, 페이징 기능 제공

    @Override
    Optional<Member> findByName(String name);
    //JPQL select m from Member m where m.name = ? 생성
    //인터페이스 이름만으로도 개발 끝!
}
