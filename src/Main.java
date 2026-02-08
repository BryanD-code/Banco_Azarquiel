import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Cuenta bancaria
        CuentaBancaria banco = new CuentaBancaria(1500,0);
        //Crear clientes
        List<Cliente> clientes = Collections.synchronizedList(new ArrayList<>());
        // creo 10 clientes con cantidades aleatorias
        for (int i = 1; i <= 10; i++) {
            clientes.add(new Cliente(i, (Math.random() * 200) + 50, "Cliente-" + i));
        }

        // Cajeros
        Cajero cajero1 = new Cajero(1,500,banco,clientes);
        Cajero cajero2 = new Cajero(2,500,banco,clientes);
        Cajero cajero3 = new Cajero(3,500,banco,clientes);

        // iniciar hilos
        cajero1.start();
        cajero2.start();
        cajero3.start();

        try {
            // 4. Esperar a que terminen
            cajero1.join();
            cajero2.join();
            cajero3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imprimirResumen(banco, cajero1, cajero2, cajero3);



    }
    private static void imprimirResumen(CuentaBancaria banco, Cajero... cajeros) {
        int totalOk = 0;
        int totalNo = 0;
        double totalDinero = 0;

        for (Cajero c : cajeros) {
            totalOk += c.getOpTrue();
            totalNo += c.getOpFalse();
            totalDinero += c.getTotalRetiradoCajero();
        }

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Saldo final: " + String.format("%.2f", banco.getSaldo()) + "€");
        System.out.println("Operaciones OK: " + totalOk);
        System.out.println("Operaciones DENEGADAS: " + totalNo);
        System.out.println("Total retirado: " + String.format("%.2f", totalDinero) + "€");
        System.out.println("Total clientes atendidos: " + (totalOk + totalNo));
    }
}