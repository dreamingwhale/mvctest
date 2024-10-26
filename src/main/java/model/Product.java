package model;

/**
 * 商品クラス
 * @author M.Takahashi
 */
public class Product {
	/******** フィールド ******************************************/
	/**
	 * 商品ID
	 */
	private String id;
	
	/**
	 * 商品名
	 */
	private String name;
	
	/**
	 * 価格
	 */
	
	private int price;
	
	/*
	 * 
	 * 20241024_16:30 追加
	 * 
	 */
	
	private String imgSource;
	
	private int amount;
	
	

	/******** コンストラクタ **************************************/
	/**
	 * フィールド初期化コンストラクタ
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(String id, String name, int price , String imgSource) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgSource = imgSource;
		this.amount = 0;
	}
	
	public Product(String id, String name, int price , String imgSource, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgSource = imgSource;
		this.amount = amount;
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	

	/**
	 * 価格を文字列で返す（３桁カンマ区切り＋"円"）
	 * @return 価格 + 円
	 */
	public String getPriceString() {
		return String.format("%,d", price) + "円";
	}

	public String getImgSource() {
		return imgSource;
	}
	
	public int getAmount() {
		return amount;
	}
	
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
