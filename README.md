# FilmQueryProject

## Description ##

FilmQuery is a command-line application that retrieves and displays film data. It is menu-based, allowing the user to choose actions and submit query data.

All JDBC code is encapsulated in methods of the DatabaseAccessorObject class. All database access methods are first declared in the DatabaseAccessor interface, then implemented in DatabaseAccessorObject. Methods return objects like Film, Actor, and List<Actor>, not String or List<String>.

There is a menu and users can choose:

1) Look up a film by its id.
2) Look up a film by a search keyword.
3) Exit the application.

If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found, its title, year, rating, and description are displayed.

If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.

When a film is displayed, its language (English,Japanese, etc.) is also displayed.

When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.

## Lessons Learned ##

I apparently still don't always know when the Scanner needs to be flushed (I'm glad the Scanner won't be used much more after this project). I also had some issues with the menu even though we've made like 10 menus thus far. I'm "trying to catch" inputMismatch with the try/catch and accounting for numbers outside the menu range with default in the switch. It works now, but I had to play with the logic more that I would have liked. I also had some issues early on getting the language and actors to populate by of new methods called by others, but after stepping away from it for a bit I realized it could be done simply by calling new simpler methods (especially the language name which is a simple 1:1 query).
