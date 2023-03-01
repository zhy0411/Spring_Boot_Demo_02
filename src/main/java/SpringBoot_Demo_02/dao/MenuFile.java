package SpringBoot_Demo_02.dao;

import com.google.gson.Gson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


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

    //添加二级目录
    public boolean write2(String s[]) {
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

    //删除二级目录
    public boolean delete2(String[] s){
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                String[] str = read.split(":");
                if (s[0].equals(str[0])) {
                    List<String> list = Arrays.asList(str[1].split(","));
                    List<String> strings=new ArrayList<>(list);
                    String str1="";
                    for (int i = 0; i < strings.size(); i++) {
                        if(strings.get(i).equals(s[1])){
                            strings.remove(i--);
                        }
                    }
                    for (int i = 0; i < strings.size(); i++) {
                        if((i+1)!=strings.size()){
                            str1+=strings.get(i)+",";
                        }else {
                            str1+=strings.get(i);
                        }
                    }
                    str[1]=str1;
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

    //修改二级目录
    public boolean alter2(String[] s){
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                String[] str = read.split(":");
                if (s[0].equals(str[0])) {
                    String[] strings=str[1].split(",");
                    String str1="";
                    for (int i = 0; i < strings.length; i++) {
                        if(strings[i].equals(s[1])){
                            strings[i]=s[2];
                        }
                        if(i+1!=strings.length){
                            str1+=strings[i]+",";
                        }else {
                            str1+=strings[i];
                        }
                    }
                    str[1]=str1;
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

    public boolean delete1(String s){
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                String[] str = read.split(":");
                if (s.equals(str[0])) {
                    b = true;
                    continue;
                }
                write+=read+"\n";
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

    public boolean write1(String s){
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                write+=read+"\n";
            }
            write+=s+":";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(write);
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    public boolean alter1(String[] s){
        boolean b = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String read;
            String write = "";
            while ((read = reader.readLine()) != null) {
                String[] str = read.split(":");
                if (s[0].equals(str[0])) {
                    str[0]=s[1];
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
