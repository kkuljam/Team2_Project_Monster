package Monster.Model.Dao;

import Monster.Model.Dto.MemberDto;

import java.util.ArrayList;

public class AdminDao extends Dao {
    private AdminDao(){}//생성자 : 객체 생성시 초기화 담당
    private static AdminDao adminDao = new AdminDao();
    public static AdminDao getInstance(){return adminDao;}

    //회원정보 불러오기
    public ArrayList<MemberDto> MemberPrint(MemberDto memberDto){
        try{
            String sql="select * from member order by mno";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

            ArrayList<MemberDto>memberDtos= new ArrayList<>();
            while(rs.next()){
                MemberDto dto= new MemberDto();
                rs.getInt("mno");
                rs.getString("mid");
                rs.getString("mpw");
                rs.getString("mphone");
                rs.getString("mname");
                memberDtos.add(dto);
            }
            return memberDtos;

        }catch (Exception e){
            System.out.println(e);
        }
    return null;
    }
}
