package modelo;

import java.sql.Date;

public class ContratoDto 
{
    private String codiCont;
    private Date fechCont;
    private Date fechInicCont;
    private Date fechFincont;
    private String estCont;
    private String descCont;
    private String codiNego;
    private String codiEmpl;
    private String codiTrab;

    public ContratoDto() {
    }

    public ContratoDto(String codiCont, Date fechCont, Date fechInicCont, Date fechFincont, String estCont, String descCont, String codiNego, String codiEmpl, String codiTrab) {
        this.codiCont = codiCont;
        this.fechCont = fechCont;
        this.fechInicCont = fechInicCont;
        this.fechFincont = fechFincont;
        this.estCont = estCont;
        this.descCont = descCont;
        this.codiNego = codiNego;
        this.codiEmpl = codiEmpl;
        this.codiTrab = codiTrab;
    }
    
    @Override
    public String toString() {
        return "ContratoDto{" + "codiCont=" + codiCont + ", fechCont=" + fechCont + ", fechInicCont=" + fechInicCont + ", fechFincont=" + fechFincont + ", estCont=" + estCont + ", descCont=" + descCont + ", codiNego=" + codiNego + ", codiEmpl=" + codiEmpl + ", codiTrab=" + codiTrab + '}';
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

    public Date getFechFincont() {
        return fechFincont;
    }

    public void setFechFincont(Date fechFincont) {
        this.fechFincont = fechFincont;
    }

    public String getEstCont() {
        return estCont;
    }

    public void setEstCont(String estCont) {
        this.estCont = estCont;
    }

    public String getDescCont() {
        return descCont;
    }

    public void setDescCont(String descCont) {
        this.descCont = descCont;
    }

    public String getCodiNego() {
        return codiNego;
    }

    public void setCodiNego(String codiNego) {
        this.codiNego = codiNego;
    }

    public String getCodiEmpl() {
        return codiEmpl;
    }

    public void setCodiEmpl(String codiEmpl) {
        this.codiEmpl = codiEmpl;
    }

    public String getCodiTrab() {
        return codiTrab;
    }

    public void setCodiTrab(String codiTrab) {
        this.codiTrab = codiTrab;
    }

    
}
