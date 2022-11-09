package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Laptop;
import ba.unsa.etf.rpr.dao.LaptopDao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() {
        laptopi = new ArrayList<>();
        file = new File("src/main/resources/laptopi.dat");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/main/resources/laptopi.dat")));
        out.writeObject(laptop);
        out.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {
        for (Laptop el : l)
            laptopi.add(el);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> rez = new ArrayList<>();
        return rez;
    }
}
