import java.util.Scanner;

public class testcovid {
    void affiche() {

        Scanner scan = new Scanner(System.in);
        String symptome1 = " ", symptome2 = " ", reponse = " ";

        System.out.println("\nQuestionnaire des symptômes COVID-19\n\n \n");
        System.out.println("\n UN SEUL DES SYMPTÔMES SUIVANTS JUSTIFIE UN RETRAIT IMMÉDIAT DU TRAVAIL \n\n");
        System.out.println(
                "\n Avez-vous la sensation d’être fiévreux, d’avoir des frissons comme lors d’une grippe, ou une fièvre mesurée avec une température\n prise par la bouche égale ou supérieure à 38,1 °C (100,6 °F)? \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome1 = symptome1 + 1;
        }
        System.out.println(
                "\n Avez-vous une perte soudaine de l’odorat sans congestion nasale (nez bouché), avec ou sans perte de goût? \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome1 = symptome1 + 1;
        }
        System.out.println("\n Avez-vous une toux récente ou une toux chronique aggravée depuis peu? \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome1 = symptome1 + 1;
        }
        System.out.println("\n Avez-vous de la difficulté à respirer ou êtes-vous essoufflé? \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome1 = symptome1 + 1;
        }
        System.out.println("\n Avez-vous un mal de gorge? \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome1 = symptome1 + 1;
        }
        System.out.println(
                "\n\n UNE RÉPONSE « OUI » À AU MOINS DEUX DES SYMPTÔMES SUIVANTS JUSTIFIE UN RETRAIT IMMÉDIAT DU TRAVAIL \n \n");
        System.out.println("\n Mal de ventre \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Nausées (maux de cœur) ou vomissements \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Diarrhée \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Nez qui coule ou congestion nasale (nez bouché) de cause inconnue \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Fatigue intense inhabituelle sans raison évidente \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Perte d’appétit importante \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println(
                "\n Douleurs musculaires généralisées ou courbatures inhabituelles (non liées à un effort physique) \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n Mal de tête inhabituel \n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            symptome2 = symptome2 + 1;
        }
        System.out.println("\n\n EXPLICATIONS \n\n");
        System.out.println(" Fièvre : \n");
        System.out.println(
                " Une fièvre intermittente, c’est-à-dire, qui part et revient, répond également à ce critère. Une mesure unique de la température égale \nou supérieure à 38,1 °C prise à la bouche répond également à ce critère1.\n");
        System.out.println("\n De la toux : \n");
        System.out.println(
                " De rares personnes, par exemple les fumeurs chroniques, peuvent présenter de la toux sur une base régulière. \nUne toux habituelle ne répond pas à ce critère, mais toute modification de la toux, par exemple son augmentation en fréquence ou l’apparition de crachats, répond à ce critère. \n");
        System.out.println("\n De la difficulté à respirer : \n");
        System.out.println(
                " Certaines personnes, par exemple les asthmatiques, peuvent avoir des raisons propres à leur condition et non liées \nà la COVID-19 qui expliquent leurs difficultés à respirer. Toute difficulté à respirer autre que celles qui ont des causes évidentes autres répond à ce critère. \n");
        System.out.println("\n Perte soudaine de l’odorat : \n");
        System.out.println(
                " Une perte soudaine d’odorat sans congestion nasale avec ou sans perte du goût répond à ce critère qu’elle soit isolée \nou combinée à d’autres symptômes.\n");

        System.out.println(
                "\n\nQuel est le test adapté à ma situation\nEn quelques clics, découvrez quel test de dépistage est le plus adapté à votre situation.\n\n");

        System.out.println("\nAvez-vous des symptômes qui peuvent évoquer la Covid? :  (o) pour oui | (n) pour non\n");
        reponse = scan.nextLine();
        if (reponse == "o") {
            System.out.println(
                    "Depuis quand avez-vous des symptômes? : \n Depuis 5 jours ou plus 'o' pour oui ou 'n' pour non \n");
            if (reponse == "o") {
                System.out.println(
                        "\nVous avez des symptômes qui peuvent évoquer la Covid depuis plus de 4 jours, nous vous recommandons de faire un test PCR nasopharyngé.\n Consultez notre page thématique « J'ai des symptômes de la Covid, que faire? »{https://mesconseilscovid.sante.gouv.fr/j-ai-des-symptomes-covid.html}.\n");
            } else {
                System.out.println(
                        "\nVous avez des symptômes qui peuvent évoquer la Covid depuis moins de 4 jours, nous vous recommandons de faire un test antigénique \nou PCR nasopharyngé. Consultez notre page thématique « J'ai des symptômes de la Covid, que faire? »{https://mesconseilscovid.sante.gouv.fr/j-ai-des-symptomes-covid.html}.\n");
            }
        } else {
            System.out.println("\nÊtes-vous cas contact?  : 'o' pour oui ou 'n' pour non ");
            if (reponse == "o") {
                System.out.println(
                        "\nVous n’avez pas de symptômes qui peuvent évoquer la Covid mais vous êtes cas contact, nous vous recommandons de faire un test antigénique\n si vous venez de l’apprendre.");
                System.out.println(
                        "Pour un test de contrôle (7 jours après votre contact à risque ), les tests antigénique ou PCR nasopharyngé sont indiqués. \nConsultez notre page thématique « Je suis cas contact Covid, que faire? »{https://mesconseilscovid.sante.gouv.fr/cas-contact-a-risque.html}.\n");
            } else {
                System.out.println("\nJe veux faire un test pour… // 'o' pour oui ou 'n' pour non \n");
                if (reponse == "o") {
                    System.out.println(
                            "\nVous n’avez pas de symptômes qui peuvent évoquer la Covid, vous n’êtes pas cas contact mais votre autotest est positif.\n Vous devez confirmer ce résultat avec un test PCR nasopharyngé et rester en isolement le temps d’obtenir cette confirmation. \nrecommencer le questionnaire");
                } else {
                    System.out.println(
                            "\nVous n’avez pas de symptômes qui peuvent évoquer la Covid et vous n’êtes pas cas contact :");
                    System.out.println(
                            "Si vous souhaitez obtenir un « pass sanitaire »{https://mesconseilscovid.sante.gouv.fr/pass-sanitaire-qr-code-voyages.html}, \nun test négatif PCR nasopharyngé ou antigénique, réalisé il y a moins de 24h est nécessaire.");
                    System.out.println(
                            "Si vous rendez visite à des personnes vulnérables, un test antigénique ou PCR nasopharyngé est indiqué.");
                    System.out.println(
                            "Si vous travaillez régulièrement avec des personnes fragiles, il est recommandé de vous tester régulièrement avec les autotests vendus \nen pharmacie (les professionnels exerçant à domicile auprès de personnes vulnérables peuvent obtenir la prise en charge de 10 autotests par mois en présentant leur carte professionnelle au pharmacien). \n");
                    System.out.println("\n recommencer le questionnaire\n");
                }
            }
        }

        System.out.println("\nOù puis-je faire un test de dépistage Covid-19? \n");
        System.out.println(
                "\n Cliquez ici pour trouver un lieu de dépistage{https://www.sante.fr/cf/centres-depistage-covid.html}  au plus proche de vous.\n");

        System.out.println(
                "\nJe souhaite me faire dépister mais les prélèvements nasopharyngés sont impossibles dans mon cas \n");
        System.out.println(
                "\n Le test PCR salivaire est indiqué dans ces cas : enfant en bas âge, personnes présentant des troubles psychiatriques, déviation de la cloison nasale…\n");
    }
}
