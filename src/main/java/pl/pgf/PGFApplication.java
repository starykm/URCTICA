package pl.pgf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class PGFApplication {
 public static void main(String[] args) throws Exception {

     SpringApplication.run(PGFApplication.class, args);

     

 }
 @Bean
 public EmbeddedServletContainerCustomizer containerCustomizer() {
  
     return new EmbeddedServletContainerCustomizer() {
         @Override
         public void customize(ConfigurableEmbeddedServletContainer container) {
  
           
             ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
           ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
  
             container.addErrorPages( error404Page,error500Page);
         }
     };

}
}