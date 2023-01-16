DROP TABLE IF EXISTS user;
CREATE TABLE user (
        id INTEGER PRIMARY KEY,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL,
        username TEXT NOT NULL,
        password TEXT NOT NULL,
        fk_id_formation INTEGER NOT NULL,
        fk_id_type_user INTEGER NOT NULL,
        FOREIGN KEY (fk_id_formation) 
                REFERENCES formation (id) 
                        ON DELETE NO ACTION 
                        ON UPDATE NO ACTION,
        FOREIGN KEY (fk_id_type_user) 
                REFERENCES type_user (id) 
                        ON DELETE NO ACTION 
                        ON UPDATE NO ACTION        
);

DROP TABLE IF EXISTS type_user;
CREATE TABLE type_user (
        id INTEGER PRIMARY KEY,
        label TEXT NOT NULL
);

DROP TABLE IF EXISTS formation;
CREATE TABLE formation (
        id INTEGER PRIMARY KEY,
        label TEXT NOT NULL,
        fk_id_matiere INTEGER NOT NULL,
        FOREIGN KEY (fk_id_matiere) 
                REFERENCES matiere (id) 
                        ON DELETE NO ACTION 
                        ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS matiere;
CREATE TABLE matiere (
        id INTEGER PRIMARY KEY,
        label TEXT NOT NULL
);

DROP TABLE IF EXISTS grade;
CREATE TABLE grade (
        id INTEGER PRIMARY KEY,
        value INTEGER NOT NULL,
        comment TEXT,
        fk_id_matiere INTEGER NOT NULL,
        fk_id_user INTEGER NOT NULL,
        FOREIGN KEY (fk_id_matiere) 
                REFERENCES matiere (id) 
                        ON DELETE NO ACTION 
                        ON UPDATE NO ACTION,
        FOREIGN KEY (fk_id_user) 
                REFERENCES user (id) 
                        ON DELETE NO ACTION 
                        ON UPDATE NO ACTION
);

--Insert data to tables--
INSERT INTO user (first_name, last_name,username,password,fk_id_formation,fk_id_type_user) VALUES 
("Marc","Dutoo","MDutoo","0000",1,2),
("Nicolas","Chevalier","NicoChev69","69Villeurbanne38550",1,2),
("Benoît","Fauchery","Benfau","1234",1,1),
("Laurent","Thillou","LoloThi","password",1,1);

INSERT INTO formation (label, fk_id_matiere) VALUES 
("IPI",1),
("IPI",2),
("IPI",3),
("IPI",4),
("DUT Informatique",1),
("DUT Informatique",2),
("Lycée Georges de la jungle",1);

INSERT INTO matiere (label) VALUES 
("Java"),
("JavaScript"),
("C#"),
("Anglais");

INSERT INTO type_user (label) VALUES 
("Etudiant"),
("Professeur"),
("Administrateur");

INSERT INTO grade (value,comment,fk_id_matiere,fk_id_user) VALUES 
(15,"Bien.",1,3),
(10,"Moyen",3,3),
(0,"",1,4);