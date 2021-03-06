import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PagrindinePrograma {
    public static void main(String[] args) {


        Scanner skaitytuvas = new Scanner(System.in);
        ArrayList<Preke> prekes = nuskaitoPrekesIsFailo("prekes.csv");

        isvestiListaAtskiraiEilutemis(prekes);

        System.out.println("Sandelyje esancios prekes ");

        ArrayList<Preke> esanciosPrekes = rastiPrekesSandelyje(prekes);
        isvestiListaAtskiraiEilutemis(esanciosPrekes);

        System.out.println("----------------------------------- ");

        System.out.println("Prekiu kiekis sandelyje = " + prekiuKiekisSandelyje(prekes));

        System.out.println("----------------------------------- ");

        System.out.println("Brangiausia preke  = " + brangiausiaPreke(prekes));

        System.out.println("----------------------------------- ");

        System.out.println("Brangiausia preke sarase = " + brangiausiaPrekeSarase(prekes));

        System.out.println("----------------------------");

        System.out.println("Kurioms bus taikoma nuolaida, nes jos brangesnes uz 600 ");

        ArrayList<Preke> nuolaidosPagalKaina = brangesnesUz600(prekes);
        isvestiListaAtskiraiEilutemis(nuolaidosPagalKaina);

        System.out.println("Prekes pavadinimu Stalas pries nuolaidas ");

        ArrayList<Preke> nuolaidosPagalPavadinima = prekesPavavadinimuStalas(prekes);
        isvestiListaAtskiraiEilutemis(nuolaidosPagalPavadinima);

        System.out.println("----------------------------------- ");

        System.out.println("ČIA JAU PO NUOLAIDOS VISOS PREKĖS (nuolaida tik brangesnems uz 600): ");

        System.out.println("----------------------------------- ");

        pritaikytiNuolaidaPrekemsBrangesnemsUz600(prekes);
        isvestiListaAtskiraiEilutemis(prekes);

        System.out.println("----------------------------------- ");

        System.out.println("Nulaidos Stalams ");

        pritaikytiNuolaidaPrekemsStalas(prekes);
        isvestiListaAtskiraiEilutemis(prekes);

        System.out.println("Sarasas pagal kategorija ");

        ArrayList<Preke> prekiuSarasasPagalKategorija = sarasasPagalKategorija(prekes);
        isvestiListaAtskiraiEilutemis(prekiuSarasasPagalKategorija);


    }

    public static ArrayList<Preke> nuskaitoPrekesIsFailo(String nuskaitomasFailas) {
        ArrayList<Preke> prekes = new ArrayList<>();
        try {
            File failoObjektas = new File(nuskaitomasFailas);
            Scanner skaitytuvas = new Scanner(failoObjektas);
            skaitytuvas.nextLine();
            while (skaitytuvas.hasNextLine()) {
                String eilute = skaitytuvas.nextLine();
                String[] stulpeliai = eilute.split(",");
                Preke laikinaPreke = new Preke(Integer.parseInt(stulpeliai[0]), stulpeliai[1], stulpeliai[2], Double.parseDouble(stulpeliai[3]), Integer.parseInt(stulpeliai[4]), stulpeliai[5], stulpeliai[6]);
                prekes.add(laikinaPreke);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nėra tokio failo.");
        }
        return prekes;
    }

    public static void isvestiListaAtskiraiEilutemis(ArrayList<Preke> prekes) {
        for (Preke preke : prekes) {
            System.out.println("preke = " + preke);
        }
    }

    public static ArrayList<Preke> rastiPrekesSandelyje(ArrayList<Preke> visosPrekes) {
        ArrayList<Preke> esanciosPrekes = new ArrayList<>();
        for (Preke preke : visosPrekes) {
            if (preke.arYraSandelyje()) {
                esanciosPrekes.add(preke);
            }
        }
        return esanciosPrekes;
    }

    public static double prekiuKiekisSandelyje(List<Preke> prekes) {
        double kiekis = 0;
        for (Preke preke : prekes) {
            kiekis += preke.getKiekis();
        }
        return kiekis;
    }

    public static double brangiausiaPreke(List<Preke> prekes) {
        double laikinasMax = 0;
        for (Preke preke : prekes) {
            if (laikinasMax < preke.getKaina()) {
                laikinasMax = preke.getKaina();
            }
        }
        return laikinasMax;
    }

    public static ArrayList<Preke> brangiausiaPrekeSarase(List<Preke> prekes) {
        ArrayList<Preke> brangiausia = new ArrayList<>();
        for (Preke preke : prekes) {
            if (preke.getKaina() == brangiausiaPreke(prekes)) {
                brangiausia.add(preke);
            }
        }
        return brangiausia;
    }


    public static ArrayList<Preke> brangesnesUz600(List<Preke> prekes) {

        ArrayList<Preke> prekesKuriuKainaDidesneUz = new ArrayList<>();
        for (Preke preke : prekes) {
            if (preke.getKaina() > 600) {
                prekesKuriuKainaDidesneUz.add(preke);
            }
        }
        return prekesKuriuKainaDidesneUz;


    }

    public static double pritaikytiNuolaidaPrekemsBrangesnemsUz600(List<Preke> prekes) {

        double kaina = 0;
        for (Preke preke : prekes) {
            if (preke.getKaina() > 600) {
                preke.pritaikytiNuolaida(10);
            }
        }
        return kaina;
    }


    public static ArrayList<Preke> prekesPavavadinimuStalas(List<Preke> prekes) {
        ArrayList<Preke> prekesStalas = new ArrayList<>();
        for (Preke preke : prekes) {
            if (preke.getPavadinimas().equals("Stalas")) {
                prekesStalas.add(preke);
            }
        }
        return prekesStalas;
    }

    public static double pritaikytiNuolaidaPrekemsStalas(List<Preke> prekes) {

        double kaina = 0;
        for (Preke preke : prekes) {
            if (preke.getPavadinimas().equals("Stalas")) {
                preke.pritaikytiNuolaida(42.5);
            }
        }
        return kaina;
    }

    public static ArrayList<Preke> sarasasPagalKategorija(List<Preke> prekes) {
        ArrayList<Preke> kategorija = new ArrayList<>();
        for (Preke preke : prekes) {
            if (preke.getKategorija().equals("elektronika")) {
                kategorija.add(preke);
            }
        }
        return kategorija;
    }
}
