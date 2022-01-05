import java.util.Scanner;

public class main {

    public static void affiche (Maladie[] maladie,int taille) {
        for (int i = 0; i < taille; i++) {
            System.out.println(maladie[i].getNom_maladie() + " : " + maladie[i].getcount());
        }
        int max = 0, min = 0, mil = 0;
        for (int i = 0; i < taille; i++) {
            if (maladie[i].getcount() > max) {
                max = maladie[i].getcount();
            }

            if (maladie[i].getcount() < min) {
                min = maladie[i].getcount();
            }
        }
        if (max == 0) {
            System.out.println("Vous ne souffre aucune de ses maladie apparement .");
        } else {
            mil = max / 2;
            System.out.println("Interesser Vous Aussi a ses maladie :");
            for (int i = 0; i < taille; i++) {
                if (maladie[i].getcount() >= mil) System.out.println(maladie[i].getNom_maladie() + " : " + maladie[i].getcount());
            }
            for (int i = 0; i < taille; i++) {
               if (max == maladie[i].getcount()) {

                System.out.println("Vous souvrez propablement de : " +maladie[i].getNom_maladie());
               }
            }



        }
    }

    public static void main(String[] args)
    {
        int paludisme=0 ,grippe=0,AVC=0,Hemoriode=0,InfectionUrinaire=0,diabete=0,Angine=0,Typhiode=0,Cancer=0,Leucemie=0 ;
        char reponse;

        Maladie[] Billan = new Maladie [10];
        Billan[0] = new Maladie("paludisme");
        Billan[1] = new Maladie("grippe");
        Billan[2] = new Maladie("AVC");
        Billan[3] = new Maladie("Hemoriode");
        Billan[4] = new Maladie("InfectionUrinaire");
        Billan[5] = new Maladie("diabete");
        Billan[6] = new Maladie("Angine");
        Billan[7] = new Maladie("Typhiode");
        Billan[8] = new Maladie("Cancer");
        Billan[9] = new Maladie("Leucemie=");


        boolean ok = false;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("AVEZ VOUS LES SYPTOMES SUIVANT : ");

        System.out.print("Les frissions");
        while(!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                Billan[0].setcount(paludisme);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else
            {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("La Fievre + Transpiration");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                grippe++;
                Billan[0].setcount(paludisme);
                Billan[1].setcount(grippe);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else
            {
              ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Douleur aux Muscles");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                grippe++;
                Billan[0].setcount(paludisme);
                Billan[1].setcount(grippe);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else
            {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print(" Chaire de poule");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                Billan[0].setcount(paludisme);
                ok = true;
            } else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Fatigue ");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                grippe++;
                InfectionUrinaire++;
                Cancer++;
                Billan[0].setcount(paludisme);
                Billan[1].setcount(grippe);
                Billan[4].setcount(InfectionUrinaire);
                Billan[8].setcount(Cancer);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Maux de Tete");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                grippe++;
                Billan[0].setcount(paludisme);
                Billan[1].setcount(grippe);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else
            {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Vomissement");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                paludisme++;
                Typhiode++;
                Billan[0].setcount(paludisme);
                Billan[7].setcount(Typhiode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Ecoulement Nassal");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o')
            {
                grippe++;
                Billan[1].setcount(grippe);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Trouble de la marcge, de la diction et comprehesion");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                AVC++;
                Billan[2].setcount(AVC);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Paralysie ou un engourdissement du visage");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                AVC++;
                Billan[2].setcount(AVC);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("perte de la voie(difficulter a parler");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                AVC++;
                Billan[2].setcount(AVC);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Confusion Mentale");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                AVC++;
                Billan[2].setcount(AVC);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Movement Occulaire Rapide");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                AVC++;
                Billan[2].setcount(AVC);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Chaleur au niveau du Rectum");
            while (!ok) {
                reponse = sc1.nextLine().charAt(0);
                if (reponse == 'o') {
                    Hemoriode++;
                    diabete++;
                    Billan[3].setcount(Hemoriode);
                    Billan[4].setcount(diabete);
                    ok = true;
                }
                else if ( reponse == 'n')
                {
                    ok = true;
                }
                else {
                    ok = false;
                    System.out.println("Viellez Ressayez !");
                }
            }
            ok =false;
        System.out.print("Chaleur en Position Assise");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Hemoriode++;
                Billan[3].setcount(Hemoriode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Saignements ");
        reponse = sc1.nextLine().charAt(0);
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Hemoriode++;
                Leucemie++;
                Billan[3].setcount(Hemoriode);
                Billan[9].setcount(Leucemie);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Demangement");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Hemoriode++;
                Billan[3].setcount(Hemoriode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Constipation");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Hemoriode++;
                Billan[3].setcount(Hemoriode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Envie Frequente d'uriner");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
               InfectionUrinaire++;
               Billan[4].setcount(InfectionUrinaire);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Douleur au niveau de la Vessie");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                InfectionUrinaire++;
                Billan[4].setcount(InfectionUrinaire);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Sensation de n'avior pas vide completement sa vessie");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                InfectionUrinaire++;
                Billan[4].setcount(InfectionUrinaire);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.print("Inconfort Physique");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                InfectionUrinaire++;
                Billan[4].setcount(InfectionUrinaire);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Urine Foncee");
        if (reponse == 'o')
            while (!ok) {
                reponse = sc1.nextLine().charAt(0);
                if (reponse == 'o') {
                    InfectionUrinaire++;
                    Billan[4].setcount(InfectionUrinaire);
                    ok = true;
                } else if (reponse == 'n') {
                    ok = true;
                } else {
                    ok = false;
                    System.out.println("Viellez Ressayez !");
                }
            }
        ok = false;
        System.out.print("Douleur au Niveau de l'abdomen");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                diabete++;
                Billan[5].setcount(diabete);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Crampes d'estomac");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                diabete++;
                Billan[5].setcount(diabete);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Selle Liquide");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                diabete++;
                Billan[5].setcount(diabete);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Flaturance");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                diabete++;
                Billan[5].setcount(diabete);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Deshyfratation");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                diabete++;
                Billan[5].setcount(diabete);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Douleur au Niveau de L'orielle");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Angine++;
                Billan[6].setcount(Angine);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Ganglions lymphatique sensibles");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Angine++;
                Billan[6].setcount(Angine);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Mauvaise Hailene");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Angine++;
                Billan[6].setcount(Angine);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("Ronfflement ou Salivation excessie");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Angine++;
                Billan[6].setcount(Angine);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.print("amygdales");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Angine++;
                Billan[6].setcount(Angine);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok =false;
        System.out.println("Naussees");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Typhiode++;
                Billan[7].setcount(Typhiode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
       ok =false;
        System.out.println("Perte D'appetit");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Typhiode++;
                Billan[7].setcount(Typhiode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Fiablesse Musculaire");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Typhiode++;
                Billan[7].setcount(Typhiode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
       ok = false;
        System.out.println("Douleur Abdominale");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Typhiode++;
                Billan[7].setcount(Typhiode);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Sweurs nocturnes");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Cancer++;
                Billan[8].setcount(Cancer);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Fievre Inexpliauer");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Cancer++;
                Billan[8].setcount(Cancer);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Perte de poids INexpliquer");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Cancer++;
                Billan[8].setcount(Cancer);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Presence de Grosseur anormale");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Cancer++;
                Billan[8].setcount(Cancer);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Douleur au Articulation");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Leucemie++;
                Billan[9].setcount(Leucemie);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Ganglions lymphatiques enfles");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Leucemie++;
                Billan[9].setcount(Leucemie);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Perte de poids incontroller");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Leucemie++;
                Billan[9].setcount(Leucemie);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }
        ok = false;
        System.out.println("Taches Rouges sur la Peau");
        while (!ok) {
            reponse = sc1.nextLine().charAt(0);
            if (reponse == 'o') {
                Leucemie++;
                Billan[9].setcount(Leucemie);
                ok = true;
            }
            else if ( reponse == 'n')
            {
                ok = true;
            }
            else {
                ok = false;
                System.out.println("Viellez Ressayez !");
            }
        }

    int taille = Billan.length;
       affiche(Billan,taille);


    }
}
