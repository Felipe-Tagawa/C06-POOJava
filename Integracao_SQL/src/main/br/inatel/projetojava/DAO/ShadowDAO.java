package main.br.inatel.projetojava.DAO;

import main.br.inatel.projetojava.Model.personas.Personas;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShadowDAO extends ConnectionDAO {

    
    //Inserir shadow no banco
    public void insertShadow(Personas shadow) {
        connectToDb();
        String sql = "INSERT INTO shadow(nome, nivel, arcana, tipos, fraqueza, resistencia, dano) values(?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, shadow.getNome());
            pst.setInt(2, shadow.getNivel());
            pst.setString(3, shadow.getArcana());
            pst.setString(4, String.join(",", shadow.getTipo()));
            pst.setString(5, shadow.getFraqueza());
            pst.setString(6, shadow.getResistencia());
            pst.setDouble(7, shadow.getDano());
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Shadow: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    //Buscar shadow pelo nome
    public Personas getShadowByName(String nome) {
        connectToDb();
        ArrayList<String> tipos = new ArrayList<>();
        Personas shadow = null;
        String sql = "SELECT * FROM shadow WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                tipos.add(rs.getString("tipo1"));
                tipos.add(rs.getString("tipo2"));
                shadow = new Personas(
                        rs.getString("nome"),
                        rs.getInt("nivel"),
                        rs.getString("arcana"),
                        tipos,
                        rs.getString("fraqueza"),
                        rs.getString("resistencia"),
                        rs.getDouble("dano")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Shadow: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return shadow;
    }

    //Atualizar shadow
    public void updateShadow(Personas shadow) {
        connectToDb();
        String sql = "UPDATE shadow SET nivel=?, arcana=?, tipos=?, fraqueza=?, resistencia=?, dano=? WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, shadow.getNivel());
            pst.setString(2, shadow.getArcana());
            pst.setString(3, String.join(",", shadow.getTipo()));
            pst.setString(4, shadow.getFraqueza());
            pst.setString(5, shadow.getResistencia());
            pst.setDouble(6, shadow.getDano());
            pst.setString(7, shadow.getNome());
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Shadow: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    //Deletar shadow
    public void deleteShadow(String nome) {
        connectToDb();
        String sql = "DELETE FROM shadow WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Shadow: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    //Verificar se shadow existe
    public boolean shadowExists(String nome) {
        connectToDb();
        String sql = "SELECT * FROM shadow WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar Shadow: " + e.getMessage());
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
