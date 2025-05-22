package main.br.inatel.projetojava.Model.hub;

import main.br.inatel.projetojava.Model.exceptions.InvalidMenuInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCidade {
    // ANSI Cores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static int opcao;

    public static int mostrarMenuCidade(String localAtual) throws InvalidMenuInputException {
        Scanner sc = new Scanner(System.in);

        System.out.println(ANSI_PURPLE +
                "╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      🏙️ MENU PRINCIPAL DA CIDADE                   ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");

        int espacosNecessarios = 54 - localAtual.length();
        StringBuilder espacos = new StringBuilder();
        for (int i = 0; i < espacosNecessarios; i++) {
            espacos.append(" ");
        }

        System.out.println("║ Local atual: " + localAtual + espacos + "║");

        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ [1] 🚶 Viajar para outro local                                     ║");
        System.out.println("║ [2] 👥 Ver quem está aqui                                          ║");
        System.out.println("║ [3] 🤝 Interagir com alguém                                        ║");
        System.out.println("║ [4] ⚔️ Enfrentar um vilão (se houver)                              ║");
        System.out.println("║ [5] 🛒 Visitar a loja de itens                                     ║");
        System.out.println("║ [0] 🚪 Sair do jogo                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);

        System.out.print(ANSI_CYAN + "👉 Escolha uma opção: " + ANSI_RESET);
        try {
            opcao = sc.nextInt();
            if (opcao < 0 || opcao > 5) {
                throw new InvalidMenuInputException("Valor inválido! Tente novamente...");
            }
            sc.nextLine();

            if (opcao == 0) {
                System.out.println(ANSI_YELLOW + "Saindo do menu da cidade...!" + ANSI_RESET);
            }
            return opcao;

        }catch(InputMismatchException e){
            throw new InvalidMenuInputException("Por favor, insira um número inteiro...");
        }
    }
}