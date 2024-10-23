package lecture;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Привет", "мир", "!", "Я", "родился", "!");

        //        list = list.stream().filter(str -> str.length() > 3).toList();
        //        for (String item : list) {
        //            System.out.println(item);
        //        }

        //        list.stream().filter(str->str.length()>3).forEach(s -> System.out.println(s));

        list.stream().filter(str -> str.length() > 3).forEach(System.out::println);

        list.stream().filter(str -> str.length() > 3).filter(str -> str.contains("о")).forEach(System.out::println);


        List<User> list1 =
                Arrays.asList(new User("Bob", 15), new User("Smith", 20), new User("Djo", 25), new User("Anna", 30));
        list1.stream().map(user -> new User(user.name, user.age + 5)).filter(user -> user.age <= 25)
                .forEach(System.out::println);
    }
}