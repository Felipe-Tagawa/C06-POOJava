import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner new_scan = new Scanner(System.in);

        System.out.println("Digite a nota NPA: ");
        int NPA = new_scan.nextInt();

        if(NPA >= 60){
            System.out.println("Parabéns, você passou!");
        }
        else{
            System.out.println("Ficou de NP3 :(");
            int NP3 = new_scan.nextInt();

            if((NP3 + NPA)/ 2 >= 50){
                System.out.println("Aprovado com NP3");
            }
            else{
                System.out.println("Reprovado com NP3");
            }
        }
        new_scan.close();
    }
}