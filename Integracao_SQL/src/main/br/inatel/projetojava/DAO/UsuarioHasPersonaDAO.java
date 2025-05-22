package main.br.inatel.projetojava.DAO;

import java.sql.SQLException;

public class UsuarioHasPersonaDAO extends ConnectionDAO {

    public void insertUsuarioHasPersona(int idUsuarios, int idPersona) {
        connectToDb();
        String sql = "INSERT INTO usuario_has_persona (idUsuarios, idPersona) VALUES (?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idUsuarios);
            pst.setInt(2, idPersona);
            pst.execute();
            System.out.println("Relação Usuario-Persona inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir relação: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public void deleteUsuarioPersona(int idUsuario, int idPersona) {
        connectToDb();
        String sql = "DELETE FROM usuario_has_persona WHERE usuario_id=? AND persona_id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.setInt(2, idPersona);
            pst.execute();
            System.out.println("Relação Usuario-Persona deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar relação: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }


}
