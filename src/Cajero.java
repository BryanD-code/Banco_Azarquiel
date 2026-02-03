import java.util.List;

public class Cajero extends Thread {
    private int idCajero;
    private double saldoDisponible;
    //Para que el saldo de los cajeros vengan de la misma cuenta
    public CuentaBancaria cuenta;
    //Para que los cajeros compartan la cola de clientes
    public List<Cliente>colaClientes;

    public Cajero(int idCajero, double saldoDisponible, CuentaBancaria cuenta, List<Cliente> colaClientes) {
        this.idCajero = idCajero;
        this.saldoDisponible = saldoDisponible;
        this.cuenta = cuenta;
        this.colaClientes = colaClientes;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cliente> getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(List<Cliente> colaClientes) {
        this.colaClientes = colaClientes;
    }
    //metodo run del cajero
    public void run(){
        if (colaClientes.isEmpty() || colaClientes==null){
            System.out.println("Sin clientes en cola");
        }else{
            for (int i =0; i<= colaClientes.size();i++){
               atenderCliente();
            }
        }
    }
    //metodo para que los cajeros saquen clientes de la cola
    public synchronized void atenderCliente(){
        System.out.println("El cliente a atender es: " +getColaClientes().get(0).getId() );
        eliminarClienteAtendido();
    }
    //eliminar cliente de la cola
    public synchronized void eliminarClienteAtendido(){
        getColaClientes().remove(0);
    }



    @Override
    public String toString() {
        return "Cajero{" +
                "cajero -=" + idCajero +"tiene un "+
                ", saldo disponible de=" + saldoDisponible +

                '}';
    }
}
