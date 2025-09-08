import java.sql.*;

public class Biblioteca {

    private Connection conexao;

    public void conectar() {
        try {
            String url = "jdbc:sqlite:meubanco.db";
            conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS biblioteca (titulo TEXT, autor TEXT, isbn TEXT PRIMARY KEY);)";
        try (Statement stat = conexao.createStatement()) {
            stat.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void addLivro(Livro livro) {
        String sql = "INSERT INTO biblioteca (titulo, autor ,isbn) VALUES (?, ?, ?)";
        try (PreparedStatement prepare = conexao.prepareStatement(sql)) {
            prepare.setString(1, livro.getTitulo());
            prepare.setString(2, livro.getAutor());
            prepare.setString(3, livro.getIsbn());
            prepare.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }

    public Livro buscarLivroTitulo(String titulo) {
        String sql = "SELECT * FROM biblioteca WHERE titulo = ?";
        try (PreparedStatement prepare = conexao.prepareStatement(sql)) {
            prepare.setString(1, titulo);
            ResultSet rows = prepare.executeQuery();
            if (rows.next()) {
                return new Livro(rows.getString("titulo"), rows.getString("autor"), rows.getString("isbn"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
        return null;
    }
//    public Livro buscarLivroIsbn(String isbn){
//        for(Livro livro : livros){
//            if(livro.getIsbn().equals(isbn))
//                return livro;
//        }
//        return null;
//    }
}