package in.srisrisri.psc.question;

import in.srisrisri.psc.doctor.*;
import static in.srisrisri.psc.question.QuestionResource.readFile;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity(name = "Question") // this name will be used to name the Entity
@Table(name = "Question") // this name will be used to name a table in DB
public class QuestionEntity implements Serializable {

    

    long id_of_editor;
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    long id;
    @ColumnDefault(value = "0")
    long fixedId;
    String name;
  
    
    String answer;
    
     String myEditor;

  
 String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    
    
    public String getMyEditor() {
        return myEditor;
    }

    public void setMyEditor(String myEditor) {
        this.myEditor = myEditor;
    }

    public long getId_of_editor() {
        return id_of_editor;
    }

    public void setId_of_editor(long id_of_editor) {
        this.id_of_editor = id_of_editor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFixedId() {
        return fixedId;
    }

    public void setFixedId(long fixedId) {
        this.fixedId = fixedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    


}
