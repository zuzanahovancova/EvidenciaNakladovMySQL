import com.itextpdf.text.DocumentException;
import sk.tmconsulting.evidencianakladov.model.Funkcionalita;
import sk.tmconsulting.evidencianakladov.model.Vydavok;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws SQLException, DocumentException, IOException {

        //1.krok = Zobraz menu
        //2.krok = Ak vyberieme moznost 1,tak aplikacia vyziada vstupne udaje pre vydavok (popis,cena,kategoria)
        //pozn.: datum zadania polozky je automaticky generovany
        //3.krok = Zadane udaje ulozime do databazy
        //4.krok = Ak vyberiem moznost 2 tak apl. zobrazi

        //1.krok
        Funkcionalita funkcionalitaObjekt = new Funkcionalita();
        funkcionalitaObjekt.vypisMenu();


        //2.krok
        double cisloMenu = funkcionalitaObjekt.zadajCiselnyUdaj();
        if (cisloMenu == 1) {
            //logika,ktora je priradena cislo 1
            // System.out.println("Zadal si číslo 1");
            System.out.println("zadaj popis");
            String popis = funkcionalitaObjekt.zadajTextovyUdaj();

            System.out.println("Zadaj cenu");
            double cena = funkcionalitaObjekt.zadajCiselnyUdaj();

            System.out.println("Zadaj kategóriu");
            String kategoria = funkcionalitaObjekt.zadajTextovyUdaj();

            Calendar currenttime = Calendar.getInstance();
            Date dnesnydatum = new Date((currenttime.getTime()).getTime());

            Vydavok vydavokObjekt = new Vydavok(); //vytvorime prazdny objekt vydavok
            vydavokObjekt.setPopis(popis);  //vydavok naplnime popisom
            vydavokObjekt.setCena(cena);    // -II-
            vydavokObjekt.setDatum(dnesnydatum); //-II-
            vydavokObjekt.setKategoria(kategoria); //-II-

            funkcionalitaObjekt.ulozMySQL(vydavokObjekt);
        } else if (cisloMenu == 2) {
            ArrayList<Vydavok> vydavkyPole = funkcionalitaObjekt.vyberVsetkyMySQL(); //naplnili sme vydavkyPole vsetkymi vydavkami
            //vypiseme obsah ArrayList
            for (Vydavok vystup : vydavkyPole) {
                System.out.println("Popis výdavku: " + vystup.getPopis());
                System.out.println("Cena výdavku: " + vystup.getCena());
                System.out.println("Kategória: " + vystup.getKategoria());
                System.out.println("Dátum: " + vystup.getDatum());
                System.out.println();
            }

        } else if (cisloMenu == 3) {
            System.out.println("Celková suma výdavkov: " + funkcionalitaObjekt.spocitajVsetkyVydavky());
        } else if (cisloMenu == 4) {
            System.out.println("Celkový počet záznamov:" + funkcionalitaObjekt.zistiPocetVsetkychVydavkov());
        } else if (cisloMenu == 9) {
            System.out.println("Koniec aplikácie");
            System.exit(0);
        }
    }
}
