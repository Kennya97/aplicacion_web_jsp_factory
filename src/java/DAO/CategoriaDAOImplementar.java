
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
miSQL.append("SELECT * FROM  tb_categoria  WHERE  id_categoria = ").append(id_cat_edit);

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
    
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL); //hacer la conexion

boolean guarda = false; //BANDERA DE RESULTADO
try{
    
if(categoria.getId_categoria() ==0){  //PARA CUANDO ES UNA NUEVA CATEGORIA

StringBuilder miSQL =   new StringBuilder (); //CONSTRUIR LA CONSULTA

//AGREGAR LA CONSULTA 

miSQL.append("INSERT INTO tb_categoria(nom_categoria,  estado_categoria) VALUES(' "); 
miSQL.append(categoria.getNom_categoria() +" ' , ").append(categoria.getEstado_categoria() );
miSQL.append(");");

//INVOCAR MÉTODO PARA EJECUTR LA CONSULTA
this.conn.ejecutarSQL(miSQL.toString());

}else if(categoria.getId_categoria() >0){  //Actualizar id categoria mayores a 0
StringBuilder miSQL =   new StringBuilder (); 

miSQL.append("UPDATE  tb_categoria SET  id_categoria = ").append(categoria.getId_categoria());

miSQL.append(" , nom_categoria =  ' ").append(categoria.getNom_categoria());

miSQL.append(" ' , estado_categoria =  ").append(categoria.getEstado_categoria());

miSQL.append(" WHERE id_categoria = ").append(categoria.getId_categoria()).append(";");

//INVOCAR EL METODO PARA EJECUTAR LA CONSULTA
this.conn.ejecutarSQL(miSQL.toString());

}
guarda= true;
}catch(Exception e){

}finally{
    
this.conn.cerrarConexion(); //CERRAR CONEXION

}
return guarda;
    
}

    
    
  
    
@Override
public boolean borrarCat(int id_cat_borrar) {
this.conn=FactoryConexionDB.open(FactoryConexionDB.MySQL);
boolean borra= false; //BANDERA DE RESULTADO
try {
StringBuilder miSQL =   new StringBuilder (); //CONSTRUIR LA CONSULTA
miSQL.append("DELETE FROM tb_categoria WHERE id_categoria= ").append(id_cat_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borra = true;

}catch(Exception e){

}finally{
this.conn.cerrarConexion(); //Cierra la conexion
}

return borra;

}
}

