package Monster.Controller;

import Monster.Model.Dao.MemberDao;
import Monster.Model.Dto.MemberDto;
import Monster.View.MainView;

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


    int result = 0;
    //로그인
    public int login(MemberDto memberDto){


        int result1 = MemberDao.getInstance().loginId(memberDto);
        int result2 = MemberDao.getInstance().loginPw(memberDto);
        //System.out.println(result2);


        if(result1==1&&result2==1){
            result = 1; //로그인 성공
        }else if (result1 == 2){
            result = 2; //아이디틀림
        } else if (result2==2) {
            result = 3; //비밀번호 틀림
        }

        return result;

    }


}
