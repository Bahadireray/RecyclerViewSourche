package com.bahadireray.recyclerviewsourche.Model;

public class Ulke {
    private String ulkeAdi;
    private String ulkeResimUrl;
    private String telefonKodu;
    private String ulkeBaskent;
    private int kurulusYili;

    public Ulke() {
    }

    public Ulke(String ulkeAdi, String ulkeResimUrl, String telefonKodu, String ulkeBaskent, int kurulusYili) {
        this.ulkeAdi = ulkeAdi;
        this.ulkeResimUrl = ulkeResimUrl;
        this.telefonKodu = telefonKodu;
        this.ulkeBaskent = ulkeBaskent;
        this.kurulusYili = kurulusYili;
    }

    public String getUlkeAdi() {
        return ulkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        this.ulkeAdi = ulkeAdi;
    }

    public String getUlkeResimUrl() {
        return ulkeResimUrl;
    }

    public void setUlkeResimUrl(String ulkeResimUrl) {
        this.ulkeResimUrl = ulkeResimUrl;
    }

    public String getTelefonKodu() {
        return telefonKodu;
    }

    public void setTelefonKodu(String telefonKodu) {
        this.telefonKodu = telefonKodu;
    }

    public String getUlkeBaskent() {
        return ulkeBaskent;
    }

    public void setUlkeBaskent(String ulkeBaskent) {
        this.ulkeBaskent = ulkeBaskent;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }

    public void setKurulusYili(int kurulusYili) {
        this.kurulusYili = kurulusYili;
    }
}