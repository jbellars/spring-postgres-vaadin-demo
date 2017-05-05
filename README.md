# spring-postgres-vaadin-demo

This is a Spring-based example application that demonstrates lazy loading with Vaadin Grid components adapted from https://github.com/alejandro-du/lazy-loading-spring-demo.

## Running the app

1) Configure a database connection in the
[application.properties](https://github.com/jbellars/spring-postgres-vaadin-demo/blob/master/src/main/resources/application.properties)
file. By default, this example uses a PostgreSQL database. You should include the driver dependency in the pom.xml file if you want
to use a different database.

2) Create a person table in  PostgreSQL:
```
CREATE TABLE person(
  id SERIAL NOT NULL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255)
);
```

2) Create function to insert test rows into the PostgreSQL person table.
```
   CREATE OR REPLACE FUNCTION add_person(fname VARCHAR(255), lname VARCHAR(255), eml VARCHAR(255))
   RETURNS VOID AS $$
   BEGIN
       INSERT INTO person (first_name, last_name, email) VALUES (fname, lname, eml);
   END;
   $$ LANGUAGE plpgsql;
```

3) Insert some test rows in the PostgreSQL person table using the function you just created.
```
SELECT add_person('Linus','Torvalds','linus@linux.org');
SELECT add_person('Bjarne','Stroustrup','bjarne@stroustrup.org');
SELECT add_person('Hendrik','Ebbers','hendrik@ebbers.org');
SELECT add_person('Ted','Neward','ted@neward.com');
SELECT add_person('Bruce','Tate','bruce@tate.com');
SELECT add_person('Mosh','Hamedani','mosh@hamedani.com');
SELECT add_person('Scott','Hanselman','scott@hanselman.com');
SELECT add_person('Svetlin','Nakov','svetlin@nakov.com');
SELECT add_person('Bruce','Eckel','bruce@eckel.com');
```

3) Download, compile and run the app by running the following in a terminal:
```
git clone https://github.com/jbellars/spring-postgres-vaadin-demo.git
cd lazy-loading-spring-demo
mvn package spring-boot:run
```

4) Point your browser to <http://localhost:8080>.
