package br.inatel.projetojava.personagens.jogaveis;

import br.inatel.projetojava.itens.armas.Arma;
import br.inatel.projetojava.itens.equipamentos.Equipamento;
import br.inatel.projetojava.personagens.UsuarioPersona;
import br.inatel.projetojava.personas.Personas;

public class Protagonista extends UsuarioPersona {

    public Personas[] personas; // O protagonista pode ter mais de uma persona.

    // N fiz as composições ou agregações:
    Equipamento[] equipamento;
    Arma[] arma;

    public Protagonista(String nome, int idade, String genero, int nivel) {
        super(nome, idade, genero, nivel);
        this.personas = new Personas[10];
    }

    @Override
    public void usarPersona() {

    }

    @Override
    public void mostraInfoPersonagem() {
        System.out.println("Nome do br.inatel.projetojava.personagens.jogaveis.Protagonista: " + nome);
        System.out.println("Idade do br.inatel.projetojava.personagens.jogaveis.Protagonista: " + idade);
        System.out.println("Genero do br.inatel.projetojava.personagens.jogaveis.Protagonista: " + genero);
        System.out.println();
        System.out.println("br.inatel.projetojava.personas.Personas do br.inatel.projetojava.personagens.jogaveis.Protagonista: ");
        for(Personas persona : personas){
            if(persona != null){
                persona.mostrarStatus();
                System.out.println();
            }
        }
    }

    public void trocarPersona(Personas novaPersona){

    }

    public void fundirPersona(Personas p1, Personas p2){

    }

}