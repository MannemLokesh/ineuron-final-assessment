package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.controller.Performing;

@SpringBootApplication
public class Project21Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Project21Application.class, args);
		Performing bean = context.getBean(Performing.class);
		bean.perform();
	}

}
