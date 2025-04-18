package servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;
import util.Util;

@WebServlet("/coffeeorder")
public class CoffeeOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 接收參數
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");

		// 判斷參數
		if(type == null || size == null || sugar == null) {
			resp.getWriter().print("參數輸入不正確");
			return;
		}
		
		String[] typearry = { "latte", "mocha", "americano", "cappuccino" };
		String[] sizearry = { "s", "m", "l" };
		String[] sugararry = { "yes", "no" };
		
		if (!(Arrays.asList(typearry).contains(type.toLowerCase()) && Arrays.asList(sizearry).contains(size.toLowerCase())
				&& Arrays.asList(sugararry).contains(sugar))) {
			resp.getWriter().print("參數輸入不正確");
			return;
		}

		// 進行業務邏輯
		CoffeeOrder coffeeOrder = new CoffeeOrder(type, size, sugar);
		//resp.getWriter().print(coffeeOrder.getInfo());
		
		// 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coffeeOrder);
		rd.forward(req, resp);
	}

}
