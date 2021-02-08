
package projekt;
import java.util.*;
import java.io.*;

class CCode{
    public String cezarek(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalPosition = character - 'a';
                int newPosition = (originalPosition + offset) % 26;
                char newCharacter = (char) ('a' + newPosition);
                result.append(newCharacter);
            } 
            else {
                result.append(character);
            }
        }
        String s = result.toString();
        return s;
    }
    public String decezarek(String message, int offset) {
        return cezarek(message, 26 - (offset % 26));
    }

}

class SCode{
    public String kwadracik(String message, int sq){
        char msg[] = message.toCharArray();
        int x = msg.length;
        int y = sq;
        char temp[][] = new char[y][x];
        if (x % y != 0) {
            System.out.println("Nie można zakodować, bo nie zgadza się długość boku do podanego tekstu!");
            System.exit(0);
        }
        int k=0;
        
        for (int i = 0; i < (x/y); i++) 
        {
            for (int j = 0; j < y; j++) 
            {
                temp[i][j] = msg[k];
                k++;
            }
        }
        char z = 'z';
        StringBuilder end = new StringBuilder();
        
        for (int j = 0; j < (x/y); j++) 
        {
            for (int i = 0; i < y; i++) 
            {
                z = temp[i][j];
                end.append(z); 
            }
        }
        String g = end.toString();
        return g;
    }
    
    public String dekwadracik(String message, int sq){
        char msg[] = message.toCharArray();
        int x = msg.length;
        int y = sq;
        char temp[][] = new char[y][x];
        if (x % y != 0) {
            System.out.println("Nie można odkodować, bo nie zgadza się długość boku do podanego tekstu!");
            System.exit(0);
        }
        int k=0;
        
        for (int j = 0; j < (x/y); j++) 
        {
            for (int i = 0; i < y; i++) 
            {
                temp[i][j] = msg[k];
                k++;
            }
        }
        char z = 'z';
        StringBuilder end = new StringBuilder();
        
        for (int i = 0; i < (x/y); i++) 
        {
            for (int j = 0; j < y; j++) 
            {
                z = temp[i][j];
                end.append(z); 
            }
        }
        String g = end.toString();
        return g;
    }
}

public class Projekt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "Cp1250");
        System.out.print("\n*************************************\n");
        System.out.print("         MASZYNA SZYFRUJĄCA");
        System.out.print("\n*************************************\n");
        System.out.print("Szyfr Cezara(1) czy Szyfr Kwadratowy(2)?\n");
        System.out.print("Wybór: ");
        int choice = 0;
        try{
            choice = in.nextInt();
        }
        catch(Exception e){
            System.out.print("Podano błędne dane!");
            System.out.println();
            return;
        }
        if (choice!=1 && choice!=2){
            System.out.print("Taka opcja nie istenieje!");
            System.out.println();
            return;
        }
        if(choice==1){
            Scanner Cin = new Scanner(System.in,"Cp1250");
            System.out.print("Chcesz zaszyfrować(1) czy odkodować(2)?\n");
            System.out.print("Wybór: ");
            int choice2 = 0;
            try{
                choice2 = Cin.nextInt(); 
            }
            catch(Exception e){
                System.out.print("Podano błędne dane!");
                System.out.println();
            return;
            }
            if (choice2!=1 && choice2!=2){
            System.out.print("Taka opcja nie istenieje!");
            System.out.println();
            return;
            }
            if(choice2==1){
                CCode c1 = new CCode();
                Scanner ct = new Scanner(System.in);
                System.out.print("Podaj tekst do zakodowania(bez wielkich liter i polskich znaków): ");
                String t1= ct.nextLine();
                Scanner cs = new Scanner(System.in);
                System.out.print("Podaj liczbę całkowitą do przesunięcia: ");
                int s1 = cs.nextInt();
                String message = c1.cezarek(t1, s1);
                System.out.print("Zakodowana wiadomość: \n");
                System.out.print(message);
                System.out.println();
                System.out.println();
            }
            else{
                CCode c2 = new CCode();
                Scanner cdt = new Scanner(System.in);
                System.out.print("Podaj tekst do odkodowania: ");
                String t2= cdt.nextLine();
                Scanner cds = new Scanner(System.in);
                System.out.print("Podaj liczbę całkowitą do przesunięcia(taką jaka była do zakodowania): ");
                int s2 = cds.nextInt();
                String message = c2.decezarek(t2, s2);
                System.out.print("Odkodowana wiadomość: \n");
                System.out.print(message);
                System.out.println();
                System.out.println();
            }
        }
        else{
            Scanner Sin = new Scanner(System.in,"Cp1250");
            System.out.print("Chcesz zaszyfrować(1) czy odkodować(2)?\n");
            System.out.print("Wybór: ");
            int choice3 = 0;
            try{
                choice3 = Sin.nextInt(); 
            }
            catch(Exception e){
                System.out.print("Podano błędne dane!");
                System.out.println();
            return;
            }
            if (choice3!=1 && choice3!=2){
            System.out.print("Taka opcja nie istenieje!");
            System.out.println();
            return;
            }
            if(choice3==1){
                SCode s1 = new SCode();
                Scanner st = new Scanner(System.in);
                System.out.print("Podaj tekst do zakodowania(bez wielkich spacji i polskich znaków): ");
                String t3= st.nextLine();
                Scanner ss = new Scanner(System.in);
                System.out.print("Podaj liczbę całkowitą do utworzenia boku: ");
                int s3 = ss.nextInt();
                String message = s1.kwadracik(t3, s3);
                System.out.print("Zakodowana wiadomość: \n");
                System.out.print(message);
                System.out.println();
                System.out.println();
                
            }
            else{
                SCode s2 = new SCode();
                Scanner sdt = new Scanner(System.in);
                System.out.print("Podaj tekst do odkodowania(bez wielkich liter, spacji i polskich znaków): ");
                String t4= sdt.nextLine();
                Scanner sds = new Scanner(System.in);
                System.out.print("Podaj liczbę całkowitą do utworzenia boku: ");
                int s4 = sds.nextInt();
                String message = s2.dekwadracik(t4, s4);
                System.out.print("Odkodowana wiadomość: \n");
                System.out.print(message);
                System.out.println();
                System.out.println();
            }
        }
        
        
    }
    
}

