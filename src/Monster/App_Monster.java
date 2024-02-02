package Monster;

import Monster.Controller.MonsterController;
import Monster.Model.Dao.MonsterDao;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.MonsterListDto;
import Monster.View.MainView;

import java.util.ArrayList;

public class App_Monster {
    public static void main(String[] args) {
        ArrayList<MonsterListDto> monsterList = new ArrayList<>();
        monsterList = MonsterController.getInstance().monsterList();
        ArrayList<MonsterDto> monsterDtos = new ArrayList<>();
        monsterDtos = MonsterController.getInstance().monsterDtos();

        System.out.println(monsterList.get(0).getIq());
        System.out.println(monsterDtos.get(0).getIq());
        // MonsterDao.getInstance().evolution();

        //메인화면 가져오기
        MainView.getInstance().mainView();




    }
}
