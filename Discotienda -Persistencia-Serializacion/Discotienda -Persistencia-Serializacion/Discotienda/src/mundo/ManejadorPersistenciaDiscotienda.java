package mundo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ManejadorPersistenciaDiscotienda{
    private Discotienda discotienda;

    public ManejadorPersistenciaDiscotienda(Discotienda discotienda){
        this.discotienda = discotienda;
    }

    // Método para guardar la discotienda
    public void guardarDiscotienda() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("./data/discotienda.dat")));
        oos.writeObject(discotienda);
        oos.close();
    }

    public void cargarDiscotienda() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("./data/discotienda.dat")));
        Discotienda cargada = (Discotienda) ois.readObject();
        discotienda.setDiscos(cargada.getDiscos());
        ois.close();
    }


}