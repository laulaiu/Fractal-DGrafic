import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Random;
import java.util.TimerTask;


public class Main {

    static JFrame frame;
    static int widthFrame = 300;
    static int heigthFrame = 250;
    static int escala = 2;
    public static void creatFrame(){
        frame = new JFrame("Desenho");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthFrame *escala, heigthFrame*escala);
        frame.add(new JPanelDesenho());
        frame.setVisible(true);
    }

    public static class JPanelDesenho extends JPanel{
        Graphics2D grap;
        public void paintComponent(Graphics g ) {
            grap = (Graphics2D) g;
            super.paintComponent(grap);

            grap.translate(getWidth()/2,getHeight());
            draw(150.0);
        }

        public void draw(Double len){

            if(len <=3){
                return;
            }

            grap.setStroke(new BasicStroke(1.5f));
            grap.drawLine( 0,0, 0,(int) -len);
            grap.translate(0,(int) -len);

            AffineTransform tran = grap.getTransform();
            grap.rotate(Math.toRadians(45));
            draw(len * 0.66);

            grap.setTransform(tran);
            AffineTransform tran2 = grap.getTransform();
            grap.rotate(Math.toRadians(-45));
            draw(len * 0.66);
            grap.setTransform(tran2);

        }
    }

    public static void main(String[] args) {
        creatFrame();
    }
}