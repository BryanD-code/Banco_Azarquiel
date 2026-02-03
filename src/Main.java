import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Cuenta bancaria
        CuentaBancaria banco = new CuentaBancaria(1500,0,false);
        //Crear clientes
        Cliente cliente1 = new Cliente(1,10);
        Cliente cliente2 = new Cliente(2,20);
        Cliente cliente3 = new Cliente(3,30);
        Cliente cliente4 = new Cliente(4,40);
        // array de clientes
        List<Cliente> clientes =new ArrayList<>() ;
       clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);

        // Cajero
        Cajero cajero1 = new Cajero(1,500,banco,clientes);
        Cajero cajero2 = new Cajero(2,600,banco,clientes);
        Cajero cajero3 = new Cajero(3,400,banco,clientes);

        cajero2.run();
        cajero1.run();
        cajero3.run();



    }
}