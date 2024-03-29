import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
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
                Double aux;

                for(int i=0; i<(result.length-1); i++) {
                    for(int j=0; j<(result.length-1); j++) {
                        if(result[j] > result[j+1]) { //Si número actual > número siguiente
                            aux = result[j];
                            result[j] = result[j+1];
                            result[j+1] = aux;
                        }
                    }
                }

                //Mostrando el arreglo de forma creciente
                System.out.print("\nArreglo ordenado en forma creciente ");
                for(int i=0; i<result.length; i++) {
                    System.out.print(result[i]+ " - ");
                }
                System.out.print("\nArreglo ordenado en forma decreciente ");
                for (int i = (result.length - 1); i >= 0; i--) {
                    System.out.print(result[i] + " - ");
                }

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
