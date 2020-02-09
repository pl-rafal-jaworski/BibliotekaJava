import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditBook extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField titleBox;
    private JTextField authorBox;
    private JTextField iSBNbox;
    private ArrayList<Ksiazka> wolneKsiazkiList;
    private Boolean okClicked = false;
    private int bookIndex;


    public EditBook(ArrayList<Ksiazka> wolneKsiazki) {
        wolneKsiazkiList = wolneKsiazki;

        for (Ksiazka k: wolneKsiazkiList) {
            comboBox1.addItem(k.returnDane()[0] + " " +k.returnDane()[1]+" " + k.returnDane()[2]);

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
                titleBox.setText(wolneKsiazkiList.get(comboBox1.getSelectedIndex()).returnDane()[0]);
                authorBox.setText(wolneKsiazkiList.get(comboBox1.getSelectedIndex()).returnDane()[1]);
                iSBNbox.setText(wolneKsiazkiList.get(comboBox1.getSelectedIndex()).returnDane()[2]);
                bookIndex=comboBox1.getSelectedIndex();

            }
        });
    }

    public Object[] getEditDetails() {
        return new Object[]{titleBox.getText(),authorBox.getText(),iSBNbox.getText(),bookIndex};
    };
    public Boolean okClicked(){
        return okClicked;
    }

    private void onOK() {
        // add your code here
        okClicked=true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
