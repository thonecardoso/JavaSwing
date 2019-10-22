package model;



public class Endereco {
    
    private String logradouro, complemento, bairro, municipio, estado, tipo;
    private Integer numero , id, idend;
	

    public Endereco(String logradouro, String complemento, String bairro, String municipio, String estado,
                    Integer numero, Integer id) {
            super();
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.bairro = bairro;
            this.municipio = municipio;
            this.estado = estado;
            this.numero = numero;
            this.id = id;
            
    }

    public Endereco(String logradouro, String complemento, String bairro, String municipio, String estado, String tipo, Integer numero, Integer id) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.tipo = tipo;
        this.numero = numero;
        this.id = id;
    }
    
    
	

    public Endereco() {

    }


    public String getLogradouro() {
            return logradouro;
    }
    public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
    }
    public String getComplemento() {
            return complemento;
    }
    public void setComplemento(String complemento) {
            this.complemento = complemento;
    }
    public String getBairro() {
            return bairro;
    }
    public void setBairro(String bairro) {
            this.bairro = bairro;
    }
    public String getMunicipio() {
            return municipio;
    }
    public void setMunicipio(String municipio) {
            this.municipio = municipio;
    }
    public String getEstado() {
            return estado;
    }
    public void setEstado(String estado) {
            this.estado = estado;
    }
    public Integer getNumero() {
            return numero;
    }
    public void setNumero(Integer numero) {
            this.numero = numero;
    }
    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdend() {
        return idend;
    }

    public void setIdend(Integer idend) {
        this.idend = idend;
    }
    
    
    
    
    
    
}
