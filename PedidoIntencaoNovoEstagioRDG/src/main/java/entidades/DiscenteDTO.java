package entidades;

public class DiscenteDTO {
    private int id;
    private String nome;
    private String matricula;
    private String media;
    private String cargaHoraria;


    public DiscenteDTO(int id, String nome, String matricula, String media, String cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.media = media;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
