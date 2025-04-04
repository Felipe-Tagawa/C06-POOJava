/**
 * Sistema de Loja de Computadores
 * Este programa simula uma loja de computadores onde o cliente pode:
 * - Visualizar diferentes modelos de computadores;
 * - Comprar até 3 unidades de cada modelo (limite de estoque);
 * - Ver o valor total das compras;
 * Classes:
 * - Cliente: armazena dados do cliente e seus computadores;
 * - Computador: representa um computador com hardware, sistema e memória;
 * - HardwareBasico: componentes básicos (CPU, RAM, HD);
 * - OS: Sistema Operacional;
 * - MemoriaUSB: dispositivo de armazenamento externo.
 */

import java.util.Scanner;

public class Main {

    // Função de compra de novos computadores.
    public static void comprarPC(Computador computador, Cliente cliente) {
        for (int i = 0; i < cliente.computadores.length; i++) {
            if (cliente.computadores[i] == null) {
                cliente.computadores[i] = computador; // Lógica principal: inserir os computadores num vetor de computadores.
                cliente.valor = 0; // Zerar para evitar duplicações de valor.
                System.out.println("Valor atual: R$ " + cliente.calculaTotalCompra()); // Valor a cada nova compra.
                return;
            }
        }
    }


    // Função auxiliar apenas para mostrar as promoções disponíveis.
    public static void mostraOpcoesComputador(){

        System.out.println();
        System.out.println("Escolha entre as opções de promoção a seguir para visualizar: ");
        System.out.println();
        System.out.println("Modelo 1 - Mais Simples e Barato.");
        System.out.println("Modelo 2 - Intermediário.");
        System.out.println("Modelo 3 - Mais Robusto e Caro.");
        System.out.println("4 - Ir para as compras.");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Bem-vindo à loja de computadores, primeiro insira o seu nome: ");

        String nome = entrada.nextLine(); // Nome do cliente.
        // Lógica para evitar problemas de entrada de nome nulo:
        while (nome.isEmpty()) {
            System.out.println("Insira um nome permitido: ");
            nome = entrada.nextLine();
        }

        System.out.print("Agora insira seu CPF para login: "); // CPF do cliente.
        long cpf = Long.parseLong(entrada.nextLine());
        Cliente cliente = new Cliente(nome, cpf); // Criação do cliente.
        cliente.computadores = new Computador[9]; // Instanciando os computadores(estoque com máx. 9 PCs -- minha lógica).

        System.out.println("Veja nossas opções de computadores: ");

        Computador[] modelos = new Computador[3]; // Vetor de modelos de computadores.

        // instanciando os modelos utilizando o construtor da classe Computador:
        modelos[0] = new Computador("Apple", 2037.f);
        modelos[1] = new Computador("Samsung", 3721.f);
        modelos[2] = new Computador("Dell", 7715.f);

        // Instanciando os componentes do PC:
        for (Computador modelo : modelos) {
            modelo.hw = new HardwareBasico[3];
            modelo.hw[0] = new HardwareBasico();
            modelo.hw[1] = new HardwareBasico();
            modelo.hw[2] = new HardwareBasico();
            modelo.sistema = new OS();
            modelo.mem = new MemoriaUSB();
        }

        // Setando os valores para cada um dos modelos:
        modelos[0].hw[0].setNome("Pentium Core i3");
        modelos[0].hw[1].setNome("Memoria RAM");
        modelos[0].hw[2].setNome("HD");
        modelos[0].hw[0].setCapacidade(2200); // 2200 MHz.
        modelos[0].hw[1].setCapacidade(8); // 8Gb Memória Ram.
        modelos[0].hw[2].setCapacidade(500); // 500 Gb HD.
        modelos[0].sistema.setNome("Linux Ubuntu");
        modelos[0].sistema.setTipo(32); // 32 bits
        modelos[0].mem.setNome("Pen-Drive");
        modelos[0].mem.setCapacidade(16); // 16Gb
        modelos[0].addMemoriaUSB(modelos[0].mem);

        modelos[1].hw[0].setNome("Pentium Core i5");
        modelos[1].hw[1].setNome("Memoria RAM");
        modelos[1].hw[2].setNome("HD");
        modelos[1].hw[0].setCapacidade(3370); // 3370 MHz.
        modelos[1].hw[1].setCapacidade(16); // 16Gb Memória Ram.
        modelos[1].hw[2].setCapacidade(1000); // 1000Gb HD ou 1Tb.
        modelos[1].sistema.setNome("Windows 8");
        modelos[1].sistema.setTipo(64); // 64 bits
        modelos[1].mem.setNome("Pen-drive");
        modelos[1].mem.setCapacidade(32); // 32Gb
        modelos[1].addMemoriaUSB(modelos[1].mem);

        modelos[2].hw[0].setNome("Pentium Core i7");
        modelos[2].hw[1].setNome("Memoria RAM");
        modelos[2].hw[2].setNome("HD");
        modelos[2].hw[0].setCapacidade(4500); // 4500 MHz.
        modelos[2].hw[1].setCapacidade(32); // 32Gb Memória Ram.
        modelos[2].hw[2].setCapacidade(2000); // 2000 Gb HD ou 2Tb.
        modelos[2].sistema.setNome("Windows 10");
        modelos[2].sistema.setTipo(64); // 64 bits
        modelos[2].mem.setNome("HD Externo");
        modelos[2].mem.setCapacidade(1000); // 1000 Gb ou 1Tb
        modelos[2].addMemoriaUSB(modelos[2].mem);

        mostraOpcoesComputador();

        // ‘Loop’ para mostrar as promoções de computadores:
        int opcao;
        do {
            opcao = entrada.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                modelos[opcao - 1].mostraPCConfigs();
                mostraOpcoesComputador();
            }
            else if (opcao == 4) {
                /* Vai sair do while. */
            }
            else {
                System.out.println("Escreva um valor válido.");
            }

        } while (opcao != 4);

