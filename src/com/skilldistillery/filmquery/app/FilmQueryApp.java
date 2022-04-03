package com.skilldistillery.filmquery.app;

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
    app.test(); // comment this out 
//    app.launch(); //uncomment this one
    //test GIT
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
    
//    Actor actor = db.findActorById(12);
//    System.out.println(actor);
    
    System.out.println(film.getActors());
    
    for (Actor a: film.getActors()) {
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
  }

}
