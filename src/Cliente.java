public class Cliente {
 private int id;
 private double cantidadRetirar;
 private String nombre;

    public Cliente(int id, double cantidadRetirar, String nombre) {
        this.id = id;
        this.cantidadRetirar = cantidadRetirar;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cantidadRetirar=" + cantidadRetirar +
                '}';
    }
}
