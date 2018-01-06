import java.util.*;
import java.io.*;

public class FileCopy {
	
	public static void main(String[] args) throws IOException{
	
		Scanner s = new Scanner(System.in);
                System.out.println("Enter the InputPath");
		String inputPath=s.nextLine();
                System.out.println("Enter the OutputPath");
		String outputPath=s.nextLine();
                System.out.println("Enter File Name:-");
		String fileName=s.nextLine();
                fileCopier(inputPath, outputPath, fileName);
		
		
		
	}
        static void fileCopier(String inputPath,String outputPath,String fileName) throws FileNotFoundException, IOException
        {
            
                    File inputFile=new File(inputPath+"\\"+fileName);
                    File outputFile=new File(outputPath+"\\"+fileName);
                    File temp=null;
                    FileReader readFile=null;
                    FileWriter writeFile=null;
			
			readFile = new FileReader(inputPath+"\\"+fileName);
					
			if(inputFile.exists()){
				if(outputFile.exists()){
			
					temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
					
					if(temp.exists()){
						int i=2;
						int a;
						while(true){
							temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
							if(!temp.exists()){
								break;
							}
							i++;
						}
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((a=readFile.read())!=-1){
							writeFile.write(a);
						}
						System.out.println("Successfully.");
					}else{
						int a;
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((a=readFile.read())!=-1){
							writeFile.write(a);
						}
						System.out.println("Successfully.");
					}
				}else{
					int a;
					writeFile = new FileWriter(outputPath+"\\"+fileName);
					while((a=readFile.read())!=-1){
						writeFile.write(a);
					}
					System.out.println("Successfully.");
				}
			}else{
				System.out.println("dosen't exists.");
			}
			
			readFile.close();
			writeFile.close();
		
        }
}