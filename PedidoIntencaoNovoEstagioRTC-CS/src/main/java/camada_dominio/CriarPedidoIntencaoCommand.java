package camada_dominio;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camada_dados.CamadaDadosMock;
import camada_dados.ICamadaDadosMock;
import camada_dominio.camada_servico.IPedidoIntencaoService;
import camada_dominio.camada_servico.PedidoIntencaoService;
import entidades.PedidoIntencaoDTO;

public class CriarPedidoIntencaoCommand implements ICriarPedidoIntencaoCommand {

    private final IPedidoIntencaoService pedidoService;
    private final ICamadaDadosMock camadaDadosMock;

    public CriarPedidoIntencaoCommand() {
    	this.camadaDadosMock = new CamadaDadosMock(); 
    	this.pedidoService = new PedidoIntencaoService(camadaDadosMock);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
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

       
        List<String> erros = pedidoService.ValidarPedidoIntencao(pedido);
        if(erros.isEmpty()) {
        	pedidoService.criarPedidoIntencao(pedido);
        	request.setAttribute("mensagem", "Seu pedido foi enviado com sucesso!");
        	request.setAttribute("tipoMensagem", "success"); 
        }else{
            request.setAttribute("mensagem", String.join("<br>", erros));
            request.setAttribute("tipoMensagem", "error");
        };
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/JSPS/index.jsp");
		dispatcher.forward(request, response);
    }
    
}
