package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/*
 * 可擴充: add(...)
 * 邏輯可分離: 條件與邏輯分開
 * 容易測試
 * 可以利用 lambda 開發與理解上較為值觀
 * */
public class PhonePlan {
	private Double callDurationInMinutes;
	private Double dataUsageInGB;
	
	// 建立一個內部類來代表一種咖啡類型的判斷規則
	static class PlanRule {
		// 咖啡類型名稱
		private String type;
		// 咖啡描述
		private String description;
		// 條件的判斷邏輯
		private BiPredicate<Double, Double> condition;
		
		public PlanRule(String type, String description, BiPredicate<Double, Double> condition) {
			this.type = type;
			this.description = description;
			this.condition = condition;
		}
		
		// 符合比對
		public boolean matches(Double callDurationInMinutes, Double dataUsageInGB) {
			return condition.test(callDurationInMinutes, dataUsageInGB);
		}
		
		public String getResult() {
			return type + ": " + description;
		}
		
	}
	
	// 可以儲存所有咖啡規則的清單
	private static final List<PlanRule> rules = new ArrayList<>();
	
	// 類別資料初始化區段
	static {
		// 初始化規則
		rules.add(new PlanRule("商務型($1499)", "通話 > 1000 分鐘 or 流量 > 50 GB", 
				(callDurationInMinutes, dataUsageInGB) -> callDurationInMinutes >1000 || dataUsageInGB >50));
		rules.add(new PlanRule("一般用戶型($660)", "通話 > 500 分鐘 and 流量 > 10 GB", 
				(callDurationInMinutes, dataUsageInGB) -> callDurationInMinutes >500 & dataUsageInGB >10));
		rules.add(new PlanRule("長輩節省型($200)", "流量 < 1 GB and 通話 < 200 分鐘", 
				(callDurationInMinutes, dataUsageInGB) -> callDurationInMinutes <200 & dataUsageInGB <1)); // milk == coffee

		
	}
	
	// Coffee 建構子
	public PhonePlan(Double callDurationInMinutes, Double dataUsageInGB) {
		this.callDurationInMinutes = callDurationInMinutes;
		this.dataUsageInGB = dataUsageInGB;
	}
	
	public PhonePlan(String callDurationInMinutes, String dataUsageInGB) {
		this(Double.parseDouble(callDurationInMinutes), Double.parseDouble(dataUsageInGB));
	}
	
	// 判斷咖啡類型
	public String getPhonePlanType() {
		return rules.stream()
					.filter(rule -> rule.matches(callDurationInMinutes, dataUsageInGB)) // 找出符合條件的規則
					.findFirst()                                // 取得第一筆匹配的
					//.map(CoffeeRule::getResult)                 // 傳換成字串
					.map(rule -> rule.getResult())                 // 傳換成字串
					.orElse("無法辨識的手機方案類型");
	}
	
	// Getter
	public Double getCallDurationInMinutes() {
		return callDurationInMinutes;
	}
	
	public Double getDataUsageInGB() {
		return dataUsageInGB;
	}
	
}
