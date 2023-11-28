package modelo;
public class ContratoDto 
{
    private String codiCont;
    private String fechCont;
    private String fechInicCont ;
    private String fechFincont ;
    private String estCont;
    private String descCont;
    private String codiNego;
    private String codiEmpl;
    private String codiTrab;


    public ContratoDto() {
    }

    public ContratoDto(String codiCont, String fechCont, String fechInicCont, String fechFincont, String estCont, String descCont, String codiNego, String codiEmpl, String codiTrab) {
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
    
    public String getCodiCont() {
        return codiCont;
    }

    public void setCodiCont(String codiCont) {
        this.codiCont = codiCont;
    }

    public String getFechCont() {
        return fechCont;
    }

    public void setFechCont(String fechCont) {
        this.fechCont = fechCont;
    }

    public String getFechInicCont() {
        return fechInicCont;
    }

    public void setFechInicCont(String fechInicCont) {
        this.fechInicCont = fechInicCont;
    }

    public String getFechFincont() {
        return fechFincont;
    }

    public void setFechFincont(String fechFincont) {
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

    @Override
    public String toString() {
        return "ContratoDto{" + "codiCont=" + codiCont + ", fechCont=" + fechCont + ", fechInicCont=" + fechInicCont + ", fechFincont=" + fechFincont + ", estCont=" + estCont + ", descCont=" + descCont + ", codiNego=" + codiNego + ", codiEmpl=" + codiEmpl + ", codiTrab=" + codiTrab + '}';
    }
    
}
