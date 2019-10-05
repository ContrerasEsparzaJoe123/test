import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class test extends JFrame implements ActionListener {
    private JMenuBar jmb_metodo;
    private JMenu jm_metodos, jm_metodosB;
    private JMenuItem jmi_bur, jmi_sec, jmi_salir,jmi_quick, jmi_secM, jmi_Bin, jmi_Shell;

    public test() {
        setTitle("Productos");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jmb_metodo = new JMenuBar();
        jm_metodos = new JMenu("Seleccionar metodo de ordenamiento");
        jm_metodosB = new JMenu("Seleccionar metodo de Busqueda");
        jmi_salir = new JMenuItem("Salir");
        jmi_salir.addActionListener(this);
        jmi_bur = new JMenuItem("Burbuja");
        jmi_bur.addActionListener(this);
        jmi_sec = new JMenuItem("Secuencial");
        jmi_sec.addActionListener(this);
        jmi_quick = new JMenuItem("QuickSort");
        jmi_quick.addActionListener(this);
        jmi_Shell = new JMenuItem("Shell Sort");
        jmi_Shell.addActionListener(this);
        jmi_secM = new JMenuItem("Secuencial Mejorada");
        jmi_secM.addActionListener(this);
        jmi_Bin = new JMenuItem("Busqueda Binaria");
        jmi_Bin.addActionListener(this);



        jm_metodos.add(jmi_bur);
        jm_metodos.add(jmi_Shell);
        jm_metodosB.add(jmi_sec);
        jm_metodosB.add(jmi_Bin);
        jm_metodos.add(jmi_quick);
        jm_metodosB.add(jmi_secM);
        jmb_metodo.add(jm_metodos);
        jmb_metodo.add(jm_metodosB);
        jmb_metodo.add(jmi_salir);
        setJMenuBar(jmb_metodo);

        setVisible(true);

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        test ventanaPrincipal = new test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jmi_bur) {
            Scanner entrada= new Scanner(System.in);
            int arreglo[], elementos, aux;

            elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de elementos en el arreglo"));

            arreglo = new int[elementos];

            for(int i=0; i<elementos; i++) {
                System.out.print((i+1)+". Digite un número: ");

                arreglo[i]=entrada.nextInt();
            }

            //Método burbuja
            for(int i=0; i<(elementos-1); i++) {
                for(int j=0; j<(elementos-1); j++) {
                    if(arreglo[j] > arreglo[j+1]) { //Si número actual > número siguiente
                        aux = arreglo[j];
                        arreglo[j] = arreglo[j+1];
                        arreglo[j+1] = aux;
                    }
                }
            }

            //Mostrando el arreglo de forma creciente
            System.out.print("\nArreglo ordenado en forma creciente ");
            for(int i=0; i<elementos; i++) {
                System.out.print(arreglo[i]+ " - ");
            }

            //Mostrando el arreglo de forma decreciente
            System.out.print("\nArreglo ordenado en forma decreciente ");
            for(int i=(elementos-1); i>=0; i--) {
                System.out.print(arreglo[i]+ " - ");
            }
            System.out.println("");
        }
        if(e.getSource()== jmi_quick) {
            quick amg = new quick();
            amg.setVisible(true);


        }
        if(e.getSource()== jmi_Shell) {
            Shell she = new Shell();
            she.setVisible(true);


        }

    }
}
