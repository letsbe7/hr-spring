package com.spring.hr.letsbe;

import com.spring.hr.letsbe.business.test.service.TestService;
import com.spring.hr.letsbe.config.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class LetsbeApplication {

	@Autowired
	Environment env;

	static final Logger log = LoggerFactory.getLogger(LetsbeApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LetsbeApplication.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
	}


	@PostConstruct
	public void initApplication () {
		log.info("프로퍼티모드 : " + Arrays.toString(env.getActiveProfiles()));
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
			log.error("개발과 배포용 환경이 동시에 설정될 수 없습니다.");
		}
	}

	@Bean
	public CommandLineRunner check (TestService service) {
		return args -> service.findAll().forEach(System.out::println);
	}


}
