//Result PAGE 7
package que6;

import que1.GuiQuiz2;  //import from Package que1
import que2.GuiQuiz3;  //import from Package que2
import que3.GuiQuiz4;  //import from Package que3
import que4.GuiQuiz5;  //import from Package que4
import que5.GuiQuiz6;  //import from Package que5
import que6.GuiQuiz7;  //import from Package que6

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class GuiQuiz7 implements ActionListener
{
	//Frame
	JFrame frame = new JFrame();

	//Label
	JLabel background = new JLabel();
	JLabel resultBanner = new JLabel("RESULT");
	JLabel ts = new JLabel("TOTAL SCORE");
    JLabel rs = new JLabel("RESULT");
	
	//TextField and Password
	JTextField t1 = new JTextField(20);
	JTextField t2 = new JTextField(20);

	ImageIcon img = new ImageIcon("Logout.jpg"); 
	
	JButton logbut = new JButton("Logout");
	
	//1. Font Size -- 2. Font Type -- 3. Font Size
	Font fn1 = new Font("Arial", Font.BOLD, 20);
	Font fn2 = new Font("Lithograph", Font.BOLD, 14);

	public void data()
	{
		resultBanner.setFont(fn1);
		resultBanner.setForeground(Color.white);
		ts.setFont(fn2);
		ts.setForeground(Color.white);
		rs.setFont(fn2);
		rs.setForeground(Color.white);
					
		background.setBounds	(0, 0, 450, 350); //Background Image
		resultBanner.setBounds	(185, 20, 80, 60);
        ts.setBounds			(65, 120, 140, 25);
        t1.setBounds			(220, 120, 140, 25);
        rs.setBounds			(65, 175, 140, 25);
        t2.setBounds			(220, 175, 140, 25);
        logbut.setBounds		(185, 255, 80, 30);
				
		background.setIcon(img);
		
		// Adding components in the right order
        frame.add(resultBanner);
        frame.add(ts);
        frame.add(t1);
        frame.add(rs);
        frame.add(t2);
        frame.add(logbut);
        frame.add(background);
		
		frame.addMouseListener(new MouseLis());
		frame.addWindowListener(new WindowLis());
		
		logbut.addActionListener(this);
		
		frame.setLayout(null);
		frame.setTitle("Quiz Game");
		frame.setLocation(300, 200);
		frame.setSize(450, 350); //Tablet Size
		frame.setVisible(true);
		
		
		// Calculate and display the total score
		// Add scores from different quizzes
        int totalScore = GuiQuiz2.qa + GuiQuiz3.qb + GuiQuiz4.qc + GuiQuiz5.qd + GuiQuiz6.qe; 
        t1.setText(String.valueOf(totalScore));
        
		
        // Display Pass/Fail based on totalScore
        	if (totalScore > 3) 
        	{
            	t2.setText("Pass");
        	} 
        	else
        	{
            	t2.setText("Fail");
        	}
   	}

	//Action Listener
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == logbut) 
		{
			// Handle the 'Logout' button click
			frame.setVisible(false);
			// Optionally, navigate to another screen or reset state
		}
	}
	
	
	//Window Listener
	class WindowLis implements WindowListener 
	{
		public void windowDeactivated(WindowEvent e) {}
		public void windowActivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowClosed(WindowEvent e)
		{
			System.out.println("Window Closed");
		}
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
		public void windowOpened(WindowEvent e)
		{
			System.out.println("Window Opened");
		}
	}
	
	//Mouse Listener
	class MouseLis implements MouseListener
	{
		public void mouseExited(MouseEvent e){}
		public void  mouseEntered(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("Mouse Clicked");
		}
	}
}


/*
class Quiz
{
    public static void main(String args[])
    {
        GuiQuiz7 k = new GuiQuiz7();
        k.data();
    }
}
*/