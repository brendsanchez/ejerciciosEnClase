import java.io.*;

class LeeFichero {
    public static void main(String[] arg) {
        //List<NotaMusical> notas = new LinkedList<>();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("entrada/notas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.length() == 3) {
                    Resolucion.addListNota(new NotaMusical(linea.charAt(0), linea.charAt(1), linea.charAt(2)));
                } else {
                    Resolucion.addListNota(new NotaMusical(linea.charAt(0), linea.charAt(1)));
                }
            }
            /*
            Resolucion resolucion = new Resolucion();
            resolucion.resolver(); */

            Resolucion.getListaNotas().forEach(nota -> System.out.println(nota.getNota() + " " + nota.getNumero()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

