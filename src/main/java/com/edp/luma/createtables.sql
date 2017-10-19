CREATE DATABASE IF NOT EXISTS java_am;

USE java_am;

CREATE TABLE IF NOT EXISTS Atendentes  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) null,
cpf varchar(255) null,
rg varchar(255) null,
endereco varchar(255) null,
ativo tinyint(1) null
);

CREATE TABLE IF NOT EXISTS atendimentos  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
atendente_id int null,
cliente_id int null,
local_id int null,
ocorrencia_id int null,
temp_atendimento float null,
data date null,
avaliacao varchar(255) null
);

CREATE TABLE IF NOT EXISTS clientes  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) null,
email varchar(255) null,
telefone varchar(255) null,
cpf varchar(255) null,
login varchar(255) null,
senha varchar(255) null
);

CREATE TABLE IF NOT EXISTS locais  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
pais varchar(255) null,
cidade varchar(255) null,
bairro varchar(255) null,
rua varchar(255) null,
n_residencia varchar(255) null
);

CREATE TABLE IF NOT EXISTS OCORRENCIAS  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
TIPO_OCORRENCIA varchar(255) null,
CRITICIDADE varchar(255) null,
SINTOMA varchar(255) null,
LOCAL_ID int null,
`DATA` varchar(255) null,
TEMPO_TRATATIVA varchar(255) null
);

CREATE TABLE IF NOT EXISTS USERPERMISSIONS  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
TIPO_PERMISSAO int null,
TIPO_PESSOA varchar(255) null
);

CREATE TABLE IF NOT EXISTS EDP_USERTYPE  (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
USERTYPEID int null,
USERTYPE varchar(255) null
);
