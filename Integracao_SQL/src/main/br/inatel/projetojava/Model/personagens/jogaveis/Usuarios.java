package main.br.inatel.projetojava.Model.personagens.jogaveis;


import main.br.inatel.projetojava.Model.itens.Ativador;
import main.br.inatel.projetojava.Model.itens.inventario.Inventario;
import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;
import main.br.inatel.projetojava.Model.personas.Personas;

public class Usuarios extends UsuarioPersona {

    private final String papel;
    private Personas persona;
    private final boolean vilao;
    private int id;
    public Ativador ativador;

    // Construtor existente
    public Usuarios(String nome, int idade, String genero, int nivel, String arcana, double hp, double sp, String papel, boolean vilao) {
        super(nome, idade, genero, nivel, arcana, hp, sp);
        this.vilao = vilao;
        this.inventario = new Inventario();
        this.papel = papel;
    }

    public Usuarios(String nome, int idade, String genero, int nivel, String arcana, double hp, double sp, String papel, boolean vilao, int id) {
        super(nome, idade, genero, nivel, arcana, hp, sp);
        this.vilao = vilao;
        this.inventario = new Inventario();
        this.papel = papel;
        this.id = id;
    }


    public void falarComProtagonista(Protagonista protagonista){

    }

    @Override
    public void mostraInfoPersonagem() {
        System.out.println("Nome do Usuário: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Gênero: " + genero);
        System.out.println("Papel: " + papel);
        System.out.println("Arcana: " + arcana);
        if(isVilao())
            System.out.println("Vilão");
        else
            System.out.println("Herói");
    }

    @Override
    public void usarPersona(Personas persona) {

    }

    @Override
    public void addPersona(Personas persona) {
        this.persona = persona;
    }

    public Personas getPersonas() {
        return persona;
    }

    public boolean isVilao(){
        return vilao;
    }

    public String getPapel(){
        return papel;
    }
    public int getNivel(){
        return nivel;
    }
    public int getId(){
        return id;
    }

    public int getPersonaId() {
        return persona.getId();
    }

    public int getAtivadorId() {
        return ativador.getIdAtivador();
    }
}
