package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);
}

/*
 * All JDBC code will be encapsulated in methods of the
 * com.skilldistillery.filmquery.database.DatabaseAccessorObject class. As you
 * need new database access methods, declare them first in the DatabaseAccessor
 * interface, then implement them in DatabaseAccessorObject. Methods should
 * return objects like Film, Actor, and List<Actor>, not String or List<String>
 * 
 * 
 */
*/