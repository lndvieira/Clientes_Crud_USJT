

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class CrudClientesServlet
 */
@WebServlet("/ClientesCrud")
public class ClientesCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesCrud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idCliente"));
		String nome = request.getParameter("nomeCliente");
		String email = request.getParameter("emailCliente");
		String fone = request.getParameter("foneCliente");
		String oQueFazer = request.getParameter("oQueFazer");
		Cliente cliente = new Cliente(id,nome, fone, email);
		ClienteService Service = new ClienteService();
		switch(oQueFazer){
		case "Cadastrar": 
			Service.criar(cliente);
			String cod = "<!DOCTYPEhtml><html><head><meta charset="+"UTF-8"+"><title>ID Cliente</title></head><body> <h1>ID do cliente:" +id+"</h1><BR><BR><a href="+"clientes.html"+">voltar</a></body></html>";
			
			PrintWriter out =response.getWriter();
			out.println(cod);
			break;
		case "Consultar":
			Cliente cli = Service.carregar(id);
			
			String cod1 = "<!DOCTYPEhtml><html><head><meta charset="+"UTF-8"+"><title>ID Cliente consultado</title></head><body> <h1>ID do cliente:" +id+
					"<br>nome do cliente:" +cli.getNome()+"<br>Tel do cliente:" +cli.getFone()+"<br>Email do cliente:" +cli.getEmail()+"</h1><BR><BR><a href="+"clientes.html"+">voltar</a></body></html>";
			PrintWriter out1 =response.getWriter();
			out1.println(cod1);
			
			break;
		case "Remover":
			Service.excluir(id);
			String cod2 = "<!DOCTYPEhtml><html><head><meta charset="+"UTF-8"+"><title>ID Cliente</title></head><body> <h1>ID do cliente removido:" +id+"</h1><BR><BR><a href="+"clientes.html"+">voltar</a></body></html>";
			PrintWriter out2 =response.getWriter();
			out2.println(cod2);
			
			break;
		case "Atualizar":
			Service.atualizar(cliente);
			String cod3 = "<!DOCTYPEhtml><html><head><meta charset="+"UTF-8"+"><title>ID Cliente atualizado</title></head><body> <h1>ID do cliente:" +id+
					"<br>nome do cliente:" +nome+"<br>Tel do cliente:" +fone+"<br>Email do cliente:" +email+"</h1><BR><BR><a href="+"clientes.html"+">voltar</a></body></html>";
			PrintWriter out3=response.getWriter();
			out3.println(cod3);
			break;
		}
		
		}
	}


