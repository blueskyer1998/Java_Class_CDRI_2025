package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 接收參數
		// 例如: http://localhost:8080/JavaWeb/welcome?name=Jack
		String hight = req.getParameter("h");
		String weight = req.getParameter("w");
		
		// 檢查age是否是數字
		if (!(Util.isDouble(hight) && Util.isDouble(weight))) {
			resp.getWriter().print("身高體重輸入錯誤");
			return;
		}
		
		// 計算 bmi 值
		double h = Double.parseDouble(hight);
		double w = Double.parseDouble(weight);
		double bmivalue = getBMIValue(h, w);
		String result = getBMIResult(bmivalue);
		
		//resp.getWriter().print("BMI 值 = " + bmivalue + "(" + result + ")");
		resp.getWriter().print(String.format("BMI 值 = %.2f (%s)", bmivalue, result));
	}

	// 計算 BMI 值
	private double getBMIValue(double h, double w) {
		return w / Math.pow(h/100, 2);
	}
	
	private String getBMIResult(double bmivalue) {
		return bmivalue < 18? "過輕" :(bmivalue >23 ? "過重" : "正常");
	}

	
}