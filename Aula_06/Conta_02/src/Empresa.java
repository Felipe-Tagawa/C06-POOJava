public class Empresa {

    String nome;
    Departamento dep;

    public Empresa(){
        dep = new Departamento(); // Construtor para Composição(outro tipo de composição em que há dependência).
    }
}
