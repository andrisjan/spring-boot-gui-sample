package lv.home.test.gui;

import lv.home.test.service.AppInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MainForm extends JFrame {
    private static final Logger LOG = LoggerFactory.getLogger(MainForm.class);

    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton infoButton;
    private JButton showSubformButton;

    @Autowired
    private SubForm subForm;

    @Autowired
    private AppInfoService appInfoService;

    public MainForm() {
        initComponents();
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOG.info("Info button pressed");
                appInfoService.printAppInfo();
            }
        });

        showSubformButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subForm.setVisible(true);
            }
        });
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot - GUI Application");

        //mainPanel.setSize(600, 600);
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        pack();
    }

}
