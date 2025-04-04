package CegepLimoilouCourSecurite.TP1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Scanner;

@RestController
public class RESTService
{
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/YouCantDOSMe")
    public void YouCantDOSMe()
    {
        try
        {
            String ip = request.getRemoteAddr();
            String ipConcat = ip.replace(":", "_");
            String ipFile = "./users_ip_file/" + ipConcat + ".txt";
            File fileUser = new File(ipFile);

            if(fileUser.exists() && !fileUser.isDirectory())
            {
                FileReader reader = new FileReader(ipFile);
                Scanner scanner = new Scanner(reader);
                String date = scanner.nextLine();

                if(date.equals(LocalDate.now().toString()))
                {
                    String nombreRequetesString = scanner.nextLine();

                    int nombreRequetes = Integer.parseInt(nombreRequetesString);

                    if (nombreRequetes < 10) {
                        nombreRequetes++;
                        FileWriter writer = new FileWriter(ipFile);
                        writer.write(LocalDate.now().toString() + "\n");

                        String nouveauNombreRequeteString = String.valueOf(nombreRequetes);
                        writer.write(nouveauNombreRequeteString);


                        writer.close();
                    }

                    int t = 0;
                }
            }
            else
            {
                fileUser.createNewFile();

                FileWriter writer = new FileWriter(ipFile);
                writer.write(LocalDate.now().toString() + "\n");
                writer.write("1");
                writer.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}