package TTT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TicTacToe extends JFrame implements ActionListener{
		
											
		JPanel[] row = new JPanel[6];				//your panel have 6 rows
		JButton[] button = new JButton[12];			//your panel have 12 buttons
		Dimension regularDimension = new Dimension(40, 40);		//defining object for dimension
		Dimension zeroButDimension = new Dimension(250, 35);
		Font font = new Font("Times new Roman", Font.CENTER_BASELINE, 14);
		Player player1 = new Player(Start.player1_name,Start.player1_symbol);
		Player player2 = new Player(Start.player2_name,Start.player2_symbol);
		Board board = new Board(player1.symbol, player2.symbol);
		boolean player1Turn = true; 
		boolean done = false;
		
		public TicTacToe() {
			
			super("TIC TAC TOE"); 
			setDesign();
			setSize(300,300);
			setLocation(500, 100);
			setResizable(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);        
			GridLayout grid = new GridLayout(6,3);
			setLayout(grid);
			FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,12,3);
			FlowLayout f3 = new FlowLayout(FlowLayout.CENTER,12,0);
			for(int i = 0; i < 6; i++) {
				row[i] = new JPanel();
			}

			row[0].setLayout(f3);

			for(int i = 1; i < 4; i++)
				row[i].setLayout(f2);

			row[4].setLayout(f3);
			for(int i = 0; i < 12; i++) {
				button[i] = new JButton();
				button[i].setText("");
				button[i].setFont(font);
				button[i].setFocusable(true);
				button[i].setBackground(Color.white);
				button[i].addActionListener(this);
			}
		
			
			button[0].setBackground(Color.cyan);
			button[10].setBackground(Color.cyan);
			button[11].setBackground(Color.gray);
			
			
			for(int i = 1; i < 11; i++)
				button[i].setPreferredSize(regularDimension);
			
			button[0].setText(Start.player1_name+"'s Turn");
			button[0].setPreferredSize(zeroButDimension);
			
			button[10].setText("CHOOSE YOUR MOVE");
			button[10].setPreferredSize(zeroButDimension);
		
			button[11].setText("QUIT");
			button[11].setPreferredSize(zeroButDimension);

			
			row[0].add(button[0]);
			add(row[0]);
			
			for(int i = 1; i < 4; i++)
				row[1].add(button[i]);
			add(row[1]);

			for(int i =4 ; i < 7; i++)
				row[2].add(button[i]);
			add(row[2]);

			for(int i = 7; i < 10; i++)
				row[3].add(button[i]);
			add(row[3]);
			
			row[4].add(button[10]);
			add(row[4]);
			
			row[5].add(button[11]);
			add(row[5]);
			
			setVisible(true);
		
		}
		
		
	private void setDesign() {

		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {   
		}
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()==button[11])
		{
			System.exit(1);
		}
		
		else if(ae.getSource()==button[0]||ae.getSource()==button[10]) {
			button[10].setText("Invalid Move");
			button[10].setBackground(Color.red);
			System.out.println("Invalid Move");
			}
		
		if(board.gameStatus() ==  Board.INCOMPLETE){
			
			done = false;
			
			if(player1Turn){
				
					
//					System.out.println("Enter x and y");
					int x,y;
					if(ae.getSource()==button[1])
					{ 
						x = 0 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[1].setText(""+player1.symbol);
					    } catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);
							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[2])
					{ 
						x = 0 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[2].setText(""+player1.symbol);
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[3])
					{ 
						x = 0 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[3].setText(""+player1.symbol);
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[4])
					{ 
						x = 1 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[4].setText(""+player1.symbol);
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[5])
					{ 
						x = 1 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[5].setText(""+player1.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[6])
					{ 
						x = 1 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[6].setText(""+player1.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[7])
					{ 
						x = 2 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[7].setText(""+player1.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[8])
					{ 
						x = 2 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[8].setText(""+player1.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[9])
					{ 
						x = 2 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player1.symbol,x,y);
							done =true;
							button[9].setText(""+player1.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
				if(done) {
					button[10].setText("CHOOSE YOUR MOVE");
					button[10].setBackground(Color.cyan);
					button[0].setText(player2.name+"'s turn !");
					System.out.println("Player 2 turn !");
					player1Turn = false;
				}
			}
			else
				{
					
//					System.out.println("Enter x and y");
				
					int x,y;
					 if(ae.getSource()==button[1])
					{ 
						x = 0 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[1].setText(""+player2.symbol);
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[2])
					{ 
						x = 0 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[2].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[3])
					{ 
						x = 0 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[3].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[4])
					{ 
						x = 1 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[4].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[5])
					{ 
						x = 1 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[5].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[6])
					{ 
						x = 1 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[6].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[7])
					{ 
						x = 2 ;
					 	y = 0 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[7].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[8])
					{ 
						x = 2 ;
					 	y = 1 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[8].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					else if(ae.getSource()==button[9])
					{ 
						x = 2 ;
					 	y = 2 ;
				 	 
					    try {
							board.move(player2.symbol,x,y);
							done = true;
							button[9].setText(""+player2.symbol);
					
						} catch (InvalidMoveException e) {
							button[10].setText("Invalid Move");
							button[10].setBackground(Color.red);

							System.out.println("Invalid Move");
						}
					}
					
				
				if(done) {
					button[10].setText("CHOOSE YOUR MOVE");
					button[10].setBackground(Color.cyan);
					button[0].setText(player1.name+"'s turn !");
					System.out.println("Player 1 turn !");
					player1Turn = true;
				}
			}
			board.print();
			
		
		
			if(board.gameStatus() == Board.PLAYER1WON){
				button[0].setText(player1.name+" wins !!!");
				button[10].setText("game is finished");
				button[0].setBackground(Color.green);
				button[10].setBackground(Color.green);
				System.out.println(player1.name+" wins !!!");
			}
			else if(board.gameStatus() == Board.PLAYER2WON){
				button[0].setText(player2.name+" wins !!!");
				button[10].setText("game is finished");
				button[0].setBackground(Color.green);
				button[10].setBackground(Color.green);
				System.out.println(player2.name+" wins !!!");
			}
			else if (board.gameStatus()== Board.DRAW){
				button[0].setText("Its a Draw !!");
				button[10].setText("game is finished");
				button[0].setBackground(Color.yellow);
				button[10].setBackground(Color.green);
				System.out.println("Its a Draw !!");
			}
			
		}
		

	}
}