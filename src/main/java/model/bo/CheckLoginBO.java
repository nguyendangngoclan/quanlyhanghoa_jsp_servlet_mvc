package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	
	
	CheckLoginDAO checkLoginDao = new CheckLoginDAO();
	
	public int getAccountRole(String tenDangNhap, String matKhau) {
		// TODO Auto-generated method stub
		return checkLoginDao.getAccountRole(tenDangNhap,matKhau);
	}

}
