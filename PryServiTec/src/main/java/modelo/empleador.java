
package modelo;

/* 🚀 Developed by NelsonJGP */
public class empleador {
    private String codiEmpl;
    private String dniRucEmpl;
    private String nombEmpl;
    private String teleEmpl;
    private String emailEmpl;
    private String fk_codiTipoEmpl;
    private String fk_codiUsua;

    public empleador() {
    }
<<<<<<< HEAD

=======
    
>>>>>>> d62164e773c5138abe67332c17a0d2807512ca32
    public empleador(String codiEmpl, String dniRucEmpl, String nombEmpl, String teleEmpl, String emailEmpl, String fk_codiTipoEmpl, String fk_codiUsua) {
        this.codiEmpl = codiEmpl;
        this.dniRucEmpl = dniRucEmpl;
        this.nombEmpl = nombEmpl;
        this.teleEmpl = teleEmpl;
        this.emailEmpl = emailEmpl;
        this.fk_codiTipoEmpl = fk_codiTipoEmpl;
        this.fk_codiUsua = fk_codiUsua;
    }

    public String getCodiEmpl() {
        return codiEmpl;
    }

    public void setCodiEmpl(String codiEmpl) {
        this.codiEmpl = codiEmpl;
    }

    public String getDniRucEmpl() {
        return dniRucEmpl;
    }

    public void setDniRucEmpl(String dniRucEmpl) {
        this.dniRucEmpl = dniRucEmpl;
    }

    public String getNombEmpl() {
        return nombEmpl;
    }

    public void setNombEmpl(String nombEmpl) {
        this.nombEmpl = nombEmpl;
    }

    public String getTeleEmpl() {
        return teleEmpl;
    }

    public void setTeleEmpl(String teleEmpl) {
        this.teleEmpl = teleEmpl;
    }

    public String getEmailEmpl() {
        return emailEmpl;
    }

    public void setEmailEmpl(String emailEmpl) {
        this.emailEmpl = emailEmpl;
    }

    public String getFk_codiTipoEmpl() {
        return fk_codiTipoEmpl;
    }

    public void setFk_codiTipoEmpl(String fk_codiTipoEmpl) {
        this.fk_codiTipoEmpl = fk_codiTipoEmpl;
    }

    public String getFk_codiUsua() {
        return fk_codiUsua;
    }

    public void setFk_codiUsua(String fk_codiUsua) {
        this.fk_codiUsua = fk_codiUsua;
    }
}
