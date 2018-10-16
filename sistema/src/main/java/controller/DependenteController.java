package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import database.DependenteDAO;
import database.PessoaDAO;
import java.sql.SQLException;
import javax.inject.Inject;
import model.Dependente;
import model.Pessoa;

@Controller
public class DependenteController {
    @Inject private Result result;
    @Inject private DependenteDAO dependenteDAO;
   
    public void listar() throws SQLException {        
        result.include("vetDependente", dependenteDAO.selectTodos());
    } 
    
        
    @Path("/dependente/tela_inserir/{id}")
    public void tela_inserir(int id) throws SQLException {
        result.include("pessoa", new PessoaDAO().selectPorId(id));
    }
    
    public void inserir(Dependente dependente) throws SQLException {
        
        dependenteDAO.insert(dependente);
        result.redirectTo(PessoaController.class).visualiza(dependente.getPessoa().getId());
    }
    
    @Path("/dependente/tela_editar/{id}")
    public void tela_editar(int id) throws SQLException {
        result.include("dependente", dependenteDAO.selectPorId(id));
    }

    public void editar(Dependente dependente) throws SQLException {
        dependenteDAO.update(dependente);
        result.redirectTo(DependenteController.class).listar();
    }
    
    @Path("/dependente/deletar/{id}")
    public void deletar(int id) throws SQLException {
        dependenteDAO.delete(id);
        result.redirectTo(DependenteController.class).listar();
    }
}
