package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainMenu extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 150;
    private static final int FRAME_X_ORIGIN = 450;
    private static final int FRAME_Y_ORIGIN = 250;

    private JButton manageStudent;
    private JButton manageLecturer;
    private JButton cancelBt;

    MainMenu() {
        setTitle("Student Management System");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(3, 1));

        manageStudent = new JButton("Manage Student");
        manageStudent.addActionListener(this::actionPerformed);
        optionPanel.add(manageStudent);

        manageLecturer = new JButton("Manage Lecturer");
        manageLecturer.addActionListener(this::actionPerformed);
        optionPanel.add(manageLecturer);

        cancelBt = new JButton("Cancel");
        cancelBt.addActionListener(this::actionPerformed);
        optionPanel.add(cancelBt);

        add(optionPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBt = (JButton) e.getSource();

        if (clickedBt == manageStudent){
            setVisible(false);
            new SubMenu_manageStudent().setVisible(true);
        }else if (clickedBt == manageLecturer){
            setVisible(false);
            new SubMenu_manageLecturer().setVisible(true);
        }else {
            dispose();
        }
    }
}