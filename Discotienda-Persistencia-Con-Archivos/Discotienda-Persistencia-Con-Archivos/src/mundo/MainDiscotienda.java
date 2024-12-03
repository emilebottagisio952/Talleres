package mundo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainDiscotienda {

    public static void main(String[] args){
        Discotienda discotienda = new Discotienda();

        Disco disco1 = new Disco("Thriller", "Michael Jackson", 1982);
        disco1.getCanciones().add(new Cancion("Thriller", 5, 57, "Pop"));
        disco1.getCanciones().add(new Cancion("Beat It", 4, 18, "Pop"));

        Disco disco2 = new Disco("Black in Black", "AC/DC", 1980);
        disco2.getCanciones().add(new Cancion("Hells Bells", 5, 12, "Rock"));
        disco2.getCanciones().add(new Cancion("Shoot to Thrill", 5, 17, "Rock"));

        discotienda.getDiscos().add(disco1);
        discotienda.getDiscos().add(disco2);

        ManejadorDePersistenciaDiscotienda manejador = new ManejadorDePersistenciaDiscotienda(discotienda);

        try {

            //Guardar Información

            manejador.guardarDiscotienda();

            // Leer la información desde el archivo

            manejador.leerDiscotienda();

            // Imprimir la información
            for (Disco disco : discotienda.getDiscos()){
                System.out.println("Disco:" + disco.getNombre() + "-" + disco.getArtista() + "-" + disco.getAnio());
                for (Cancion cancion : disco.getCanciones()){
                    System.out.println("Cancion:" + cancion.getNombre() + "-" + cancion.getDuracionMinutos() + ":" + cancion.getDuracionSegundos() + "-" + cancion.getGenero());
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al guardar la información");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la información");
        }



    }
    

}
