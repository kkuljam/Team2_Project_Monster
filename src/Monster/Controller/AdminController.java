package Monster.Controller;

import Monster.Model.Dao.AdminDao;
import Monster.Model.Dao.MemberDao;
import Monster.Model.Dto.MemberDto;
import Monster.View.AdminView;
import Monster.View.MemberView;

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


}
