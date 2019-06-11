package in.srisrisri.psc.ayfilman;


import in.srisrisri.psc.responses.JsonResponse;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse extends JsonResponse {

private List<ResultOfSearch> resultOfSearchList=new ArrayList<>();

    public List<ResultOfSearch> getResultOfSearchList() {
        return resultOfSearchList;
    }

    public void setResultOfSearchList(List<ResultOfSearch> resultOfSearchList) {
        this.resultOfSearchList = resultOfSearchList;
    }
}
