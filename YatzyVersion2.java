import java.util.Scanner;

public class YatzyVersion2
{
   static Scanner userInput = new Scanner(System.in);

   public static void main(String[] args)
   {

      /**
       */
      String[][] DiceVisual = new String [7][3];
      //printDiceVisual(x, DiceVisual);

      /**
       * Array innehåller vad de 5 tärningarna slog.
       * index[1][0] = Tärning 1 slog
       * index[2][0] = Tärning 2 slog
       * index[3][0] = Tärning 3 slog
       * index[4][0] = Tärning 4 slog
       * index[5][0] = Tärning 5 slog 
       */
      int[][] ShowingNumberOneToSix = new int [6][2];

      /**
       * Array innehåller antal 1 - 6 som slogs av de 5 tärningarn.
       * index[1][0] = antal ettor
       * index[2][0] = antal tvår
       * index[3][0] = antal treor
       * index[4][0] = antal fyror
       * index[5][0] = antal femmor 
       * index[6][0] = antal sexor
       */
      int[][] countingNumberOneToSix = new int [7][2];

      /**KOPIA FÖR ATT SPARA 
       * Array innehåller antal 1 - 6 som slogs av de 5 tärningarn.
       * index[1][0] = antal ettor
       * index[2][0] = antal tvår
       * index[3][0] = antal treor
       * index[4][0] = antal fyror
       * index[5][0] = antal femmor 
       * index[6][0] = antal sexor
       */
      int[][] saveCountingAfterThrow = new int [7][2];

      /**KOPIA FÖR ATT SPARA 
       * Array innehåller antal 1 - 6 som slogs av de 5 tärningarn.
       * index[1][0] = antal ettor
       * index[2][0] = antal tvår
       * index[3][0] = antal treor
       * index[4][0] = antal fyror
       * index[5][0] = antal femmor 
       * index[6][0] = antal sexor
       */
      int[][] totalScoreAfterSixRounds = new int [7][2];

      int number = 0;

      int choice = 0;

      int score = 0;

      int scoreaftersixrounds = 0;

      int countfoorloop = 1;


      while (true)
      {
         System.out.print("Börja spelet med tryck 1\n");


         choice = inputInt();

         switch (choice)
         {
         case 1:
            System.out.println("Startar spelet \n");

            break;
         case 2:
            System.out.println("Skriver ut de fem tärningarna (OBS fem tärningar !)\n");
            printFive(ShowingNumberOneToSix, DiceVisual);

         case 3:
            System.out.println("Skriver ut hur många 1 - 6 (OBS sex tal!)\n");
            printSix(countingNumberOneToSix);  

         case 4:
            System.out.println("KOPIA Skriver ut hur många 1 - 6 (OBS sex tal!)\n");
            printCopy(saveCountingAfterThrow); 
         case 5:
            System.out.println("Testar utskrift )\n");
            printtotalScoreAfterSixRounds(totalScoreAfterSixRounds,scoreaftersixrounds);

         default:
            System.out.println("Välj 1-6\n\n");
            break;
         }

         for (int rounds = 0; rounds < 6; rounds++) 
         {

            System.out.println("Omgång " + countfoorloop);
            countfoorloop++;

            // Omgång 1 
            System.out.println("Kast 1\n");
            // Kastar tärnignarna 
            throwTheDice(ShowingNumberOneToSix, countingNumberOneToSix, number);

            System.out.println("Du slog");
            printFive(ShowingNumberOneToSix, DiceVisual);

            // för spara värde eller ej
            number = saveOrZeroDices(countingNumberOneToSix, saveCountingAfterThrow, number);
            // omgång 2 
            System.out.println("Kast 2\n");         
            throwTheDice(ShowingNumberOneToSix, countingNumberOneToSix, number);

            System.out.println("Du slog");
            printFive(ShowingNumberOneToSix, DiceVisual);

            // för spara värde eller ej
            number = saveOrZeroDices(countingNumberOneToSix, saveCountingAfterThrow, number);


            System.out.println("Kast 3\n");
            throwTheDice(ShowingNumberOneToSix, countingNumberOneToSix, number);

            System.out.println("Du slog");

            printFive(ShowingNumberOneToSix, DiceVisual);

            // för spara värde eller ej
            number = saveOrZeroDices(countingNumberOneToSix, saveCountingAfterThrow, number);

            // nollställer varabel 
            number = 0;


            System.out.println("Vilken värde vill du spara poäng för? (siffra på tärning)?");
            score = inputInt();
            System.out.println(score);


            // sparar värde i indexrad som anvädnaren skriver in i ny array 
            for (int i = 1; i < saveCountingAfterThrow.length; i++)
            {
               if (i == score && totalScoreAfterSixRounds[i][0] != 0)
               {
                  System.out.println("Du har redan sparat det här värdet!!");
               }

               if (i == score && totalScoreAfterSixRounds[i][0] == 0)
               {
                  // sparar även tidigare värden på den raden 
                  totalScoreAfterSixRounds[i][0] = saveCountingAfterThrow[i][0];    
               }


            }


            // nollställer så inget gammalt värde är kvar
            saveCountingAfterThrow[1][0] = 0;
            saveCountingAfterThrow[2][0] = 0;
            saveCountingAfterThrow[3][0] = 0;
            saveCountingAfterThrow[4][0] = 0;
            saveCountingAfterThrow[5][0] = 0;
            saveCountingAfterThrow[6][0] = 0;


            for (int i = 1; i < totalScoreAfterSixRounds.length; i++)
            {
               System.out.println(totalScoreAfterSixRounds[i][0]);

            }
         } // en foorloop som varvara 6 gånger eftersom man har sex omgångar på sig 






         for (int i = 1; i < totalScoreAfterSixRounds.length; i++)
         {

            scoreaftersixrounds =  scoreaftersixrounds + (totalScoreAfterSixRounds[i][0] * i);
         }

         printtotalScoreAfterSixRounds(totalScoreAfterSixRounds,scoreaftersixrounds);

      } // end whileloop   
   }


