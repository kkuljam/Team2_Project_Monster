package Monster.Model.Dao;

import Monster.Model.Dto.MemberDto;

public class MemberDao extends Dao{
    //싱글톤
    private MemberDao(){};
    private static MemberDao memberDao = new MemberDao();
    public static MemberDao getInstance(){return memberDao;}

    //메소드
    //회원가입
    public int signup(MemberDto memberDto){

        try {
            //sql 작성
            String sql = "insert into member values(0,?,?,?,?)";

            //sql에 기재
            ps=conn.prepareStatement(sql);

            //?매개변수 대입
            ps.setString(1,memberDto.getMid());
            ps.setString(2,memberDto.getMpw());
            ps.setString(3,memberDto.getMphone());
            ps.setString(4,memberDto.getMname());

            //sql실행
            int count = ps.executeUpdate();
            //sql 결과
            if(count==1){
                return 0;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return 1;
    }//m e

    //회원가입시 아이디중복검사
    public boolean idCheck(String mid){
        try{
            //sql 작성
            String sql = "select mid from member where mid = ?";

            //sql에 기재
            ps = conn.prepareStatement(sql);

            //?매개변수대입
            ps.setString(1, mid);

            //sql실행
            rs = ps.executeQuery();

            //중복확인
            if(rs.next()){
                return true; //중복 있음
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false; //중복없음
    }

    int no ;
    //로그인 아이디 유효성 검사
    public int loginId(MemberDto memberDto){
        try {
            //sql작성
            String sql = "select * from member where mid = ?";
            //sql기재
            ps = conn.prepareStatement(sql);
            //?매개변수대입
            ps.setString(1,memberDto.getMid());

            //sql 실행
            rs= ps.executeQuery();



            //sql처리
            if (rs.next()){
                //비밀번호 유효성 검사를 위한 mno저장
                no = rs.getInt(1);
                //System.out.println(no);

                return 1;// 아이디 동일
            }


        }catch (Exception e){
            System.out.println(e);
        }
        return 2; // 아이디 틀림
    }



    //로그인 비밀번호 유효성검사
    public int loginPw(MemberDto memberDto){
        try {
            //sql작성
            String sql = "select * from member where mpw = ?";
            //sql기재
            ps = conn.prepareStatement(sql);
            //?매개변수대입
            ps.setString(1,memberDto.getMpw());

            //sql 실행
            rs = ps.executeQuery();

            //sql처리
            if (rs.next()){
                if(no==rs.getInt(1)) {
                    return 1;// 비밀번호 동일

                }
            }
            //System.out.println(rs.getInt(1));


        }catch (Exception e){
            System.out.println(e);
        }
        return 2; // 비밀번호 틀림
    }




}//c e
