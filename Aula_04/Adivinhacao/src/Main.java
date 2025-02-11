import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt(1,10);
        Scanner entrada = new Scanner(System.in);
        int y = entrada.nextInt();

        while(y != x){
            if(y == x){
                System.out.println("Acertou!");
                break;
            }
            else{
                System.out.println("Errou, tente novamente!");
            }
            y = entrada.nextInt();
        }

    }
}