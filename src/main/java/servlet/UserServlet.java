package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收表單資料
		// 1.請求編碼
		req.setCharacterEncoding("UTF-8");
		
		// 2.接收參數
		String userName = req.getParameter("userName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		// 3.將參數資料注入到 Model 中(User.java)
		User user = new User(userName, gender, age, height, weight);
		
		// 4.分派到 /WEB-INF/user_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_result.jsp");
		req.setAttribute("user", user); // 將 user 資料物件傳給 jsp
		rd.forward(req, resp);
		
	}
	
	
	
}
