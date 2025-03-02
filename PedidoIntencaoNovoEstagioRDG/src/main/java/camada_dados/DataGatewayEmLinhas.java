package camada_dados;

import entidades.DiscenteDTO;
import entidades.PedidoIntencaoDTO;
import entidades.EmpresaDTO;

import java.util.ArrayList;
import java.util.List;

public class DataGatewayEmLinhas implements IDataGatewayEmLinhas {
    // Dados Mockados
    private final List<DiscenteDTO> discentes = new ArrayList<>();
    private final List<PedidoIntencaoDTO> pedidos = new ArrayList<>();
    private final List<EmpresaDTO> empresas = new ArrayList<>();

    public DataGatewayEmLinhas() {
        // Mock de Discentes
        discentes.add(new DiscenteDTO(1, "Gabriel", "20220001", "8.5", "300"));
        discentes.add(new DiscenteDTO(2, "Merhi", "20220002", "7.9", "280"));

        // Mock de Empresas
        empresas.add(new EmpresaDTO(1, "Tech Solutions", "Rua A, 123", "12345678000100"));
        empresas.add(new EmpresaDTO(2, "SoftDev Corp", "Av. Central, 45", "98765432000100"));
        
        //mock pedido
     // Mock de pedidos de intenção simulados
        pedidos.add(new PedidoIntencaoDTO(
            "1",                            // idDiscente
            "Gabriel",                      // usuário
            85,                             // IRA
            true,                           // IRA dos últimos dois períodos
            300,                            // Carga Horária Cumprida
            "Rua das Flores, 123",          // Endereço de Residência
            "Tech Solutions",               // Nome da Empresa
            "Av. Principal, 456",           // Endereço da Empresa
            "Desenvolvimento Web",          // Modalidade do Estágio
            true,                           // Primeiro Estágio
            20,                             // Carga Horária Semanal
            1500,                           // Valor da Bolsa
            "Desenvolver aplicações web.",  // Resumo das Atividades
            "HTML, CSS, JavaScript",        // Conteúdos Teóricos
            "Quero aprender e crescer na área de tecnologia." // Motivo
        ));

        pedidos.add(new PedidoIntencaoDTO(
            "2",                            // idDiscente
            "Henrique",                     // usuário
            90,                             // IRA
            false,                          // IRA dos últimos dois períodos
            280,                            // Carga Horária Cumprida
            "Av. Central, 789",             // Endereço de Residência
            "SoftDev Corp",                 // Nome da Empresa
            "Rua do Comércio, 654",         // Endereço da Empresa
            "Testes de Software",           // Modalidade do Estágio
            false,                          // Primeiro Estágio
            30,                             // Carga Horária Semanal
            1800,                           // Valor da Bolsa
            "Executar testes e validar software.", // Resumo das Atividades
            "Testes automatizados, QA",     // Conteúdos Teóricos
            "Quero me especializar na área de qualidade de software." // Motivo
        ));

        pedidos.add(new PedidoIntencaoDTO(
            "3",                            // idDiscente
            "Mehri",                        // usuário
            88,                             // IRA
            true,                           // IRA dos últimos dois períodos
            320,                            // Carga Horária Cumprida
            "Praça do Sol, 15",             // Endereço de Residência
            "Innovatech",                   // Nome da Empresa
            "Rua da Inovação, 300",         // Endereço da Empresa
            "Análise de Dados",             // Modalidade do Estágio
            true,                           // Primeiro Estágio
            25,                             // Carga Horária Semanal
            2000,                           // Valor da Bolsa
            "Analisar e criar relatórios de dados empresariais.", // Resumo das Atividades
            "Python, SQL, Power BI",        // Conteúdos Teóricos
            "Quero adquirir experiência em análise de dados." // Motivo
        ));
    }


    public DiscenteDTO buscarDiscentePorId(String NomeDiscente) {
        for (DiscenteDTO discente : discentes) {
            if (discente.getNome() == NomeDiscente) {
                return discente; // Encontrado
            }
        } 
        return null; 
    }

    public EmpresaDTO buscarEmpresaPorId(String Nomeempresa) {
        for (EmpresaDTO empresa : empresas) {
            if (empresa.getNome() == Nomeempresa) {
                return empresa;
            }
        }
        return null; 
    }

    public List<PedidoIntencaoDTO> buscarPedidosPorDiscente(String NomeDiscente) {
        List<PedidoIntencaoDTO> pedidosDoDiscente = new ArrayList<>();
        for (PedidoIntencaoDTO pedido : pedidos) {
            if (pedido.getUsuario().equals(NomeDiscente)) {
                pedidosDoDiscente.add(pedido);
                System.out.println("achou");
                return pedidosDoDiscente;
            }
        }
        return pedidosDoDiscente;
    }
    
    public boolean salvarPedidoIntencao(PedidoIntencaoDTO pedido) {
        // Validar Discente e Empresa no mesmo método
        DiscenteDTO discente = buscarDiscentePorId(pedido.getUsuario());
        EmpresaDTO empresa = buscarEmpresaPorId(pedido.getNomeEmpresa());

        if (discente == null || empresa == null) {
            System.out.println("Erro: Discente ou Empresa não encontrados!");
            return false;
        }

        // Salvar Pedido
        pedidos.add(pedido);
        System.out.println("Pedido de Intenção salvo com sucesso!");
        return true;
    }
}
