package hello.springjpa.entity;

import javax.persistence.*;;
import java.util.Date;

// create table by Entity
@Entity
//@Table(name = "hello_monkey") // set table name
public class Monkey {
    @Id  // set primary key of table
    // auto increase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "username")
    private String name;

    @Column(length = 30)
    private String boss;

    @Column(columnDefinition = "date")
    private Date endDay;

    @Column(updatable = false)
    private String email;

    @Transient
    private boolean isHungry;

    public Monkey() {
    }

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

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public Date getEndDay() {
        return endDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
