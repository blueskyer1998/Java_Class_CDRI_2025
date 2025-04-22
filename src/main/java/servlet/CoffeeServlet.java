package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Coffee;


@WebServlet("/coffee")
public class CoffeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收表單資料
		// 1.請求編碼
		req.setCharacterEncoding("UTF-8");
		
		// 2.接收參數
		String milkAmount = req.getParameter("milk");
		String coffeeAmount = req.getParameter("coffee");
		
		// 3.將參數資料注入到 Model 中(User.java)
		Coffee coffee = new Coffee(milkAmount, coffeeAmount);
		
		// 4.分派到 /WEB-INF/coffee_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		req.setAttribute("coffee", coffee); // 將 coffee 資料物件傳給 jsp
		rd.forward(req, resp);
		
	}
	
	
	
}
