import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Stream;

public class GetIDCount {
	
	/***
	 * 
	 * In this code, the have updated an statement to convert the string into lower case and then check the rows with pubmatic word.
	 * 
	 *Also updated the split statement as per the given file conditions
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {
		
		String user = System.getProperty("user.name");
		

		File file = new File("C:\\Users\\"+user+"\\eclipse-workspace\\newWork\\Pubmatic_Assignment\\src\\config prop");

		BufferedReader br = new BufferedReader(new FileReader(file));

		int count = 0;

		String st = null;

		HashSet<String> hdirect = new HashSet<String>();
		HashSet<String> hreseller = new HashSet<String>();

		/*
		 * while(br.readLine()!=null ) l++; System.out.println("LINES" + l);
		 */
		st =br.readLine();
		try {
			while (st != null) {
				
					st =st.toLowerCase();
				

				if (st!=null && st.contains("pubmatic"))

				{
					count++;
					System.out.println(st);
					System.out.println(count);

					String words[] = st.split(",");
					int l = words.length;
					if (st.contains("direct")) {

						
						
						if (words.length == 4) {
							if (words[l - 1].contains("#")) {
								String arr[] = words[l - 1].split("#");
								hdirect.add(arr[0].trim());
							} else {
								hdirect.add(words[l - 1].trim());
							}
								
						}

					} else if (st!=null && st.contains("reseller")) {

						
						if (words.length == 4) {
							if (words[l - 1].contains("#")) {
								String arr[] = words[l - 1].split("#");
								hreseller.add(arr[0].trim());
							}else {
								hreseller.add(words[l - 1].trim());
							}
							
						}
							

					}
					// pubmatic.com, 23105, DIRECT, 5d62403b186f2ace
					// pubmatic.com, 158151, RESELLER, 5d62403b186f2ace

				}
				st =br.readLine();

			}

			br.close();

			// Print both sets

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		System.out.println(hreseller);
		System.out.println(hdirect);

	}

}
