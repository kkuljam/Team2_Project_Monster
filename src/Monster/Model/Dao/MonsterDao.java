package Monster.Model.Dao;

import Monster.Controller.MonsterController;
import Monster.Model.Dto.MonsterDto;
import Monster.Model.Dto.EventDto;

import Monster.Model.Dto.MonsterListDto;

import java.util.ArrayList;
import java.util.Random;

public class MonsterDao extends Dao{
    //싱글톤
    private MonsterDao(){};// 생성자 : 객체 생성시 초기화 담당
    private static MonsterDao monsterDao=new MonsterDao();
    public static MonsterDao getInstance(){return monsterDao;}

    //===============================김민지===============================
    public boolean monsterExistence(int mno){// 몬스터 보유 여부 확인
        try {
            //1. SQL 작성
            String sql = "select mno from monster where mno = ?";
            //1. SQL 기재
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mno); // sql문법내 첫번째 ?에 mno 변수 값 대입
            //1. SQL 실행
            rs = ps.executeQuery(); //질의/검색(select) 결과를 rs 인터페이스에 대입한다
            //1. SQL 처리
            if (rs.next()) {  //rs.next() : 검색 결과 테이블에서 다음레코드 이동
                System.out.println("몬스터 있음");
                return false; //몬스터 있음
            }
        }catch (Exception e){
            System.out.println(e+"존재여부");
        }
        //5.함수종료
        return true; // 몬스터 없음
    }
    public boolean monsterRandom(String nM, int mno){// 몬스터 랜덤 생성 및 DB에 저장
        try {
            String sql="select stepno from monsterlist where stepno=1";
            //String sql="select count(*) from monsterlist where stepno=1";

            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            int a=0;
            while (rs.next()){// stepno의 1번의 개수만큼 a 증가
                a++;
            }
            System.out.println(a+"카운트 값");
            Random random=new Random(); // 난수 객체 생성
            int mRandom=random.nextInt(a);// 1부터 몬스터 진화 1단계 개수까지 랜덤
            if(mRandom==0){
                mRandom+=1;
            }else {
                mRandom=mRandom*3;
            }

            sql = "insert into monster(mno,lino, nickname)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            // ? 매개변수 대입
            ps.setInt(1,mno); //기재된 SQL내 첫번째 ?에 값 대입
            ps.setInt(2, mRandom); //기재된 SQL내 두번째 ?에 값 대입
            ps.setString(3,nM ); //기재된 SQL내 세

            int count = ps.executeUpdate(); //executeUpdate() 기재된sql 실행하고 insert된 레코드 개수 반환
            if (count == 1) {
                return true;
            }// 만약에 insert 처리된 레코드가 1개면 회원가입 성공


        }catch (Exception e){
            System.out.println(e+"생성");
        }
        return false;
    }

    public ArrayList<EventDto>eventPrint(EventDto eventDto){
        try {
            //1. SQL 작성
            String sql = "select eno,ename from event";
            //1. SQL 기재
            ps = conn.prepareStatement(sql);
            //1. SQL 실행
            rs = ps.executeQuery(); //질의/검색(select) 결과를 rs 인터페이스에 대입한다
            //1. SQL 처리
            ArrayList<EventDto> eventDtos = new ArrayList<>();
            while (rs.next()){
                EventDto eDto=new EventDto(
                        rs.getInt("eno"),
                        rs.getString("ename")
                );
                eventDtos.add(eDto);
            }
            return eventDtos;
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
    public String eventExecution(int ch){
        String[]stat=MonsterController.getInstance().stat;
        return null;

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




