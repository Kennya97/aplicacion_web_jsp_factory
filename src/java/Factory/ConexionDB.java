
package Factory;

import java.sql.*;

import java.sql.ResultSet;

public abstract class ConexionDB{
    
protected String [] parametros; //Array que recibe los parametros de la conexion 
protected Connection conexion;

//EL SIGUIENTE METODO ABSTRACTO NO SE IMPLEMENTA SOLO SE DECLARA
//IMPLEMENTARA EN LA SUBCLASE

abstract Connection open(); //Metodo abstracto que devuelve un objeto conecction


public ResultSet consultaSQL(String consulta){
Statement st; //OBJETO STATEMENT EN EL ENCARGADO DE EJECUTAR LAS CONSULTAS 
ResultSet rs= null; //TABLA TEMPORAL DONDE SE ALMACENAN LOS DATOS 

try{
st= conexion.createStatement();
rs= st.executeQuery(consulta); //Se ejecuta la consulta

    
}catch(SQLException ex){
    
ex.printStackTrace();

}
return rs;
}

//METODO PARA CERRAR LA CONEXION
public boolean cerrarConexion(){
boolean ok = true;
try{
conexion.close();

    
}catch(Exception ex){
    
ok= false;

ex.printStackTrace();

}
return ok;
}
}
