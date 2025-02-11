import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt(10) + 1;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int y = entrada.nextInt();

        while(true){
            if(y == x){
                System.out.println("Acertou!");
                break;
            }
            else{
                System.out.println("Errou, tente novamente!");
                if(y > x){
                    System.out.println("Tente um valor menor!");
                }
                else{
                    System.out.println("Tente um valor maior!");
                }
            }
            y = entrada.nextInt();
        }

    }
}