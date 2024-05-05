package com.txt.java.structure.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@FunctionalInterface
interface Calculator {
    long calculate(long num1, long num2);
}

@FunctionalInterface
interface TaskHandler {
    void get(String tname);
}

@FunctionalInterface
interface Worship {
    void chant(String name);

    default Worship again(Worship w) {
        return (name) -> {
            Objects.requireNonNull(w);
            chant(name);
            w.chant(name);
        };
    }
}

@FunctionalInterface
interface DataCombiner<T> {
    String combine(T t);
}

@FunctionalInterface
interface ExtraInfoProvider<R> {
    R provideMore(R r);
}

@FunctionalInterface
interface InfoProvider<T, R> {
    R provide(T t);

    default InfoProvider<T, R> addMore(ExtraInfoProvider<R> more) {
        return (T t) -> {
            Objects.requireNonNull(more);
            R r = provide(t);
            return more.provideMore(r);
        };
    }

    default DataCombiner<T> addCombiner(DataCombiner<R> combiner) {
        return (T t) -> {
            Objects.requireNonNull(combiner);
            return combiner.combine(provide(t));
        };
    }
}

@FunctionalInterface
interface DataReceiver<T> extends DataCombiner<T> {

    default void receive(TaskHandler handler, T t) {
        Objects.requireNonNull(handler);
        handler.get(combine(t));
    }
}

public class CustomFuntional {

    public static void main(String[] args) {
        List<MyNumber> list = new ArrayList<>();
        list.add(new MyNumber(100, 40));
        list.add(new MyNumber(300, 60));
        list.add(new MyNumber(60, 20));

        Calculator calc = new Calculator() {
            @Override
            public long calculate(long num1, long num2) {
                return num1 + num2;
            }
        };

        // Instantiate Functional Interface using Lambda Expression
        System.out.println("-----Instantiate Functional Interface using Lambda Expression------");
        for (MyNumber myNumber : list) {
            System.out.println(myNumber.process(calc));
        }

        System.out.println("-----");
        for (MyNumber myNumber : list) {
            System.out.println(myNumber.process(Utility::multiply)); // Don't need calling directly to Calculator but must b syntax
        }

        // Instantiate Functional Interface using Constructor Reference
        System.out.println("-----Instantiate Functional Interface using Constructor Reference------");
        Calculator calc2 = Utility::add;
        System.out.println(calc2.calculate(30, 50));

        TaskHandler taskHandler = Utility::new;
        taskHandler.get("Task new");

        taskHandler = Utility::abc;
        taskHandler.get("Task 1");

        // Functional Interface with Default Methods
        System.out.println("------Functional Interface with Default Methods------");
        Worship worship = (name) -> System.out.println(name);
        worship.again(worship).again(worship).chant("Ram");

        // Functional Interface with Generic and Default Methods
        System.out.println("------Functional Interface with Generic and Default Methods------");
        DataCombiner<Project> dataCombiner = (Project p) -> {
            if (p.getLocation() == null) {
                return p.getPname() + " : " + p.getTeamLead();
            } else {
                return p.getPname() + " : " + p.getTeamLead() + " : " + p.getLocation();
            }
        };

        InfoProvider<Employee, Project> infoProvider = (Employee emp) -> {
            if (emp.getId() > 100) {
                return new Project("ABCD", emp.getName());
            } else {
                return new Project("PQRS", emp.getName());
            }
        };

        ExtraInfoProvider<Project> extraInfoProvider = new ExtraInfoProvider<Project>() {

            @Override
            public Project provideMore(Project p) {
                return new Project("ThuongTX", "Java");
            }
        };

        String s = infoProvider.addMore(extraInfoProvider).addCombiner(dataCombiner)
                .combine(new Employee(50, "Mahesh"));
        System.out.println(s);

        // Functional Interface Inheritance
        System.out.println("------Functional Interface Inheritance------");
        DataReceiver<Employee> dataReceiver = (Employee emp) -> emp.getId() + "-" + emp.getName();
        TaskHandler tskHandler = (res) -> System.out.println(res);
        dataReceiver.receive(tskHandler, new Employee(101, "Krishna"));
    }

    static class Project {
        private String pname;
        private String teamLead;
        private String location;

        public Project(String pname, String teamLead) {
            this.pname = pname;
            this.teamLead = teamLead;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getTeamLead() {
            return teamLead;
        }

        public void setTeamLead(String teamLead) {
            this.teamLead = teamLead;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    static class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
