import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MonsterMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Monster> monsters = new ArrayList<>();


        do {
            System.out.println("Enter traits for Monster 1:");
            Monster monster1 = createMonster(scanner);

            System.out.println("Enter traits for Monster 2:");
            Monster monster2 = createMonster(scanner);

            Monster babyMonster=createBabyMonster(monster1,monster2);
            monsters.add(babyMonster);


            System.out.println("Do you want to create more monsters?(yes/no):");
        }while(scanner.next().equalsIgnoreCase("yes"));





        System.out.println("\n All created monsters:");
        for(Monster baby: monsters)
        {
            baby.displayTraits();
        }

    }

    private static Monster createMonster(Scanner scanner){
        System.out.println("Eye Color: ");
        String eyeColor= scanner.next();

        System.out.println("Fur Color: ");
        String furColor= scanner.next();

        System.out.println("Magical Ability: ");
        String magicalAbility= scanner.next();

        System.out.println("size: ");
        int size= scanner.nextInt();

        System.out.println("Strength: ");
        int strength= scanner.nextInt();

        System.out.println("Durability: ");
        int durability= scanner.nextInt();

        System.out.println("Weakness: ");
        String weakness= scanner.next();

        System.out.println("Aggression Level: ");
        int aggressionLevel= scanner.nextInt();

        return new Monster(eyeColor,furColor,magicalAbility,size,strength,durability,weakness,aggressionLevel);

    }

    private static Monster createBabyMonster(Monster parent1, Monster parent2) {
        Monster babyMonster = new Monster("", "", "", 0, 0, 0, "", 0);

        Random random = new Random();
        for (Field field : Monster.class.getDeclaredFields()) {
            if (random.nextBoolean()) {
                try {
                    field.set(babyMonster, field.get(parent1));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    field.set(babyMonster, field.get(parent2));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return babyMonster;
    }

    }

