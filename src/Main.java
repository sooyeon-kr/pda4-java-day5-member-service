import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UserService userService = new UserService();
        User logined = null;
        while(true) {
            System.out.println("1:회원가입 2:로그인 3:회원정보 수정 4:탈퇴 0:종료");
            int inputValue = in.nextInt();
            if(inputValue == 1) {
                System.out.println("가입하실 아이디와 이름, 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
                String id = in.next();
                String name = in.next();
                String pw = in.next();
                User user = new User(id, name, pw);
                if(userService.join(user)) System.out.println(user.getName() + "님 가입을 환영합니다.");
            }else if(inputValue == 2) {
                System.out.println("로그인하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
                String id = in.next();
                String pw = in.next();
                User user = new User(id, pw);
                logined = userService.login(user);
                if(logined != null) {
                    System.out.println(logined.getName()+"님 로그인이 되었습니다.");
                }else{
                    System.out.println("사용자 아이디나 비밀번호를 확인해주세요.");
                }
            }else if(inputValue == 3) {
                break;
                if(logined == null){
                    System.out.println("로그인한 상태가 아닙니다.");
                }else{
                    System.out.println("변경하실 비밀번호를 입력해주세요.");
                    String pw = in.next();
                    User user = new User(logined.getId(), logined.getName(), pw);
                    User modified = userService.modify(user);
                    if(modified == null){
                        System.out.println("수정을 실패했습니다.");
                    }else{
                        logined = modified;
                        System.out.println("수정했습니다.");
                    }
                }
            }else if(inputValue == 4) {
                break;
            }else if(inputValue == 0) {
                System.out.println("안녕히가세요!");
                break;
            }else{
                System.out.println("올바른 번호를 입력해주세요.");
            }

        }
    }
}