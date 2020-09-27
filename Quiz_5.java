import java.util.Scanner;

class Seat { // 좌석 관리
	private String seat[];
	
	public Seat() { // 생성
		seat = new String[10]; //10개의 좌석
		for(int i=0; i < seat.length; i++) {
			seat[i] = "---";
		}
	}
	
	public void Show() { // 상태 출력
		for(int i=0; i < seat.length; i++) {
			System.out.print(seat[i]+" ");
		}
		System.out.println();
	}
	
	public void Set(String name, int num) { // 예매된 좌석 정보 처리
		seat[num-1] = name;
	}
	
	public boolean Reset(String name) { // 좌석 취소 처리
		for(int i=0; i < seat.length; i++) {
			if(name.equals(seat[i])) {
				seat[i] = "---";
				return true;
			}
		}
		return false;
	}
}

class Reservation {
	Scanner scanner = new Scanner(System.in);
	private Seat s[]; // 등급별 좌석
	private String seatGrade[] = {"S","A","B"}; // 등급별 이름
	
	public Reservation() {
		s  = new Seat[3];
		for(int i=0; i<s.length; i++) {
			s[i] = new Seat();
		}
	}
	
	public void Reserve() {
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int grade = scanner.nextInt();
		System.out.print(seatGrade[grade-1]+">>");
		s[grade-1].Show();
		
		System.out.print("이름>>");
		String name = scanner.next();
		System.out.print("번호>>");
		int num = scanner.nextInt();
		s[grade-1].Set(name, num);
	}
	
	public void Check() {
		for(int i=0; i < s.length; i++ ) {
			System.out.print(seatGrade[i]+">>");
			s[i].Show();
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	public void Cancel() {
		System.out.print("좌석 S:1, A:2, B:3>>");
		int grade = scanner.nextInt();
		System.out.print(seatGrade[grade-1]+">>");
		s[grade-1].Show();
		
		System.out.print("이름>>");
		String name = scanner.next();
		
		boolean result = s[grade-1].Reset(name);
		if(result==true)
			System.out.println("<<<취소를 완료하였습니다.>>>");
		else
			System.out.println("존재하지 않는 정보입니다.");
	}
	
	public void Run() {
		int option;
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			option = scanner.nextInt();
			
			switch(option) {
			case 1:
				Reserve();
				break;
			case 2:
				Check();
				break;
			case 3:
				Cancel();
				break;
			case 4:
				return;
			}
		}
	}
}

public class HelloJava {
	public static void main(String[] args) {
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		Reservation r = new Reservation();
		r.Run();
	}
}
