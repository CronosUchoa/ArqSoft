package camada_dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import camada_dados.DataGatewayEmLinhas;
import camada_dados.IDataGatewayEmLinhas;
import entidades.PedidoIntencaoDTO;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/Controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IDataGatewayEmLinhas camadaDadosMock;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
		super();
		this.camadaDadosMock = new DataGatewayEmLinhas();
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
		  PedidoIntencaoDTO pedido = new PedidoIntencaoDTO(
	    		    request.getParameter("identificador"),
	    		    request.getParameter("usuario"),
	    		    Integer.parseInt(request.getParameter("ira")),
	    		    Boolean.parseBoolean(request.getParameter("iraUlt")) ,
	    		    Integer.parseInt(request.getParameter("cargaHorariaCumprida")),
	                request.getParameter("enderecoResidencia"),
	                request.getParameter("nomeEmpresa"),
	                request.getParameter("enderecoEmpresa"),
	                request.getParameter("modalidadeEstagio"),
	                Boolean.parseBoolean(request.getParameter("primeiroEstagio")),
	                Integer.parseInt(request.getParameter("cargaHorariaSemanal")),
	                Integer.parseInt(request.getParameter("valorBolsa")),
	                request.getParameter("resumoAtividades"),
	                request.getParameter("conteudosTeoricos"),
	                request.getParameter("motivo")
	        );

	       
	        List<String> erros = ValidarPedidoIntencao(pedido);
	        if(erros.isEmpty()) {
	        	criarPedidoIntencao(pedido);
	        	request.setAttribute("mensagem", "Seu pedido foi enviado com sucesso!");
	        	request.setAttribute("tipoMensagem", "success"); 
	        }else{
	            request.setAttribute("mensagem", String.join("<br>", erros));
	            request.setAttribute("tipoMensagem", "error");
	        };
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/JSPS/index.jsp");
			dispatcher.forward(request, response);
	    }

	public boolean criarPedidoIntencao(PedidoIntencaoDTO pedido) {
	
			camadaDadosMock.salvarPedidoIntencao(pedido);
		    System.out.println("Pedido de intenção salvo com sucesso!");
		    return true;
	     
	  }
	  
	 public boolean verificarPedidoEmAndamento(String usuario) {
		    List<PedidoIntencaoDTO> pedidosExistentes = camadaDadosMock.buscarPedidosPorDiscente(usuario);
		    return !pedidosExistentes.isEmpty();
		}
		
	 public List<String> ValidarPedidoIntencao(PedidoIntencaoDTO pedido) {
		    List<String> erros = new ArrayList<>();
		    
		    if (verificarPedidoEmAndamento(pedido.getUsuario())) {
		        erros.add("Já existe um pedido em andamento para este usuário.");
		    }
		    
		    if (pedido.getCargaHorariaCumprida() < 80) {
		        erros.add("Você não cumpriu o mínimo de 80 créditos obrigatórios.");
		    }
		    
		    if ((pedido.getIra() < 6 && !pedido.getIraUlt()) || (pedido.getIra() < 7 && pedido.getIraUlt())) {
		        erros.add("O Índice de Rendimento Acadêmico (IRA) é insuficiente.");
		    }
		    
		    if (pedido.getCargaHorariaSemanal() > 30) {
		        erros.add("A carga horária semanal máxima é de 30 horas.");
		    }
		    
		    return erros;
		}
	    

}
