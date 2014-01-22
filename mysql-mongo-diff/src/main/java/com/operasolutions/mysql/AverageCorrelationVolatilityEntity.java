package com.operasolutions.mysql;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.common.collect.ComparisonChain;
import com.operasolutions.CsvFieldFormat;
import com.operasolutions.Published;

public class AverageCorrelationVolatilityEntity implements
		Comparable<AverageCorrelationVolatilityEntity> {

	public String fundId;
	@Published(format = CsvFieldFormat.DATE)
	public Long date;

	public BigInteger windowId;

	@Published
	public Double correlation;
	@Published(format = CsvFieldFormat.PERCENTAGE)
	public Double volatility;
	@Published("contributingManagers")
	public BigDecimal volume;

	@Published
	public Double stressCorrelation;
	public Integer isNra;

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public BigInteger getWindowId() {
		return windowId;
	}

	public void setWindowId(BigInteger windowId) {
		this.windowId = windowId;
	}

	public Double getCorrelation() {
		return correlation;
	}

	public void setCorrelation(Double correlation) {
		this.correlation = correlation;
	}

	public Double getVolatility() {
		return volatility;
	}

	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}

	public Double getStressCorrelation() {
		return stressCorrelation;
	}

	public void setStressCorrelation(Double stressCorrelation) {
		this.stressCorrelation = stressCorrelation;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Integer getIsNra() {
		return isNra;
	}

	public void setIsNra(Integer isNra) {
		this.isNra = isNra;
	}

	@Override
	public String toString() {
		return "AverageCorrelationVolatilityEntity [fundId=" + fundId
				+ ", date=" + date + ", windowId=" + windowId
				+ ", correlation=" + correlation + ", volatility=" + volatility
				+ ", volume=" + volume + ", stressCorrelation="
				+ stressCorrelation + ", isNra=" + isNra + "]";
	}

	public int compareTo(AverageCorrelationVolatilityEntity o) {
		return ComparisonChain.start().compare(this.fundId, o.fundId)
				.compare(this.date, o.date).compare(this.windowId, o.windowId)
				.compare(this.correlation, o.correlation)
				.compare(this.volatility, o.volatility)
				.compare(this.volume, o.volume)
				.compare(this.stressCorrelation, o.stressCorrelation)
				.compare(this.isNra, o.isNra).result();
	}

}
