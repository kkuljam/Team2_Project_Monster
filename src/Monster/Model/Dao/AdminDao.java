package Monster.Model.Dao;

import java.util.ArrayList;

public class AdminDao {
    private AdminDao(){}//생성자 : 객체 생성시 초기화 담당
    private static AdminDao adminDao = new AdminDao();
    public static AdminDao getInstance(){return adminDao;}

    //회원정보 불러오기
    //public ArrayList<>
}
