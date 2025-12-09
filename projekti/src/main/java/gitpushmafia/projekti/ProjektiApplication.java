package gitpushmafia.projekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;
import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;
import gitpushmafia.projekti.domain.Vaihtoehto;
import gitpushmafia.projekti.domain.VaihtoehtoRepository;

@SpringBootApplication
public class ProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepository kyselyrepo, KysymysRepository kysymysrepo, VaihtoehtoRepository vaihtoehtorepo) {
		return (args) -> {

			Kysely k1 = new Kysely("Kysely", "testi", null, null, null);
			kyselyrepo.save(k1);

			Kysely hh = new Kysely("IT-tradenomien kiinnostuksen kohteet", "IT-opiskelijoille tarkoitettu kysely, jolla kartoitetaan opiskelijoiden kiinnostuksia kurssitarjontaa varten.", null, null, null);
			kyselyrepo.save(hh);

			Kysymys hh1 = new Kysymys("Mihin olet suuntautunut?", hh, "monivalinta");
			Vaihtoehto ve1 = new Vaihtoehto("Ohjelmistokehitys", hh1);
			Vaihtoehto ve2 = new Vaihtoehto("Digitaaliset palvelut", hh1);
			Vaihtoehto ve3 = new Vaihtoehto("ICT ja infrastruktuuri", hh1);
			Vaihtoehto ve4 = new Vaihtoehto("ICT ja liiketoiminta", hh1);
			kysymysrepo.save(hh1);
			vaihtoehtorepo.save(ve1);
			vaihtoehtorepo.save(ve2);
			vaihtoehtorepo.save(ve3);
			vaihtoehtorepo.save(ve4);



			Kysymys hh2 = new Kysymys("Monesko vuosi sinulla on menossa?", hh, "monivalinta");
			Vaihtoehto ve5 = new Vaihtoehto("1.", hh2);
			Vaihtoehto ve6 = new Vaihtoehto("2.", hh2);
			Vaihtoehto ve7 = new Vaihtoehto("3.", hh2);
			Vaihtoehto ve8 = new Vaihtoehto("4.", hh2);
			kysymysrepo.save(hh2);
			vaihtoehtorepo.save(ve5);
			vaihtoehtorepo.save(ve6);
			vaihtoehtorepo.save(ve7);
			vaihtoehtorepo.save(ve8);

			Kysymys hh3 = new Kysymys("Mitkä alat kiinnostavat sinua?", hh, "teksti");
			Kysymys hh4 = new Kysymys("Mikä on ollut itsellesi mielenkiintoisin kurssi?", hh, "teksti");
			Kysymys hh5 = new Kysymys("Minkä aiheisia uusia kursseja haluaisit lisätä kurssitarjontaan?", hh, "teksti");
			
			kysymysrepo.save(hh3);
			kysymysrepo.save(hh4);
			kysymysrepo.save(hh5);

		};
	}
}
