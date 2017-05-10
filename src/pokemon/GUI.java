package pokemon;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		JPanel PainelBatalha = new JPanel();
		JPanel PainelPokePool = new JPanel();
		
	/*
	 * PRIMEIRO PAINEL ====== BATALHA
	 */ 	
		
		PainelBatalha.setBounds(0, 0, 784, 461);
		PainelBatalha.setLayout(null);
		container.add(PainelBatalha);
	
		
		//Mostradores
		JPanel mostrador1 = new JPanel();
		mostrador1.setBackground(Color.WHITE);
		mostrador1.setBounds(552, 279, 189, 56);
		PainelBatalha.add(mostrador1);
		
		JLabel name1 = new JLabel("Veloster 3 portas");
		mostrador1.add(name1);
		
		JProgressBar HPBarPoke1 = new JProgressBar();
		mostrador1.add(HPBarPoke1);
		
		
		JPanel mostrador2 = new JPanel();
		mostrador2.setBackground(Color.WHITE);
		mostrador2.setBounds(41, 79, 189, 56);
		PainelBatalha.add(mostrador2);
		
		JLabel name2 = new JLabel("UNO TURBO");
		mostrador2.add(name2);
		
		JProgressBar HPBarPoke2 = new JProgressBar();
		mostrador2.add(HPBarPoke2);
		
		
		
		//Imagens		
			//Variaveis auxiliares
		ImageIcon MyImage;
		Image img;
		
		
			//Jogador 1
		JLabel lblPlayer1 = new JLabel("");
		lblPlayer1.setBounds(57, 189, 282, 219);
			//Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\back\\150.png");
		img = MyImage.getImage().getScaledInstance(lblPlayer1.getWidth(), lblPlayer1.getHeight(), Image.SCALE_SMOOTH);
		lblPlayer1.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblPlayer1);
		
			//Jogador 2
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(434, 38, 275, 219);
			//Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\122.png");
		img = MyImage.getImage().getScaledInstance(lblPlayer2.getWidth(), lblPlayer2.getHeight(), Image.SCALE_SMOOTH);
		lblPlayer2.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblPlayer2);
		
			//Background de Batalha
		JLabel lblBackBatalha = new JLabel("");
		lblBackBatalha.setBounds(0, 0, 784, 369);
			//Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\terrains\\battles(1).png");
		img = MyImage.getImage().getScaledInstance(lblBackBatalha.getWidth(), lblBackBatalha.getHeight(), Image.SCALE_SMOOTH);
		lblBackBatalha.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblBackBatalha);
	
	
		//Botoes e menu
			//Botoes
		JButton btn1 = new JButton("Tentar correr");
		btn1.setBounds(480, 374, 138, 36);
		PainelBatalha.add(btn1);
		
		JButton btn2 = new JButton("Rezar");
		btn2.setBounds(480, 421, 138, 36);
		PainelBatalha.add(btn2);
		
		JButton btn3 = new JButton("Comprar 4 portas");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelBatalha.setVisible(false);
				PainelPokePool.setVisible(true);
			}
		});
		btn3.setBounds(628, 374, 138, 36);
		PainelBatalha.add(btn3);
		
		JButton btn4 = new JButton("Aceitar Destino");
		btn4.setBounds(628, 421, 138, 36);
		PainelBatalha.add(btn4);
			//Menu
		JTextPane txtBox = new JTextPane();
		txtBox.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtBox.setEditable(false);
		txtBox.setBackground(Color.WHITE);
		txtBox.setText("O que quer fazer?");
		txtBox.setBounds(10, 380, 460, 70);
		PainelBatalha.add(txtBox);
		
		JLabel MenuBack = new JLabel("");
		MenuBack.setIcon(new ImageIcon("C:\\Users\\sacch\\Desktop\\Sprites\\MenuBackground\\2.png"));
		MenuBack.setBounds(0, 368, 784, 93);
		PainelBatalha.add(MenuBack);
	/*
	 * FIM PRIMEIRO PAINEL ====== BATALHA
	 */ PainelBatalha.setVisible(false);
		
	 
	 
	/*
	 * SEGUNDO PAINEL ====== TROCAR POKEMON
	 * */
		
		PainelPokePool.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(PainelPokePool);
		PainelPokePool.setLayout(null);
		
		JPanel poke1 = new JPanel();
		poke1.setBounds(41, 32, 222, 103);
		PainelPokePool.add(poke1);
		
			JProgressBar HPBar1 = new JProgressBar();
			poke1.add(HPBar1);
			
			JButton btnPoke1 = new JButton("New button");
			poke1.add(btnPoke1);
		
		JPanel poke2 = new JPanel();
		poke2.setBounds(41, 158, 222, 103);
		PainelPokePool.add(poke2);
		
			JProgressBar HPBar2 = new JProgressBar();
			poke2.add(HPBar2);
			
			JButton btnPoke2 = new JButton("New button");
			poke2.add(btnPoke2);
		
		JPanel poke3 = new JPanel();
		poke3.setBounds(41, 294, 222, 103);
		PainelPokePool.add(poke3);
		
			JProgressBar HPBar3 = new JProgressBar();
			poke3.add(HPBar3);
			
			JButton btnPoke3 = new JButton("New button");
			poke3.add(btnPoke3);
		
		JPanel poke4 = new JPanel();
		poke4.setBounds(510, 32, 222, 103);
		PainelPokePool.add(poke4);
		
			JProgressBar HPBar4 = new JProgressBar();
			poke4.add(HPBar4);
			
			JButton btnPoke4 = new JButton("New button");
			poke4.add(btnPoke4);
		
		JPanel poke5 = new JPanel();
		poke5.setBounds(510, 158, 222, 103);
		PainelPokePool.add(poke5);
		
			JProgressBar HPBar5 = new JProgressBar();
			poke5.add(HPBar5);
			
			JButton btnPoke5 = new JButton("New button");
			poke5.add(btnPoke5);
			
		JPanel poke6 = new JPanel();
		poke6.setBounds(510, 294, 222, 103);
		PainelPokePool.add(poke6);
		
			JProgressBar HPBar6 = new JProgressBar();
			poke6.add(HPBar6);
			
			JButton btnPoke6 = new JButton("New button");
			poke6.add(btnPoke6);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelBatalha.setVisible(true);
				PainelPokePool.setVisible(false);
			}
		});
		btnCancelar.setBounds(643, 427, 89, 23);
		PainelPokePool.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 461);
		label.setIcon(new ImageIcon("C:\\Users\\sacch\\Desktop\\Sprites\\MenuBackground\\1.jpg"));
		PainelPokePool.add(label);
	
	/*
	 * FIM SEGUNDO PAINEL ====== TROCAR POKEMON
	 * */	
		
	PainelBatalha.setVisible(true);
	PainelPokePool.setVisible(false);
	
	}
}
