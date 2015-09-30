
REQUIREMENTS
------------
Compiled with JDK 1.8.0_45
Deployed with Tomcat v7.0.47
Tested with Firefox 40.0.3 and Google Chrome 45.0.2454.101m

Mock records are contained in a SQLite database.
Database project path is: /XFormationRestaurant/WebContent/WEB-INF/db/restaurant.db

!IMPORTANT
In order for ConnectionDAO class to stablish the connection properly,
it is necessary to modify the RESOURCES file:
/XFormationRestaurant/src/resources/config.properties

and set the config var 
DB_PATH=C:\Users\Diego\workspace\XFormationRestaurant\WebContent\WEB-INF\db\restaurant.db
pointing to a VALID local disk path
(-in real life this would be a jdbc url resource against a proper server or similar).

Contents of the database file can be edited with a SQLite client (e.g. Sqliteadmin)

Please run the Tomcat server in port 8080

The list of all exposed rest service operations can be found at the file
/XFormationRestaurant/src/com/xformation/test/curl.txt
and it can be used in addition with the command tool "curl",
or just pasting the lines in the navigator.