package com.mycompany.biblioteca;

import com.mycompany.biblioteca.service.ConsoleMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleMenu consoleMenu = new ConsoleMenu();
		consoleMenu.displayMenu();
	}
}
