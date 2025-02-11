import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o número de alunos(as): ");
       int alunos = entrada.nextInt();

       switch (alunos) {
           case 10, 20:
               System.out.println("Sala I-16");
           break;
           //case 20:
           //    System.out.println("Sala I-16");
           //break;
           case 30:
               System.out.println("Sala I-22");
           break;
       }

       entrada.close();

    }
}