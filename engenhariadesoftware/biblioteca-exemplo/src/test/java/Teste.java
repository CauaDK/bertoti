import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.sql.*;

class Teste {

    @Test
    public void test() {
        Biblioteca bib = new Biblioteca();

        bib.conectar();
        bib.criarTabela();

        bib.addLivro(new Livro("Senhor dos Aneis", "Tolkien", "123"));
        bib.addLivro(new Livro("Java", "Autor", "321"));

        Livro busca = bib.buscarLivroTitulo("Senhor dos Aneis");
        assertEquals(busca.getAutor(), "Tolkien");
    }
}
