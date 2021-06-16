DROP TABLE copylending; 

DROP TABLE copyshelving ; 

DROP TABLE lending; 

DROP TABLE reservation; 

DROP TABLE shelving; 

DROP TABLE copy; 

DROP TABLE book; 

DROP TABLE customer; 

DROP TABLE tuser_role ; 

DROP TABLE tuser; 

DROP TABLE trole_server_permission ; 

DROP TABLE tserver_permission ; 

DROP TABLE trole; 



 

 

CREATE TABLE IF NOT EXISTS  book (    

  

    bookId SERIAL PRIMARY KEY,    

  

    bookTitle VARCHAR(50) NOT NULL,    

  

    bookDescription VARCHAR(200),    

  

    bookAuthor VARCHAR(50) NOT NULL,    

  

    bookPageNumber INT,    

  

    bookISBN VARCHAR(13) NOT NULL,    

  

    bookEditorial VARCHAR(50),    

  

    bookEdition INT,    

  

    bookPublicationYear INT     

  

);   

  

ALTER SEQUENCE public.book_bookid_seq RESTART 9;  

  

  

  

CREATE TABLE IF NOT EXISTS copy (   

  

    copyId SERIAL PRIMARY KEY,    

  

    bookId INT NOT NULL REFERENCES book(bookId),    

  

    CopyNotes VARCHAR(50) NOT NULL ,  

  

   CopyCode INT  

  

   

  

);   

  

ALTER SEQUENCE public.copy_copyid_seq RESTART 19;  

  

  

  

CREATE TABLE IF NOT EXISTS customer (   

  

    customerId SERIAL PRIMARY KEY,   

  

    customerName VARCHAR (50),   

  

    customerSurname VARCHAR (50),  

  

    customerDni VARCHAR (9),  

  

    customerAddress VARCHAR (200),  

  

    customerTlf VARCHAR (9),  

  

    customerEmail VARCHAR (100)  

  

); 

ALTER SEQUENCE public.customer_customerid_seq RESTART 12;  

  

  

  

CREATE TABLE IF NOT EXISTS reservation (    

  

    reservationId SERIAL PRIMARY KEY ,    

  

    bookId INT NOT NULL REFERENCES  book(bookId),    

  

    customerId INT NOT NULL REFERENCES  customer(customerId),  

  

    copyId INT REFERENCES copy(copyId),  

  

    reservationDeadLine DATE  

  

);   

  

ALTER SEQUENCE public.reservation_reservationid_seq RESTART 2;  

  

  

  

CREATE TABLE IF NOT EXISTS lending (     

  

    lendingId SERIAL PRIMARY KEY,    

  

    customerId INT NOT NULL REFERENCES customer(customerId),  

  

    lendingDate DATE NOT NULL,    

  

    lendingDeadLine DATE NOT NULL,    

  

    lendingReturnDate DATE,    

  

    lendingNotes VARCHAR (200)    

  

);   

  

ALTER SEQUENCE public.lending_lendingid_seq RESTART 8;  

  

  

  

CREATE TABLE IF NOT EXISTS copyLending(    

  

    copyLendingId SERIAL PRIMARY KEY ,    

  

    copyId INT NOT NULL REFERENCES copy(copyId),    

  

    lendingId INT NOT NULL REFERENCES lending(lendingId)    

  

);   

  

ALTER SEQUENCE public.copylending_copylendingid_seq RESTART 11;  

  

  

  

CREATE TABLE IF NOT EXISTS shelving(    

  

   shelvingId SERIAL PRIMARY KEY ,    

  

   shelvingPublicName VARCHAR(50) NOT NULL    

  

);    

  

ALTER SEQUENCE public.shelving_shelvingid_seq RESTART 3;  

  

  

  

CREATE TABLE IF NOT EXISTS copyShelving(    

  

   copyShelvingId SERIAL PRIMARY KEY ,    

  

   shelvingId INT NOT NULL REFERENCES shelving(shelvingId),    

  

   copyId INT NOT NULL REFERENCES copy(copyId)   

  

);  

  

ALTER SEQUENCE public.copyshelving_copyshelvingid_seq RESTART 19;  

  

  

  

