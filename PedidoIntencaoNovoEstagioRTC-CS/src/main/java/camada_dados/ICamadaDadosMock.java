package camada_dados;

import entidades.DiscenteDTO;
import entidades.PedidoIntencaoDTO;
import entidades.EmpresaDTO;

//import java.util.ArrayList;
import java.util.List;

public interface ICamadaDadosMock {
	
	DiscenteDTO buscarDiscentePorId(String idDiscente);
	List<PedidoIntencaoDTO>  buscarPedidosPorDiscente(String nomeDiscente);
    EmpresaDTO buscarEmpresaPorId(int idEmpresa);
    void salvarPedidoIntencao(PedidoIntencaoDTO pedido);	
	
}