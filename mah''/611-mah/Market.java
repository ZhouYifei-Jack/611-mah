package ttt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Market extends Pieces{
    public String getmahMarket(){
        return "M";
    }
    public void shopping() throws IOException {

        System.out.println("shopping");
        Grocery[] List = Filereader.ListOfGroceries();
        for (int i = 1; i <= List.length; i++) {
            System.out.print(i + ". ");
            if (List[i-1].getType().equals("Armory")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof Armory) {
                    Armory armory = (Armory) firstItem;
                    System.out.println(armory.getType()+": "+armory.getName()+" "+armory.getCost()+" "+armory.getRequiredLevel()+" "+armory.getDamageReduction());
                }
            }
            if (List[i-1].getType().equals("Weaponry")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof Weaponry) {
                    Weaponry a = (Weaponry) firstItem;
                    System.out.println(a.getType()+": "+a.getName()+" "+a.getCost()+" "+a.getRequiredLevel()+" "+a.getDamage()+" "+a.getRequiredHands());
                }
            }
            if (List[i-1].getType().equals("Potions")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof Potions) {
                    Potions a = (Potions) firstItem;
                    System.out.println(a.getType()+": "+a.getName()+" "+a.getCost()+" "+a.getRequiredLevel()+" "+a.getIncrease()+" "+a.getAffected());
                }
            }
            if (List[i-1].getType().equals("FireSpells")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof FireSpells) {
                    FireSpells a = (FireSpells) firstItem;
                    System.out.println(a.getType()+": "+a.getName()+" "+a.getCost()+" "+a.getRequiredLevel()+" "+a.getDamage()+" "+a.getManaCost());
                }
            }
            if (List[i-1].getType().equals("IceSpells")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof IceSpells) {
                    IceSpells a = (IceSpells) firstItem;
                    System.out.println(a.getType()+": "+a.getName()+" "+a.getCost()+" "+a.getRequiredLevel()+" "+a.getDamage()+" "+a.getManaCost());
                }
            }
            if (List[i-1].getType().equals("LightningSpells")){
                Grocery firstItem = List[i-1];
                if (firstItem instanceof LightningSpells) {
                    LightningSpells a = (LightningSpells) firstItem;
                    System.out.println(a.getType()+": "+a.getName()+" "+a.getCost()+" "+a.getRequiredLevel()+" "+a.getDamage()+" "+a.getManaCost());
                }
            }
        }
        System.out.println("Now pick a grocery,please:");



    }
}
