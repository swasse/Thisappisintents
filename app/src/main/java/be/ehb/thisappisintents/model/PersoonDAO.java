package be.ehb.thisappisintents.model;

import java.util.ArrayList;

/**
 * Created by ontlener on 11/02/2019. ;)
 */
public class PersoonDAO {
    //Singleton pattern
    private static final PersoonDAO ourInstance = new PersoonDAO();

    public static PersoonDAO getInstance() {
        return ourInstance;
    }

    private PersoonDAO() {

        personen.add( new Persoon("David",
                "tel:0492827218",
                "http://www.ehb.be") );
        personen.add( new Persoon("Joske Vermeulen",
                "tel:0492827218",
                "http://www.ehb.be") );

    }

    //eigen waarden
    private ArrayList<Persoon> personen = new ArrayList<>();

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }
}
