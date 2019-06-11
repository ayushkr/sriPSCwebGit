package in.srisrisri.psc.utils;

import java.io.File;
import java.util.*;

public class FolderUtils {
    public static String TSTORE="/media/radesh/ddrive/TSTORE";
    public static String TDATA="/media/radesh/ddrive/TSTORE/TDATA";

    public static Map<String,String> spring_boot_tutorial_keywords_all=new HashMap<>();

    public static Map<String, String> get_spring_boot_etc_keywords_from_keywordsFolder(){
        File f=new File(TSTORE+File.separator+"TKEYWORDS");
        System.out.println("Looking in "+f.getAbsolutePath());
        for (String s: f.list()){
            spring_boot_tutorial_keywords_all.put(s,"");
            System.out.println("putting keyword --> "+s);
        
        }

        return  spring_boot_tutorial_keywords_all;
    }


    public static List<String>  get_1472_1473_etc_list_for(String spring){
        List<String> _1472_1473_etc_list = new ArrayList<>();

        File f=new File(TSTORE+File.separator+"TKEYWORDS"+File.separator+spring);


        _1472_1473_etc_list= Arrays.asList(f.list());
        System.out.println("Listing 1472 s in "+f.getAbsolutePath()+"\n as "+_1472_1473_etc_list.toString() );

        return _1472_1473_etc_list;

    }

    public static void main(String[] args) {
        get_1472_1473_etc_list_for("spring");
        get_1472_1473_etc_list_for("boot");
    }

}


