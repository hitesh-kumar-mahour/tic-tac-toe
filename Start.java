package TTT;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Start extends JFrame implements ActionListener{

	public static String player1_name="X";
	public static char player1_symbol='X';
	public static String player2_name="O";
	public static char player2_symbol='O';
	
	JLabel label_x_name;
	JLabel label_o_name;
	
	JTextField Tf_x_name;
	JTextField Tf_o_name;
	
	JButton button_begin;
	JButton button_exit;
	
	public Start() {
		
		setLayout(null);
 		setSize(300,300);
 		setLocation(500, 100);
 		getContentPane().setBackground(Color.yellow);
 		
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		setTitle("TIC TAC TOE");
 		
 		label_x_name = new JLabel("Player1(X) name");
 		label_x_name.setBounds(10, 10, 150, 20);
 		add(label_x_name);
 		
 		label_o_name = new JLabel("Player2(O) name");
 		label_o_name.setBounds(10, 40, 150, 20);
 		add(label_o_name);

 		Tf_x_name = new JTextField();
 		Tf_x_name.setBounds(180, 10, 80, 20);
 		Tf_x_name.setText("X");
 		add(Tf_x_name);

 		Tf_o_name = new JTextField();
 		Tf_o_name.setBounds(180, 40, 80, 20);
 		Tf_o_name.setText("O");
 		add(Tf_o_name);
 		
 		button_begin = new JButton("START MATCH");
 		button_begin.setBackground(Color.cyan);
 		button_begin.setBounds(20, 150, 250, 50);
 		add(button_begin);
 		button_begin.addActionListener(this);
 		
 		button_exit = new JButton("EXIT");
 		button_exit.setBackground(Color.red);
 		button_exit.setBounds(20,210,250,50);
 		add(button_exit);
 		button_exit.addActionListener(this);
 		
        setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource().equals(button_begin))
		{
			player1_name=Tf_x_name.getText();
			player2_name=Tf_o_name.getText();
			
			new TicTacToe();
			
			
			dispose();
		}
		if(e.getSource().equals(button_exit))
		{
			System.exit(0);
		}
	}
}
