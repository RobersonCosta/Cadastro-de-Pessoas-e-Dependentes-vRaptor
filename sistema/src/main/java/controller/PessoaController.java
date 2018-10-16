package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import database.DependenteDAO;
import database.PessoaDAO;
import java.sql.SQLException;
import javax.inject.Inject;
import model.Pessoa;

@Controller
public class PessoaController {
    @Inject private Result result;
    @Inject private PessoaDAO pessoaDAO;
   
    public void listar() throws SQLException {        
        result.include("vetPessoa", pessoaDAO.selectTodos());
    } 
    
    
    
    public void tela_inserir() {
    }
    
    public void inserir(Pessoa pessoa) throws SQLException {
        int id = pessoaDAO.insert(pessoa);
        pessoa.setId(id);
        result.redirectTo(DependenteController.class).tela_inserir(id);
    }
    
    @Path("/pessoa/tela_editar/{id}")
    public void tela_editar(int id) throws SQLException {
        result.include("pessoa", pessoaDAO.selectPorId(id));
    }

    public void editar(Pessoa pessoa) throws SQLException {
        pessoaDAO.update(pessoa);
        result.redirectTo(PessoaController.class).listar();
    }
    @Path("/pessoa/deletar/{id}")
    public void deletar(int id) throws SQLException {
        pessoaDAO.delete(id);
        result.redirectTo(PessoaController.class).listar();
    }
    @Path("/pessoa/visualiza/{id}")
    public void visualiza(int id) throws SQLException {        
        result.include("pessoa", pessoaDAO.selectPorId(id));
        result.include("vetDependente", new DependenteDAO().selectDependentePorIdPessoa(id));
    }
    
}
