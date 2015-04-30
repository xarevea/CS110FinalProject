//Matthew Partridge...CS110 final
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class WarGUI extends JFrame {
	private JPanel topLeftPanel,topRightPanel,bottomLeftPanel,bottomRightPanel;
	private GameOfWar game;
	private JLabel playerOneCard,playerTwoCard,playerOneHandSize,playerTwoHandSize;
	public WarGUI()
	{
		setLayout(new GridLayout(2,2));
		
		game=new GameOfWar();

		topLeftPanel=new JPanel();
		topLeftPanel.setBackground(Color.blue);
		bottomLeftPanel=new JPanel();
		bottomLeftPanel.setBackground(Color.blue);
		topRightPanel=new JPanel();
		topRightPanel.setBackground(Color.pink);
		bottomRightPanel=new JPanel();
		bottomRightPanel.setBackground(Color.pink);
		JLabel playerOne=new JLabel("Player One:");
		playerOneCard=new JLabel(new ImageIcon("cards/b1.png"));
		JLabel playerTwo=new JLabel("Player Two:");
		playerTwoCard=new JLabel(new ImageIcon("cards/b1.png"));
		playerOneHandSize=new JLabel("Player's Cards:");
		playerTwoHandSize=new JLabel("Player's Cards:");
	    playerOne.setFont(new Font("ARIAL",Font.BOLD,24));
	    playerTwo.setFont(new Font("ARIAL",Font.BOLD,24));
	    playerOneHandSize.setFont(new Font("ARIAL",Font.BOLD,18));
	    playerTwoHandSize.setFont(new Font("ARIAL",Font.BOLD,18));

		JButton playButton=new JButton("Flip");
		playButton.addActionListener(new ButtonListener());

		topLeftPanel.add(playerOne);
		topLeftPanel.add(playerOneCard);
		bottomLeftPanel.add(playerOneHandSize);
		topRightPanel.add(playerTwo);
		topRightPanel.add(playerTwoCard);
		bottomRightPanel.add(playerTwoHandSize);
		add(topLeftPanel);
		add(topRightPanel);
		add(playButton);
		add(bottomLeftPanel);
		add(bottomRightPanel);				
	}
	class ButtonListener implements ActionListener{
	      public void actionPerformed (ActionEvent e) {
	    	  boolean go=true;
	    	  if(game.getCardsOne()==0)
	 		  {
	        	 go=false;
	        	 playerOneCard.setIcon(new ImageIcon("cards/b1.png"));
			     playerTwoCard.setIcon(new ImageIcon("cards/b1.png"));
			     playerOneHandSize.setText("GAME OVER!!");
			  	 playerTwoHandSize.setText("WINNER!!");
	 		  }
	    	  if(game.getCardsTwo()==0)
	 		  {
	 			 go=false;
	 			 playerOneCard.setIcon(new ImageIcon("cards/b1.png"));
			     playerTwoCard.setIcon(new ImageIcon("cards/b1.png"));
			     playerOneHandSize.setText("WINNER!!");
			  	 playerTwoHandSize.setText("GAME OVER!!");
	 	   	  }
	    	  if(go)
	    	  {
	    		  boolean war=true;
			      game.nextTurn();
			      war=game.isWar();
			      if(war)
			      {
			    	  playerOneHandSize.setText("IT'S A");
				  	  playerTwoHandSize.setText("WAR!!");
			      }
			      else{
			    	  playerOneHandSize.setText("Player's Cards:"+game.getCardsOne());
			  	  	  playerTwoHandSize.setText("Player's Cards:"+game.getCardsTwo());
			      }
			  	  playerOneCard.setIcon(new ImageIcon(game.getFilenameOne()));
			      playerTwoCard.setIcon(new ImageIcon(game.getFilenameTwo()));
	    	  }
	      }
	   }
}
