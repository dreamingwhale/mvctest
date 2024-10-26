package model;

//Iteratorを追加
import java.util.Iterator;
import java.util.List;



/**
 * カート情報を表すクラス
 * @author M.Takahashi
 */
public class Cart {
	
	/*
	 * Cartの注文番号を追加して重複を避ける機能を追加
	 */
	private int orderId;
	
	
	/******** フィールド ******************************************/
	/**
	 * ユーザーID
	 */
	private String userId;

	/**
	 * カート内の商品リスト
	 */
	private List<Product> listProd;

	/******** コンストラクタ **************************************/
	/**
	 * フィールド初期化コンストラクタ
	 * @param userId
	 * @param listProd
	 */
	public Cart(String userId, List<Product> listProd) {
		this.userId = userId;
		this.listProd = listProd;
		System.out.println(lastIndexOfProd());
		//this.orderId = lastIndexOfProd();
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return listItem
	 */
	public List<Product> getListProd() {
		return listProd;
	}

	/*--------------------通常メソッド--------------------*/
	/**
	 * カートに商品を追加する
	 * @param prod 追加する商品
	 */
	public void add(Product prod) {
		listProd.add(prod);
	}

	
	/*
	 * 
	 * 20241024 17:32 amountを一省に追加するメソッド追加
	 * 
	 */
	public void add(Product prod, int amount) {
		prod.setAmount(amount);
		listProd.add(prod);
	}
	
	/**
	 * カート内の特定の商品を除去する
	 * @param index 削除する商品のリスト内のインデックス
	 */
	public void remove(int index) {
		listProd.remove(index);
	}
	
	/**
	 * カート内の全ての商品を除去する
	 */
	public void clear() {
		listProd.clear();
	}
	
	/**
	 * カート内の商品の合計金額を取得する
	 * @return 合計金額
	 */
	public int getTotalPrice() {
		int total = 0;
		for (Product prod : listProd) {
			total += prod.getPrice()*prod.getAmount();
		}
		
		return total;
	}
	
	/**
	 * カート内の商品の合計金額を文字列にして返す(３桁カンマ区切り＋円)
	 * @return
	 */
	public String getTotalPriceString() {
		return String.format("%,d", getTotalPrice()) + "円";
	}

	public int lastIndexOfProd() {
		Iterator it = listProd.iterator();
		int value = 0;
		while(it.hasNext())
		{
		    value  = (Integer)it.next();
		}
		
		return value;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
