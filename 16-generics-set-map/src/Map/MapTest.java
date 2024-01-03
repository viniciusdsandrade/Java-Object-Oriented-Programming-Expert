package src.Map;

import src.Set.Product;

import java.util.Set;
import java.util.TreeSet;

public class MapTest {
    /*
    Map<K,V>
    
    • É uma coleção de pares chave / valor
        • Não admite repetições do objeto chave
        • Os elementos são indexados pelo objeto chave (não possuem posição)
        • Acesso, inserção e remoção de elementos são rápidos
        
    • Uso comum: cookies, local storage, qualquer modelo chave-valor
         Principais implementações:
          • HashMap - mais rápido (operações O(1) em tabela hash) e não ordenado
          • TreeMap - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
          • LinkedHashMap - velocidade intermediária e elementos na ordem em que são adicionados
          
    • put(key, value), remove(key), containsKey(key), get(key)
        • Baseado em equals e hashCode
        • Se equals e hashCode não existir, é usada comparação de ponteiros
        
    • clear()
    • size()
    
    • keySet() - retorna um Set<K>
    • values() - retorna um Collection<V>
     */

    public static void main(String[] args) {

        Set<Product> set = new TreeSet<>();
        
        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));
        
        Product prod = new Product("Notebook", 1200.0);
    }
}
