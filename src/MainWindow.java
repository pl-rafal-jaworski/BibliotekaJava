import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainWindow {
    private Biblioteka library = new Biblioteka("Biblioteka", "Politechnika Wrocławska");

    private JPanel MainPanel;
    private JButton dodajPracownikaButton;
    private JButton dodajKlientaButton;
    private JButton dodajKsiążkęButton;
    private JButton noweWypożyczenieButton;
    private JButton edytujKsiążkęButton;
    private JButton zwrotKsiążkiButton;
    private JButton edytujDanePracownikaButton;
    private JButton edytujDaneKlientaButton;
    private JLabel nazwaBiblioteki;
    private JLabel adresBiblioteki;

    public MainWindow() {
        nazwaBiblioteki.setText(library.getName());
        adresBiblioteki.setText(library.getAddress());

        //przykładowe dane
        library.addClient("Jan","Kowalski","5000000000");
        library.addEmployee("Piotr","Kowalski","600000000");
        library.addBook("Pan Tadeusz","Adam Mickiewicz","978-83-070-3341-9");
        library.addBook("Pan Tadeusz","Adam Mickiewicz","978-83-070-3341-9");



        dodajPracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewEmployee newEmployee= new NewEmployee();
                newEmployee.setMinimumSize(new Dimension(300,400));
                newEmployee.setVisible(true);
                if (newEmployee.getDetails().length!=0) {
                    //System.out.print(Arrays.toString(newEmployee.getDetails()));
                    library.addEmployee(newEmployee.getDetails()[0],newEmployee.getDetails()[1],newEmployee.getDetails()[2]);
                    //System.out.println(library.getPracownicy());
                }

            }
        });
        dodajKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewClient newClient = new NewClient();
                newClient.setMinimumSize(new Dimension(300,400));
                newClient.setVisible(true);
                if (newClient.getDetails().length!=0) {
                    //System.out.print(Arrays.toString(newClient.getDetails()));
                    library.addClient(newClient.getDetails()[0],newClient.getDetails()[1],newClient.getDetails()[2]);
                    //System.out.print(library.getKlienci());
                }

            }
        });
        dodajKsiążkęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewBook newBook = new NewBook();
                newBook.setMinimumSize(new Dimension(300,400));
                newBook.setVisible(true);
                if (newBook.getDetails().length!=0) {
                    //System.out.print(Arrays.toString(newBook.getDetails()));
                    library.addBook(newBook.getDetails()[0],newBook.getDetails()[1],newBook.getDetails()[2]);
                    //System.out.print(library.getWolneKsiazki());
                }

            }
        });
        noweWypożyczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewLease newLease = new NewLease(library.getPracownicy(),library.getKlienci(),library.getWolneKsiazki());
                newLease.setMinimumSize(new Dimension(700,400));
                newLease.setVisible(true);
                //System.out.println(library.getWolneKsiazki());
                //System.out.println(library.getWypozyczenia());
                if (newLease.okClicked()){
                    library.newLease(newLease.getDetails().getBook(),newLease.getDetails().getClient(),newLease.getDetails().getEmployee());
                }

                //System.out.println(library.getWolneKsiazki());
                //System.out.println(library.getWypozyczenia());

            }
        });
        zwrotKsiążkiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ReturnLease returnLease = new ReturnLease(library.getWypozyczenia());
                returnLease.setMinimumSize(new Dimension(900,400));
                returnLease.setVisible(true);

                if (returnLease.okClicked()){
                    library.returnLease(returnLease.getReturn());
                }
            }
        });
        edytujKsiążkęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditBook editBook = new EditBook(library.getWolneKsiazki());
                editBook.setMinimumSize(new Dimension(700,400));
                editBook.setVisible(true);
                if (editBook.okClicked()){
                    library.getWolneKsiazki().get((Integer) editBook.getEditDetails()[3]).changeTitle((String) editBook.getEditDetails()[0]);
                    library.getWolneKsiazki().get((Integer) editBook.getEditDetails()[3]).changeAuthor((String) editBook.getEditDetails()[1]);
                    library.getWolneKsiazki().get((Integer) editBook.getEditDetails()[3]).changeISBN((String) editBook.getEditDetails()[2]);
                }
            }
        });
        edytujDaneKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            EditClient editClient = new EditClient(library.getKlienci());
            editClient.setMinimumSize(new Dimension(700,400));
            editClient.setVisible(true);
                if (editClient.okClicked()){
                    library.getKlienci().get((Integer) editClient.getEditDetails()[3]).changeImie((String) editClient.getEditDetails()[0]);
                    library.getKlienci().get((Integer) editClient.getEditDetails()[3]).changeNazwisko((String) editClient.getEditDetails()[1]);
                    library.getKlienci().get((Integer) editClient.getEditDetails()[3]).changeNumber((String) editClient.getEditDetails()[2]);
                }
            }

        });
        edytujDanePracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditEmployee editEmployee = new EditEmployee(library.getPracownicy());
                editEmployee.setMinimumSize(new Dimension(700,400));
                editEmployee.setVisible(true);
                if (editEmployee.okClicked()){
                    library.getPracownicy().get((Integer) editEmployee.getEditDetails()[3]).changeImie((String) editEmployee.getEditDetails()[0]);
                    library.getPracownicy().get((Integer) editEmployee.getEditDetails()[3]).changeNazwisko((String) editEmployee.getEditDetails()[1]);
                    library.getPracownicy().get((Integer) editEmployee.getEditDetails()[3]).changeNumber((String) editEmployee.getEditDetails()[2]);
                }
            }
        });
    }

    public static void main(String[] args) {




        JFrame frame = new JFrame("Biblioteka");
        frame.setContentPane(new MainWindow().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }




    private void createUIComponents() {
    }
}
