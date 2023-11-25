public class Passageiro {
    private String CPF;
    private String nome;
    private String endereco;
    private String telefone;
    private String numeroPassagem;
    private String numeroPoltrona;
    private String numeroVoo;
    private String horario;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public String getNumeroPoltrona() {
        return numeroPoltrona;
    }

    public void setNumeroPoltrona(String numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Passageiro(String CPF, String nome, String endereco, String telefone, String numeroPassagem, 
                      String numeroPoltrona, String numeroVoo, String horario) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numeroPassagem = numeroPassagem;
        this.numeroPoltrona = numeroPoltrona;
        this.numeroVoo = numeroVoo;
        this.horario = horario;
    }

    
}
