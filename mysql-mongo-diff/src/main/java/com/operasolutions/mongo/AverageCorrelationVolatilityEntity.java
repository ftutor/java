package com.operasolutions.mongo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.collect.ComparisonChain;
import com.operasolutions.CsvFieldFormat;
import com.operasolutions.Published;
import com.operasolutions.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
final class AverageCorrelationVolatilityEntity implements
		Comparable<AverageCorrelationVolatilityEntity> {

	private static Logger logger = Logger
			.getLogger(AverageCorrelationVolatilityEntity.class);

	private ObjectId _id;

	private String fundId;
	@Published(format = CsvFieldFormat.DATE)
	private Long date;

	private Integer windowId;

	@Published
	private Float correlation;
	@Published(format = CsvFieldFormat.PERCENTAGE)
	private Float volatility;
	@Published("contributingManagers")
	private Float volume;

	@Published
	private Float stressCorrelation;
	private Integer isNra;

	public int compareTo(AverageCorrelationVolatilityEntity o) {
		return ComparisonChain.start().compare(this.fundId, o.fundId)
				.compare(this.date, o.date).compare(this.windowId, o.windowId)
				.compare(this.correlation, o.correlation)
				.compare(this.volatility, o.volatility)
				.compare(this.volume, o.volume)
				.compare(this.stressCorrelation, o.stressCorrelation)
				.compare(this.isNra, o.isNra).result();
	}

	@Override
	public boolean equals(Object obj) {
		logger.info("call equal method");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		com.operasolutions.mysql.AverageCorrelationVolatilityEntity other = (com.operasolutions.mysql.AverageCorrelationVolatilityEntity) obj;
		logger.info("---------------");
		if (fundId == null) {
			if (other.fundId != null) {
				logger.info("fundId mismatch");
				return false;
			}
		} else if (!fundId.equals(other.fundId)) {
			logger.info("fundId mismatch");
			return false;
		}

		if (date == null) {
			if (other.date != null) {
				logger.info("date mismatch");
				return false;
			}
		} else if (date != other.date.longValue()) {
			logger.info("orgial:" + date + " compare date" + other.date);
			logger.info("date mismatch");
			return false;
		}
		if (windowId == null) {
			if (other.windowId != null) {
				logger.info("windowId mismatch");
				return false;
			}
		} else if (windowId != other.windowId.intValue()) {
			logger.info("windowId mismatch");
			return false;
		}

		if (correlation == null) {
			if (other.correlation != null) {
				logger.info("correlation mismatch");
				return false;
			}
		} else if (Math.abs(correlation - other.correlation) > Utils.doublePrecise) {
			logger.info("correlation mismatch");
			return false;
		}
		if (volatility == null) {
			if (other.volatility != null) {
				logger.info("volatility mismatch");
				return false;
			}
		} else if (Math.abs(volatility - other.volatility) > Utils.doublePrecise) {
			logger.info("volatility mismatch");
			return false;
		}

		if (stressCorrelation == null) {
			if (other.stressCorrelation != null) {
				logger.info("stressCorrelation mismatch");
				return false;
			}
		} else if (Math.abs(stressCorrelation - other.stressCorrelation) > Utils.doublePrecise) {
			logger.info("stressCorrelation mismatch");
			return false;
		}
		return true;
	}

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

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
	}

	public Float getCorrelation() {
		return correlation;
	}

	public void setCorrelation(Float correlation) {
		this.correlation = correlation;
	}

	public Float getVolatility() {
		return volatility;
	}

	public void setVolatility(Float volatility) {
		this.volatility = volatility;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Float getStressCorrelation() {
		return stressCorrelation;
	}

	public void setStressCorrelation(Float stressCorrelation) {
		this.stressCorrelation = stressCorrelation;
	}

	public Integer getIsNra() {
		return isNra;
	}

	public void setIsNra(Integer isNra) {
		this.isNra = isNra;
	}

	@Override
	public String toString() {
		return "AverageCorrelationVolatilityEntity [_id=" + _id + ", fundId="
				+ fundId + ", date=" + date + ", windowId=" + windowId
				+ ", correlation=" + correlation + ", volatility=" + volatility
				+ ", volume=" + volume + ", stressCorrelation="
				+ stressCorrelation + ", isNra=" + isNra + "]";
	}

}
