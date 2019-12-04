import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class OnlineTest extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current =0, x=1,y1, now=0;
    int m[] = new int[10];

    OnlineTest(String s){
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for(int i = 0; i < 5; i++){
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmak");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,650,20);
        jb[0].setBounds(50,80,300,20);
        jb[1].setBounds(50,110,300,20);
        jb[2].setBounds(50,140,300,20);
        jb[3].setBounds(50,170,300,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,300);
        setVisible(true);
        setSize(600,350);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            if (check())
                count += 1;
            current++;
            set();
            if (current == 9){
                b1.setEnabled(false);
                b2.setText("Result");

            }

        }
        if (e.getActionCommand().equals("Bookmark")){

            JButton bk=new JButton("Bookmark"+x);
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
        for (int i=0,y=1;i<x;i++,y++){
            if (e.getActionCommand().equals("Bookmark" + y)){
                if (check())
                    count += 1;
                now = current;
                current = m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if(e.getActionCommand().equals("Result")){
            if (check()) {
                count += 1;
            }
            current++;
            JOptionPane.showMessageDialog(this, "correct ans= " + count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Question_1: Which one among these is not a primitive datatype?");
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");
        }
        if(current==1)
        {
            l.setText("Question_2: Which of the following statements are true?");
            jb[0].setText("Runtime exceptions are checked exceptions.");jb[1].setText("Runtime exceptions are unchecked exceptions");jb[2].setText("You can declare only checked exceptions");jb[3].setText("You can handle only Exception subclasses");
        }
        if(current==2)
        {
            l.setText("Question_3:When are you required to use a finally block in a regular try statement not a try-with-resources?");
            jb[0].setText("Never");jb[1].setText("When the program code cannot exit on its own.");jb[2].setText("When there are no catch blocks in a try statement.");jb[3].setText("When there is one catch block in a try statement.");
        }
        if(current==3)
        {
            l.setText("Question_4: Which of the following lines will compile?");
            jb[0].setText("char d=\"d\"");jb[1].setText("float f=3.1415;");jb[2].setText("byte b=257;");jb[3].setText("boolean isPresent=true;");
        }
        if(current==4)
        {
            l.setText("Question_5: Which of the following statements will compile?");
            jb[0].setText("int myArray[];");jb[1].setText("int myArray[5];");jb[2].setText("t myArray[5] = {1,2}");jb[3].setText("myArray[] = {1,2,3,4,5};");
        }
        if(current==5)
        {
            l.setText("Question_6: Which one among these is not a keyword?");
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
        }
        if(current==6)
        {
            l.setText("Que7: Which one among these is not a class? ");
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if(current==7)
        {
            l.setText("Question_8: Which one is true?");
            jb[0].setText("main method cannot be overloaded");jb[1].setText("code cant compile without main method");jb[2].setText("equals same as main method");
            jb[3].setText("tostring and main share same package");
        }
        if(current==8)
        {
            l.setText("Question_9: Which of the following are true? ");
            jb[0].setText("An array has a fixed size.");jb[1].setText("ArrayList is immutable.");jb[2].setText("Array is better than ArrayList");jb[3].setText("Arraylist i slow");
        }
        if(current==9)
        {
            l.setText("Question_10: System.out.println(4 % 3); result?");
            jb[0].setText("0");jb[1].setText("1");jb[2].setText("2");
            jb[3].setText("3");
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
            return(jb[2].isSelected());
        if(current==2)
            return(jb[0].isSelected());
        if(current==3)
            return(jb[2].isSelected());
        if(current==4)
            return(jb[1].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
}
