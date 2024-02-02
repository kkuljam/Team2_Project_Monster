package Monster.Controller;

import Monster.Model.Dao.MonsterDao;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.EventDto;
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

    //===================김민지==========================
    //----- 몬스터 존재 확인 메소드
    public boolean monsterExistence(int mno){
         boolean result;
         result=MonsterDao.getInstance().monsterExistence(mno);
         return result;
    }
    //------- 몬스터 랜덤 메소드
    public boolean monsterRandom(String nM,int mno){
        boolean result=true;
        result=MonsterDao.getInstance().monsterRandom(nM,mno);
        return result;
    }
    //------ 이벤트 선택지 출력 메소드
    public ArrayList<EventDto>eventPrint(EventDto eventDto){
        ArrayList<EventDto>eDtos=MonsterDao.getInstance().eventPrint(eventDto);
        return eDtos;
    }
    public String eventExecution(int ch){
        String result = null;
        return result;
    }
    //==================================================
}

