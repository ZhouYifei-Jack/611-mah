package ttt;

public class Battle {
    private HeroTeam heroTeam;
    private Hero currentHero;
    private MonsterTeam monsterTeam;

    public void init(HeroTeam heroTeam){
        this.heroTeam=heroTeam;
        while (heroTeam.inBattle_leftHero()!=0){
            boolean isThisHeroAlive=false;
            while (!isThisHeroAlive){
                System.out.println("pick a hero ");
                Generalboardgame g =new Generalboardgame();
                int b_h=g.CheckSetUp(1,heroTeam.getTeamsize());
                isThisHeroAlive=heroTeam.inBattle_pickHero(b_h);
                if (isThisHeroAlive){
                    currentHero=heroTeam.getHero(b_h);
                }
            }





        }
        System.out.println("battle end");
    }
}
