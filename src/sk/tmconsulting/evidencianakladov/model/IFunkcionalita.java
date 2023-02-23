package sk.tmconsulting.evidencianakladov.model;
import java.util.ArrayList;

public interface IFunkcionalita {
    //Vstupne udaje z konzoly cez Scanner
    String zadajTextovyUdaj();
    int zadajCiselnyUdaj();

    //Agregacne funkcie
    double spocitajVsetkyVydavky();
    int zistiPocetVsetkychVydavkov();

    void vypisMenu();
    void exportPDF(); //exportuje vsetky zaznamy s detailami a celkovym sumarom

    //MySQL
    void ulozMySQL(Vydavok vydavok);
    ArrayList<Vydavok> vyberVsetkyMySQL(); //vyberie vsetky zoznamy z databazy a vrati ArrayList
    //Ako bude reagovat aplikacia,ked zvolime menu polozku Uprav zoznam. App sa nasledne opyta na ID zoznamu,cize bude pracovat s nim
    void aktualizujMySQL(int id, Vydavok vydavok);
    void odstranMySQL(int id);


}
