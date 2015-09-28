
REQUIREMENTS
------------
Compiled with JDK 1.8.0_45
Deployed with Tomcat v7.0

Mock records are contained in a SQLite database.
Database project path is: /XFormationRestaurant/WebContent/WEB-INF/db/restaurant.db

!IMPORTANT
In order for ConnectionDAO class to stablish the connection properly,
it is necessary to modify the RESOURCES file:
/XFormationRestaurant/src/resources/config.properties
and set the config var 
DB_PATH=C:\Users\Diego\workspace\XFormationRestaurant\WebContent\WEB-INF\db\restaurant.db
pointing to a VALID local disk path
(in real life this would be a jdbc jndi resource against a proper server or similar).

The contents of the database file can be edited with a SQLite client (e.g. Sqliteadmin)
