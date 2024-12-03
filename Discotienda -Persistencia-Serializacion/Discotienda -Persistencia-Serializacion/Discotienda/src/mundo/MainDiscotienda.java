package mundo;

import java.io.IOException;

public class MainDiscotienda {

    public static void main(String[] args) {
        Discotienda discotienda = new Discotienda();

        // Crear discos y canciones
        Disco disco1 = new Disco("Thriller", "Michael Jackson", 1982);
        disco1.getCanciones().add(new Cancion("Thriller", 5, 57, "Pop"));
        disco1.getCanciones().add(new Cancion("Beat It", 4, 18, "Rock"));

        Disco disco2 = new Disco("Back in Black", "AC/DC", 1980);
        disco2.getCanciones().add(new Cancion("Hells Bells", 5, 12, "Rock"));
        disco2.getCanciones().add(new Cancion("Shoot to Thrill", 5, 17, "Rock"));

        discotienda.getDiscos().add(disco1);
        discotienda.getDiscos().add(disco2);

        // Crear el manejador de persistencia
        ManejadorPersistenciaDiscotienda manejador = new ManejadorPersistenciaDiscotienda(discotienda);

        try {
            // Guardar la información
            manejador.guardarDiscotienda();
            System.out.println("Discotienda guardada correctamente.");

            // Cargar la información
            manejador.cargarDiscotienda();
            System.out.println("Discotienda cargada correctamente.");

            // Imprimir la información cargada
            for (Disco disco : discotienda.getDiscos()) {
                System.out.println("Disco: " + disco.getNombre() + " - " + disco.getArtista() + " (" + disco.getAnio() + ")");
                for (Cancion cancion : disco.getCanciones()) {
                    System.out.println("  Canción: " + cancion.getNombre() + " [" + cancion.getDuracionMinutos() + ":" + cancion.getDuracionSegundos() + "] - " + cancion.getGenero());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