CREATE TABLE IF NOT EXISTS TUSER (  

  

    USER_ VARCHAR(50) NOT NULL PRIMARY KEY,  

  

    PASSWORD VARCHAR(50),  

  

    USERBLOCKED TIMESTAMP,  

  

    LASTPASSWORDUPDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  

  

    FIRSTLOGIN BOOLEAN DEFAULT TRUE,  

  

    customerid INT NOT NULL REFERENCES customer(customerid)  

  

  

  

);  

  

CREATE TABLE IF NOT EXISTS TROLE (  

  

    ID_ROLENAME INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,  

  

    ROLENAME VARCHAR(255),  

  

    XMLCLIENTPERMISSION VARCHAR,  

  

    JSONCLIENTPERMISSION VARCHAR  

  

);  

  

ALTER TABLE TROLE ALTER COLUMN ID_ROLENAME RESTART WITH 1;  

  

  

  

CREATE TABLE  IF NOT EXISTS TUSER_ROLE (  

    ID_USER_ROLE INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,  

    ID_ROLENAME INTEGER,  

    USER_ VARCHAR(50),  

    CONSTRAINT FK_TUSER FOREIGN KEY(USER_) REFERENCES TUSER(USER_),CONSTRAINT FK_TROLE FOREIGN KEY(ID_ROLENAME) REFERENCES TROLE(ID_ROLENAME)  

 );  

ALTER TABLE TUSER_ROLE ALTER COLUMN ID_USER_ROLE RESTART WITH 1;  

ALTER SEQUENCE public.tuser_role_id_user_role_seq RESTART 12; 

  

  

  

CREATE TABLE IF NOT EXISTS TSERVER_PERMISSION(  

  

    ID_SERVER_PERMISSION INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,  

  

    PERMISSION_NAME VARCHAR(10485760)  

  

);  

  

  

  

CREATE TABLE IF NOT EXISTS TROLE_SERVER_PERMISSION (  

  

    ID_ROLE_SERVER_PERMISSION INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,  

  

    ID_ROLENAME INTEGER,ID_SERVER_PERMISSION INTEGER,  

  

    CONSTRAINT FK_TROLE_SERVER_PERMISSION FOREIGN KEY(ID_ROLENAME) REFERENCES TROLE(ID_ROLENAME),CONSTRAINT FK_TSERVER_PERMISSION FOREIGN KEY(ID_SERVER_PERMISSION) REFERENCES TSERVER_PERMISSION(ID_SERVER_PERMISSION)  

  

);  

  

  

  

  

  

INSERT INTO customer VALUES   

   (0,'demo','administrador','34567123D','Calle Rosas, 2','666777888', 'demo@administrador.com'),  

    (1,'customer','customer','36789654G','Calle Amapola, 4','654245222','customer@clientes.com'),  

    (2,'Manolo','Rodriguez Lopez','49736530L','Calle de la Amargura, 35, 2A','654562585','manolo.rodriguez@clientes.com'),  

    (3,'Francisco','Martinez Gomez','11713669E','Calle del Medio, 18, 3B','652356987','francisco.martinez@clientes.com'),  

    (4,'Lucia','Estevez Morales','93593647T','Calle Doblando Esquina, 9, 5A','653125879','lucia.estevez@clientes.com'),  

    (5,'Maria','Iglesias Seoane','38828031Y','Calle del Poeta Callado, 35, 2A','654562585','maria.iglesias@clientes.com'),  

    (6,'Mario','Fernandez Rodriguez', '89453863D','Calle del Final del Camino, 142, 7C','664521785','mario.fernandez@clientes.com'),  

    (7,'Fernando','Perez Gonzalez','03065097W','Plaza de la Rotonda Cuadrada, 12, 5B','675259745','fernando.perez@clientes.com'),  

    (8,'Antonio','Rodriguez De La Torre','22624818V','Travesía del Polígono, 157, 4A','654854129','antonio.rodriguez@clientes.com'),  

    (9,'Pedro','Vazquez Romero', '75287699M','Plaza de la Fuente Seca, 49, 9D','672587125','pedro.vazquez@clientes.com'),   

    (10,'Azucena','Ibañez Pedrido','10046318X','Plaza de los Héroes de la Patria, 5, 1C','677562417','azucena.ibañez@clientes.com'),  

    (11,'Encarnacion','Lopez Regueiro','62169159K','Calle del Edificio, 214, 9C','678658754','encarnacion.lopez@clientes.com') 

