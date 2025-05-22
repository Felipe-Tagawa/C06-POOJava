package main.br.inatel.projetojava.Model.personagens.jogaveis;

import main.br.inatel.projetojava.Model.itens.Ativador;
import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.itens.armas.Arma;
import main.br.inatel.projetojava.Model.itens.consumiveis.Consumiveis;
import main.br.inatel.projetojava.Model.itens.equipamentos.Equipamento;
import main.br.inatel.projetojava.Model.itens.inventario.Inventario;
import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;
import main.br.inatel.projetojava.Model.personas.Habilidades;
import main.br.inatel.projetojava.Model.personas.Personas;

import java.util.*;

public class Protagonista extends UsuarioPersona {

    public List<Personas> personas; // O protagonista pode ter mais de uma persona.
    private double saldo;
    private int id;
    public Personas persona_atual;
    public Ativador ativador;

    public Protagonista(String nome, int idade, String genero, int nivel, String arcana, double hp, double sp, double saldo, int Ativador_idAtivador) {
        super(nome, idade, genero, nivel, arcana, hp, sp);
        this.personas = new ArrayList<>(); // Composição
        this.saldo = saldo;
        this.inventario = new Inventario();
        this.ativador = new Ativador(Ativador_idAtivador);
    }

    // Sobrecarga de construtor para busca de protagonista com ID em SQL
    public Protagonista(String nome, int idade, String genero, int nivel, String arcana, double hp, double sp, double saldo, int Ativador_idAtivador, int id) {
        super(nome, idade, genero, nivel, arcana, hp, sp);
        this.personas = new ArrayList<>(); // Composição
        this.saldo = saldo;
        this.inventario = new Inventario();
        this.ativador = new Ativador(Ativador_idAtivador);
        this.id = id;
    }



    // Fazer associação simples com usuário:
    // Usuarios usuarios; // Associação

    /*public Protagonista(int idProtagonista, String nome, int idade, String genero, int nivel, String arcana, double hp, double sp, double saldo) {
        super(nome, idade, genero, arcana, hp, sp);
        this.personas = new ArrayList<>(); // Composição
        this.saldo = saldo;
        this.inventario = new Inventario();
    }*/


    @Override
    public void usarPersona(Personas persona) {

    }

    @Override
    public void addPersona(Personas persona) {
        this.personas.add(persona);
    }

    @Override
    public void mostraInfoPersonagem() {
        System.out.println("Nome do Protagonista: " + nome);
        System.out.println("Idade do Protagonista: " + idade);
        System.out.println("Genero do Protagonista: " + genero);
        System.out.println();
        System.out.println("Personas do Protagonista: ");
        for(Personas persona : personas){
            if(persona != null){
                persona.mostrarStatusPersona();
                System.out.println();
            }
        }
        for (Personas p : personas) {
            System.out.println("Habilidades de " + p.getNome() + ":");
            for (Habilidades h : p.getHabilidades()) {
                h.descreverHabilidade();
                System.out.println();
            }
        }
    }

    public void darItemUsuario(Usuarios usuario, Itens novo_item){
        if(usuario.item == null){
            usuario.item = new HashSet<>();
        }
        switch(novo_item){
            case Arma arma -> {
                if(this.inventario.getQuantidadeArma(arma) > 0){
                    usuario.inventario.adicionarArma((Arma)novo_item, 1);
                    this.inventario.removerArma(novo_item);
                    System.out.println("Arma " + novo_item.getNome() + " transferido para " + usuario.getNome() + "\n");
                }
                else{
                    System.out.println("Protagonista não possui essa arma. Tente novamente.");
                }
            }
            case Equipamento equipamento -> {
                if(this.inventario.getQuantidadeEquipamento(equipamento) > 0){
                    usuario.inventario.adicionarEquipamento((Equipamento)novo_item, 1);
                    this.inventario.removerEquipamento(novo_item);
                    System.out.println("Equipamento " + novo_item.getNome() + " transferido para " + usuario.getNome() + "\n");
                }
                else{
                    System.out.println("Protagonista não possui esse equipamento. Tente novamente.");
                }
            }
            case Consumiveis consumivel -> {
                if (this.inventario.getQuantidadeConsumivel(consumivel) > 0) {
                    usuario.inventario.adicionarConsumivel((Consumiveis)novo_item, 1);
                    this.inventario.removerConsumivel(novo_item);
                    System.out.println("Colecionavel " + novo_item.getNome() + " transferido para " + usuario.getNome() + "\n");
                }
                else{
                    System.out.println("Protagonista não possui esse consumível. Tente novamente.");
                }
            }
            default -> System.out.println("Item não está entre os tipos! Tente novamente.");
        }
    }

