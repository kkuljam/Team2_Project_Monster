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
    public int signup(MemberDto memberDto){
        int result = 0;

        if(MemberDao.getInstance().idCheck(memberDto.getMid())){
            return 1;
        }

        result = MemberDao.getInstance().signup(memberDto);
        return result;
    }
}
