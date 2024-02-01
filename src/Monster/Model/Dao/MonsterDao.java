package Monster.Model.Dao;

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
    public boolean monsterRandom(String nM, int mno){
        try {
            String sql="select count from monsterlist where stapno=1";
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            int a=rs.getRow();

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
    //================================================================

    // 몬스터리스트 뽑아오기
    public ArrayList<MonsterListDto> monsterList() {
        ArrayList<MonsterListDto> result = new ArrayList<>();
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
                result.add(monsterListDto);
            }


        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
