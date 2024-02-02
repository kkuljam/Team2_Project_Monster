package Monster.Model.Dao;

import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.MonsterListDto;

import java.util.ArrayList;

public class MonsterDao extends Dao{
    //싱글톤
    private MonsterDao(){};// 생성자 : 객체 생성시 초기화 담당
    private static MonsterDao monsterDao=new MonsterDao();
    public static MonsterDao getInstance(){return monsterDao;}

    //===============================김민지===============================
    public boolean monsterExistence(int mno){// 몬스터 보유 여부 확인
        try {
            //1. SQL 작성
            String sql = "slesct mno form monster where mno = ?";
            //1. SQL 기재
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mno); // sql문법내 첫번째 ?에 mno 변수 값 대입
            //1. SQL 실행
            rs = ps.executeQuery(); //질의/검색(select) 결과를 rs 인터페이스에 대입한다
            //1. SQL 처리
            if (rs.next()) {  //rs.next() : 검색 결과 테이블에서 다음레코드 이동
                return false; //몬스터 있음
            }
        }catch (Exception e){
            System.out.println(e);
        }
        //5.함수종료
        return true; // 몬스터 없음
    }
    public void monsterRandom(String nM){
        int a=1;
        try {
            String sql="select stepno from monsterlist where stepno=1";
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            if(rs.next()){

            }
        }catch (Exception e){
            System.out.println(e+"몬스터 난수 오류");
        }

        ArrayList<MonsterListDto>monsterListDtos=new ArrayList<>();

    }
    //================================================================

    //===============================김건우===============================



        // 몬스터리스트 불러오기
        ArrayList<MonsterListDto> mlist = new ArrayList<>();

        public ArrayList<MonsterListDto> monsterList () {

            try {

                // 1. SQL 작성
                String sql = "select * from monsterlist";

                // 2. SQL 기재한다
                ps = conn.prepareStatement(sql);

                // 3. SQL 실행한다
                rs = ps.executeQuery();
                while (rs.next()) {
                    MonsterListDto monsterListDto = new MonsterListDto();
                    monsterListDto.setLino(rs.getInt("lino"));
                    monsterListDto.setStepno(rs.getInt("stepno"));
                    monsterListDto.setImg(rs.getString("img"));
                    monsterListDto.setIq(rs.getInt("iq"));
                    monsterListDto.setStrong(rs.getInt("strong"));
                    mlist.add(monsterListDto);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
            return mlist;
        }
        ArrayList<MonsterDto> mstat = new ArrayList<>();

        // 몬스터 테이블 불러오기
        public ArrayList<MonsterDto> monsterDtos () {


            try {

                // 1. SQL 작성
                String sql = "select * from monster";

                // 2. SQL 기재한다
                ps = conn.prepareStatement(sql);

                // 3. SQL 실행한다
                rs = ps.executeQuery();
                while (rs.next()) {
                    MonsterDto monsterDto = new MonsterDto();
                    monsterDto.setMno(rs.getInt("mno"));
                    monsterDto.setNickname(rs.getString("nickname"));
                    monsterDto.setLino(rs.getInt("lino"));
                    monsterDto.setHp(rs.getInt("hp"));
                    monsterDto.setStress(rs.getInt("stress"));
                    monsterDto.setIq(rs.getInt("iq"));
                    monsterDto.setStrong(rs.getInt("strong"));
                    mstat.add(monsterDto);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return mstat;
        }

        public boolean evolution () {
            while (true) {
                for (int i = 0 ; i < mlist.size() ; i++) {
                    for (int j = 0 ; j < mstat.size() ; j++){
                        if ( mlist.get(i).getLino() == mstat.get(j).getLino()){
                            if ( mlist.get(i).getIq() <= mstat.get(j).getIq() && mlist.get(i).getStrong() <= mstat.get(j).getStrong()){

                            }
                        }
                        }
                    }


                    }

                }


    
                
                
            }


    // if ( mlist.get(i).getIq() <= mstat.get(j).getIq() && mlist.get(i).getStrong() <= mstat.get(j).getStrong())
    //===============================김건우===============================




