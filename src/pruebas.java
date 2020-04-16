import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class pruebas {
    public static void main(String[] args) {
        int CC = 15;
        int Q = 3000;
        int B = 15;
        ArrayList<Proceso> lista = new ArrayList<Proceso>();

        /*for (int i=0; i<5; i++){
            int exeTime = new Random().nextInt(1000) +1;
            Proceso p = new Proceso(Integer.toString(i),exeTime);
            lista.add(p);       // supuestamente al final de la lista
            System.out.println("Proceso: "+p.getId() + ", TE =" +p.getExeTime());
        }*/
        Proceso a = new Proceso("A",400, 3000);
        Proceso b = new Proceso("B",300, 0);
        Proceso c = new Proceso("C",50, 3000);
        Proceso d = new Proceso("D",100, 0);
        Proceso e = new Proceso("E",1000, 3000);
        Proceso f = new Proceso("F",500, 0);
        Proceso g = new Proceso("G",10, 3000);
        Proceso h = new Proceso("H",700, 0);
        Proceso i = new Proceso("I",450, 3000);
        Proceso j = new Proceso("J",300, 1500);
        Proceso k = new Proceso("K",100, 4000);
        Proceso l = new Proceso("L",3000, 1500);
        Proceso m = new Proceso("M",80, 4000);
        Proceso n = new Proceso("N",50, 1500);
        Proceso nn = new Proceso("Ñ",500, 8000);
        Proceso o = new Proceso("O",600, 1500);
        Proceso p = new Proceso("P",800, 4000);

        lista.add(b);
        lista.add(d);
        lista.add(f);
        lista.add(h);
        lista.add(j);
        lista.add(l);
        lista.add(n);
        lista.add(o);
        lista.add(a);
        lista.add(c);
        lista.add(e);
        lista.add(g);
        lista.add(i);
        lista.add(k);
        lista.add(m);
        lista.add(p);
        lista.add(nn);

        Despachador x = new Despachador(lista, 2, CC, Q, B);
        x.startDispatch();
        x.imprimirTablas();
    }

}
