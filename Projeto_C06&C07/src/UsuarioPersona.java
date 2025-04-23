public class UsuarioPersona extends SerHumano{

    public int nivel;
    public String Arcana;
    Personas personas;

    public UsuarioPersona(String nome, int idade, String genero) {
        super(nome, idade, genero);
    }

    @Override
    public void interagir() {

    }

    public void usarItem(){

    }

    public void usarPersona(){

    }

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
        System.out.println("Nome: (" + personas.nome +
                ") ::> Nível: (" + personas.nivel +
                ") ::> Arcana: (" + personas.Arcana +
                ") ::> Tipos: (" + personas.tipo[0] + ", " + personas.tipo[1] + ")"
        );
    }

    public void evoluirPersona(){

    }

}
