public class Deposito {
    private int profundidad;
    private int base;
    private Integer petroleoAlmacenado = 0;

    public Deposito(String profundidad, String base) {
        this.profundidad = Integer.parseInt(profundidad);
        this.base = Integer.parseInt(base);
    }

    public Deposito(int profundidad, int base) {
        this.profundidad = profundidad;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "profundidad=" + profundidad +
                ", base=" + base +
                '}';
    }

    public Integer cantidadMaxima() {
        return getProfundidad() * getBase();
    }

    public Integer getProfundidad() {
        return this.profundidad;
    }

    public Integer getBase() {
        return this.base;
    }

    public boolean tieneEspacioSuficiente(int cantidad) {
        return this.profundidad - cantidad >= 0;
    }


    public void setPetroleoAlmacenado(int petroleoAlmacenado) {
        this.petroleoAlmacenado = petroleoAlmacenado;
    }


    public int distanciaSuperficieHastaNivelDeFluido() {
        double nivelDepositoRestante = (this.petroleoAlmacenado.doubleValue() * this.getBase().doubleValue()) / this.cantidadMaxima().doubleValue();
        System.out.println("real distancia hasta superficie:" + (this.getBase().doubleValue() - nivelDepositoRestante));
        return (int) Math.round(this.getBase() - nivelDepositoRestante);
    }
}
