import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.Timer;
import java.util.TimerTask;
class login extends JFrame implements ActionListener
{
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;
    login()
    {
        userLabel = new JLabel();
        userLabel.setText("    Username :");
        textField1 = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("    Password :");
        textField2 = new JPasswordField(8);
        b1 = new JButton("   SUBMIT   ");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("Login Form ");
    }
    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        if(!passValue.equals(""))
            new OnlineTestBegin(userValue);
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }
}
class OnlineTestBegin extends JFrame implements ActionListener
{
    JLabel l;
    JLabel l1;
    JRadioButton jb[]=new JRadioButton[6];
    JButton b1,b2,log;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    Timer timer = new Timer();
    OnlineTestBegin(String s)
    {
        super(s);
        l=new JLabel();
        l1 = new JLabel();
        add(l);
        add(l1);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Save and Next");
        b2=new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(95,240,140,30);
        b2.setBounds(270,240,150,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600;
            public void run() {
                l1.setText("Time left: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");
                }
            }
        }, 0, 1000);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Save for later"))
        {
            JButton bk=new JButton("Review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Review"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }
        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"Score ="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Q1: Who invented java programming language?");
            jb[0].setText("charles Babbage");jb[1].setText("James Gosling");jb[2].setText("M.P.Java");jb[3].setText("Blais Pascal");
        }
        if(current==1)
        {
            l.setText("Q2: The size of float and double is?");
            jb[0].setText("32 & 64");jb[1].setText("32 & 32");jb[2].setText("64 & 64");jb[3].setText("64 & 32");
        }
        if(current==2)
        {
            l.setText("Q3. Select valid statement");
            jb[0].setText("int[] a ={}");jb[1].setText("int[] a ={1,2,3}");jb[2].setText("int[] a =(1,2,3)");jb[3].setText("None");
        }
        if(current==3)
        {
            l.setText("Q4. Arrays in java are");
            jb[0].setText("Object References");jb[1].setText("Objects");jb[2].setText("Primitive Data Type");jb[3].setText("None");
        }
        if(current==4)
        {
            l.setText("Q5. Which of the following is not an OOPS concept in java?");
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");jb[3].setText("Encapsulation");
        }
        if(current==5)
        {
            l.setText("Q6. When the object is created with new Keyword? ");
            jb[0].setText("Depends on code");jb[1].setText("At compile time");jb[2].setText("At run time");jb[3].setText("None");
        }
        if(current==6)
        {
            l.setText("Q7.Identify the modifier which cannot be used for constructor? ");
            jb[0].setText("Public");jb[1].setText("Private");jb[2].setText("Protected");
            jb[3].setText("Static");
        }
        if(current==7)
        {
            l.setText("Q8.What is variable declared in class for the use of all methods of the class called?");
            jb[0].setText("Object");jb[1].setText("Instance Variable");jb[2].setText("Reference Variable");
            jb[3].setText("None");
        }
        if(current==8)
        {
            l.setText("Q9.Output of Math.floor(3.6);");
            jb[0].setText("3.0");jb[1].setText("3");jb[2].setText("0.6");jb[3].setText("None");
        }
        if(current==9)
        {
            l.setText("Q10.Find output:" +
                    "\n int x =5;" +
                    "\n x *= (7 + 3);" +
                    "\n System.out.print(x);");
            jb[0].setText("22");jb[1].setText("10");jb[2].setText("50");
            jb[3].setText("None");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[0].isSelected());
        if(current==2)
            return(jb[1].isSelected());
        if(current==3)
            return(jb[1].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[3].isSelected());
        if(current==7)
            return(jb[1].isSelected());
        if(current==8)
            return(jb[0].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
}
class OnlineExam
{
    public static void main(String args[])
    {
        try
        {
            login form = new login();
            form.setSize(400,150);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}