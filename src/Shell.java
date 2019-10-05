import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Shell  extends JFrame implements ActionListener {
    private JButton btn_aceptar, btn_salir;

    public Shell(){
        setSize(200,150);
        setTitle("Shell Sort");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        btn_aceptar = new JButton("Aceptar");
        btn_aceptar.addActionListener(this);
        add(btn_aceptar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_aceptar){
            Scanner entrada= new Scanner(System.in);
            int intArray[], elementos;
            elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de elementos en el arreglo"));
            intArray = new int[elementos];

            for(int i=0; i<elementos; i++) {
                System.out.print((i+1)+". Digite un número: ");

                intArray[i]=entrada.nextInt();
            }

            for (int gap = intArray.length /2; gap > 0; gap/= 2) {

                for (int i = gap; i<intArray.length; i++) {
                    int newElement = intArray[i];

                    int j = i;
                    while (j >= gap && intArray[j - gap] > newElement) {
                        intArray[j] = intArray[j - gap];
                        j -= gap;
                    }
                    intArray[j] = newElement;
                }
            }
            System.out.print("\nArreglo ordenado en forma creciente ");
            for (int i= 0; i< intArray.length; i++){
                System.out.println(intArray[i]+  " - ");

            }
            System.out.print("\nArreglo ordenado en forma decreciente ");
            for(int i=(elementos-1); i>=0; i--) {
                System.out.print(intArray[i]+ " - ");
            }
        }
    }
}
