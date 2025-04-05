package CegepLimoilouCourSecurite.TP1;

import java.util.regex.Matcher;

public class Traitement
{
    public static long CalculerUnGrandNombre()
    {
        long resultat = 0;

        for(int i = 0; i < 200000; i++)
        {
            resultat += Math.random() * i;
        }

        return resultat;
    }
}
