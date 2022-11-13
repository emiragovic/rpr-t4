package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.*;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LaptopDao l = new LaptopDaoSerializableFile();

        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Asus", "...", 0, 0, 0, 0, "...", "...", 0));
        laptops.add(new Laptop("Acer", "...", 0, 0, 0, 0, "...", "...", 0));
        laptops.add(new Laptop("HP", "...", 0, 0, 0, 0, "...", "...", 0));
        laptops.add(new Laptop("Lenovo", "...", 0, 0, 0, 0, "...", "...", 0));
        laptops.add(new Laptop("Apple", "...", 0, 0, 0, 0, "...", "...", 0));
        laptops.add(new Laptop("Dell", "...", 0, 0, 0, 0, "...", "...", 0));
        try {
            for(Laptop el : laptops)
                l.dodajLaptopUFile(el);
            ArrayList<Laptop> temp;

            temp = l.vratiPodatkeIzDatoteke();
            for(Laptop el : temp)
                System.out.println(el);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
