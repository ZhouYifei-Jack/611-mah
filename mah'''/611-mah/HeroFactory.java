package ttt;

import java.io.IOException;

public class HeroFactory {
    public Hero makeHero(String type,String Name,int mana,int strength,int agility,int dexterity,int starting_money,int starting_experience) throws IOException {
        if (type.equals("Warrior")){
            return new Warrior(Name,mana,strength,agility,dexterity,starting_money,starting_experience);
        }else if (type.equals("Sorcerer")){
            return new Sorcerer(Name,mana,strength,agility,dexterity,starting_money,starting_experience);
        }else {
            return new Paladin(Name,mana,strength,agility,dexterity,starting_money,starting_experience);
        }
    }
}
