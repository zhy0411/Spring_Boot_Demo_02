package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.dao.MenuFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class MenuServiceImpl {

    @Autowired
    private MenuFile menuFile;

    public MenuServiceImpl(){
        menuFile=new MenuFile();
    }

    public HashMap<String,String[]> read(){
        return menuFile.read();
    }

    public boolean write2(String[] s){
        return menuFile.write2(s);
    }
}
