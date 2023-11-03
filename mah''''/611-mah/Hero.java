package ttt;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Player{
    protected String Number;
    protected int mana;
    protected int strength;
    protected int agility;
    protected int dexterity;
    protected int starting_money;
    protected int exp;
    protected String type;
    protected int level;
    protected int hp;



    protected boolean rightHand=false;
    protected boolean leftHand=false;
    protected boolean is_armory=false;
    private int damageReduction=0;
    private int damage=0;
    //private Grocery[] G ;
    //private int G_index;
    private List<Grocery>bag;
    private int bagCapacity=10;

    public Hero(String Name,int mana,int strength,int agility,int dexterity,int starting_money,int starting_experience) throws IOException {
        this.name=Name;
        this.mana=mana;
        this.strength=strength;
        this.agility=agility;
        this.dexterity=dexterity;
        //this.starting_money=starting_money;
        this.starting_money=10000;
        this.exp =starting_experience;
        this.level=1;
        this.hp=100;

        //G=new Grocery[10];
        //G_index=0;
        this.bag=new ArrayList<>();

        Pieces p=new Pieces();
        p.setPtest("H");
        this.set_pieces(p);
    }


    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStarting_money() {
        return starting_money;
    }

    public void setStarting_money(int starting_money) {
        this.starting_money = starting_money;
    }

    public int getExp() {
        return exp;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int updateEXP(int newEXP) {
        this.exp = newEXP;
        if (this.exp > (this.level * 10)) {
            this.levelUp();
        }
        return exp;
    }
    public void levelUp() {
        this.level += 1;
        this.exp = 0;
        this.hp = level * 100;
        this.mana *= 1.1;
        this.strength *= 1.05;
        this.agility *= 1.05;
        this.dexterity *= 1.05;
    }



    public int getLevel() {
        return level;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public void attacked(int s){
        if (s<=damageReduction){
            System.out.println("protected by armory,no damage");
        }else {
            int d=s-damageReduction;
            System.out.println("attacked,hp-"+d);
            this.setHp(this.getHp()-d);
        }
    }

    public boolean isRightHand() {
        return rightHand;
    }

    public void setRightHand(boolean rightHand) {
        this.rightHand = rightHand;
    }

    public boolean isLeftHand() {
        return leftHand;
    }

    public void setLeftHand(boolean leftHand) {
        this.leftHand = leftHand;
    }
    public void buygrocery(Grocery grocery){
        int cost=grocery.getCost();
        if (cost>getStarting_money()){
            System.out.println("can't buy");
        }else {
            if(bag.size()<this.bagCapacity){
                System.out.println("money before buying:"+getStarting_money());
                this.starting_money=this.getStarting_money()-cost;
                bag.add(grocery);

                String type=grocery.getType();
                if (type.equals("Armory")){
                    Armory a=(Armory) grocery;
                    System.out.println("buy a armory "+a.getDamageReduction());
                }else if (type.equals("Weaponry")){
                    Weaponry a=(Weaponry)grocery;
                    System.out.println("hands"+a.getRequiredHands());

                }else if (type.equals("Potions")){
                    Potions a=(Potions)grocery;
                    System.out.println("increase " +a.getIncrease());

                }else if (type.equals("FireSpells")){
                    FireSpells a=(FireSpells)grocery;
                    System.out.println("cost"+a.getManaCost());

                }else if (type.equals("IceSpells")){
                    IceSpells a=(IceSpells)grocery;
                    System.out.println("cost"+a.getManaCost());

                }else{
                    LightningSpells a=(LightningSpells)grocery;
                    System.out.println("cost"+a.getManaCost());

                }
                System.out.println(this.get_name()+" "+"money after buying:"+this.getStarting_money());


                //G[G_index]=grocery;
                //G_index=G_index+1;
            }else {
                System.out.println("bag has no room");
            }

        }
    }

    public void getBag(){
        System.out.println(this.name+"'s bag has:");
        int i=0;
        while (i<bag.size()){
            System.out.println(bag.get(i).getName()+" "+bag.get(i).getType());
            i++;
        }
    }
    public void equip(){
        System.out.println("ok");

    }
    public void equipArmory(Armory armory){
        if (!is_armory){
            if (armory.getRequiredLevel()>this.getLevel()){
                System.out.println("not satisfy level requirement");
            }else {
                this.damageReduction=armory.getDamageReduction();
                is_armory=true;
            }
        }else {
            System.out.println("already has armory,remove first");
        }


    }
    public void removeArmory(){
        if (!is_armory){
            System.out.println("no armory now");
        }else {
            System.out.println("move armory");
            damageReduction=0;
            is_armory=false;
        }
    }
    public int attack(){
        return strength+damage;
    }

    public void equipWeaponry(Weaponry weaponry){


    }
    public void removeWeapon(){
        if (!rightHand&&!leftHand){
            System.out.println("no weapon now");
        }else {
            System.out.println("move weapon");
            damage=0;
            rightHand=false;
            leftHand=false;
        }
    }

    @Override
    public String toString() {
        String a="";
        a=a+"Hero name:"+this.name+", mana:"+mana+", strength:"+strength+", agility:"+agility+" ,dexterity:"+dexterity+", money:"+starting_money+", experience:"+exp+", type:"+type;
        return a;
    }
}
