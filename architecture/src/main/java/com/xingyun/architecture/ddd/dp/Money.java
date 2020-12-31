package com.xingyun.architecture.ddd.dp;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * 让隐性的上下文显性化
 */
public class Money {
	private BigDecimal amount;
	private Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}
}
