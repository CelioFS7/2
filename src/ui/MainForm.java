package ui;

import business.ContactBusiness;
import entity.ContatoEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel panell;
    private JPanel rootPanel;
    private JButton buttonRemover;
    private JButton buttonNovoContato;
    private JTable tableContatos;
    private JLabel labelContactCount;

    private ContactBusiness mContacBusiness;
    private String mName = "";
    private String mfone = "";

    public MainForm() {

        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().width / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContacBusiness = new ContactBusiness();

        setListeners();
        loadContacts();

    }

    private void loadContacts() {
        List<ContatoEntity> contactlist = mContacBusiness.getList();
        String[] columnNames = {"Nomel, Telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);


        for (ContatoEntity i : contactlist) {
            Object[] o = new Object[2];

            o[0] = i.getName();
            o[1] = i.getFone();

            model.addRow(o);
        }
        tableContatos.clearSelection();
        tableContatos.setModel(model);

        labelContactCount.setText(mContacBusiness.getContactCountDescription());
    }

    private void setListeners() {
        buttonNovoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        tableContatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {

                    if (tableContatos.getSelectedRow() != -1) {

                        mName = tableContatos.getValueAt(tableContatos.getSelectedRow(), 0).toString();
                        mfone = tableContatos.getValueAt(tableContatos.getSelectedRow(), 1).toString();


                    }
                }
            }
        });

        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {mContacBusiness.delete(mName, mfone);
                    loadContacts();

                    mName ="";
                    mfone ="";

                }catch (Exception excp){
                    JOptionPane.showMessageDialog(new JFrame(),excp.getMessage());
                }
            }
        });


    }
}
