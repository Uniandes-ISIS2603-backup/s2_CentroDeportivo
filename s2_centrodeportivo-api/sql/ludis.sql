delete from SeguimientoEntity;
delete from EjercicioEntity;
delete from EspecialistaEntity;
delete from ImplementoEntity;
delete from MaquinaEntity;
delete from ObjetivoEntity;
delete from RutinaEntity;
delete from ZonacuerpoEntity;
delete from DeportistaEntity;


 -- POBLAMIENTO TABLA DEPORTISTA
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values 
(1, 11, 'Jessee Templeton', 1, 1.59, 80.46, 82, 265, 1.69, 1.11, 1.76, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (2, 12, 'Brandise Beaven', 0, 1.25, 86.6, 92, 117, 1.33, 3.63, 1.9, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (3, 13, 'Jamie Archambault', 0, 1.81, 124.72, 66, 126, 1.85, 3.84, 1.59, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (4, 14, 'Terrie Jovanovic', 0, 1.47, 93.27, 61, 180, 1.39, 1.31, 1.29, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (5, 15, 'Melinde De Laci', 0, 1.41, 96.26, 61, 280, 2.0, 3.64, 1.03, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (6, 16, 'Edwina Perell', 0, 1.94, 126.24, 70, 109, 1.05, 1.88, 1.35, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (7, 17, 'Broddie Starking', 1, 1.74, 98.19, 44, 251, 1.42, 1.55, 1.0,'1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento)
 values (8, 18, 'Vasili McAulay', 1, 1.83, 106.82, 29, 211, 1.89, 3.47, 1.17, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento) 
values (9, 19, 'Ingelbert Daud', 1, 1.1, 104.18, 51, 117, 1.4, 1.91, 1.77, '1985-11-20 00:00:00');
insert into DeportistaEntity (id, cedula, nombre, sexo, altura, presionSanguinea, peso, ritmoCardiaco, medidaPiernas, medidaCintura, medidaBrazos, fechaNacimiento)
 values (10, 20, 'Estel Pitcher', 0, 1.08, 83.28, 48, 40, 1.9, 2.36, 1.29, '1985-11-20 00:00:00');

 --POBLAMIENTO TABLA EJERCICIO
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (1, 'Remo', 'pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi', 1, 1, 'pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor', 'dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (2, 'Press Pecho', 'nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at', 2, 2, 'nibh in quis justo maecenas rhoncus aliquam lacus morbi quis', 'blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (3, 'Lift mancuerna', 'sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis', 3, 3, 'elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante', 'dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (4, 'Dominadas', 'elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla', 4, 4, 'aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non', 'maecenas ut massa quis augue luctus tincidunt nulla mollis molestie');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (5, 'Sentadillas', 'at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis', 5, 5, 'orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi', 'augue luctus tincidunt nulla mollis molestie lorem quisque ut erat');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (6, 'Cardio', 'scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec', 6, 6, 'posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et', 'dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (7, 'Remo', 'felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet', 7, 7, 'congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl', 'convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (8, 'Lift barra', 'mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse', 8, 8, 'nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin', 'iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (9, 'Lift alternado', 'tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis', 9, 9, 'et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc', 'nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit');
insert into ejercicioEntity (id, nombre, categoria, duracion, numeroDeSeries, descripcion, explicacion) values (10, 'Lagartijas', 'magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum', 10, 10, 'duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim', 'aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi');

 --POBLAMIENTO TABLA ESPECIALISTA
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (1, 'Accounting', 'Farrel Upstone', 8056768, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (2, 'Accounting', 'Bellina Addlestone', 1667650, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (3, 'Accounting', 'Willie Stave', 750498, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (4, 'Legal', 'Tilda Ianne', 3744463, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (5, 'Legal', 'Elsi Purches', 3355656, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (6, 'Legal', 'Lauryn Larkin', 3056820, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (7, 'Human Resources', 'Angy Drissell', 168751, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (8, 'Human Resources', 'Lawrence Bothie', 8582383, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (9, 'Human Resources', 'Whit Ford', 721831, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');
insert into especialistaEntity (id, Especialidad, nombre, Cedula, imagen) values (10, 'Human Resources', 'Alberto Chiechio', 5985083, 'https://png.pngtree.com/element_origin_min_pic/16/09/07/0957cf724d9c465.jpg');

 --POBLAMIENTO TABLA IMPLEMENTO
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (1, 'dui vel', 32, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (2, 'ultrices', 32, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (3, 'aliquet', 15, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (4, 'ante', 32, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (5, 'vel', 27, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (6, 'vulputate justo', 33, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (7, 'blandit mi', 25, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (8, 'faucibus accumsan', 16, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (9, 'vivamus vestibulum', 32, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');
insert into ImplementoEntity (id, nombre, cantidadExistencias, imagen) values (10, 'eu felis', 10, 'https://banner2.kisspng.com/20180402/rae/kisspng-barbell-weight-training-dumbbell-physical-fitness-weights-5ac2504ebc0714.6438486515226839827702.jpg');

 --POBLAMIENTO TABLA ZONA_CUERPO
insert into zonaCuerpoEntity (id, nombre) values (1, 'Brazo');
insert into zonaCuerpoEntity (id, nombre) values (2, 'Cuadricep');
insert into zonaCuerpoEntity (id, nombre) values (3, 'Bicep');
insert into zonaCuerpoEntity (id, nombre) values (4, 'pecho');
insert into zonaCuerpoEntity (id, nombre) values (5, 'tricep');
insert into zonaCuerpoEntity (id, nombre) values (6, 'Gluteos');
insert into zonaCuerpoEntity (id, nombre) values (7, 'Antebrazo');
insert into zonaCuerpoEntity (id, nombre) values (8, 'Abdomianles');
insert into zonaCuerpoEntity (id, nombre) values (9, 'Hombro');
insert into zonaCuerpoEntity (id, nombre) values (10, 'Espalda');

 --POBLAMIENTO TABLA OBJETIVO
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (1, 'Right-sized context-sensitive encryption', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (2, 'Vision-oriented contextually-based function', 1, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (3, 'Integrated human-resource solution', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (4, 'Implemented next generation ability', 1,'1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (5, 'Reverse-engineered 24 hour migration', 1, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (6, 'Extended foreground solution', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (7, 'Front-line radical open architecture', 1, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (8, 'Public-key mobile Graphical User Interface', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (9, 'Persevering object-oriented access', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite) values (10, 'Function-based maximized project', 0, '1985-11-20 00:00:00');
insert into ObjetivoEntity (id, descripcion, cumplio, fechaLimite, deportista_id) values (11, 'Prueba', 0, '1985-11-20 00:00:00',1);

 --POBLAMIENTO TABLA MAQUINA
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (1, 'Caminadora', '12334', 'https://bodytech.com.co/uploads/complementaryservice/72a941c8e0574edfa2d77a182c1b5961/bodytech_zona_cardiovascular.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (2, 'Eliptica', '4542', 'http://thedailywrite.net/wp-content/uploads/2018/02/spin.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (3, 'Multifuerza', '3526', 'https://bodytech.com.co/uploads/complementaryservice/da5773daf4e246b783922d904ac78bd1/bodytech_zona_musculacion.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (4, 'Maquina para abdomen', '325345', 'https://bodytech.com.co/uploads/complementaryservice/59931bdc633c4e36b5f815e4b2e490c2/bodytech_abdomen_estiramiento1920x622.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (5, 'Multifuerza', '25896', 'https://www.telegraph.co.uk/content/dam/luxury/2017/03/21/Gym_2-xlarge_trans_NvBQzQNjv4BqgsaO8O78rhmZrDxTlQBjdGcv5yZLmao6LolmWYJrXns.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (6, 'Caminadora', '98756', 'http://www.fitness4all.es/arturo-soria/wp-content/uploads/sites/2/2014/03/gym1.jpg' );
insert into MAQUINAENTITY (id, nombre, referencia, imagen) values (7, 'Eliptica', '2353', 'https://d2s0f1q6r2lxto.cloudfront.net/pub/ProTips/wp-content/uploads/2016/12/intro-to-spinning-and-indoor-cycling.jpg' );



 --POBLAMIENTO TABLA RUTINA
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (1, 1, 'Diplock', 1);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (2, 1, 'Farnworth', 2);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (3, 1, 'Banane', 3);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (4, 0, 'Flobert', 4);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (5, 1, 'Keemer', 5);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (6, 0, 'Yushmanov', 6);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (7, 0, 'Simon', 7);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (8, 0, 'Vallender', 8);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (9, 1, 'Idle', 9);
insert into rutinaEntity (id, estadoTerminado, nombre, identificadorRutina) values (10, 1, 'Marsie', 10);

