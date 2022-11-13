package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Laptop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile() {
        laptopi = new ArrayList<>();
        file = new File("src/main/resources/laptopi.json");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        try {
            JsonMapper mapper = new JsonMapper();
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
        for(Laptop el : laptopi)
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
        JsonMapper mapper = new JsonMapper();
        rez = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {
        });
        return rez;
    }
}
