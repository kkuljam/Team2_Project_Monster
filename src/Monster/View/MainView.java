package Monster.View;

import java.util.Scanner;

public class MainView {
    //싱글톤
    private MainView(){}
    private static MainView mainView = new MainView();
    public static MainView getInstance(){return mainView;}

    //입력객체
    Scanner scanner = new Scanner(System.in);

    //메인페이지
    public void mainView(){
        while (true) {
            //입력받기
            System.out.println("============메인페이지============");
            System.out.println("1.회원가입 2.로그인");
            System.out.print("선택 > ");
            int ch = scanner.nextInt();

            if (ch == 1) {
                MemberView.getInstance().signup();
            } else if (ch == 2) {
                MemberView.getInstance().login();
            } else {
                System.out.println("<알림> 입력이 잘못되었습니다.");
            }
        }//w e
    }//m e
}//c e
