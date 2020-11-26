package tankes;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;
public class Tankes extends JFrame{
    private Semaphore semaforo;
    private DibujaTanke panel;
    private Y rc;
    private Productor p;
    private Consumidor c;
    private Agua agua;
    
    
    public Tankes(){
        semaforo = new Semaphore(0);
        setSize(400,400);
        rc=new Y();
        agua = new Agua();
        panel = new DibujaTanke(agua);
        p = new Productor(panel,rc, semaforo);
        c = new Consumidor(panel, rc,semaforo);
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(panel);
        p.start();
        c.start();
    }
    public static void main(String[] args) {
        Tankes fr = new Tankes();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
