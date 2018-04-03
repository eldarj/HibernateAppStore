package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KonzolniAlat {
    public static String ucitajString()
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String result;
        try
        {
            result = reader.readLine();
        } catch (IOException e)
        {
            result = "";
        }
        return result;
    }

    public static Integer ucitajInteger()
    {
        final String s = ucitajString();
        return Integer.parseInt(s);
    }

    public static Float ucitajFloat() {
        final String s = ucitajString();
        return Float.parseFloat(s);
    }
}
