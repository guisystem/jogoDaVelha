package rocha.guilherme.jose.controller.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rocha.guilherme.jose.model.ModelJogo;
import rocha.guilherme.jose.view.JogoView;

class JogoHelperTeste {

	private JogoHelper helper;
	private JogoView jogoView;
	
	@BeforeEach
	void iniciar() {
		jogoView = new JogoView();
		helper = new JogoHelper(jogoView);
	}
	
	@Test
	void testarVerificarCampoMarcado() {
		jogoView.getBtnDoisDois().setText("X");
		assertFalse(helper.verificarCampo(jogoView.getBtnDoisDois()));
	}
	
	@Test
	void testarVerificarCampoNaoMarcado() {
		assertTrue(helper.verificarCampo(jogoView.getBtnDoisDois()));
	}
	
	@Test
	void testarMarcarX() {
		helper.marcarX(jogoView.getBtnDoisUm());
		assertEquals("X", jogoView.getBtnDoisUm().getText());
	}
	
	@Test
	void testarMarcarO() {
		helper.marcarO(jogoView.getBtnDoisUm());
		assertEquals("O", jogoView.getBtnDoisUm().getText());
	}
	
	@Test
	void testarLimparTabuleiro() {
		jogoView.getBtnDoisDois().setText("X");
		jogoView.getBtnUmDois().setText("O");
	
		helper.limparTabuleiroJogo();
		
		assertEquals("", jogoView.getBtnDoisDois().getText());
		assertEquals("", jogoView.getBtnDoisDois().getText());
	}
	
	@Test
	void testarAtualizarPlacar() {
		ModelJogo jogo = new ModelJogo();
		jogo.setQuantVitoriaX(1);
		jogo.setQuantVitoriaO(1);
		jogo.setQuantEmpates(3);
		
		helper.atualizarPlacar(jogo);
		
		assertEquals("1", jogoView.getTextFieldVitoriasUm().getText());
		assertEquals("1", jogoView.getTextFieldVitoriasDois().getText());
		assertEquals("3", jogoView.getTextFieldEmpates().getText());
	}

}
