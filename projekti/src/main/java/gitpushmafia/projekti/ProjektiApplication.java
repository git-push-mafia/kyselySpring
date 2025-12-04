package gitpushmafia.projekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;
import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;

@SpringBootApplication
public class ProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepository kyselyrepo, KysymysRepository kysymysrepo) {
		return (args) -> {

			Kysely k1 = new Kysely("kysely", "testi", null, null, null);
			kyselyrepo.save(k1);

			Kysely hh = new Kysely("Opiskelu ja kiinnostuksen kohteet", "Opiskelijoille tarkoitettu kysely", null, null, null);
			kyselyrepo.save(hh);

			Kysymys hh1 = new Kysymys("Mitä opiskelet?", hh);
			Kysymys hh2 = new Kysymys("Mihin olet suuntautunut?", hh);
			Kysymys hh3 = new Kysymys("Mikä ala sinua kiinnostaa?", hh);
			Kysymys hh4 = new Kysymys("Mikä on ollut itsellesi mielenkiintoisin kurssi?", hh);
			kysymysrepo.save(hh1);
			kysymysrepo.save(hh2);
			kysymysrepo.save(hh3);
			kysymysrepo.save(hh4);

		};
	}
}
