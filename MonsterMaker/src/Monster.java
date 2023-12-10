import java.lang.reflect.Field;
import java.util.*;

class Monster {
    String eyeColor;
    String furColor;
    String magicalAbility;
    int size;
    int strength;
    int durability;
    String weakness;
    int aggressionLevel;

    public Monster(String eyeColor,String furColor, String magicalAbility,int size, int strength,
                   int durability,String weakness, int aggressionLevel)
    {
        this.eyeColor=eyeColor;
        this.furColor=furColor;
        this.magicalAbility=magicalAbility;
        this.size=size;
        this.strength=strength;
        this.durability=durability;
        this.weakness=weakness;
        this.aggressionLevel=aggressionLevel;

    }

    public void copyTraitsFrom(Monster parent){
        try{
            for(Field field:Monster.class.getDeclaredFields()){
                field.set(this,field.get(parent));
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    public void displayTraits(){
        System.out.println("Eye Color :"+ eyeColor );
        System.out.println("Fur Color :"+furColor );
        System.out.println("Magical Ability:"+ magicalAbility );
        System.out.println("Size :"+ size);
        System.out.println("Strength :"+strength );
        System.out.println("Durability :"+ durability );
        System.out.println("Weakness :"+ weakness);
        System.out.println("Aggression Level :"+aggressionLevel );
        System.out.println();

    }

}
