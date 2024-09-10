//QUIZ PAGE 6 - Q5
package que5;

import que6.GuiQuiz7;  //import from Package que6

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiQuiz6 implements ActionListener
{
	public static int qe; //Static Value
	
	JFrame frame = new JFrame();
	
	//Background Image
	JLabel background = new JLabel(); 
	ImageIcon img = new ImageIcon("Quiz2.jpg");
	
	//Labels
	JLabel l1_01 = new JLabel("_____ is used to find and fix bugs in");
	JLabel l1_02 = new JLabel("the Java programs.");
	JLabel l1_1 = new JLabel("JVM");
    JLabel l1_2 = new JLabel("JRE");
	JLabel l1_3 = new JLabel("JDK");
	JLabel l1_4 = new JLabel("JDB");

	//CheckBox
	ButtonGroup options = new ButtonGroup();  //Radio Button Group
    JRadioButton opt1 = new JRadioButton("", false);
    JRadioButton opt2 = new JRadioButton("", false);
    JRadioButton opt3 = new JRadioButton("", false);
    JRadioButton opt4 = new JRadioButton("", false);
	
	//Buttons
	JButton submit = new JButton("Submit");  //Submit Button
	JButton next = new JButton("Next ->");  //Next Page Button
	
	Font fn1 = new Font("Arial", Font.BOLD, 18); //Font Define - Banner
	Font fn2 = new Font("Arial", Font.BOLD, 16); //Font Define - Options
	
	public void data()
	{
		l1_01.setFont(fn1);	
		l1_02.setFont(fn1);
		l1_01.setForeground(Color.white);
		l1_02.setForeground(Color.white);
		l1_1.setFont(fn2);
		l1_1.setForeground(Color.white);
		l1_2.setFont(fn2);
		l1_2.setForeground(Color.white);
		l1_3.setFont(fn2);
		l1_3.setForeground(Color.white);
		l1_4.setFont(fn2);
		l1_4.setForeground(Color.white);
		
		background.setBounds(0, 0, 450, 350); //Background Image
		
		// Set bounds for components
        l1_01.setBounds(65, 49, 390, 30);
		l1_02.setBounds(147, 71, 390, 30);
		
       	l1_1.setBounds(71, 154, 110, 25);
       	opt1.setBounds(157, 157, 17, 15);
		
       	l1_2.setBounds(293, 154, 110, 25);
        opt2.setBounds(382, 157, 17, 15);
		
       	l1_3.setBounds(71, 220, 110, 25);
       	opt3.setBounds(157, 223, 17, 15);
		
       	l1_4.setBounds(293, 220, 110, 25);
       	opt4.setBounds(382, 223, 17, 15);
		
        submit.setBounds(30, 273, 100, 25);
        next.setBounds(305, 273, 100, 25);
		
		//Add RadioButtons
		options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
		
		opt1.addActionListener(this);
		opt2.addActionListener(this);
		opt3.addActionListener(this);
		opt4.addActionListener(this);
		submit.addActionListener(this);
		next.addActionListener(this);
		
		//Addition of Objects in Frame
		frame.add(l1_01);
		frame.add(l1_02);
		frame.add(l1_1);
		frame.add(opt1);
		frame.add(l1_2);
		frame.add(opt2);
		frame.add(l1_3);
		frame.add(opt3);
		frame.add(l1_4);
		frame.add(opt4);
		frame.add(submit);
		frame.add(next);
		frame.add(background);
		
		background.setIcon(img);
		
		opt1.setForeground(Color.RED);
		
		//Mouse and Window Listener
		frame.addMouseListener(new MouseLis2());
		frame.addWindowListener(new WindowLis2());
		
		frame.setLayout(null);
		frame.setTitle("Quiz Game");
		frame.setLocation(300, 200);
		frame.setSize(450, 350);
		frame.setVisible(true);
	}
	
	
	//Action Listener	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == submit) 
		{
			if (opt4.isSelected()) 
			{
				qe++;
				System.out.println("Que 5 Correct--Point = " + qe);
			}
		}
		else if (e.getSource() == next) 
		{
			// Handle the 'next' button click
			frame.setVisible(false);
			GuiQuiz7 k1 = new GuiQuiz7();
			qe = 1;
			k1.data();
		}
	}
	
	//Window Listener
	public class WindowLis2 implements WindowListener 
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
	public class MouseLis2 implements MouseListener
	{
		public void mouseExited(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
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
        GuiQuiz6 k = new GuiQuiz6();
        k.data();
    }
}
*/