package entidades;

public class PedidoIntencaoDTO {
	
    private String idDiscente;
    private String usuario;
    private int ira;
    private boolean iraUlt;
    private int cargaHorariaCumprida;
    private String enderecoResidencia;
    private String nomeEmpresa;
    private String enderecoEmpresa;
    private String modalidadeEstagio;
    private boolean primeiroEstagio;
    private int cargaHorariaSemanal;
    private int valorBolsa;
    private String resumoAtividades;
    private String conteudosTeoricos;
    private String motivo;
    
    public PedidoIntencaoDTO(String idDiscente,String usuario, int ira, boolean iraUlt, int cargaHorariaCumprida, String enderecoResidencia, String nomeEmpresa,
			String enderecoEmpresa, String modalidadeEstagio, boolean primeiroEstagio, int cargaHorariaSemanal, int valorBolsa, String resumoAtividades,
			String conteudosTeoricos, String motivo) {
		this.setUsuario(usuario);
		this.setIra(ira);
		this.setIraUlt(iraUlt);
		this.setCargaHorariaCumprida(cargaHorariaCumprida);
		this.setEnderecoResidencia(enderecoResidencia);
		this.setNomeEmpresa(nomeEmpresa);
		this.setEnderecoEmpresa(enderecoEmpresa);
		this.setModalidadeEstagio(modalidadeEstagio);
		this.setPrimeiroEstagio(primeiroEstagio);
		this.setCargaHorariaSemanal(cargaHorariaSemanal);
		this.setValorBolsa(valorBolsa);
		this.setResumoAtividades(resumoAtividades);
		this.setConteudosTeoricos(conteudosTeoricos);
		this.setMotivo(motivo);
		this.setIdDiscente(idDiscente);
		
	}



    public String getIdDiscente() {
        return idDiscente;
    }

    public void setIdDiscente(String idDiscente) {
        this.idDiscente = idDiscente;
    }



	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIra() {
		return ira;
	}

	public void setIra(int ira) {
		this.ira = ira;
	}

	public boolean getIraUlt() {
		return iraUlt;
	}

	public void setIraUlt(boolean iraUlt) {
		this.iraUlt = iraUlt;
	}
	
	public int getCargaHorariaCumprida() {
		return cargaHorariaCumprida;
	}

	public void setCargaHorariaCumprida(int cargaHorariaCumprida) {
		this.cargaHorariaCumprida = cargaHorariaCumprida;
	}

	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}

	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public String getModalidadeEstagio() {
		return modalidadeEstagio;
	}

	public void setModalidadeEstagio(String modalidadeEstagio) {
		this.modalidadeEstagio = modalidadeEstagio;
	}

	public boolean getPrimeiroEstagio() {
		return primeiroEstagio;
	}

	public void setPrimeiroEstagio(boolean primeiroEstagio) {
		this.primeiroEstagio = primeiroEstagio;
	}
	
	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public int getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(int valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public String getResumoAtividades() {
		return resumoAtividades;
	}

	public void setResumoAtividades(String resumoAtividades) {
		this.resumoAtividades = resumoAtividades;
	}

	public String getConteudosTeoricos() {
		return conteudosTeoricos;
	}

	public void setConteudosTeoricos(String conteudosTeoricos) {
		this.conteudosTeoricos = conteudosTeoricos;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
