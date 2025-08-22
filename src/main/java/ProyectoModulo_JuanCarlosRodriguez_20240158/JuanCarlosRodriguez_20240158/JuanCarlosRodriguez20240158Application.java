package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuanCarlosRodriguez20240158Application {

	public static void main(String[] args) {
		//Código que permite CARGAR ARCHVOS ENV a la hora de iniciar la API
		Dotenv runDOTEnv = Dotenv.configure().ignoreIfMissing().load();
		runDOTEnv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		//Queda así, estático
		SpringApplication.run(JuanCarlosRodriguez20240158Application.class, args);
	}
}
