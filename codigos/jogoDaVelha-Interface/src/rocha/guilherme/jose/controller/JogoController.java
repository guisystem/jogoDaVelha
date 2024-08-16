package rocha.guilherme.jose.controller;

import javax.swing.JButton;

import rocha.guilherme.jose.controller.helper.JogoHelper;
import rocha.guilherme.jose.model.ModelJogo;
import rocha.guilherme.jose.view.JogoView;

public class JogoController {

	private final JogoView jogoView;
	private final JogoHelper helper;
	private final ModelJogo jogo;
	
	public JogoController(JogoView jogoView) {
		this.jogoView = jogoView;
		this.helper = new JogoHelper(jogoView);
		this.jogo = new ModelJogo();
	}
	
	public void iniciarJogo() {
		helper.limparTabuleiroJogo();
		jogo.iniciarJogo();
	}

	public void verificarCampo(int linha, int coluna, JButton campo) {
		if(helper.verificarCampo(campo)) {
			if(jogo.getNumeroDeX() == jogo.getNumeroDeO()) {
				jogo.setCampo(linha, coluna, "X");
				jogo.setNumeroDeX(jogo.getNumeroDeX() + 1);
				helper.marcarX(campo);
			}else {
				jogo.setCampo(linha, coluna, "O");
				jogo.setNumeroDeO(jogo.getNumeroDeO() + 1);
				helper.marcarO(campo);
			}
		}
		
		verificarResultado();
	}
	
	private void verificarResultado() {
		if(jogo.getResultado() != -1) {
			
			if(jogo.getResultado() == 1 || jogo.getResultado() == 2) {
				jogoView.exibirResultado("O jogador " + jogo.getResultado() + " ganhou.");
			}
			
			if(jogo.getResultado() == 0) {
				jogoView.exibirResultado("Deu velha: O jogo empatou.");
			}

			jogo.atualizarResultado();
			iniciarJogo();

			helper.atualizarPlacar(jogo);
		}
	}
	
}
