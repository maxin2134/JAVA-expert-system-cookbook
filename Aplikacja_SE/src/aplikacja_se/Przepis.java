package aplikacja_se;

public class Przepis{
    
    private String nazwa_przepisu = null;
    private String opis_przepisu = null;
    
    private String[] tabNazwySkaldnikow = new String[9];
    
    private int id_przepisu = 0;

    private int suma = 0;
    
    Przepis(int id_przepisu, String nazwa_przepisu, String skladnik1, String skladnik2, String skladnik3,
            String skladnik4, String skladnik5, String skladnik6, String skladnik7, 
            String skladnik8, String skladnik9, String opis_przepisu, int suma)
    {
        this.id_przepisu = id_przepisu;
        this.nazwa_przepisu = nazwa_przepisu;
        wstawSkladniki(skladnik1, skladnik2, skladnik3, skladnik4, skladnik5, skladnik6, skladnik7, skladnik8, skladnik9);
        this.opis_przepisu = opis_przepisu;
        this.suma = suma;
    }
    
    void wstawSkladniki(String sk1, String sk2, String sk3, String sk4, String sk5, String sk6, String sk7, String sk8, String sk9){
        tabNazwySkaldnikow[0] = sk1;
        tabNazwySkaldnikow[1] = sk2;
        tabNazwySkaldnikow[2] = sk3;
        tabNazwySkaldnikow[3] = sk4;
        tabNazwySkaldnikow[4] = sk5;
        tabNazwySkaldnikow[5] = sk6;
        tabNazwySkaldnikow[6] = sk7;
        tabNazwySkaldnikow[7] = sk8;
        tabNazwySkaldnikow[8] = sk9;
    }
    
    int get_id_przepisu(){
        return id_przepisu;
    }
    
    String get_nazwa_przepisu(){
        return nazwa_przepisu;
    }
   
    public String[] getTabNazwySkaldnikow() {
        return tabNazwySkaldnikow;
    }
    
    String get_opis_przepisu(){
        return opis_przepisu;
    }
    
    int get_suma(){
        return suma;
    }
}