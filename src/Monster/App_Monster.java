package Monster;

import Monster.Controller.MonsterController;
import Monster.Model.Dao.MonsterDao;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.MonsterListDto;
import Monster.View.MainView;

import java.util.ArrayList;

public class App_Monster {
    public static void main(String[] args) {
        //===============================김건우===============================
        ArrayList<MonsterListDto> monsterList = new ArrayList<>();
        monsterList = MonsterController.getInstance().monsterList();
        ArrayList<MonsterDto> monsterDtos = new ArrayList<>();
        monsterDtos = MonsterController.getInstance().monsterDtos();
        /*int result = MonsterController.getInstance().findstepno(new MonsterListDto());
        System.out.println(result);*/

//        System.out.println(MonsterDao.getInstance().evolution()); // 진화함수 실행해보기
//        System.out.println(monsterList.get(0).getIq()); // 몬스터리스트테이블 첫레코드의 지능
//        System.out.println(monsterDtos.get(1).getIq()); // 몬스터테이블 첫레코드의 지능
        /*for (int i = 0; i < monsterList.size(); i++) {
            System.out.println(monsterList.get(i).getImg()); // 도감출력 해보기
        }*/
        //===============================김건우===============================

        // MonsterDao.getInstance().evolution();

        //메인화면 가져오기
        MainView.getInstance().mainView();

    }
}
