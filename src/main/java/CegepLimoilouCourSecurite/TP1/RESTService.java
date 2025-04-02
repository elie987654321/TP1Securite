package CegepLimoilouCourSecurite.TP1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTService
{
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/YouCantDOSMe")
    public void YouCantDOSMe()
    {
        String ip = request.getRemoteHost();
        System.out.println(ip);
    }
}