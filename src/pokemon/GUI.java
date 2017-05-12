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

	private ImageIcon resize(String path, JLabel label) {
		ImageIcon MyImage;
		Image img;
		
		MyImage = new ImageIcon(GUI.class.getResource(path));
		img = MyImage.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		return (new ImageIcon(img));
	}
	private ImageIcon resize(String path, JButton button) {
		ImageIcon MyImage;
		Image img;
		
		MyImage = new ImageIcon(GUI.class.getResource(path));
		img = MyImage.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
		return (new ImageIcon(img));
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container container = frame.getContentPane();
		container.setLayout(null);
	
		
	//	Declara��o dos Paineis	
		JPanel PainelBatalha = new JPanel();
		JPanel PainelPokePool = new JPanel();
		JPanel PainelItem = new JPanel();
		JPanel botoesPrincipais = new JPanel();
		JPanel botoesAtaque = new JPanel();
		JTextPane txtBox = new JTextPane();
		txtBox.setForeground(Color.WHITE);
		JPanel Balls = new JPanel();
		JPanel Pots = new JPanel();
		JPanel Elix = new JPanel();
		
	/*
	 * PRIMEIRO PAINEL ====== BATALHA
	 */ 	
		
		PainelBatalha.setBounds(0, 0, 784, 461);
		PainelBatalha.setLayout(null);
		container.add(PainelBatalha);
	
		
	//	Mostradores
		JPanel mostrador1 = new JPanel();
		mostrador1.setBounds(552, 256, 189, 79);
		PainelBatalha.add(mostrador1);
		mostrador1.setLayout(null);
		mostrador1.setOpaque(false);

		
		JLabel name1 = new JLabel("VELOSTER");
		name1.setForeground(Color.WHITE);
		name1.setFont(new Font("Monospaced", Font.BOLD, 18));
		name1.setBounds(30, 11, 149, 14);
		mostrador1.add(name1);
		
		JProgressBar HPBarPoke1 = new JProgressBar();
		HPBarPoke1.setBounds(45, 50, 134, 12);
		mostrador1.add(HPBarPoke1);
		
		
		JPanel mostrador2 = new JPanel();
		mostrador2.setBackground(Color.WHITE);
		mostrador2.setBounds(74, 50, 189, 85);
		PainelBatalha.add(mostrador2);
		mostrador2.setLayout(null);
		mostrador2.setOpaque(false);
		
		JLabel name2 = new JLabel("UNO TURBO");
		name2.setForeground(Color.WHITE);
		name2.setFont(new Font("Monospaced", Font.BOLD, 18));
		name2.setBounds(33, 18, 140, 16);
		mostrador2.add(name2);
		
		JProgressBar HPBarPoke2 = new JProgressBar();
		HPBarPoke2.setBounds(45, 57, 134, 12);
		mostrador2.add(HPBarPoke2);
		
		JLabel lblMostrador1 = new JLabel("");
		lblMostrador1.setBounds(519, 242, 222, 93);
		PainelBatalha.add(lblMostrador1);
		//Adicionando Icone
		lblMostrador1.setIcon(resize("/imagens/Moldura/mostrador.png", lblMostrador1));
		
		JLabel lblMostrador2 = new JLabel("");
		lblMostrador2.setBounds(41, 42, 222, 93);
		PainelBatalha.add(lblMostrador2);
		//Adicionando Icone
		lblMostrador2.setIcon(resize("/imagens/Moldura/mostrador.png", lblMostrador2));
		
		
		
	//	Imagens		
		
	//		Jogador 1
		JLabel lblPlayer1 = new JLabel("");
		lblPlayer1.setBounds(57, 189, 282, 198);
			//Adicionando Icone
		lblPlayer1.setIcon(resize("/imagens/Pokemon/back/36.png", lblPlayer1));
		PainelBatalha.add(lblPlayer1);
		
	//		Jogador 2
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(434, 38, 275, 219);
	//			Adicionando Icone
		lblPlayer2.setIcon(resize("/imagens/Pokemon/front/122.png", lblPlayer2));
		PainelBatalha.add(lblPlayer2);
		
		
	//		Background de Batalha
		JLabel lblBatalhaBack = new JLabel("");
		lblBatalhaBack.setBounds(0, 0, 784, 369);
	//			Adicionando Icone
		lblBatalhaBack.setIcon(resize("/imagens/Background/Terreno/battles(1).png", lblBatalhaBack));
		PainelBatalha.add(lblBatalhaBack);
		
		
	//	Menu
		botoesPrincipais.setBounds(476, 380, 282, 70);
		botoesPrincipais.setOpaque(false);
		PainelBatalha.add(botoesPrincipais);
		
			JButton btn_Principais1 = new JButton("Atacar");
			btn_Principais1.setBounds(7, 7, 122, 26);
			btn_Principais1.setIcon(resize("/imagens/Botoes/Botao.png", btn_Principais1));
			btn_Principais1.setIconTextGap(-80);
			btn_Principais1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botoesAtaque.setVisible(true);
					botoesPrincipais.setVisible(false);
					txtBox.setVisible(false);
					
				}
			});
			botoesPrincipais.setLayout(null);
			botoesPrincipais.add(btn_Principais1);
			
			JButton btn_Principais2 = new JButton("Trocar Pokemon");
			btn_Principais2.setBounds(133, 7, 142, 26);
			btn_Principais2.setIcon(resize("/imagens/Botoes/Botao.png", btn_Principais2));
			btn_Principais2.setIconTextGap(-130);
			btn_Principais2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(true);
					PainelItem.setVisible(false);
				}
			});
			botoesPrincipais.add(btn_Principais2);
			
			JButton btn_Principais3 = new JButton("Fugir");
			btn_Principais3.setBounds(7, 37, 122, 26);
			btn_Principais3.setIcon(resize("/imagens/Botoes/Botao.png", btn_Principais3));
			btn_Principais3.setIconTextGap(-75);
			btn_Principais3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botoesPrincipais.add(btn_Principais3);
			
			JButton btn_Principais4 = new JButton("Usar Item");
			btn_Principais4.setBounds(133, 37, 142, 26);
			btn_Principais4.setIcon(resize("/imagens/Botoes/Botao.png", btn_Principais4));
			btn_Principais4.setIconTextGap(-100);
			btn_Principais4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(false);
					PainelItem.setVisible(true);
					
					Balls.setVisible(true);
					Elix.setVisible(false);
					Pots.setVisible(false);
					
				}
			});
			botoesPrincipais.add(btn_Principais4);

		
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
		botoesAtaque.setLayout(null);
		
		JButton btn_ataque1 = new JButton("Ataque 1");
		btn_ataque1.setBounds(7, 7, 141, 56);
		botoesAtaque.add(btn_ataque1);
		
		JButton btn_ataque2 = new JButton("Ataque 2");
		btn_ataque2.setBounds(152, 7, 140, 56);
		botoesAtaque.add(btn_ataque2);
		
		JButton btn_ataque3 = new JButton("Ataque 3");
		btn_ataque3.setBounds(296, 7, 141, 56);
		botoesAtaque.add(btn_ataque3);
		
		JButton btn_ataque4 = new JButton("Ataque 4");
		btn_ataque4.setBounds(441, 7, 140, 56);
		botoesAtaque.add(btn_ataque4);
		
		JButton btn_ataque_voltar = new JButton("Voltar");
		btn_ataque_voltar.setBounds(585, 7, 141, 56);
		btn_ataque_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botoesAtaque.setVisible(false);
				botoesPrincipais.setVisible(true);
				txtBox.setVisible(true);
			}
		});
		botoesAtaque.add(btn_ataque_voltar);
		
		JLabel lblMenuBack = new JLabel("");
		lblMenuBack.setBounds(0, 368, 784, 93);
		lblMenuBack.setIcon(resize("/imagens/Menu/Frame.png", lblMenuBack));
		PainelBatalha.add(lblMenuBack);
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
			poke1.setLayout(null);
			poke1.setOpaque(false);
		
			JProgressBar HPBar1 = new JProgressBar();
			HPBar1.setBounds(80, 72, 130, 12);
			poke1.add(HPBar1);
			
			JButton btnPoke1 = new JButton("New button");
			btnPoke1.setBounds(64, 24, 130, 23);
			poke1.add(btnPoke1);
			
			JLabel lblPoke1 = new JLabel();
			lblPoke1.setBounds(0, 0, 222, 103);
			lblPoke1.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke1));
			poke1.add(lblPoke1);
			
		
		JPanel poke2 = new JPanel();
		poke2.setBounds(41, 158, 222, 103);
		PainelPokePool.add(poke2);
		poke2.setLayout(null);
		poke2.setOpaque(false);
		
			JProgressBar HPBar2 = new JProgressBar();
			HPBar2.setBounds(80, 72, 130, 12);
			poke2.add(HPBar2);
			
			JButton btnPoke2 = new JButton("New button");
			btnPoke2.setBounds(64, 24, 130, 23);
			poke2.add(btnPoke2);
			
			JLabel lblPoke2 = new JLabel();
			lblPoke2.setBounds(0, 0, 222, 103);
			lblPoke2.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke2));
			poke2.add(lblPoke2);
		
		JPanel poke3 = new JPanel();
		poke3.setBounds(41, 294, 222, 103);
		PainelPokePool.add(poke3);
		poke3.setLayout(null);
		poke3.setOpaque(false);
		
			JProgressBar HPBar3 = new JProgressBar();
			HPBar3.setBounds(80, 72, 130, 12);
			poke3.add(HPBar3);
			
			JButton btnPoke3 = new JButton("New button");
			btnPoke3.setBounds(64, 24, 130, 23);
			poke3.add(btnPoke3);
			
			JLabel lblPoke3 = new JLabel();
			lblPoke3.setBounds(0, 0, 222, 103);
			lblPoke3.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke3));
			poke3.add(lblPoke3);
		
		JPanel poke4 = new JPanel();
		poke4.setBounds(510, 32, 222, 103);
		PainelPokePool.add(poke4);
		poke4.setLayout(null);
		poke4.setOpaque(false);
		
			JProgressBar HPBar4 = new JProgressBar();
			HPBar4.setBounds(80, 72, 130, 12);
			poke4.add(HPBar4);
			
			JButton btnPoke4 = new JButton("New button");
			btnPoke4.setBounds(64, 24, 130, 23);
			poke4.add(btnPoke4);
			
			JLabel lblPoke4 = new JLabel();
			lblPoke4.setBounds(0, 0, 222, 103);
			lblPoke4.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke4));
			poke4.add(lblPoke4);
		
		JPanel poke5 = new JPanel();
		poke5.setBounds(510, 158, 222, 103);
		PainelPokePool.add(poke5);
		poke5.setLayout(null);
		poke5.setOpaque(false);
		
			JProgressBar HPBar5 = new JProgressBar();
			HPBar5.setBounds(80, 72, 130, 12);
			poke5.add(HPBar5);
			
			JButton btnPoke5 = new JButton("New button");
			btnPoke5.setBounds(64, 24, 130, 23);
			poke5.add(btnPoke5);
			
			JLabel lblPoke5 = new JLabel();
			lblPoke5.setBounds(0, 0, 222, 103);
			lblPoke5.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke5));
			poke5.add(lblPoke5);
			
		JPanel poke6 = new JPanel();
		poke6.setBounds(510, 294, 222, 103);
		PainelPokePool.add(poke6);
		poke6.setLayout(null);
		poke6.setOpaque(false);
		
			JProgressBar HPBar6 = new JProgressBar();
			HPBar6.setBounds(80, 72, 130, 12);
			poke6.add(HPBar6);
			
			JButton btnPoke6 = new JButton("New button");
			btnPoke6.setBounds(64, 24, 130, 23);
			poke6.add(btnPoke6);
			
			JLabel lblPoke6 = new JLabel();
			lblPoke6.setBounds(0, 0, 222, 103);
			lblPoke6.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke6));
			poke6.add(lblPoke6);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelBatalha.setVisible(true);
				PainelPokePool.setVisible(false);
			}
		});
		btnCancelar.setBounds(643, 427, 89, 23);
		PainelPokePool.add(btnCancelar);
		
		JLabel lblBackPokePool = new JLabel("");
		lblBackPokePool.setBounds(0, 0, 784, 461);
		lblBackPokePool.setIcon(resize("/imagens/Background/Menu/Itens.png", lblBackPokePool));
		PainelPokePool.add(lblBackPokePool);
	
	/*
	 * FIM SEGUNDO PAINEL ====== TROCAR POKEMON
	 */	
		

		
	/*
	 * TERCEIRO PAINEL ====== ITENS
	 */	
		
		PainelItem.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(PainelItem);
		PainelItem.setLayout(null);
		
		
		Balls.setBounds(0, 0, 611, 461);
		PainelItem.add(Balls);
		Balls.setLayout(null);
		Balls.setOpaque(false);
		
			JLabel lbl_ball1 = new JLabel();
			lbl_ball1.setBounds(64, 0, 177, 177);
			lbl_ball1.setIcon(resize("/imagens/Item/poke-ball.png", lbl_ball1));
			Balls.add(lbl_ball1);
			
			JLabel lbl_ball2 = new JLabel();
			lbl_ball2.setBounds(369, 0, 177, 177);
			lbl_ball2.setIcon(resize("/imagens/Item/great-ball.png", lbl_ball2));
			Balls.add(lbl_ball2);
			
			JButton btn_ball1 = new JButton("Pokeball");
			btn_ball1.setBounds(0, 188, 305, 42);
			Balls.add(btn_ball1);
			
			JButton btn_ball2 = new JButton("Greatball");
			btn_ball2.setBounds(305, 188, 305, 42);
			Balls.add(btn_ball2);
			
			JLabel lbl_ball3 = new JLabel();
			lbl_ball3.setBounds(64, 230, 177, 177);
			lbl_ball3.setIcon(resize("/imagens/Item/ultra-ball.png", lbl_ball3));
			Balls.add(lbl_ball3);
			
			JLabel lbl_ball4 = new JLabel();
			lbl_ball4.setBounds(369, 230, 177, 177);
			lbl_ball4.setIcon(resize("/imagens/Item/master-ball.png", lbl_ball4));
			Balls.add(lbl_ball4);
			
			JButton btn_ball3 = new JButton("Ultraball");
			btn_ball3.setBounds(0, 418, 305, 42);
			Balls.add(btn_ball3);
			
			JButton btn_ball4 = new JButton("Masterball");
			btn_ball4.setBounds(305, 418, 305, 42);
			Balls.add(btn_ball4);
		
		Pots.setBounds(0, 0, 610, 461);
		PainelItem.add(Pots);
		Pots.setLayout(null);
		Pots.setOpaque(false);
		
			JLabel lbl_pot1 = new JLabel();
			lbl_pot1.setBounds(7, 29, 146, 146);
			lbl_pot1.setIcon(resize("/imagens/Item/potion.png", lbl_pot1));
			Pots.add(lbl_pot1);
			
			JLabel lbl_pot2 = new JLabel();
			lbl_pot2.setBounds(157, 29, 146, 146);
			lbl_pot2.setIcon(resize("/imagens/Item/super-potion.png", lbl_pot2));
			Pots.add(lbl_pot2);
			
			JLabel lbl_pot3 = new JLabel();
			lbl_pot3.setBounds(307, 29, 146, 146);
			lbl_pot3.setIcon(resize("/imagens/Item/hyper-potion.png", lbl_pot3));
			Pots.add(lbl_pot3);
			
			JLabel lbl_pot4 = new JLabel();
			lbl_pot4.setBounds(457, 29, 146, 146);
			lbl_pot4.setIcon(resize("/imagens/Item/max-potion.png", lbl_pot4));
			Pots.add(lbl_pot4);
			
			JButton btn_pot1 = new JButton("Potion");
			btn_pot1.setBounds(7, 186, 146, 23);
			Pots.add(btn_pot1);
			
			JButton btn_pot2 = new JButton("Super Potion");
			btn_pot2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_pot2.setBounds(157, 186, 146, 23);
			Pots.add(btn_pot2);
			
			JButton btn_pot3 = new JButton("Hyper Potion");
			btn_pot3.setBounds(307, 186, 146, 23);
			Pots.add(btn_pot3);
			
			JButton btn_pot4 = new JButton("Max Potion");
			btn_pot4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot4.setBounds(457, 186, 146, 23);
			Pots.add(btn_pot4);
			
			JLabel lbl_pot5 = new JLabel();
			lbl_pot5.setBounds(7, 270, 146, 146);
			lbl_pot5.setIcon(resize("/imagens/Item/full-restore.png", lbl_pot5));
			Pots.add(lbl_pot5);
			
			JLabel lbl_pot6 = new JLabel();
			lbl_pot6.setBounds(157, 270, 146, 146);
			lbl_pot6.setIcon(resize("/imagens/Item/fresh-water.png", lbl_pot6));
			Pots.add(lbl_pot6);
			
			JLabel lbl_pot7 = new JLabel();
			lbl_pot7.setBounds(307, 270, 146, 146);
			lbl_pot7.setIcon(resize("/imagens/Item/soda-pop.png", lbl_pot7));
			Pots.add(lbl_pot7);
			
			JLabel lbl_pot8 = new JLabel();
			lbl_pot8.setBounds(457, 270, 146, 146);
			lbl_pot8.setIcon(resize("/imagens/Item/lemonade.png", lbl_pot8));
			Pots.add(lbl_pot8);
			
			JButton btn_pot5 = new JButton("Full Restore");
			btn_pot5.setBounds(7, 427, 146, 23);
			Pots.add(btn_pot5);
			
			JButton btn_pot6 = new JButton("Fresh Water");
			btn_pot6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot6.setBounds(157, 427, 146, 23);
			Pots.add(btn_pot6);
			
			JButton btn_pot7 = new JButton("Soda Pop");
			btn_pot7.setBounds(307, 427, 146, 23);
			Pots.add(btn_pot7);
			
			JButton btn_pot8 = new JButton("Lemonade");
			btn_pot8.setBounds(457, 427, 146, 23);
			Pots.add(btn_pot8);
		
		Elix.setBounds(0, 0, 611, 461);
		PainelItem.add(Elix);
		Elix.setLayout(null);
		Elix.setOpaque(false);
		
			JLabel lbl_elix1 = new JLabel();
			lbl_elix1.setBounds(64, 0, 177, 177);
			lbl_elix1.setIcon(resize("/imagens/Item/ether.png", lbl_elix1));
			Elix.add(lbl_elix1);
			
			JLabel lbl_elix2 = new JLabel();
			lbl_elix2.setBounds(369, 0, 177, 177);
			lbl_elix2.setIcon(resize("/imagens/Item/max-ether.png", lbl_elix2));
			Elix.add(lbl_elix2);
			
			JButton btn_elix1 = new JButton("Ether");
			btn_elix1.setBounds(0, 188, 305, 42);
			Elix.add(btn_elix1);
			
			JButton btn_elix2 = new JButton("Max Ether");
			btn_elix2.setBounds(305, 188, 305, 42);
			Elix.add(btn_elix2);
			
			JLabel lbl_elix3 = new JLabel();
			lbl_elix3.setBounds(64, 230, 177, 177);
			lbl_elix3.setIcon(resize("/imagens/Item/elixir.png", lbl_elix3));
			Elix.add(lbl_elix3);
			
			JLabel lbl_elix4 = new JLabel();
			lbl_elix4.setBounds(369, 230, 177, 177);
			lbl_elix4.setIcon(resize("/imagens/Item/max-elixir.png", lbl_elix4));
			Elix.add(lbl_elix4);
			
			JButton btn_elix3 = new JButton("Elixir");
			btn_elix3.setBounds(0, 418, 305, 42);
			Elix.add(btn_elix3);
			
			JButton btn_elix4 = new JButton("Max Elixir");
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
		
		JLabel lblItensBack = new JLabel();
		lblItensBack.setBounds(0, 0, 784, 461);
		lblItensBack.setIcon(resize("/imagens/Background/Menu/Itens.png", lblItensBack));
		PainelItem.add(lblItensBack);
		
		
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
