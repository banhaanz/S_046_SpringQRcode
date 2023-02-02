package com.example.demo.constant;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    private static final Map<String,String> urlMap = new HashMap<>();

    public static Map<String,String> getIosMap(){
        urlMap.put("iosTLteam", "itms-services://?action=download-manifest&url=https://direct.thailife.com/tlappscenter/asset/MDAPlus/tlteamplus.plist");
        urlMap.put("iosTLpro", "itms-services://?action=download-manifest&url=https://direct.thailife.com/tlappscenter/asset/MDAPlus/prod-proplus.plist");
        urlMap.put("iosTLafter", "itms-services://?action=download-manifest&url=https://direct.thailife.com/tlappscenter/asset/MDAPlus/tlafterplus.plist");
        urlMap.put("iosTLrecruit", "itms-services://?action=download-manifest&url=https://direct.thailife.com/tlappscenter/asset/MDAPlus/tlrecruitplus.plist");
        return urlMap;
    }

    public static Map<String,String> getAndroidMap(){
        urlMap.put("androidTLteam", "https://direct.thailife.com/tlappscenter/asset/MDAPlus/TLTeamPlus.apk");
        urlMap.put("androidTLpro", "https://direct.thailife.com/tlappscenter/asset/MDAPlus/prod-tlproplus.apk");
        urlMap.put("androidTLafter", "https://direct.thailife.com/tlappscenter/asset/MDAPlus/TLAfterPlus.apk");
        urlMap.put("androidTLrecruit", "https://direct.thailife.com/tlappscenter/asset/MDAPlus/TLRecruitPlus.apk");
        return urlMap;
    }
}
