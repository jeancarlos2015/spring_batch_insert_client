package br.com.jeancarlos.spring_batch_v5.model;

public class Cliente {
    private String nome;
	private String descricao;
	private boolean publico;

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}





	
	@Override
	public String toString() {
		return "Cliente{" +
	                "nome='" + nome + "'" +
	                ", descricao ='" + descricao + "'" +
	                ", publico='" + publico + "'" +
	                '}';
	}
}
