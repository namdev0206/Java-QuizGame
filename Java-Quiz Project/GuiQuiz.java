//LOGIN PAGE
import que1.GuiQuiz2; //import from Package que1
import que2.GuiQuiz3; //import from Package que2
import que3.GuiQuiz4; //import from Package que3
import que4.GuiQuiz5; //import from Package que4
import que5.GuiQuiz6; //import from Package que5
import que6.GuiQuiz7; //import from Package que6

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class GuiQuiz implements ActionListener
{
	//Frame
	JFrame frame = new JFrame();

	//Label
	JLabel background = new JLabel();
	JLabel loginBanner = new JLabel("LOGIN PAGE");
	JLabel l1 = new JLabel("Enter Username");
    JLabel l2 = new JLabel("Enter Password");
	
	//TextField and Password
	JTextField t1 = new JTextField(20);
	JPasswordField t2 = new JPasswordField(20);

	ImageIcon img = new ImageIcon("LoginPage.jpg"); 
	
	JButton logbut = new JButton("Login");
	
	//1. Font Size -- 2. Font Type -- 3. Font Size
	Font fn1 = new Font("Arial", Font.BOLD, 19);
	
	void data()
	{
		loginBanner.setFont(fn1);
		loginBanner.setForeground(Color.cyan);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
					
		background.setBounds(0, 0, 450, 350); //Background Image
		loginBanner.setBounds(160, 25, 130, 50);
		l1.setBounds(80, 90, 150, 20);
		t1.setBounds(80, 115, 290, 27);
		l2.setBounds(80, 155, 150, 20);
		t2.setBounds(80, 180, 290, 27);
		logbut.setBounds(175, 240, 100, 30);
		
		background.setIcon(img);
		
		// Adding components in the right order
        frame.add(loginBanner);
       	frame.add(l1);
        frame.add(t1);
        frame.add(l2);
       	frame.add(t2);
       	frame.add(logbut);
        frame.add(background);
		
		frame.addMouseListener(new MouseLis()); //Window Listener
		frame.addWindowListener(new WindowLis()); //Window Listener
		logbut.addActionListener(this); //Action Listener
		
		frame.setLayout(null);
		frame.setTitle("Quiz Game");
		frame.setLocation(300, 200);
		frame.setSize(450, 350); //Tablet Size
		frame.setVisible(true);
	}
	
	
	//Action Listener
	public void actionPerformed(ActionEvent ae)
	{
		
		if(t1.getText().equals("") || t2.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please fill details");
			return;
		}	
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizlogin", "root", "");
			Statement st = con.createStatement();
			
			String query = "select userp from login where usern = '"+t1.getText()+"' ";
			ResultSet rs = st.executeQuery(query);
			
			String get_password = "";
			while(rs.next())
			{
				get_password = rs.getString(1);
			}
			
			if(get_password.equals(t2.getText()))
			{
				frame.setVisible(false);
				GuiQuiz2 k1 = new GuiQuiz2();
				k1.data();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Enter Correct Details!");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	//Window Listener
	class WindowLis implements WindowListener 
	{
		public void windowDeactivated(WindowEvent e) 
		{}
		public void  windowActivated(WindowEvent e)
		{}
		public void windowDeiconified(WindowEvent e)
		{}
		public void windowIconified(WindowEvent e)
		{}
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
	
	//Mouse Listener //
	class MouseLis implements MouseListener
	{
		public void mouseExited(MouseEvent e)
		{}
		public void  mouseEntered(MouseEvent e)
		{}
		public void mouseReleased(MouseEvent e)
		{}
		public void mousePressed(MouseEvent e)
		{}
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("Mouse Clicked");
		}
	}
}

//Main Class
class Quiz
{
    public static void main(String args[])
    {
        GuiQuiz k = new GuiQuiz();
        k.data();
    }
}