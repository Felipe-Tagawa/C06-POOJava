public class Personas {

    private String nome;
    private int nivel;
    private String Arcana;
    private String[] tipo; // Inserir os tipos no UML.
    private Habilidades[] habilidades;

    public Personas(String nome, int nivel, String Arcana, String[] tipo) {
        this.nome = nome;
        this.nivel = nivel;
        this.Arcana = Arcana;
        this.habilidades = new Habilidades[10];
        this.tipo = new String[2];
        this.tipo[0] = tipo[0];
        this.tipo[1] = tipo[1];
    }

    public void aprenderHabilidade(Habilidades habilidade){

    }

    public void mostrarStatus(){
        System.out.println("Nome da Persona: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Arcana: " + Arcana);
        System.out.println("Tipo: " + tipo[0] + ", " + tipo[1]);
        System.out.println("Habilidades: ");
        for(Habilidades habilidade : habilidades){
            if(habilidade != null){
                habilidade.descreverHabilidade();
            }
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

    public String getArcana() {
        return Arcana;
    }

    public void setArcana(String arcana) {
        Arcana = arcana;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public Habilidades[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidades[] habilidades) {
        this.habilidades = habilidades;
    }
}