   public static void printDiceVisual (int x, String[][] DiceVisual)
   {
      DiceVisual[1][0] = "|   |";
      DiceVisual[1][1] = "| * |";
      DiceVisual[1][2] = "|   |";

      // tärning 2 
      DiceVisual[2][0] = "|*  |";
      DiceVisual[2][1] = "|   |";
      DiceVisual[2][2] = "|  *|";

      // tärning 3
      DiceVisual[3][0] = "|*  |";
      DiceVisual[3][1] = "| * |";
      DiceVisual[3][2] = "|  *|";

      DiceVisual[4][0] = "|* *|";
      DiceVisual[4][1] = "|   |";
      DiceVisual[4][2] = "|* *|";

      // tärning 2 
      DiceVisual[5][0] = "|* *|";
      DiceVisual[5][1] = "| * |";
      DiceVisual[5][2] = "|* *|";

      // tärning 3
      DiceVisual[6][0] = "|* *|";
      DiceVisual[6][1] = "|* *|";
      DiceVisual[6][2] = "|* *|";

      for (int i = 1; i < DiceVisual.length; i++)
      {
         for (int k = 0; k < DiceVisual[i].length; k++)
         {   
            if (i == x)
            {

               System.out.println(DiceVisual[i][k]);
               //System.out.println("test");
            } 
         }
      } 


   }



   public static void printtotalScoreAfterSixRounds (int[][] totalScoreAfterSixRounds, int scoreaftersixrounds)
   {
      int bonus = 50;

      System.out.println("Ettor\t\t" + totalScoreAfterSixRounds[1][0]);
      System.out.println("Tvåor\t\t" + totalScoreAfterSixRounds[2][0]);
      System.out.println("Treor\t\t" + totalScoreAfterSixRounds[3][0]);
      System.out.println("Fyror\t\t" + totalScoreAfterSixRounds[4][0]);
      System.out.println("Femor\t\t" + totalScoreAfterSixRounds[5][0]);
      System.out.println("Sexor\t\t" + totalScoreAfterSixRounds[6][0]);
      System.out.println(".............");
      System.out.println("Summa\t\t" + scoreaftersixrounds);
      if (scoreaftersixrounds < 63)
      {
         System.out.println("Bonus\t\t" + "0");
         System.out.println(".............");
         System.out.println("Total Poäng\t" + scoreaftersixrounds);
      }
      if (scoreaftersixrounds >= 63)
      {
         System.out.println("Bonus\t\t" + bonus);
         System.out.println("Total Poäng\t\t" + (scoreaftersixrounds + bonus));
         // annars får jag skapa en int total score 
      }

      System.out.println();
   }



   /**
    * Metod för hantera heltal, q och övrig input
    * @return heltal
    */






   public static int inputInt()
   {
      while (true)
      {
         int number = 0;

         // När användare skriver siffrer
         if (userInput.hasNextInt())
         {
            number = userInput.nextInt();
            // Omvandla negativt till positv tal
            number = Math.abs(number);
            userInput.nextLine();
            return number;
         }
         // Lagt till de här blocket för brejka med q
         else if (userInput.hasNext("q"))
         {
            // RENSNING FÖR KUNNA TA IN NY INPUT
            userInput.nextLine();
            number = -1;
            return number;
         }

         else
         {
            // Annan inmatning från user än siffror
            System.out.printf("Mata in ett heltal" + "\n");
            // För att stoppa loop
            userInput.nextLine();
         }
      }
   }

