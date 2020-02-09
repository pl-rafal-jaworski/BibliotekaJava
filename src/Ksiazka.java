public class Ksiazka {
    private String tytul;
    private String autor;
    private String isbn;
    public Ksiazka(String tytul, String autor, String isbn){
        this.tytul = tytul;
        this.autor = autor;
        this.isbn = isbn;
    }
    public String[] returnDane(){
        return new String [] {tytul,autor,isbn};
    }
    public void changeTitle (String title){
        this.tytul = title;
    }
    public void changeAuthor (String author){
        this.autor = author;
    }
    public void changeISBN(String ISBN){
        this.isbn = ISBN;
    }

}