ON CONFLICT DO NOTHING;    

  

  

  

  

  

  

  

  

  

INSERT INTO TUSER VALUES  

('demo','demouser',NULL,NULL,NULL,0),  

 ('customer', 'customeruser',  NULL, NULL, NULL,1), 

('Manolo.Rodriguez','49736530L',NULL,NULL,NULL,2),     ('Francisco.Martinez','11713669E',NULL,NULL,NULL,3),    ('Lucia.Estevez','93593647T',NULL,NULL,NULL,4),  

('Maria.Iglesias','38828031Y',NULL,NULL,NULL,5), 

('Mario.Fernandez', '89453863D',NULL,NULL,NULL,6),    ('Fernando.Perez','03065097W',NULL,NULL,NULL,7),      ('Antonio.Rodriguez','22624818V',NULL,NULL,NULL,8), 

('Pedro.Vazquez', '75287699M',NULL,NULL,NULL,9),      ('Azucena.Ibañez','10046318X',NULL,NULL,NULL,10),     ('Encarnacion.Lopez','62169159K',NULL,NULL,NULL,11)  

ON CONFLICT DO NOTHING;  

  

  

  

INSERT INTO TROLE VALUES  

  

   (0,'admin','<?xml version="1.0" encoding="UTF-8"?><security></security>', '{"menu":[{"attr": "customers-home", "visible": false, "enabled": false },{ "attr": "books", "visible": true, "enabled": true },{ "attr": "customers", "visible": true, "enabled": true},{ "attr": "reservations", "visible": true, "enabled": true },{ "attr": "lendings", "visible": true, "enabled": true},{ "attr": "customers-lendings", "visible": false, "enabled": false},{ "attr": "customers-reservations", "visible": false, "enabled": false}, { "attr": "customers-customers", "visible": false, "enabled": false}]} '),  

  

   (1, 'public', '<?xml version="1.0" encoding="UTF-8"?><security></security>', '{"components":[{"attr":"booksTable", "selector":"o-table", "columns":[{"attr":"BOOKTITLE", "visible":true, "enabled":true},{"attr":"BOOKAUTHOR", "visible":true, "enabled":true},{"attr":"BOOKISBN", "visible":true, "enabled":true},{"attr":"BOOKEDITORIAL", "visible":true, "enabled":true}],"actions":[{"attr":"insert", "visible":false, "false":false},{"attr":"refresh", "visible":false, "enabled":false}]},{"attr":"copysTable", "selector":"o-table", "columns":[{"attr":"COPYCODE", "visible":true, "enabled":true},{"attr":"SHELVINGPUBLICNAME", "visible":true, "enabled":true},{"attr":"COPYNOTES", "visible":true, "enabled":true}],"actions":[{"attr":"insert", "visible":false, "false":false}]},{"attr":"books_form_detail","selector": "o-form","actions": [{ "attr": "update", "visible": false, "enabled": false }]},{"attr":"listCopies", "selector":"o-table", "columns":[{"attr":"COPYCODE", "visible":true, "enabled":true},{"attr":"BOOKTITLE", "visible":true, "enabled":true},{"attr":"COPYNOTES", "visible":true, "enabled":true}],"actions":[{"attr":"insert", "visible":false, "enabled":false}]}],"menu":[{"attr":"home", "visible":false, "enabled":false },{"attr":"books", "visible":true, "enabled":true },{"attr":"customers", "visible":false, "enabled":false},{"attr":"reservations", "visible":false, "enabled":false},{"attr":"lendings", "visible":false, "enabled":false}]} ')  

  

    ON CONFLICT DO NOTHING;  

  

  

  

INSERT INTO TUSER_ROLE VALUES  

  

(0,0,'demo'),  

  

(1, 1, 'customer'),  

  

(2,1, 'Manolo.Rodriguez'),   

  

(3,1,'Francisco.Martinez'),   

  

(4,1,'Lucia.Estevez'),  

  

