package hello.springjpa.repository;

import hello.springjpa.entity.Monkey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonkeyRepo
        extends JpaRepository<Monkey, Long> {
    // select * from monkeys where boss = #{boss}
    List<Monkey> findByBoss(String boss);

    // select * from monkeys where boss = #{boss} order by id desc
    List<Monkey> findByBossOrderByIdDesc(String boss);

    // select * from monkeys where id < #{id}
    List<Monkey> findByIdBefore(long id);

    @Query("select m from Monkey m where m.id = ?1")
    Monkey findOneById(Long id);
}