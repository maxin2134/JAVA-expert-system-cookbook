package aplikacja_se;

public class Skladnik {
    private int id;
    private String nazwa;
    private String sciezka;
    
    Skladnik(int id,String nazwa, String sciezka){
        this.id = id;
        this.nazwa = nazwa;
        this.sciezka = sciezka;
    }

    public int getId() {
        return id;
    }

    public String getSciezka() {
        return sciezka;
    }

    public String getNazwa() {
        return nazwa;
    }
}
