import java.awt.print.Book;

public class Lease {
    private Ksiazka ksiazka;
    private Osoba klient;
    private Osoba pracownik;


    public Lease (Ksiazka ksiazka, Osoba klient, Osoba pracownik){
        this.ksiazka = ksiazka;
        this.klient = klient;
        this.pracownik = pracownik;
    }
    public Ksiazka getBook(){
        return this.ksiazka;
    }
    public Osoba getClient() {return this.klient;}
    public Osoba getEmployee() {return this.pracownik;}

}

