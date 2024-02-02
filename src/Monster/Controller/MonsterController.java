package Monster.Controller;

import Monster.Model.Dao.MonsterDao;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.MonsterListDto;

import java.util.ArrayList;


public class MonsterController {
    private MonsterController() {
    }

    ;
    private static MonsterController monsterController = new MonsterController();

    public static MonsterController getInstance() {
        return monsterController;
    }


    //===============================김건우===============================
    public ArrayList<MonsterListDto> monsterList(){
        ArrayList<MonsterListDto> result = new ArrayList<>();
        result = MonsterDao.getInstance().monsterList();
        return result;
    }

    public ArrayList<MonsterDto> monsterDtos(){
        ArrayList<MonsterDto> result = new ArrayList<>();
        result = MonsterDao.getInstance().monsterDtos();
        return result;
    }
    //===============================김건우===============================


    public boolean monsterExistence(int mno){// 몬스터 존재 확인 메소드
     boolean result=true;
     result=MonsterDao.getInstance().monsterExistence(mno);
     return result;
    }
    //========= 몬스터 랜덤
    public void monsterRandom(String nM){

    }
}