(5,1,'Maria.Iglesias'),  

  

(6,1,'Mario.Fernandez'),  

  

(7,1,'Fernando.Perez'),  

  

(8,1,'Antonio.Rodriguez'),  

  

(9,1,'Pedro.Vazquez'),  

  

(10,1,'Azucena.Ibañez'),  

  

(11,1,'Encarnacion.Lopez')  

  

ON CONFLICT DO NOTHING;  

  

  

  

INSERT INTO TSERVER_PERMISSION VALUES  

  

(1, 'model.core.service.BookService/bookQuery'),  

  

(2, 'model.core.service.BookService/bookInsert'),  

  

(3, 'model.core.service.BookService/bookUpdate'),  

  

(4, 'model.core.service.CopyService/copyQuery'),  

  

(5, 'model.core.service.CopyService/copyInsert'),  

  

(6, 'model.core.service.CopyService/copyUpdate'),  

  

(7, 'model.core.service.CopyService/copyDelete'),  

  

(8, 'model.core.service.LendingService/lendingQuery'),  

  

(9, 'model.core.service.LendingService/lendingInsert'),  

  

(10, 'model.core.service.LendingService/lendingUpdate'),  

  

(11, 'model.core.service.LendingService/lendingDelete'),  

  

(12, 'model.core.service.CustomerService/customerQuery'),  

  

(13, 'model.core.service.CustomerService/customerInsert'),  

  

(14, 'model.core.service.CustomerService/customerUpdate'),  

  

(15, 'model.core.service.CustomerService/customerDelete')  

  

ON CONFLICT DO NOTHING;  

  

  

  

  

  

  

  

INSERT INTO TROLE_SERVER_PERMISSION VALUES  

  

(1, 0, 1),  

  

(2, 0, 2),  

  

(3, 0, 3),  

  

(4, 1, 1),  

  

(5, 0, 4),  

  

(6, 0, 5),  

  

(7, 0, 6),  

  

(8, 0, 7),  

  

(9, 1, 4),  

  

(10, 0, 8),  

  

(11, 0, 9),  

  

(12, 0, 10),  

  

(13, 0, 11),  

  

(14, 1, 8),  

  

(15, 0, 12),  

  

(16, 0, 13),  

  

(17, 0, 14),  

  

(18, 0, 15), 

 

(19, 1, 12), 

 

(20, 1, 14) 

 

  

  

ON CONFLICT DO NOTHING;  

  

  

  

  

  

  

  

INSERT INTO book VALUES     

  

    (1,'Delparaíso','Delparaíso es un lugar seguro, vigilado las 24 horas, lujoso e inexpugnable. Sin embargo, sus muros no protegen del miedo, del amor, de la tristeza, del deseo y de la muerte.','Juan del Val',312,'9788467061130','Espasa',1,'2021'),     

  

    (2,'Los ojos cerrados','Los ojos cerrados es una novela de un solo lugar, un pueblo que podría tener cualquier nombre y que por eso se llama Pueblo Chico. Pueblo Chico está anclado en una sierra agreste…','Edurne Portela',208,'9788418526206','Galaxia Gutenberg ',1,'2021'),     

  

    (3,'Exi. Bienvenidos a Glitch City','¡Soy Exi! Puede que me conozcas por mi canal de YouTube, donde hago muchas cosas locas, hay salseo, nos reímos un montón y… ¡Eh! ¡No! Espera, deja el móvil…','Exi',176,'9788408240389','Destino Infantil & Juvenil', 1,'2021'),     

  

    (4,'El Evangelio','Mundo maldito, llévame a mí si quieres que ya estoy podrida de todas formas pero no me chafes a Alberto, a Alberto déjamelo tranquilo dando saltos en su casa vestido de gato…','Elisa Victoria',312,'9788418187803','Blackie Books',1,'2021'),     

  

    (5,'¡Es la microbiota, idiota!','Descubre cómo tu salud depende de los billones de microorganismos que habitan en tu cuerpo','Sari Arponen',368,'9788413440682','Alienta Editorial',1,'2021'),   

  

    (6,'SIRA','La Segunda Gran Guerra llega a su fin y el mundo emprende una tortuosa reconstrucción. Concluidas sus funciones como colaboradora de los Servicios Secretos británicos...','Maria Dueñas',648,'9788408241911','Planeta',1,'2021'),   

  

    (7,'El Invencible','El Invencible es el nombre de la enorme nave interestelar que parte hacia el rescate de su gemela, la impresionante y guerrera El Cóndor, que se haya varada en Regis III.','Stanislaw Lem',264,'9788417553937','Impedimenta',2,'2021'),   

  

    (8,'Las Medallas de Mercurio','El mercurio es uno de esos escasos metales que se encuentran en estado líquido a temperatura ambiente. Contradice nuestras ideas habituales, y utilizarlo para fabricar medallas sería absurdo.','Pablo Escudero Abenza',178,'9788466937153','Complutense Ediciones',3,'2020')  

  

    ON CONFLICT DO NOTHING;  

  

  

  

   

  

