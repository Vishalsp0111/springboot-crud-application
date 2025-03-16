import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nimap.crudapp"})
@EntityScan(basePackages = {"com.nimap.crudapp.entity"})
@EnableJpaRepositories(basePackages = {"com.nimap.crudapp.repository"})
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		System.out.println("hello");

	}

}
