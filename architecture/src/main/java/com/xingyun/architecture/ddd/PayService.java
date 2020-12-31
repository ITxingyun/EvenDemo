package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.ExchangeRate;
import com.xingyun.architecture.ddd.dp.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class PayService {

	public void pay(BigDecimal money, Long recipientId) {
		BankService.transfer(money, "CNY", recipientId);
	}

	/**
	 * {@link #pay(BigDecimal money, Long recipientId)}
	 * 让隐性的上下文显性化
	 */
	public void pay(Money money, Long recipientId) {
		BankService.transfer(money, recipientId);
	}


	/*public void pay(Money money, Currency targetCurrency, Long recipientId) {
		if (money.getCurrency().equals(targetCurrency)) {
			BankService.transfer(money, recipientId);
		} else {
			BigDecimal rate = ExchangeService.getRate(money.getCurrency(), targetCurrency);
			BigDecimal targetAmount = money.getAmount().multiply(new BigDecimal(String.valueOf(rate)));
			Money targetMoney = new Money(targetAmount, targetCurrency);
			BankService.transfer(targetMoney, recipientId);
		}
	}*/

	/**
	 * 封装多对象行为
	 */
	public void pay(Money money, Currency targetCurrency, Long recipientId) {
		ExchangeRate rate = ExchangeService.getRate(money.getCurrency(), targetCurrency);
		Money targetMoney = rate.exchange(money);
		BankService.transfer(targetMoney, recipientId);
	}


}
