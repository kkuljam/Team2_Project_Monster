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
            String sql="select * from member;";
            ps = conn.prepareStatement(sql);
            rs =    ps.executeQuery();

            ArrayList<MemberDto>memberDtos= new ArrayList<>();
            while(rs.next()){
                MemberDto dto= new MemberDto();
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
                dto.setMpw(rs.getString("mpw"));
                dto.setMphone(rs.getString("mphone"));
                dto.setMname(rs.getString("mname"));
                memberDtos.add(dto);
                System.out.println(memberDtos);
            }
            return memberDtos;

        }catch (Exception e){
            System.out.println(e);
        }
    return null;
    }
    public boolean memberChange(MemberDto memberDto){
        try {
            String sql= "update member set mid= ? ,mpw= ?,mphone= ?,mname= ? where mid= ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,memberDto.getMid());
            ps.setString(2,memberDto.getMid());
            ps.setString(3,memberDto.getMid());
            ps.setString(4,memberDto.getMid());
            ps.setInt(5,memberDto.getMno());


        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }


}
