
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAOImplementar implements CategoriaDAO  {

ConexionDB conn;//CREAR EL OBJETO TIPO CONEXION

public CategoriaDAOImplementar(){

//DEFINIR A LA BASE DE DATOS QUE SE CONECTARA POR DEFECTO
}
    
    
    
@Override
 public List<Categoria> Listar() {
    
this.conn=FactoryConexionDB.open(FactoryConexionDB.MySQL);



StringBuilder miSQL = new StringBuilder(); //CONSTRUIR LA CONSULTA

miSQL.append("SELECT * FROM  tb_categoria;"); //AGREGAR LA CONSULTA

List<Categoria> lista = new ArrayList<Categoria>();

try{
//Se crea el objeto Result set implementando el metodo (consulta sql) creado para la consulta

ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
Categoria categoria = new Categoria();//DECLARAR EL OBJETO CATEGORIA

//ASIGNAR CADA CAMPO CONSULTADO AL ATRIBUTO EN LA CLASE 
categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
lista.add(categoria); //agregar al array cada registro
}
}catch(Exception ex){
    
}finally{
this.conn.cerrarConexion(); //PARA CERRAR LA CONEXION
}
return lista;

}

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    @Override
public Categoria editarCat(int id_cat_edit) {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL); //hacer la conexion
Categoria categoria = new Categoria (); //objeto categoria para devolver datos
StringBuilder miSQL =   new StringBuilder(); //CONSTRUIR LA CONSULTA

//AGREGAR LA CONSULTA
miSQL.append("SELECT * FROM  tb_categoria  WHERE  id_categoria =").append(id_cat_edit);
try{//REALIZAR LA CONSULTA
    
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
while(resultadoSQL.next()){
categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));

}

}catch(Exception e){
    
}finally{

this.conn.cerrarConexion(); //CERRAR CONEXION
}

return categoria;

}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean guardarCat(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
