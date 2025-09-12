import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Teste {

    @Test
    public void test() {
        Curso curso = new Curso();
        curso.addAluno(new Aluno("Cauã Mohor", 18, 12345678));
        curso.addProf(new Professor("Bertoti", "Engenharia de Software"));
    }
}
