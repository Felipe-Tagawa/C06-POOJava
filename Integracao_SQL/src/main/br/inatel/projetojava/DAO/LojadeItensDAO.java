package main.br.inatel.projetojava.DAO;

import main.br.inatel.projetojava.Model.itens.Itens;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LojadeItensDAO extends ConnectionDAO {

    private static final String TABLE = "loja_itens";

    public void insertItem(Itens item, int itemId, int quantidade) {
        connectToDb();
        String sql = "INSERT INTO " + TABLE + "(item_id, quantidade) VALUES (?, ?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, itemId);
            pst.setInt(2, quantidade);
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public void atualizarQuantidade(int itemId, int novaQuantidade) {
        connectToDb();
        String sql = "UPDATE " + TABLE + " SET quantidade = ? WHERE item_id = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, novaQuantidade);
            pst.setInt(2, itemId);
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar quantidade: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public Map<Integer, Integer> getItens() {
        Map<Integer, Integer> itens = new HashMap<>();
        connectToDb();
        String sql = "SELECT item_id, quantidade FROM " + TABLE;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                itens.put(rs.getInt("item_id"), rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar itens: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return itens;
    }
}
