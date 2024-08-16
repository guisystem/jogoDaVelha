package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import rocha.guilherme.jose.controller.JogoController;

@SuppressWarnings("serial")
public class JogoView extends JFrame {

	private JPanel contentPane;
	private JButton btnZeroZero;
	private JButton btnZeroUm;
	private JButton btnUmZero;
	private JButton btnZeroDois;
	private JButton btnUmUm;
	private JButton btnUmDois;
	private JButton btnDoisZero;
	private JButton btnDoisUm;
	private JButton btnDoisDois;
	private JTextField textFieldVitoriasUm;
	private JTextField textFieldVitoriasDois;
	private JTextField textFieldEmpates;
	
	private JogoController controller;
	private JButton btnNovoJogo;
	private JButton btnSobreOJogo;
	private JButton btnSair;
	
	private JPanel painelJogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoView frame = new JogoView();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);

        g2d.drawLine(191, 91, 191, 471);
        g2d.drawLine(325, 91, 325, 471);
        g2d.drawLine(68, 214, 448, 214);
        g2d.drawLine(68, 348, 448, 348);

        g2d.setColor(Color.decode("#E100FF"));
        g2d.drawLine(508, 113, 778, 113);
        g2d.drawLine(508, 203, 778, 203);
        g2d.drawLine(508, 296, 778, 296);
        g2d.drawLine(508, 348, 778, 348);
    }

	/**
	 * Create the frame.
	 */
	public JogoView() {
		controller = new JogoController(this);
		
		setTitle("Jogo da Velha");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JogoView.class.getResource("/rocha/guilherme/jose/view/icones/icone-jogoDaVelha.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 539);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(Color.decode("#7F00FF"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		painelJogo = new JPainelGradient(Color.decode("#E100FF"), Color.decode("#8E2DE2"));
		painelJogo.setBounds(50, 50, 400, 400);
		painelJogo.setLayout(null);
		contentPane.add(painelJogo);
		
		btnZeroZero = new JButton("");
		btnZeroZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(0, 0, btnZeroZero);
			}
		});
		btnZeroZero.setContentAreaFilled(false);
		btnZeroZero.setBorderPainted(false);
		btnZeroZero.setFont(new Font("Arial", Font.PLAIN, 80));
		btnZeroZero.setBounds(10, 10, 113, 113);
		painelJogo.add(btnZeroZero);
		
		btnZeroUm = new JButton("");
		btnZeroUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(0, 1, btnZeroUm);
			}
		});
		btnZeroUm.setContentAreaFilled(false);
		btnZeroUm.setBorderPainted(false);
		btnZeroUm.setFont(new Font("Arial", Font.PLAIN, 80));
		btnZeroUm.setBounds(143, 10, 113, 113);
		painelJogo.add(btnZeroUm);
		
		btnZeroDois = new JButton("");
		btnZeroDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(0, 2, btnZeroDois);
			}
		});
		btnZeroDois.setContentAreaFilled(false);
		btnZeroDois.setBorderPainted(false);
		btnZeroDois.setFont(new Font("Arial", Font.PLAIN, 80));
		btnZeroDois.setBounds(277, 10, 113, 113);
		painelJogo.add(btnZeroDois);
		
		btnUmZero = new JButton("");
		btnUmZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(1, 0, btnUmZero);
			}
		});
		btnUmZero.setContentAreaFilled(false);
		btnUmZero.setBorderPainted(false);
		btnUmZero.setFont(new Font("Arial", Font.PLAIN, 80));
		btnUmZero.setBounds(10, 143, 113, 113);
		painelJogo.add(btnUmZero);
		
		btnDoisZero = new JButton("");
		btnDoisZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(2, 0, btnDoisZero);
			}
		});
		btnDoisZero.setContentAreaFilled(false);
		btnDoisZero.setBorderPainted(false);
		btnDoisZero.setFont(new Font("Arial", Font.PLAIN, 80));
		btnDoisZero.setBounds(10, 276, 113, 113);
		painelJogo.add(btnDoisZero);
		
		btnDoisDois = new JButton("");
		btnDoisDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(2, 2, btnDoisDois);
			}
		});
		btnDoisDois.setContentAreaFilled(false);
		btnDoisDois.setBorderPainted(false);
		btnDoisDois.setFont(new Font("Arial", Font.PLAIN, 80));
		btnDoisDois.setBounds(277, 276, 113, 113);
		painelJogo.add(btnDoisDois);
		
		btnUmUm = new JButton("");
		btnUmUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(1, 1, btnUmUm);
			}
		});
		btnUmUm.setContentAreaFilled(false);
		btnUmUm.setBorderPainted(false);
		btnUmUm.setFont(new Font("Arial", Font.PLAIN, 80));
		btnUmUm.setBounds(143, 143, 113, 113);
		painelJogo.add(btnUmUm);
		
		btnUmDois = new JButton("");
		btnUmDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(1, 2, btnUmDois);
			}
		});
		btnUmDois.setContentAreaFilled(false);
		btnUmDois.setBorderPainted(false);
		btnUmDois.setFont(new Font("Arial", Font.PLAIN, 80));
		btnUmDois.setBounds(277, 143, 113, 113);
		painelJogo.add(btnUmDois);
		
		btnDoisUm = new JButton("");
		btnDoisUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarCampo(2, 1, btnDoisUm);
			}
		});
		btnDoisUm.setContentAreaFilled(false);
		btnDoisUm.setBorderPainted(false);
		btnDoisUm.setFont(new Font("Arial", Font.PLAIN, 80));
		btnDoisUm.setBounds(143, 276, 113, 113);
		painelJogo.add(btnDoisUm);
		
		JLabel lblInformacoesJogo = new JLabel("Informa\u00E7\u00F5es do jogo");
		lblInformacoesJogo.setForeground(new Color(255, 255, 255));
		lblInformacoesJogo.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblInformacoesJogo.setBounds(500, 50, 171, 20);
		contentPane.add(lblInformacoesJogo);
		
		JLabel lblJogadorUm = new JLabel("Jogador 1");
		lblJogadorUm.setForeground(new Color(255, 255, 255));
		lblJogadorUm.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblJogadorUm.setBounds(500, 102, 81, 20);
		contentPane.add(lblJogadorUm);
		
		JLabel lblSimboloX = new JLabel("Simbolo: X");
		lblSimboloX.setForeground(new Color(255, 255, 255));
		lblSimboloX.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblSimboloX.setBounds(674, 102, 90, 20);
		contentPane.add(lblSimboloX);
		
		JLabel lblVitoriasDoJogadorUm = new JLabel("Vitorias do Jogador 1:");
		lblVitoriasDoJogadorUm.setForeground(new Color(255, 255, 255));
		lblVitoriasDoJogadorUm.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblVitoriasDoJogadorUm.setBounds(500, 132, 198, 20);
		contentPane.add(lblVitoriasDoJogadorUm);
		
		JLabel lblJogadorDois = new JLabel("Jogador 2");
		lblJogadorDois.setForeground(new Color(255, 255, 255));
		lblJogadorDois.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblJogadorDois.setBounds(500, 195, 81, 20);
		contentPane.add(lblJogadorDois);
		
		JLabel lblSimboloO = new JLabel("Simbolo: O");
		lblSimboloO.setForeground(new Color(255, 255, 255));
		lblSimboloO.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblSimboloO.setBounds(674, 195, 90, 20);
		contentPane.add(lblSimboloO);
		
		JLabel lblVitoriasDoJogadorDois = new JLabel("Vitorias do Jogador 2:");
		lblVitoriasDoJogadorDois.setForeground(new Color(255, 255, 255));
		lblVitoriasDoJogadorDois.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblVitoriasDoJogadorDois.setBounds(500, 225, 198, 20);
		contentPane.add(lblVitoriasDoJogadorDois);
		
		JLabel lblEmpates = new JLabel("Empates:");
		lblEmpates.setForeground(new Color(255, 255, 255));
		lblEmpates.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblEmpates.setBounds(500, 281, 72, 20);
		contentPane.add(lblEmpates);
		
		btnNovoJogo = new JButton("NOVO JOGO");
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				estiloMouseEnter(btnNovoJogo);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				estiloPadrao(btnNovoJogo);
			}
		});
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.iniciarJogo();
			}
		});
		btnNovoJogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNovoJogo.setForeground(Color.WHITE);
		btnNovoJogo.setBackground(Color.decode("#E100FF"));
		btnNovoJogo.setBorder(new LineBorder(Color.WHITE));
		btnNovoJogo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNovoJogo.setBounds(500, 336, 140, 28);
		contentPane.add(btnNovoJogo);
		
		btnSobreOJogo = new JButton("SOBRE O JOGO");
		btnSobreOJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				estiloMouseEnter(btnSobreOJogo);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				estiloPadrao(btnSobreOJogo);
			}
		});
		btnSobreOJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSobreOJogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSobreOJogo.setForeground(Color.WHITE);
		btnSobreOJogo.setBackground(Color.decode("#E100FF"));
		btnSobreOJogo.setBorder(new LineBorder(Color.WHITE));
		btnSobreOJogo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSobreOJogo.setBounds(500, 379, 140, 28);
		contentPane.add(btnSobreOJogo);
		
		btnSair = new JButton("SAIR");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				estiloMouseEnter(btnSair);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				estiloPadrao(btnSair);
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.decode("#E100FF"));
		btnSair.setBorder(new LineBorder(Color.WHITE));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSair.setBounds(500, 422, 140, 28);
		contentPane.add(btnSair);
		
		JLabel lblIconeJogo = new JLabel("");
		lblIconeJogo.setIcon(new ImageIcon(JogoView.class.getResource("/rocha/guilherme/jose/view/icones/emojinTransparente.png")));
		lblIconeJogo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIconeJogo.setBounds(670, 343, 100, 100);
		contentPane.add(lblIconeJogo);
		
		textFieldVitoriasUm = new JTextField();
		textFieldVitoriasUm.setText("0");
		textFieldVitoriasUm.setEditable(false);
		textFieldVitoriasUm.setForeground(new Color(255, 255, 255));
		textFieldVitoriasUm.setOpaque(false);
		textFieldVitoriasUm.setBorder(null);
		textFieldVitoriasUm.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldVitoriasUm.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVitoriasUm.setBounds(708, 131, 58, 20);
		contentPane.add(textFieldVitoriasUm);
		textFieldVitoriasUm.setColumns(10);
		
		textFieldVitoriasDois = new JTextField();
		textFieldVitoriasDois.setText("0");
		textFieldVitoriasDois.setEditable(false);
		textFieldVitoriasDois.setForeground(new Color(255, 255, 255));
		textFieldVitoriasDois.setOpaque(false);
		textFieldVitoriasDois.setBorder(null);
		textFieldVitoriasDois.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldVitoriasDois.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVitoriasDois.setColumns(10);
		textFieldVitoriasDois.setBounds(708, 224, 58, 20);
		contentPane.add(textFieldVitoriasDois);
		
		textFieldEmpates = new JTextField();
		textFieldEmpates.setText("0");
		textFieldEmpates.setEditable(false);
		textFieldEmpates.setForeground(new Color(255, 255, 255));
		textFieldEmpates.setOpaque(false);
		textFieldEmpates.setBorder(null);
		textFieldEmpates.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldEmpates.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldEmpates.setColumns(10);
		textFieldEmpates.setBounds(708, 280, 58, 20);
		contentPane.add(textFieldEmpates);
		
		iniciar();
		
	}

	protected void estiloMouseEnter(JButton botao) {
		botao.setForeground(Color.decode("#E100FF"));
		botao.setBackground(Color.WHITE);
		botao.setBorder(new LineBorder(Color.decode("#E100FF")));
		
	}

	protected void estiloPadrao(JButton botao) {
		botao.setForeground(Color.WHITE);
		botao.setBackground(Color.decode("#E100FF"));
		botao.setBorder(new LineBorder(Color.WHITE));
	}

	private void iniciar() {
		controller.iniciarJogo();
	}
	
	public void exibirResultado(String mensagem) {
		ImageIcon iconeResultado = new ImageIcon(JogoView.class.getResource("/rocha/guilherme/jose/view/icones/icone-jogoDaVelha.png"));
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16));
		UIManager.put("Panel.background", Color.decode("#7F00FF"));
		UIManager.put("OptionPane.background", Color.decode("#7F00FF"));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("Button.background", Color.decode("#8E2DE2"));
		UIManager.put("Button.foreground", Color.WHITE);

	   JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE, iconeResultado);
	}
	
	public JButton getBtnZeroZero() {
		return btnZeroZero;
	}

	public void setBtnZeroZero(JButton btnZeroZero) {
		this.btnZeroZero = btnZeroZero;
	}

	public JButton getBtnZeroUm() {
		return btnZeroUm;
	}

	public void setBtnZeroUm(JButton btnZeroUm) {
		this.btnZeroUm = btnZeroUm;
	}

	public JButton getBtnUmZero() {
		return btnUmZero;
	}

	public void setBtnUmZero(JButton btnUmZero) {
		this.btnUmZero = btnUmZero;
	}

	public JButton getBtnZeroDois() {
		return btnZeroDois;
	}

	public void setBtnZeroDois(JButton btnZeroDois) {
		this.btnZeroDois = btnZeroDois;
	}

	public JButton getBtnUmUm() {
		return btnUmUm;
	}

	public void setBtnUmUm(JButton btnUmUm) {
		this.btnUmUm = btnUmUm;
	}

	public JButton getBtnUmDois() {
		return btnUmDois;
	}

	public void setBtnUmDois(JButton btnUmDois) {
		this.btnUmDois = btnUmDois;
	}

	public JButton getBtnDoisZero() {
		return btnDoisZero;
	}

	public void setBtnDoisZero(JButton btnDoisZero) {
		this.btnDoisZero = btnDoisZero;
	}

	public JButton getBtnDoisUm() {
		return btnDoisUm;
	}

	public void setBtnDoisUm(JButton btnDoisUm) {
		this.btnDoisUm = btnDoisUm;
	}

	public JButton getBtnDoisDois() {
		return btnDoisDois;
	}

	public void setBtnDoisDois(JButton btnDoisDois) {
		this.btnDoisDois = btnDoisDois;
	}

	public JTextField getTextFieldVitoriasUm() {
		return textFieldVitoriasUm;
	}

	public void setTextFieldVitoriasUm(JTextField textFieldVitoriasUm) {
		this.textFieldVitoriasUm = textFieldVitoriasUm;
	}

	public JTextField getTextFieldVitoriasDois() {
		return textFieldVitoriasDois;
	}

	public void setTextFieldVitoriasDois(JTextField textFieldVitoriasDois) {
		this.textFieldVitoriasDois = textFieldVitoriasDois;
	}

	public JTextField getTextFieldEmpates() {
		return textFieldEmpates;
	}

	public void setTextFieldEmpates(JTextField textFieldEmpates) {
		this.textFieldEmpates = textFieldEmpates;
	}
	
	public JPanel getPainelJogo() {
		return painelJogo;
	}

	public void setPainelJogo(JPanel painelJogo) {
		this.painelJogo = painelJogo;
	}
	
}
