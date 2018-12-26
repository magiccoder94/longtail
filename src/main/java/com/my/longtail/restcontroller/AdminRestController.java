package com.my.longtail.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.longtail.AdminService;
import com.my.longtail.logger.Logger;
import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseType;
import com.my.longtail.property.Property;
import com.my.longtail.util.UserUtil;

@RestController
@RequestMapping(value = "/admincontroller")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	@Value("${upload-path}")
	private String uploadPath;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	@RequestMapping(value = "/get_franchise_list", method = RequestMethod.GET)
	private String getFranchiseList(){
		JSONObject jObjectResult = new JSONObject();
		JSONArray JARY = new JSONArray();
		
		//get user security context
		
		try {
			List<Franchise> franchises = adminService.getAllFranchise();
			
			for(Franchise franchise : franchises) {
				JSONObject jObject = new JSONObject();
				jObject.put("id", franchise.getId());
				jObject.put("company_name", franchise.getCompanyName());
				jObject.put("date_created", franchise.getDateCreated().toString().replace(" ", "T"));
				jObject.put("date_updated", franchise.getDateUpdated().toString().replace(" ", "T"));
				jObject.put("description", franchise.getDescriptionPackage());
				jObject.put("introduction", franchise.getIntroduction());
				jObject.put("franchisee_criteria", franchise.getFranchiseeCriteria());
				jObject.put("name", franchise.getName());
				jObject.put("img_url", franchise.getFranchiseLogoImg());
				jObject.put("category_id", franchise.getCategory().getId());
				jObject.put("franchise_type", franchise.getFranchiseType());
				jObject.put("user_interested", franchise.getInvestorInterested());
				
				JARY.put(jObject);
			}
			jObjectResult.put("data", JARY);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		return jObjectResult.toString();
	}
	
	@RequestMapping(value = "/get_category_list", method = RequestMethod.GET)
	private String getCategories() {
		JSONObject jObjectResult = new JSONObject();
		JSONArray JARY = new JSONArray();
		
		try {
			List<Category> categories = adminService.getAllCategories();
			for(Category category : categories) {
				JSONObject jObject = new JSONObject();
				jObject.put("id", category.getId());
				jObject.put("name", category.getName());
				JARY.put(jObject);
			}
			jObjectResult.put("data", JARY);
		}catch (Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		
		return jObjectResult.toString();
	}
	
	@RequestMapping(value = "/save_franchise", method = {RequestMethod.GET, RequestMethod.POST})
	private String saveFranchise(@RequestBody String formfield, HttpServletResponse response, HttpServletRequest request) {
		JSONObject jObjectResult = new JSONObject();
		Franchise franchise = new Franchise();
		Category category = null;
		
		try {
			JSONObject formfield_main = new JSONObject(formfield);
			JSONObject jObject = formfield_main.getJSONObject("formfield");
			int indicator = jObject.getInt("indicator");
			
			if(jObject.has("category_id"))
				category = adminService.getCategory(Long.valueOf(jObject.getString("category_id")));
			
			if(jObject.getInt("type") == 0)
				franchise.setFranchiseType(FranchiseType.SINGLE);
			else if(jObject.getInt("type") == 1)
				franchise.setFranchiseType(FranchiseType.AREA_MASTER);
			else if(jObject.getInt("type") == 2)
				franchise.setFranchiseType(FranchiseType.COUNTRY_MASTER);
			else if(jObject.getInt("type") == 3)
				franchise.setFranchiseType(FranchiseType.MULTIPLE);
			
			franchise.setCategory(category);
			if(indicator == 1)
				franchise.setDateCreated(new Date());
			else {
				franchise.setId(jObject.getLong("franchise_id"));
				franchise.setDateUpdated(new Date());
			}
			
			if(jObject.has("company_name"))
				franchise.setCompanyName(jObject.getString("company_name"));
			if(jObject.has("description_package"))
				franchise.setDescriptionPackage(jObject.getString("description_package"));
			if(jObject.has("short_description"))
				franchise.setShortDescription(jObject.getString("short_description"));
			if(jObject.has("introduction"))
				franchise.setIntroduction(jObject.getString("introduction"));
			if(jObject.has("franchisee_criteria"))
				franchise.setFranchiseeCriteria(jObject.getString("franchisee_criteria"));
			if(jObject.has("logo_img"))
				franchise.setFranchiseLogoImg(UserUtil.saveImageFile(jObject.getString("franchise_logo"), null, uploadPath));
			if(jObject.has("name"))
				franchise.setName(jObject.getString("name"));
			
			if(indicator == 1)
				franchise = adminService.saveFranchise(franchise);
			else
				franchise = adminService.updateFranchise(franchise);
			
			if(franchise != null) {
				if(indicator == 1)
					jObjectResult.put("msg", "Franchise Successfully Added.");
				else
					jObjectResult.put("msg", "Franchise Successfully Update");
				
				jObjectResult.put("franchise_id", franchise.getId());
				Logger.writeActivity("Franchise successfully created", foldername);
			}else {
				if(indicator == 1)
					jObjectResult.put("error", "Franchise Failed To Create, Please make sure all field are entered.");
				else
					jObjectResult.put("error", "Franchise Failed To Update, Please make sure all field are entered.");
				Logger.writeActivity("Franchise fail to save", foldername);
			}
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		
		return jObjectResult.toString();
	}
	
//	@RequestMapping(value = "/admincontroller/update_franchise", method = {RequestMethod.GET, RequestMethod.POST})
//	private String updateFranchise(@RequestBody String formfield, HttpServletResponse response, HttpServletRequest request) {
//		
//		return null;
//	}
	
	@RequestMapping(value = "/remove_franchise/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	private String removeFranchise(@PathVariable int franchiseId) {
		JSONObject jObjectResult = new JSONObject();
		
		try {
			if(adminService.removeFranchise(franchiseId)) {
				jObjectResult.put("msg", "Franchise has been removed.");
				Logger.writeActivity("franchise successfully removed", foldername);
			}else {
				jObjectResult.put("msg", "Franchise fail to be remove.");
				Logger.writeActivity("franchise fail to save", foldername);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		return jObjectResult.toString();
	}
	
	@RequestMapping(value = "/get_holding_list", method = RequestMethod.GET)
	public String getHoldingList() {
		return null;
	}
	
	@RequestMapping(value = "/get_franchise_with_participant", method = RequestMethod.GET)
	public String getFranchiseWithParticipant() {
		return null;
	}
}
