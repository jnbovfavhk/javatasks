package org.knit.jnbovfavhk.sem1.lab10;

import org.knit.jnbovfavhk.TaskDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@TaskDescription(number = 21, description = "Напишите универсальный метод filter, который " +
        "принимает список элементов и предикат (интерфейс Predicate<T>). " +
        "Метод должен возвращать новый список, содержащий только те элементы, которые удовлетворяют предикату.")
public class Task21 {
    public static void execute() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredStrings = filter(words, s -> s.startsWith("b"));
        System.out.println(filteredStrings); // [banana]

        List<Integer> ints = Arrays.asList(2, 56, -3, -55, 100, 45);
        List<Integer> filteredInts = filter(ints, x -> Math.abs(x) % 2 == 0);
        System.out.println(filteredInts);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> newList = new ArrayList<>();
        for (T obj : list) {
            if (p.test(obj)) {
                newList.add(obj);
            }
        }
        return newList;
    }
}
