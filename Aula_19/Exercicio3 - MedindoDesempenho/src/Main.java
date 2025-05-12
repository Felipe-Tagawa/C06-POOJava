import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Exercício de Prova
        List<Integer> AL = new ArrayList<>();
        long tempoInicialAL = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            AL.add(i);
        }

        long tempoFinalAL = System.currentTimeMillis();
        long tempoAL = tempoFinalAL - tempoInicialAL;

        System.out.println(tempoAL);

        long tempoInicialHS = System.currentTimeMillis();
        Set<Integer> HS = new HashSet<>();
        for(int i = 0; i < 100000; i++) {
            HS.add(i);
        }
        long tempoFinalHS = System.currentTimeMillis();
        long tempoHS = tempoFinalHS - tempoInicialHS;
        System.out.println(tempoHS);

        Map<Integer, Integer> map = new HashMap<>();
        long tempoInicialMap = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        long tempoFinalMap = System.currentTimeMillis();
        long tempoMap = tempoFinalMap - tempoInicialMap;
        System.out.println(tempoMap);

        if(tempoAL < tempoHS && tempoAL < tempoMap) {
            System.out.println("ArrayList");
        }
        else if(tempoHS < tempoAL && tempoHS < tempoMap) {
            System.out.println("HashSet");
        }
        else {
            System.out.println("HashMap");
        }

        // Buscas:

        long buscaTempoInicialAl = System.currentTimeMillis();
        boolean achou = false;
        for(int i = 0; i < 100000; i++) {
            if(AL.contains(i)) {
                achou = true;
            }
        }

        if(achou) {
            tempoFinalAL = System.currentTimeMillis();
            tempoAL = tempoFinalAL - buscaTempoInicialAl;
            System.out.println(tempoAL + " ms");
        }

        long buscaTempoInicialHs = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            if(HS.contains(i)) {
                achou = true;
            }
        }

        if(achou) {
            tempoFinalHS = System.currentTimeMillis();
            tempoHS = tempoFinalHS - buscaTempoInicialHs;
            System.out.println(tempoHS + " ms");
        }

        long buscaTempoInicialMap = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            if(map.containsKey(i)) {
                achou = true;
            }
        }

        if(achou) {
            tempoFinalMap = System.currentTimeMillis();
            System.out.println(tempoFinalMap - buscaTempoInicialMap + " ms");
        }

        // ArrayList - inserção mais rápida(sem hashing)
        // ArrayList - busca mais devagar(força bruta)



    }
}