package es.ua.jtech.spring.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//cometnario hola 2
//comentario 2

@WebServlet("/listarPedidos")
public class ListarPedidos extends HttpServlet {
/// hola que takl
    private static final long serialVersionUID = 780361686776789966L;
 //pruena marge
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        IPedidosDAO pdao = wac.getBean(IPedidosDAO.class);


        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head><title>Listado de pedidos</title></head>");
        pw.println("<body>");
        pw.println("<table><tr><th>Cliente</th><th>Producto</th><th>Unidades</th></tr>");
        for (Pedido p : pdao.listarPedidos()) {
            pw.println("<tr>");
            pw.println("<td>"+p.getIdCliente()+"</td>");
            pw.println("<td>"+p.getIdProducto()+"</td>");
            pw.println("<td>"+p.getUnidades()+"</td>");
            pw.println("</tr>");
        }

        pw.println("</table> </body> </html>");
        pw.close();
    }




}
