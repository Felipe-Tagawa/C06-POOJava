public class Main {
    public static void main(String[] args) {

        Conta conta = new Conta();
        Cliente cliente = new Cliente();

        cliente.nome = "Joao";
        cliente.cpf = "123.456.789";

        conta.titular = cliente; // Agregação é um tipo de Associação em que a parte(cliente) independe da existência do todo_(conta).

        System.out.println(conta.titular.nome);
        System.out.println(conta.titular.cpf);
        // ou
        System.out.println(cliente.nome);

    }
}