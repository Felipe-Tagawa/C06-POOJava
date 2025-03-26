import br.inatel.cdg.inimigo.Asteroide;
import br.inatel.cdg.jogador.Nave;

public class Main {
    public static void main(String[] args) {

        Nave n1 = new Nave("Nave1", 100, "teleguiado");
        Nave n2 = new Nave("Nave2", 200, "incendiário");

        Asteroide ast1 = new Asteroide("Vesta", "metálico");
        Asteroide ast2 = new Asteroide("Ceres", "silicoso");

        System.out.println("O nome da primeira nave é " + n1.getNome() + " e seu tipo de tiro é " + n1.getTipoTiro() + " com vida = " + n1.getVida());
        System.out.println("O nome da segunda nave é " + n2.getNome() + " e seu tipo de tiro é " + n2.getTipoTiro() + " com vida = " + n2.getVida());

        System.out.println("A nave " + n1.getNome() + " atirou com sucesso!");
        n1.atirar(ast1);
        n2.atirar(ast2);

    }
}