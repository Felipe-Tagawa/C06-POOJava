import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        boolean [][] matriz = new boolean [2][2];

        Random rand = new Random();
        Scanner entrada = new Scanner(System.in);
        // Gera o valor de 0 ou 1.
        int x = rand.nextInt(2);
        int y = rand.nextInt(2);
        int numTentativas = 3;

        System.out.println(x + " e " + y);

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = false;

                if(x == i && y == j){
                    matriz[i][j] = true;
                    break;
                }
            }
        }

        while(true) {
            System.out.println("Digite dois números de coordenadas: ");
            int digitado1 = entrada.nextInt();
            int digitado2 = entrada.nextInt();
            while(!matriz[digitado1][digitado2] && numTentativas >= 0) {
                if (digitado1 == x && digitado2 == y) {
                    System.out.println("Morreu, tente novamente!");
                    break;
                }
                else {
                    System.out.println("Posição segura, continue!");
                    numTentativas--;
                    break;
                }
            }
            if (digitado1 == x && digitado2 == y) {
                System.out.println("Morreu, tente novamente!");
                break;
            }
            if(numTentativas == 0){
                System.out.println("Parabéns, você ganhou!");
                break;
            }
        }
    }
}