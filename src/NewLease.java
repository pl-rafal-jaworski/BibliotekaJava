import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewLease extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox employeesList;
    private JComboBox clientsList;
    private JComboBox booksList;
    private Boolean okClicked = false;

    private ArrayList<Osoba> globalEmployeesList;
    private ArrayList<Osoba> globalClientsList;
    private ArrayList<Ksiazka> globalBooksList;

    public Lease getDetails(){
            return new Lease(globalBooksList.get(booksList.getSelectedIndex()),globalClientsList.get(clientsList.getSelectedIndex()),globalEmployeesList.get(employeesList.getSelectedIndex()));

    };

    public NewLease(ArrayList<Osoba> globalEmployeesList, ArrayList<Osoba> globalClientsList, ArrayList<Ksiazka> globalBooksList) {
        //System.out.println(globalEmployeesList);
        //System.out.println(globalClientsList);
        this.globalEmployeesList = globalEmployeesList;
        this.globalBooksList=globalBooksList;
        this.globalClientsList=globalClientsList;


        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        for (Osoba a:globalEmployeesList) {
            employeesList.addItem("" + a.returnDane()[0] + " " + a.returnDane()[1]);
        }
        for (Osoba a:globalClientsList) {
            clientsList.addItem("" + a.returnDane()[0] + " " + a.returnDane()[1]);
        }
        for (Ksiazka a:globalBooksList) {
            booksList.addItem("" + a.returnDane()[0] + " " + a.returnDane()[1] + " " + a.returnDane()[2]);
        }






        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        okClicked=true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        okClicked = false;
        dispose();
    }
    public Boolean okClicked(){
        return okClicked;
    }

    //public static void main(String[] args) {
      //  NewLease dialog = new NewLease();
       // dialog.pack();
       // dialog.setVisible(true);
       // System.exit(0);
    //}
}
