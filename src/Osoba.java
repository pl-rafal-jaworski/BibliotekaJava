public class Osoba {
    private String imie;
    private String nazwisko;
    private String numerTel;
    Boolean pracownik;

    public Osoba(String imie, String nazwisko, String numer,Boolean rola){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTel = numer;
        this.pracownik = rola;

    }

    public String[] returnDane(){
        String[] daneOsoby = new String [] {imie,nazwisko,numerTel, String.valueOf(pracownik)};
        return daneOsoby;
    }



    public void changeImie(String imie){
        this.imie = imie;
    }

    public void changeNazwisko (String nazwisko){
        this.nazwisko = nazwisko;
    }

    public void changeNumber(String tel){
        this.numerTel = tel;
    }

    public Boolean czyPracownik(){
        if (pracownik){
            return true;
        }
        else {
            return false;
        }
    }
}
