package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

// 冰果店
@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet {
	
	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		
		// ✅ 驗證 CAPTCHA
		String captchaToken = req.getParameter("captchaToken");
		if (captchaToken == null || captchaToken.trim().isEmpty()) {
			req.setAttribute("captchaError", "請先完成 CAPTCHA 驗證！");
			req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
			return;
		}
		
		String orderIndex = req.getParameter("orderindex");
		if (orderIndex != null) {
			iceOrders.remove(Integer.parseInt(orderIndex));
		} else {
			// 接收表單參數
			String mainDishName = req.getParameter("mainDish");
			String[] toppingArray = req.getParameterValues("toppings");
			// 建立 IceOrder
			IceOrder iceOrder = new IceOrder(mainDishName, toppingArray);
			// 加入到訂單集合
			iceOrders.add(iceOrder);
		}
		
		// 重導到 jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("iceOrders", iceOrders);
		rd.forward(req, resp);
	}
	
	
}
