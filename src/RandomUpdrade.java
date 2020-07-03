import java.util.*;

public class RandomUpdrade extends Random {
    // returns a random number between l and h.
    public int nextInt(int l, int h){
        if (l < h){
            int randomNumber = nextInt(h-l+1) + l;
            return randomNumber;
        }
        else{
            System.out.println("Invalid bounds");
            return -1;
        }
    }

    // returns a random even number between 0 and h.
    public int nextEven(int h){
        if (h >= 0){
            int randomNumber = nextInt(h/2 + 1) * 2;
            return randomNumber;
        }
        else{
            System.out.println("Invalid bounds");
            return -1;
        }
    }

    // returns a random even number between l and h.
    // returns -1 if l >= h.
    public int nextEven(int l, int h){
        if (l < h){
            if(l%2 == 0 && h%2 == 0){
                int randomNumber = l + nextInt((h-l)/2 + 1) * 2;
                return randomNumber;
            }
            else if (l%2 == 0 && h%2 == 1){
                int randomNumber = l + nextInt((h-l)/2 + 1) * 2;
                return randomNumber;
            }
            else if (l%2 == 1 && h%2 == 0){
                int randomNumber = l + nextInt((h-l)/2 + 1) * 2 + 1;
                return randomNumber;
            }
            else if (l%2 == 1 && h%2 == 1){
                int randomNumber = l + nextInt((h-l)/2) * 2 + 1;
                return randomNumber;
            }
            else{
                System.out.println("Invalid bounds");
                return -1;
            }
        }
        else{
            System.out.println("Invalid bounds");
            return - 1;
        }
    }

    // returns a random odd number between 1 and h.
    public int nextOdd(int h){
        if (h >= 1){
            int randomNumber = nextEven(h-1) + 1;
            return randomNumber;
        }
        else{
            System.out.println("Invalid bounds");
            return -1;
        }
    }

    // returns a random off number between l and h.
    // returns -1 if l >= h.
    public int nextOdd(int l, int h){
        if (l < h){
            if (l%2 == 0 && h%2 == 0){
                int randomNumber = l + nextInt((h-l)/2) * 2 + 1;
                return randomNumber;
            }
            else if (l%2 == 0 && h%2 == 1){
                int randomNumber = l + nextInt((h-l)/2+1) * 2 + 1;
                return randomNumber;
            }
            else if (l%2 == 1 && h%2 == 0){
                int randomNumber = l + nextInt((h-l)/2+1) * 2;
                return randomNumber;
            }
            else if (l%2 == 1 && h%2 == 1){
                int randomNumber = l + nextInt((h-l)/2+1) * 2;
                return randomNumber;
            }
            else{
                System.out.println("Invalid bounds");
                return -1;
            }
        }
        else{
            System.out.println("Invalid bounds");
            return -1;
        }
    }

    // returns a random uppercase character.
    public char nextChar(){
        int randomNumber = nextInt(26) + 65;
        return (char) randomNumber;
    }

    // returns a random uppercase character between l and h.
    public char nextChar(char l, char h){
        l = Character.toUpperCase(l);
        h = Character.toUpperCase(h);
        if ((int) l < (int) h){
            int randomNumber = nextInt((int) l, (int) h);
            return (char) randomNumber;
        }
        else if(l == h){
            return l;
        }
        else{
            int counter = 0;
            for (int i = l; i <= 90; i++){
                counter++;
            }
            for (int j = h; j >= 65; j--){
                counter++;
            }
            char[] characters = new char[counter];
            int index = 0;
            while (l <= 90){
                characters[index] = l;
                index++;
                l++;
            }
            while (h >= 65){
                characters[index] = h;
                index++;
                h--;
            }

            int randomNumber = nextInt(counter);
            return characters[randomNumber];
        }
    }

    // returns a random six-digit password.
    public int nextSixDigitPassword(){
        int randomPassword = nextInt(100000, 999999);
        return randomPassword;
    }

    // returns a word w that is in a random order.
    public String nextWord(String w){
        char[] word = new char[w.length()];
        for (int i = 0; i < w.length(); i++){
            word[i] = w.charAt(i);
        }
        String nextWord = "";
        int j = 0;
        while (j < word.length){
            int randomIndex = nextInt(w.length());
            if (word[randomIndex] != ' '){
                nextWord = nextWord + word[randomIndex];
                word[randomIndex] = ' ';
                j++;
            }
            else{

            }
        }
        return nextWord;
    }

    public String nextPassword(){
        String password = "";
        int randomLength = nextInt(6, 10);
        for (int i = 0; i < randomLength; i++){
            int x = nextInt(0,1);
            if (x == 0){
                password += nextChar();
            }
            else{
                password += nextInt(0,9);
            }
        }
        return password;
    }
}