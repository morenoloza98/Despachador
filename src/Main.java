import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    // aquí iría el código de la gui
    public static void main(String[] args) {
        // Crear procesos
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

        // Constantes y creación de Despachador
        int CC = 10;
        int Q = 3000;
        int B = 10;
        int numMicros =1;

        Queue<Proceso> lista = new LinkedList<Proceso>();
        Despachador x = new Despachador(lista,numMicros,CC,Q,B);

        // PRIMER LOTE - Inicio
        lista.add(b);
        lista.add(d);
        lista.add(f);
        lista.add(h);
        x.despacha();
        x.detectarHuecos(1500);
        lista.add(j);
        lista.add(l);
        lista.add(n);
        lista.add(o);
        x.despacha();
        x.detectarHuecos(3000);
        lista.add(a);
        lista.add(c);
        lista.add(e);
        lista.add(g);
        lista.add(i);
        x.despacha();
        x.detectarHuecos(4000);
        lista.add(k);
        lista.add(m);
        lista.add(p);
        x.despacha();
        x.detectarHuecos(8000);
        lista.add(nn);
        x.despacha();
        x.deleteHole();
        x.imprimirTablas();

    }



}
