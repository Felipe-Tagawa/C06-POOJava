package main.br.inatel.projetojava.DAO;

import main.br.inatel.projetojava.Model.itens.equipamentos.Equipamento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO extends ConnectionDAO {

    public void insertEquipamento(Equipamento equipamento) {
        connectToDb();
        String sql = "INSERT INTO equipamento (nome, tipo, valor, defesa, status, genero) values(?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, equipamento.getNome());
            pst.setString(2, equipamento.getTipo());
            pst.setDouble(3, equipamento.getValor());
            pst.setDouble(4, equipamento.getDefesa());
            pst.setString(5, equipamento.getStatus());
            pst.setString(6, equipamento.getGenero());
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir equipamento: " + e.getMessage());
        }
    }

    public List<String[]> getAllEquipamentos() {
        ArrayList<String[]> equipamentos = new ArrayList<>();
        connectToDb();
        String sql = "SELECT * FROM equipamento";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] equipamento = new String[6];
                equipamento[0] = rs.getString("nome");
                equipamento[1] = rs.getString("tipo");
                equipamento[2] = String.valueOf(rs.getDouble("valor"));
                equipamento[3] = String.valueOf(rs.getDouble("defesa"));
                equipamento[4] = rs.getString("status");
                equipamento[5] = rs.getString("genero");
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar equipamentos: " + e.getMessage());
        }
        return equipamentos;
    }

    public void updateEquipamento(String nome, String tipo, double valor, double defesa, String status, String genero) {
        connectToDb();
        String sql = "UPDATE equipamento SET tipo=?, valor=?, defesa=?, status=?, genero=? WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setDouble(2, valor);
            pst.setDouble(3, defesa);
            pst.setString(4, status);
            pst.setString(5, genero);
            pst.setString(6, nome);
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar equipamento: " + e.getMessage());
        }
    }

    public void deleteEquipamento(String nome) {
        connectToDb();
        String sql = "DELETE FROM equipamento WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar equipamento: " + e.getMessage());
        }
    }

}
