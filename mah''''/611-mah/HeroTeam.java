package ttt;

public class HeroTeam extends Team{
    private Hero hero1=null;
    private Hero hero2=null;
    private Hero hero3=null;

    private int teamsize;

    public void initTeam(int i,Hero hero){
        if (i==1){
            hero1=hero;
        }else if (i==2){
            hero2=hero;
        }else {
            hero3=hero;
        }
    }
    public Hero getFirst(){
        return hero1;
    }
    public Hero getHero(int i){
        if (i==1){
            return hero1;
        }else if (i==2){
            return hero2;
        }else {
            return hero3;
        }
    }
    public int getTeamsize(){
        int n=0;
        if (hero1!=null){
            if (hero1.getHp()!=0){
                n=n+1;
            }
        }
        if (hero2!=null){
            if (hero2.getHp()!=0){
                n=n+1;
            }
        }
        if (hero3!=null){
            if (hero3.getHp()!=0){
                n=n+1;
            }
        }

        return n;
    }

    @Override
    public String toString() {
        return hero1+"\n"+hero2+"\n"+hero3;
    }
    public void check_big(){
        int check_bag=0;
        while (check_bag<this.getTeamsize()){
            this.getHero(check_bag+1).getBag();
            check_bag=check_bag+1;
        }
        System.out.println("do you want to equip hero(0-yes,1-no) ");
        Generalboardgame g =new Generalboardgame();
        int c=g.CheckSetUp(0,1);
        if (c!=1){
            System.out.println("which hero");
            System.out.println(this);
            int c1=g.CheckSetUp(1,this.getTeamsize());
            this.getHero(c1).getBag();

            this.getHero(c1).equip();

        }
    }
}
