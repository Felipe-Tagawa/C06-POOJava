import java.util.*;

public class Main {
    public static void main(String[] args) {
        // HashSet possui alto desempenho para buscar elementos (não pode repetir elementos) - sem ordem.
        Set<String> conjunto = new HashSet<>();
        conjunto.add("String1");
        conjunto.add("String2");
        conjunto.add("String3");

        System.out.println(conjunto.remove("String2"));
        for(String elemento : conjunto){
            System.out.println(elemento);
        } // Sem indíces.

        // LinkedHashSet -- Mantém a ordem de inserção, mas perde desempenho se comparado ao HashSet
        Set<String> conjunto2 = new LinkedHashSet<>();

        // HashMap - Dicionário (chave-valor)

        // Inserção: put(chave, valor);
        // Busca: get(chave);
        // É necessário saber o valor da chave para encontrar o valor.
        // Necessidade de teste de null para corrigir null pointer exception.
        // Se for inserido um valor numa chave já existente, o valor é sobrescrito.
        // Iterando com Lambda:
        Map<String,Double> mapaPrecoStreaming = new HashMap<>();

        mapaPrecoStreaming.put("Netflix", 19.99);
        mapaPrecoStreaming.put("Amazon Prime", 19.99);
        mapaPrecoStreaming.put("Spotify", 8.99);
        mapaPrecoStreaming.put("Cinema", 14.99);

        mapaPrecoStreaming.forEach((chave,valor) ->
                System.out.println(chave + " : " + valor));

    }
}