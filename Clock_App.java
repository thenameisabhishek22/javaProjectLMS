import java.time.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Clock_App {
    public static void main(String arg[]) {
        // Main Frame
        JFrame jf=new JFrame();
        jf.setSize(410,500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
        //Making Tabbed pane
        JTabbedPane tb=new JTabbedPane();

        //Current time
        JPanel jp1=new JPanel();
        //Image
        ImageIcon ic=new ImageIcon("D:/B.Tech Syllabus/2nd Year/4th Semester/CSE310/JavaProject/clock1.jpg");
        jp1.setBackground(Color.BLACK);
        JLabel ima=new JLabel(ic);
        jp1.add(ima);
        jp1.setLayout(null);
        JLabel jl1=new JLabel();
        jl1.setForeground(Color.white);
        Font f1=new Font("SansSerif",1,40);
        jl1.setFont(f1);

        // Thread
        Thread t=new Thread(()-> {
            while(true) {
                jl1.setText(""+LocalTime.now());
                try {
                    Thread.sleep(1);
                } catch(Exception e) {};
            }
        });
        t.start();
        jl1.setText(""+LocalTime.now());

        //Stop Watch
        JPanel jp2=new JPanel();
        jp2.setBackground(new Color(250, 24, 50));
        jp2.setLayout(null);
        ImageIcon pa=new ImageIcon("pause.png");
        ImageIcon re=new ImageIcon("reset.jpeg");

        JButton pause=new JButton(pa);
        JButton reset=new JButton(re);

        JLabel jl2=new JLabel();
        Font f2=new Font("SansSerif",1,90);
        jl2.setFont(f2);
        jp2.add(pause);
        jp2.add(reset);


        class MyListener implements ActionListener {

            int x=0;
            int h=0,m=0,s=0;
            public void actionPerformed(ActionEvent ae) {
                
                if(ae.getSource()==pause) {
                    if(x==0){
                        x=1;
                    }
                    else{
                        x=0;
                    }
                } else if(ae.getSource()==reset) {
                    h=0;
                    m=0;
                    s=0;
                    jl2.setText(h+":"+m+":"+s);
                }
                
                    Thread nt=new Thread(()-> {
                        while(true) {
                            if(x==1) {
                                jl2.setText(h+":"+m+":"+s);
                                s++;
                                if(s==60) {
                                    m++;
                                    s=0;
                                }
                                if(m==60) {
                                    h++;
                                    m=0;
                                }
                            }
                            try {
                                Thread.sleep(1000);
                            } catch(Exception e) {}
                        }
                    });
                if(x==1){
                    nt.start();}
                
            }
        }

        jl2.setText(0+":"+0+":"+0);

        //World Clock
        JPanel jp3=new JPanel();
        jp3.setLayout(null);
        JLabel jl3=new JLabel();
        ImageIcon map=new ImageIcon("map1.jpg");
        JLabel jl4=new JLabel(map);
        jp3.add(jl3);
        jp3.add(jl4);
        Font f3=new Font("SansSerif",1,30);
        jl3.setFont(f3);

        class Mouse extends MouseAdapter {
            int x,y;
            public void mouseMoved(MouseEvent me) {
                x=me.getX();
                y=me.getY();
		jl3.setText(x+" "+y);
                if(x>272&&x<304&&y>239&&y<273) {
                    jl3.setText("Time: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
                }
                if(x>327&&x<369&&y>295&&y<323) {
                    ZoneId z=ZoneId.of("Australia/Melbourne");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>64&&x<111&&y>217&&y<243) {
                    ZoneId z=ZoneId.of("America/Los_Angeles");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>127&&x<157&&y>273&&y<312) {
                    ZoneId z=ZoneId.of("Brazil/East");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>117&&x<131&&y>311&&y<353) {
                    ZoneId z=ZoneId.of("America/Argentina/Mendoza");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>344&&x<361&&y>222&&y<250) {
                    ZoneId z=ZoneId.of("Japan");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>213&&x<236&&y>210&&y<230) {
                    ZoneId z=ZoneId.of("Europe/Athens");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>293&&x<346&&y>170&&y<207) {
                    ZoneId z=ZoneId.of("Europe/Moscow");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>203&&x<241&&y>247&&y<286) {
                    ZoneId z=ZoneId.of("Africa/Algiers");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
                if(x>22&&x<377&&y>386&&y<431) {
                    ZoneId z=ZoneId.of("Antarctica/South_Pole");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
		if(x>36&&x<109&&y>171&&y<211) {
                    ZoneId z=ZoneId.of("Canada/Yukon");
                    jl3.setText("Time: "+LocalTime.now(z).getHour()+":"+LocalTime.now(z).getMinute()+":"+LocalTime.now(z).getSecond());
                }
            }
        }
        ima.setBounds(0,50,410,410);
        jl1.setBounds(70,0,250,50);
        pause.setBounds(200,200,200,200);
        jl3.setBounds(80,0,410,70);
        jl4.setBounds(0,80,400,400);
        reset.setBounds(0,200,200,200);
        jl2.setBounds(100,50,400,90);


        jp1.add(jl1);
        jp2.add(jl2);
        //setting ActionListener
        MyListener ml=new MyListener();
        pause.addActionListener(ml);
        reset.addActionListener(ml);

//setting MouseListener
        Mouse m=new Mouse();
        jp3.addMouseMotionListener(m);
        //adding to Jtabbed
        tb.addTab("CLOCK",jp1);
        tb.addTab("STOP WATCH",jp2);
        tb.addTab("WORLD CLOCK",jp3);
        jf.add(tb);

    }
}