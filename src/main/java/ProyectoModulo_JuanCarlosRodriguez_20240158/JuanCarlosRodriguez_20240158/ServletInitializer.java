package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JuanCarlosRodriguez20240158Application.class);
	}

}
