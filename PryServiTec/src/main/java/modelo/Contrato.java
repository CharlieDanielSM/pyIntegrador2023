
package modelo;

import java.sql.Date;

/* 🚀 Developed by NelsonJGP */
public class Contrato {
    private String codiCont;
    private Date fechCont;
    private Date fechInicCont;
    private Date fechFinCont;
    private String estaCont;
    private String descCont;
    private String fk_codiNego;
    private String fk_codiTrab;
    private String fk_codiEmpl;

    public Contrato() {
    }

    public Contrato(String codiCont, Date fechCont, Date fechInicCont, Date fechFinCont, String estaCont, String descCont, String fk_codiNego, String fk_codiTrab, String fk_codiEmpl) {
        this.codiCont = codiCont;
        this.fechCont = fechCont;
        this.fechInicCont = fechInicCont;
        this.fechFinCont = fechFinCont;
        this.estaCont = estaCont;
        this.descCont = descCont;
        this.fk_codiNego = fk_codiNego;
        this.fk_codiTrab = fk_codiTrab;
        this.fk_codiEmpl = fk_codiEmpl;
    }

    public String getCodiCont() {
        return codiCont;
    }

    public void setCodiCont(String codiCont) {
        this.codiCont = codiCont;
    }

    public Date getFechCont() {
        return fechCont;
    }

    public void setFechCont(Date fechCont) {
        this.fechCont = fechCont;
    }

    public Date getFechInicCont() {
        return fechInicCont;
    }

    public void setFechInicCont(Date fechInicCont) {
        this.fechInicCont = fechInicCont;
    }

    public Date getFechFinCont() {
        return fechFinCont;
    }

    public void setFechFinCont(Date fechFinCont) {
        this.fechFinCont = fechFinCont;
    }

    public String getEstaCont() {
        return estaCont;
    }

    public void setEstaCont(String estaCont) {
        this.estaCont = estaCont;
    }

    public String getDescCont() {
        return descCont;
    }

    public void setDescCont(String descCont) {
        this.descCont = descCont;
    }

    public String getFk_codiNego() {
        return fk_codiNego;
    }

    public void setFk_codiNego(String fk_codiNego) {
        this.fk_codiNego = fk_codiNego;
    }

    public String getFk_codiTrab() {
        return fk_codiTrab;
    }

    public void setFk_codiTrab(String fk_codiTrab) {
        this.fk_codiTrab = fk_codiTrab;
    }

    public String getFk_codiEmpl() {
        return fk_codiEmpl;
    }

    public void setFk_codiEmpl(String fk_codiEmpl) {
        this.fk_codiEmpl = fk_codiEmpl;
    }
    
    
}
