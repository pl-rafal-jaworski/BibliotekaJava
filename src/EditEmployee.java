import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditEmployee extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField nameBox;
    private JTextField surnameBox;
    private JTextField phoneBox;
    ArrayList<Osoba> employeesList;
    private Boolean okClicked = false;
    private int employeeIndex;

    public EditEmployee(ArrayList<Osoba> employees) {
        employeesList = employees;

        for (Osoba e: employeesList) {
            comboBox1.addItem(e.returnDane()[0] + " " +e.returnDane()[1] + " " +e.returnDane()[2]);

        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nameBox.setText(employeesList.get(comboBox1.getSelectedIndex()).returnDane()[0]);
                surnameBox.setText(employeesList.get(comboBox1.getSelectedIndex()).returnDane()[1]);
                phoneBox.setText(employeesList.get(comboBox1.getSelectedIndex()).returnDane()[2]);
                employeeIndex=comboBox1.getSelectedIndex();


            }
        });
    }
    public Object[] getEditDetails() {
        return new Object[]{nameBox.getText(),surnameBox.getText(),phoneBox.getText(),employeeIndex};
    };
    private void onOK() {
        // add your code here
        okClicked=true;
        dispose();
    }
    public Boolean okClicked(){
        return okClicked;
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
