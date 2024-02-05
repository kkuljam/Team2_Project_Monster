package Monster.Model.Dao;

import Monster.Model.Dto.MemberDto;
import Monster.Model.Dto.MonsterListDto;

import java.util.ArrayList;

public class AdminDao extends Dao {
    private AdminDao() {
    }//생성자 : 객체 생성시 초기화 담당

    private static AdminDao adminDao = new AdminDao();

    public static AdminDao getInstance() {
        return adminDao;
    }

    //회원정보 출력
    public ArrayList<MemberDto> MemberPrint(MemberDto memberDto) {
        try {
            String sql = "select * from member;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<MemberDto> memberDtos = new ArrayList<>();
            while (rs.next()) {
                MemberDto dto = new MemberDto();
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
                dto.setMpw(rs.getString("mpw"));
                dto.setMphone(rs.getString("mphone"));
                dto.setMname(rs.getString("mname"));
                memberDtos.add(dto);
                System.out.println(memberDtos);
            }
            return memberDtos;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // 정보 수정===============================================
    public boolean memberChange(MemberDto memberDto) {
        try {
            String sql = "update member set mid= ? ,mpw= ?,mphone= ?,mname= ? where mno= ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpw());
            ps.setString(3, memberDto.getMphone());
            ps.setString(4, memberDto.getMname());
            ps.setInt(5, memberDto.getMno());
            int count = ps.executeUpdate();

            if (count == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 정보 삭제=====================================================
    public int memberDelete(int mno) {
        try {
            String sql = "delete from member where mno= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            int count = ps.executeUpdate();
            if (count == 1) {
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // 몬스터리스트 출력========================================
    public ArrayList<MonsterListDto> monsterListPrint(MonsterListDto monsterListDto) {
        try {
            String sql = "select * from monsterlist";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<MonsterListDto> monsterListDtos = new ArrayList<>();
            while (rs.next()) {
                MonsterListDto dto = new MonsterListDto();
                dto.setLino(rs.getInt("lino"));
                dto.setStepno(rs.getInt("stepno"));
                dto.setIq(rs.getInt("iq"));
                dto.setStrong(rs.getInt("strong"));
                monsterListDtos.add(dto);
            }
            return monsterListDtos;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //몬스터리스트 수정
    public boolean monsterUpdate(MonsterListDto monsterListDto) {
        try {
            String sql = "update monsterlist set img= ?, iq =? ,strong= ? where lino=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, monsterListDto.getImg());
            ps.setInt(2, monsterListDto.getIq());
            ps.setInt(3, monsterListDto.getStrong());
            ps.setInt(4, monsterListDto.getLino());
            int count = ps.executeUpdate();

            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    //몬스터 리스트에서 삭제
    public boolean monsterDelete(MonsterListDto monsterListDto){
        try {
            String sql = "delete from monsterlist where lino=?";
            ps = conn.prepareStatement(sql);
            int count =0;
            if(monsterListDto.getLino()%3==1){
                for(int i=0;i<3;i++) {
                    ps.setInt(1, monsterListDto.getLino()+i);
                    count = ps.executeUpdate();
                }
            }else if(monsterListDto.getLino()%3==2){
                for(int i=-1;i<2;i++) {
                    ps.setInt(1, monsterListDto.getLino()+i);
                    count = ps.executeUpdate();
                }
            }else if(monsterListDto.getLino()%3==0){
                for(int i=-2;i<1;i++) {
                    ps.setInt(1, monsterListDto.getLino()+i);
                    count = ps.executeUpdate();
                }
            }
            if(count==1) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }



}
