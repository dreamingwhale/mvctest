package model;

import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

public class Moperation {
	/**
	 * ログイン時の処理
	 * @param userId リクエストパラメータ
	 * @param password リクエストパラメータ
	 * @param session セッションオブジェクト
	 * @return true .. 正常、false .. ID／パスワード誤り
	 */
	public boolean loginProc(String userId, String password, HttpSession session) {

		// ログイン認証
		boolean result = authenticate(userId, password);

		if (result) {
			// 店舗データの作成⇒セッションに格納
			Store store = makeStore();
			session.setAttribute("store", store);
			
			// カート情報の作成（userId設定・商品リストは空）⇒セッションに格納
			Cart cart = new Cart(userId, new ArrayList<Product>());
			session.setAttribute("cart", cart);
		}

		return result;
	}

	/**
	 * 認証する
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return 結果 (true / false)
	 */
	private boolean authenticate(String userId, String password) {

		// ★ここでは password = "pass" であれば true とする
		boolean result = password.equals("pass");

		return result;
	}
	
	/**
	 * 店舗情報（店舗名＋選択データ（リスト））を作成する
	 * @return 店舗情報
	 */
	private Store makeStore() {

		// 店舗情報作成
		Store store = new Store("キャル食料ショップ", new ArrayList<Product>());
		
		// 商品追加
		store.add(new Product("A110", "バナナ", 200, "img/banana.jpg"));
		store.add(new Product("A120", "アップル", 100, "img/apple.jpg"));
		store.add(new Product("A130", "ジャガイモ", 300, "img/potato.jpg"));
		store.add(new Product("A140", "サツマイモ", 200, "img/sweetpotato.jpg"));
		store.add(new Product("A150", "商品05", 9800, "e"));
		store.add(new Product("A160", "商品06", 1900, "f"));
		store.add(new Product("A170", "商品07", 3500, "g"));
		store.add(new Product("A180", "商品08", 11000, "h"));
		store.add(new Product("A190", "商品09", 4200, "i"));
		store.add(new Product("A200", "商品10", 7800, "j"));
		
		return store;
	}
	
	/**
	 * ログアウト時の処理
	 * @param session
	 */
	public void logoutProc(HttpSession session) {

		session.invalidate();
		
	}

	/**
	 * 商品追加処理
	 * @param idx 商品一覧の選択した商品のidx (セッション：store内)
	 * @param session セッションオブジェクト
	 */
	public void addProd(int idx, int amount, HttpSession session) {
		
		// 店舗情報・カート情報の取得（セッションより）
		Store store = (Store) session.getAttribute("store");
		Cart cart = (Cart) session.getAttribute("cart");

		
		/*
		 * 20241025 追加 Product
		 * 
		 */
		Product product = new Product();
		
		if ((store != null) && (cart != null)) {
			// カートに指定の商品を追加
			System.out.println("Moperation.addProd >> "+store.getListProd().get(idx));
			
			//cart.add(store.getListProd().get(idx),amount);
			cart.add(product,amount);
			
			// セッションに再度格納
			session.setAttribute("cart", cart);
		}

	}

	/**
	 * カートから商品削除処理
	 * @param idx カートの中の選択した商品のidx
	 * @param session セッションオブジェクト
	 */
	public void removeProd(int idx, HttpSession session) {
	
		// カート内商品情報の取得（セッションより）
		Cart cart = (Cart) session.getAttribute("cart");
	
		if (cart != null) {
			// カートから指定の商品を削除
			cart.remove(idx);

			// セッションに書き戻す
			session.setAttribute("cart", cart);
		}
			
	}
	
	/**
	 * 精算処理
	 * @param session セッションオブジェクト
	 */
	public void pay(HttpSession session) {

		// カート内商品情報の取得
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart != null) {
			// セッションに格納（精算済みデータ）
			session.setAttribute("pay", cart);

			// カート情報の新規作成⇒セッションに格納
			Cart newCart = new Cart(cart.getUserId(), new ArrayList<Product>());
			session.setAttribute("cart", newCart);
		}

	}

}
