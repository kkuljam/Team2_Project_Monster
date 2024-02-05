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
    //---몬스터 랜덤 생성 및 DB에 저장
    public boolean monsterRandom(String nM, int mno){
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
            int mRandom=random.nextInt(a);// 1부터 몬스터 진화 1단계 개수까지 랜덤 // 번호 랜덤 수정 필요함
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
    //--- 이벤트 목록 출력 메소드
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
    //---- 몬스터 정보 출력 메소드
    public MonsterDto monsterPrint(int mno){
        try {
            String sql="select nickname,lino,hp,stress,iq,strong from monster where  mno=? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            rs=ps.executeQuery();
            if(rs.next()){
                MonsterDto monsterDto1=new MonsterDto(
                        rs.getString("nickname"),
                        rs.getInt("lino"),
                        rs.getInt("hp"),
                        rs.getInt("stress"),
                        rs.getInt("iq"),
                        rs.getInt("strong")
                );
                return monsterDto1;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //----- 몬스터 현재 이미지 출력 메소드
    public String monsterImg(int level){
        try {
            String sql="select img from monsterlist where lino=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,level);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString("img");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    //-- 이벤트 실행 및 이미지 반환 메소드
    public String eventExecution(int ch, int mno){
        try {
            String[]stat=MonsterController.getInstance().stat;
            //1. 이벤트 숫자에 있는 업다운 숫자 불러와
            String sql="select statup,statdown,eimg from event where eno=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,ch);
            rs= ps.executeQuery();
            System.out.println("숫자 넣어서 이벤트 업다운 불러와");
            if(rs.next()) {
                int up = rs.getInt("statup");
                int down = rs.getInt("statdown");
                String eimg = rs.getString("eimg");

                //2. 숫자에 해당하는 인덱스 이름 가져와
                String upStat = stat[up-1];
                String downStat = stat[down-1];

                //3. 첫번째 이름 +난수 / but 만약 2번이면 부호 반대로
                int upR=(int) (Math.random() * 5) + 3;
                if(up==2){
                    upR*=-1;
                }
                System.out.println("올라갈 스탯 "+upStat+"숫자 "+upR);
                //4. 두번째 이름 -난수 / but 만약 2번이면 부호 반대로
                int downR=(int) (Math.random() * 3) + 1;
                if(down==2){
                    downR*=-1;
                }
                System.out.println("내려갈 스탯 "+downStat+"숫자 "+downR);

                //원본 숫자 불러와
                sql="select "+upStat+", "+downStat+" from monster where mno=?";
                ps= conn.prepareCall(sql);
                ps.setInt(1,mno);
                rs= ps.executeQuery();
                if(rs.next()){
                    upR+=rs.getInt(upStat);
                    downR+=rs.getInt(downStat);
                }
                System.out.println("원본숫자 불러와서 더했음");

                //5. 이름으로 검색해서 업데이트
                sql = "update monster set "+upStat+" = ? , "+downStat+" = ? where mno= ?";
                ps = conn.prepareStatement(sql);
                // ? 매개변수 대입
                ps.setInt(1, upR);   // 합친 숫자
                ps.setInt(2, downR); // 합친 숫자
                ps.setInt(3, mno);

                int count=ps.executeUpdate();
                if(count==1){
                    System.out.println(" 이벤트 이미지");
                    return eimg;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
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




