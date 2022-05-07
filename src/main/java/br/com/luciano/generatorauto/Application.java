package br.com.luciano.generatorauto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.luciano.generatorauto.domain.entity.Dependent;
import br.com.luciano.generatorauto.domain.entity.Partner;
import br.com.luciano.generatorauto.domain.repository.PartnerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private PartnerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Dependent dependent1 = Dependent.builder().name("luciano").build();
		Dependent dependent2 = Dependent.builder().name("Pedro").build();
		
		Partner partner = new Partner("Karine");
		partner.addDependent(dependent1);
		partner.addDependent(dependent2);
		
		repository.save(partner);
		
	}

}
