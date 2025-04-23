public abstract class SerHumano {

    // No UML não está protected(#) - arrumar.
    protected String nome;
    protected int idade;
    protected String genero;

    // Falta construtor no UML.
    public SerHumano(String nome, int idade, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    // Criar métodos abstratos?

    public abstract void interagir();

}
