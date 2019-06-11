package in.srisrisri.psc.login;


import in.srisrisri.psc.ayfilman.SearchResponse;
import in.srisrisri.psc.ayfilman.FileService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("")
public class LoginController {

    Logger logger=Logger.getLogger(LoginController.class);

    FileService fileService;
 

    @Autowired
    public LoginController(FileService fileService) {

        this.fileService=fileService;
      
    }
    
    @GetMapping("")
    public String get1(){
        System.out.println("test");
        String body="<h1><a href=\"psc/index.html\" >PSC</a></h1>";
        return body;
    }

    @PostMapping("login")
    public String login(final HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
     return "ok";
    }



    @PostMapping("checkThisCredentials")
    public @ResponseBody
    SearchResponse l(final HttpServletRequest request, final HttpServletResponse response){
        SearchResponse  searchResponse=new SearchResponse();
        //String keyLine=request.getParameter("keyLine");
        //logger.info("keyLine="+keyLine);
        //fileService.doNeedful(keyLine,searchResponse);

        return searchResponse;

    }
}
