package rocha.guilherme.jose.view;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoViewTeste {

private JogoView jogo;
	
	@BeforeEach
	void iniciar() {
		jogo = new JogoView();
	}
	
	@Test
	void testarIniciarTelaJogo() {
		JogoView.main(null);
		jogo.setResizable(false);
		jogo.setLocationRelativeTo(null);
		jogo.setVisible(true);
		
		assertTrue(jogo.isVisible());
	}

}
