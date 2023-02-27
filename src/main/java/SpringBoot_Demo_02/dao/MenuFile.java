package SpringBoot_Demo_02.dao;

import com.google.gson.Gson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public class MenuFile {
    private File file=new File("/opt/dome/Spring_Boot_Demo_02/Menu/menu.txt");
    public MenuFile(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public HashMap<String, String[]> read(){
        HashMap<String ,String[]> map=new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            while ((read=reader.readLine())!=null){
                String[] str=read.split(":");
                String[] strings;
                if(str.length>1){
                    strings=str[1].split(",");
                }else {
                    strings=new String[1];
                }
                map.put(str[0],strings);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public boolean write(String s[]) {
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                String[] str = read.split(":");
                if (s[0].equals(str[0])) {
                    str[1] += "," + s[1];
                    b = true;
                }
                if(str.length>1) {
                    write += str[0] + ":" + str[1] + "\n";
                }else {
                    write+=str[0]+":\n";
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(write);
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b;
    }


}
