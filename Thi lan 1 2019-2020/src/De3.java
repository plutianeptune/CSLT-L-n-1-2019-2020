import java.util.Scanner;
import java.io.*;
public class De3 {
	
	private static void LietKeFileVaThuMuc(String path) {
		File file = new File(path);
		if(file.exists()) {
			File[] dsFile = file.listFiles();
			for(int i = 0;i < dsFile.length; i++) {
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
			
		}catch (Exception e) {
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
	
	private static boolean KiemTraSNT(int so) {
		if(so <= 2) return false;
		for(int i = 2;i <= so/2;i++) {
			if(so % i ==0) {
				return false;
			}
		}
		return true;
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
		
//Câu 2:
		String cacSNT = "";
		String[] daySo = content.split(" "); //Đọc từ file ra
		for (int i = 0;i < daySo.length; i++) {
			int number = Integer.parseInt(daySo[i]);
			if (KiemTraSNT(number)) {
				cacSNT += daySo[i] + " ";
			}
		}
		System.out.println("Cac SNT co trong day so : " +cacSNT);
		
//Câu 3:
		GhiFile(cacSNT);
	}
	}
