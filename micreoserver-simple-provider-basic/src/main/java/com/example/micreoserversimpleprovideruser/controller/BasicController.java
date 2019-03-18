package com.example.micreoserversimpleprovideruser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.example.micreoserversimpleprovideruser.bean.HygCart;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;




@RestController
public class BasicController {
  
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/Basic/{skuId}")
	public String getBasicInfo(@PathVariable("skuId")String skuId)
	{ Map<String, Object> map = new HashMap<String, Object>();  
    //商品编号  
    map.put("skuId", skuId);  
    //名称  
    map.put("name", "苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机");  
    //一级二级三级分类  
    map.put("ps1Id", 9987);  
    map.put("ps2Id", 653);  
    map.put("ps3Id", 655);  
    //品牌ID  
    map.put("brandId", 14026);  
    //图片列表  
    map.put("imgs", getImgs(skuId));  
    //上架时间  
    map.put("date", "2014-10-09 22:29:09");  
    //商品毛重  
    map.put("weight", "400");  
    //颜色尺码  
    map.put("colorSize", getColorSize(skuId));  
    //扩展属性  
    map.put("expands", getExpands(skuId));  
    //规格参数  
    map.put("propCodes", getPropCodes(skuId));  
    map.put("date", System.currentTimeMillis());  
    String content = JSON.toJSONString(map);  
    //实际应用应该是发送MQ  
    asyncSetToRedis( "p:" + skuId + ":", content);  
    return content;  
	}
	private void asyncSetToRedis(String string, String content) {
		redisTemplate.opsForHash().put("Desc",string,content);
		
	}
	private List<String> getImgs(String skuId) {  
	    return Lists.newArrayList(  
	            "jfs/t277/193/1005339798/768456/29136988/542d0798N19d42ce3.jpg",  
	            "jfs/t352/148/1022071312/209475/53b8cd7f/542d079bN3ea45c98.jpg",  
	            "jfs/t274/315/1008507116/108039/f70cb380/542d0799Na03319e6.jpg",  
	            "jfs/t337/181/1064215916/27801/b5026705/542d079aNf184ce18.jpg"  
	    );  
	}  
	  
	private List<Map<String, Object>> getColorSize(String skuId) {  
	    return Lists.newArrayList(  
	        makeColorSize(1217499, "金色", "公开版（16GB ROM）"),  
	        makeColorSize(1217500, "深空灰", "公开版（16GB ROM）"),  
	        makeColorSize(1217501, "银色", "公开版（16GB ROM）"),  
	        makeColorSize(1217508, "金色", "公开版（64GB ROM）"),  
	        makeColorSize(1217509, "深空灰", "公开版（64GB ROM）"),  
	        makeColorSize(1217509, "银色", "公开版（64GB ROM）"),  
	        makeColorSize(1217493, "金色", "移动4G版 （16GB）"),  
	        makeColorSize(1217494, "深空灰", "移动4G版 （16GB）"),  
	        makeColorSize(1217495, "银色", "移动4G版 （16GB）"),  
	        makeColorSize(1217503, "金色", "移动4G版 （64GB）"),  
	        makeColorSize(1217503, "金色", "移动4G版 （64GB）"),  
	        makeColorSize(1217504, "深空灰", "移动4G版 （64GB）"),  
	        makeColorSize(1217505, "银色", "移动4G版 （64GB）")  
	    );  
	}  
	private Map<String, Object> makeColorSize(long skuId, String color, String size) {  
	    Map<String, Object> cs1 = Maps.newHashMap();  
	    cs1.put("SkuId", skuId);  
	    cs1.put("Color", color);  
	    cs1.put("Size", size);  
	    return cs1;  
	}  
	  
	private List<List<?>> getExpands(String skuId) {  
	    return Lists.newArrayList(  
	            (List<?>)Lists.newArrayList("热点", Lists.newArrayList("超薄7mm以下", "支持NFC")),  
	            (List<?>)Lists.newArrayList("系统", "苹果（IOS）"),  
	            (List<?>)Lists.newArrayList("系统", "苹果（IOS）"),  
	            (List<?>)Lists.newArrayList("购买方式", "非合约机")  
	    );  
	}  
	  
	private Map<String, List<List<String>>> getPropCodes(String skuId) {  
	    Map<String, List<List<String>>> map = Maps.newHashMap();  
	    map.put("主体", Lists.<List<String>>newArrayList(  
	            Lists.<String>newArrayList("品牌", "苹果（Apple）"),  
	            Lists.<String>newArrayList("型号", "iPhone 6 A1586"),  
	            Lists.<String>newArrayList("颜色", "金色"),  
	            Lists.<String>newArrayList("上市年份", "2014年")  
	    ));  
	    map.put("存储", Lists.<List<String>>newArrayList(  
	            Lists.<String>newArrayList("机身内存", "16GB ROM"),  
	            Lists.<String>newArrayList("储存卡类型", "不支持")  
	    ));  
	    map.put("显示", Lists.<List<String>>newArrayList(  
	            Lists.<String>newArrayList("屏幕尺寸", "4.7英寸"),  
	            Lists.<String>newArrayList("触摸屏", "Retina HD"),  
	            Lists.<String>newArrayList("分辨率", "1334 x 750")  
	    ));  
	    return map;  
	}  
	
}
