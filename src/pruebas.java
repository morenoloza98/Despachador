import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class pruebas {
    public static void main(String[] args) {
        int CC = 10;
        int Q = 100;
        int B = 10;

        Queue<Proceso> lista = new LinkedList<Proceso>();

        for (int i=0; i<5; i++){
            int exeTime = new Random().nextInt(1000) +1;
            Proceso p = new Proceso(Integer.toString(i),exeTime);
            lista.add(p);       // supuestamente al final de la lista
            System.out.println("Proceso: "+p.getId() + ", TE =" +p.getExeTime());
        }
        System.out.println("DESPACHAR\n");
        Despachador d = new Despachador(lista, 3, 10,10,10);
        d.despacha();

    }

}
