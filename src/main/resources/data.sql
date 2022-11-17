drop table if exists `departamentos`;
create table `departamentos`(
`id` int not null auto_increment primary key,
`nombre` varchar(100) not null,
`presupuesto` varchar(100) not null 
);

drop table if exists `empleados`;
create table `empleados`(
`id` int not null auto_increment primary key,
`nombre` varchar(100) not null ,
`apellidos` varchar(100) not null ,
`departamento` int not null,
CONSTRAINT `departamentos_fk` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`id`)
);

insert into departamentos(nombre,presupuesto) values ('central',4141),('recursos humanos',6777),('programacion',1222);
insert into empleados(nombre,apellidos,departamento) values ('carlos','milonga',1),('carla','castro',2),('laura','castaño',3);