import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

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
            Double[] result = new Double[0];
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException r) {
                System.out.println("MySQL JDBC Driver not found !!");
                return;
            }
            System.out.println("MySQL JDBC Driver Registered!");
            Connection connection = null;

            String url = "jdbc:mysql://localhost:3306/dht_data1?useSSL=false";
            String user = "root";
            String password = "";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select * from dht_data1;")){

                System.out.println("SQL Connection to database established!");


                ArrayList<Double> list = new ArrayList<Double>();
                while (rs.next()) {
                    //list.add(rs.getDate("humidity"));
                    list.add(rs.getDouble("Temperatura"));
                    //list.add(rs.getInt("humidity"));
                }

                result = new Double[list.size()];
                result = list.toArray(result);

            } catch (SQLException r) {
                System.out.println("Connection Failed! Check output console");
                return;
            } finally {
                try
                {
                    if(connection != null)
                        connection.close();
                    System.out.println("Connection closed !!");
                } catch (SQLException r) {
                    r.printStackTrace();
                }
            }





            quickSort(result, 0, result.length);
            System.out.print("\nArreglo ordenado en forma creciente ");
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i] + " - ");

            }
            System.out.print("\nArreglo ordenado en forma decreciente ");
            for (int i = (result.length - 1); i >= 0; i--) {
                System.out.print(result[i] + " - ");
            }
        }
    }



    private static void quickSort(Double[] input, int start, int end) {
        if (end - start<2){
            return;
        }
        int pivotIndex =partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex +1, end);


    }
    public static int partition(Double[] input, int start, int end){
        Double pivot = input[start];
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
