package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import model.Pessoa;

// para poder colocar o @Inject no Controller
@RequestScoped 
public class PessoaDAO {
    
// Consultas
    private PreparedStatement selectTodos;    
    private PreparedStatement selectPorId;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement insert;
   
    // Conexao
    private ConexaoPostgreSQL con;

    public PessoaDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL(ConexaoPostgreSQL.HOST, ConexaoPostgreSQL.USER, ConexaoPostgreSQL.PASSWORD, ConexaoPostgreSQL.DATABASE);
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }
        this.initStatement();
    }

    private void initStatement() throws SQLException {
        this.selectPorId = con.getConnection().prepareStatement("select * from pessoa where id = ?;");
        this.selectTodos = con.getConnection().prepareStatement("select * from pessoa order by nome;");
        this.delete = con.getConnection().prepareStatement("delete from pessoa where id = ?");
        this.update = con.getConnection().prepareStatement("update pessoa set nome = ?, sobrenome = ? where id = ?;");
        this.insert = con.getConnection().prepareStatement("insert into pessoa (nome, sobrenome) values (?,?) RETURNING id;");
    }
    
    public Pessoa selectPorId(int id) throws SQLException{
         this.selectPorId.setInt(1, id);
         ResultSet rs = this.selectPorId.executeQuery();
         Pessoa pessoa = new Pessoa();
         if (rs.next()){
             pessoa.setId(rs.getInt("id"));
             pessoa.setNome(rs.getString("nome"));
             pessoa.setSobrenome(rs.getString("sobrenome"));
         }
        this.selectPorId.close();
        return pessoa;
    }

    public ArrayList<Pessoa> selectTodos() throws SQLException {
        ArrayList<Pessoa> todos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.selectTodos.executeQuery();
            while (rs.next()) {
                todos.add(new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome")));
            }
            this.selectTodos.close();
        } catch (SQLException e) {
            return todos;  
        }
        return todos;
    }

    public int insert(Pessoa pessoa) throws SQLException {
            this.insert.setString(1, pessoa.getNome());
            this.insert.setString(2, pessoa.getSobrenome());
            ResultSet rs = this.insert.executeQuery();
            int id  = -1;
            if (rs.next()){
                id = rs.getInt("id");
            }
            this.insert.close();            
            //rs.close();
            return id;
    }

    public void delete(int id) throws SQLException {
        this.delete.setInt(1, id);
        this.delete.execute();
        this.delete.close();
    }
    
    public void deleteMassa(int id[]){
       for (int i = 0; i < id.length; i++){ 
           try {
               this.delete.setInt(1, id[i]);
               this.delete.execute();             
           } catch (SQLException ex) {
               Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       try {
           this.delete.close();
       } catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public boolean update(Pessoa pessoa) {
          try {
            this.update.setString(1, pessoa.getNome());
            this.update.setString(2, pessoa.getSobrenome());
            this.update.setInt(3, pessoa.getId());
            this.update.execute();
            this.update.close();
            return true;
        } catch (Exception erro) {
            return false;
        }
    }
}
