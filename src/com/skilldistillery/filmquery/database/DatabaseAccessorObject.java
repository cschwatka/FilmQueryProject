package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Driver not found.");
			throw new RuntimeException("Unable to load MySQL driver class.");
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId); // bind variable if needed
			ResultSet filmResult = stmt.executeQuery();

			if (filmResult.next()) {
				film = new Film();

				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));

			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {

		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, actorId); // bind variable if needed
			ResultSet actorResult = stmt.executeQuery();

			if (actorResult.next()) {
				actor = new Actor();

				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getString(2));
				actor.setLastName(actorResult.getString(3));

			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT * FROM actor a JOIN film_actor fa ON fa.actor_id  = a.id  WHERE film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId); // bind variable if needed
			ResultSet actorResult = stmt.executeQuery();

			while (actorResult.next()) {

				int actorId = actorResult.getInt(1);
				String firstName = actorResult.getString(2);
				String lastName = actorResult.getString(3);

				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);

//			film.setActors(actors);

			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

}
