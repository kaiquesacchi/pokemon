package pokemon;

import java.awt.Color;
import java.awt.Container;
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
		
		
		
	
		
	//	DeclaraÃ§ao dos Paineis	
		JPanel painelBatalha = new JPanel();
		JPanel painelPokePool = new JPanel();
		JPanel painelItem = new JPanel();
		JPanel batalha_botoesPrincipais = new JPanel();
		JPanel batalha_botoesAtaque = new JPanel();
		JPanel batalha_botaoAvancar = new JPanel();
		JTextPane batalha_txtBox = new JTextPane();
		batalha_txtBox.setForeground(Color.WHITE);
		JPanel item_balls = new JPanel();
		JPanel item_pots = new JPanel();
		JPanel item_elix = new JPanel();
		
	/*
	 * PRIMEIRO PAINEL ====== BATALHA
	 */ 	
		
		painelBatalha.setBounds(0, 0, 784, 461);
		painelBatalha.setLayout(null);
		container.add(painelBatalha);
	
		
	//	Mostradores
		JPanel batalha_mostrador1 = new JPanel();
		batalha_mostrador1.setBounds(552, 256, 189, 79);
		painelBatalha.add(batalha_mostrador1);
		batalha_mostrador1.setLayout(null);
		batalha_mostrador1.setOpaque(false);

			JLabel mostrador1_nome = new JLabel(trainer1.getPool().getPokemon(0).getNome());
			mostrador1_nome.setForeground(Color.WHITE);
			mostrador1_nome.setFont(new Font("Monospaced", Font.BOLD, 18));
			mostrador1_nome.setBounds(30, 11, 149, 14);
			batalha_mostrador1.add(mostrador1_nome);
			
			JProgressBar mostrador1_hpBar = new JProgressBar();
			mostrador1_hpBar.setBounds(45, 50, 134, 12);
			mostrador1_hpBar.setForeground(Color.GREEN);
			batalha_mostrador1.add(mostrador1_hpBar);
				
		JPanel batalha_mostrador2 = new JPanel();
		batalha_mostrador2.setBackground(Color.WHITE);
		batalha_mostrador2.setBounds(74, 50, 189, 85);
		painelBatalha.add(batalha_mostrador2);
		batalha_mostrador2.setLayout(null);
		batalha_mostrador2.setOpaque(false);
		
			JLabel mostrador2_nome = new JLabel(trainer1.getPool().getPokemon(0).getNome());
			mostrador2_nome.setForeground(Color.WHITE);
			mostrador2_nome.setFont(new Font("Monospaced", Font.BOLD, 18));
			mostrador2_nome.setBounds(33, 18, 140, 16);
			batalha_mostrador2.add(mostrador2_nome);
			
			JProgressBar mostrador2_hpBar = new JProgressBar();
			mostrador2_hpBar.setBounds(45, 57, 134, 12);
			mostrador2_hpBar.setForeground(Color.GREEN);
			batalha_mostrador2.add(mostrador2_hpBar);
		
		JLabel batalha_lblMostrador1 = new JLabel("");
		batalha_lblMostrador1.setBounds(519, 242, 222, 93);
		painelBatalha.add(batalha_lblMostrador1);
		//Adicionando Icone
		batalha_lblMostrador1.setIcon(resize("/imagens/Moldura/mostrador.png", batalha_lblMostrador1));
		
		JLabel batalha_lblMostrador2 = new JLabel("");
		batalha_lblMostrador2.setBounds(41, 42, 222, 93);
		painelBatalha.add(batalha_lblMostrador2);
		//Adicionando Icone
		batalha_lblMostrador2.setIcon(resize("/imagens/Moldura/mostrador.png", batalha_lblMostrador2));
		
		
		
	//	Imagens		
		
	//		Jogador 1
		JLabel batalha_lblPlayer1 = new JLabel("");
		batalha_lblPlayer1.setBounds(57, 189, 282, 198);
			//Adicionando Icone
		painelBatalha.add(batalha_lblPlayer1);
		
	//		Jogador 2
		JLabel batalha_lblPlayer2 = new JLabel("");
		batalha_lblPlayer2.setBounds(434, 38, 275, 219);
	//			Adicionando Icone
		painelBatalha.add(batalha_lblPlayer2);
		
		
	//		Background de Batalha
		JLabel batalha_lblBackground = new JLabel("");
		batalha_lblBackground.setBounds(0, 0, 784, 369);
	//			Adicionando Icone
		batalha_lblBackground.setIcon(resize("/imagens/Background/Terreno/battles(1).png", batalha_lblBackground));
		painelBatalha.add(batalha_lblBackground);
		
		
	//	Menu
		batalha_botoesPrincipais.setBounds(476, 380, 282, 70);
		batalha_botoesPrincipais.setOpaque(false);
		painelBatalha.add(batalha_botoesPrincipais);
		
			JButton botoesPrincipais_btn1 = new JButton("Atacar");
			botoesPrincipais_btn1.setBounds(7, 7, 122, 26);
			botoesPrincipais_btn1.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn1));
			botoesPrincipais_btn1.setIconTextGap(-80);
			batalha_botoesPrincipais.setLayout(null);
			batalha_botoesPrincipais.add(botoesPrincipais_btn1);
			
			JButton botoesPrincipais_btn2 = new JButton("Trocar Pokemon");
			botoesPrincipais_btn2.setBounds(133, 7, 142, 26);
			botoesPrincipais_btn2.setIcon(resize("/imagens/Botoes/Botao.png", botoesPrincipais_btn2));
			botoesPrincipais_btn2.setIconTextGap(-130);
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
					painelBatalha.setVisible(false);
					painelPokePool.setVisible(false);
					painelItem.setVisible(true);
					
					item_balls.setVisible(true);
					item_elix.setVisible(false);
					item_pots.setVisible(false);
					
				}
			});
			batalha_botoesPrincipais.add(botoesPrincipais_btn4);

		batalha_botoesAtaque.setBounds(25, 380, 733, 70);
		batalha_botoesAtaque.setOpaque(false);
		painelBatalha.add(batalha_botoesAtaque);
		batalha_botoesAtaque.setLayout(null);
		
			JButton botoesAtaque_btn1 = new JButton();
			botoesAtaque_btn1.setBounds(7, 7, 141, 56);
			batalha_botoesAtaque.add(botoesAtaque_btn1);
			JButton botoesAtaque_btn2 = new JButton();
			botoesAtaque_btn2.setBounds(152, 7, 140, 56);
			batalha_botoesAtaque.add(botoesAtaque_btn2);
			JButton botoesAtaque_btn3 = new JButton();	
			botoesAtaque_btn3.setBounds(296, 7, 141, 56);
			batalha_botoesAtaque.add(botoesAtaque_btn3);
			JButton botoesAtaque_btn4 = new JButton();
			JButton botoesAtaque_btnVoltar = new JButton("Voltar");
			botoesAtaque_btnVoltar.setBounds(585, 7, 141, 56);
			botoesAtaque_btn4.setBounds(441, 7, 140, 56);
			batalha_botoesAtaque.add(botoesAtaque_btn4);
			
			botoesAtaque_btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					batalha_botoesAtaque.setVisible(false);
					batalha_botoesPrincipais.setVisible(true);
					batalha_txtBox.setVisible(true);
				}
			});
			batalha_botoesAtaque.add(botoesAtaque_btnVoltar);
		
		batalha_txtBox.setFont(new Font("Monospaced", Font.BOLD, 20));
		batalha_txtBox.setEditable(false);
		batalha_txtBox.setBackground(Color.WHITE);
		batalha_txtBox.setOpaque(false);
		batalha_txtBox.setText("O que quer fazer?");
		batalha_txtBox.setBounds(41, 380, 402, 70);
		painelBatalha.add(batalha_txtBox);
		
		batalha_botaoAvancar.setBounds(25, 380, 733, 70);
		batalha_botaoAvancar.setOpaque(false);
		painelBatalha.add(batalha_botaoAvancar);
		batalha_botaoAvancar.setLayout(null);
		
			JButton botaoAvancar_btnOk = new JButton("Continuar");
			botaoAvancar_btnOk.setBounds(585, 7, 141, 56);
			botaoAvancar_btnOk.setIcon(resize("/imagens/Botoes/Botao.png", botaoAvancar_btnOk));
			botaoAvancar_btnOk.setIconTextGap(-95);
			botaoAvancar_btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		batalha_botaoAvancar.add(botaoAvancar_btnOk);
		
		
		JLabel batalha_lblMenuBackground = new JLabel("");
		batalha_lblMenuBackground.setBounds(0, 368, 784, 93);
		batalha_lblMenuBackground.setIcon(resize("/imagens/Menu/Frame.png", batalha_lblMenuBackground));
		painelBatalha.add(batalha_lblMenuBackground);
	/*
	 * FIM PRIMEIRO PAINEL ====== BATALHA
	 */
		
	 
	 
	/*
	 * SEGUNDO PAINEL ====== TROCAR POKEMON
	 */
		
		painelPokePool.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(painelPokePool);
		painelPokePool.setLayout(null);
		
		JPanel pokepool_poke1 = new JPanel();
		pokepool_poke1.setBounds(41, 32, 222, 103);
		painelPokePool.add(pokepool_poke1);
			pokepool_poke1.setLayout(null);
			pokepool_poke1.setOpaque(false);
		
			JProgressBar poke1_hpBar = new JProgressBar();
			poke1_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke1.add(poke1_hpBar);
			
			JButton poke1_btn = new JButton();
			poke1_btn.setBounds(64, 24, 130, 23);
			pokepool_poke1.add(poke1_btn);
			
			JLabel poke1_lbl = new JLabel();
			poke1_lbl.setBounds(0, 0, 222, 103);
			poke1_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke1_lbl));
			pokepool_poke1.add(poke1_lbl);
			
		
		JPanel pokepool_poke2 = new JPanel();
		pokepool_poke2.setBounds(41, 158, 222, 103);
		painelPokePool.add(pokepool_poke2);
		pokepool_poke2.setLayout(null);
		pokepool_poke2.setOpaque(false);
		
			JProgressBar poke2_hpBar = new JProgressBar();
			poke2_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke2.add(poke2_hpBar);
			
			JButton poke2_btn = new JButton("New button");
			poke2_btn.setBounds(64, 24, 130, 23);
			pokepool_poke2.add(poke2_btn);
			
			JLabel poke2_lbl = new JLabel();
			poke2_lbl.setBounds(0, 0, 222, 103);
			poke2_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke2_lbl));
			pokepool_poke2.add(poke2_lbl);
		
		
		JPanel pokepool_poke3 = new JPanel();
		pokepool_poke3.setBounds(41, 294, 222, 103);
		painelPokePool.add(pokepool_poke3);
		pokepool_poke3.setLayout(null);
		pokepool_poke3.setOpaque(false);
		
			JProgressBar poke3_hpBar = new JProgressBar();
			poke3_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke3.add(poke3_hpBar);
			
			JButton poke3_btn = new JButton("New button");
			poke3_btn.setBounds(64, 24, 130, 23);
			pokepool_poke3.add(poke3_btn);
			
			JLabel poke3_lbl = new JLabel();
			poke3_lbl.setBounds(0, 0, 222, 103);
			poke3_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke3_lbl));
			pokepool_poke3.add(poke3_lbl);
			
		
		JPanel pokepool_poke4 = new JPanel();
		pokepool_poke4.setBounds(510, 32, 222, 103);
		painelPokePool.add(pokepool_poke4);
		pokepool_poke4.setLayout(null);
		pokepool_poke4.setOpaque(false);
		
			JProgressBar poke4_hpBar = new JProgressBar();
			poke4_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke4.add(poke4_hpBar);
			
			JButton poke4_btn = new JButton("New button");
			poke4_btn.setBounds(64, 24, 130, 23);
			pokepool_poke4.add(poke4_btn);
			
			JLabel poke4_lbl = new JLabel();
			poke4_lbl.setBounds(0, 0, 222, 103);
			poke4_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke4_lbl));
			pokepool_poke4.add(poke4_lbl);
			
		
		JPanel pokepool_poke5 = new JPanel();
		pokepool_poke5.setBounds(510, 158, 222, 103);
		painelPokePool.add(pokepool_poke5);
		pokepool_poke5.setLayout(null);
		pokepool_poke5.setOpaque(false);
		
			JProgressBar poke5_hpBar = new JProgressBar();
			poke5_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke5.add(poke5_hpBar);
			
			JButton poke5_btn = new JButton("New button");
			poke5_btn.setBounds(64, 24, 130, 23);
			pokepool_poke5.add(poke5_btn);
			
			JLabel poke5_lbl = new JLabel();
			poke5_lbl.setBounds(0, 0, 222, 103);
			poke5_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke5_lbl));
			pokepool_poke5.add(poke5_lbl);
			
			
		JPanel pokepool_poke6 = new JPanel();
		pokepool_poke6.setBounds(510, 294, 222, 103);
		painelPokePool.add(pokepool_poke6);
		pokepool_poke6.setLayout(null);
		pokepool_poke6.setOpaque(false);
		
			JProgressBar poke6_hpBar = new JProgressBar();
			poke6_hpBar.setBounds(80, 72, 130, 12);
			pokepool_poke6.add(poke6_hpBar);
			
			JButton poke6_btn = new JButton("New button");
			poke6_btn.setBounds(64, 24, 130, 23);
			pokepool_poke6.add(poke6_btn);
			
			JLabel poke6_lbl = new JLabel();
			poke6_lbl.setBounds(0, 0, 222, 103);
			poke6_lbl.setIcon(resize("/imagens/Moldura/mostrador.png", poke6_lbl));
			pokepool_poke6.add(poke6_lbl);
			
		
		JButton pokepool_btnCancelar = new JButton("Cancelar");
		pokepool_btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelBatalha.setVisible(true);
				painelPokePool.setVisible(false);
			}
		});
		pokepool_btnCancelar.setBounds(643, 427, 89, 23);
		painelPokePool.add(pokepool_btnCancelar);
		
		JLabel pokepool_lblBackground = new JLabel("");
		pokepool_lblBackground.setBounds(0, 0, 784, 461);
		pokepool_lblBackground.setIcon(resize("/imagens/Background/Menu/Itens.png", pokepool_lblBackground));
		painelPokePool.add(pokepool_lblBackground);
	
	/*
	 * FIM SEGUNDO PAINEL ====== TROCAR POKEMON
	 */	
		

		
	/*
	 * TERCEIRO PAINEL ====== ITENS
	 */	
		
		painelItem.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(painelItem);
		painelItem.setLayout(null);
		
		
		item_balls.setBounds(0, 0, 611, 461);
		painelItem.add(item_balls);
		item_balls.setLayout(null);
		item_balls.setOpaque(false);
		
			JLabel balls_lbl1 = new JLabel();
			balls_lbl1.setBounds(64, 0, 177, 177);
			balls_lbl1.setIcon(resize("/imagens/Item/poke-ball.png", balls_lbl1));
			item_balls.add(balls_lbl1);
			
			JLabel balls_lbl2 = new JLabel();
			balls_lbl2.setBounds(369, 0, 177, 177);
			balls_lbl2.setIcon(resize("/imagens/Item/great-ball.png", balls_lbl2));
			item_balls.add(balls_lbl2);
			
			JButton balls_btn1 = new JButton("Pokeball");
			balls_btn1.setBounds(0, 188, 305, 42);
			item_balls.add(balls_btn1);
			
			JButton balls_btn2 = new JButton("Greatball");
			balls_btn2.setBounds(305, 188, 305, 42);
			item_balls.add(balls_btn2);
			
			JLabel balls_lbl3 = new JLabel();
			balls_lbl3.setBounds(64, 230, 177, 177);
			balls_lbl3.setIcon(resize("/imagens/Item/ultra-ball.png", balls_lbl3));
			item_balls.add(balls_lbl3);
			
			JLabel balls_lbl4 = new JLabel();
			balls_lbl4.setBounds(369, 230, 177, 177);
			balls_lbl4.setIcon(resize("/imagens/Item/master-ball.png", balls_lbl4));
			item_balls.add(balls_lbl4);
			
			JButton balls_btn3 = new JButton("Ultraball");
			balls_btn3.setBounds(0, 418, 305, 42);
			item_balls.add(balls_btn3);
			
			JButton balls_btn4 = new JButton("Masterball");
			balls_btn4.setBounds(305, 418, 305, 42);
			item_balls.add(balls_btn4);
		
		item_pots.setBounds(0, 0, 610, 461);
		painelItem.add(item_pots);
		item_pots.setLayout(null);
		item_pots.setOpaque(false);
		
			JLabel pots_lbl1 = new JLabel();
			pots_lbl1.setBounds(7, 29, 146, 146);
			pots_lbl1.setIcon(resize("/imagens/Item/potion.png", pots_lbl1));
			item_pots.add(pots_lbl1);
			
			JLabel pots_lbl2 = new JLabel();
			pots_lbl2.setBounds(157, 29, 146, 146);
			pots_lbl2.setIcon(resize("/imagens/Item/super-potion.png", pots_lbl2));
			item_pots.add(pots_lbl2);
			
			JLabel pots_lbl3 = new JLabel();
			pots_lbl3.setBounds(307, 29, 146, 146);
			pots_lbl3.setIcon(resize("/imagens/Item/hyper-potion.png", pots_lbl3));
			item_pots.add(pots_lbl3);
			
			JLabel pots_lbl4 = new JLabel();
			pots_lbl4.setBounds(457, 29, 146, 146);
			pots_lbl4.setIcon(resize("/imagens/Item/max-potion.png", pots_lbl4));
			item_pots.add(pots_lbl4);
			
			JButton pots_btn1 = new JButton("Potion");
			pots_btn1.setBounds(7, 186, 146, 23);
			item_pots.add(pots_btn1);
			
			JButton pots_btn2 = new JButton("Super Potion");
			pots_btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			pots_btn2.setBounds(157, 186, 146, 23);
			item_pots.add(pots_btn2);
			
			JButton pots_btn3 = new JButton("Hyper Potion");
			pots_btn3.setBounds(307, 186, 146, 23);
			item_pots.add(pots_btn3);
			
			JButton pots_btn4 = new JButton("Max Potion");
			pots_btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			pots_btn4.setBounds(457, 186, 146, 23);
			item_pots.add(pots_btn4);
			
			JLabel pots_lbl5 = new JLabel();
			pots_lbl5.setBounds(7, 270, 146, 146);
			pots_lbl5.setIcon(resize("/imagens/Item/full-restore.png", pots_lbl5));
			item_pots.add(pots_lbl5);
			
			JLabel pots_lbl6 = new JLabel();
			pots_lbl6.setBounds(157, 270, 146, 146);
			pots_lbl6.setIcon(resize("/imagens/Item/fresh-water.png", pots_lbl6));
			item_pots.add(pots_lbl6);
			
			JLabel pots_lbl7 = new JLabel();
			pots_lbl7.setBounds(307, 270, 146, 146);
			pots_lbl7.setIcon(resize("/imagens/Item/soda-pop.png", pots_lbl7));
			item_pots.add(pots_lbl7);
			
			JLabel pots_lbl8 = new JLabel();
			pots_lbl8.setBounds(457, 270, 146, 146);
			pots_lbl8.setIcon(resize("/imagens/Item/lemonade.png", pots_lbl8));
			item_pots.add(pots_lbl8);
			
			JButton pots_btn5 = new JButton("Full Restore");
			pots_btn5.setBounds(7, 427, 146, 23);
			item_pots.add(pots_btn5);
			
			JButton pots_btn6 = new JButton("Fresh Water");
			pots_btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			pots_btn6.setBounds(157, 427, 146, 23);
			item_pots.add(pots_btn6);
			
			JButton pots_btn7 = new JButton("Soda Pop");
			pots_btn7.setBounds(307, 427, 146, 23);
			item_pots.add(pots_btn7);
			
			JButton pots_btn8 = new JButton("Lemonade");
			pots_btn8.setBounds(457, 427, 146, 23);
			item_pots.add(pots_btn8);
		
		item_elix.setBounds(0, 0, 611, 461);
		painelItem.add(item_elix);
		item_elix.setLayout(null);
		item_elix.setOpaque(false);
		
			JLabel elix_lbl1 = new JLabel();
			elix_lbl1.setBounds(64, 0, 177, 177);
			elix_lbl1.setIcon(resize("/imagens/Item/ether.png", elix_lbl1));
			item_elix.add(elix_lbl1);
			
			JLabel elix_lbl2 = new JLabel();
			elix_lbl2.setBounds(369, 0, 177, 177);
			elix_lbl2.setIcon(resize("/imagens/Item/max-ether.png", elix_lbl2));
			item_elix.add(elix_lbl2);
			
			JButton elix_btn1 = new JButton("Ether");
			elix_btn1.setBounds(0, 188, 305, 42);
			item_elix.add(elix_btn1);
			
			JButton elix_btn2 = new JButton("Max Ether");
			elix_btn2.setBounds(305, 188, 305, 42);
			item_elix.add(elix_btn2);
			
			JLabel elix_lbl3 = new JLabel();
			elix_lbl3.setBounds(64, 230, 177, 177);
			elix_lbl3.setIcon(resize("/imagens/Item/elixir.png", elix_lbl3));
			item_elix.add(elix_lbl3);
			
			JLabel elix_lbl4 = new JLabel();
			elix_lbl4.setBounds(369, 230, 177, 177);
			elix_lbl4.setIcon(resize("/imagens/Item/max-elixir.png", elix_lbl4));
			item_elix.add(elix_lbl4);
			
			JButton elix_btn3 = new JButton("Elixir");
			elix_btn3.setBounds(0, 418, 305, 42);
			item_elix.add(elix_btn3);
			
			JButton elix_btn4 = new JButton("Max Elixir");
			elix_btn4.setBounds(305, 418, 305, 42);
			item_elix.add(elix_btn4);
			
			
		JButton item_btn1 = new JButton("Balls");
		item_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				item_balls.setVisible(true);
				item_pots.setVisible(false);
				item_elix.setVisible(false);
			}
		});
		item_btn1.setBounds(621, 11, 153, 86);
		painelItem.add(item_btn1);
		
		JButton item_btn2 = new JButton("Pots");
		item_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_balls.setVisible(false);
				item_pots.setVisible(true);
				item_elix.setVisible(false);
			}
		});
		item_btn2.setBounds(621, 129, 153, 86);
		painelItem.add(item_btn2);
		
		JButton item_btn3 = new JButton("Elix");
		item_btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_balls.setVisible(false);
				item_pots.setVisible(false);
				item_elix.setVisible(true);
			}
		});
		item_btn3.setBounds(621, 245, 153, 86);
		painelItem.add(item_btn3);
		
		JButton item_btnVoltar = new JButton("Voltar");
		item_btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelBatalha.setVisible(true);
				painelPokePool.setVisible(false);
				painelItem.setVisible(false);
			}
		});
		item_btnVoltar.setBounds(621, 364, 153, 86);
		painelItem.add(item_btnVoltar);
		
		JLabel item_lblBackground = new JLabel();
		item_lblBackground.setBounds(0, 0, 784, 461);
		item_lblBackground.setIcon(resize("/imagens/Background/Menu/Itens.png", item_lblBackground));
		painelItem.add(item_lblBackground);
		
		
		/*
		 * FIM TERCEIRO PAINEL ====== ITENS
		 */
		
		
		
		/*
		 * INICIO DA BATALHA
		 */
		
		//Aviso de começo de batalha
		painelBatalha.setVisible(true);
		painelPokePool.setVisible(false);
		painelItem.setVisible(false);
		
		batalha_botoesPrincipais.setVisible(false);
		batalha_botoesAtaque.setVisible(false);
		batalha_botaoAvancar.setVisible(true);
		batalha_txtBox.setVisible(true);
		batalha_mostrador1.setVisible(false);
		batalha_mostrador2.setVisible(false);
		batalha_lblMostrador1.setVisible(false);
		batalha_lblMostrador2.setVisible(false);
		batalha_txtBox.setText("Você foi desafiado para uma batalha Pokemon!");
		botaoAvancar_btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batalha_botoesPrincipais.setVisible(true);
				batalha_botaoAvancar.setVisible(false);
				batalha_txtBox.setText("O que quer fazer?");
				
				batalha_lblPlayer1.setIcon(resize("/imagens/Pokemon/back/"+ trainer1.getPool().getPokemon(0).getId() +".png", batalha_lblPlayer1));
				batalha_lblPlayer2.setIcon(resize("/imagens/Pokemon/front/"+ trainer2.getPool().getPokemon(0).getId() +".png", batalha_lblPlayer2));
				batalha_mostrador1.setVisible(true);
				batalha_mostrador2.setVisible(true);
				batalha_lblMostrador1.setVisible(true);
				batalha_lblMostrador2.setVisible(true);
				mostrador1_nome.setText(trainer1.getPool().getPokemon(0).getNome());
				mostrador1_hpBar.setMaximum(trainer1.getPool().getPokemon(0).getMaxHp());
				mostrador1_hpBar.setValue(trainer1.getPool().getPokemon(0).getCurHp());
				mostrador2_nome.setText(trainer2.getPool().getPokemon(0).getNome());
				mostrador2_hpBar.setMaximum(trainer2.getPool().getPokemon(0).getMaxHp());
				mostrador2_hpBar.setValue(trainer2.getPool().getPokemon(0).getCurHp());
			}
		});
		
		//Funcoes Botoes Principais
			//Atacar
		botoesPrincipais_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batalha_botoesAtaque.setVisible(true);
				batalha_botoesPrincipais.setVisible(false);
				batalha_txtBox.setVisible(false);
				
				
				if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(0) != null){
					botoesAtaque_btn1.setText(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(0).getNome());
					botoesAtaque_btn1.setEnabled(true);
				}
				else{
					botoesAtaque_btn1.setText("");
					botoesAtaque_btn1.setEnabled(false);
				}
		
				if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(1) != null){
					botoesAtaque_btn2.setText(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(1).getNome());
					botoesAtaque_btn2.setEnabled(true);
				}
				else{
					botoesAtaque_btn2.setText("");
					botoesAtaque_btn2.setEnabled(false);
				}
			
				if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(2) != null){
					botoesAtaque_btn3.setText(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(2).getNome());
					botoesAtaque_btn3.setEnabled(true);
				}
				else{
					botoesAtaque_btn3.setText("");
					botoesAtaque_btn3.setEnabled(false);
				}
			
				if(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(3) != null){
					botoesAtaque_btn4.setText(trainer1.getPool().getPokemon(0).getAtkPool().getAtaqueAtualX(3).getNome());
					botoesAtaque_btn4.setEnabled(true);
				}
				else{
					botoesAtaque_btn4.setText("");
					botoesAtaque_btn4.setEnabled(false);
				}

			}
		});
		
			//Trocar Pokemon
		botoesPrincipais_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelBatalha.setVisible(false);
				painelPokePool.setVisible(true);
				painelItem.setVisible(false);
				
				if(trainer1.getPool().getPokemon(0) != null){
					poke1_btn.setText(trainer1.getPool().getPokemon(0).getNome());
					poke1_hpBar.setMaximum(trainer1.getPool().getPokemon(0).getMaxHp());
					poke1_hpBar.setValue(trainer1.getPool().getPokemon(0).getCurHp());
					if(trainer1.getPool().getPokemon(0).getCurHp() == 0) poke1_btn.setEnabled(false);
				}
				poke1_btn.setEnabled(false);
				if(trainer1.getPool().getPokemon(1) != null){
					poke2_btn.setText(trainer1.getPool().getPokemon(1).getNome());
					poke2_btn.setEnabled(true);
					poke2_hpBar.setMaximum(trainer1.getPool().getPokemon(1).getMaxHp());
					poke2_hpBar.setValue(trainer1.getPool().getPokemon(1).getCurHp());
					if(trainer1.getPool().getPokemon(1).getCurHp() == 0) poke2_btn.setEnabled(false);
				}
				else poke2_btn.setEnabled(false);
				if(trainer1.getPool().getPokemon(2) != null){
					poke3_btn.setText(trainer1.getPool().getPokemon(2).getNome());
					poke3_btn.setEnabled(true);
					poke3_hpBar.setMaximum(trainer1.getPool().getPokemon(2).getMaxHp());
					poke3_hpBar.setValue(trainer1.getPool().getPokemon(2).getCurHp());
					if(trainer1.getPool().getPokemon(2).getCurHp() == 0) poke3_btn.setEnabled(false);
				}
				else poke3_btn.setEnabled(false);
				if(trainer1.getPool().getPokemon(3) != null){
					poke4_btn.setText(trainer1.getPool().getPokemon(3).getNome());
					poke4_btn.setEnabled(true);
					poke4_hpBar.setMaximum(trainer1.getPool().getPokemon(3).getMaxHp());
					poke4_hpBar.setValue(trainer1.getPool().getPokemon(3).getCurHp());
					if(trainer1.getPool().getPokemon(3).getCurHp() == 0) poke4_btn.setEnabled(false);
				}
				else poke4_btn.setEnabled(false);
				if(trainer1.getPool().getPokemon(4) != null){
					poke5_btn.setText(trainer1.getPool().getPokemon(4).getNome());
					poke5_btn.setEnabled(true);
					poke5_hpBar.setMaximum(trainer1.getPool().getPokemon(4).getMaxHp());
					poke5_hpBar.setValue(trainer1.getPool().getPokemon(4).getCurHp());
					if(trainer1.getPool().getPokemon(4).getCurHp() == 0) poke5_btn.setEnabled(false);
				}
				else poke5_btn.setEnabled(false);
				if(trainer1.getPool().getPokemon(5) != null){
					poke6_btn.setText(trainer1.getPool().getPokemon(5).getNome());
					poke6_btn.setEnabled(true);
					poke6_hpBar.setMaximum(trainer1.getPool().getPokemon(5).getMaxHp());
					poke6_hpBar.setValue(trainer1.getPool().getPokemon(5).getCurHp());
					if(trainer1.getPool().getPokemon(5).getCurHp() == 0) poke1_btn.setEnabled(false);
				}
				else poke6_btn.setEnabled(false);
			}
		});

			
		
		//Açoes
			//Trocar Pokemon
		poke2_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainer1.getPool().switchPokemon(1);
				batalha_lblPlayer1.setIcon(resize("/imagens/Pokemon/back/"+ trainer1.getPool().getPokemon(0).getId() +".png", batalha_lblPlayer1));
				mostrador1_nome.setText(trainer1.getPool().getPokemon(0).getNome());
				mostrador1_hpBar.setMaximum(trainer1.getPool().getPokemon(0).getMaxHp());
				mostrador1_hpBar.setValue(trainer1.getPool().getPokemon(0).getCurHp());
				
				painelBatalha.setVisible(true);
				painelPokePool.setVisible(false);
				batalha_botoesPrincipais.setVisible(false);
				
				
				pokepool_btnCancelar.doClick();
			}
		});
	
	}
}
