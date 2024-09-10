CREATE DATABASE hospital;
USE hospital;

CREATE TABLE Especialidades
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255)
);

CREATE TABLE PlanosDeSaude
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255)
);

CREATE TABLE FichaPaciente
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    nomePaciente        VARCHAR(255),
    numeroCarteiraPlano VARCHAR(255),
    idPlanoDeSaude      INT,
    idEspecialidade     INT,
    FOREIGN KEY (idPlanoDeSaude) REFERENCES PlanosDeSaude (id),
    FOREIGN KEY (idEspecialidade) REFERENCES Especialidades (id),
    UNIQUE (numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade)
);
insert into Especialidades (nome)
values ("Cardiologia");
insert into Especialidades (nome)
values ("Neurologia");
insert into Especialidades (nome)
values ("Ortopedia");
insert into Especialidades (nome)
values ("Pediatria");
insert into Especialidades (nome)
values ("Dermatologia");

insert into PlanosDeSaude (nome)
values ("Amil");
insert into PlanosDeSaude (nome)
values ("Unimed");
insert into PlanosDeSaude (nome)
values ("Hapvida");
insert into PlanosDeSaude (nome)
values ("SulAmerica");
insert into PlanosDeSaude (nome)
values ("Bradesco");

insert into FichaPaciente (nomePaciente, numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade)
values ("Leandro Ribeiro", "3248", 1, 5);
insert into FichaPaciente (nomePaciente, numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade)
values ("Ana Maria", "2615", 2, 2);
insert into FichaPaciente (nomePaciente, numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade)
values ("Joaerson Barbosa", "8143", 1, 1);
insert into FichaPaciente (nomePaciente, numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade)
values ("Juliana Chaves", "2000", 3, 4);

select * from Especialidades;
select * from PlanosDeSaude;
select * from fichapaciente;