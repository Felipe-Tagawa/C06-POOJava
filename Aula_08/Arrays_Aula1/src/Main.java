public class Main {
    public static void main(String[] args) {

        // Podemos guardar classes em vetores.
        // Declarando um array:

        double z[] = {1,2,3,4};
        int []x = new int[10]; // 10 Elementos.
        Conta contas[] = new Conta[5];

        Conta conta1 = new Conta();
        contas[0] = conta1;

        //Percorrer array:

        for(int i = 0; i < z.length; i++){
            System.out.println(z[i]);
        }

        // For-Each:
        for(double array : z){
            System.out.println(array);
        }

        System.out.println(x);

    }
}