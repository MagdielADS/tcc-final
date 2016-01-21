/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Desenvolvedor01
 */
public class Arquivo{
    public static final String BUSCA_TODOS_OS_ARQUIVOS = "busca.todos.os.arquivos";

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private String caminho;
    private String colunaDeBusca;
    private char caractereDetabulacao;
    private String extensao;
    private StatusDoArquivo status;
    private String latitude;
    private String longitude;
    private String referenciaDeLugar;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getReferenciaDeLugar() {
        return referenciaDeLugar;
    }

    public void setReferenciaDeLugar(String referenciaDeLugar) {
        this.referenciaDeLugar = referenciaDeLugar;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getColunaDeBusca() {
        return colunaDeBusca;
    }

    public void setColunaDeBusca(String colunaDeBusca) {
        this.colunaDeBusca = colunaDeBusca;
    }

    public char getCaractereDetabulacao() {
        return caractereDetabulacao;
    }

    public void setCaractereDetabulacao(char caractereDetabulacao) {
        this.caractereDetabulacao = caractereDetabulacao;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public StatusDoArquivo getStatus() {
        return status;
    }

    public void setStatus(StatusDoArquivo status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivo)) {
            return false;
        }
        Arquivo other = (Arquivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Arquivo[ id=" + id + " ]";
    }
    
}
