import item.*
import jeu.Jeu
import personnage.Personnage

// Création des qualités des objets
val qualiteCommun = Qualite (
    "commun",
    0,
    "\u001B[32m"
)

val qualiteRare = Qualite (
    "rare",
    1,
    "\u001B[34m"
)

val qualiteEpic = Qualite (
    "epic",
    2,
    "\u001B[35m"
)

val qualiteLegendaire = Qualite (
    "legendaire",
    3,
    "\u001B[33m"
)

// Creation des types d'armures
val typeArmureRembourree = TypeArmure (
    "Armure Rembourrée",
    1
)

val typeArmureCuir = TypeArmure (
    "Armure En cuir",
    2
)

val typeArmureCuirCloute = TypeArmure (
    "Armure En cuir Clouté",
    3
)

val typeArmureChemiseAChaine = TypeArmure (
    "Chemise à Chaîne",
    4
)

val typeArmurePectoral = TypeArmure (
    "Pectoral",
    5
)

val typeArmureCotteDeMaille = TypeArmure(
    "Cotte de Maille",
    6
)

// Creation des types d'armes
val typesArmesDague = Types_armes (
    1,
    4,
    3,
    18
)

val typesArmesBaton = Types_armes (
    1,
    4,
    2,
    20,
)

val typesArmesLance = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesArbaleteLegere = Types_armes (
    1,
    8,
    2,
    19
)

val typesArmesEpeeCourte = Types_armes (
    1,
    6,
    2,
    19
)

val typesArmesHache = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesEpeeLongue = Types_armes (
    1,
    8,
    2,
    19
)

val typesArmesMarteau = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesArcLong = Types_armes (
    1,
    8,
    3,
    20
)


//TODO Sprint 2 : Création de sorts


fun main(args: Array<String>) {
    // Creation des armures
    val armure1 = Armure (
        "Armure en Cuir +2",
        "",
        typeArmureCuir,
        qualiteEpic
    )

    val armure2 = Armure (
        "Armure En Cuir Clouté +1",
        "",
        typeArmureCuirCloute,
        qualiteRare
    )

    //Creation des armes
    val arme1 = Arme (
        "Bâton + 2 ",
        "",
        typesArmesBaton,
        qualiteLegendaire
    )

    val arme2 = Arme (
        "Dague + 2 ",
        "",
        typesArmesDague,
        qualiteRare
    )
    val arme3 = Arme (
        "big bertha + 2 ",
        "",
        typesArmesEpeeLongue,
        qualiteRare
    )
    // Creation des bombes
    val gregois = Bombe (
        4,
        6,
        "Feu grégois",
        "Une flasque qui contient un liquide inflammable."
    )

    val flasque = Bombe (
        2,
        8,
        "Flasque d’acide",
        "Une flasque qui contient une puissante substance corrosive."
    )

    val grenade = Bombe (
        5,
        6,
        "Grenade",
        "Une contraption qui explose une fois lancée."
    )

    //Creation des potions
    val potionSoin = Potion (
        "potion de soins",
        20,
        "Une potion qui contient un liquide rouge."
    )

    val grandePotionSoins = Potion (
        "Grande potion de soins",
        30,
        "Une grande potion qui contient un liquide rouge"
    )

    //Creation des monstres
    val gobelin = Personnage(
        "Gobuta le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        armePrincipale = arme2,
        armurePrincipale = armure2,
    )

    val mimique = Personnage(
        "geraldine la mimique",
        pointDeVie = 58,
        pointDeVieMax = 58,
        attaque = 14,
        defense = 10,
        endurance = 9,
        vitesse = 12,
        armePrincipale = null,
        armurePrincipale = null
    )

    val oni = Personnage(
        "Lony l'oni",
        pointDeVie = 50,
        pointDeVieMax = 50,
        attaque = 19,
        defense = 16,
        endurance = 12,
        vitesse = 11,
        armePrincipale = arme3,
        armurePrincipale = armure2,
    )

    val dragon = Personnage(
        "lillie",
        pointDeVie = 95,
        pointDeVieMax = 95,
        attaque = 20,
        defense = 20,
        vitesse = 18,
        endurance = 20,
        armePrincipale = null,
        armurePrincipale = armure2,
    )

    val Cube_Gelatineux = Personnage(
        "Ghlub le cube gélatineux",
        pointDeVie = 84,
        pointDeVieMax = 84,
        attaque = 14,
        defense = 20,
        vitesse = 3,
        endurance = 6,
        armePrincipale = null,
        armurePrincipale = armure1,
    )

    val Grand_Dracosire_Diamantin = Personnage(
        "Angarster le Grand dracosire diamantin",
        pointDeVie = 57,
        pointDeVieMax = 57,
        attaque = 28,
        defense = 29,
        endurance = 24,
        vitesse = 30,
        armePrincipale = null,
        armurePrincipale = armure1,
    )

    val Farfadet = Personnage(
        "Danaé le Farfadet",
        pointDeVie = 18,
        pointDeVieMax = 18,
        attaque = 8,
        defense = 18,
        endurance = 12,
        vitesse = 18,
        armePrincipale = arme1,
        armurePrincipale = null,
    )

    //Ajout des monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf(gobelin, mimique, oni, dragon, Cube_Gelatineux, Grand_Dracosire_Diamantin,Farfadet))
    //Lancement du jeu
    jeu.lancerCombat()
}