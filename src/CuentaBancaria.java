public class CuentaBancaria {
 private double saldo;
 private double cantidad;
 private boolean retiroExitoso;

    public CuentaBancaria(double saldo, double cantidad, boolean retiroExitoso) {
        this.saldo = saldo;
        this.cantidad = cantidad;
        this.retiroExitoso = retiroExitoso;
    }

    public boolean isRetiroExitoso() {
        return retiroExitoso;
    }

    public void setRetiroExitoso(boolean retiroExitoso) {
        this.retiroExitoso = retiroExitoso;
    }

    public double getSaldo() {
        return saldo;
    }
    // para actulizar el saldo
    public synchronized void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    //Funcion con synchronized para retirar para que solo 1 hilo a la vez pueda acceder
    public synchronized boolean retiroDinero(double cantidad){
     if (this.saldo >= cantidad){
     this.saldo -= cantidad;
     retiroExitoso = true;
         System.out.println("Saldo disponible en el banco!");
     }else {
         retiroExitoso = false;
         System.out.println("No hay saldo disponible en el banco");
     }
     return retiroExitoso;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "Saldo total disponible del banco=" + saldo  +
                '}';
    }
}
