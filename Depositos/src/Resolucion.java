import java.util.*;

public class Resolucion {
    private List<Deposito> depositosList = new LinkedList<>();
    private List<String> datos = new ArrayList<>();

    public void addListaDeposito(Deposito deposito) {
        depositosList.add(deposito);
    }

    public List<Deposito> getDepositosList() {
        return depositosList;
    }

    public void addListDatos(String dato) {
        datos.add(dato);
    }

    public int getPetroleoRecibido() {
        return Integer.parseInt(datos.get(1));
    }

    public int getCantidadDeNivelesProfundidad() {
        return Integer.parseInt(datos.get(0));
    }

    public int cantidadMaximaParaAlmacenarPetroleo() {
        return depositosList.stream().mapToInt(Deposito::cantidadMaxima).sum();
    }

    public String resolver() {
        if (depositosList.size() == 0) {
            throw new RuntimeException("no hay depositos ingresados");
        }

        ordenarDepositos();
        if (getPetroleoRecibido() > cantidadMaximaParaAlmacenarPetroleo()) {
            return "Rebasan:" + (getPetroleoRecibido() - cantidadMaximaParaAlmacenarPetroleo());
        } else {
            return noDesborda();
        }
    }

    private String noDesborda() {
        int restantePetroleo = getPetroleoRecibido();
        int cantidadDeDepositos = 0;
        Deposito depositoAmpliado = new Deposito(0, 0);
        for (Deposito deposito : getDepositosList()) {

            depositoAmpliado = new Deposito(depositoAmpliado.getProfundidad() + deposito.getProfundidad(), deposito.getBase());

            if (depositoAmpliado.tieneEspacioSuficiente(restantePetroleo)) {
                cantidadDeDepositos++;
                break;
            } else {
                cantidadDeDepositos++;
                restantePetroleo -= depositoAmpliado.getProfundidad();
            }
        }
        depositoAmpliado.setPetroleoAlmacenado(restantePetroleo);
        return cantidadDeDepositos + "\n" + depositoAmpliado.distanciaSuperficieHastaNivelDeFluido();
    }


    public List<Deposito> ordenarDepositos() {
        depositosList.sort(new Comparator<Deposito>() {
            public int compare(Deposito n, Deposito n2) {
                return n.getBase() + n2.getBase();
            }
        });
        return depositosList;
    }

}
