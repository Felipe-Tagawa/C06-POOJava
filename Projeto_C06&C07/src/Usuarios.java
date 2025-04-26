public class Usuarios extends UsuarioPersona{

    public String papel;
    public boolean vilao;

    public Usuarios(String nome, int idade, String genero, String papel, boolean vilao, String arcana) {
        super(nome, idade, genero);
        this.papel = papel;
        this.vilao = vilao;
        this.setArcana(arcana); // Precisou-se utilizar o setArcana, já que Arcana está private na UsuarioPersona.
    }

    public void atacar(Personas persona) { // Atacar personagem ou persona ou os dois?

    }

    public void defender(){

    }

    public void agir(int turno){

    }

    public void falarComProtagonista(){

    }

    @Override
    public void mostraInfoPersonagem() {
        System.out.println("Nome do Usuário: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Gênero: " + genero);
        System.out.println("Papel: " + papel);
        System.out.println("Arcana: " + this.getArcana());
        if(vilao)
            System.out.println("Vilão");
        else
            System.out.println("Herói");

        if(genero.equals("Masculino"))
            System.out.println("Persona do " + nome + " é: " + personas.getNome());
        else
            System.out.println("Persona da " + nome + " é: " + personas.getNome());
    }
}
