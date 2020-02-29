import java.util.*;

public class Resolucion {
    private List<NotaMusical> notaMusicals = new LinkedList<>();
    private ArrayList<Conjunto> conjuntos = new ArrayList<>();

    public static void addListNota(NotaMusical nota) {
        notaMusicals.add(nota);
    }

    public static List<NotaMusical> getListaNotas() {
        return notaMusicals;
    }

    public void resolver() {
        Conjunto c = new Conjunto();
        conjuntos.add(c);


        for (NotaMusical notaMusical : getListaNotas()) {
            if (c.sePuedeAgregar(notaMusical)) {
                c.agregar(notaMusical);
            } else {
                c = new Conjunto();
                conjuntos.add(c);
            }
        }

        //todo conjunto queda vacio

        NotaMusical anterior = null;
        for(Conjunto conjunto : conjuntos) {
            anterior = conjunto.posicionMano(anterior);
            System.out.println(anterior.getNumero());
            //notasMano.add(anterior);
        }
    }

}
