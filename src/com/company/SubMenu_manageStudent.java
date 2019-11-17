package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenu_manageStudent extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 350;
    private static final int FRAME_X_ORIGIN = 450;
    private static final int FRAME_Y_ORIGIN = 250;

    private JButton addNew;
    private JButton viewAll;
    private JButton searchFor;
    private JButton delete;
    private JButton update;
    private JButton backToMainMenu;

    SubMenu_manageStudent() {
        setTitle("Manage Student");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        setLayout(new GridLayout(6, 1));

        addNew = new JButton("Add new student");
        addNew.addActionListener(this::actionPerformed);
        add(addNew);
        viewAll =  new JButton("View all student");
        viewAll.addActionListener(this::actionPerformed);
        add(viewAll);
        searchFor = new JButton("Search for student");
        searchFor.addActionListener(this::actionPerformed);
        add(searchFor);
        delete = new JButton("Delete student");
        delete.addActionListener(this::actionPerformed);
        add(delete);
        update = new JButton("Update student's info");
        update.addActionListener(this::actionPerformed);
        add(update);
        backToMainMenu = new JButton("Back to main menu");
        backToMainMenu.addActionListener(this::actionPerformed);
        add(backToMainMenu);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBt = (JButton) e.getSource();

    }
}
