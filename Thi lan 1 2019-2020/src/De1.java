import java.util.Scanner;
import java.io.*;
public class De1 {
	
	private static void LietKeFileVaThuMuc(String path) {
		File file = new File(path);
		if(file.exists()) {
			File[] dsFile = file.listFiles();
			for(int i=0;i<dsFile.length;i++) {
				System.out.println(dsFile[i].getName());
			}
		}else {
			System.out.println("Duong dan khong ton tai");
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
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("Tap tin khong ton tai");
		}
		return content;
	}
	
	private static void GhiFile(String[] mang) {
		String content = "";
		try {
			File file = new File("D:/File code/Data.txt");
			FileWriter fw = new FileWriter(file);
			for(int i=0;i<mang.length;i++) {
				content += mang[i]+"";
			}
			fw.write(content);
			fw.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void SapXep(String[] dsTen) {
		for(int i=0;i<dsTen.length-1;i++) {
			for(int j=i+1;j<dsTen.length;j++) {
				if(dsTen[i].compareTo(dsTen[j])>0) {
					String temp = dsTen[i];
					dsTen[i] = dsTen[j];
					dsTen[j] = temp;
				}
			}
		}
	}
	
	private static void XuatMang(String[] dsTen) {
		for(int i=0;i<dsTen.length;i++) {
			System.out.println(dsTen[i] +" ");
			
		}
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
		String[] dsTen = content.split(" ");
		SapXep(dsTen);
		System.out.println("Sau khi sap xep ten theo thu tu A-Z ");
		XuatMang(dsTen);
		
//Câu 2b:
		GhiFile(dsTen);
		
//Câu 3:
		System.out.println("\n=== Thu muc va File trong D:/");
		LietKeFileVaThuMuc("D:/");
		
	}

}
