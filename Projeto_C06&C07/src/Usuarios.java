public class Usuarios extends UsuarioPersona{

    public String papel;
    public boolean vilao;

    public Usuarios(String nome, int idade, String genero, String papel, boolean vilao) {
        super(nome, idade, genero);
        this.papel = papel;
        this.vilao = vilao;
    }

    public void atacar(Personas persona) { // Atacar personagem ou persona ou os dois?

    }

    public void defender(){

    }

    public void agir(int turno){

    }

    public void falarComProtagonista(){

    }

}
