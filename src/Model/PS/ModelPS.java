package Model.PS;

public class ModelPS {
    private Integer id;
    private String nama, paket;
    private int harga, lamasewa, hargatotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getLamasewa() {
        return lamasewa;
    }

    public void setLamasewa(int lamasewa) {
        this.lamasewa = lamasewa;
    }

    public int getHargatotal() {
        return hargatotal;
    }

    public void setHargatotal(int hargatotal) {
        this.hargatotal = hargatotal;
    }
    
}
