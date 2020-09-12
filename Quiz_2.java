import java.util.Scanner ;

public class HelloJava {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("연산>>");
		int number1=scanner.nextInt();
		String operator=scanner.next(); 
		int number2=scanner.nextInt(); 
		int result=0;
		switch(operator) {
		
		case "+": 
			result=number1+number2; 
			break;
			
		case "-": 
			result=number1-number2; 
		
		case "*": 
			result=number1*number2; 
	
		case "/": 
			if(number2==0) {
				System.out.print("0으로 나눌수 없습니다."); 
				scanner.close(); 
				} 
			result=number1/number2; 
			break; 
			
		default: 
			System.out.print("사칙연산이 아닙니다."); 
			scanner.close(); 
			break; 
			} 
		System.out.print(number1+operator+number2+"의 계산결과는"+result); 
		scanner.close(); 
		} 
	}
