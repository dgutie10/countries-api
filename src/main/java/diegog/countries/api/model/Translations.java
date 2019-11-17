package diegog.countries.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Translations {
    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String br;
    private String pt;
    private String nl;
    private String hr;

    public String getBr() {
        return br;
    }

    public String getDe() {
        return de;
    }

    public String getEs() {
        return es;
    }

    public String getFr() {
        return fr;
    }

    public String getIt() {
        return it;
    }

    public String getJa() {
        return ja;
    }

    public String getPt() {
        return pt;
    }

    public String getNl() {
        return nl;
    }

    public String getHr() {
        return hr;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }
}
