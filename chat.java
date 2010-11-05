import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chat implements ActionListener{

public Frame f;
public Panel p;
public TextArea ta;
public TextField tf;
public Button bsend,bquit;
public MenuBar mb;
public Menu file, help;
public MenuItem mquit, mabout;
public Choice uid;
public JOptionPane dabout;

    public chat() {
        f = new Frame("Chat Client");
        p = new Panel();
        ta = new TextArea();
        tf = new TextField();
        bsend = new Button("Send");
        bquit = new Button("Quit");
        mb = new MenuBar();
        file = new Menu("File");
        help = new Menu("Help");
        mquit = new MenuItem("Quit");
        mabout = new MenuItem("About");     
        uid = new Choice();
        dabout = new JOptionPane();
        ta.setEditable(false);
        ta.setBackground(Color.WHITE);
    }
    
    public void launchframe()
    {
        file.add(mquit);
        help.add(mabout);
        mb.add(file);
        mb.add(help);
        f.setMenuBar(mb);
        uid.add("Kevin");
        uid.add("Willard");
        
        //bsend.setMinimumSize(new Dimension(100000,10000));
        //bsend.setMaximumSize(new Dimension(100000,10000));
        //bsend.setSize(new Dimension(10000,10000));
        //tf.setText((bsend.getMaximumSize()).toString());
        
        
        p.setLayout(new GridLayout(3,1));
        p.add(bsend);
        p.add(bquit);
        p.add(uid);
        
        f.add(ta,BorderLayout.CENTER);
        f.add(p,BorderLayout.EAST);
        f.add(tf,BorderLayout.SOUTH);
        
        
        f.pack();
        f.setVisible(true);
        
        bquit.addActionListener(this);
        bsend.addActionListener(this);
        mquit.addActionListener(this);
        mabout.addActionListener(this);
        f.addWindowListener(new close());
    }
    
    private class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bquit || ae.getSource() == mquit)
        {
            System.exit(0);
        }
        else if(ae.getSource() == bsend){
            ta.append(uid.getSelectedItem() + ": " + tf.getText() + "\n");
            tf.setText("");
        }
        else if(ae.getSource() == mabout){
        	dabout.showMessageDialog(f,"Chat Client v1.0 11/4/2010 Kevin Willard Quing","About Chat",1);
        }
    }
    
    public static void main(String args[]){
        chat ch = new chat();
        ch.launchframe();
    }
    
}