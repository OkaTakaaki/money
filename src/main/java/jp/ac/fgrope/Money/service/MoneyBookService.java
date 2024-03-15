package jp.ac.fgrope.Money.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.fgrope.Money.model.MoneyBook;
import jp.ac.fgrope.Money.model.UserBook;
import jp.ac.fgrope.Money.repository.MoneyBookRepository;

@Service
@Transactional
public class MoneyBookService {

	@Autowired
	private MoneyBookRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<MoneyBook>
	 */
	public List<MoneyBook> getMoneyList(UserBook UserBook) {
	    List<MoneyBook> entityList = this.repository.findAllByNameEquals(UserBook.getUsername());
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  MoneyBook
	 */
	public MoneyBook get(@NonNull Long index) {
		MoneyBook MoneyBook = this.repository.findById(index).orElse(new MoneyBook());
		return MoneyBook;
	}

	/**
	 * アドレス帳データの保存
	 * @param MoneyBook MoneyBook
	 */
	public void save(@NonNull MoneyBook MoneyBook) {
		this.repository.save(MoneyBook);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
