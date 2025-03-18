import br.inatel.cdg.Cliente;
import br.inatel.cdg.Conta;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();

        cliente1.setNome("Joao");
        cliente2.setNome("Maria");
        cliente3.setNome("Pedro");
        cliente1.setCpf(123);
        cliente2.setCpf(456);
        cliente3.setCpf(789);

        Cliente []clientes = new Cliente[3];
        clientes[0] = cliente1;
        clientes[1] = cliente2;
        clientes[2] = cliente3;

        Conta conta = new Conta();
        conta.setCliente(clientes);

        conta.setLimite(500);
        conta.setNumero(1234);

        System.out.println(conta.getSaldo());

        conta.deposita(700);

        System.out.println(conta.getSaldo());

        conta.sacar(300);

        System.out.println(conta.getSaldo());

        conta.sacar(800);
    }

}