package main.br.inatel.projetojava.DAO;

import main.br.inatel.projetojava.Model.hub.Cidade;
import main.br.inatel.projetojava.Model.personagens.SerHumano;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends ConnectionDAO {

    public void insertCidade(Cidade cidade) {
        connectToDb();
        String sql = "INSERT INTO cidade (nome) VALUES (?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cidade.getNomeCidade());
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar cidade: " + e.getMessage());
        }
    }

    public void adicionarLocal(String nomeCidade, String nomeLocal) {
        connectToDb();
        String sql = "INSERT INTO locais (nome_cidade, nome_local) VALUES (?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nomeCidade);
            pst.setString(2, nomeLocal);
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar local: " + e.getMessage());
        }
    }

    public void adicionarPersonagemAoLocal(String nomeLocal, SerHumano personagem) {
        connectToDb();
        String sql = "INSERT INTO personagens_local (nome_local, id_personagem) VALUES (?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nomeLocal);
            pst.setString(2, personagem.getNome());
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar personagem ao local: " + e.getMessage());
        }
    }

    public List<Cidade> buscarTodasCidades() {
        List<Cidade> cidades = new ArrayList<>();
        connectToDb();
        String sql = "SELECT * FROM cidade";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cidade cidade = new Cidade(rs.getString("nome"));
                cidades.add(cidade);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cidades: " + e.getMessage());
        }
        return cidades;
    }

    public void deletarCidade(String nomeCidade) {
        connectToDb();
        String sql = "DELETE FROM cidade WHERE nome = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nomeCidade);
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cidade: " + e.getMessage());
        }
    }

}
