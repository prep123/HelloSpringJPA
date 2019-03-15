package hello.springjpa.utils;

import hello.springjpa.entity.Monkey;

import java.util.List;

public class Print {
    public static void monkey(Monkey monkey){
        System.out.println(monkey.getId());
        System.out.println(monkey.getName());
    }
    public static void monkeys(List<Monkey> monkeys){
        for (Monkey monkey : monkeys){
            Print.monkey(monkey);
        } // 4 3 2 1
    }
}
