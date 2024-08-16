package rocha.guilherme.jose.model;

public class ModelJogo {

	private int quantVitoriaX;
	private int quantVitoriaO;
	private int quantEmpates;
	private int resultado;
	private int numeroDeX;
	private int numeroDeO;
	private String campo[][];
	
	public ModelJogo() {
		campo = new String[3][3];
		iniciarJogo();
	}

	public void iniciarJogo() {
		this.numeroDeX = 0;
		this.numeroDeO = 0;
		
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				campo[linha][coluna] = "";
			}
		}
	}
	
	public int getQuantVitoriaX() {
		return quantVitoriaX;
	}

	public void setQuantVitoriaX(int quantVitoriaX) {
		this.quantVitoriaX = quantVitoriaX;
	}

	public int getQuantVitoriaO() {
		return quantVitoriaO;
	}

	public void setQuantVitoriaO(int quantVitoriaO) {
		this.quantVitoriaO = quantVitoriaO;
	}

	public int getQuantEmpates() {
		return quantEmpates;
	}

	public void setQuantEmpates(int quantEmpates) {
		this.quantEmpates = quantEmpates;
	}

	public int getNumeroDeX() {
		return numeroDeX;
	}
	
	public void setNumeroDeX(int numeroDeX) {
		this.numeroDeX = numeroDeX;
	}
	
	public int getNumeroDeO() {
		return numeroDeO;
	}
	
	public void setNumeroDeO(int numeroDeO) {
		this.numeroDeO = numeroDeO;
	}
	
	public String getCampo(int linha, int coluna) {
		return campo[linha][coluna];
	}
	
	public void setCampo(int linha, int coluna, String jogador) {
		this.campo[linha][coluna] = jogador;
	}
	
	public int getResultado() {
		resultadoJogo();
		return resultado;
	}
	
	public void atualizarResultado() {
		if(resultado == 1) {
			setQuantVitoriaX(getQuantVitoriaX() + 1);
		}
		
		if(resultado == 2) {
			setQuantVitoriaO(getQuantVitoriaO() + 1);
		}
		
		if(resultado == 0) {
			setQuantEmpates(getQuantEmpates() + 1);
		}
	}
	
	/** @note O zero(0) é retornado quando dar empate*/
	private void resultadoJogo() {
		this.resultado = ganhouHorizontal() != 0 ? ganhouHorizontal() : 
			ganhouVertical() != 0 ? ganhouVertical() : 
			ganhouDiagonal() != 0 ? ganhouDiagonal() : 
			tabuleiroPreenchido() ? 0 : -1;
	}

	private int ganhouHorizontal() {
		int quantidadeX = 0;
		int quantidadeO = 0;
		
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				quantidadeX = compararCampoX(linha, coluna, quantidadeX);
				quantidadeO = compararCampoO(linha, coluna, quantidadeO);
			}
			
			if(verificarResultado(quantidadeX, quantidadeO) != 0) {
				return verificarResultado(quantidadeX, quantidadeO);
			}
			
			quantidadeX = 0;
			quantidadeO = 0;
		}
		
		return 0;
	}

	private int ganhouVertical() {
		int quantidadeX = 0;
		int quantidadeO = 0;
		
		for(int coluna = 0; coluna < 3; coluna++) {
			for(int linha = 0; linha < 3; linha++) {
				quantidadeX = compararCampoX(linha, coluna, quantidadeX);
				quantidadeO = compararCampoO(linha, coluna, quantidadeO);
			}
			
			if(verificarResultado(quantidadeX, quantidadeO) != 0) {
				return verificarResultado(quantidadeX, quantidadeO);
			}
			
			quantidadeX = 0;
			quantidadeO = 0;
		}
		
		return 0;
	}
	
	private int ganhouDiagonal() {
		int quantidadeX = 0;
		int quantidadeO = 0;
		
		if(diagonalDeCimaParaBaixo(quantidadeX, quantidadeO) != 0) {
			return diagonalDeCimaParaBaixo(quantidadeX, quantidadeO);
		}
		
		quantidadeX = 0;
		quantidadeO = 0;
		
		if(diagonalDeBaixoParaCima(quantidadeX, quantidadeO) != 0) {
			return diagonalDeBaixoParaCima(quantidadeX, quantidadeO);
		}
		
		return 0;
	}

	private int diagonalDeCimaParaBaixo(int quantidadeX, int quantidadeO) {
		for(int linha = 0; linha < 3; linha++) {
			quantidadeX = compararCampoX(linha, linha, quantidadeX);
			quantidadeO = compararCampoO(linha, linha, quantidadeO);
		}
		
		return verificarResultado(quantidadeX, quantidadeO);
	}
	
	private int diagonalDeBaixoParaCima(int quantidadeX, int quantidadeO) {
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 2; coluna >= 0; coluna--) {
				if(linha + coluna == 2) {
					quantidadeX = compararCampoX(linha, coluna, quantidadeX);
					quantidadeO = compararCampoO(linha, coluna, quantidadeO);
				}
			}
		}
		
		return verificarResultado(quantidadeX, quantidadeO);
		
	}
	
	private int compararCampoX(int linha, int coluna, int quantidadeX) {
		if(campo[linha][coluna].equals("X")) {
			quantidadeX += 1;
		}
		
		return quantidadeX;
	}
	
	private int compararCampoO(int linha, int coluna, int quantidadeO) {
		if(campo[linha][coluna].equals("O")) {
			 quantidadeO += 1;
		}
		
		return quantidadeO;
	}
	
	private int verificarResultado(int quantidadeX, int quantidadeO) {
		if(quantidadeX == 3) return 1;
		if(quantidadeO == 3) return 2;
		return 0;
	}
	
	private boolean tabuleiroPreenchido() {
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				if(campo[linha][coluna].equals("")) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
