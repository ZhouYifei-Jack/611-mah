package ttt;

import java.io.IOException;

public abstract class Hero extends Player{
    protected String Number;
    protected int mana;
    protected int strength;
    protected int agility;
    protected int dexterity;
    protected int starting_money;
    protected int starting_experience;
    protected String type;

    public Hero(String Name,int mana,int strength,int agility,int dexterity,int starting_money,int starting_experience) throws IOException {
        this.name=Name;
        this.mana=mana;
        this.strength=strength;
        this.agility=agility;
        this.dexterity=dexterity;
        this.starting_money=starting_money;
        this.starting_experience=starting_experience;

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

    public int getStarting_experience() {
        return starting_experience;
    }

    public void setStarting_experience(int starting_experience) {
        this.starting_experience = starting_experience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
