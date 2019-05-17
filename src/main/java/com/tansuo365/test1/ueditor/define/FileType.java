package com.tansuo365.test1.ueditor.define;

import java.util.HashMap;
import java.util.Map;

public class FileType {

    public static final String JPG = "JPG";
    public static final String PNG = "PNG";
    public static final String GIF = "GIF";
    public static final String BMP = "BMP";

    private static final Map<String,String> types = new HashMap<String,String>(){{
        put( FileType.JPG, ".jpg" );
        put( FileType.PNG, ".png" );
        put( FileType.GIF, ".gif" );
        put( FileType.BMP, ".bmp" );
    }};

    public static String getSuffix(String key){
        return FileType.types.get(key);
    }

    /**
     * 根据给定的文件名,获取其后缀信息
     * @param filename
     * @return
     */
    public static String getSuffixByFilename( String filename ){
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }
}
