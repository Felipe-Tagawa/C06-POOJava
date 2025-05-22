package main.br.inatel.projetojava.Model.personas;

import main.br.inatel.projetojava.Model.itens.Ativador;
import main.br.inatel.projetojava.Model.personagens.SerHumano;

import java.util.ArrayList;
import java.util.List;

public class Personas {

    private String nome;
    private int nivel;
    private final String arcana;
    private final List<String> tipo;
    private final String fraqueza;
    private final String resistencia;
    private double dano;
    private int id;

    private List<Habilidades> habilidades = new ArrayList<>();

    public void addHabilidade(Habilidades habilidade) {
        habilidades.add(habilidade);
    }


    public Personas(String nome, int nivel, String arcana, List<String> tipo, String fraqueza, String resistencia, double dano) {
        this.nome = nome;
        this.nivel = nivel;
        this.arcana = arcana;
        this.tipo = tipo;
        this.fraqueza = fraqueza;
        this.resistencia = resistencia;
        this.dano = dano;
    }

    // Sobrecarga de construtor para busca de persona com ID em SQL
    public Personas(String nome, int nivel, String arcana, List<String> tipo, String fraqueza, String resistencia, double dano, int id) {
        this.nome = nome;
        this.nivel = nivel;
        this.arcana = arcana;
        this.tipo = tipo;
        this.fraqueza = fraqueza;
        this.resistencia = resistencia;
        this.dano = dano;
        this.id = id;
    }

    public void aprenderHabilidade(Habilidades habilidade){

    }

    public void mostrarStatusPersona(){
        System.out.println("Nome da Persona: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Arcana: " + arcana);
        System.out.println("Tipo: " + tipo.get(0) + ", " + tipo.get(1));
        System.out.println("Fraqueza: " + fraqueza);
        System.out.println("Habilidades: ");
        for(Habilidades habilidade : habilidades){
            habilidade.descreverHabilidade();
        }
    }

    public void usarHabilidade(Habilidades habilidade, SerHumano alvo){

    }

    // Setters n Getters:


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<String> getTipo() {
        return tipo;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public String getArcana() {
        return arcana;
    }

    public String getFraqueza() {
        return fraqueza;
    }
    public String getResistencia() {
        return resistencia;
    }
    public double getDano() {
        return dano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}