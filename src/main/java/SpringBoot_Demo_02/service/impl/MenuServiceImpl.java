package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.dao.MenuFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MenuServiceImpl {

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

    public boolean write1(String s){
        return menuFile.write1(s);
    }

    public boolean alter1(String[] s){
        return menuFile.alter1(s);
    }

    public boolean alter2(String[] s){
        return menuFile.alter2(s);
    }

    public boolean delete2(String[] s){
        return menuFile.delete2(s);
    }

    public boolean delete1(String s){
        return menuFile.delete1(s);
    }
}
