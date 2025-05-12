import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Double> lista = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            lista.add(random.nextDouble(20));
        }

        Collections.sort(lista, Collections.reverseOrder());

        for(Double valor : lista){
            System.out.println(valor);
        }

    }
}