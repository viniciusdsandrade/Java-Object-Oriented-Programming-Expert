package src.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    /*
    Set<T>
    Representa um conjunto de elementos (similar ao da Álgebra)
    • Não admite repetições
    • Elementos não possuem posição
    • Acesso, inserção e remoção de elementos são rápidos
    • Oferece operações eficientes de conjunto: interseção, união, diferença.
    
    Principais implementações:
        • HashSet - mais rápido (operações O(1) em tabela hash) e não ordenado
        • TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
        • LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados
     */
    public static void main(String[] args) {
        Set<String> myHashSet = new HashSet<>();

        myHashSet.add("TV");
        myHashSet.add("Tablet");
        myHashSet.add("Notebook");

        System.out.println(myHashSet.contains("Notebook"));

        myHashSet.forEach(System.out::println);

        System.out.println("\nSize: " + myHashSet.size());
        System.out.println("Remove: " + myHashSet.remove("Tablet"));
        System.out.println("Size: " + myHashSet.size());
        System.out.println();

        myHashSet.forEach(System.out::println);

        System.out.println("------------------------------------------------");
        
        Set<Integer> a = new TreeSet<>(Set.of(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Set.of(5, 6, 7, 8, 9, 10));

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        
        // union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println("Union: " + c);
        
        // intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        
        System.out.println("Intersection: " + d);
        
        // difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        
        System.out.println("Difference: " + e); 
    }
}