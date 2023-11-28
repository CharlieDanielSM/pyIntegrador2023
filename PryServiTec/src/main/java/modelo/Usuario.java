
package modelo;

/* 🚀 Developed by NelsonJGP */
public class Usuario {
    private String codiUsua;
    private String passUsua;
    private String tipoUsua;

    public Usuario() {
    }

    public Usuario(String codiUsua, String passUsua, String tipoUsua) {
        this.codiUsua = codiUsua;
        this.passUsua = passUsua;
        this.tipoUsua = tipoUsua;
    }

    public String getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(String codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getPassUsua() {
        return passUsua;
    }

    public void setPassUsua(String passUsua) {
        this.passUsua = passUsua;
    }

    public String getTipoUsua() {
        return tipoUsua;
    }

    public void setTipoUsua(String tipoUsua) {
        this.tipoUsua = tipoUsua;
    }
    
    
}
