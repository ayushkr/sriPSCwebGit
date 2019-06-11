package in.srisrisri.psc.Document;

public class Document {
   private String name;
  private   String number;
  private   String content;
  private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
