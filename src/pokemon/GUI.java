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
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

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
	
	//	Variaveis auxiliares
		ImageIcon MyImage;
		Image img;
		
	//	Declaração dos Paineis	
		JPanel PainelBatalha = new JPanel();
		JPanel PainelPokePool = new JPanel();
		JPanel PainelItem = new JPanel();
		JPanel botoesPrincipais = new JPanel();
		JPanel botoesAtaque = new JPanel();
		JTextPane txtBox = new JTextPane();
		txtBox.setForeground(Color.WHITE);
		
	/*
	 * PRIMEIRO PAINEL ====== BATALHA
	 */ 	
		
		PainelBatalha.setBounds(0, 0, 784, 461);
		PainelBatalha.setLayout(null);
		container.add(PainelBatalha);
	
		
	//	Mostradores
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
		
		
		
	//	Imagens		
		
	//		Jogador 1
		JLabel lblPlayer1 = new JLabel("");
		lblPlayer1.setBounds(57, 189, 282, 198);
			//Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\back\\150.png");
		img = MyImage.getImage().getScaledInstance(lblPlayer1.getWidth(), lblPlayer1.getHeight(), Image.SCALE_SMOOTH);
		lblPlayer1.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblPlayer1);
		
	//		Jogador 2
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(434, 38, 275, 219);
	//			Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\122.png");
		img = MyImage.getImage().getScaledInstance(lblPlayer2.getWidth(), lblPlayer2.getHeight(), Image.SCALE_SMOOTH);
		lblPlayer2.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblPlayer2);
		
		
	//		Background de Batalha
		JLabel lblBackBatalha = new JLabel("");
		lblBackBatalha.setBounds(0, 0, 784, 369);
	//			Adicionando Icone
		MyImage = new ImageIcon("C:\\Users\\sacch\\Desktop\\sprites\\terrains\\battles(1).png");
		img = MyImage.getImage().getScaledInstance(lblBackBatalha.getWidth(), lblBackBatalha.getHeight(), Image.SCALE_SMOOTH);
		lblBackBatalha.setIcon(new ImageIcon(img));
		PainelBatalha.add(lblBackBatalha);
		
		
	//	Menu
		botoesPrincipais.setBounds(476, 380, 282, 70);
		botoesPrincipais.setOpaque(false);
		PainelBatalha.add(botoesPrincipais);
		botoesPrincipais.setLayout(new MigLayout("", "[89px,grow][89px,grow]", "[23px,grow][23px,grow]"));
		
			JButton btnNewButton_2 = new JButton("Atacar");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botoesAtaque.setVisible(true);
					botoesPrincipais.setVisible(false);
					txtBox.setVisible(false);
					
				}
			});
			botoesPrincipais.add(btnNewButton_2, "cell 0 0,grow");
			
			JButton btnNewButton_3 = new JButton("Trocar Pokemon");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(true);
					PainelItem.setVisible(false);
				}
			});
			botoesPrincipais.add(btnNewButton_3, "cell 1 0,grow");
			
			JButton btnNewButton_1 = new JButton("Fugir");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botoesPrincipais.add(btnNewButton_1, "cell 0 1,grow");
			
			JButton btnNewButton = new JButton("Usar Item");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(false);
					PainelItem.setVisible(true);
				}
			});
			botoesPrincipais.add(btnNewButton, "cell 1 1,grow");

		
		txtBox.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtBox.setEditable(false);
		txtBox.setBackground(Color.WHITE);
		txtBox.setOpaque(false);
		txtBox.setText("O que quer fazer?");
		txtBox.setBounds(41, 380, 402, 70);
		PainelBatalha.add(txtBox);
		
		
		botoesAtaque.setBounds(25, 380, 733, 70);
		botoesAtaque.setOpaque(false);
		PainelBatalha.add(botoesAtaque);
		botoesAtaque.setLayout(new MigLayout("", "[89px,grow][89px,grow][89px,grow][89px,grow][89px,grow]", "[23px,grow]"));
		
		JButton btn_ataque1 = new JButton("Ataque 1");
		botoesAtaque.add(btn_ataque1, "cell 0 0,grow");
		
		JButton btn_ataque2 = new JButton("Ataque 2");
		botoesAtaque.add(btn_ataque2, "cell 1 0,grow");
		
		JButton btn_ataque3 = new JButton("Ataque 3");
		botoesAtaque.add(btn_ataque3, "cell 2 0,grow");
		
		JButton btn_ataque4 = new JButton("Ataque 4");
		botoesAtaque.add(btn_ataque4, "cell 3 0,grow");
		
		JButton btn_ataque_voltar = new JButton("Voltar");
		btn_ataque_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botoesAtaque.setVisible(false);
				botoesPrincipais.setVisible(true);
				txtBox.setVisible(true);
			}
		});
		botoesAtaque.add(btn_ataque_voltar, "cell 4 0,grow");
		
		JLabel MenuBack = new JLabel("");
		MenuBack.setBounds(0, 368, 784, 93);
		MyImage = new ImageIcon("C:\\Users\\sacch\\Programas\\GitHub\\pokemon\\imgs\\Menu\\Background.png");
		img = MyImage.getImage().getScaledInstance(MenuBack.getWidth(), MenuBack.getHeight(), Image.SCALE_SMOOTH);
		MenuBack.setIcon(new ImageIcon(img));
		PainelBatalha.add(MenuBack);
	/*
	 * FIM PRIMEIRO PAINEL ====== BATALHA
	 */
		
	 
	 
	/*
	 * SEGUNDO PAINEL ====== TROCAR POKEMON
	 */
		
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
	 */	
		

		
	/*
	 * TERCEIRO PAINEL ====== ITENS
	 */	
		
		PainelItem.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(PainelItem);
		PainelItem.setLayout(null);
		
		JPanel Balls = new JPanel();
		Balls.setBounds(0, 0, 611, 461);
		PainelItem.add(Balls);
		Balls.setLayout(null);
		
			JLabel lbl_ball1 = new JLabel("New label");
			lbl_ball1.setBounds(64, 0, 177, 177);
			Balls.add(lbl_ball1);
			
			JLabel lbl_ball2 = new JLabel("New label");
			lbl_ball2.setBounds(369, 0, 177, 177);
			Balls.add(lbl_ball2);
			
			JButton btn_ball1 = new JButton("New button");
			btn_ball1.setBounds(0, 188, 305, 42);
			Balls.add(btn_ball1);
			
			JButton btn_ball2 = new JButton("New button");
			btn_ball2.setBounds(305, 188, 305, 42);
			Balls.add(btn_ball2);
			
			JLabel lbl_ball3 = new JLabel("New label");
			lbl_ball3.setBounds(64, 230, 177, 177);
			Balls.add(lbl_ball3);
			
			JLabel lbl_ball4 = new JLabel("New label");
			lbl_ball4.setBounds(369, 230, 177, 177);
			Balls.add(lbl_ball4);
			
			JButton btn_ball3 = new JButton("New button");
			btn_ball3.setBounds(0, 418, 305, 42);
			Balls.add(btn_ball3);
			
			JButton btn_ball4 = new JButton("New button");
			btn_ball4.setBounds(305, 418, 305, 42);
			Balls.add(btn_ball4);
		
		JPanel Pots = new JPanel();
		Pots.setBounds(0, 0, 610, 461);
		PainelItem.add(Pots);
		Pots.setLayout(null);
		
			JLabel lbl_pot1 = new JLabel("New label");
			lbl_pot1.setBounds(7, 29, 146, 146);
			Pots.add(lbl_pot1);
			
			JLabel lbl_pot2 = new JLabel("New label");
			lbl_pot2.setBounds(157, 29, 146, 146);
			Pots.add(lbl_pot2);
			
			JLabel lbl_pot3 = new JLabel("New label");
			lbl_pot3.setBounds(307, 29, 146, 146);
			Pots.add(lbl_pot3);
			
			JLabel lbl_pot4 = new JLabel("New label");
			lbl_pot4.setBounds(457, 29, 146, 146);
			Pots.add(lbl_pot4);
			
			JButton btn_pot1 = new JButton("New button");
			btn_pot1.setBounds(7, 186, 146, 23);
			Pots.add(btn_pot1);
			
			JButton btn_pot2 = new JButton("New button");
			btn_pot2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_pot2.setBounds(157, 186, 146, 23);
			Pots.add(btn_pot2);
			
			JButton btn_pot3 = new JButton("New button");
			btn_pot3.setBounds(307, 186, 146, 23);
			Pots.add(btn_pot3);
			
			JButton btn_pot4 = new JButton("New button");
			btn_pot4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot4.setBounds(457, 186, 146, 23);
			Pots.add(btn_pot4);
			
			JLabel lbl_pot5 = new JLabel("New label");
			lbl_pot5.setBounds(7, 270, 146, 146);
			Pots.add(lbl_pot5);
			
			JLabel lbl_pot6 = new JLabel("New label");
			lbl_pot6.setBounds(157, 270, 146, 146);
			Pots.add(lbl_pot6);
			
			JLabel lbl_pot7 = new JLabel("New label");
			lbl_pot7.setBounds(307, 270, 146, 146);
			Pots.add(lbl_pot7);
			
			JLabel lbl_pot8 = new JLabel("New label");
			lbl_pot8.setBounds(457, 270, 146, 146);
			Pots.add(lbl_pot8);
			
			JButton btn_pot5 = new JButton("New button");
			btn_pot5.setBounds(7, 427, 146, 23);
			Pots.add(btn_pot5);
			
			JButton btn_pot6 = new JButton("New button");
			btn_pot6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot6.setBounds(157, 427, 146, 23);
			Pots.add(btn_pot6);
			
			JButton btn_pot7 = new JButton("New button");
			btn_pot7.setBounds(307, 427, 146, 23);
			Pots.add(btn_pot7);
			
			JButton btn_pot8 = new JButton("New button");
			btn_pot8.setBounds(457, 427, 146, 23);
			Pots.add(btn_pot8);
		
		JPanel Elix = new JPanel();
		Elix.setBounds(0, 0, 611, 461);
		PainelItem.add(Elix);
			Elix.setLayout(null);
		
			JLabel lbl_elix1 = new JLabel("New label");
			lbl_elix1.setBounds(64, 0, 177, 177);
			Elix.add(lbl_elix1);
			
			JLabel lbl_elix2 = new JLabel("New label");
			lbl_elix2.setBounds(369, 0, 177, 177);
			Elix.add(lbl_elix2);
			
			JButton btn_elix1 = new JButton("New button");
			btn_elix1.setBounds(0, 188, 305, 42);
			Elix.add(btn_elix1);
			
			JButton btn_elix2 = new JButton("New button");
			btn_elix2.setBounds(305, 188, 305, 42);
			Elix.add(btn_elix2);
			
			JLabel lbl_elix3 = new JLabel("New label");
			lbl_elix3.setBounds(64, 230, 177, 177);
			Elix.add(lbl_elix3);
			
			JLabel lbl_elix4 = new JLabel("New label");
			lbl_elix4.setBounds(369, 230, 177, 177);
			Elix.add(lbl_elix4);
			
			JButton btn_elix3 = new JButton("New button");
			btn_elix3.setBounds(0, 418, 305, 42);
			Elix.add(btn_elix3);
			
			JButton btn_elix4 = new JButton("New button");
			btn_elix4.setBounds(305, 418, 305, 42);
			Elix.add(btn_elix4);
			
			
		JButton btn_item1 = new JButton("Balls");
		btn_item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Balls.setVisible(true);
				Pots.setVisible(false);
				Elix.setVisible(false);
			}
		});
		btn_item1.setBounds(621, 11, 153, 86);
		PainelItem.add(btn_item1);
		
		JButton btn_item2 = new JButton("Pots");
		btn_item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balls.setVisible(false);
				Pots.setVisible(true);
				Elix.setVisible(false);
			}
		});
		btn_item2.setBounds(621, 129, 153, 86);
		PainelItem.add(btn_item2);
		
		JButton btn_item3 = new JButton("Elix");
		btn_item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balls.setVisible(false);
				Pots.setVisible(false);
				Elix.setVisible(true);
			}
		});
		btn_item3.setBounds(621, 245, 153, 86);
		PainelItem.add(btn_item3);
		
		JButton btn_item_voltar = new JButton("Voltar");
		btn_item_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelBatalha.setVisible(true);
				PainelPokePool.setVisible(false);
				PainelItem.setVisible(false);
			}
		});
		btn_item_voltar.setBounds(621, 364, 153, 86);
		PainelItem.add(btn_item_voltar);
		
		/*
		 * FIM TERCEIRO PAINEL ====== ITENS
		 */
		
		
		
		PainelBatalha.setVisible(true);
		PainelPokePool.setVisible(false);
		PainelItem.setVisible(false);
		botoesPrincipais.setVisible(true);
		botoesAtaque.setVisible(false);
	
	}
}
