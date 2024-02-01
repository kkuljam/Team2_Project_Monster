package Monster.Model.Dao;

public class MonsterDao {
    //싱글톤
    private MonsterDao(){};
    private static MonsterDao monsterDao=new MonsterDao();
    public static MonsterDao getInstance(){return monsterDao;}
   /* public boolean monsterExistence(){
        try {
            //1. SQL 작성
            String sql = "slesct mno form monster where mno = ?";
            //1. SQL 기재
            ps = conn.prepareStatement(sql);
            ps.setString(1, mno); // sql문법내 첫번째 ?에 mno 변수 값 대입
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
        return true;
    }*/
}
