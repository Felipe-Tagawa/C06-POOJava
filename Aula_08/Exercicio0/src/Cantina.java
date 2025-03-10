public class Cantina {

    String nome;
    Salgado []salgado = new Salgado[3];


    public void addSalgado(Salgado novoSalgado){
        for(int i = 0; i < salgado.length; i++){
            if(salgado[i] == null){
                salgado[i] = novoSalgado;
                break;
            }
        }

    }

    public void mostraInfo(){
        for(int i = 0; i < salgado.length; i++){
            System.out.println(salgado[i].nome);
        }
    }

}
