package org.lessons.java.auth.conf;

import org.lessons.java.auth.classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// DEFINIZIONE DEI 16 VAGONI PREDEFINITI (4L, 4C, 4P, 4R)

	/*
	 * la creazione dei vagoni la demandiamo a VagoneFactory gli passiamo, oltre ai
	 * dati, la compagnia e la tipologia
	 * 
	 * es. VagoneFactory.creaVagone(tipologia, compagnia, id, peso, lunghezza,
	 * colore, costo + campi specifici)
	 * 
	 * dalla tipologia e dalla compagnia passate crea opportunamente il vagone
	 * 
	 * VagoneFactory.creaVagone("Locomotiva", "Italo", ...) crea LocomotivaItalo
	 */

	// *CARGOITALO*

	/*
	 * 11 p4000 35 Nero Italo c2500 --- Frigo 7000
	 */
	@Bean(name = "CargoItalo11")
	public Cargo cargoItalo11() {
		return VagoneFactory.creaVagone(11, 4000, 35, "Nero", "Italo", 2500, "Frigo", 7000);
	}

	/*
	 * 16 p7500 50 Azzurro Italo c2000 --- Merce 4000
	 */
	@Bean(name = "CargoItalo16")
	public Cargo cargoItalo16() {
		return VagoneFactory.creaVagone(16, 7500, 50, "Azzurro", "Italo", 2000, "Merce", 4000);
	}
	
	
	

	// *CARGOTRENITALIA*

	/*
	 * 1 p5000 20 Rosso TrenItalia c1500 --- Posta 5000
	 */

	@Bean(name = "CargoTrenItalia1")
	public Vagone cargoTrenItalia1() {
		return VagoneFactory.creaVagone(1, 5000, 20, "Rosso", "TrenItalia", 1500, "Posta", 5000);
	}

	/*
	 * 5 p5000 50 Azzurro TrenItalia c2200 --- Frigo 5000
	 */
	@Bean(name = "CargoTrenItalia5")
	public Vagone cargoTrenItalia5() {
		return VagoneFactory.creaVagone(5, 5000, 50, "Azzurro", "TrenItalia", 2200, "Frigo", 5000);
	}

	
	
	
	// *LOCOMOTIVAITALO*
	
	/* 
	 * 6 p4000 20 Rosso Italo c1400 --- 20000 2
	 */
	@Bean(name = "LocomotivaItalo6")
	public Vagone locomotivaItalo6() {
		return VagoneFactory.creaVagone(6, 4000, 20, "Rosso", "Italo", 1400, 20000, 2);
	}

	/*
	 * 10 p2000 10 Verde Italo c1900 --- 50000 3
	 */

	@Bean(name = "LocomotivaItalo10")
	public Vagone locomotivaItalo10() {
		return VagoneFactory.creaVagone(10, 2000, 10, "Verde", "Italo", 1900, 50000, 3);
	}

	
	
	

	 // *LOCOMOTIVATRENITALIA*
	 /* 
	 * 4 p5500 42 Verde TrenItalia c3000 --- 40000 2
	 */
	@Bean(name = "LocomotivaTrenItalia4")
	public Vagone locomotivaTrenItalia4() {
		return VagoneFactory.creaVagone(4, 5500, 42, "Verde", "TrenItalia", 3000, 40000, 2);
	}

	/*
	 * 15 p7000 50 Verde TrenItalia c1900 --- 10000 1
	 */

	@Bean(name = "LocomotivaTrenItalia15")
	public Vagone locomotivaTrenItalia15() {
		return VagoneFactory.creaVagone(15, 7000, 50, "Verde", "TrenItalia", 1900, 10000, 1);

	}

	
	
	
	 // *PASSEGGERIITALO*
	 /*
	  * 9 p4000 30 Bianco Italo c1500 --- 40pd 59pp 3cd 100pc
	  */
	@Bean(name = "PasseggeriItalo9")
	public Vagone passeggeriItalo9() {
		return VagoneFactory.creaVagone(9, 4000, 30, "Bianco", "Italo", 1500, 40, 59, 3, 100);
	}

	/*
	 * 14 p5000 40 Nero Italo c2000 --- 65pd 70pp 0cd 0pc
	 */
	@Bean(name = "PasseggeriItalo14")
	public Vagone passeggeriItalo14() {
		return VagoneFactory.creaVagone(14, 5000, 40, "Nero", "Italo", 2000, 65, 70, 0, 0);
	}

	
	
	
	/*
	 * PASSEGGERITRENITALIA*
	 * 
	 * /* 12 p7000 50 Verde TrenItalia c1900 --- 25pd 69pp 4cd 120pc
	 */

	@Bean(name = "PasseggeriTrenItalia12")
	public Vagone passeggeriTrenItalia12() {
		return VagoneFactory.creaVagone(12, 7000, 50, "Verde", "TrenItalia", 1900, 25, 69, 4, 120);
	}

	/*
	 * 7 p2000 15 Rosso TrenItalia c1200 --- 55pd 40pp 0cd 0pc
	 */

	@Bean(name = "PasseggeriTrenItalia7")
	public Vagone passeggeriTrenItalia7() {
		return VagoneFactory.creaVagone(7, 2000, 15, "Rosso", "TrenItalia", 1200, 55, 40, 0, 0);
	}

	
	
	
	/*
	 * RISTORANTEITALO*
	 * 
	 * /* 3 p3000 75 Verde Italo c1550 --- 15
	 */
	@Bean(name = "RistoranteItalo3")
	public Vagone ristoranteItalo3() {
		return VagoneFactory.creaVagone(3, 3000, 75, "Verde", "Italo", 1550, 15);
	}

	/*
	 * 8 p3000 12 Giallo Italo c1500 --- 20
	 */

	@Bean(name = "RistoranteItalo8")
	public Vagone ristoranteItalo8() {
		return VagoneFactory.creaVagone(8, 3000, 12, "Giallo", "Italo", 1500, 20);
	}

	
	
	
	/*
	 * RISTORANTETRENITALIA*
	 * 
	 * /* 2 p4000 15 Azzurro TrenItalia c2000 --- 12
	 */
	@Bean(name = "RistoranteTrenItalia2")
	public Vagone ristoranteTrenItalia2() {
		return VagoneFactory.creaVagone(2, 4000, 15, "Azzurro", "TrenItalia", 2000, 12);
	}

	/*
	 * 13 p7000 35 Bianco TrenItalia c1700 --- 10
	 */

	@Bean(name = "RistoranteTrenItalia13")
	public Vagone ristoranteTrenItalia13() {
		return VagoneFactory.creaVagone(13, 7000, 35, "Bianco", "TrenItalia", 1700, 10);
	}

}
