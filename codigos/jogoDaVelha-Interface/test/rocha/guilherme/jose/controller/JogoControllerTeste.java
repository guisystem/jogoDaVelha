package rocha.guilherme.jose.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Window;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rocha.guilherme.jose.view.JogoView;

class JogoControllerTeste {

	private JogoController controller;
	private JogoView jogoView;
	
	@BeforeEach
	void iniciar() {
		jogoView = new JogoView();
		controller = new JogoController(jogoView);
	}
	
	@Test
	void testarIniciarJogo() {
		controller.iniciarJogo();
		assertEquals("", jogoView.getBtnUmUm().getText());
	}
	
	@Test
	void testarVerificarCampoJaMarcado() {
		JButton campoMarcado = jogoView.getBtnDoisDois();
		campoMarcado.setText("X");
		controller.verificarCampo(2, 2, campoMarcado);
		assertEquals("X", jogoView.getBtnDoisDois().getText());
	}
	
	@Test
	void testarVerificarCampoNaoMarcado_X() {
		JButton campoNaoMarcado = jogoView.getBtnDoisDois();
		controller.verificarCampo(2, 2, campoNaoMarcado);
		assertEquals("X", jogoView.getBtnDoisDois().getText());
	}
	
	@Test
	void testarVerificarCampoNaoMarcado_O() {
		JButton campoMarcadoX = jogoView.getBtnDoisDois();
		controller.verificarCampo(2, 2, campoMarcadoX);

		JButton campoNaoMarcado = jogoView.getBtnZeroZero();
		controller.verificarCampo(0, 0, campoNaoMarcado);
		
		assertEquals("O", jogoView.getBtnZeroZero().getText());
	}
	
	@Test
	void testarVerificarCampo_VerificarResultadoVencedor() {
		controller.verificarCampo(0, 0, jogoView.getBtnZeroZero()); // X O -
		controller.verificarCampo(0, 1, jogoView.getBtnZeroUm());   // X O -
		controller.verificarCampo(1, 0, jogoView.getBtnUmZero());   // X - -
		controller.verificarCampo(1, 1, jogoView.getBtnUmUm());
		controller.verificarCampo(2, 0, jogoView.getBtnDoisZero());
		
		assertEquals("1", jogoView.getTextFieldVitoriasUm().getText());
	}
	
	@Test
	void testarVerificarCampo_VerificarResultadoEmpatou() {
		controller.verificarCampo(0, 0, jogoView.getBtnZeroZero()); // X O X
		controller.verificarCampo(0, 1, jogoView.getBtnZeroUm());   // X O 0
		controller.verificarCampo(1, 0, jogoView.getBtnUmZero());   // O X X
		controller.verificarCampo(1, 1, jogoView.getBtnUmUm());
		controller.verificarCampo(2, 1, jogoView.getBtnDoisUm());
		controller.verificarCampo(2, 0, jogoView.getBtnDoisZero());
		controller.verificarCampo(0, 2, jogoView.getBtnZeroDois());
		controller.verificarCampo(1, 2, jogoView.getBtnUmDois());
		controller.verificarCampo(2, 2, jogoView.getBtnDoisDois());
		
		assertEquals("1", jogoView.getTextFieldEmpates().getText());
	}
	
	@Test
	void testarAbrirJanelaSobre() {
	    controller.abrirJanelaSobre();

        for (Window janela : Window.getWindows()) {
            janela.dispose();
        }
	}
	
}
