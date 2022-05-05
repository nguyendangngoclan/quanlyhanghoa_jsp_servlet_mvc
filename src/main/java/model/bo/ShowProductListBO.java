package model.bo;

import java.util.ArrayList;

import model.bean.HangHoa;
import model.dao.ShowProductListDAO;

public class ShowProductListBO {
	ShowProductListDAO showProductListDAO = new ShowProductListDAO();
	public ArrayList<HangHoa> getDsHangHoa() {
		// TODO Auto-generated method stub
		return showProductListDAO.getDsHangHoa();
	}
	public  ArrayList<HangHoa> getDsHangHoa(int pageNumber) {
		// TODO Auto-generated method stub
		return showProductListDAO.getDsHangHoaBySQL(pageNumber);
	}
	public int getTotalPageNumber() {
		// TODO Auto-generated method stub
		return showProductListDAO.getTotalPageNumber();
	}

}
