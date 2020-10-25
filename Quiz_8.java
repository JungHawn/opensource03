import java.io.*;
import java.util.*;

public class HelloJava {
	private File targetFile = null;
	Vector<String> lineVector = new Vector<String>();
	
	public HelloJava() { }
	
	private void readFile(String fileName) {
		targetFile = new File(fileName);
		try {
			Scanner fScanner = new Scanner(new FileReader(targetFile));
			while(fScanner.hasNext()) {
				String line = fScanner.nextLine(); 
				lineVector.add(line);
			}			
			fScanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Vector<Integer> searchWord(String word) {
		Vector<Integer> noVector = new Vector<Integer>();
		for(int i=0; i<lineVector.size(); i++) {
			String line = lineVector.get(i);
			if(line.indexOf(word) != -1) 
				noVector.add(i);
		}
		
		return noVector;
	}

	private void printLines(Vector<Integer> noVector) {
		for(int i=0; i<noVector.size(); i++) {
			int lineNo = noVector.get(i);
			String line = lineVector.get(lineNo);
			System.out.println(lineNo + ":" + line);
		}
	}
	
	public void run() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();

		readFile(fileName);
		
		while(true) {
			System.out.print("검색할 단어나 문장>> ");
			String line = scanner.nextLine();
			if(line.equals("그만"))
				break; // 프로그램 종료
			Vector<Integer> noVector = searchWord(line);
			printLines(noVector);
		}
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}
	public static void main(String[] args) {
		HelloJava serach = new HelloJava();
		serach.run();
	}
}
