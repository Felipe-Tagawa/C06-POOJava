import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ArrayList é dinâmico.

        // Pode-se adicionar quaisquer tipos de dados num único ArrayList(não interessante - necessidade de casting):
        List listagenerica = new ArrayList();
        listagenerica.add("Item 1");
        listagenerica.add(2);
        int numero = (int) listagenerica.get(1); // Há necessidade de saber o tipo manualmente.
        System.out.println(numero);

        List <String> listaString = new ArrayList/*<String>*/(); // Essa segunda ‘String’ é redundante
        // Apenas retorna ‘Strings’.
        // Se for usado o add de um tipo diferente, ele não considera, começa a inserir a partir da primeira ‘String’
        listaString.add("Elemento1"); // Sobrecarga do métod0 add.
        listaString.add(1,"Elemento2");

        for(String elemento: listaString){
            System.out.println(elemento);
        }

        for(int i = 0; i < listaString.size(); i++){
            System.out.println(listaString.get(i));
        }

        // Ordenando Elementos:

        Collections.sort(listaString);

        // Classes Wrapper(usada nas listas):

        // Integer // Classe de inteiros.
        // Float // Classe de float.
        // Double // Classe de double.
        // Long // Classe de long.
        // Short // Classe de short.
        // Byte // Classe de byte.
        // Character // Classe de char - usar o String.
        // Boolean // Classe de boolean.
        // String // Classe de String.





    }
}