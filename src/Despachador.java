import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Despachador
{
    private ArrayList<Proceso> listaProcesos = new ArrayList<>();   // lista simple con los procesos
    private Queue<Proceso> colaProcesos = new LinkedList<Proceso>();    // cola para que entren y salgan procesos.
    private int cc;
    private int q;
    private int b;
    private ArrayList<Micro> listaMicros = new ArrayList<Micro>();

    public Despachador(ArrayList<Proceso> listaProcesos, int nMicros, int cc, int q, int b) {
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

    public void startDispatch() {
        /* Este proceso simula lo que teníamos anteriormente afuera en Main.
        * A partir de una lista de procesos ordenada por tiempos de entrada,
        * Los va metiendo a la cola y despachando. Usa una variable startTime para
        * detectar cuando pasamos al siguiente tiempo de entrada.
        * Añade a la cola uno a uno de los procesos, cuando hay un cambio de tiempo de lote,
        * los despacha y crea los huecos hasta dicho tiempo.*/

        int startTime = 0;
        for (int i=0; i<listaProcesos.size(); i++) {
            // ciclo que recorre todos los procesos de la lista simple
            if (listaProcesos.get(i).getEntryTime() != startTime) {
                this.despacha();
                this.detectarHuecos( listaProcesos.get(i).getEntryTime() );
            }
            colaProcesos.add(listaProcesos.get(i));     // en cada vuelta agrega el proceso a la cola.
        }
        // al final del ciclo queda un proceso por despachar en la cola.
        this.despacha();
        this.deleteHole();
    }

    public void  despacha() {
        // Discriminar por tiempos de micro,
        while (colaProcesos.size()!=0){
            // debe leer los tiempos de todos los micros y escoger el de menor tiempo, cuidando prioridad de id.
            // el de menor tiempo se le asigna y procesa el primer proceso en la cola.
            System.out.println("Proceso " + colaProcesos.peek().getId() + " a:" + this.chooseMicro());
            this.chooseMicro().process(colaProcesos.remove());
        }
        // en teoría ya acabamos los procesos en este punto. Se quedan no-vacíos por ahora.
        System.out.println("Finished processing batch. ");
    }

    public void detectarHuecos(int nextStartTime) {
        for (Micro m: listaMicros) {
            if (m.getTiempoTotal()<nextStartTime) {
                m.wait(nextStartTime);
            }       // aquellos que no cumplen la condición tienen tiempo de uso igual o mayor al nextStartTime. No se les hace nada.
        }
    }

    public void deleteHole() {
        for (Micro micro : listaMicros) {
            if(micro.getTerminados().get(micro.getTerminados().size()-1).getId() == "Hueco") {
                micro.setTiempoTotal(micro.getTiempoTotal() - (micro.getTerminados().get(micro.getTerminados().size()-1)).getExeTime());
                micro.getTerminados().remove(micro.getTerminados().size()-1);
            }
        }
    }

    public Micro chooseMicro(){
        Micro min = Collections.min(listaMicros);
        return min;
    }
    public ArrayList<Micro> getListaMicros() {
        return listaMicros;
    }

    public void imprimirTablas(){
        for (Micro m: listaMicros){
            System.out.println("Micro: " + m.getId());
            System.out.println("Proceso\t TCC\t TE \t TVC\t TB \t TT \t TI \t TF");
            for (Proceso p : m.getTerminados()){
                System.out.format("%3s%8d%8d%8d%8d%8d%8d%8d%n", p.getId(), p.getTCC(), p.getExeTime(), p.getTVC(), p.getTB(),
                        p.getTotal(), p.gettInicial(), p.gettFinal());
            }
            System.out.println("Tiempo total Micro " + m.getId() + " = " + m.getTiempoTotal());
            System.out.println();
        }
    }
}