   /**
    * Metod för att hantera bokstäver och text
    * @return String
    */
   public static String inputString()
   {

      while (true)
      {
         String inputString;

         // När användare skriver siffrer
         if (userInput.hasNext())
         {
            inputString = userInput.nextLine();

            return inputString;
         } else
         {
            // Annan inmatning från user än bokstäver
            // System.out.printf("Mata in ett heltal" + "\n");
            // För att stoppa loop
            userInput.nextLine();
         }
      }
   }
   /**
    * metod som kastar 5 tärningar och lägger in i array hur många antal ettor tvår osv upp till sex.
    * @param numberofstrokeswithdice
    */
   public static void throwTheDice (int[][] ShowingNumberOneToSix, int[][] countingNumberOneToSix, int number)
   {
      //int count = 1;
      int dice;

      int diceOne = 0;
      int diceTwo = 0;
      int diceThree = 0;
      int diceFour = 0;
      int diceFive = 0;
      int diceSix = 0;

      // nollställer 5 tärningarna till noll så inget gammalt är kvar
      ShowingNumberOneToSix[1][0] = 0;
      ShowingNumberOneToSix[2][0] = 0;
      ShowingNumberOneToSix[3][0] = 0;
      ShowingNumberOneToSix[4][0] = 0;
      ShowingNumberOneToSix[5][0] = 0;


      // nollställer så inget gammalt värde är kvar
      countingNumberOneToSix[1][0] = 0;
      countingNumberOneToSix[2][0] = 0;
      countingNumberOneToSix[3][0] = 0;
      countingNumberOneToSix[4][0] = 0;
      countingNumberOneToSix[5][0] = 0;
      countingNumberOneToSix[6][0] = 0;



      // Loopar 5 gånger 
      for (int i = 0; i < 5 - number; i++)
      {
         // tillfällig för hålla koll på allt stämmer
         //System.out.println(count);
         //count++;
         dice = (int) (Math.random() * ((6 - 1) + 1)) + 1; 
         // lägger in i array vad tärningarna slog
         // börjar med index 1 
         ShowingNumberOneToSix[i + 1][0] = dice;
         // kontroll så jag ser att det stämmer med antal
         //System.out.println(dice);

         if (dice == 1)
         {
            diceOne++;
         }
         if (dice == 2)
         {
            diceTwo++;

         }
         if (dice == 3)
         {
            diceThree++;
         }
         if (dice == 4)
         {
            diceFour++;
         }
         if (dice == 5)
         {
            diceFive++;
         }
         if (dice == 6)
         {
            diceSix++;
         }
      } // end foor

      // lägger in i array antal 
      countingNumberOneToSix[1][0] = diceOne;
      countingNumberOneToSix[2][0] = diceTwo;
      countingNumberOneToSix[3][0] = diceThree;
      countingNumberOneToSix[4][0] = diceFour;
      countingNumberOneToSix[5][0] = diceFive;
      countingNumberOneToSix[6][0] = diceSix;
   }


   /**
    * 
    * @param ShowingNumberOneToSix
    */
   public static void printFive (int[][] ShowingNumberOneToSix, String[][] DiceVisual  )
   {
      for (int i = 1; i < ShowingNumberOneToSix.length; i++)
      {
         // skriver bara ut de som är slagna då de inte slagna visar 0
         if (ShowingNumberOneToSix[i][0] != 0)
         {
            System.out.println(ShowingNumberOneToSix[i][0]);
            // lägg in tärningsmetoden med värdet  ShowingNumberOneToSix[i][0]
// showing = ett int värde
            printDiceVisual(ShowingNumberOneToSix[i][0], DiceVisual);

         }
      }
      System.out.println();
   }

   /**
    * 
    * @param countingNumberOneToSix
    */
   public static void printSix (int[][] countingNumberOneToSix)
   {
      for (int i = 1; i < countingNumberOneToSix.length; i++)
      {
         System.out.println(countingNumberOneToSix[i][0]);

      }
      System.out.println();
   }


   public static void printCopy(int[][] saveCountingAfterThrow)
   {
      for (int i = 1; i < saveCountingAfterThrow.length; i++)
      {
         System.out.println(saveCountingAfterThrow[i][0]);

      }
      System.out.println();
   }



   /**
    * metod som kan spara ex alla 3or om användaren väljer att göra det.  
    * @param numberofstrokeswithdice
    */
   public static int saveOrZeroDices (int[][] countingNumberOneToSix, int[][] saveCountingAfterThrow, int number)
   {

      //int number = 0;

      int inputInt;

      String inputString;

      System.out.println("Vill du behålla något tal? (svara ja eller nej)");


      inputString = userInput.nextLine().toLowerCase();
      System.out.println(inputString);

      if (inputString.equals("ja"))
      {
         System.out.println("vilket värde vill du behålla?");

         inputInt = userInput.nextInt();
         System.out.println(inputInt);
         // För rensa 
         userInput.nextLine();

         // sparar värde i indexrad som anvädnaren skriver in i ny array 
         for (int i = 1; i < countingNumberOneToSix.length; i++)
         {
            if (i == inputInt)
            {
               // sparar även tidigare värden på den raden 
               saveCountingAfterThrow[i][0] = saveCountingAfterThrow[i][0] + countingNumberOneToSix[i][0];
               number = saveCountingAfterThrow[i][0];

            }
         }
      } // end if 

      else if (inputString.equals("nej"))
      {
         // array nollställs helt
         for (int i = 1; i < countingNumberOneToSix.length; i++)
         {
            countingNumberOneToSix[i][0] = 0;
         }
      }

      else 
      {
         // lägga in en true eller false här med whileloop?? 
         System.out.println("Ditt tal blev inte sparat");
      }
      return number;
   } // end metod 




}
