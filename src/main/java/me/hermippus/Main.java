package me.hermippus;

import me.hermippus.models.Human;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        // Functional interfaces that the Stream API uses:
        // - Predicate<T>, Consumer<T>, Function<? super T, ? extends R>

        // Immutable list of Human objects
        List<Human> humans = List.of(
                new Human("John", 16),
                new Human("Alex", 17),
                new Human("Mary", 16),
                new Human("Ada", 17)
        );

        // Use forEach(Consumer<T> action) to print human names
        humans.forEach(h -> System.out.print(h.getName() + " "));
        System.out.println();

        // Use filter(Predicate<T> predicate) and forEach(Consumer<T> action) to print human names that age > 16
        humans.stream().filter(h -> h.getAge() > 16).forEach(h -> System.out.print(h.getName() + " "));
        System.out.println();

        // Use filter(Predicate<T> predicate) and forEach(Consumer<T> action) to set the name "Jack" for all people that age > 16
        humans.stream().filter(h -> h.getAge() > 16).forEach(h -> {
           h.setName("Jack");
           System.out.print(h.getName() + " ");
        });
        System.out.println();

        // Use anyMatch(Predicate<T> predicate) to get true/false if there is any match with the condition, e.g. a human that age > 16
        boolean b = humans.stream().anyMatch(h -> h.getAge() > 16);
        System.out.println("There are people that age > 16: " + b);

        // Use anyMatch(Predicate<T> predicate) to get true/false if there is all match with the condition, e.g. a humans that age > 16
        boolean b2 = humans.stream().allMatch(h -> h.getAge() > 16);
        System.out.println("There are all people that age > 16: " + b2);

        // Use anyMatch(Predicate<T> predicate) to get true/false if there is no match with the condition, e.g. a humans that age > 17
        boolean b3 = humans.stream().noneMatch(h -> h.getAge() > 17);
        System.out.println("There are no people that age > 17: " + b3);

        // Use parallelStream (that creates a parallel stream for processing data, and also is multithreaded)
        // to set the name "Oliver" and age 18 for all people that age > 16
        humans.parallelStream().filter(h -> h.getAge() > 16).forEach(h -> {
           h.setName("Oliver");
           h.setAge(18);
           System.out.print(h.getName() + " ");
        });
    }

}