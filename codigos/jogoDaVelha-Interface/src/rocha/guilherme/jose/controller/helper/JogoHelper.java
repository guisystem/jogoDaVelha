package rocha.guilherme.jose.controller.helper;

import java.awt.Color;

import javax.swing.JButton;

import rocha.guilherme.jose.model.ModelJogo;
import rocha.guilherme.jose.view.JogoView;

public class JogoHelper {

	private final JogoView jogoView;

	public JogoHelper(JogoView jogoView) {
		this.jogoView = jogoView;
	}

	public boolean verificarCampo(JButton campo) {
		if(campo.getText().equals("")){
			return true;
		}
		
		return false;
	}
	
	public void marcarX(JButton campo) {
		campo.setText("X");
		campo.setForeground(Color.WHITE);
	}

	public void marcarO(JButton campo) {
		campo.setText("O");
		campo.setForeground(Color.WHITE);
	}

	public void limparTabuleiroJogo() {
		jogoView.getBtnZeroZero().setText("");
		jogoView.getBtnZeroUm().setText("");
		jogoView.getBtnZeroDois().setText("");
		jogoView.getBtnUmZero().setText("");
		jogoView.getBtnUmUm().setText("");
		jogoView.getBtnUmDois().setText("");
		jogoView.getBtnDoisZero().setText("");
		jogoView.getBtnDoisUm().setText("");
		jogoView.getBtnDoisDois().setText("");
		
	}

	public void atualizarPlacar(ModelJogo jogo) {
		jogoView.getTextFieldVitoriasUm().setText(jogo.getQuantVitoriaX() + "");
		jogoView.getTextFieldVitoriasDois().setText(jogo.getQuantVitoriaO() + "");
		jogoView.getTextFieldEmpates().setText(jogo.getQuantEmpates() + "");
		
	}
	
}
