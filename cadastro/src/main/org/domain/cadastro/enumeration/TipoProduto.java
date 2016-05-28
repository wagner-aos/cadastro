package org.domain.cadastro.enumeration;

public enum TipoProduto {
	
		APARELHO("APARELHO"), 
		SIMCARD("SIMCARD"), 
		CARTAO("CARTÃO");

		private String nome;

		TipoProduto(String nome) {
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

	}

