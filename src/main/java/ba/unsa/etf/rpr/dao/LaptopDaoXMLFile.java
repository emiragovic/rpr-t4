package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Laptop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public void dodajLaptopUFile(Laptop laptop) throws JsonProcessingException, FileNotFoundException {
        laptopi.add(laptop);
        try {
            XmlMapper mapper = new XmlMapper();
            String temp = mapper.writeValueAsString(laptopi);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(temp.getBytes());
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Laptop getLaptop(String procesor) {
        Laptop temp = new Laptop();
        for (Laptop el : laptopi)
            if (el.getProcesor().equals(procesor))
                temp = el;
        return temp;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {
        laptopi.addAll(l);
    }


    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> rez;
        XmlMapper mapper = new XmlMapper();
        rez = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {
        });
        return rez;
    }
}
