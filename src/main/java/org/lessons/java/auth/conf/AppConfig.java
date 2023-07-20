package org.lessons.java.auth.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import beans.CargoItalo;
import beans.LocomotivaItalo;
import beans.LocomotivaTrenItalia;
import beans.PasseggeriItalo;
import beans.RistoranteItalo;
import beans.RistoranteTrenItalia;

@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    
    //DEFINIZIONE DEI 16 VAGONI PREDEFINITI (4L, 4C, 4P, 4R)
    
    /*la creazione dei vagoni la demandiamo a VagoneFactory
	 * gli passiamo, oltre ai dati, la compagnia e la tipologia
	 * 
	 * es.
	 * VagoneFactory.creaVagone(tipologia, compagnia, id, peso, lunghezza, colore, costo + campi specifici)
	 * 
	 * dalla tipologia e dalla compagnia passate crea opportunamente il vagone
	 * 
	 * VagoneFactory.creaVagone("Locomotiva", "Italo", ...)
	 * crea
	 * LocomotivaItalo
	 */
    
     
    
    
    /*
	 * 11 p4000 35 Nero Italo c2500 --- Frigo 7000
	 */
	/*@Bean(name = "CargoItalo11")
	public CargoItalo cargoItalo() {
		return new CargoItalo();
	}*/
	
	
	

	/*
	 * 16 p7500 50 Azzurro Italo c2000 --- Merce 4000
	 */
	/*
	 * @Bean(name = "CargoItalo16") public CargoItalo cargoItalo() { return new
	 * CargoItalo(); }
	 */

	
	
	
	/*
	 * 1 p5000 20 Rosso Trenitalia c1500 --- Posta 5000
	 */
	/*
	 * @Bean(name = "CargoTrenItalia1") public CargoTrenItalia cargoTrenItalia() {
	 * return new CargoTrenItalia(); }
	 */

	
	
	
	/*
	 * 5 p5000 50 Azzurro Trenitalia c2200 --- Frigo 5000
	 */
	/*
	 * @Bean(name = "CargoTrenItalia5") public CargoTrenItalia CargoTrenItalia() {
	 * return new CargoTrenItalia(); }
	 */

	
	
	
	/*
	 * 6 p4000 20 Rosso Italo c1400 --- 20000 2
	 */
	/*@Bean(name = "LocomotivaItalo6")
	public LocomotivaItalo locomotivaItalo() {
		return new LocomotivaItalo();
	}*/

	
	
	
	/*
	 * 10 p2000 10 Verde Italo c1900 --- 50000 3
	 */
	/*
	 * @Bean(name = "LocomotivaItalo10") public LocomotivaItalo locomotivaItalo() {
	 * return new LocomotivaItalo(); }
	 */

	
	
	
	/*
	 * 4 p5500 42 Verde Trenitalia c3000 --- 40000 2
	 */
	/*@Bean(name = "LocomotivaTrenitalia4")
	public LocomotivaTrenItalia locomotivaTrenItalia() {
		return new LocomotivaTrenItalia();
	}*/

	
	
	
	/*
	 * 15 p7000 50 Verde Trenitalia c1900 --- 10000 1
	 */
	/*
	 * @Bean(name = "LocomotivaTrenItalia15") public LocomotivaTrenItalia
	 * locomotivaTrenItalia() { return new LocomotivaTrenItalia(); }
	 */

	
	
	
	/*
	 * 9 p4000 30 Bianco Italo c1500 --- 40pd 59pp 3cd 100pc
	 */
	/*@Bean(name = "PasseggeriItalo9")
	public PasseggeriItalo passeggeriItalo() {
		return new PasseggeriItalo();
	}*/

	
	
	
	/*
	 * 14 p5000 40 Nero Italo c2000 --- 65pd 70pp 0cd 0pc
	 */
	/*
	 * @Bean(name = "PasseggeriItalo14") public PasseggeriItalo passeggeriItalo() {
	 * return new PasseggeriItalo(); }
	 */

	
	
	
	/*
	 * 12 p7000 50 Verde Trenitalia c1900 --- 25pd 69pp 4cd 120pc
	 */
	/*
	 * @Bean(name = "PasseggeriTrenItalia12") public PasseggeriTrenItalia
	 * passeggeriTrenItalia() { return new PasseggeriTrenItalia(); }
	 * */
	
	
	
	
	 /* 7 p2000 15 Rosso Trenitalia c1200 --- 55pd 40pp 0cd 0pc
	 */
	/*
	 * @Bean(name = "PasseggeriTrenItalia7") public PasseggeriTrenItalia
	 * passeggeriTrenItalia() { return new PasseggeriTrenItalia(); }
	 */

	
	
	
	/*
	 * 3 p3000 75 Verde Italo c1550 --- 15
	 */
	/*@Bean(name = "RistoranteItalo3")
	public RistoranteItalo ristoranteItalo() {
		return new RistoranteItalo();
	}*/

	
	
	
	/*
	 * 8 p3000 12 Giallo Italo c1500 --- 20
	 */
	/*
	 * @Bean(name = "RistoranteItalo8") public RistoranteItalo ristoranteItalo() {
	 * return new RistoranteItalo(); }
	 */

	
	
	
	/*
	 * 2 p4000 15 Azzurro Trenitalia c2000 --- 12
	 */
	/*@Bean(name = "RistoranteTrenItalia2")
	public RistoranteTrenItalia ristoranteTrenItalia() {
		return new RistoranteTrenItalia();
	}*/

	
	
	
	/*
	 * 13 p7000 35 Bianco Trenitalia c1700 --- 10
	 */
	/*
	 * @Bean(name = "RistoranteTrenItalia13") public RistoranteTrenItalia
	 * ristoranteTrenItalia() { return new RistoranteTrenItalia(); }
	 */
    
}
