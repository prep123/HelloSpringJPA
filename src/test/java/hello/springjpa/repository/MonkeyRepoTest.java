package hello.springjpa.repository;

import hello.springjpa.entity.Monkey;
import hello.springjpa.utils.Print;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MonkeyRepoTest {
    private Monkey newCreateMonkey;

    // SpringBoot will create an instance of MonkeyRepo
    // and auto inject to this field
    @Autowired
    private MonkeyRepo monkeyRepo;

    @Test
    public void saveOne(){
        Monkey monkey = new Monkey();
        monkey.setBoss("WuKong Sun");
        monkey = monkeyRepo.save(monkey);
        Assert.assertTrue(monkey.getId() != null);

        System.out.println("saveOne: " + monkey.getId());
        newCreateMonkey = monkey;
    }

    @Test
    public void finaOne(){
    }

    // 我擦，虽然先执行了saveOne，而且也有结果，但是数据库中
    // 没数据，可能是没提交，我擦，debug了半天
    @Test
    public void findAll(){
        List<Monkey> monkeys = monkeyRepo.findAll();
        if(monkeys.size() > 0){
            System.out.println("findAll: " + monkeys.get(0).getBoss());
        }
    }
    @Test
    public void findAll1(){
        List<Monkey> monkeys = monkeyRepo.findByBoss("WuKong Sun");
        if(monkeys.size() > 0){
            System.out.println(monkeys.get(0).getBoss());
        }
    }
    @Test
    public void findAll2(){
        List<Monkey> monkeys =
                monkeyRepo.findByBossOrderByIdDesc("WuKong Sun");
        System.out.println("findAll2");
        Print.monkeys(monkeys); // 4 3 2 1
    }

    @Test
    public void findAll3(){
        List<Monkey> monkeys =
                monkeyRepo.findByIdBefore(3);
        System.out.println("finder before");
        Print.monkeys(monkeys); // 1 2
    }

    @Test
    public void updateOne(){
        Monkey monkey = new Monkey();
        monkey.setId((long)3);
        monkey.setName("Jong Kong");
        // change boss field to null
        monkeyRepo.save(monkey);
    }
}
