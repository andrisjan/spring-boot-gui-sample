package my.java.code.spring.gui.sample;

import my.java.code.spring.gui.sample.gui.MainForm;
import my.java.code.spring.gui.sample.service.AppInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private MainForm mainForm;

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public void run(String... args) throws Exception {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                LOG.info("Look and feel: " + info.getName() + ", " + info.getClassName());
            }
            UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel88");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        /* display the form using the AWT EventQueue */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                mainForm.setVisible(true);
            }
        });

        // console interaction
        while (true){
            System.out.println("write some input - <q> to exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println("your inut:" + s);
            if ("q".equals(s)){
                mainForm.dispose();
                break;
            }
            else if ("i".equals(s)){
                appInfoService.printAppInfo();
            }
        }
    }


}
