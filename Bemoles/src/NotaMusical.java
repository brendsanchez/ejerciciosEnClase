import java.util.HashMap;
import java.util.Map;

public class NotaMusical {
    private String nota;
    private int octave;
    private int valor = 0;

    public NotaMusical(int valor) {
        this.valor = valor;
        this.nota = String.valueOf(notaMusicalNumericoValor().get((valor - 1) % 7 + 1));
        this.octave = (valor - 1) / 7;
    }

    public NotaMusical(char nota, char octave) {
        this.nota = String.valueOf(nota);
        this.octave = Character.getNumericValue(octave);
        this.asignarValorNumerico(nota);
    }

    public NotaMusical(char nota, char octave, char numeral) {
        this.nota = String.valueOf(nota) + numeral;
        this.octave = Character.getNumericValue(octave);
        this.asignarValorNumerico(nota);
    }

    @Override
    public String toString() {
        return "NotaMusical{" +
                "letra=" + nota +
                ", octava=" + octave +
                '}';
    }

    public String getNota() {
        if (nota.length() > 1) {
            return String.valueOf(nota.charAt(0)) + octave + nota.charAt(1);
        } else {
            return String.valueOf(nota.charAt(0)) + octave;
        }
    }

    public int getNumero() {
        return this.valor + (this.octave - 1) * 7;
    }

    private void asignarValorNumerico(char aChar) {
        for (Map.Entry<Character, Integer> notaValor : notaMusicalValorNumerico().entrySet()) {
            if (notaValor.getKey().equals(aChar)) {
                this.valor = notaValor.getValue();
            }
        }
    }

    private static Map<Character, Integer> notaMusicalValorNumerico() {
        Map<Character, Integer> mapa = new HashMap();
        mapa.put('C', 1);
        mapa.put('D', 2);
        mapa.put('E', 3);
        mapa.put('F', 4);
        mapa.put('G', 5);
        mapa.put('A', 6);
        mapa.put('B', 7);
        return mapa;
    }

    private static Map<Integer, Character> notaMusicalNumericoValor() {
        Map<Integer, Character> mapa = new HashMap();
        mapa.put(1, 'C');
        mapa.put(2, 'D');
        mapa.put(3, 'E');
        mapa.put(4, 'F');
        mapa.put(5, 'G');
        mapa.put(6, 'A');
        mapa.put(7, 'B');
        return mapa;
    }
}
