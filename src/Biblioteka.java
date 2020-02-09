import java.util.ArrayList;

public class Biblioteka {
    private String nazwa;
    private String adres;


    private ArrayList<Ksiazka> wolneKsiazki= new ArrayList<Ksiazka>();
    private ArrayList<Osoba> pracownicy= new ArrayList<Osoba>();
    private ArrayList<Osoba> klienci= new ArrayList<Osoba>();
    private ArrayList<Lease> wypozyczenia = new ArrayList<Lease>();



    public Biblioteka(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;

    }
    public ArrayList<Osoba> getPracownicy(){
        return pracownicy;
    }
    public ArrayList<Osoba> getKlienci(){
        return klienci;
    }
    public ArrayList<Lease> getWypozyczenia(){return wypozyczenia;}
    public ArrayList<Ksiazka> getWolneKsiazki(){
        return wolneKsiazki;
    }
    public String getName(){
        return this.nazwa;
    }
    public String getAddress(){
        return this.adres;
    }

    public void addBook(String tytul, String autor, String isbn){
        this.wolneKsiazki.add(new Ksiazka(tytul,autor,isbn));
    }

    public void newLease(Ksiazka ksiazka, Osoba klient, Osoba pracownik){
        wypozyczenia.add(new Lease(ksiazka,klient,pracownik));
        wolneKsiazki.remove(ksiazka);
    }

    public void addClient(String imie, String nazwisko, String numer){
        klienci.add(new Osoba(imie,nazwisko,numer, false));
    }

    public void addEmployee(String imie, String nazwisko, String numer){
        pracownicy.add(new Osoba(imie,nazwisko,numer, true));
    }

    public void returnLease(Lease l){
        wolneKsiazki.add(l.getBook());
        wypozyczenia.remove(l);
    }

}
