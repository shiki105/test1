package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private int stock;
	private int buyItem_price;
	private String pay;
	public Map<String,Object> session;
	private String result;

	public String execute(){
		result=SUCCESS;

		session.put("stock",stock);
		int intStock=Integer.parseInt(session.get("stock").toString());
//		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		int intPrice=buyItem_price;

		System.out.println("-----------");
		System.out.println(intStock);
		System.out.println(buyItem_price);
		System.out.println(intStock * intPrice);
		System.out.println("-----------");

		session.put("buyItem_price",intStock * intPrice);
		String payment;

		if(pay.equals("1")){
			payment="現金支払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock=stock;
	}


	public int getBuyItem_price() {
		return buyItem_price;
	}

	public void setBuyItem_price(int buyItem_price) {
		this.buyItem_price = buyItem_price;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay=pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
