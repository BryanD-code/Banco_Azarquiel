public class Cliente {
 private int id;
 private double cantidadRetirar;

    public Cliente(int id, double cantidadRetirar) {
        this.id = id;
        this.cantidadRetirar = cantidadRetirar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidadRetirar() {
        return cantidadRetirar;
    }

    public void setCantidadRetirar(double cantidadRetirar) {
        this.cantidadRetirar = cantidadRetirar;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cantidadRetirar=" + cantidadRetirar +
                '}';
    }
}
