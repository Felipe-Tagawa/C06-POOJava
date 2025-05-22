import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Path arquivo = Paths.get("professores_disciplinas.txt");

        // Escrita no arquivo:

        try{
            Files.writeString(arquivo, "Guilherme=Introducao a Engenharia");
            Files.writeString(arquivo, "Ynoguti=Algoritmos");
            Files.writeString(arquivo, "Chris=POO");
            Files.writeString(arquivo, "Renzao=BD");
            Files.writeString(arquivo,"Marcelo=CG");
            Files.writeString(arquivo,"Soned=tudo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Leitura do arquivo:

        try{
            List<String> conteudo = Files.readAllLines(arquivo);
            Map<String, String> configuracoes = new HashMap<>();

            conteudo.forEach((linha) -> {
                String[] linhaQuebrada = linha.split(";"); // split separa a linha.
                configuracoes.put(linhaQuebrada[0], linhaQuebrada[1].strip()); // strip retira o espaço em branco.
                System.out.println(configuracoes);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}