package vv.cc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by melo on 2016/12/8.
 */
@SpringBootApplication
@ImportResource(locations = "classpath:application-bootpro.xml")
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
       SpringApplication.run(Application.class,args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }

}
