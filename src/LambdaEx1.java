import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx1 {
   private static Random random = new Random();
    private static Supplier<Integer> supplier = () ->  { return random.nextInt(99); };
    private static <T> void consumeList (List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
    private static <T> List<Integer> filterByPredicate (List<T> list, Predicate<T> predicate){
        List<Integer> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t))
                filteredList.add((Integer) t);
        }
        return filteredList;
    }

    public static void main(String[] args) {

        List<Integer> randomNumbers = generateList(100, supplier);
        System.out.println(randomNumbers);
        consumeList(randomNumbers,integer -> System.out.print((integer) + " "));
        List<Integer> numbersNotDividedByTwo = filterByPredicate(randomNumbers, integer -> ((integer % 2 > 0) || (integer == 0)));
        System.out.println("\n");
        consumeList(numbersNotDividedByTwo, integer -> System.out.print((integer) + " "));


    }


    private static List<Integer> generateList (int elements, Supplier supplier){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<elements; i++){
            Integer number = (Integer) supplier.get();
            result.add(number);
        }
        return result;
    }
}
