package be.ehb.thisappisintents.model;

import java.io.Serializable;

/**
 * Created by ontlener on 11/02/2019. ;)
 */
public class Persoon implements Serializable {

    private String naam, tel, homepage;

    public Persoon() {
    }

    public Persoon(String naam, String tel, String homepage) {
        this.naam = naam;
        this.tel = tel;
        this.homepage = homepage;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return naam;
    }
}
