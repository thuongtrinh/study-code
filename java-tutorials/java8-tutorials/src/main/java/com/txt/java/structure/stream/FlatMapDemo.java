package com.txt.java.structure.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.txt.java.structure.model.Book;
import com.txt.java.structure.model.Writer;
import com.txt.java.structure.model.optional.Country;
import com.txt.java.structure.model.optional.Person;
import com.txt.java.structure.model.optional.PrimeMinister;

public class FlatMapDemo {

    public static void main(String[] args) {
        System.out.println("----------FlatMap with Stream----------");
        List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
        Writer w1 = new Writer("Mohan", books);
        books = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));
        Writer w2 = new Writer("Sohan", books);
        List<Writer> writers = Arrays.asList(w1, w2);

//		Stream<List<Book>> s = Stream.of(w1.getBooks(), w2.getBooks());
//		Stream<List<Book>> s = 
        List<String> lst = new ArrayList<String>();

        Book bookMax = Stream.of(w1.getBooks(), w2.getBooks()).flatMap(new Function<List<Book>, Stream<Book>>() {

            @Override
            public Stream<Book> apply(List<Book> books) {
                return books.stream();
            }
        }).max(new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice() - o2.getPrice();
            }
        }).get();

//		bookMax = Stream.of(w1.getBooks(), w2.getBooks()).flatMap(b -> b.stream())
//				.max((book1, book2) -> book1.getPrice() - book2.getPrice()).get();

        System.out.println("Book with max price: " + bookMax.getName() + ", " + bookMax.getPrice());

        Book bookMin = writers.stream().flatMap(w -> w.getBooks().stream())
                .max((b1, b2) -> b2.getPrice() - b1.getPrice()).get();
        System.out.println("Book with min price:" + bookMin.getName() + ", " + bookMin.getPrice());

        //--------------------------------------------------------------
        System.out.println("Test filter not action if not flatMap");
//		lst.add("s1");
//		lst.add("s2");
//		Stream.of(lst).filter(s -> "s1".equals(s.toString())).forEach(s -> System.out.println(s)); // -> Not filter

        List<String> students1 = new ArrayList<>();
        students1.add("Khanh");
        List<String> students2 = new ArrayList<>();
        students2.add("Thanh");
        students2.add("Dung");
        List<List<String>> students = Arrays.asList(students1, students2);
        Stream<List<String>> streamST = students.stream();
        Stream<String> flatMap = streamST.flatMap(l -> l.stream());

        System.out.println("\n----------Stream flatMap with List of Lists----------");
        List<Book> list1 = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
        List<Book> list2 = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));
        List<List<Book>> finalList = Arrays.asList(list1, list2);

//		Stream<List<Book>> ss = finalList.stream();
        Book bookMaxDList = finalList.stream().flatMap(new Function<List<Book>, Stream<Book>>() {

            @Override
            public Stream<Book> apply(List<Book> t) {
                return t.stream();
            }
        }).max((b1, b2) -> b1.getPrice() - b2.getPrice()).get();

        System.out.println("Book with min price with List of Lists: " + bookMaxDList.getName() + ", " + bookMaxDList.getPrice());


        // Stream flatMap with Array
        System.out.println("\n----------Stream flatMap with Array----------");
        Integer[][] data = {{1, 2}, {3, 4}, {5, 6}};
        Stream<Integer> intStream = Arrays.stream(data).flatMap(new Function<Integer[], Stream<Integer>>() {

            @Override
            public Stream<Integer> apply(Integer[] t) {
                return Arrays.stream(t);
            }
        });

        intStream.filter(new Predicate<Integer>() {

            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        }).forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });
//		Arrays.stream(data).flatMap(t -> Arrays.stream(t)).filter(u -> u%2==0).forEach(System.out::println);


        // Stream flatMap with Array of Objects
        System.out.println("\n----------Stream flatMap with Array of Objects----------");
        books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
        w1 = new Writer("Mohan", books);
        books = Arrays.asList(new Book(30, "CCC"), new Book(15, "DDD"));
        w2 = new Writer("Sohan", books);
        books = Arrays.asList(new Book(45, "EEE"), new Book(25, "FFF"));
        Writer w3 = new Writer("Vikas", books);
        books = Arrays.asList(new Book(5, "GGG"), new Book(15, "HHH"));
        Writer w4 = new Writer("Ramesh", books);
        Writer[][] writerArray = {{w1, w2}, {w3, w4}};

        Arrays.stream(writerArray).flatMap(wr -> Arrays.stream(wr)).flatMap(w -> w.getBooks().stream())
                .filter(f -> f.getPrice() % 2 == 0)
                .forEach(b -> System.out.println("Book: " + b.getName() + ", " + b.getPrice()));


        // Stream flatMap with Files.lines()
        System.out.println("\n----------Stream flatMap with Files.lines()----------");
        Stream<String> lines = null;
        try {
            String path = FileSystems.getDefault().getPath("").toAbsolutePath() + "/resources/info.txt";
            lines = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<String> stream = lines.flatMap(new Function<String, Stream<String>>() {

            @Override
            public Stream<String> apply(String line) {
                return Stream.of(line.split(" "));
            }
        });

        List<String> words = new ArrayList<>();
        stream.forEach(w -> words.add(w));
        words.forEach(System.out::println);


        // Optional flatMap
        System.out.println("\n----------Optional flatMap----------");
        Optional<PrimeMinister> primeMinister = Optional.of(new PrimeMinister("ABC", 57));
        Optional<Country> country = Optional.of(new Country(primeMinister));
        Optional<Person> person = Optional.of(new Person(country));

        Optional<Country> optionalCountry = person.flatMap(new Function<Person, Optional<Country>>() {

            @Override
            public Optional<Country> apply(Person p) {
                return p.getCountry();
            }
        });

        Optional<PrimeMinister> optionalPM = optionalCountry.flatMap(new Function<Country, Optional<PrimeMinister>>() {

            @Override
            public Optional<PrimeMinister> apply(Country c) {
                return c.getPrimeMinister();
            }
        });

        String primeName = optionalPM.flatMap(new Function<PrimeMinister, Optional<String>>() {

            @Override
            public Optional<String> apply(PrimeMinister pm) {
                return Optional.of(pm.getName() + ", " + pm.getAge());
            }
        }).get();

        System.out.println("Name and age of prime minister: " + primeName);

        // Summary code above way 1
        primeName = person.flatMap(p -> p.getCountry()).flatMap(c -> c.getPrimeMinister())
                .flatMap(pm -> Optional.of(pm.getName() + ", " + pm.getAge())).get();
        System.out.println("Name and age of prime minister: " + primeName);

        // Summary code above way 2
        primeName = person.flatMap(Person::getCountry).flatMap(Country::getPrimeMinister).map(PrimeMinister::getName).orElse("None");
        System.out.println("Name of prime minister: " + primeName);
    }
}
