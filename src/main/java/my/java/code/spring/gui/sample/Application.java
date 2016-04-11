package my.java.code.spring.gui.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .headless(false)
                .web(false)
                .run(args);
    }

    // orģinālajā piemērā forma tika manuāli inicializēta, bet strādā arī jā pie formas pieliek @Component anotāciju
//    @Bean
//    public MainForm mainForm() {
//        return new MainForm();
//    }
}
