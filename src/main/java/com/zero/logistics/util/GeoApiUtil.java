package com.zero.logistics.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName : GeoApiUtil
 * @Description : TODO
 * @Author : 郑思华
 * @Date: 2020-04-20 09:42
 */
public class GeoApiUtil {

    private static final String GEO_KEY = "2ea608f756a18c1ed363e50f3db805bf";

    /**
     * 获取经纬度
     * @param address
     * @return
     */
    public static String GetLonLat(String address) {
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo"; //高德接口
        String param = "key=" + GEO_KEY + "&address=" + address;
        String queryResult = HttpRequestUtil.sendGet(queryUrl,param); //请求接口数据
        String location = null; //经度纬度
        //字符串转换成json格式
        JSONObject jsonObject = JSONObject.parseObject(queryResult);
        if (1 == jsonObject.getInteger("status")) //成功
        {
            JSONArray geoCodes = jsonObject.getJSONArray("geocodes");
            if (geoCodes.size() > 0) {
                //获取经度纬度
                location = geoCodes.getJSONObject(0).getString("location");
            }
        }
        return location;
    }

    /**
     * 获取起始地到目的地的距离（支持多个起始地）
     * @param startLonLat 起始地经度、纬度（多个时用"|"分隔）
     * @param endLonLat   目的地经度、纬度
     * @param type        0：直线距离 1(默认)：驾车导航距离（仅支持国内坐标）。3：步行规划距离（仅支持5km之间的距离）
     * @return 结果列表
     */
    public static JSONArray GetDistance(String startLonLat, String endLonLat, int type) {
        String queryUrl = "http://restapi.amap.com/v3/distance"; //高德接口
        String param = "key=" + GEO_KEY + "&origins=" + startLonLat + "&destination=" + endLonLat + "&type=" + type;
        //请求接口数据
        String queryResult = HttpRequestUtil.sendGet(queryUrl, param);
        //字符串转换成json格式
        JSONObject jsonObject = JSONObject.parseObject(queryResult);
        if (1 == jsonObject.getIntValue("status")) //成功
        {
            JSONArray results = jsonObject.getJSONArray("results");
            return results;
        }
        return null;
    }

    /**
     * 获取多个起始地到目的地最小直线距离的索引
     * @param startLonLat 起始地经度、纬度（用"|"分隔）
     * @param endLonLat   目的地经度、纬度
     * @return 最小距离的索引  -1:出错
     */
    public static int getMinDistanceIndex(String startLonLat, String endLonLat) {
        JSONArray results = GetDistance(startLonLat, endLonLat, 0);
        if (null == results)
            return -1;
        int index = 0;
        long minDistance = results.getJSONObject(0).getLongValue("distance");
        for (int i = 1; i < results.size(); i++) {
            long distance = results.getJSONObject(1).getLongValue("distance");
            if (minDistance > distance) {
                minDistance = distance;
                index = i;
            }
        }
        return index;
    }

    /**
     * 根据地址获取最近的地址索引
     * @param startAddrList 开始地址列表
     * @param endAddress 结束地址
     * @return 最近的地址索引
     */
    public static int getMinDistanceIndexByAddr(List<String> startAddrList, String endAddress){
        if (startAddrList == null)
            return -1;
        String endLonLat = GetLonLat(endAddress);
        StringBuilder stringBuilder = new StringBuilder();
        startAddrList.forEach(a->{
            stringBuilder.append(GetLonLat(a)+"%7C");
        });
        return getMinDistanceIndex(stringBuilder.toString(), endLonLat);
    }
}
