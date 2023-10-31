package ttt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Filereader {
    public static String[] reader(String filename) throws IOException{

        BufferedReader txtreader=new BufferedReader(new FileReader(filename));
        ArrayList<String> arrayList=new ArrayList<>();
        String info_row;
        while ((info_row=txtreader.readLine())!=null){
            arrayList.add(info_row);
        }
        String[] result = new String[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        txtreader.close();
        return result;
    }
    public static Hero[] ListOfHeroes() throws IOException {
        String[] Warrior = reader("info/Warriors.txt");
        String[] Sorcerer = reader("info/Sorcerers.txt");
        String[] Paladin = reader("info/Paladins.txt");

        Hero[] hero = new Hero[Warrior.length + Sorcerer.length + Paladin.length-3 ];

        String[] splitRow;
        int Number = 0;
        for (int i = 1; i < Warrior.length; i++) {
            splitRow = Warrior[i].split("\\s+");
            hero[Number] = new Warrior(splitRow[0], Integer.parseInt(splitRow[1]), Integer.parseInt(splitRow[2]), Integer.parseInt(splitRow[3]), Integer.parseInt(splitRow[4]), Integer.parseInt(splitRow[5]), Integer.parseInt(splitRow[6]));
            Number++;
        }
        for (int i = 1; i < Sorcerer.length; i++) {
            //System.out.println(Sorcerer[i]);

            splitRow = Sorcerer[i].split("\\s+");
            hero[Number] = new Sorcerer(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]), Integer.valueOf(splitRow[5]), Integer.valueOf(splitRow[6]));
            Number++;
        }
        for (int i = 1; i < Paladin.length; i++) {
            splitRow = Paladin[i].split("\\s+");
            hero[Number] = new Paladin(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]), Integer.valueOf(splitRow[5]), Integer.valueOf(splitRow[6]));
            Number++;
        }
        return hero;
    }

    public static Hero[] ListOfGroceries() throws IOException {
        String[] ArmorArr = reader("info/Armory.txt");
        String[] WeaponArr = reader("info/Weaponry.txt");
        String[] PotionArr = reader("info/Potions.txt");
        String[] IceSpellArr =reader("info/IceSpells.txt");
        String[] FireSpellArr = reader("info/FireSpells.txt");
        String[] LightningSpellArr =reader("info/LightningSpells.txt");
        /*
        /
        Item[] itemArr = new Item[ArmorArr.length + WeaponArr.length + PotionArr.length + IceSpellArr.length + FireSpellArr.length + LightningSpellArr.length - 6];
        String[] splitRow;
        int resultIndex = 0;
        for (int i = 1; i < ArmorArr.length; i++) {
            splitRow = ArmorArr[i].split("\t");
            itemArr[resultIndex] = new Armor(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]));
            resultIndex++;
        }
        for (int i = 1; i < WeaponArr.length; i++) {
            splitRow = WeaponArr[i].split("\t");
            itemArr[resultIndex] = new Weapon(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]));
            resultIndex++;
        }
        for (int i = 1; i < PotionArr.length; i++) {
            splitRow = PotionArr[i].split("\t");
            itemArr[resultIndex] = new Potion(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), splitRow[4]);
            resultIndex++;
        }
        for (int i = 1; i < IceSpellArr.length; i++) {
            splitRow = IceSpellArr[i].split("\t");
            itemArr[resultIndex] = new IceSpell(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]));
            resultIndex++;
        }
        for (int i = 1; i < FireSpellArr.length; i++) {
            splitRow = FireSpellArr[i].split("\t");
            itemArr[resultIndex] = new FireSpell(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]));
            resultIndex++;
        }
        for (int i = 1; i < LightningSpellArr.length; i++) {
            splitRow = LightningSpellArr[i].split("\t");
            itemArr[resultIndex] = new LightningSpell(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]));
            resultIndex++;
        }
        return itemArr;
         */
        Hero[] hero = new Hero[Warrior.length + Sorcerer.length + Paladin.length-3 ];

        String[] splitRow;
        int Number = 0;
        for (int i = 1; i < Warrior.length; i++) {
            splitRow = Warrior[i].split("\\s+");
            hero[Number] = new Warrior(splitRow[0], Integer.parseInt(splitRow[1]), Integer.parseInt(splitRow[2]), Integer.parseInt(splitRow[3]), Integer.parseInt(splitRow[4]), Integer.parseInt(splitRow[5]), Integer.parseInt(splitRow[6]));
            Number++;
        }
        for (int i = 1; i < Sorcerer.length; i++) {
            //System.out.println(Sorcerer[i]);

            splitRow = Sorcerer[i].split("\\s+");
            hero[Number] = new Sorcerer(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]), Integer.valueOf(splitRow[5]), Integer.valueOf(splitRow[6]));
            Number++;
        }
        for (int i = 1; i < Paladin.length; i++) {
            splitRow = Paladin[i].split("\\s+");
            hero[Number] = new Paladin(splitRow[0], Integer.valueOf(splitRow[1]), Integer.valueOf(splitRow[2]), Integer.valueOf(splitRow[3]), Integer.valueOf(splitRow[4]), Integer.valueOf(splitRow[5]), Integer.valueOf(splitRow[6]));
            Number++;
        }
        return hero;
    }


}
