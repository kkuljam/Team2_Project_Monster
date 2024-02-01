package Monster.Controller;

import Monster.Model.Dao.MemberDao;
import Monster.Model.Dto.MemberDto;

public class MemberController {
    //싱글톤
    private MemberController(){}
    private static MemberController memberController = new MemberController();
    public static MemberController getInstance(){return memberController;}

    //메소드
    //회원가입
    public boolean signup(MemberDto memberDto){
        boolean result = MemberDao.getInstance().signup(memberDto);
        return result;
    }

}
