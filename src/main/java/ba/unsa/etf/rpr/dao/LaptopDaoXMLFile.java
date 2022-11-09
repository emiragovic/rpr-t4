package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Laptop;
import ba.unsa.etf.rpr.dao.LaptopDao;

import java.io.File;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile() {
        laptopi = new ArrayList<>();
        file = new File("src/main/resources/laptopi.xml");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {

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
