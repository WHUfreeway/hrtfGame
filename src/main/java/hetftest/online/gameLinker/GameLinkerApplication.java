package hetftest.online.gameLinker;

import com.google.gson.Gson;
import hetftest.online.gameLinker.mapper.StudentMapper;
import hetftest.online.gameLinker.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
@RestController
@MapperScan("hetftest.online.gameLinker.mapper")
public class GameLinkerApplication {

	@Autowired
	private StudentMapper studentMapper;

	@GetMapping("/getcat")
	public List<Student> getStudent(){
		return studentMapper.getAllStudents(1,"name");
	}

	/*设置路由界面的用户名, 密码*/
	@Bean
	MapReactiveUserDetailsService mapReactiveUserDetailsService(){
		return new MapReactiveUserDetailsService(
				User.withUsername("admin").
						password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).roles("USER").build());
	}

	public static void main(String[] args) {
		SpringApplication.run(GameLinkerApplication.class, args);
	}

}
