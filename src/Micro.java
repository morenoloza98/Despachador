import java.util.ArrayList;

// micro sólo se vacía cuando hay un hueco, o un tiempo de espera.

public class Micro implements Comparable<Micro> {
    private int id;
    private ArrayList<Proceso> terminados = new ArrayList<Proceso>();   // NO necesita ser Queue
    private int tiempoTotal;
    private boolean isEmpty;
    private int context;
    private int quantum;
    private int block;

    public Micro(int id, int cc, int q, int b) {
        this.id = id;
        this.tiempoTotal = 0;
        context = cc;
        quantum = q;
        block = b;
        this.isEmpty = true;
    }

    public void process(Proceso p) {
        // calcula tiempos, actualiza tiempo total de micro, guarda tiempo inicial y final de proceso, añade proceso a terminados
        p.settInicial(this.tiempoTotal);
        int pTime = 0;
        if (!isEmpty){
            pTime += context;
        }
        pTime = pTime + p.getExeTime() + this.calculateTVC(p) + this.calculateBlock(p);
        this.tiempoTotal += pTime;
        p.settFinal(p.getInicial() + pTime);
        this.terminados.add(p);
        this.setEmpty(false);

        System.out.println("Proceso: "+p.getId() + "\tExecution time: " + pTime + "\t Tiempo final micro: " + this.tiempoTotal);
    }

    public int calculateBlock(Proceso p) {
        if (p.getExeTime()<=400){
            return 2*block;
        } else if (p.getExeTime()<=600) {
            return 3*block;
        } else if (p.getExeTime()<=800) {
            return 4*block;
        } else{
            return 5*block;
        }
    }

    public int calculateTVC(Proceso p) {
        if (p.getExeTime()%quantum == 0){       // no sobra tiempo. n-1 cambios.
            return ((p.getExeTime()/quantum - 1)*context);
        }
        return (p.getExeTime()/quantum)*context;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    @Override
    public String toString() {
        return "Micro{" +
                "id=" + id +
                ", tiempoTotal=" + tiempoTotal +
                '}';
    }
    @Override
    public int compareTo(Micro o) {
        if (this.tiempoTotal>o.tiempoTotal){
            return 1;
        }
        if (this.tiempoTotal<o.tiempoTotal){
            return -1;
        }
        return 0;
    }

}
