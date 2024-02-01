package Monster.Controller;

import Monster.Model.Dao.MonsterDao;

public class MonsterController {
    private MonsterController(){};
    private static MonsterController monsterController=new MonsterController();
    public static MonsterController getInstance(){return monsterController;}


   /* public boolean monsterExistence(int mno){
     boolean result=true;
     result=MonsterDao.getInstance().monsterExistence(mno);
     return result;
    }*/
}
