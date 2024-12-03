package mundo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
public class ManejadorDePersistenciaDiscotienda {

    private Discotienda discotienda;

    public ManejadorDePersistenciaDiscotienda(Discotienda discotienda) {
        this.discotienda = discotienda;
    }

    public void guardarDiscotienda() throws FileNotFoundException {
        PrintWriter escritor = new PrintWriter("./data/discotienda.txt");
        ArrayList<Disco> discos = discotienda.getDiscos();
        for (Disco disco : discos){
            escritor.println(disco.getNombre() + ";" + disco.getArtista() + ";" + disco.getAnio());

            for (Cancion cancion : disco.getCanciones()){
                escritor.println(cancion.getNombre() + ";" + cancion.getDuracionMinutos() + ";" + cancion.getDuracionSegundos() + ";" + cancion.getGenero());
            }

        }

        escritor.close();

    }

    public void leerDiscotienda() throws IOException {
        ArrayList<Disco> discos = new ArrayList<Disco>();
        File f = new File("./data/discotienda.txt");
        BufferedReader lector = new BufferedReader(new FileReader(f));
        String linea = lector.readLine();

        Disco discoActual = null;

        while(linea != null){
            if (!linea.startsWith(" ")){
                String[] datosDisco = linea.split(";");
                String nombre = datosDisco[0];
                String artista = datosDisco[1];
                int anio = Integer.parseInt(datosDisco[2]);
                discoActual = new Disco(nombre, artista, anio);
                discos.add(discoActual);
            } else {
                String[] datosCancion = linea.trim().split(";");
                String nombre = datosCancion[0];
                int duracionMinutos = Integer.parseInt(datosCancion[1]);
                int duracionSegundos = Integer.parseInt(datosCancion[2]);
                String genero = datosCancion[3];
                Cancion cancion = new Cancion(nombre, duracionMinutos, duracionSegundos, genero);
                if (discoActual != null){
                    discoActual.getCanciones().add(cancion);
                }
            }
            linea = lector.readLine();
        }
        lector.close();
        discotienda.setDiscos(discos);
    }

}
