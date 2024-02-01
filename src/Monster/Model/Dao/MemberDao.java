package Monster.Model.Dao;

import Monster.Model.Dto.MemberDto;

public class MemberDao {
    //싱글톤
    private MemberDao(){};
    private static MemberDao memberDao = new MemberDao();
    public static MemberDao getInstance(){return memberDao;}

    //메소드
    //회원가입
    public boolean signup(MemberDto memberDto){
        System.out.println("회원가입");
        return true;
    }
}
