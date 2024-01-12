import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class javaAssignmentProgram {
    static int menuRun = 0;
    static ArrayList<String> userData = new ArrayList<>();

    static ArrayList<String[]> CSVdata = new ArrayList<>();

    static List<String> csvLines = new ArrayList<>();
    static ArrayList<String> user10 = new ArrayList<String>();
    static ArrayList<String> user11 = new ArrayList<String>();
    static ArrayList<String> user12 = new ArrayList<String>();
    static ArrayList<String> user13 = new ArrayList<String>();
    static ArrayList<String> user14 = new ArrayList<String>();
    static ArrayList<String> user15 = new ArrayList<String>();
    static ArrayList<String> user16 = new ArrayList<String>();
    static ArrayList<String> user17 = new ArrayList<String>();
    static ArrayList<String> user18 = new ArrayList<String>();
    static ArrayList<String> user19 = new ArrayList<String>();
    
    public static void main(String[] args) {
        
      
      CSVProcess();
      userLoad();
      Menu();
      //define a list for each user
        
      

    }
    public static void userLoad() {
    BufferedReader userRaw = null;
    try {
        userRaw = new BufferedReader(new InputStreamReader(new FileInputStream("UserData.csv"), StandardCharsets.UTF_8));

        System.out.println("user data file found");

        // Read and store each line in the list
        String line;

        // Remove BOM from the first line if present
        if ((line = userRaw.readLine()) != null) {
            line = line.replace("\uFEFF", "").replace("\u200B", "");
            userData.add(line);
        }

        // Read and store the remaining lines
        while ((line = userRaw.readLine()) != null) {
            userData.add(line);
        }

        // print the userdata list to show that the data is correctly stored and loaded
        System.out.println("user data loaded:");
        for (String Line : userData) {
            System.out.println(Line);
        }

    } catch (FileNotFoundException e) {
        // Handle file not found exception
        System.out.println(e);
        System.out.println("file not found");
    } catch (IOException e) {
        // Handle potential IOException while reading lines
        System.out.println(e);
        System.out.println("error reading lines");
    } finally {
        // Close the BufferedReader in a finally block to ensure it's always closed
        try {
            if (userRaw != null) {
                userRaw.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing BufferedReader");
        }
    }
}
    public static void CSVProcess()
    {
      BufferedReader csvRaw = null;
        
        try {
            csvRaw = new BufferedReader(new FileReader("PCAPData.csv"));
            
            System.out.println("file found");
    
            // Read and store each line in the list
            String line;
            while ((line = csvRaw.readLine()) != null) {
                csvLines.add(line);
            }

            /*printing the lines
            for (String csvLine : csvLines) {
                System.out.println(csvLine);
            }
            */
            
        } catch (FileNotFoundException e) {
            // error print if file doesn't work
            System.out.println(e);
            System.out.println("file not found");
        } catch (IOException e) {
            // handle potential IOException while reading lines
            System.out.println(e);
            System.out.println("error reading lines");
        } finally {
            // close the BufferedReader in a finally block to ensure it's always closed
            try {
                if (csvRaw != null) {
                    csvRaw.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader");
            }
        //sort data into user specific lists
        System.out.println("csvlines size " + csvLines.size());
        
        
        //sort through all entries
        
      
          for (int i = 0; i < csvLines.size(); i++) {
             for (String line : csvLines) {
                String[] columns = line.split(",");
                  
                  switch (columns[0]) {//sorts data concerning specific users into relevant arraylist
                      case "10": user10.add(line); System.out.println("data found for user 10 at line " + i + " of " + csvLines.size()); i++; break;
                      case "11": user11.add(line); System.out.println("data found for user 11 at line " + i + " of " + csvLines.size()); i++; break;
                      case "12": user12.add(line); System.out.println("data found for user 12 at line " + i + " of " + csvLines.size()); i++; break;
                      case "13": user13.add(line); System.out.println("data found for user 13 at line " + i + " of " + csvLines.size()); i++; break;
                      case "14": user14.add(line); System.out.println("data found for user 14 at line " + i + " of " + csvLines.size()); i++; break;
                      case "15": user15.add(line); System.out.println("data found for user 15 at line " + i + " of " + csvLines.size()); i++; break;
                      case "16": user16.add(line); System.out.println("data found for user 16 at line " + i + " of " + csvLines.size()); i++; break;
                      case "17": user17.add(line); System.out.println("data found for user 17 at line " + i + " of " + csvLines.size()); i++; break;
                      case "18": user18.add(line); System.out.println("data found for user 18 at line " + i + " of " + csvLines.size()); i++; break;
                      case "19": user19.add(line); System.out.println("data found for user 19 at line " + i + " of " + csvLines.size()); i++; break;
                  }
                
                }
          }
    }
  }
    
    public static void Menu()
    {
      
      do{
      System.out.println("Please select which function you want:");
      //display user options
      System.out.println("--------------------------------------- ");
      System.out.println("1. complete data sort ");
      System.out.println("2. data search by user ");
      System.out.println("3. data search by ASN ");
      System.out.println("4. data search by date ");
      System.out.println("5. exit program ");
      System.out.println("--------------------------------------- ");
      Scanner userInput = new Scanner(System.in);//get input from user
      int Input = userInput.nextInt();
      
      switch (Input) {
          case 1:
              System.out.println("you have selected function 1");
              
              function1();
              break;
          case 2:
              System.out.println("you have selected function 2");
              
              function2();
              break;
          case 3:
              System.out.println("you have selected function 3");
              
              function3();
              break;
          case 4:
              System.out.println("you have selected function 4");
              
              function4();
              break;
          case 5:
              System.out.println("you have selected exit");
              userInput.close();
              
              exit();
          default:
                System.out.println("please enter a correct option");
              break;
      }
    }while (menuRun == 0);
    }

    public static void exit()
    {
        menuRun = 1;//sets menurun to 1 so that the do while loop closes
    }

    public static void outputList(ArrayList<String> userlist)
    {
        for (String string : userlist) {//small but useful function to iterate over every line and print its content of arraylists
            System.out.println(string);
            updateCSV(string);
            
        }
    }
    private static void updateCSV (String data) 
    {
        CSVdata.add(new String[]{data});//function to add data to a csv
    }
    private static void clearCSV(ArrayList<String[]> data)
    {
        data.clear();//clears the csv for if the user says no to saving the data in a csv
        System.out.println("temporay data deleted");
    }

    private static void writeCSV(String filePath, ArrayList<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate through the ArrayList and write each line to the CSV file
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void DecideCSV(String filename)
    {
        Scanner userDecide = new Scanner(System.in);//get input from user
        System.out.println("would you like to save the data discovered to a .CSV file. (Y/N) ");
        String userInput =  userDecide.nextLine();

        switch (userInput) {
            case "y":
            case "Y":
                writeCSV(filename, CSVdata);
                System.out.println("'yes' selected, creating .CSV");
                clearCSV(CSVdata);
                
                break;
            case "n":
            case "N":
                clearCSV(CSVdata);
                System.out.println("'no' selected, clearing .CSV");
                break;
            default:
                break;
        }
    }

    public static void FlowCalculation(ArrayList<String> userlist)
    {

    // print "this user has x amount of entries (list.length?)" with this amount of traffic (total all traffic from all their entries)
      String userName = " ";
      String userJob = " ";
      String userID = " ";
      int FlowTotal = 0;
      float FlowAverage = 0f;

      HashMap<String, Integer> ASNTally = new HashMap<>();
      ArrayList<Integer> list = new ArrayList<>();
      LinkedHashMap<String, Integer> sortedASNTally = new LinkedHashMap<>();
      

      for (String string : userlist) {//for each line in userlist
            String[] userLine = string.split(",");
            userID = userLine[0];
            
            // Check if the line10[2] element exists
            if (userLine.length > 2) {
              //get the value and store as an integer
              Integer FlowNumber = Integer.valueOf(userLine[2]);
          
              // Add the FlowNumber to the FlowTotal
              FlowTotal = FlowTotal + FlowNumber;
              String key = userLine[1];
              ASNTally.put(key, ASNTally.getOrDefault(key, 0) + 1);//gets or adds a new entry for the specific ASN
            } else {
              // if line10[2] does not exist, so we can't parse it to an integer
              System.out.println("unable to get value of");
            }
            FlowAverage = FlowTotal/ userlist.size();
          
          for (String line : userData) 
            {
                //uses the csv with data about the user to find their name, and their job
              String[] userInfo = line.split(",");
              if (userInfo[0].equals(userID))
              {
                //if the the userID matches then it gets the name and job from that same line
                userJob = userInfo[1];
                //System.out.println("user job is :" + userInfo[1]);
                userName = userInfo[2];
                //System.out.println("user name is :" + userInfo[2]);
                break;
              }
            }
          }
          // different info about the specified user
          System.out.printf("data for user " + userID + " has the name: " + userName + " with job title :" + userJob );
          updateCSV("data for user " + userID + " has the name: " + userName + " with job title :" + userJob );
          System.out.println(" ");
          System.out.printf("%s has %d entrys and %d amount of flows",userName, userlist.size(), FlowTotal);
          updateCSV( userName + " has " + userlist.size() + " entrys and %d amount of flows" + FlowTotal);
          System.out.println(" ");
          System.out.printf( userName + " has an average flow amount of " + FlowAverage );
          updateCSV( userName + " has an average flow amount of " + FlowAverage );
          System.out.println(" ");

          for (Map.Entry<String, Integer> entry : ASNTally.entrySet()) {
            list.add(entry.getValue());//adds the data from the tally hashmap into an arraylist to be sorted
          }

          Collections.sort(list, Collections.reverseOrder());//sorts largest first

        
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : ASNTally.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedASNTally.put(entry.getKey(), num);
                    //adds the data from the list back in til the largest 5 are in the list based on the .size() 
                    if (sortedASNTally.size() >= 5) {
                        break;
                    }
                }
            }
            if (sortedASNTally.size() >= 5) {
                break;
            }
        }
        System.out.println("top 5 amount of times specific ASN are accessed " + sortedASNTally);//prints the top 5
        updateCSV("top 5 amount of times specific ASN are accessed " + sortedASNTally);
        
      }




    public static void function1(){
        //big data sort function
        System.out.println("big data sort function");
        //read csv
      
        //uses the flow calculations function to calculate some statistics on each user 
        FlowCalculation(user10);
        FlowCalculation(user11);
        FlowCalculation(user12);
        FlowCalculation(user13);
        FlowCalculation(user14);
        FlowCalculation(user15);
        FlowCalculation(user16);
        FlowCalculation(user17);
        FlowCalculation(user18);
        FlowCalculation(user19);
        String fileName = "allUserStats.csv";
        DecideCSV(fileName);
      }
    
    public static void allUserInfo(ArrayList<String> userlist)
    {
        String userName = " "; 
        String userID = " ";
            
        for (String string : userlist) {//for each line in userlist
            String[] userLine = string.split(",");
            userID = userLine[0];
        }

        for (String line : userData) 
        {
            //uses the csv with data about the user to find their name, and their job
          String[] userInfo = line.split(",");
          if (userInfo[0].equals(userID))
          {
            //if the the userID matches then it gets the name from that same line
            userName = userInfo[2];
            //System.out.println("user name is :" + userInfo[2]);//used for debugging/testing 
            break;
          }
        }
        
        outputList(userlist);
        System.out.println("all data related to user ID:" + userID + " name: " + userName + " outputted in the format 'user IP, private ASN, amount of flows, date' ");
        updateCSV("all data related to user ID:" + userID + " name:  " + userName + " outputted in the format 'user IP, private ASN, amount of flows, date' ");
        FlowCalculation(userlist);
    }


    public static void function2(){
        //search csv by user
        System.out.println("search csv by user");
        
        Scanner userSelect = new Scanner(System.in);
        int Input = 0;
        outputList(userData);
        clearCSV(CSVdata);
        String filename = "";
        try {
            
            System.out.println("please enter the ID number of the user you would like the data of");
            if (userSelect.hasNextInt()) {
                Input = userSelect.nextInt();
            }
            //waits for user input and then displays data bas

        switch (Input) {
            case 10: allUserInfo(user10); filename = "user10Info.csv"; DecideCSV(filename); break;
            case 11: allUserInfo(user11); filename = "user11Info.csv"; DecideCSV(filename); break;
            case 12: allUserInfo(user12); filename = "user12Info.csv"; DecideCSV(filename); break;
            case 13: allUserInfo(user13); filename = "user13Info.csv"; DecideCSV(filename); break;
            case 14: allUserInfo(user14); filename = "user14Info.csv"; DecideCSV(filename); break;
            case 15: allUserInfo(user15); filename = "user15Info.csv"; DecideCSV(filename); break;
            case 16: allUserInfo(user16); filename = "user16Info.csv"; DecideCSV(filename); break;
            case 17: allUserInfo(user17); filename = "user17Info.csv"; DecideCSV(filename); break;
            case 18: allUserInfo(user18); filename = "user18Info.csv"; DecideCSV(filename); break;
            case 19: allUserInfo(user19); filename = "user19Info.csv"; DecideCSV(filename); break;
            default:System.out.println("incorrect user ID.. returning to main menu"); break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } 
        }
        
    
    public static void function3(){
        //
        System.out.println("search for data with specific ASN");

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> userTally = new HashMap<>();
        LinkedHashMap<String, Integer> sortedUserTally = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int FlowNumber = 0;
        int FlowTotal = 0;
        int Count = 0;
        int largestFlow = 0;
        System.out.println("Please enter a valid ASN number:");
        String userInput = scanner.nextLine();
        
        //ask to enter an asn number

        for (String line : csvLines) {
                String[] columns = line.split(",");
                if (columns.length > 1 && columns[1].equals(userInput)) {
                    FlowNumber = Integer.valueOf(columns[2]);
                    FlowTotal = FlowTotal + FlowNumber;
                    Count++;
                    
                    if (FlowNumber > largestFlow){
                        largestFlow = FlowNumber;
                    }

                    String key = columns[0];
                    userTally.put(key, userTally.getOrDefault(key, 0) + 1);

                    System.out.println(line);
                    updateCSV(line);
                }
                
            }
            for (Map.Entry<String, Integer> entry : userTally.entrySet()) {
            list.add(entry.getValue());
            }

            Collections.sort(list, Collections.reverseOrder());//sorts largest first
            
            for (int num : list) {
            for (Map.Entry<String, Integer> entry : userTally.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedUserTally.put(entry.getKey(), num);
                    
                }
            }
            
        }
        // Calculate average flow only if there are more than 0 entrys for that ASN
        int FlowAverage = (Count > 0) ? (FlowTotal / Count) : 0;

        //largest flow, users connected to and amount, average flows, how many times on network, print full lines
        System.out.println("The ASN:" + userInput + " shows up on the network " + Count + " times ");
        if (Count > 0 )
        {
            updateCSV("The ASN:" + userInput + " shows up on the network " + Count + " times ");
            System.out.println("It was connected to by the following users :");
            updateCSV("It was connected to by the following users :");
            System.out.println(sortedUserTally);
            updateCSV(sortedUserTally.toString());
            System.out.println("The total amount of flows were :" + FlowTotal);
            updateCSV("The total amount of flows were :" + FlowTotal);
            System.out.println(" The average amount of flows on the network was: " + FlowAverage);
            updateCSV(" The average amount of flows on the network was: " + FlowAverage);
            System.out.println(" with the largest flow amount being " + largestFlow );
            updateCSV(" with the largest flow amount being " + largestFlow );
            
            String fileName = "ASN_" + userInput + "_Stats.csv";
            DecideCSV(fileName);
        }
        
        System.out.println("To find other ASN's use function 1 ");

    }
    
    private static boolean isValidDate(String date) {

        if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            // Add slashes to the date
            date = date.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
        }
        String dateRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(date);
    
        return matcher.matches();
    }

    public static void function4(){
        //find user with most anomalies
        System.out.println("search for data via date");

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a date in the format MM/DD/YYYY and include the /:");
        String userInput = scanner.nextLine();

        if (isValidDate(userInput)) {
            System.out.println("Valid date: " + userInput);
            // Process the valid date here
    
            for (String line : csvLines) {
                String[] columns = line.split(",");
                if (columns.length > 3 && columns[3].equals(userInput)) {
                    System.out.println(line);
                    updateCSV(line);
                }
            }
            System.out.println("all data related to date " + userInput + " outputted in the format 'user IP, private ASN, amount of flows, date' ");
            updateCSV("all data related to date " + userInput + " outputted in the format 'user IP, private ASN, amount of flows, date' ");
            
            String usersimplified = userInput.replaceAll("/", "_");//reformats the user input to allow for file name
            String fileName = "date_" + usersimplified + "_Stats.csv";//filename format
            DecideCSV(fileName);

        } else {
            System.out.println("Invalid date format. Please include / and enter in MM/DD/YYYY format.");
        }
    }



}
