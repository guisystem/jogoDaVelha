package rocha.guilherme.jose.controller;

import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import rocha.guilherme.jose.controller.helper.JogoHelper;
import rocha.guilherme.jose.model.ModelJogo;
import rocha.guilherme.jose.view.JogoView;
import rocha.guilherme.jose.view.SobreOJogoView;

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
		cursorInicial();
	}
	
	public void cursorInicial() {
		try {
			jogoView.setCursorImage(ImageIO.read(getClass().getResourceAsStream("/rocha/guilherme/jose/view/icones/cursorX.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (jogoView.getCursorImage() != null) {
           	jogoView.setCustomCursor(Toolkit.getDefaultToolkit().createCustomCursor(jogoView.getCursorImage(), new Point(0, 0), "Custom Cursor"));
        }
        
        jogoView.getPainelJogo().setCursor(jogoView.getCustomCursor());
		
	}

	public void verificarCampo(int linha, int coluna, JButton campo) {
		if(helper.verificarCampo(campo)) {
			if(jogo.getNumeroDeX() == jogo.getNumeroDeO()) {
				jogo.setCampo(linha, coluna, "X");
				jogo.setNumeroDeX(jogo.getNumeroDeX() + 1);
				helper.marcarX(campo);
				mudarCursor("O");
			}else {
				jogo.setCampo(linha, coluna, "O");
				jogo.setNumeroDeO(jogo.getNumeroDeO() + 1);
				helper.marcarO(campo);
				mudarCursor("X");
			}
		}
		
		verificarResultado();
	}
	
	private void mudarCursor(String cursor) {
		try {
			if(cursor.equals("X")) {
				jogoView.setCursorImage(ImageIO.read(getClass().getResourceAsStream("/rocha/guilherme/jose/view/icones/cursorX.png")));
			}else {
				jogoView.setCursorImage(ImageIO.read(getClass().getResourceAsStream("/rocha/guilherme/jose/view/icones/cursorO.png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (jogoView.getCursorImage() != null) {
			jogoView.setCustomCursor(Toolkit.getDefaultToolkit().createCustomCursor(jogoView.getCursorImage(), new Point(0, 0), "Custom Cursor"));
		}
		
		jogoView.getPainelJogo().setCursor(jogoView.getCustomCursor());
		
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
	
	public void abrirJanelaSobre() {
		SobreOJogoView sobre = new SobreOJogoView();
		sobre.setLocationRelativeTo(null);
		sobre.setResizable(false);
		sobre.setVisible(true);
		
	}

	public void sair() {
	    System.exit(0);
	}
	
}
