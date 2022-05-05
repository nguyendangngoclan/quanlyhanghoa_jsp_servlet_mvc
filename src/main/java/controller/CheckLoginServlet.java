package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.CheckLoginBO;

/**
 * Servlet implementation class CheckLoginServlet
 */
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");

		CheckLoginBO checkloginbo = new CheckLoginBO();
		RequestDispatcher rd = null;

		final int INVALID_ACCOUNT = 0;
		final int ADMIN_ACCOUNT = 1;
		//final int EMPLOYEE_ACCOUNT = 2;

		String accountInfor = null;
		HttpSession session = request.getSession();

		if(checkloginbo.getAccountRole(tenDangNhap, matKhau)== INVALID_ACCOUNT) {
			rd = request.getRequestDispatcher("login.jsp?error=2");
		}else if(checkloginbo.getAccountRole(tenDangNhap, matKhau)==ADMIN_ACCOUNT) {
			accountInfor = tenDangNhap + "(admin)";
			session.setAttribute("accountInfor", accountInfor);
			rd = request.getRequestDispatcher("welcomeAdmin.jsp");
		}else {
			accountInfor = tenDangNhap + "(user)";
			session.setAttribute("accountInfor", accountInfor);
			rd = request.getRequestDispatcher("welcomeEmployee.jsp");
		}
		rd.forward(request,response);
	}

}
