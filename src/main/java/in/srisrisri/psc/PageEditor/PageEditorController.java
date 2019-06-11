package in.srisrisri.psc.PageEditor;

import in.srisrisri.psc.Constants.Constants1;
import in.srisrisri.psc.ayfilman.FileService;
import in.srisrisri.psc.utils.FolderUtils;
import in.srisrisri.psc.Document.Document;
import in.srisrisri.psc.responses.SaveResponse;
import in.srisrisri.psc.ayfilman.SearchResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/PageEditor")
public class PageEditorController {
    Logger logger=Logger.getLogger(PageEditorController.class);

    FileService fileService;
 

    @Autowired
    public PageEditorController(FileService fileService ) {

        this.fileService=fileService;
      
    }


    @GetMapping("/help")
    public @ResponseBody
    SaveResponse    help(final HttpServletRequest request, final HttpServletResponse response){
        SaveResponse saveResponse=new SaveResponse();

        saveResponse.setStatus(Constants1.SUCCESS);
        saveResponse.setMessage("Help is ");

        return saveResponse;


    }



//    RedirectView
    @PostMapping("/save")
      public @ResponseBody
    SaveResponse    save(final HttpServletRequest request, final HttpServletResponse response){
SaveResponse saveResponse=new SaveResponse();
        Document document=new Document();


        String fileContent=request.getParameter("fileContent");
       String fileNumber= request.getParameter("fileNumber");
       document.setContent(fileContent);
       document.setNumber(fileNumber);
        document = fileService.save(document);
        saveResponse.setStatus(Constants1.SUCCESS);
        saveResponse.setMessage(document.getStatus());

       return saveResponse;
     //   return new RedirectView("/");

    }


    @GetMapping("/api/search")
    public @ResponseBody
    SearchResponse getMatches(final HttpServletRequest request, final HttpServletResponse response){
        SearchResponse  searchResponse=new SearchResponse();
        String keyLine=request.getParameter("keyLine");
        logger.info("keyLine="+keyLine);
        fileService.doNeedful(keyLine,searchResponse);

        return searchResponse;

    }


    @GetMapping("/api/open/{id}")
    public @ResponseBody
    SearchResponse getId(final HttpServletRequest request, final HttpServletResponse response,@PathVariable String id){
        SearchResponse  searchResponse=new SearchResponse();
        searchResponse.setMessage("id="+id);
        logger.info(id);
        File file=new File(FolderUtils.TDATA+File.separator+id);
if(file.exists()){
    try {
        Runtime.getRuntime().exec("nautilus "+file.getAbsolutePath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}else{
    try {
        Runtime.getRuntime().exec("nautilus "+FolderUtils.TDATA);
    } catch (IOException e1) {
        e1.printStackTrace();
    }

}


        return searchResponse;

    }

}
