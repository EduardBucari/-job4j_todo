CREATE TABLE if not exists item (
   id SERIAL PRIMARY KEY,
   task TEXT,
   description TEXT,
   created DATE,
   done BOOLEAN,
   user_id int not null references user(id)
);

CREATE TABLE if not exists user (
   id SERIAL PRIMARY KEY,
   email TEXT UNIQUE,
   name TEXT,
   password TEXT
);