INSERT INTO copy VALUES    

  

   (1,1, 'Buen estado',12345),     

  

    (2,1, 'Buen estado',23456),    

  

    (3,2, 'Buen estado',34567),    

  

    (4,2, 'Buen estado',45678),    

  

    (5,3, 'Buen estado',56789),    

  

    (6,4, 'Mal estado(Mojado)',67890),      

  

    (7,5, 'Buen estado',78901),      

  

    (8,5, 'Buen estado',89012),    

  

    (9,5, 'Buen estado',12456),    

  

    (10,5, 'Buen estado',23567),    

  

    (11,6, 'Buen estado',34678),    

  

    (12,7, 'Buen estado',45789),    

  

    (13,7, 'Buen estado',56890),    

  

    (14,8, 'Buen estado',67901),    

  

    (15,8, 'Buen estado',13456),    

  

    (16,8, 'Buen estado',24567),    

  

    (17,8, 'Buen estado',35678),    

  

    (18,8, 'Buen estado',46789)  

  

    ON CONFLICT DO NOTHING;  

  

  

  

  

  

INSERT INTO lending VALUES      

  

    (1,2,'2021-04-28','2021-05-13', '2021-05-05', 'Entregado en buen estado'),     

  

    (2,3,'2021-04-28','2021-05-13', '2021-05-15', 'Entregado en mal estado(mojado), 2 dias tarde'),     

  

    (3,1,'2021-04-01','2021-04-15', NULL, NULL ),     

  

    (4,6,'2021-04-03','2021-04-18', NULL, NULL ),     

  

    (5,1,'2021-04-09','2021-04-24',NULL, NULL),     

  

    (6,5,'2021-05-01','2021-05-15','2021-05-12', 'Entregado en buen estado'),    

  

    (7,4,'2021-05-12','2021-05-27',NULL,NULL)  

  

    ON CONFLICT DO NOTHING;    

  

  

  

INSERT INTO copyLending VALUES   

  

    (1,1,1),    

  

    (2,3,1),    

  

    (3,5,1),    

  

    (4,2,2),    

  

    (5,5,3),   

  

    (6,6,4),    

  

    (7,11,5),    

  

    (8,14,6),    

  

    (9,14,7),    

  

    (10,10,7)  

  

    ON CONFLICT DO NOTHING;   

  

  

  

  

  

INSERT INTO reservation VALUES   

  

    (1,6,7,11,'2021-06-01')  

  

    ON CONFLICT DO NOTHING;   

  

  

  

  

  

INSERT INTO shelving VALUES    

  

    (1,'lendings'),   

  

    (2,'reservations')  

  

    ON CONFLICT DO NOTHING;   

  

  

  

INSERT INTO copyshelving VALUES   

  

    (1,1,1),   

  

    (2,1,2),   

  

    (3,1,3),   

  

    (4,1,4),   

  

    (5,1,5),   

  

    (6,1,6),   

  

    (7,1,7),   

  

    (8,1,8),   

  

    (9,1,9),   

  

    (10,1,10),   

  

    (11,2,11),   

  

    (12,1,12),   

  

    (13,1,13),   

  

    (14,1,14),   

  

    (15,1,15),   

  

    (16,1,16),   

  

    (17,1,17),   

  

    (18,1,18)  

  

    ON CONFLICT DO NOTHING; 