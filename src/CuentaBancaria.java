public class CuentaBancaria {
 private double saldo;
 private int cantidad;
 private boolean retiroExitoso;

    public CuentaBancaria(double saldo, int cantidad, boolean retiroExitoso) {
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Funcion con synchronized para retirar para que solo 1 hilo a la vez pueda acceder
    public synchronized boolean retiroDinero(int cantidad){
     if (this.saldo >= cantidad){
     this.saldo -= cantidad;
     retiroExitoso = true;
     }else {
         retiroExitoso = false;
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