    public void trocarPersona(){
        Scanner entrada = new Scanner(System.in);
        int opcao;

       while(true) {
           System.out.println("Suas personas são: \n");
           int i = 0;
           for (Personas persona : personas) {
               System.out.println((i+1) + " " + persona.getNome());
               i++;
           }
           System.out.println("Digite o indice da persona para qual quer trocar: ");
           opcao = entrada.nextInt();

           if(opcao > 0 && opcao < personas.size()){
               persona_atual = personas.get(opcao - 1);
               break;
           }
           else{
               System.out.println("Escolha invalida");
           }
       }
    }

    public void fundirPersona(Personas p1, Personas p2){

    }

    @Override
    public void atacar(Personas persona, UsuarioPersona alvo) {
        if (alvo == null || persona == null) {
            System.out.println("Ataque inválido! Persona ou alvo nulo.");
            return;
        }

        System.out.println("\nEscolha o tipo de ataque:");
        System.out.println("1 - Ataque Físico");
        System.out.println("2 - Usar Habilidade da Persona atual");
        System.out.println("3 - Trocar persona atual");

        Scanner scanner = new Scanner(System.in);
        int escolhaTipo = scanner.nextInt();

        switch (escolhaTipo) {
            case 1 -> {
                double danoFinal = Math.max(0, danoArma - alvo.getDefesa());
                alvo.setHp(alvo.getHp() - danoFinal);
                System.out.println(nome + " realizou um ataque físico causando " + danoFinal + " de dano em " + alvo.getNome());
            }
            case 2 -> {
                List<Habilidades> habilidades = persona.getHabilidades();
                if (habilidades.isEmpty()) {
                    System.out.println("Essa persona não possui habilidades!");
                    return;
                }

                System.out.println("Escolha a habilidade:");
                for (int i = 0; i < habilidades.size(); i++) {
                    Habilidades hab = habilidades.get(i);
                    System.out.println((i + 1) + " - " + hab.getNome() + " (Dano: " + (hab.getDano()-alvo.getDefesa()) + ", SP: 10)");
                }

                int escolhaHab = scanner.nextInt() - 1;
                if (escolhaHab < 0 || escolhaHab >= habilidades.size()) {
                    System.out.println("Habilidade inválida!");
                    return;
                }

                Habilidades hab = habilidades.get(escolhaHab);
                double custoSP = 10;

                if (sp < custoSP) {
                    System.out.println("SP insuficiente!");
                    return;
                }

                sp -= custoSP;
                double danoFinal = Math.max(0, hab.getDano() - alvo.getDefesa());
                alvo.setHp(alvo.getHp() - danoFinal);
                System.out.println(nome + " usou " + hab.getNome() + " causando " + danoFinal + " de dano!");
                System.out.println("SP restante: " + sp);
            }
            case 3 -> trocarPersona();
            default -> System.out.println("Opção inválida!");
        }

        defesa = 0; // Reseta defesa no fim do turno
    }

    // Getters e setters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNivel() {
        return nivel;
    }
    public int getId() {
        return id;
    }

}