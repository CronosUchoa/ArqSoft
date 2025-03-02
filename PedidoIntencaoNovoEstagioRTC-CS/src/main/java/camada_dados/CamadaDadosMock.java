package camada_dados;

import entidades.DiscenteDTO;
import entidades.PedidoIntencaoDTO;
import entidades.EmpresaDTO;

import java.util.ArrayList;
import java.util.List;

public class CamadaDadosMock implements ICamadaDadosMock {
    private final List<DiscenteDTO> discentes;
    private final List<PedidoIntencaoDTO> pedidos;
    private final List<EmpresaDTO> empresas;

    public CamadaDadosMock() {
        discentes = new ArrayList<>();
        pedidos = new ArrayList<>();
        empresas = new ArrayList<>();

        // Mock de dados para Discentes
        discentes.add(new DiscenteDTO(1, "Gabriel", "20220001", "8.5", "300"));
        discentes.add(new DiscenteDTO(2, "Merhi", "20220002", "7.9", "280"));

        // Mock de dados para Empresas
        empresas.add(new EmpresaDTO(1, "Tech Solutions", "Rua A, 123", "12345678000100"));
        empresas.add(new EmpresaDTO(2, "SoftDev Corp", "Av. Central, 45", "98765432000100"));
        
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
            "Merhi",                        // usuário
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

    @Override
    public DiscenteDTO buscarDiscentePorId(String idDiscente) {
        return discentes.stream()
                .filter(d -> d.getNome() == idDiscente)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PedidoIntencaoDTO> buscarPedidosPorDiscente(String nomeDiscente) {
        List<PedidoIntencaoDTO> pedidosDoDiscente = new ArrayList<>();
        for (PedidoIntencaoDTO pedido : pedidos) {
            if (pedido.getUsuario().equals(nomeDiscente)) {
                pedidosDoDiscente.add(pedido);
            }
        }
        return pedidosDoDiscente;
    }

    @Override
    public EmpresaDTO buscarEmpresaPorId(int idEmpresa) {
        return empresas.stream()
                .filter(e -> e.getId() == idEmpresa)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void salvarPedidoIntencao(PedidoIntencaoDTO pedido) {
        System.out.println("Salvando pedido:");
        System.out.println("Usuário: " + pedido.getUsuario());
        System.out.println("Outros detalhes do pedido...");
        
        pedidos.add(pedido);
        
        System.out.println("Tamanho do array de pedidos após salvar: " + pedidos.size());
        
        for (PedidoIntencaoDTO p : pedidos) {
            System.out.println("Pedido salvo - Usuário: " + p.getUsuario());
        }
    }
}
