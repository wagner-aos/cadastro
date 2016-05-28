/*========================================================================================*
	Script de implantação do sistema de cadastro de Produtos.
	Teste para a empresa Ventron.
	Data: 28/05/2016
	Autor: Wagner Alves de Oliveira Silva
==========================================================================================*/

use ventron;

INSERT INTO `ventron`.`Categoria` (`id`,`codigo`,`descricao`)VALUES
(1,"101","Aparelho de telefone celular"),
(2,"102","Chip de Operadora"),
(3,"103","Cartao de Memória"),
(4,"104","Telefonia"),
(5,"105","Armazenamento");

INSERT INTO `ventron`.`Fabricante` (`id`,`codigo`,`descricao`)VALUES
(1,"11","Apple"),
(2,"12","Sansung"),
(3,"13","Vivo"),
(4,"14","Kingston");

/*=================================== END OF SCRIPT =======================================*/
