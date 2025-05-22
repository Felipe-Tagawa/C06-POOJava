package main.br.inatel.projetojava.Model.personagens;

import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.itens.consumiveis.Consumiveis;
import main.br.inatel.projetojava.Model.itens.inventario.Inventario;
import main.br.inatel.projetojava.Model.personagens.combate.Combate;
import main.br.inatel.projetojava.Model.personas.Habilidades;
import main.br.inatel.projetojava.Model.personas.Personas;

import java.util.*;

public abstract class UsuarioPersona extends SerHumano implements Combate {

    protected int nivel;
    public Set<Itens> item = new HashSet<>(); // Agregação
    public Inventario inventario; // Não faz sentido um inventário existir sem usuário - composição - public pra usar na main.
    protected double defesa = 0;
    protected double sp;
    protected double hp;
    protected int danoArma = 3; // Dano base da arma (exemplo apenas pois precisa implementar os itens de arma)

    public UsuarioPersona(String nome, int idade, String genero, int nivel, String arcana, double hp, double sp) {
        super(nome, idade, genero, arcana);
        this.nivel = nivel;
        this.inventario = new Inventario();
        this.hp = hp;
        this.sp = sp;
    }

    @Override
    public void interagir() {

    }

    public abstract void usarPersona(Personas persona);

    public abstract void addPersona(Personas persona);

    public void usarItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nConsumíveis disponíveis:");
        Map<Consumiveis, Integer> consumiveis = this.inventario.getConsumiveis();

        if (consumiveis.isEmpty()) {
            System.out.println("Nenhum item consumível disponível!");
            return;
        }

        int i = 1;
        List<Consumiveis> listaConsumivel = new ArrayList<>();
        for (Map.Entry<Consumiveis, Integer> entry : consumiveis.entrySet()) {
            System.out.println(i + " - " + entry.getKey().getNome() + " (Quantidade: " + entry.getValue() + ")");
            listaConsumivel.add(entry.getKey());
            i++;
        }

        System.out.println("\nEscolha um item para usar (0 para cancelar):");
        int escolha = scanner.nextInt();

        if (escolha == 0) {
            return;
        }

        if (escolha > 0 && escolha <= listaConsumivel.size()) {
            Consumiveis itemSelecionado = listaConsumivel.get(escolha - 1);

            if (itemSelecionado.getStatus().equalsIgnoreCase("HP")) {
                this.setHp(this.getHp() + itemSelecionado.getValor());
                System.out.println("HP recuperado: +" + itemSelecionado.getValor());
            } else if (itemSelecionado.getStatus().equalsIgnoreCase("SP")) {
                this.setSp(this.getSp() + itemSelecionado.getValor());
                System.out.println("SP recuperado: +" + itemSelecionado.getValor());
            }

            this.inventario.removerConsumivel(itemSelecionado);
            System.out.println("Item " + itemSelecionado.getNome() + " usado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    // Como a evolução será igual para protagonista e/ou usuário, não precisa ser abstract.
    public void evoluirPersona(Personas persona){
        persona.setNivel(persona.getNivel() + 1);
    }

    public String getArcana() {
        return arcana;
    }

    public void setArcana(String Arcana) {
        this.arcana = Arcana;
    }


    // Implementação da 'interface' de Combate

    @Override
    public void atacar(Personas persona, UsuarioPersona alvo) {
        if (alvo == null || persona == null) {
            System.out.println("Ataque inválido! Persona ou alvo nulo.");
            return;
        }

        System.out.println("\nEscolha o tipo de ataque:");
        System.out.println("1 - Ataque Físico");
        System.out.println("2 - Usar Habilidade da Persona");

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
            default -> System.out.println("Opção inválida!");
        }

        defesa = 0; // Reseta defesa no fim do turno
    }

    @Override
    public void defender() {
        System.out.println(nome + " está se defendendo e receberá menos dano no próximo ataque.");
        this.defesa = 10; // pode ser adaptado conforme a lógica de buffs futuros
    }

    @Override
    public boolean agir(int turno, Personas persona, UsuarioPersona alvo) {
        System.out.println("\nTurno " + turno + " de " + nome);
        System.out.println("Escolha sua ação: ");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar Item");
        System.out.println("4 - Sair");

        int opcao = new Scanner(System.in).nextInt();
        switch (opcao) {
            case 1:
                atacar(persona, alvo);
                break;
            case 2:
                defender();
                break;
            case 3:
                usarItem();
                break;
            case 4:
                System.out.println("Saindo...");
                return false;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        return true;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = Math.max(0, hp); // Garante que não fique negativo
    }

    public double getDefesa() {
        return defesa;
    }

    public int getDanoArma() {
        return danoArma;
    }

    public void setDanoArma(int danoArma) {
        this.danoArma = danoArma;
    }
}