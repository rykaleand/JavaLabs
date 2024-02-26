package Lab1_Functional_Programming;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> integersList = List.of(0, 2, 2 ,10, 10 ,55 ,70);
        List<String> stringsList = List.of("hello", "everyone", "on", "this", "party", "nobody", "every");

        int[] integersArray = {-10, 5 ,14, 26, -121};

        System.out.println("1. Method intsAverage returned: " +intsAverage(integersList));
        System.out.println("2. Method strsToUpperWithPrefix returned: " + strsToUpperWithPrefix(stringsList));
        System.out.println("3. Method intsSecondDegree returned: " + intsSecondDegree(integersList));
        System.out.println("4. Method strsFilterByFirstLetter returned: " + strsFilterByFirstLetter(stringsList, "e"));
        System.out.println("5.1. Method listLastElement returned: " + listLastElement(integersList));
        System.out.println("5.2. Method listLastElement returned: " + listLastElement(stringsList));
        System.out.println("6. Method sumOfEvens returned: " + sumOfEvens(integersArray));
        System.out.println("7. Method stringsListConvertToMap returned: " + stringsListConvertToMap(stringsList));
    }

    //метод, возвращающий среднее значение списка целых чисел;
    public static double intsAverage(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()   //возвращает OptionalDouble
                .orElse(Double.NaN);
    }

    //метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»
    public static List<String> strsToUpperWithPrefix(List<String> list){
        return list.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    //метод, возвращающий список квадратов всех встречающихся только один раз элементов списка
    public static List<Integer> intsSecondDegree(List<Integer> list){
        return list.stream()
                .distinct()
                .map(i -> i * i).collect(Collectors.toList());
    }

    //метод, принимающий на вход коллекцию строк и возвращает все строки, начинающиеся с заданной буквы, отсортированные по алфавиту
    public static List<String> strsFilterByFirstLetter(List<String> list, String letter){
        return list.stream()
                .filter(s -> s.startsWith(letter))
                .sorted()
                .collect(Collectors.toList());


    }

    //метод, принимающий на вход коллекцию и возвращающий ее последний элемент или кидающий исключение, если коллекция пуста
    public static <T> T listLastElement(Collection<T> list){
        return list.stream()
                .reduce((first,second)->second) //reduce комбинирует элементы потока в одно значение, возвращает Optional<T>
                .orElseThrow(()->new NoSuchElementException("Exception: List is empty."));
    }

    //метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет
    public static int sumOfEvens(int[] array) {
        return Arrays.stream(array)
                .filter(number->number%2==0)
                .sum();
    }

    //метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение
    public static Map<Character, String> stringsListConvertToMap(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1),(s1, s2) -> s1 + "," + s2, Hashtable::new));

    }

}