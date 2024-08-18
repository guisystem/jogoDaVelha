package rocha.guilherme.jose.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelJogoTeste {

	private ModelJogo jogo;
	
	@BeforeEach
	void iniciar() {
		jogo = new ModelJogo();
	}
	
	@Test
	void testarIniciarJogo() {
		String campo = jogo.getCampo(0, 0);
		assertEquals("", campo);
	}
	
	@Test
	void testarSetVitoriaX() {
		jogo.setQuantVitoriaX(1);
		assertEquals(1, jogo.getQuantVitoriaX());
	}
	
	@Test
	void testarSetVitoriaO() {
		jogo.setQuantVitoriaO(2);
		assertEquals(2, jogo.getQuantVitoriaO());
	}
	
	@Test
	void testarSetEmpates() {
		jogo.setQuantEmpates(3);
		assertEquals(3, jogo.getQuantEmpates());
	}
	
	@Test
	void testarSetNumeroX() {
		jogo.setNumeroDeX(4);
		assertEquals(4, jogo.getNumeroDeX());
	}
	
	@Test
	void testarSetNumeroO() {
		jogo.setNumeroDeO(5);
		assertEquals(5, jogo.getNumeroDeO());
	}
	
	@Test
	void testarSetCampo() {
		jogo.setCampo(2, 2, "O");
		assertEquals("O", jogo.getCampo(2, 2));
	}
	
	@Test
	void testarAtualizarResultadoX() {
		jogo.setCampo(0, 0, "X");  // X X X
		jogo.setCampo(0, 1, "X");  // - - -
		jogo.setCampo(0, 2, "X");  // - - -
		
		jogo.getResultado();
		jogo.atualizarResultado();
		
		assertEquals(1, jogo.getQuantVitoriaX());
	}
	
	@Test
	void testarAtualizarResultadoO() {
		jogo.setCampo(0, 0, "O");  // O O O
		jogo.setCampo(0, 1, "O");  // - - -
		jogo.setCampo(0, 2, "O");  // - - -
		
		jogo.getResultado();
		jogo.atualizarResultado();
		
		assertEquals(1, jogo.getQuantVitoriaO());
	}
	
	@Test
	void testarAtualizarResultadoEmpate() {
		jogo.setCampo(0, 0, "X");  // X O X
		jogo.setCampo(0, 1, "O");  // X O O
		jogo.setCampo(0, 2, "X");  // O X X
		jogo.setCampo(1, 0, "X");
		jogo.setCampo(1, 1, "O");
		jogo.setCampo(1, 2, "O");
		jogo.setCampo(2, 0, "O");
		jogo.setCampo(2, 1, "X");
		jogo.setCampo(2, 2, "X");
		
		jogo.atualizarResultado();
		
		assertEquals(1, jogo.getQuantEmpates());
	}
	
	@Test
	void testarGetResultadoNaoDefinido() {
		assertEquals(-1, jogo.getResultado());
	}
	
	@Test
	void testarGetResultadoEmpate() {
		jogo.setCampo(0, 0, "X");  // X O X
		jogo.setCampo(0, 1, "O");  // X O O
		jogo.setCampo(0, 2, "X");  // O X X
		jogo.setCampo(1, 0, "X");
		jogo.setCampo(1, 1, "O");
		jogo.setCampo(1, 2, "O");
		jogo.setCampo(2, 0, "O");
		jogo.setCampo(2, 1, "X");
		jogo.setCampo(2, 2, "X");
		assertEquals(0, jogo.getResultado());
	}
	
	@Test
	void testarGetResultadoGanhouHorizontalO() {
		jogo.setCampo(0, 0, "X");  // X O X
		jogo.setCampo(0, 1, "O");  // O O O
		jogo.setCampo(0, 2, "X");  // - X X
		jogo.setCampo(1, 0, "O");
		jogo.setCampo(1, 1, "O");
		jogo.setCampo(1, 2, "O");
		jogo.setCampo(2, 1, "X");
		jogo.setCampo(2, 2, "X");
		assertEquals(2, jogo.getResultado());
	}
	
	@Test
	void testarGetResultadoGanhouVerticalX() {
		jogo.setCampo(0, 0, "X");  // X O -
		jogo.setCampo(0, 1, "O");  // X O -  
		jogo.setCampo(1, 0, "X");  // X - -
		jogo.setCampo(1, 1, "O");
		jogo.setCampo(2, 0, "X");
		assertEquals(1, jogo.getResultado());
	}
	
	@Test
	void testarGetResultadoGanhouDiagonalCimaParaBaixo() {
		jogo.setCampo(0, 0, "X");  // X O O
		jogo.setCampo(0, 1, "O");  // - X -  
		jogo.setCampo(0, 2, "O");  // - - X
		jogo.setCampo(1, 1, "X");
		jogo.setCampo(2, 2, "X");
		assertEquals(1, jogo.getResultado());
	}
	
	@Test
	void testarGetResultadoGanhouDiagonalBaixoParaCima() {
		jogo.setCampo(0, 0, "X");  // X X O
		jogo.setCampo(0, 1, "X");  // - O -  
		jogo.setCampo(0, 2, "O");  // O - X
		jogo.setCampo(1, 1, "O");
		jogo.setCampo(2, 2, "X");
		jogo.setCampo(2, 0, "O");
		assertEquals(2, jogo.getResultado());
	}

}
