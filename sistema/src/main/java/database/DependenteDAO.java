package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import model.Dependente;

// para poder colocar o @Inject no Controller
@RequestScoped
public class DependenteDAO {

// Consultas
    private PreparedStatement selectTodos;
    private PreparedStatement selectPorId;
    private PreparedStatement selectDependentePorIdPessoa;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement insert;

    // Conexao
    private ConexaoPostgreSQL con;

    public DependenteDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL(ConexaoPostgreSQL.HOST, ConexaoPostgreSQL.USER, ConexaoPostgreSQL.PASSWORD, ConexaoPostgreSQL.DATABASE);
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }
        this.initStatement();
    }

    private void initStatement() throws SQLException {
        this.selectDependentePorIdPessoa = con.getConnection().prepareStatement("select * from dependente inner join  pessoa on (pessoa.id =dependente.id_pessoa) where pessoa.id = ?;");
        this.selectPorId = con.getConnection().prepareStatement("select * from dependente where id = ?;");
        this.selectTodos = con.getConnection().prepareStatement("select * from dependente order by nome;");
        this.delete = con.getConnection().prepareStatement("delete from dependente where id = ?");
        this.update = con.getConnection().prepareStatement("update dependente set id_pessoa = ?, nome = ?, sobrenome = ? where id = ?;");
        this.insert = con.getConnection().prepareStatement("insert into dependente (id_pessoa, nome, sobrenome) values (?, ?,?);");
    }

    public Dependente selectPorId(int id) throws SQLException {
        this.selectPorId.setInt(1, id);
        ResultSet rs = this.selectPorId.executeQuery();
        Dependente dependente = new Dependente();
        if (rs.next()) {
            dependente.setId(rs.getInt("id"));
            dependente.setPessoa(new PessoaDAO().selectPorId(Integer.parseInt(rs.getString("id_pessoa"))));
            dependente.setNome(rs.getString("nome"));
            dependente.setSobrenome(rs.getString("sobrenome"));
        }
        this.selectPorId.close();
        return dependente;
    }

    public ArrayList<Dependente> selectDependentePorIdPessoa(int id) throws SQLException {
        ArrayList<Dependente> todos = new ArrayList();
        ResultSet rs;
        Dependente dependente = new Dependente();
        try {
            rs = this.selectTodos.executeQuery();
            while (rs.next()) {
                todos.add(new Dependente(rs.getInt("id"), new PessoaDAO().selectPorId(Integer.parseInt(rs.getString("id_pessoa"))), rs.getString("nome"), rs.getString("sobrenome")));
            }
            this.selectTodos.close();
        } catch (SQLException e) {
            return todos;
        }
        return todos;
    }

    public ArrayList<Dependente> selectTodos() throws SQLException {
        ArrayList<Dependente> todos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.selectTodos.executeQuery();
            while (rs.next()) {
                todos.add(new Dependente(rs.getInt("id"), new PessoaDAO().selectPorId(Integer.parseInt(rs.getString("id_pessoa"))), rs.getString("nome"), rs.getString("sobrenome")));
            }
            this.selectTodos.close();
        } catch (SQLException e) {
            return todos;
        }
        return todos;
    }

    public boolean insert(Dependente dependente) {
        try {
            this.insert.setInt(1, dependente.getPessoa().getId());
            this.insert.setString(2, dependente.getNome());
            this.insert.setString(3, dependente.getSobrenome());
            this.insert.execute();
            this.insert.close();
            return true;
        } catch (Exception erro) {
            return false;
        }
    }

    public void delete(int id) throws SQLException {
        this.delete.setInt(1, id);
        this.delete.execute();
        this.delete.close();
    }

    public void deleteMassa(int id[]) {
        for (int i = 0; i < id.length; i++) {
            try {
                this.delete.setInt(1, id[i]);
                this.delete.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            this.delete.close();
        } catch (SQLException ex) {
            Logger.getLogger(DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean update(Dependente dependente) {
        try {
            this.update.setInt(1, dependente.getPessoa().getId());
            this.update.setString(2, dependente.getNome());
            this.update.setString(3, dependente.getSobrenome());
            this.update.setInt(4, dependente.getId());
            this.update.execute();
            this.update.close();
            return true;
        } catch (Exception erro) {
            return false;
        }
    }
}
