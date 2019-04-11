create database agenda;
use agenda;

create table contato(id_contato int not null primary key auto_increment,
					 nome varchar(20) not null,
                     telefone varchar(20) not null,
                     email varchar(20) not null,
                     data_nasc varchar(20) not null
                     );

create table compromissos(id_co int not null primary key auto_increment,
						  id_contato int not null,
						  data_co varchar(20) not null,
                          hora varchar(20) not null,
                          descricao varchar(20) not null,
                          constraint fk_contato_compromisso foreign key(id_contato) references contato(id_contato));

desc contato;
select * from contato;
select * from compromissos;
insert into compromissos values(null,1,'08/04/2019','19:00','Negocios');

