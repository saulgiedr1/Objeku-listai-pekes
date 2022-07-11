public class Preke {

    private int id;
    private String pavadinimas;
    private String aprasymas;
    private double kaina;
    private int kiekis;
    private String kategorija;
    private String medziaga;

    //konstruktoriai;
    public Preke() {
    }

    public Preke(int id, String pavadinimas, String aprasymas, double kaina, int kiekis, String kategorija, String medziaga) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.aprasymas = aprasymas;
        this.kaina = kaina;
        this.kiekis = kiekis;
        this.kategorija = kategorija;
        this.medziaga = medziaga;
    }
    //metodai;
    public boolean arYraSandelyje(){
        return kiekis > 0;
    }

    public void pritaikytiNuolaida(int pr){

             kaina = kaina - (kaina*pr/100);
        }






    //geteriai seteriai;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getMedziaga() {
        return medziaga;
    }

    public void setMedziaga(String medziaga) {
        this.medziaga = medziaga;
    }

    //string;

    @Override
    public String toString() {
        return "Preke{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", aprasymas='" + aprasymas + '\'' +
                ", kaina=" + kaina +
                ", kiekis=" + kiekis +
                ", kategorija='" + kategorija + '\'' +
                ", medziaga='" + medziaga + '\'' +
                '}';
    }
}
