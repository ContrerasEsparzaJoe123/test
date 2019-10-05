import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class quick extends JFrame implements ActionListener {
    private JButton btn_aceptar, btn_salir;
    public quick(){
        setSize(200,150);
        setTitle("Quick Sort");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        btn_aceptar = new JButton("Aceptar");
        btn_aceptar.addActionListener(this);
        add(btn_aceptar);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_aceptar) {
            Scanner entrada= new Scanner(System.in);
            int intArray[], elementos;
            elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de elementos en el arreglo"));
            intArray = new int[elementos];

            for(int i=0; i<elementos; i++) {
                System.out.print((i+1)+". Digite un número: ");

                intArray[i]=entrada.nextInt();
            }

            quickSort(intArray, 0, intArray.length);
            System.out.print("\nArreglo ordenado en forma creciente ");
            for (int i=0; i<intArray.length; i++){
                System.out.println(intArray[i]+  " - ");

            }
            System.out.print("\nArreglo ordenado en forma decreciente ");
            for(int i=(elementos-1); i>=0; i--) {
                System.out.print(intArray[i]+ " - ");
            }
        }
    }



    private static void quickSort(int[] input, int start, int end) {
        if (end - start<2){
            return;
        }
        int pivotIndex =partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex +1, end);


    }
    public static int partition(int[] input, int start, int end){
        int pivot = input[start];
        int i= start;
        int j = end;

        while (i<j){
            while (i<j && input[--j] >= pivot);
            if (i<j){
                input[i] = input[j];
            }

            while (i<j && input[++i] <= pivot);
            if (i<j){
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
    }
