package in.srisrisri.psc.ayfilman;

import in.srisrisri.psc.utils.FileUtils;
import in.srisrisri.psc.utils.FolderUtils;
import in.srisrisri.psc.Document.Document;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;

@Service
public class FileService {
    Logger logger = Logger.getLogger(FileService.class);


    public Document save(Document document) {
        //
        logger.info("saving " + document);
        try {
            String savedLocation = FileUtils.writeFile("userData/" + document.getNumber() + ".html", document.getContent());
            document.setStatus("saved to " + savedLocation);
            return document;
        } catch (IOException e) {
            e.printStackTrace();
            document.setStatus(e.toString());
            return document;
        }

    }

    Map<String, List<String>> _1472_mapped_to__ayittulla_spring_map = new HashMap<>();
    Map<String, List<String>> order = new HashMap<>();

    public void doNeedful(String spring_boot_tutorial_line, SearchResponse searchResponse) {
        _1472_mapped_to__ayittulla_spring_map = new HashMap<>();
        order = new HashMap<>();
        //String spring_boot_tutorial_line = "spring boot tutorial";
        String[] spring_boot_tutorial_array = spring_boot_tutorial_line.split(" ");
        for (String spring : spring_boot_tutorial_array) {
            List<String> _1472_1473_etc_list = FolderUtils.get_1472_1473_etc_list_for(spring);
            for (String _1472 : _1472_1473_etc_list) {
                if (!_1472_mapped_to__ayittulla_spring_map.containsKey(_1472)) {
                    _1472_mapped_to__ayittulla_spring_map.put(_1472, new ArrayList<>());
                }
                List<String> spring_boot_etc_of_1472_list = _1472_mapped_to__ayittulla_spring_map.get(_1472);

                spring_boot_etc_of_1472_list.add(spring);

            }

        }

        createOrder();
        System.out.println("========== weight ==============");
        Set<String> _1_2_etc_set = order.keySet();
        List<String> _1_2_etc_list = new ArrayList<String>();
        _1_2_etc_list.addAll(_1_2_etc_set);

        Collections.sort(_1_2_etc_list, Collections.reverseOrder());


        _1_2_etc_list.forEach(_1 -> {
            ResultOfSearch resultOfSearch=new ResultOfSearch();

            //System.out.println("weight : " + _1);
            resultOfSearch.setWeight(_1);

            List<String> _1472_etc = order.get(_1);

            _1472_etc.forEach(_1472 -> {

                //System.out.println("\tName : " + _1472);
                resultOfSearch.setName(_1472);

                List<String> spring_boot_etc = _1472_mapped_to__ayittulla_spring_map.get(_1472);
                //System.out.print("\t\twords:");

                spring_boot_etc.forEach(spring -> {
                    //System.out.print("," + spring);
                  //  resultOfSearch.getWords().add(spring);
                });
               // System.out.println("");
            });

            System.out.println("000 "+resultOfSearch.toString());
            List<ResultOfSearch> resultOfSearchList = searchResponse.getResultOfSearchList();
           resultOfSearchList.add(resultOfSearch);
        });


    }


    public void createOrder() {
        for (String _1472 : _1472_mapped_to__ayittulla_spring_map.keySet()) {


            List<String> spring_boot_etc_list = _1472_mapped_to__ayittulla_spring_map.get(_1472);
            int spring_boot_etc_list_size = spring_boot_etc_list.size();
            System.out.println("for _1472=" + _1472 + " (size =" + spring_boot_etc_list_size + ") is having  ");


            if (order.containsKey(spring_boot_etc_list_size + "")) {
                System.out.println(spring_boot_etc_list_size + " already exists  ");

            } else {
                System.out.println(spring_boot_etc_list_size + " Not  exists  ");
                order.put(spring_boot_etc_list_size + "", new ArrayList<String>());
            }

            System.out.println("order now contains ");
            order.forEach((k, v) -> {
                System.out.println(k + " --> " + v);
            });


            (order.get(spring_boot_etc_list_size + "")).add(_1472);


            for (String spring : spring_boot_etc_list) {

                System.out.println("\t--- " + spring + "\t\t in spring_boot_etc_list");
            }

            System.out.println("order now contains ");
            order.forEach((k, v) -> {
                System.out.println(k + " --> " + v);
            });
        }


    }


    public List<String> get_1472_1473_etc_list_for_mock(String spring) {
        List<String> _1472_1473_etc_list = new ArrayList<>();

        if (StringUtils.equalsIgnoreCase(spring, "spring")) {
            _1472_1473_etc_list.add("1472");
            _1472_1473_etc_list.add("1473");
            _1472_1473_etc_list.add("1474");
            _1472_1473_etc_list.add("1476");
        }

        if (StringUtils.equalsIgnoreCase(spring, "tutorial")) {
            _1472_1473_etc_list.add("1472");
            _1472_1473_etc_list.add("1474");
            _1472_1473_etc_list.add("1476");
        }

        if (StringUtils.equalsIgnoreCase(spring, "boot")) {
            _1472_1473_etc_list.add("1472");
            _1472_1473_etc_list.add("1476");
        }


        return _1472_1473_etc_list;
    }


    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.doNeedful("spring boot tutorial", null);
    }
}


class _1472_box {
    int size_;
    List<String> spring_boot_etc_list = new ArrayList<>();

}