        //Lógica de no máximo 3 computadores de cada promoção poderem ser comprados por cada usuário(estoque).
        boolean[] escolhido = new boolean[3]; // Aplicar a lógica de estoque, começam com false.

        boolean[] compradoFull = new boolean[3]; // Vai ser verdadeira se todos os computadores de tal promoção se esgotarem.

        int[] comprados = new int[3]; // Fazer a contagem de computadores(usado apenas para mostrar no final).

        System.out.println("Vejo que agora está ciente das promoções!");

        // 'Loop' para compra de computadores:
        do {
            System.out.println("Escolha sua opção (1 - 3) ou 0 para sair:");
            opcao = entrada.nextInt();

            if (opcao >= 1 && opcao <= 3) { // Opcões válidas.

                if(comprados[opcao - 1] < 3){ // Opção - 1 porque o vetor começa no 0 e a opção no 1.
                    // Instanciando um computador geral para compra.
                    Computador computador = new Computador(modelos[opcao - 1].marca, modelos[opcao - 1].preco);

                    // Próximas linhas vão instanciar os componentes deste computador.
                    computador.hw = new HardwareBasico[3];
                    for (int i = 0; i < 3; i++) {
                        computador.hw[i] = new HardwareBasico();
                        computador.hw[i].setNome(modelos[opcao - 1].hw[i].getNome());
                        computador.hw[i].setCapacidade(modelos[opcao - 1].hw[i].getCapacidade());
                    }
                    computador.sistema = new OS();
                    computador.sistema.setNome(modelos[opcao - 1].sistema.getNome());
                    computador.sistema.setTipo(modelos[opcao - 1].sistema.getTipo());

                    computador.mem = new MemoriaUSB();
                    computador.mem.setNome(modelos[opcao - 1].mem.getNome());
                    computador.mem.setCapacidade(modelos[opcao - 1].mem.getCapacidade());
                    computador.addMemoriaUSB(computador.mem);

                    comprarPC(computador, cliente); // Comprar um novo PC.
                    System.out.println("Computador " + modelos[opcao - 1].marca + " comprado!");

                    comprados[opcao - 1]++; // Incrementa o computador de opcao - 1 modelo.
                    escolhido[opcao - 1] = true; // A compra é oficializada.

                    // Lógica do estoque:
                    if(comprados[opcao - 1] == 3){
                        compradoFull[opcao - 1] = true;
                    }
                }
                else {
                    System.out.println("Você já comprou o " + modelos[opcao - 1].marca + " o número máximo de vezes!");
                }

            }else if (opcao != 0) {
                System.out.println("Escolha uma opção válida!");
            }
        } while (opcao != 0);

        // Toda a lógica seguinte depende de pelo menos um computador ser comprado.
        if (escolhido[0] || escolhido[1] || escolhido[2]) {
            System.out.println("O(s) PC(s) comprado(s) é(são):");
            System.out.println();

            // Mostrando as configs dos PCs comprados:
            for (int i = 0; i < cliente.computadores.length; i++) {
                if (cliente.computadores[i] != null) {
                    cliente.computadores[i].mostraPCConfigs();
                }
            }

            // Mostrar a quantidade dos modelos comprados:
            System.out.printf("| %-53s | ", "Você comprou " + comprados[0] + " " + modelos[0].marca);
            System.out.println();
            System.out.printf("| %-53s | ", "Você comprou " + comprados[1] + " " + modelos[1].marca);
            System.out.println();
            System.out.printf("| %-53s | ", "Você comprou " + comprados[2] + " " + modelos[2].marca);
            System.out.println();

            // O uso das %- : apenas para deixar a entrada mais elegante.
            if (compradoFull[0] && compradoFull[1] && compradoFull[2]) {
                System.out.printf("| %-53s | ", "Você comprou todos os computadores disponíveis!");
                System.out.println();
            }

            cliente.valor = 0; // Resetar para não considerar o valor já calculado no método.

            System.out.printf("| %-53s | ", "O valor total das compras: R$ " + cliente.calculaTotalCompra());
            System.out.println();
            System.out.println("|-------------------------------------------------------|");
        } else {
            System.out.println("Nenhuma compra foi feita, esperamos que tenha mais interesse na próxima!");
        }

        System.out.println();
        System.out.println("Obrigado " + cliente.nome + ", volte sempre!");
        entrada.close();
    }
}