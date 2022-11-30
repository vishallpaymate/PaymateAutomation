package step_definitions;

public class TestJava {

    public static void main (String[] args){
        String str = "Welcome to Java";
        String[] splitwords = str.split(" ");
        String reversestring = "";

        for(String word : splitwords){
            StringBuffer sb = new StringBuffer(word);
            sb.reverse();
            reversestring=reversestring+sb.toString()+" ";
        }
        System.out.println(reversestring);
    }
}
