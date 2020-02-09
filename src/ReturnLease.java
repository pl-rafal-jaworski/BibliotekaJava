import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ReturnLease extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private ArrayList<Lease> leasesList;
    private Boolean okClicked = false;
    DefaultTableModel model = new DefaultTableModel();

    public ReturnLease(ArrayList<Lease> leases) {
        this.leasesList = leases;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        Object[] columns = {"Książka", "Pracownik", "Klient"};
        model.setColumnIdentifiers(columns);
        table1.setBackground(Color.white);
        table1.setForeground(Color.gray);
        Font font = new Font("", Font.BOLD,15);
        table1.setFont(font);
        table1.setRowHeight(30);
        table1.setModel(model);

        for (Lease l: leasesList) {
            Object[] row = new Object[3];
            row[0] = new String(l.getBook().returnDane()[0]+ " " + l.getBook().returnDane()[1]+ " " + l.getBook().returnDane()[2]);
            row[1] = new String(l.getEmployee().returnDane()[0]+ " " + l.getEmployee().returnDane()[1]);
            row[2] = new String(l.getClient().returnDane()[0]+ " " + l.getClient().returnDane()[1]);
            model.addRow(row);

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

    public Lease getReturn(){
        return leasesList.get(table1.getSelectedRow());
    }
    public Boolean okClicked(){
        return okClicked;
    }
    private void onOK() {
        // add your code here
        okClicked = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
