public class Cajero {
    private int id;
    private float saldoDisponible;

    public Cajero(float saldoDisponible, int id) {
        this.saldoDisponible = saldoDisponible;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "id=" + id +
                ", saldoDisponible=" + saldoDisponible +
                '}';
    }
}
