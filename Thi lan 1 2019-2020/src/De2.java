import java.util.Scanner;
import java.io.*;
public class De2 {
	
	private static void LietKeFileVaThuMuc(String path) {
		File file = new File(path);
		if(file.exists()) {
			File[] dsFile = file.listFiles();
			for(int i = 0;i < dsFile.length;i++) {
				System.out.println(dsFile[i].getName());
			}
		}
		else {
			System.out.println("Duong dan khong ton tai");
		}
	}
	
	private static void GhiFile(String content) {
		try {
			File file = new File("D:/Filecode/Data.txt");
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String DocFile(String path) {
		String content = "";
		File file = new File(path);
		if(file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				content = br.readLine(); //Đọc dòng đầu tiên
				
				br.close();
				fr.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("Tap tin khong ton tai");
		}
		return content;
	}
	
	private static int TinhTong(String[] daySo) {
		int tong = 0;
		for(int i = 0;i < daySo.length;i++) {
			tong += Integer.parseInt(daySo[i]); //Chuyển về kiểu số
		}
		return tong;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Câu 1:
		Scanner n = new Scanner(System.in);
		System.out.println("Nhap vao duong dan file :");
		String path = n.nextLine();
		String content = "";
		content = DocFile(path);
		System.out.println(content);
		
//Câu 2a:
		String[] daySo = content.split(" "); //Đọc từ file ra
		int tong = TinhTong(daySo);
		System.out.printf("Ket qua tong :%d",tong);
		
//Câu 2b:
		GhiFile(String.valueOf(tong));
		
//Câu 3:
		System.out.println("\n======== Thu muc va file trong o D:/ ");
		LietKeFileVaThuMuc("D:/");
	}

}
