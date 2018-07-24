import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        learnStream();
    }

    public static void learnStream() {

        List<Integer> lists = new ArrayList<>();
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        System.out.println("elements in lists:");
        for (Integer integer : lists) {
            System.out.print(integer);
            System.out.print("  ");
        }
        System.out.println();

        Stream<Integer> stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
    }
}