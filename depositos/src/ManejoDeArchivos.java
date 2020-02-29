import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ManejoDeArchivos {
    public static void main(String[] arg){
        Resolucion resolucion = new Resolucion();

        //Leer archivo
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("entrada/depositos_in.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                List<String> line = Arrays.asList(linea.split(" "));
                if (line.size() == 2) {
                    resolucion.addListaDeposito(new Deposito(line.get(0), line.get(1)));
                } else {
                    resolucion.addListDatos(line.get(0));
                }
            }

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

        //Escribir archivo
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("salida/depositosOut.txt");
            pw = new PrintWriter(fichero);

            pw.println(resolucion.resolver());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
