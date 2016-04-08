package org.home.test.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class SubForm extends JFrame {
    private JButton okButton;
    private JPanel mainPanel;

    public SubForm() {
        initComponents();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void initComponents() {
        setTitle("Spring Boot - subform");

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        pack();
    }
}
