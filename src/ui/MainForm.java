package ui;

import business.ContactBusiness;
import entity.ContatoEntity;

import javax.swing.*;
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

    private ContactBusiness mContacBusiness;

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

    }

    private void setListeners() {
        buttonNovoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
