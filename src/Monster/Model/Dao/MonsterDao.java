package Monster.Model.Dao;

import Monster.Model.Dto.MonsterListDto;

public class MonsterDao extends Dao{

    // 싱글톤
    private MonsterDao() { }// 생성자 : 객체 생성시 초기화 담당


    private static MonsterDao monsterDao = new MonsterDao();

    public static MonsterDao getInstance() {
        return monsterDao;
    }

    // 몬스터리스트 뽑아오기
    public int monsterList(MonsterListDto monsterListDto){
        try {

            // 1. SQL 작성
            String sql = "select * from monsterlist";

            // 2. SQL 기재한다
            ps = conn.prepareStatement(sql);

            // 3. SQL 실행한다
            rs = ps.executeQuery();


        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }











}
