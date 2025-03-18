public class Main {
    public static void main(String[] args) {

        int [][] matriz = new int[3][3];

        for(int[] linha : matriz){ // Precisa retirar de uma matriz um vetor, pois cada array acessa outro.
            for(int valores : linha){
                System.out.print(valores + " ");
            }
            System.out.println("");
        }
    }
}