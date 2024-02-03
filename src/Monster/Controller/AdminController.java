package Monster.Controller;

import Monster.Model.Dao.AdminDao;
import Monster.Model.Dto.MemberDto;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.MonsterListDto;

import java.util.ArrayList;

public class AdminController {
    private AdminController(){}
    private static AdminController adminController= new AdminController();

    public static  AdminController getInstance(){return adminController;}

    // 모든회원정보 출력
    public ArrayList<MemberDto>memberPrint(MemberDto memberDto){
        ArrayList<MemberDto> result = null;
        result = AdminDao.getInstance().MemberPrint(memberDto);
        return result;
    }
    // 정보 수정===============================================
    public boolean  memberChange(MemberDto memberDto){
        boolean result =false;
        result=AdminDao.getInstance().memberChange(memberDto);

        return result;
    }
    // 정보 삭제=====================================================
    public int  memberDelete(int mno){
        int result =0;
        result=AdminDao.getInstance().memberDelete(mno);

        return result;
    }
    public ArrayList<MonsterListDto>monsterListPrint(MonsterListDto monsterListDto){

        ArrayList<MonsterListDto>result= null;
        return null;
    }


}
