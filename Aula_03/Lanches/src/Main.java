import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        int lanche1 = 10;
        int lanche2 = 4;
        int lanche3 = 2;

        int total = lanche1 + lanche2 + lanche3;

        float media = (float)total / 3; // Casting.

        System.out.println("Total de lanches: " + total);
        System.out.println("Media de lanches: " + media);

        int x = 10;
        long x1 = x; // Promoção - raro de usar.
        float nota = 7.5F; // Precisa do F para entender que é float e não Double.



    }
}