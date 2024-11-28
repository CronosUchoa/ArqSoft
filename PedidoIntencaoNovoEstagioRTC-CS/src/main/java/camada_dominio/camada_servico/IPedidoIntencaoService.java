package camada_dominio.camada_servico;

import java.util.List;

import entidades.PedidoIntencaoDTO;

public interface  IPedidoIntencaoService {
	boolean criarPedidoIntencao(PedidoIntencaoDTO pedidoIntencao);
	
	List<String> ValidarPedidoIntencao(PedidoIntencaoDTO pedidoIntencao);

    PedidoIntencaoDTO buscarPedidoIntencaoPorId(int idPedido);

    List<PedidoIntencaoDTO> buscarPedidosPorDiscente(int idDiscente);

    void excluirPedidoIntencao(int idPedido);

    void atualizarPedidoIntencao(PedidoIntencaoDTO pedidoIntencao);
}