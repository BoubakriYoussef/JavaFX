package com.example.youssefboubakri;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class writeRead {
    File file;

    public writeRead(File file) {
        this.file = file;
    }

    void write(Manager manager) throws IOException {
        Manager manager1;
        ObjectInputStream entre = null;
        ObjectOutputStream sortie = null;
        boolean flag = false;
        File temporaire = new File("temp.txt");
        sortie = new ObjectOutputStream(new FileOutputStream(temporaire));
        try {
            entre = new ObjectInputStream(new FileInputStream(file));
            manager1 = (Manager) entre.readObject();
            while (manager1 != null){
                if (manager.ID.equals(manager1.ID)){
                    sortie.writeObject(manager);
                    flag = true;
                }else {
                    sortie.writeObject(manager1);
                }
                manager1 = (Manager) entre.readObject();
            }
        } catch (FileNotFoundException e) {

        }
        catch (EOFException e) {entre.close();}
        catch (ClassNotFoundException e){}

        if (!flag) sortie.writeObject(manager);
        sortie.close();
        file.delete();
        temporaire.renameTo(file);
    }

    Set<Manager> Read() throws IOException {
        Manager manager;
        Set<Manager> s = new HashSet<Manager>();
        ObjectInputStream entre = new ObjectInputStream(new FileInputStream((file)));
        try {
            manager = (Manager) entre.readObject();
            while (manager != null){
                s.add(manager);
                manager = (Manager) entre.readObject();
            }

        } catch (EOFException e) {
            entre.close();
        } catch (ClassNotFoundException e) {}
        return s;
    }
}