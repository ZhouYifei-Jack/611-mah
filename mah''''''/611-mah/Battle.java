package ttt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    private HeroTeam heroTeam;
    private Hero currentHero;
    private Monster currentMonster;
    private MonsterTeam monsterTeam;
    private boolean finish=false;

    public void init(HeroTeam heroTeam) throws IOException {
        this.heroTeam=heroTeam;
        this.heroTeam.prepareBattle();


        int c_team_hero=heroTeam.getTeamsize();

        System.out.println("You will fight " + c_team_hero + "  monsters.");
        int c_monster_round=1;
        System.out.println("random create monster...please wait:");
        System.out.println();

        Monster[] MonsterList = Filereader.ListOfMonsters();
        System.out.println("   Name/level/damage/defense/dodge chance/Type");
        for (int i = 1; i <= MonsterList.length; i++) {
            System.out.print(i + ". ");
            System.out.println(MonsterList[i-1]);
        }
        System.out.println(" ");
        System.out.println("random create monster...please wait:");

        List avoid_repeat=new ArrayList();
        this.monsterTeam=new MonsterTeam();
        while (c_monster_round<=c_team_hero){
            Random rand = new Random();
            int min = 1;
            int max = MonsterList.length;
            int c_h= rand.nextInt((max - min) + 1) + min;


            if (avoid_repeat.contains(c_h)){
                System.out.println("wait");
            }else {
                avoid_repeat.add(c_h);
                HeroFactory heroFactory=new HeroFactory();
                Monster monster=heroFactory.makemonster(MonsterList[c_h-1].getType(),MonsterList[c_h-1].getName(),MonsterList[c_h-1].getLevel(),MonsterList[c_h-1].getDamage(),MonsterList[c_h-1].getDefense(),MonsterList[c_h-1].getDodgechance());

                monsterTeam.initTeam(c_monster_round,monster);
                c_monster_round=c_monster_round+1;

            }

        }


        System.out.println("Monster team information:");
        System.out.println(monsterTeam);

        pk();
    }


    public void pk(){
        while (heroTeam.inBattle_leftHero()!=0&!finish){
            boolean isThisHeroAlive=false;
            while (!isThisHeroAlive){
                System.out.println(" ");
                System.out.println("pick a hero ");
                System.out.println(heroTeam);
                Generalboardgame g =new Generalboardgame();
                int b_h=g.CheckSetUp(1,heroTeam.getTeamsize());
                isThisHeroAlive=heroTeam.inBattle_pickHero(b_h);
                if (isThisHeroAlive){
                    currentHero=heroTeam.getHero(b_h);
                }
            }
            System.out.println(currentHero);



            boolean isThisMAlive=false;
            while (!isThisMAlive){
                System.out.println("attack which monster");
                System.out.println(monsterTeam);
                Generalboardgame g =new Generalboardgame();
                int b_h=g.CheckSetUp(1,heroTeam.getTeamsize());
                isThisMAlive=monsterTeam.inBattle_pickMonster(b_h);
                if (isThisMAlive){
                    currentMonster=monsterTeam.getMonster(b_h);
                }
            }
            currentMonster.attacked(currentHero.attack());


            System.out.println(monsterTeam);

            if(monsterTeam.inBattle_leftMonster()==0){
                System.out.println("heroes win");
                finish=true;

            }else {
                currentMonster=monsterTeam.randompickmonster();
                System.out.println(" ");
                System.out.println(currentMonster.getName()+" now attack");
                currentHero.attacked(currentMonster.attack());
                //monsterTeam.getMonster(i).attack();
                if(heroTeam.inBattle_leftHero()==0){
                    System.out.println("monsters win");
                }


            }





        }
        System.out.println("battle end");
    }
}
