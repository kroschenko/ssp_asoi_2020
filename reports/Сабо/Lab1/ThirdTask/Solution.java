package SSP.Lab1.ThirdTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>( Arrays.asList(args));
        String inStr;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while((inStr = reader.readLine())!= null && inStr.length() != 0){
            list.add(inStr);
        }
        for(String str : list){
            try {
                System.out.println( stripWhitespaces( str ) );
            }
            catch (NullPointerException e )
            {
                System.out.println("null");
            }
        }
    }
    public static String stripWhitespaces(String str){
      Pattern pattern =  Pattern.compile("\\S.*\\S?");
      Matcher matcher = pattern.matcher(str);
      String result =null;
      if(str == null)
          return null;
        while (matcher.find()) {
            result = str.substring(matcher.start(), matcher.end());
        }
        return result;
    }
}
