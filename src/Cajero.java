import java.util.List;
import java.util.Random;

public class Cajero extends Thread {
    private int idCajero;
    private double saldoDisponible; 
    public CuentaBancaria cuenta;    // La cuenta del banco 
    public List<Cliente> colaClientes;
    private Random random = new Random();

    // para el resumen
    private int opTrue = 0;
    private int opFalse = 0;
    private double totalRetiradoCajero = 0;

    public Cajero(int idCajero, double saldoDisponible, CuentaBancaria cuenta, List<Cliente> colaClientes) {
        this.idCajero = idCajero;
        this.saldoDisponible = saldoDisponible;
        this.cuenta = cuenta;
        this.colaClientes = colaClientes;
    }

    @Override
    public void run() {
        if (colaClientes == null) {
            System.out.println("Cola no inicializada");
            return;
        }

        while (true) {
            Cliente clienteAtenderdouble;

            //  Solo bloqueo para sacar al cliente
            synchronized (colaClientes) {
                if (!colaClientes.isEmpty()) {
                    clienteAtenderdouble = colaClientes.remove(0);
                } else {
                    // Si no hay clientes, salimos del bucle y el hilo termina
                    break;
                }
            }

            //  Atendemos al cliente FUERA del synchronized de la lista
            // Esto permite que otros cajeros entren a la lista mientras este duerme
            if (clienteAtenderdouble != null) {
                atenderCliente(clienteAtenderdouble);
            }
        }
    }

    public void atenderCliente(Cliente cliente) {
        int tiempo = random.nextInt(1001) + 200;
        double cantidad = cliente.getCantidadRetirar();

        try {
            Thread.sleep(tiempo); // Simulación de tiempo


            // validacion de efectivo de cajero
            if (this.saldoDisponible >= cantidad) {

                // validacion de saldo de cuenta bancaria
                boolean exitoBanco = cuenta.retiroDinero(cantidad);

                if (exitoBanco) {
                    //Restamos del efectivo físico del cajero
                    this.saldoDisponible -= cantidad;
                    this.opTrue++;
                    this.totalRetiradoCajero += cantidad;

                    imprimirLog(cliente, "OK", tiempo);
                } else {
                    // Falló el banco
                    this.opFalse++;
                    imprimirLog(cliente, "DENEGADO (Banco sin fondos)", tiempo);
                }
            } else {
                // Falló el cajero físico
                this.opFalse++;
                imprimirLog(cliente, "DENEGADO (Cajero sin efectivo)", tiempo);
            }

        } catch (InterruptedException e) {
            System.out.println("Cajero-" + idCajero + " interrumpido");
        }
    }

    private void imprimirLog(Cliente cliente, String resultado, int tiempo) {
        System.out.printf("[Cajero-%d] Cliente %s solicita %.2f€ -> %s | saldo banco=%.2f€ | t=%dms\n",
                idCajero, cliente.getNombre(), cliente.getCantidadRetirar(),
                resultado, cuenta.getSaldo(), tiempo);
    }

    // Getters
    public int getOpTrue() { return opTrue; }
    public int getOpFalse() { return opFalse; }
    public double getTotalRetiradoCajero() { return totalRetiradoCajero; }
}