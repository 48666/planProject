import java.io.*;
import java.util.Arrays;


public class MainPlaneTest {
    public static void main(String[] args) {


        double[] a = new double[2];
        Plane cargoPlane = new CargoPlanes("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 200000);

        Plane amphibious = new Amphibious("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, true);

        Plane aerobaticPlane = new AerobaticPlane("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, true);

        Plane drone = new Drone("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 0, 50, false);

        Plane passangerJet = new PassangerJet("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, "buisness", 1000);

        Plane jumboPassagerJet = new JumboPassagerJet("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, "buisness", 2000, 2);

        Plane rocket = new Rocket("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 5);

        Plane helicopter = new Helicopter("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 799, "military", true);

        Plane militaryJets = new MilitaryJets("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, "bomby");

        Plane militaryTurboprops = new MilitaryTurboprops("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 3, 3000);

        Plane airShip = new AirShip("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, "CocaCola", 10000);

        Plane turboPropAircrafft = new TurboPropAircrafft("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 2);

        Plane airBaloon = new AirBaloon("model", a, 3.4, 2000, 700,
                "niewiem", 200, "spalinowy", 20000, 200, 3, 2000);
        Plane[] plasnes = {cargoPlane, amphibious, aerobaticPlane, drone,
                passangerJet, jumboPassagerJet, rocket, helicopter, militaryJets, militaryTurboprops, airShip, turboPropAircrafft, airBaloon};
        int countPlanes = plasnes.length;
//        save(plasnes);
        load(3);

    }

    private static void save(Plane[] planes) {
        String info = "";
        for (int i = 0; i < planes.length; i++) {
            info += planes[i].toString() + " \n";

        }
        writeIntoFile(info);

    }

    private static void writeIntoFile(String content) {
        try {

            FileWriter fileWriter = new FileWriter("/home/michalw/Documents/pjatk/PPJ/plane-project/src/planesInfo.txt", true);
            fileWriter.write(content);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
    }

    private static Plane[][] load(int countPlanes) {
        Plane [][] planes = new Plane[10][10];
        try {
            FileReader fr = new FileReader("/home/michalw/Documents/pjatk/PPJ/plane-project/src/planesInfo.txt");
            int ret = fr.read();
            int i = 0;
            while (ret != -1) {
                if (i++ % 2 == 0)
                    System.out.print((char) ret);
                ret= fr.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planes;
    }


}
class MakeCalculation{
    public double countDistance(Plane plane1){
        double[] pozycja1= plane1.getPozycja();
        double pulap1 = plane1.getPulapWMetrach();
         double [] radarLocalization = {0,0,0};

        double odleglosOdradaru = Math.sqrt(Math.pow(pozycja1[0]-radarLocalization[0],2)+
                Math.pow(pozycja1[1]-radarLocalization[1],2) + Math.pow(pulap1-radarLocalization[2],2));
        return odleglosOdradaru;
    }

}

class Plane {
    private String model;
    private double[] pozycja = new double[2];
    private double wektor;
    private double pulapWMetrach;
    private double predkosc;
    private String nazwaSilnika;
    private int liczbaMiejsc;
    private String naped;
    private double odlegloscLotu;
    private double predkowsWKm;
    private int liczbaSilnikow;

    public Plane(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow) {
        this.model = model;
        this.pozycja = pozycja;
        this.wektor = wektor;
        this.pulapWMetrach = pulapWMetrach;
        this.predkosc = predkosc;
        this.nazwaSilnika = nazwaSilnika;
        this.liczbaMiejsc = liczbaMiejsc;
        this.naped = naped;
        this.odlegloscLotu = odlegloscLotu;
        this.predkowsWKm = predkowsWKm;
        this.liczbaSilnikow = liczbaSilnikow;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double[] getPozycja() {
        return pozycja;
    }

    public void setPozycja(double[] pozycja) {
        this.pozycja = pozycja;
    }

    public double getWektor() {
        return wektor;
    }

    public void setWektor(double wektor) {
        this.wektor = wektor;
    }

    public double getPulapWMetrach() {
        return pulapWMetrach;
    }

    public void setPulapWMetrach(double pulapWMetrach) {
        this.pulapWMetrach = pulapWMetrach;
    }

    public double getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(double predkosc) {
        this.predkosc = predkosc;
    }

    public String getNazwaSilnika() {
        return nazwaSilnika;
    }

    public void setNazwaSilnika(String nazwaSilnika) {
        this.nazwaSilnika = nazwaSilnika;
    }

    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public String getNaped() {
        return naped;
    }

    public void setNaped(String naped) {
        this.naped = naped;
    }

    public double getOdlegloscLotu() {
        return odlegloscLotu;
    }

    public void setOdlegloscLotu(double odlegloscLotu) {
        this.odlegloscLotu = odlegloscLotu;
    }

    public double getPredkowsWKm() {
        return predkowsWKm;
    }

    public void setPredkowsWKm(double predkowsWKm) {
        this.predkowsWKm = predkowsWKm;
    }

    public int getLiczbaSilnikow() {
        return liczbaSilnikow;
    }

    public void setLiczbaSilnikow(int liczbaSilnikow) {
        this.liczbaSilnikow = liczbaSilnikow;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", pozycja=" + Arrays.toString(pozycja) +
                ", wektor=" + wektor +
                ", pulapWMetrach=" + pulapWMetrach +
                ", predkosc=" + predkosc +
                ", nazwaSilnika='" + nazwaSilnika + '\'' +
                ", liczbaMiejsc=" + liczbaMiejsc +
                ", naped='" + naped + '\'' +
                ", odlegloscLotu=" + odlegloscLotu +
                ", predkowsWKm=" + predkowsWKm +
                ", liczbaSilnikow=" + liczbaSilnikow +
                '}';
    }
}


class CargoPlanes extends Plane {
    private double wagaTransportu;

    public CargoPlanes(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, double wagaTransportu) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.wagaTransportu = wagaTransportu;
    }

    public double getWagaTransportu() {
        return wagaTransportu;
    }

    public void setWagaTransportu(double wagaTransportu) {
        this.wagaTransportu = wagaTransportu;
    }

    @Override
    public String toString() {
        return super.toString() + "CargoPlanes{" +
                "wagaTransportu=" + wagaTransportu +
                '}';
    }
}

class Amphibious extends Plane {
    private boolean czyLondujeNaLodzie;

    public Amphibious(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, boolean czyLondujeNaLodzie) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.czyLondujeNaLodzie = czyLondujeNaLodzie;
    }

    public boolean isCzyLondujeNaLodzie() {
        return czyLondujeNaLodzie;
    }

    public void setCzyLondujeNaLodzie(boolean czyLondujeNaLodzie) {
        this.czyLondujeNaLodzie = czyLondujeNaLodzie;
    }

    @Override
    public String toString() {
        return super.toString() + "Amphibious{" +
                "czyLondujeNaLodzie=" + czyLondujeNaLodzie +
                '}';
    }
}

class AerobaticPlane extends Plane {
    private boolean czyPolAkrobacyjny;

    public AerobaticPlane(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, boolean czyPolAkrobacyjny) {

        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.czyPolAkrobacyjny = czyPolAkrobacyjny;
    }

    public boolean isCzyPolAkrobacyjny() {
        return czyPolAkrobacyjny;
    }

    public void setCzyPolAkrobacyjny(boolean czyPolAkrobacyjny) {
        this.czyPolAkrobacyjny = czyPolAkrobacyjny;
    }

    @Override
    public String toString() {
        return super.toString() + "AerobaticPlane{" +
                "czyPolAkrobacyjny=" + czyPolAkrobacyjny +
                '}';
    }
}

class MilitaryJets extends Plane {
    private String rodzajBroni;

    public MilitaryJets(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, String rodzajBroni) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.rodzajBroni = rodzajBroni;
    }

    public String getRodzajBroni() {
        return rodzajBroni;
    }

    public void setRodzajBroni(String rodzajBroni) {
        this.rodzajBroni = rodzajBroni;
    }

    @Override
    public String toString() {
        return super.toString() + "MilitaryJets{" +
                "rodzajBroni='" + rodzajBroni + '\'' +
                '}';
    }
}

class PassangerJet extends Plane {
    private String ktoraKlasa;
    private int liczbaBagazy;

    public PassangerJet(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, String ktoraKlasa, int liczbaBagazy) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.ktoraKlasa = ktoraKlasa;
        this.liczbaBagazy = liczbaBagazy;
    }

    public String getKtoraKlasa() {
        return ktoraKlasa;
    }

    public void setKtoraKlasa(String ktoraKlasa) {
        this.ktoraKlasa = ktoraKlasa;
    }

    public int getLiczbaBagazy() {
        return liczbaBagazy;
    }

    public void setLiczbaBagazy(int liczbaBagazy) {
        this.liczbaBagazy = liczbaBagazy;
    }

    @Override
    public String toString() {
        return super.toString() + "PassangerJet{" +
                "ktoraKlasa='" + ktoraKlasa + '\'' +
                ", liczbaBagazy=" + liczbaBagazy +
                '}';
    }
}

class JumboPassagerJet extends PassangerJet {
    private int liczbaPieter;

    public JumboPassagerJet(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, String ktoraKlasa, int liczbaBagazy, int liczbaPieter) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow, ktoraKlasa, liczbaBagazy);
        this.liczbaPieter = liczbaPieter;
    }

    public int getLiczbaPieter() {
        return liczbaPieter;
    }

    public void setLiczbaPieter(int liczbaPieter) {
        this.liczbaPieter = liczbaPieter;
    }

    @Override
    public String toString() {
        return super.toString() + "JumboPassagerJet{" +
                "liczbaPieter=" + liczbaPieter +
                '}';
    }
}

class Helicopter extends Plane {
    private int szybkoscSmigla;
    private String rodzajHelikopteru;
    private boolean czyprywatny;

    public Helicopter(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int ploperRotationSpeed, String typeOfHelicopter, boolean isPrivate) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.szybkoscSmigla = ploperRotationSpeed;
        this.rodzajHelikopteru = typeOfHelicopter;
        this.czyprywatny = isPrivate;
    }

    public int getSzybkoscSmigla() {
        return szybkoscSmigla;
    }

    public void setSzybkoscSmigla(int szybkoscSmigla) {
        this.szybkoscSmigla = szybkoscSmigla;
    }

    public String getRodzajHelikopteru() {
        return rodzajHelikopteru;
    }

    public void setRodzajHelikopteru(String rodzajHelikopteru) {
        this.rodzajHelikopteru = rodzajHelikopteru;
    }

    public boolean isCzyprywatny() {
        return czyprywatny;
    }

    public void setCzyprywatny(boolean czyprywatny) {
        this.czyprywatny = czyprywatny;
    }

    @Override
    public String toString() {
        return super.toString() + "Helicopter{" +
                "szybkoscSmigla=" + szybkoscSmigla +
                ", rodzajHelikopteru='" + rodzajHelikopteru + '\'' +
                ", czyprywatny=" + czyprywatny +
                '}';
    }
}

class AirShip extends Plane {
    private String tekstNaBanerze;
    private double wagaBalonu;

    public AirShip(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, String tekstNaBanerze, double wagaBalonu) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
    }

    public String getTekstNaBanerze() {
        return tekstNaBanerze;
    }

    public void setTekstNaBanerze(String tekstNaBanerze) {
        this.tekstNaBanerze = tekstNaBanerze;
    }

    public double getWagaBalonu() {
        return wagaBalonu;
    }

    public void setWagaBalonu(double wagaBalonu) {
        this.wagaBalonu = wagaBalonu;
    }


    @Override
    public String toString() {
        return super.toString() + " AirShip{" +
                "tekstNaBanerze='" + tekstNaBanerze + '\'' +
                ", wagaBalonu=" + wagaBalonu +
                '}';
    }
}

class MilitaryTurboprops extends TurboPropAircrafft {
    private double wagaUzbrojenia;

    public MilitaryTurboprops(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int liczbaWiatrakow, double wagaUzbrojenia) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow, liczbaWiatrakow);
        this.wagaUzbrojenia = wagaUzbrojenia;
    }

    public double getWagaUzbrojenia() {
        return wagaUzbrojenia;
    }

    public void setWagaUzbrojenia(double wagaUzbrojenia) {
        this.wagaUzbrojenia = wagaUzbrojenia;
    }

    @Override
    public String toString() {
        return super.toString() + "MilitaryTurboprops{" +
                "wagaUzbrojenia=" + wagaUzbrojenia +
                '}';
    }
}

class TurboPropAircrafft extends Plane {
    private int liczbaWiatrakow;

    public TurboPropAircrafft(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int liczbaWiatrakow) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.liczbaWiatrakow = liczbaWiatrakow;
    }

    public int getLiczbaWiatrakow() {
        return liczbaWiatrakow;
    }

    public void setLiczbaWiatrakow(int liczbaWiatrakow) {
        this.liczbaWiatrakow = liczbaWiatrakow;
    }

    @Override
    public String toString() {
        return super.toString() + "TurboPropAircrafft{" +
                "liczbaWiatrakow=" + liczbaWiatrakow +
                '}';
    }
}

class Drone extends Plane {
    private int maksymalnyDystans;
    private boolean czyMaKamere;

    public Drone(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int maksymalnyDystans, boolean czyMaKamere) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.maksymalnyDystans = maksymalnyDystans;
        this.czyMaKamere = czyMaKamere;
    }

    public int getMaksymalnyDystans() {
        return maksymalnyDystans;
    }

    public void setMaksymalnyDystans(int maksymalnyDystans) {
        this.maksymalnyDystans = maksymalnyDystans;
    }

    public boolean isCzyMaKamere() {
        return czyMaKamere;
    }

    public void setCzyMaKamere(boolean czyMaKamere) {
        this.czyMaKamere = czyMaKamere;
    }

    @Override
    public String toString() {
        return super.toString() + "Drone{" +
                "maksymalnyDystans=" + maksymalnyDystans +
                ", czyMaKamere=" + czyMaKamere +
                '}';
    }
}

class Rocket extends Plane {
    private int liczbaCzlonow;


    public Rocket(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int liczbaCzlonow) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
    }

    public int getLiczbaCzlonow() {
        return liczbaCzlonow;
    }

    public void setLiczbaCzlonow(int liczbaCzlonow) {
        this.liczbaCzlonow = liczbaCzlonow;
    }

    @Override
    public String toString() {
        return super.toString() + "Rocket{" +
                "liczbaCzlonow=" + liczbaCzlonow +
                '}';
    }
}

class AirBaloon extends Plane {
    private int maksymalnaWysokosc;

    public AirBaloon(String model, double[] pozycja, double wektor, double pulapWMetrach, double predkosc, String nazwaSilnika, int liczbaMiejsc, String naped, double odlegloscLotu, double predkowsWKm, int liczbaSilnikow, int maksymalnaWysokosc) {
        super(model, pozycja, wektor, pulapWMetrach, predkosc, nazwaSilnika, liczbaMiejsc, naped, odlegloscLotu, predkowsWKm, liczbaSilnikow);
        this.maksymalnaWysokosc = maksymalnaWysokosc;
    }

    public int getMaksymalnaWysokosc() {
        return maksymalnaWysokosc;
    }

    public void setMaksymalnaWysokosc(int maksymalnaWysokosc) {
        this.maksymalnaWysokosc = maksymalnaWysokosc;
    }

    @Override
    public String toString() {
        return super.toString() + "AirBaloon{" +
                "maksymalnaWysokosc=" + maksymalnaWysokosc +
                '}';
    }
}