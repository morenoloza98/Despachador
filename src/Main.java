import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main extends JFrame
{
    private JTextField microsTF;
    private JTextField quantumTF;
    private JTextField contextoTF;
    private JTextField bloqueoTF;

    private ActionListener EnviarDatos = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            // Obtener los datos
            try
            {
                int micros = Integer.parseInt(microsTF.getText());
                int quantum = Integer.parseInt(quantumTF.getText());
                int contexto = Integer.parseInt(contextoTF.getText());
                int bloqueo = Integer.parseInt(bloqueoTF.getText());
                ArrayList<Proceso> lista = populateList();
                System.out.println(micros);
                System.out.println(quantum);
                System.out.println(contexto);
                System.out.println(bloqueo);
                Despachador x = new Despachador(lista, micros, contexto, quantum, bloqueo);
                // Procesamiento de los datos
                x.startDispatch(); //process se refiere a la clase donde realizar toda la asignación
                x.imprimirTablas();

            }
            catch (NumberFormatException e)
            {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    };

    private Main()
    {
        super();
        //Elementos de JPanel
        JButton boton = new JButton("Enviar");
        JLabel titulo = new JLabel("DESPACHADOR");
        JLabel enrique = new JLabel("Enrique Orduña - A01339605");
        JLabel eric = new JLabel("Eric Jardón - A01376748");
        JLabel alex = new JLabel("Alejandro Moreno - A01654319");
        JLabel micros = new JLabel("Micros:");
        JLabel quantum = new JLabel("Quantum:");
        JLabel contexto = new JLabel("C Contexto:");
        JLabel bloqueo = new JLabel("Bloqueo:");
        microsTF = new JTextField();
        quantumTF = new JTextField();
        contextoTF = new JTextField();
        bloqueoTF = new JTextField();

        // Posicionamiento de los elementos
        titulo.setBounds(50, 50, 300, 60);
        enrique.setBounds(330, 50, 200, 40);
        eric.setBounds(330, 90, 200, 40);
        alex.setBounds(330, 130, 240, 40);
        micros.setBounds(50, 200, 100, 40);
        quantum.setBounds(50, 240, 100, 40);
        contexto.setBounds(350, 200, 100, 40);
        bloqueo.setBounds(350, 240, 100, 40);
        microsTF.setBounds(150, 200, 100, 35);
        quantumTF.setBounds(150, 240, 100, 35);
        contextoTF.setBounds(450,200, 100, 35);
        bloqueoTF.setBounds(450, 240, 100, 35);
        boton.setBounds(300, 300, 100, 40);

        //Asignación de fuentes
        Font fuente = new Font("Arial", Font.BOLD, 14);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        enrique.setFont(fuente);
        eric.setFont(fuente);
        alex.setFont(fuente);
        micros.setFont(fuente);
        quantum.setFont(fuente);
        contexto.setFont(fuente);
        bloqueo.setFont(fuente);
        microsTF.setFont(fuente);
        quantumTF.setFont(fuente);
        contextoTF.setFont(fuente);
        bloqueoTF.setFont(fuente);

        // Colocación de los elementos
        add(titulo);
        add(enrique);
        add(eric);
        add(alex);
        add(micros);
        add(quantum);
        add(contexto);
        add(bloqueo);
        add(microsTF);
        add(quantumTF);
        add(contextoTF);
        add(bloqueoTF);
        add(boton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 430);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(115, 185, 255));
        //Listeners
        boton.addActionListener(EnviarDatos);
    }

    public ArrayList<Proceso> populateList() {
        ArrayList<Proceso> lista = new ArrayList<>();
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
        System.out.println("Populated list succesfully");
        return lista;
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
