public class Main {
    public static void main(String[] args) {
        Cantina cantina  = new Cantina();
        Salgado []salgado = new Salgado[3];
        Salgado s1 = new Salgado();
        salgado[0] = s1;
        Salgado s2 = new Salgado();
        salgado[1] = s2;
        Salgado s3 = new Salgado();
        salgado[2] = s3;

        cantina.nome = "Cantina do Inatel";

        salgado[0].nome = "Empada";
        salgado[1].nome = "Pizza";
        salgado[2].nome = "Hamburguer de calabresa";

        for(int i = 0; i < salgado.length; i++) {
            cantina.addSalgado(salgado[i]);
        }

        cantina.mostraInfo();

    }
}