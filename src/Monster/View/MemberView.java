package Monster.View;

import Monster.Controller.MemberController;
import Monster.Model.Dto.MemberDto;

import java.util.Scanner;

public class MemberView {
    //싱글톤
    private MemberView(){}
    private static MemberView memberView = new MemberView();
    public static MemberView getInstance(){return memberView;}

    //입력객체
    Scanner scanner = MainView.getInstance().scanner;

    //1.회원가입
    public void signup(){
        //입력받기
        System.out.println("============회원가입============");
        System.out.print("아이디 : ");
        String id = scanner.next();
        System.out.print("비밀번호 : ");
        String pw = scanner.next();
        System.out.print("핸드폰 : ");
        String phone = scanner.next();
        System.out.print("이름 : ");
        String name = scanner.next();

        //객체화
        MemberDto memberDto = new MemberDto(0,id,pw,phone,name);

        //컨트롤러에 전달 후 받기
        boolean result = MemberController.getInstance().signup(memberDto);

    }





}
