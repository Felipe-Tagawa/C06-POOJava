public class Personas {

    public String nome;
    public int nivel;
    public String Arcana;
    public String[] tipo; // Inserir os tipos no UML.
    public Habilidades[] habilidades;

    public Personas(String nome, int nivel, String Arcana, String[] tipo) {
        this.nome = nome;
        this.nivel = nivel;
        this.Arcana = Arcana;
        this.habilidades = new Habilidades[10];
        this.tipo = new String[2];
    }

    public void aprenderHabilidade(Habilidades habilidade){

    }

    public void mostrarStatus(){

    }

    public void usarHabilidade(Habilidades habilidade, SerHumano alvo){

    }

}
