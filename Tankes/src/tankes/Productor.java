package tankes;
import javax.swing.*;
import java.awt.geom.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Productor extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    private  Semaphore semaforo;

    public Productor(DibujaTanke panel, Y rc,Semaphore semaforo) {
        this.semaforo =  semaforo;
        this.panel=panel;
        this.rc=rc;
        mutex = new ReentrantLock();
    }
      public void run(){
        while(true){
                try {
                     semaforo.acquire();
                 } catch (InterruptedException e) { }
                 try {
                   panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                   rc.setY(rc.getY()-5);
                   panel.repaint();
                   sleep(1000);
                   } catch (InterruptedException e) {
                   } finally {
                       semaforo.release();
                }
        }
     }
  }

