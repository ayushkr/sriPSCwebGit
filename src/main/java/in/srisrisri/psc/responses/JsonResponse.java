package in.srisrisri.psc.responses;
        import com.fasterxml.jackson.annotation.JsonIgnore;
import in.srisrisri.psc.Constants.Constants1;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;

public class JsonResponse
{
    private String status = Constants1.SUCCESS;

    private String sessionExpired = Constants1.FALSE;

    private String message = Constants1.EMPTY;

    private HashMap<String,Object> map=new HashMap<>();

    public JsonResponse()
    {

    }

    /**
     * @return the map
     */
    public HashMap<String, Object> getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public JsonResponse(String status, String sessionExp, String message)
    {
        this.status = status;
        this.sessionExpired = sessionExp;
        this.message = message;
    }

    @JsonIgnore
    public static JsonResponse createNoTokenIdResponse() {
        return new JsonResponse(Constants1.FAILURE, Constants1.TRUE, Constants1.NO_TOKEN_ID_FOUND);
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getSessionExpired()
    {
        return sessionExpired;
    }

    public void setSessionExpired(String sessionExpired)
    {
        this.sessionExpired = sessionExpired;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setErrorMessages(List<String> validationErrors)
    {
        this.message = StringUtils.join(validationErrors, Constants1.LINE_SEPERATOR);
    }
}
