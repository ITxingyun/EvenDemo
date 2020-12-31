package com.xingyun.architecture.ddd.dp;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * 封装多对象行为
 */
public class ExchangeRate {
	private BigDecimal rate;
	private Currency from;
	private Currency to;

	public ExchangeRate(BigDecimal rate, Currency from, Currency to) {
		this.rate = rate;
		this.from = from;
		this.to = to;
	}

	public Money exchange(@NonNull Money fromMoney) {
		isTrue(this.from.equals(fromMoney.getCurrency()));
		BigDecimal targetAmount = fromMoney.getAmount().multiply(rate);
		return new Money(targetAmount, to);
	}

	private void isTrue(boolean equals) {

	}
}
