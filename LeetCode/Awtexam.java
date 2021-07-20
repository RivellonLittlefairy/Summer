import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Awtexam extends JFrame {

    public static void cre(String title){
        JButton j1=new JButton("+");
        JButton j2=new JButton("-");
        JFrame jf=new JFrame(title);
        Container c=jf.getContentPane();
        c.setLayout(new FlowLayout(0,10,10));
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.add(new JTextArea("AA"));
            }
        });


        c.add(j1);
        c.add(j2);





        jf.setVisible(true);
        jf.setBounds(400,100,800,500);
        jf.setContentPane(c);
    }

    public static void main(String[] args) {
        cre("new");
    }
}
