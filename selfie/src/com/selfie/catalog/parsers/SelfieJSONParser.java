package com.selfie.catalog.parsers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.selfie.catalog.model.selfie;

public class SelfieJSONParser {
	
	public static List<selfie> parseFeed(String content) {
	
		try {
			JSONObject jobj=new JSONObject(content);			
			JSONArray ar = jobj.getJSONArray("data");
			List<selfie> flowerList = new ArrayList<>();
			for (int i = 0; i < ar.length(); i++) {
				JSONObject obj = ar.getJSONObject(i);
				JSONObject obj2=obj.getJSONObject("images");
				JSONObject obj3=obj2.getJSONObject("low_resolution");
				JSONObject obj4=obj.getJSONObject("user");
				JSONObject obj5=obj2.getJSONObject("standard_resolution");
				selfie selfie = new selfie();
//				flower.setProductId(obj.getInt("productId"));
				selfie.setName(obj4.getString("username"));
//				selfie.setCategory(obj.getString("category"));
				selfie.setInstructions(obj5.getString("url"));
				selfie.setPhoto(obj3.getString("url"));
//				selfie.setPrice(obj.getDouble("price"));
				
				flowerList.add(selfie);
			}
			
			return flowerList;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
