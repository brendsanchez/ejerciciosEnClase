import java.io.*;

public class EscribeFichero {
    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("salida/bemolesOut.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

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