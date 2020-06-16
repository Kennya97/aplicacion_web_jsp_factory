
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Categorias extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
     
String parametro = request.getParameter("opcion"); //Captura  el parametro que se esta enviando

if(parametro.equals("crear")){ //EVALUAR SI EL PARAMETRO ES CREAR O LISTAR O CUALQUIER  OTRO
String pagina= "/Vistas-Categorias/crearCategoria.jsp";    //VISTA O FORMULARIO PARA REGISTRAR NUEVA CATEGORIA

RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
dispatcher.forward(request, response);
}else{
     
this.listaCategorias(request, response);
}
}

 

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
Categoria categoria = new Categoria();

//SE EFECTUA EL CASTING O CONVERSION  DE DATOS PORQUE LO INGRESADO EN EL FORMULARIO ES TEXTO

categoria.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
categoria.setNom_categoria(request.getParameter("txtNomCategoria"));
categoria.setEstado_categoria(Integer.parseInt(request.getParameter("txtEstadoCategoria")));


CategoriaDAO guardaCategoria = new CategoriaDAOImplementar();

guardaCategoria.guardarCat(categoria);
this.listaCategorias(request, response);

}
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
protected void  listaCategorias(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    
response.setContentType("text/html; charset=UTF-8");
//CREAR LA INSTANCIA A CATEGORIA DAO

CategoriaDAO categoria = new CategoriaDAOImplementar();

//CREAR INSTANCIA DE SESION  SE LE DA TRUE PARA CREAR LA SECCION

HttpSession sesion = request.getSession(true);
sesion.setAttribute("lista", categoria.Listar());  //Lista es el nombre de la sesion
RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategoria.jsp");


dispatcher.forward(request, response);

}
}


    

