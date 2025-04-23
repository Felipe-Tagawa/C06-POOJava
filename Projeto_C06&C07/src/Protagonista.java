public class Protagonista extends UsuarioPersona{

    Personas[] personas;

    public Protagonista(String nome, int idade, String genero) {
        super(nome, idade, genero);
        this.personas = new Personas[10];
    }

    public void trocarPersona(Personas novaPersona){

    }

    public void fundirPersona(Personas p1, Personas p2){

    }

}

