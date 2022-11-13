package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Laptop;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() {
        laptopi = new ArrayList<>();
        file = new File("src/main/resources/laptopi.txt");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public Laptop getLaptop(String procesor) {
        Laptop temp = new Laptop();
        for (Laptop el : laptopi)
            if (el.getProcesor().equals(procesor))
                return el;
        throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {
        laptopi.addAll(l);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        laptopi.add(laptop);
        os.writeObject(laptopi);

        os.close();
        fos.close();
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> rez;
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream is = new ObjectInputStream(fis);
        try {
            rez = (ArrayList<Laptop>) is.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rez;
    }
}
