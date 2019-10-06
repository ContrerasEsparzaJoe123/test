import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
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
            Integer[] result = new Integer[0];
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javat", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from temp;");

                ArrayList<Integer> list = new ArrayList<Integer>();
                while (rs.next()) {
                    //list.add(rs.getDate("humidity"));
                    list.add(rs.getInt("temperatura"));
                    //list.add(rs.getInt("humidity"));
                }

                result = new Integer[list.size()];
                result = list.toArray(result);


            } catch (ClassNotFoundException r) {
                r.printStackTrace();
            } catch (SQLException r) {
                r.printStackTrace();
            }

            for (int gap = result.length /2; gap > 0; gap/= 2) {

                for (int i = gap; i<result.length; i++) {
                    int newElement = result[i];

                    int j = i;
                    while (j >= gap && result[j - gap] > newElement) {
                        result[j] = result[j - gap];
                        j -= gap;
                    }
                    result[j] = newElement;
                }
            }
            System.out.print("\nArreglo ordenado en forma creciente ");
            for (int i= 0; i< result.length; i++){
                System.out.println(result[i]+  " - ");

            }
            System.out.print("\nArreglo ordenado en forma decreciente ");
            for(int i=(result.length-1); i>=0; i--) {
                System.out.print(result[i]+ " - ");
            }
        }
    }
}
