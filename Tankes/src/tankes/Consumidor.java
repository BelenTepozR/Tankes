package tankes;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Consumidor extends Thread{
    private  Semaphore semaforo;
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    public Consumidor(DibujaTanke panel, Y rc,Semaphore semaforo){
        this.semaforo =  semaforo;
        this.panel=panel;
        this.rc=rc;
        this.mutex = mutex;
        mutex = new ReentrantLock();
    }
     public void run(){
        while(true){
            try {
                semaforo.acquire();
                panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                rc.setY(rc.getY()+5);
                panel.repaint();
                sleep(1000);
            } catch (InterruptedException e) {
            } finally {
                semaforo.release();
            } 
        }
     }
}
