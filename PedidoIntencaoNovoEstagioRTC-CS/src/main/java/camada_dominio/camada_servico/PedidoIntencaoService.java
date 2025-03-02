package camada_dominio.camada_servico;
import java.util.ArrayList;
import java.util.List;
import camada_dados.ICamadaDadosMock;
import entidades.PedidoIntencaoDTO;


public class PedidoIntencaoService implements IPedidoIntencaoService{
    private final ICamadaDadosMock dados;

    public PedidoIntencaoService(ICamadaDadosMock dados) {
        this.dados = dados;
    }

    public boolean criarPedidoIntencao(PedidoIntencaoDTO pedido) {

		dados.salvarPedidoIntencao(pedido);
	    System.out.println("Pedido de intenção salvo com sucesso!");
	    return true;
       
    }
    
   public boolean verificarPedidoEmAndamento(String usuario) {
	    List<PedidoIntencaoDTO> pedidosExistentes = dados.buscarPedidosPorDiscente(usuario);
	    return !pedidosExistentes.isEmpty();
	}
	
   public List<String> ValidarPedidoIntencao(PedidoIntencaoDTO pedido) {
	    List<String> erros = new ArrayList<>();
	    
	    if (verificarPedidoEmAndamento(pedido.getUsuario())) {
	        erros.add("Já existe um pedido em andamento para este usuário.");
	    }
	    
	    //RN1
	    if (pedido.getCargaHorariaCumprida() < 80) {
	        erros.add("Você não cumpriu o mínimo de 80 créditos obrigatórios.");
	    }
	    
	    //RN2
	    if ((pedido.getIra() < 6 && !pedido.getIraUlt()) || (pedido.getIra() < 7 && pedido.getIraUlt())) {
	        erros.add("O Índice de Rendimento Acadêmico (IRA) é insuficiente.");
	    }
	    
	    //RN3
	    if (pedido.getCargaHorariaSemanal() > 30) {
	        erros.add("A carga horária semanal máxima é de 30 horas.");
	    }
	    
	    return erros;
	}
	    
	@Override
	public PedidoIntencaoDTO buscarPedidoIntencaoPorId(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoIntencaoDTO> buscarPedidosPorDiscente(int idDiscente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirPedidoIntencao(int idPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarPedidoIntencao(PedidoIntencaoDTO pedidoIntencao) {
		// TODO Auto-generated method stub
		
	}

}
