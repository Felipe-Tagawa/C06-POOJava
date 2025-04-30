public abstract class UsuarioPersona extends SerHumano{

    private int nivel;
    private String arcana;
    Personas personas;

    public UsuarioPersona(String nome, int idade, String genero, int nivel) {
        super(nome, idade, genero);
    }

    @Override
    public void interagir() {

    }

    public void usarItem(){

    }

    public abstract void usarPersona();

    //Adicionar esse métod0 no UML:

    public void addPersona(Personas persona){
        if(personas == null){
            personas = persona;
        }
    }

    // Personas não tem que estar ligado diretamente a usuários persona e não somente a protagonista?
    // Mudar esse métod0 no UML:
    public void mostraInfoPersona(){
        System.out.println("Informações da Persona: ");
        System.out.println();
        System.out.println("Nome: (" + personas.getNome() +
                ") :: Nível: (" + personas.getNivel() +
                ") :: Arcana: (" + personas.getArcana() +
                ") :: Tipos: (" + personas.getTipo()[0] + ", " + personas.getTipo()[1] + ")"
        );
        System.out.println();
        System.out.println("Habilidades da Persona: " + personas.getNome());
        System.out.println();
        for(Habilidades habilidade : personas.getHabilidades()){
            habilidade.descreverHabilidade();
            System.out.println();
        }
        System.out.println();
    }

    public void evoluirPersona(Personas persona){
        persona.setNivel(personas.getNivel() + 1);
    }

    public String getArcana() {
        return arcana;
    }

    public void setArcana(String Arcana) {
        this.arcana = Arcana;
    }
}
