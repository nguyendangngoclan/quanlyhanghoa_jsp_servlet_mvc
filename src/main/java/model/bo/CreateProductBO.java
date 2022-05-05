package model.bo;

import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateProductDAO;

public class CreateProductBO {

	CreateProductDAO createProductDAO = new CreateProductDAO();

	public String insertProduct(String tenHH, String dvt, String donGiaTK, String ghiChu) {
		String returnedString = null;
		String tempValidate = ValidateCommon.validateProduct(tenHH, dvt, donGiaTK, ghiChu);

        if (!"No error".equals(tempValidate)) {

                return tempValidate;

        }
		
		for (int i = 1; i <= 10; i++) {
			String lastestMaHH = createProductDAO.getLastestMaHH();
			if (lastestMaHH == null) {
				lastestMaHH = "HH001";
			} else {
				 long orderNumber = Long.valueOf(lastestMaHH.substring(2, 5));
                 orderNumber++;
                 lastestMaHH = "HH" + StringCommon.convertNumberToString(orderNumber, 3);
			}
			String returnedMessage = createProductDAO.insertProduct(lastestMaHH, tenHH, dvt, donGiaTK, ghiChu);
			System.out.println("Lần " + i + " --- lastestMaHH --- " + lastestMaHH + " --- returnedMessage --- " + returnedMessage);
			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;
			} else if ("Invalid DGTK error".equals(returnedMessage)) {
					returnedString = "Invalid DGTK error";
					continue;
			} else if ("No error".equals(returnedMessage)) {
				returnedString = "No error";
				break;
			}
		}
	
		return returnedString;
	}
}
