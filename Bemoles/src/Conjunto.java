import java.util.*;

public class Conjunto {
    private List<NotaMusical> conjunto = new LinkedList<>();
    private int maximo = -999999;
    private int minimo = 999999;

    void agregar(NotaMusical notaMusical) {
        if(notaMusical == null || !sePuedeAgregar(notaMusical)) {
            throw new RuntimeException("nota musical no puede estar vacia");
        }
        maximo = Math.max(notaMusical.getNumero(), maximo);
        minimo = Math.min(notaMusical.getNumero(), maximo);
        conjunto.add(notaMusical);
    }

    boolean sePuedeAgregar(NotaMusical notaMusical) {
        int maximo_tentativo = Math.max(notaMusical.getNumero(), maximo);
        int minimo_tentativo = Math.min(notaMusical.getNumero(), maximo);
        return maximo_tentativo - minimo_tentativo <= 4;
    }

    NotaMusical posicionMano(NotaMusical posicionManoAnterior) {
        int cantQueMePuedoMover = 4 - (maximo - minimo);
        if(cantQueMePuedoMover == 0) {
            return getPrimera();
        } else {
            if(getPrimera().getNumero() < posicionManoAnterior.getNumero()) {
                return new NotaMusical(getPrimera().getNumero() + cantQueMePuedoMover);
            } else {
                return new NotaMusical(getPrimera().getNumero() - cantQueMePuedoMover);
            }
        }
    }

    private NotaMusical getPrimera() {

        Collections.sort(conjunto, new Comparator<NotaMusical>() {
            public int compare(NotaMusical n, NotaMusical n2) {
                return n.getNumero() - n2.getNumero();
            }
        });
        return conjunto.get(0);
    }

    public List<NotaMusical> getConjunto() {
        return conjunto;
    }
}
