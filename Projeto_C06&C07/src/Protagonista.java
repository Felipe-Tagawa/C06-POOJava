public class Protagonista extends UsuarioPersona{

    Personas[] personas; // O protagonista pode ter mais de uma persona.

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
        System.out.println("Nome do Protagonista: " + nome);
        System.out.println("Idade do Protagonista: " + idade);
        System.out.println("Genero do Protagonista: " + genero);
        System.out.println();
        System.out.println("Personas do Protagonista: ");
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