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

	JFrame frame;

	/*public static void main(String[] args) {
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
	}*/

	public GUI(Trainer trainer1, Trainer trainer2) {
		initialize(trainer1, trainer2);
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
	
	private void initialize(Trainer trainer1, Trainer trainer2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		
		
	
		
	//	Declaraçao dos Paineis	
		JPanel PainelBatalha = new JPanel();
		JPanel PainelPokePool = new JPanel();
		JPanel PainelItem = new JPanel();
		JPanel batalha_botoesPrincipais = new JPanel();
		JPanel botoesAtaque = new JPanel();
		JTextPane batalha_txtBox = new JTextPane();
		batalha_txtBox.setForeground(Color.WHITE);
		JPanel balls = new JPanel();
		JPanel pots = new JPanel();
		JPanel elix = new JPanel();
		
	/*
	 * PRIMEIRO PAINEL ====== BATALHA
	 */ 	
		
		PainelBatalha.setBounds(0, 0, 784, 461);
		PainelBatalha.setLayout(null);
		container.add(PainelBatalha);
	
		
	//	Mostradores
		JPanel batalha_mostrador1 = new JPanel();
		batalha_mostrador1.setBounds(552, 256, 189, 79);
		PainelBatalha.add(batalha_mostrador1);
		batalha_mostrador1.setLayout(null);
		batalha_mostrador1.setOpaque(false);

			JLabel mostrador1_nome = new JLabel(trainer1.getPool().getPokemon(0).getNome());
			mostrador1_nome.setForeground(Color.WHITE);
			mostrador1_nome.setFont(new Font("Monospaced", Font.BOLD, 18));
			mostrador1_nome.setBounds(30, 11, 149, 14);
			batalha_mostrador1.add(mostrador1_nome);
			
			JProgressBar mostrador1_hpBar = new JProgressBar();
			mostrador1_hpBar.setBounds(45, 50, 134, 12);
			batalha_mostrador1.add(mostrador1_hpBar);
				
		JPanel batalha_mostrador2 = new JPanel();
		batalha_mostrador2.setBackground(Color.WHITE);
		batalha_mostrador2.setBounds(74, 50, 189, 85);
		PainelBatalha.add(batalha_mostrador2);
		batalha_mostrador2.setLayout(null);
		batalha_mostrador2.setOpaque(false);
		
			JLabel mostrador2_nome = new JLabel(trainer1.getPool().getPokemon(0).getNome());
			mostrador2_nome.setForeground(Color.WHITE);
			mostrador2_nome.setFont(new Font("Monospaced", Font.BOLD, 18));
			mostrador2_nome.setBounds(33, 18, 140, 16);
			batalha_mostrador2.add(mostrador2_nome);
			
			JProgressBar mostrador2_hpBar = new JProgressBar();
			mostrador2_hpBar.setBounds(45, 57, 134, 12);
			batalha_mostrador2.add(mostrador2_hpBar);
		
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
		JLabel batalha_lblPlayer1 = new JLabel("");
		batalha_lblPlayer1.setBounds(57, 189, 282, 198);
			//Adicionando Icone
		batalha_lblPlayer1.setIcon(resize("/imagens/Pokemon/back/"+ trainer1.getPool().getPokemon(0).getId() +".png", batalha_lblPlayer1));
		PainelBatalha.add(batalha_lblPlayer1);
		
	//		Jogador 2
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(434, 38, 275, 219);
	//			Adicionando Icone
		lblPlayer2.setIcon(resize("/imagens/Pokemon/front/"+ trainer2.getPool().getPokemon(0).getId() +".png", lblPlayer2));
		PainelBatalha.add(lblPlayer2);
		
		
	//		Background de Batalha
		JLabel batalha_lblBackground = new JLabel("");
		batalha_lblBackground.setBounds(0, 0, 784, 369);
	//			Adicionando Icone
		batalha_lblBackground.setIcon(resize("/imagens/Background/Terreno/battles(1).png", batalha_lblBackground));
		PainelBatalha.add(batalha_lblBackground);
		
		
	//	Menu
		batalha_botoesPrincipais.setBounds(476, 380, 282, 70);
		batalha_botoesPrincipais.setOpaque(false);
		PainelBatalha.add(batalha_botoesPrincipais);
		
			JButton botoesPrincipais_btn1 = new JButton("Atacar");
			botoesPrincipais_btn1.setBounds(7, 7, 122, 26);
			botoesPrincipais_btn1.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn1));
			botoesPrincipais_btn1.setIconTextGap(-80);
			botoesPrincipais_btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botoesAtaque.setVisible(true);
					batalha_botoesPrincipais.setVisible(false);
					batalha_txtBox.setVisible(false);
					
				}
			});
			batalha_botoesPrincipais.setLayout(null);
			batalha_botoesPrincipais.add(botoesPrincipais_btn1);
			
			JButton botoesPrincipais_btn2 = new JButton("Trocar Pokemon");
			botoesPrincipais_btn2.setBounds(133, 7, 142, 26);
			botoesPrincipais_btn2.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn2));
			botoesPrincipais_btn2.setIconTextGap(-130);
			botoesPrincipais_btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(true);
					PainelItem.setVisible(false);
				}
			});
			batalha_botoesPrincipais.add(botoesPrincipais_btn2);
			
			JButton botoesPrincipais_btn3 = new JButton("Fugir");
			botoesPrincipais_btn3.setBounds(7, 37, 122, 26);
			botoesPrincipais_btn3.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn3));
			botoesPrincipais_btn3.setIconTextGap(-75);
			botoesPrincipais_btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			batalha_botoesPrincipais.add(botoesPrincipais_btn3);
			
			JButton botoesPrincipais_btn4 = new JButton("Usar Item");
			botoesPrincipais_btn4.setBounds(133, 37, 142, 26);
			botoesPrincipais_btn4.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn4));
			botoesPrincipais_btn4.setIconTextGap(-100);
			botoesPrincipais_btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PainelBatalha.setVisible(false);
					PainelPokePool.setVisible(false);
					PainelItem.setVisible(true);
					
					balls.setVisible(true);
					elix.setVisible(false);
					pots.setVisible(false);
					
				}
			});
			batalha_botoesPrincipais.add(botoesPrincipais_btn4);

		botoesAtaque.setBounds(25, 380, 733, 70);
		botoesAtaque.setOpaque(false);
		PainelBatalha.add(botoesAtaque);
		botoesAtaque.setLayout(null);
		
			JButton botoesAtaque_btn1 = new JButton();
			if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(0) != null){
				botoesAtaque_btn1.setLabel(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(0).getNome());
				botoesAtaque_btn1.setEnabled(true);
			}
			else botoesAtaque_btn1.setEnabled(false);
			botoesAtaque_btn1.setBounds(7, 7, 141, 56);
			botoesAtaque.add(botoesAtaque_btn1);
			
			JButton botoesAtaque_btn2 = new JButton();
			if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(1) != null){
				botoesAtaque_btn2.setLabel(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(1).getNome());
				botoesAtaque_btn2.setEnabled(true);
			}
			else botoesAtaque_btn2.setEnabled(false);
			botoesAtaque_btn2.setBounds(152, 7, 140, 56);
			botoesAtaque.add(botoesAtaque_btn2);
			
			JButton botoesAtaque_btn3 = new JButton();
			if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(2) != null){
				botoesAtaque_btn3.setLabel(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(2).getNome());
				botoesAtaque_btn3.setEnabled(true);
			}
			else botoesAtaque_btn3.setEnabled(false);
			botoesAtaque_btn3.setBounds(296, 7, 141, 56);
			botoesAtaque.add(botoesAtaque_btn3);
			
			JButton botoesAtaque_btn4 = new JButton();
			if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(3) != null){
				botoesAtaque_btn4.setLabel(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(3).getNome());
				botoesAtaque_btn4.setEnabled(true);
			}
			else botoesAtaque_btn4.setEnabled(false);
			botoesAtaque_btn4.setBounds(441, 7, 140, 56);
			botoesAtaque.add(botoesAtaque_btn4);
			
			JButton botoesAtaque_btnVoltar = new JButton("Voltar");
			botoesAtaque_btnVoltar.setBounds(585, 7, 141, 56);
			botoesAtaque_btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botoesAtaque.setVisible(false);
					batalha_botoesPrincipais.setVisible(true);
					batalha_txtBox.setVisible(true);
				}
			});
			botoesAtaque.add(botoesAtaque_btnVoltar);
		
		batalha_txtBox.setFont(new Font("Monospaced", Font.BOLD, 20));
		batalha_txtBox.setEditable(false);
		batalha_txtBox.setBackground(Color.WHITE);
		batalha_txtBox.setOpaque(false);
		batalha_txtBox.setText("O que quer fazer?");
		batalha_txtBox.setBounds(41, 380, 402, 70);
		PainelBatalha.add(batalha_txtBox);
		
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
			
			JButton btnPoke1 = new JButton();
			btnPoke1.setBounds(64, 24, 130, 23);
			poke1.add(btnPoke1);
			
			JLabel lblPoke1 = new JLabel();
			lblPoke1.setBounds(0, 0, 222, 103);
			lblPoke1.setIcon(resize("/imagens/Moldura/mostrador.png", lblPoke1));
			poke1.add(lblPoke1);
			
			if(trainer1.getPool().getPokemon(0) != null){
				btnPoke1.setLabel(trainer1.getPool().getPokemon(0).getNome());
				btnPoke1.setEnabled(true);
			}
			else btnPoke1.setEnabled(false);
			
		
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
			
			if(trainer1.getPool().getPokemon(1) != null){
				btnPoke2.setLabel(trainer1.getPool().getPokemon(1).getNome());
				btnPoke2.setEnabled(true);
			}
			else btnPoke2.setEnabled(false);
		
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
			
			if(trainer1.getPool().getPokemon(2) != null){
				btnPoke3.setLabel(trainer1.getPool().getPokemon(2).getNome());
				btnPoke3.setEnabled(true);
			}
			else btnPoke3.setEnabled(false);
		
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
			
			if(trainer1.getPool().getPokemon(3) != null){
				btnPoke4.setLabel(trainer1.getPool().getPokemon(3).getNome());
				btnPoke4.setEnabled(true);
			}
			else btnPoke4.setEnabled(false);
		
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
			
			if(trainer1.getPool().getPokemon(4) != null){
				btnPoke5.setLabel(trainer1.getPool().getPokemon(4).getNome());
				btnPoke5.setEnabled(true);
			}
			else btnPoke5.setEnabled(false);
			
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
			
			if(trainer1.getPool().getPokemon(5) != null){
				btnPoke6.setLabel(trainer1.getPool().getPokemon(5).getNome());
				btnPoke6.setEnabled(true);
			}
			else btnPoke6.setEnabled(false);
		
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
		
		
		balls.setBounds(0, 0, 611, 461);
		PainelItem.add(balls);
		balls.setLayout(null);
		balls.setOpaque(false);
		
			JLabel lbl_ball1 = new JLabel();
			lbl_ball1.setBounds(64, 0, 177, 177);
			lbl_ball1.setIcon(resize("/imagens/Item/poke-ball.png", lbl_ball1));
			balls.add(lbl_ball1);
			
			JLabel lbl_ball2 = new JLabel();
			lbl_ball2.setBounds(369, 0, 177, 177);
			lbl_ball2.setIcon(resize("/imagens/Item/great-ball.png", lbl_ball2));
			balls.add(lbl_ball2);
			
			JButton btn_ball1 = new JButton("Pokeball");
			btn_ball1.setBounds(0, 188, 305, 42);
			balls.add(btn_ball1);
			
			JButton btn_ball2 = new JButton("Greatball");
			btn_ball2.setBounds(305, 188, 305, 42);
			balls.add(btn_ball2);
			
			JLabel lbl_ball3 = new JLabel();
			lbl_ball3.setBounds(64, 230, 177, 177);
			lbl_ball3.setIcon(resize("/imagens/Item/ultra-ball.png", lbl_ball3));
			balls.add(lbl_ball3);
			
			JLabel lbl_ball4 = new JLabel();
			lbl_ball4.setBounds(369, 230, 177, 177);
			lbl_ball4.setIcon(resize("/imagens/Item/master-ball.png", lbl_ball4));
			balls.add(lbl_ball4);
			
			JButton btn_ball3 = new JButton("Ultraball");
			btn_ball3.setBounds(0, 418, 305, 42);
			balls.add(btn_ball3);
			
			JButton btn_ball4 = new JButton("Masterball");
			btn_ball4.setBounds(305, 418, 305, 42);
			balls.add(btn_ball4);
		
		pots.setBounds(0, 0, 610, 461);
		PainelItem.add(pots);
		pots.setLayout(null);
		pots.setOpaque(false);
		
			JLabel lbl_pot1 = new JLabel();
			lbl_pot1.setBounds(7, 29, 146, 146);
			lbl_pot1.setIcon(resize("/imagens/Item/potion.png", lbl_pot1));
			pots.add(lbl_pot1);
			
			JLabel lbl_pot2 = new JLabel();
			lbl_pot2.setBounds(157, 29, 146, 146);
			lbl_pot2.setIcon(resize("/imagens/Item/super-potion.png", lbl_pot2));
			pots.add(lbl_pot2);
			
			JLabel lbl_pot3 = new JLabel();
			lbl_pot3.setBounds(307, 29, 146, 146);
			lbl_pot3.setIcon(resize("/imagens/Item/hyper-potion.png", lbl_pot3));
			pots.add(lbl_pot3);
			
			JLabel lbl_pot4 = new JLabel();
			lbl_pot4.setBounds(457, 29, 146, 146);
			lbl_pot4.setIcon(resize("/imagens/Item/max-potion.png", lbl_pot4));
			pots.add(lbl_pot4);
			
			JButton btn_pot1 = new JButton("Potion");
			btn_pot1.setBounds(7, 186, 146, 23);
			pots.add(btn_pot1);
			
			JButton btn_pot2 = new JButton("Super Potion");
			btn_pot2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_pot2.setBounds(157, 186, 146, 23);
			pots.add(btn_pot2);
			
			JButton btn_pot3 = new JButton("Hyper Potion");
			btn_pot3.setBounds(307, 186, 146, 23);
			pots.add(btn_pot3);
			
			JButton btn_pot4 = new JButton("Max Potion");
			btn_pot4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot4.setBounds(457, 186, 146, 23);
			pots.add(btn_pot4);
			
			JLabel lbl_pot5 = new JLabel();
			lbl_pot5.setBounds(7, 270, 146, 146);
			lbl_pot5.setIcon(resize("/imagens/Item/full-restore.png", lbl_pot5));
			pots.add(lbl_pot5);
			
			JLabel lbl_pot6 = new JLabel();
			lbl_pot6.setBounds(157, 270, 146, 146);
			lbl_pot6.setIcon(resize("/imagens/Item/fresh-water.png", lbl_pot6));
			pots.add(lbl_pot6);
			
			JLabel lbl_pot7 = new JLabel();
			lbl_pot7.setBounds(307, 270, 146, 146);
			lbl_pot7.setIcon(resize("/imagens/Item/soda-pop.png", lbl_pot7));
			pots.add(lbl_pot7);
			
			JLabel lbl_pot8 = new JLabel();
			lbl_pot8.setBounds(457, 270, 146, 146);
			lbl_pot8.setIcon(resize("/imagens/Item/lemonade.png", lbl_pot8));
			pots.add(lbl_pot8);
			
			JButton btn_pot5 = new JButton("Full Restore");
			btn_pot5.setBounds(7, 427, 146, 23);
			pots.add(btn_pot5);
			
			JButton btn_pot6 = new JButton("Fresh Water");
			btn_pot6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_pot6.setBounds(157, 427, 146, 23);
			pots.add(btn_pot6);
			
			JButton btn_pot7 = new JButton("Soda Pop");
			btn_pot7.setBounds(307, 427, 146, 23);
			pots.add(btn_pot7);
			
			JButton btn_pot8 = new JButton("Lemonade");
			btn_pot8.setBounds(457, 427, 146, 23);
			pots.add(btn_pot8);
		
		elix.setBounds(0, 0, 611, 461);
		PainelItem.add(elix);
		elix.setLayout(null);
		elix.setOpaque(false);
		
			JLabel lbl_elix1 = new JLabel();
			lbl_elix1.setBounds(64, 0, 177, 177);
			lbl_elix1.setIcon(resize("/imagens/Item/ether.png", lbl_elix1));
			elix.add(lbl_elix1);
			
			JLabel lbl_elix2 = new JLabel();
			lbl_elix2.setBounds(369, 0, 177, 177);
			lbl_elix2.setIcon(resize("/imagens/Item/max-ether.png", lbl_elix2));
			elix.add(lbl_elix2);
			
			JButton btn_elix1 = new JButton("Ether");
			btn_elix1.setBounds(0, 188, 305, 42);
			elix.add(btn_elix1);
			
			JButton btn_elix2 = new JButton("Max Ether");
			btn_elix2.setBounds(305, 188, 305, 42);
			elix.add(btn_elix2);
			
			JLabel lbl_elix3 = new JLabel();
			lbl_elix3.setBounds(64, 230, 177, 177);
			lbl_elix3.setIcon(resize("/imagens/Item/elixir.png", lbl_elix3));
			elix.add(lbl_elix3);
			
			JLabel lbl_elix4 = new JLabel();
			lbl_elix4.setBounds(369, 230, 177, 177);
			lbl_elix4.setIcon(resize("/imagens/Item/max-elixir.png", lbl_elix4));
			elix.add(lbl_elix4);
			
			JButton btn_elix3 = new JButton("Elixir");
			btn_elix3.setBounds(0, 418, 305, 42);
			elix.add(btn_elix3);
			
			JButton btn_elix4 = new JButton("Max Elixir");
			btn_elix4.setBounds(305, 418, 305, 42);
			elix.add(btn_elix4);
			
			
		JButton btn_item1 = new JButton("Balls");
		btn_item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				balls.setVisible(true);
				pots.setVisible(false);
				elix.setVisible(false);
			}
		});
		btn_item1.setBounds(621, 11, 153, 86);
		PainelItem.add(btn_item1);
		
		JButton btn_item2 = new JButton("Pots");
		btn_item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balls.setVisible(false);
				pots.setVisible(true);
				elix.setVisible(false);
			}
		});
		btn_item2.setBounds(621, 129, 153, 86);
		PainelItem.add(btn_item2);
		
		JButton btn_item3 = new JButton("Elix");
		btn_item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balls.setVisible(false);
				pots.setVisible(false);
				elix.setVisible(true);
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
		batalha_botoesPrincipais.setVisible(true);
		botoesAtaque.setVisible(false);
	
	}
}
