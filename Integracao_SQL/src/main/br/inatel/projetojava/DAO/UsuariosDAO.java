package main.br.inatel.projetojava.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.br.inatel.projetojava.Model.personagens.jogaveis.Usuarios;

public class UsuariosDAO extends ConnectionDAO {

    public boolean insertUsuario(Usuarios usuario) {
        connectToDb();
        String sql = "INSERT INTO usuarios(nome, idade, genero, nivel, arcana, hp, sp, papel, vilao) values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setInt(2, usuario.getIdade());
            pst.setString(3, usuario.getGenero());
            pst.setInt(4, usuario.getNivel());
            pst.setString(5, usuario.getArcana());
            pst.setDouble(6, usuario.getHp());
            pst.setDouble(7, usuario.getSp());
            pst.setString(8, usuario.getPapel());
            pst.setBoolean(9, usuario.isVilao());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public List<Usuarios> selectUsuarios() {
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        connectToDb();
        String sql = "SELECT * FROM usuarios";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuarios usuario = new Usuarios(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("genero"),
                        rs.getInt("nivel"),
                        rs.getString("arcana"),
                        rs.getDouble("hp"),
                        rs.getDouble("sp"),
                        rs.getString("papel"),
                        rs.getBoolean("vilao")
                );
                usuarios.add(usuario);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return usuarios;
    }

    public boolean updateUsuario(Usuarios usuario) {
        connectToDb();
        String sql = "UPDATE usuarios SET idade=?, genero=?, nivel=?, arcana=?, hp=?, sp=?, papel=?, vilao=? WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, usuario.getIdade());
            pst.setString(2, usuario.getGenero());
            pst.setInt(3, usuario.getNivel());
            pst.setString(4, usuario.getArcana());
            pst.setDouble(5, usuario.getHp());
            pst.setDouble(6, usuario.getSp());
            pst.setString(7, usuario.getPapel());
            pst.setBoolean(8, usuario.isVilao());
            pst.setString(9, usuario.getNome());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public boolean deleteUsuario(String nome) {
        connectToDb();
        String sql = "DELETE FROM usuarios WHERE nome=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
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
