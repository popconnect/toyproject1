package com.personal.combobox;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import com.personal.juice.sql.Beverage;
import com.personal.juice.sql.BeverageSearch;

public class BrandComboboxModel extends DefaultComboBoxModel<String> {
	
private ArrayList<Beverage> brands ;
	
	public BrandComboboxModel() {
		// TODO Auto-generated constructor stub
		brands = new ArrayList<>();
		Beverage to = new Beverage();
		to.setBrand("브랜드");
		brands.add(to);
	}
	
	public BrandComboboxModel(String strBrand) {
		BeverageSearch dao = new BeverageSearch();
		brands = dao.listBrand(strBrand);
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return brands.size();
	}
	
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		Beverage to = brands.get(index);
		return to.getBrand();
	}

}
