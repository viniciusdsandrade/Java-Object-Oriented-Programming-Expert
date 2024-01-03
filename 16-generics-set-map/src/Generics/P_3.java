package src.Generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_3 {
    public static void main(String[] args) {
        List<?> myObjs = List.of("Maria", 1, 2.0, 3L);
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> myInts = Arrays.asList(5, 2, 10);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs2 = new ArrayList<>();

        List<? super Number> myNums = myObjs2;

        myNums.add(10);
        myNums.add(3.14);

        Number x = (Number) myNums.getFirst();
        System.out.println("X: " + x);

        copy(myInts, myObjs2);
        copy2(myDoubles, myObjs2);

        System.out.println("myObjs2: ");
        System.out.println(Arrays.toString(myObjs2.toArray()));

        System.out.println(Arrays.toString(myObjs.toArray()));
        printList(myNumbers);

        myObjs = myNumbers;
        printList(myObjs);

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        System.out.println("Total area: " + String.format("%.8f", totalArea(myShapes)));
    }

    private static void copy2(
            List<? extends Number> source,
            List<? super Number> destination
    ) {
        destination.addAll(source);
    }

    private static void copy(
            List<? extends Integer> source,
            List<? super Integer> destination
    ) {
        destination.addAll(source);
    }

    public static double totalArea(@NotNull List<? extends Shape> list) {
        return list.stream().mapToDouble(Shape::area).sum();
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}