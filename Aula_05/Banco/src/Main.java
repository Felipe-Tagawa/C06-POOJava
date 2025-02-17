public class Main {
    public static void main(String[] args) {

        // Criando uma nova instância de Conta!
        // E atribuindo a uma variável do tipo Conta!
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        Conta conta3 = new Conta();

        conta1.saldo = 10000;
        conta2.saldo = 20000;
        conta3.saldo = 3000;
        conta1.nome_do_Dono = "Joao";
        conta2.nome_do_Dono = "Maria";
        System.out.println("Nome do Dono da conta 1: " + conta1.nome_do_Dono +
                " e seu saldo: " + conta1.saldo);

        conta1.sacar(1000);
        System.out.println("Saldo novo: " + conta1.saldo);

    }
}