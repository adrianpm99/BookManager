INSERT INTO TUSER VALUES 

    ('demo','demouser','demo','demo',NULL,'44460713B',NULL,NULL,NULL) 

    ON CONFLICT DO NOTHING; 

INSERT INTO TROLE VALUES 

    (0,'admin','<?xml version="1.0" encoding="UTF-8"?><security></security>') 

    ON CONFLICT DO NOTHING; 

INSERT INTO TUSER_ROLE VALUES 

    (0,0,'demo') 

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

INSERT INTO customer VALUES  

    (1,'Manolo','Rodriguez Lopez','32578945A','Calle de la Amargura, 35, 2A','654562585','manolo.rodriguez@clientes.com'), 

    (2,'Francisco','Martinez Gomez','3352145B','Calle del Medio, 18, 3B','652356987','francisco.martinez@clientes.com'), 

    (3,'Lucia','Estevez Morales','44844546','Calle Doblando Esquina, 9, 5A','653125879','lucia.estevez@clientes.com'), 

    (4,'Maria','Iglesias Seoane','32578945A','Calle del Poeta Callado, 35, 2A','654562585','manolo.rodriguez@clientes.com'), 

    (5,'Mario','Fernandez Rodriguez','33547812Z','Calle del Final del Camino, 142, 7C','664521785','mario.fernandez@clientes.com'), 

    (6,'Fernando','Perez Gonzalez','44855462W','Plaza de la Rotonda Cuadrada, 12, 5B','675259745','fernando.perez@clientes.com'), 

    (7,'Antonio','Rodriguez De La Torre','33589745K','Travesía del Polígono, 157, 4A','654854129','antonio.rodriguez@clientes.com'), 

    (8,'Pedro','Vazquez Romero','32558784L','Plaza de la Fuente Seca, 49, 9D','672587125','pedro.vazquez@clientes.com'), 

    (9,'Azucena','Ibañez Pedrido','44866157M','Plaza de los Héroes de la Patria, 5, 1C','677562417','azucena.ibañez@clientes.com'), 

    (10,'Encarnacion','Lopez Regueiro','33547852P','Calle del Edificio, 214, 9C','678658754','manolo.rodriguez@clientes.com') 

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

    (4,2,4),  

    (5,2,5),  

    (6,2,6),  

    (7,1,7),  

    (8,1,8),  

    (9,1,9),  

    (10,2,10),  

    (11,2,11),  

    (12,2,12),  

    (13,1,13),  

    (14,1,14),  

    (15,1,15),  

    (16,2,16),  

    (17,2,17),  

    (18,2,18) 

    ON CONFLICT DO NOTHING; 