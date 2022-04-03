package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test(); // comment this out
		app.launch(); // uncomment this one
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);

//    Actor actor = db.findActorById(12);
//    System.out.println(actor);

		System.out.println(film.getActors());

		for (Actor a : film.getActors()) {
			System.out.println(a);
		}

//    List<Actor> actors = db.findActorsByFilmId(1);
//    System.out.println(actors);

	}

	private void launch() {

		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		// start menu loop, input etc.

		int choice = 0;

		do {

			System.out.println("***************  MENU  **************");
			System.out.println("********** chose an option **********");
			System.out.println();
			System.out.println("1: Look up a film by its id");
			System.out.println("2: Look up a film by a search keyword");
			System.out.println("3: Exit");

			try {

				choice = input.nextInt();
				switch (choice) {

				case 1:
					try {
						System.out.println("Enter a film id: ");
						Film film;
						film = db.findFilmById(input.nextInt());
						if (film != null) {
						System.out.println(film);
						} else 
							System.out.println("Film not found. Try again.\n");
						input.nextLine(); // flush
					} catch (InputMismatchException e) {
						System.out.println("You must enter a number. ~Try again.\n");
					}
					break;
				case 2:
					System.out.println("Enter a search keyword (eg. bama) TODO ");
					break;
				case 3:
					System.out.println("Goodbye\n");
					break;

				default:
					System.out.println("Not a valid menu choice. Try again.\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("You must enter a number. Try again.\n");
				input.nextLine();  // flush
			}
		} while (choice != 3);

	}
}
