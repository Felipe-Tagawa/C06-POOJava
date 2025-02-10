import java.util.Scanner; // Importando o Scanner para entrada de dados.
public class Main {
    public static void main(String[] args) {

        Scanner novo_scanner = new Scanner(System.in);
        // novo_scanner.nextLine(); //NextLine serve para entrada de strings.

        System.out.println("Digite o valor de 3 lanches(valores inteiros): ");
        int lanche1 = novo_scanner.nextInt();
        int lanche2 = novo_scanner.nextInt();
        int lanche3 = novo_scanner.nextInt();

        int total = lanche1 + lanche2 + lanche3;
        int media = total / 3;

        System.out.println("Total de lanches: " + total);
        System.out.println("Media de lanches: " + media);

        novo_scanner.close(); // Indica problema de memória.

    }
}