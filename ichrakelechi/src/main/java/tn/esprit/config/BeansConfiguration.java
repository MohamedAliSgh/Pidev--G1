package tn.esprit.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan("tn.esprit")
@ComponentScan("tn.esprit.service")
@ComponentScan("tn.esprit.control")
@ComponentScan("tn.esprit.repository")
public class BeansConfiguration {
	

}
