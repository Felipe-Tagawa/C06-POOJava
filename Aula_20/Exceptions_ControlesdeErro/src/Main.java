import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Proteger o código avisando o usuário que houve um erro(tratamento de erros)
        // Continua o código mesmo com o erro
        /*try{ // Classe
            // Métod0 2:
            Conta conta = null;
            conta.deposita(250);
        } catch(NullPointerException e){
            System.out.println("Erro: " + e);
        }

        // ou:
        try {
            metodo2();

        }catch(NullPointerException e){
            System.out.println("Erro: " + e);
        } // Não mostra o fim do métod0 2, então antes de mostrar o fim, o catch puxa o erro direto e procura onde está o tratamento de erro

        // Exceções Unchecked: Compilador não checa(compilador mostra)
        // divisão por zero
        // Null Pointer Exception
        */

        Conta conta = new Conta(100, 500);
        Cliente cliente1 = new Cliente("Zezinho", 123456789);
        Cliente cliente2 = new Cliente("Zezao", 987654321);
        Cliente cliente3 = null;

        conta.setClientes(cliente1);
        conta.setClientes(cliente2);
        conta.setClientes(cliente3);


        try {
            conta.mostraInfo();
        }catch(NullPointerException e){
           System.out.println("Erro: " + e);
        }

    }
}