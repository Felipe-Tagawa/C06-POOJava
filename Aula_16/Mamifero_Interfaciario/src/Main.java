import br.inatel.cdg.animal.Boi;
import br.inatel.cdg.animal.Cachorro;
import br.inatel.cdg.animal.Lontra;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Pedro", 100);
        cachorro.emitirSom();
        cachorro.mostraInfo();
        Lontra lontra = new Lontra("Davi", 50);
        lontra.nadar();
        lontra.emitirSom();
        lontra.mostraInfo();
        Boi boi = new Boi("Laranja", 200);
        boi.emitirSom();
        boi.mostraInfo();
    }
}