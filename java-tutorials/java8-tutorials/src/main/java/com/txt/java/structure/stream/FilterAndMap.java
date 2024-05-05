package com.txt.java.structure.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.txt.java.structure.model.Employee;

public class FilterAndMap {

    public static void main(String[] args) {
        List<Employee> list = Employee.getEmpList();

        // Predicate: test
        Predicate<Employee> empPredicate = new Predicate<Employee>() {

            @Override
            public boolean test(Employee e) {
                return e.id > 1 && e.id < 100;
            }
        };
//		Predicate<Employee> filterPredicate = e -> e.id > 1 && e.sal < 100;

        // Consumer: accept
        Consumer<Employee> empConsumer = new Consumer<Employee>() {

            @Override
            public void accept(Employee e) {
                System.out.println(e.id + ", " + e.name + ", " + e.sal);
            }
        };
//		Consumer<Employee> printConsumer = e -> System.out.println(e.id + ", " + e.sal);

        list.stream().filter(empPredicate).forEach(empConsumer);

        //-------------------------------------------------
        // Function: Map
        Stream<Player> playerStream = list.stream().map(new Function<Employee, Player>() {

            @Override
            public Player apply(Employee e) {
                return new Player(e.id, "player " + e.name);
            }
        });
//		Stream<Player> players = list.stream().map(e -> new Player(e.id, e.name));

        playerStream.forEach(new Consumer<Player>() {

            @Override
            public void accept(Player p) {
                System.out.println(p.id + ", " + p.name);
            }
        });
//		players.forEach(p -> System.out.println(p.id + ", " + p.name));
    }

    private static class Player {
        int id;
        String name;

        Player(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
