package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SobreOJogoView extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreOJogoView dialog = new SobreOJogoView();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SobreOJogoView() {
		setTitle("Sobre o Jogo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SobreOJogoView.class.getResource("/rocha/guilherme/jose/view/icones/icone-jogoDaVelha.png")));
		setModal(true);
		setBounds(100, 100, 499, 419);
		JPainelGradient painelGradient = new JPainelGradient(Color.decode("#8E2DE2"), Color.decode("#8E2DE2"));
		setContentPane(painelGradient);
		getContentPane().setLayout(null);
		
		JLabel lblRegras = new JLabel("As regras do Jogo da Velha s\u00E3o muito simples:");
		lblRegras.setForeground(new Color(255, 255, 255));
		lblRegras.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegras.setBounds(115, 32, 260, 16);
		getContentPane().add(lblRegras);
		
		JLabel lblRegraUm = new JLabel("1. O jogo cont\u00E9m dois jogadores, um joga como \"X\" e o outro como \"O\".");
		lblRegraUm.setForeground(new Color(255, 255, 255));
		lblRegraUm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraUm.setBounds(32, 80, 390, 16);
		getContentPane().add(lblRegraUm);
		
		JLabel lblRegraDois = new JLabel("2. O jogador \"X\" come\u00E7a jogando.");
		lblRegraDois.setForeground(new Color(255, 255, 255));
		lblRegraDois.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraDois.setBounds(32, 112, 183, 16);
		getContentPane().add(lblRegraDois);
		
		JLabel lblRegraTresObjetivo = new JLabel("3. O objetivo do jogo \u00E9 alinhar tr\u00EAs simbolos iguais em sequ\u00EAncia -");
		lblRegraTresObjetivo.setForeground(new Color(255, 255, 255));
		lblRegraTresObjetivo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraTresObjetivo.setBounds(32, 144, 367, 16);
		getContentPane().add(lblRegraTresObjetivo);
		
		JLabel lblRegraTresExemplo = new JLabel("Horizontalmente, Verticalmente ou Diagonalmente. Como mostra abaixo:");
		lblRegraTresExemplo.setForeground(new Color(255, 255, 255));
		lblRegraTresExemplo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraTresExemplo.setBounds(46, 160, 405, 16);
		getContentPane().add(lblRegraTresExemplo);
		
		JLabel lblRegraQuatro = new JLabel("4. O primeiro jogador a atingir esse objetivo ganha.");
		lblRegraQuatro.setForeground(new Color(255, 255, 255));
		lblRegraQuatro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraQuatro.setBounds(32, 300, 280, 16);
		getContentPane().add(lblRegraQuatro);
		
		JLabel lblRegraCinco = new JLabel("5. Se nenhum dos dois conseguir, o jogo \"da velha\", ou seja, d\u00E1 empate.");
		lblRegraCinco.setForeground(new Color(255, 255, 255));
		lblRegraCinco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegraCinco.setBounds(32, 332, 398, 16);
		getContentPane().add(lblRegraCinco);
		
		JLabel lblExemploVitoriaHorizontal = new JLabel("");
		lblExemploVitoriaHorizontal.setIcon(new ImageIcon(SobreOJogoView.class.getResource("/rocha/guilherme/jose/view/icones/sobre-vitoriaHorizontal.png")));
		lblExemploVitoriaHorizontal.setBounds(32, 184, 100, 100);
		painelGradient.add(lblExemploVitoriaHorizontal);
		
		JLabel lblExemploVitoriaVertical = new JLabel("");
		lblExemploVitoriaVertical.setIcon(new ImageIcon(SobreOJogoView.class.getResource("/rocha/guilherme/jose/view/icones/sobre-vitoriaVertical.png")));
		lblExemploVitoriaVertical.setBounds(172, 184, 100, 100);
		painelGradient.add(lblExemploVitoriaVertical);
		
		JLabel lblExemploVitoriaDiagonal = new JLabel("");
		lblExemploVitoriaDiagonal.setIcon(new ImageIcon(SobreOJogoView.class.getResource("/rocha/guilherme/jose/view/icones/sobre-vitoriaDiagonal.png")));
		lblExemploVitoriaDiagonal.setBounds(311, 184, 100, 100);
		painelGradient.add(lblExemploVitoriaDiagonal);

	}
}
