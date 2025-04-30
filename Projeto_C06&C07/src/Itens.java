public abstract class Itens {
    protected String nome;
    protected String tipo;
    protected double valor;
    protected String status;

    public Itens(String nome, String tipo, double valor, String status){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public abstract void equiparItem(UsuarioPersona usuario);

    // Setters e Getters:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {}

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }
}
