package com.company;

import java.util.Random;

public class Main {

    public static int[] heroesHealth = {250, 300, 270, 150, 470, 200, 250, 300};
    public static int[] heroesDamage = {20, 15, 25, 4, 10, 15, 20, 35};
    public static String[] heroesDAttackType = {"Psyhical", "Magical", "Kinetick", "Medic", "Tank", "Adroit", "Berserk", "Tor"};
    public static String bossDeffenceType = "";
    public static int bossHealth = 1000;
    public static int bossDamage = 55;

    public static void main(String[] args) {
        printStatistics();
        while (!isFinished()) {
            round();
        }


    }

    public static void tor() {
        Random r = new Random();
        int coef = r.nextInt(3);
        if (coef == 0) {
            bossDamage = bossDamage * coef;
            System.out.println("Босс оглушен");

        }
    }
        public static void berserk() {
            Random r = new Random();
            int coef = r.nextInt(55);
            heroesHealth[6]=bossDamage-coef;
            heroesDamage[6]=heroesDamage[6]+coef;

                System.out.println("возрат " +heroesDamage[6]);
    }
public static void tank(){
        Random random=new Random();
      int coef=  random.nextInt(55);
        heroesHealth[4]=bossDamage-coef;
    for (int i = 0; i <3 ; i++) {
        heroesHealth[i] = heroesHealth[i] + coef;
        System.out.println("принял урон " + coef );


        for (int j = 5; j < heroesHealth.length; j++) {
                heroesHealth[j] = heroesHealth[j] + coef;
                System.out.println("принял урон " + coef );

            }

        }
    }



    public static void adroit() {
        Random r = new Random();
        int coef = r.nextInt(3);
        if (coef == 0) {
            heroesHealth[5] =heroesHealth[5]- bossDamage * coef;
            System.out.println("ловкач увернулся");
        }else {
            System.out.println("ловкач не смог увернутся");
        }
    }
public static void medic() {
    for (int i = 0; i < heroesHealth.length; i++) {
        Random r = new Random();
        int hp = r.nextInt(10);
        int randomIndex = r.nextInt(heroesDAttackType.length);
        if ((heroesHealth[i] - bossDamage) < heroesHealth[i]) {
            heroesHealth[randomIndex] = heroesHealth[randomIndex] + (heroesDamage[3] +hp);
            System.out.println(heroesDAttackType[3] + " cured on: " + heroesDAttackType[randomIndex] + " " + heroesDamage[3] + hp);
        }
    }
}


    public static void changeBossDeffence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesDAttackType.length);
        bossDeffenceType = heroesDAttackType[randomIndex];
    }

    public static void round() {
        changeBossDeffence();
        heroesHit();
        medic();
        tank();
        adroit();
        tor();
        berserk();
        bossHit();
        printStatistics();

    }

    public static void printStatistics() {

        System.out.println("________________________");
        System.out.println("Boss Health " + bossHealth + " " + bossDeffenceType);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("warrior health " + heroesHealth[0]);
        System.out.println("magic health " + heroesHealth[1]);
        System.out.println("kinetic health " + heroesHealth[2]);
        System.out.println("medic health " + heroesHealth[3]);
        System.out.println("tank health " + heroesHealth[4]);
        System.out.println("adroit " + heroesHealth[5]);
        System.out.println("berserk " + heroesHealth[6]);
        System.out.println("tor " + heroesHealth[7]);

        System.out.println("___________________________");


    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++)
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossDeffenceType.equals(heroesDAttackType[i])) {
                    Random r = new Random();
                    int coef = r.nextInt(8) + 2;
                    if (bossHealth - heroesDamage[i] * coef < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coef;
                    }
                    System.out.println(heroesDAttackType[i] + " critically hit " + heroesDamage[i] * coef);
                } else {

                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;

                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;

                }

            }
        }
    }


    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("heroes won");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0 && heroesHealth[3] <= 0 && heroesHealth[4] <= 0 && heroesHealth[5]<=0&& heroesHealth[6] <= 0&& heroesHealth[7] <= 0) {
            System.out.println("Boss Won");

            return true;

        }


        return false;

    }


}
