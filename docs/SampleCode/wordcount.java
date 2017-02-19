import java.util.*;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;


public class wordcount {
	/*The purpose of wordcount.java is to practice using scanner to import txt files to
	 * java. We import the content/ words of a text file by asking a user to submit a name
	 * of a file. Later we using certain methods to get the number of lines, words, vowels,
	 * numbers, punctuations and alphanumeric characters.
	 */
	
	/* wordcount.java uses first a basic scanner system.in to ask the user for his or her
	 * file name. Later the File class creates a new file with that name and the scanner
	 * is converted to new Scanner(file). a while loop is used with hasNextLine to print
	 * out every line in the txt file. but more importantly while every line of code
	 * is being printed out, it is being saved in an arraylist. Later different methods
	 * are used to make specific calculations for words, lines, vowels, ect.
	 */
	//Scanner and arraylist is available throughout program
	
	/* the arraylist is undoubtly the most important data structure used in this program
	 * array was not an option because of the uncertainty of the txt file size
	 * and vectors were not necessary because everything was going to be in a string
	 * also the arraylist could be easily broken down in foor loops to strings and even
	 * further into char arrays. making the task easy.
	 */
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<String> input = new ArrayList<String>();
	public static File file;
	public static int numLine;
	public static int numWordFinal;
	public static int vowels;
	public static int count;
	public static int punc;
	public static int s;
	public static BufferedWriter writer;
	
	//main class calls each method
	public static void main(String[] args) {
		fileInput();
		numLines();
		numWords();
		vowel();
		numbers();
		output();
	}
	//method used to input/ show/ and save file
	public static void fileInput(){
		//try and catch statements are required, unless your throw exception
		try{
			System.out.println("Please enter your file name + extension: ");
			
		String ans = sc.nextLine();

			
			 file = new File(ans);
			
			
			sc = new Scanner(file);
			
			//hasNextLine reach each line in file
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				 System.out.println(line);
				 
				 //Add file to ArrayList
				 input.add(line);		
			}			
			//Scanner file must always be closed/ flushed
			sc.close();
		}
		
		catch(Exception ex){
			System.out.println("Sorry the file could not be located.");
		
		}		
	}
	//counts the number of lines by using arraylist
	public static void numLines(){
		 numLine =0;
		for(String e: input ){
			numLine++;
		}
	}
	
	//counts the number of words by differenting between words with blank spaces
	public static void numWords(){
		int numWord =0;
		 numWordFinal=0;
		
		for(String e: input){
			numWord = e.split(" ").length;
			numWordFinal+=numWord;
		}
			
	}
	
	//counts the number of vowels by adding together the number of time aeiou appear
	public static void vowel(){
		String arrayToString = input.toString();
		int length = arrayToString.length();
		
		 vowels = (length-arrayToString.replace("a", "").length()) + (length-arrayToString.replace("e", "").length()) + (length-arrayToString.replace("i", "").length())
				+(length-arrayToString.replace("o", "").length()) + (length-arrayToString.replace("u", "").length());

	}
	
	//counts the number of sentences. by determining if they end with .!?
	//counts the number of numbers and punctuations , sentences
	public static void numbers(){
		
		 count=0;
		 punc=0;
		 s=0;
			//two for loops are necessary the first for string and later for char array
		for(String e: input){
			//char conversion allows more accurate results 
			//and more easier available methods
		for(char c: e.toCharArray()){
			if(Character.isDigit(c))
				count++;
			if(Character.isAlphabetic(c))
				count++;
			
			//looking for punctuations
			if(c == '!'){
				punc++; 
				s++;}
			if(c == ':')
				punc++;
			if(c == ';')
				punc++;
			if(c == ',')
				punc++;
			if(c == '?'){
				punc++; 
				s++;}
			if(c == '"')
				punc++;
			if(c == '(')
				punc++;
			if(c == ')')
				punc++;
			if(c == '.'){
				punc++; 
				s++;}
			if(c == '%')
				punc++;
			
		}
	}
	}
	public static void output(){
		
		try{
			File nFile= new File("output.txt");
			if(!nFile.exists())
				nFile.createNewFile();
			
			FileWriter w = new FileWriter(nFile);
			 writer = new BufferedWriter(w);
			 
			 if(count == 0){
				 writer.write("File is Empty. So.... ");
				 writer.newLine();
			 }
			writer.write("The number of lines are: " + numLine);
			writer.newLine();
			writer.write("The number of words are: " + numWordFinal);
			writer.newLine();
			writer.write("The number of vowels are: " + vowels);
			writer.newLine();
			writer.write("The Number of Alphanumeric Characters are: " + count);
			writer.newLine();
			writer.write("The number of punctuations are: "+ punc);
			writer.newLine();
			writer.write("The number of sentences are: "+ s);
			writer.newLine();
			
			System.out.println();
			System.out.println();
			System.out.println("**Output file has been succesfully created.**");
		}catch(Exception e){
			System.out.println("An error has occured while attempting to create output file.");
			
		}finally{
			try{
				if(writer!=null)
					writer.close();
			}catch(Exception ex){
				System.out.println("Error in closing the BufferedWriter"+ex);
			}
		}
		
	}
}