import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Despachador
{
    private Queue<Proceso> listaProcesos = new LinkedList<Proceso>();    // dinámica para que entren y salgan procesos.
    private int cc;
    private int q;
    private int b;
    private ArrayList<Micro> listaMicros = new ArrayList<Micro>();

    public Despachador(Queue<Proceso> listaProcesos, int nMicros, int cc, int q, int b) {
        this.listaProcesos = listaProcesos;
        this.cc = cc;
        this.q = q;
        this.b = b;
        this.initMicros(nMicros);

    }
    private void initMicros(int nMicros){
        for (int i=0; i<nMicros; i++) {
            Micro m = new Micro(i+1,cc,q,b);
            listaMicros.add(m);
        }
        for(Micro m : listaMicros){
            System.out.println(m);
        }
    }

    public void  despacha() {
        // primero, se asignan tantos procesos cuantos micros hayan.
        for (int i=0; i<listaProcesos.size() && i<listaMicros.size(); i++) {
            System.out.println("Proceso " + listaProcesos.peek().getId() + " a:" + listaMicros.get(i));
            listaMicros.get(i).process(listaProcesos.remove());
        }
        // en adelante tenemos que discriminar por tiempos de micro,
        while (listaProcesos.size()!=0){
            // debe leer los tiempos de todos los micros y escoger el de menor tiempo.
            // el de menor tiempo se le asigna y procesa el primer proceso en la cola.
            System.out.println("Proceso " + listaProcesos.peek().getId() + " a:" + this.chooseMicro());
            this.chooseMicro().process(listaProcesos.remove());
        }
        // en teoría ya acabamos los procesos en este punto. Los micros se van a empty.
        System.out.println("Finished processing all. ");
        for (Micro m : listaMicros){
            m.setEmpty(true);
            }
    }
    public Micro chooseMicro(){
        Micro min = Collections.min(listaMicros);
        return min;
    }
    public ArrayList<Micro> getListaMicros() {
        return listaMicros;
    }
}
