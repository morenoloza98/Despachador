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
        // Discriminar por tiempos de micro,
        while (listaProcesos.size()!=0){
            // debe leer los tiempos de todos los micros y escoger el de menor tiempo, cuidando prioridad de id.
            // el de menor tiempo se le asigna y procesa el primer proceso en la cola.
            System.out.println("Proceso " + listaProcesos.peek().getId() + " a:" + this.chooseMicro());
            this.chooseMicro().process(listaProcesos.remove());
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
        ImpresionTablas it = new ImpresionTablas(listaMicros);
        it.createAndShowGUI(listaMicros);
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
