import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Path arquivo = Paths.get("configuracao.txt");
        // ReadAllLines:
        try{
            List<String> conteudo = Files.readAllLines(arquivo);
            Map<String, String> configuracoes = new HashMap<>();

            conteudo.forEach((linha) -> {
                String[] linhaQuebrada = linha.split(";"); // split separa a linha.
                configuracoes.put(linhaQuebrada[0], linhaQuebrada[1].strip()); // strip retira o espaço em branco.
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            String conteudoString = Files.readString(arquivo);
            System.out.println(conteudoString);
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            Files.writeString(arquivo, "Nova String");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}