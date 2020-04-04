import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    // aquí iría el código de la gui
    public static void main(String[] args) {
        // Crear procesos
        Proceso a = new Proceso("A",400);
        Proceso b = new Proceso("B",300);
        Proceso c = new Proceso("C",50);
        Proceso d = new Proceso("D",100);
        Proceso e = new Proceso("E",1000);
        Proceso f = new Proceso("F",500);
        Proceso g = new Proceso("G",10);
        Proceso h = new Proceso("H",700);
        Proceso i = new Proceso("I",450);
        Proceso j = new Proceso("J",300);
        Proceso k = new Proceso("K",100);
        Proceso l = new Proceso("L",3000);
        Proceso m = new Proceso("M",80);
        Proceso n = new Proceso("N",50);
        Proceso nn = new Proceso("Ñ",500);
        Proceso o = new Proceso("O",600);
        Proceso p = new Proceso("P",800);

        // Constantes y creación de Despachador
        int CC = 15;
        int Q = 3000;
        int B = 15;

        Queue<Proceso> lista = new LinkedList<Proceso>();
        Despachador x = new Despachador(lista,2,CC,Q,B);

        // PRIMER LOTE - Inicio
        lista.add(b);
        lista.add(d);
        lista.add(f);
        lista.add(h);
        x.despacha();
        x.hacerHuecos(1500);
        lista.add(j);
        lista.add(l);
        lista.add(n);
        lista.add(o);
        x.despacha();
        x.hacerHuecos(3000);
        lista.add(a);
        lista.add(c);
        lista.add(e);
        lista.add(g);
        lista.add(i);
        x.despacha();
        x.hacerHuecos(4000);
        lista.add(k);
        lista.add(m);
        lista.add(p);
        x.despacha();
        x.hacerHuecos(8000);
        lista.add(nn);
        x.despacha();
        x.imprimirTablas();

    }



}
