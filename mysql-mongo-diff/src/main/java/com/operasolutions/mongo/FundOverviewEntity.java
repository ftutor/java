package com.operasolutions.mongo;

import com.google.common.collect.ComparisonChain;
import com.operasolutions.Utils;

public class FundOverviewEntity implements Comparable<FundOverviewEntity> {

	private String fundName;
	private String fundId;
	private Long date;
	private Integer posId;
	private Boolean complianceAlert;
	private Integer numPositions;
	private Float value;
	private Float gross;
	private Float net;
	private Float pnlDtd;
	private Float pnlMtd;
	private Float pnlYtd;
	private Float beta;
	private Float dividend;
	private String bucket;
	private String type;
	private Double riskStd;

	private Float valueNotional;
	private Float grossNotional;
	private Float netNotional;
	private Float pnlDtdNotional;
	private Float pnlMtdNotional;
	private Float pnlYtdNotional;

	private Float ivar95Hist;
	private Float ivar95HistNotional;

	private Float etl1D95Hist;
	private Float etl1D95HistNotional;

	private Float ivar99Hist;
	private Float ivar99HistNotional;

	private Float etl1D99Hist;
	private Float etl1D99HistNotional;

	private Integer isAggregated;

	@Override
	public int compareTo(FundOverviewEntity o) {
		return ComparisonChain.start().compare(this.fundName, o.fundName)
				.compare(this.fundId, o.fundId).compare(this.date, o.date)
				.compare(this.posId, o.posId)
				.compare(this.complianceAlert, o.complianceAlert)

				.compare(this.numPositions, o.numPositions)
				.compare(this.value, o.value).compare(this.gross, o.gross)
				.compare(this.net, o.net).compare(this.pnlDtd, o.pnlDtd)
				.compare(this.pnlMtd, o.pnlMtd).compare(this.pnlYtd, o.pnlYtd)
				.compare(this.beta, o.beta)

				.compare(this.dividend, o.dividend)
				.compare(this.bucket, o.bucket).compare(this.type, o.type)
				.compare(this.riskStd, o.riskStd)
				.compare(this.valueNotional, o.valueNotional)
				.compare(this.grossNotional, o.grossNotional)
				.compare(this.netNotional, o.netNotional)
				.compare(this.pnlDtdNotional, o.pnlDtdNotional)
				.compare(this.etl1D95Hist, o.etl1D95Hist)
				.compare(this.etl1D95HistNotional, o.etl1D95HistNotional)
				.compare(this.pnlMtdNotional, o.pnlMtdNotional)
				.compare(this.pnlYtdNotional, o.pnlYtdNotional)
				.compare(this.etl1D95Hist, o.ivar95Hist)
				.compare(this.ivar95Hist, o.ivar95Hist)
				.compare(this.ivar95HistNotional, o.ivar95HistNotional)
				.compare(this.ivar99Hist, o.ivar99Hist)
				.compare(this.ivar99HistNotional, o.ivar99HistNotional)
				.compare(this.etl1D99Hist, o.etl1D99Hist)
				.compare(this.etl1D99HistNotional, o.etl1D99HistNotional)
				.compare(this.isAggregated, o.isAggregated).result();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		com.operasolutions.mysql.FundOverviewEntity other = (com.operasolutions.mysql.FundOverviewEntity) obj;
		if (beta == null) {
			if (other.getBeta() != null)
				return false;
		} else if (Math.abs(beta - other.getBeta()) > Utils.doublePrecise)
			return false;
		if (bucket == null) {
			if (other.getBucket() != null)
				return false;
		} else if (!bucket.equals(other.getBucket()))
			return false;
		if (complianceAlert == null) {
			if (other.getComplianceAlert() != null)
				return false;
		} else if (!complianceAlert.equals(Boolean.valueOf(other
				.getComplianceAlert())))
			return false;
		if (date == null) {
			if (other.getDate() != null)
				return false;
		} else if (!date.equals(other.getDate()))
			return false;
		if (dividend == null) {
			if (other.getDividend() != null)
				return false;
		} else if (Math.abs(dividend - other.dividend) > Utils.doublePrecise)
			return false;
		if (etl1D95Hist == null) {
			if (other.etl1D95Hist != null)
				return false;
		} else if (Math.abs(etl1D95Hist - other.etl1D95Hist) > Utils.doublePrecise)
			return false;
		if (etl1D95HistNotional == null) {
			if (other.etl1D95HistNotional != null)
				return false;
		} else if (Math.abs(etl1D95HistNotional - other.etl1D95HistNotional) > Utils.doublePrecise)
			return false;
		if (etl1D99Hist == null) {
			if (other.etl1D99Hist != null)
				return false;
		} else if (Math.abs(etl1D99Hist - other.etl1D99Hist) > Utils.doublePrecise)
			return false;
		if (etl1D99HistNotional == null) {
			if (other.etl1D99HistNotional != null)
				return false;
		} else if (Math.abs(etl1D99HistNotional - other.etl1D99HistNotional) > Utils.doublePrecise)
			return false;
		if (fundId == null) {
			if (other.fundId != null)
				return false;
		} else if (!fundId.equals(other.fundId))
			return false;
		if (fundName == null) {
			if (other.fundName != null)
				return false;
		} else if (!fundName.equals(other.fundName))
			return false;
		if (gross == null) {
			if (other.gross != null)
				return false;
		} else if (Math.abs(beta - other.gross) > Utils.doublePrecise)
			return false;
		if (grossNotional == null) {
			if (other.grossNotional != null)
				return false;
		} else if (Math.abs(grossNotional - other.grossNotional) > Utils.doublePrecise)
			return false;

		if (ivar95Hist == null) {
			if (other.ivar95Hist != null)
				return false;
		} else if (!ivar95Hist.equals(other.ivar95Hist))
			return false;
		if (ivar95HistNotional == null) {
			if (other.ivar95HistNotional != null)
				return false;
		} else if (Math.abs(beta - other.getBeta()) > Utils.doublePrecise)
			return false;
		if (ivar99Hist == null) {
			if (other.getIvar99Hist() != null)
				return false;
		} else if (Math.abs(ivar99Hist - other.getIvar99Hist()) > Utils.doublePrecise)
			return false;
		if (ivar99HistNotional == null) {
			if (other.getIvar99HistNotional() != null)
				return false;
		} else if (Math.abs(ivar99HistNotional - other.getIvar99HistNotional()) > Utils.doublePrecise)
			return false;
		if (net == null) {
			if (other.getNet() != null)
				return false;
		} else if (Math.abs(net - other.getNet()) > Utils.doublePrecise)
			return false;
		if (netNotional == null) {
			if (other.getNetNotional() != null)
				return false;
		} else if (Math.abs(netNotional - other.getNetNotional()) > Utils.doublePrecise)
			return false;
		if (numPositions == null) {
			if (other.getNumPositions() != null)
				return false;
		} else if (numPositions != other.getNumPositions().intValue())
			return false;
		if (pnlDtd == null) {
			if (other.getPnlDtd() != null)
				return false;
		} else if (Math.abs(pnlDtd - other.getPnlDtd()) > Utils.doublePrecise)
			return false;
		if (pnlDtdNotional == null) {
			if (other.getPnlDtdNotional() != null)
				return false;
		} else if (Math.abs(pnlDtdNotional - other.getPnlDtdNotional()) > Utils.doublePrecise)
			return false;
		if (pnlMtd == null) {
			if (other.getPnlMtd() != null)
				return false;
		} else if (Math.abs(pnlMtd - other.getPnlMtd()) > Utils.doublePrecise)
			return false;
		if (pnlMtdNotional == null) {
			if (other.getPnlMtdNotional() != null)
				return false;
		} else if (Math.abs(pnlMtdNotional - other.getPnlMtdNotional()) > Utils.doublePrecise)
			return false;
		if (pnlYtd == null) {
			if (other.getPnlYtd() != null)
				return false;
		} else if (Math.abs(pnlYtd - other.getPnlYtd()) > Utils.doublePrecise)
			return false;
		if (pnlYtdNotional == null) {
			if (other.getPnlYtdNotional() != null)
				return false;
		} else if (Math.abs(pnlYtdNotional - other.getPnlYtdNotional()) > Utils.doublePrecise)
			return false;
		if (posId == null) {
			if (other.getPosId() != null)
				return false;
		} else if (posId != other.posId)
			return false;
		if (riskStd == null) {
			if (other.getRiskStd() != null)
				return false;
		} else if (Math.abs(riskStd - other.getRiskStd()) > Utils.doublePrecise)
			return false;
		if (type == null) {
			if (other.getType() != null)
				return false;
		} else if (!type.equals(other.getType()))
			return false;
		if (value == null) {
			if (other.getValue() != null)
				return false;
		} else if (!value.equals(other.getValue()))
			return false;
		if (valueNotional == null) {
			if (other.getValueNotional() != null)
				return false;
		} else if (Math.abs(valueNotional - other.getValueNotional()) > Utils.doublePrecise)
			return false;
		return true;
	}

	public String getFundName() {
		return fundName;
	}

	public String getFundId() {
		return fundId;
	}

	public Long getDate() {
		return date;
	}

	public Integer getPosId() {
		return posId;
	}

	public Boolean getComplianceAlert() {
		return complianceAlert;
	}

	public Integer getNumPositions() {
		return numPositions;
	}

	public Float getValue() {
		return value;
	}

	public Float getGross() {
		return gross;
	}

	public Float getNet() {
		return net;
	}

	public Float getPnlDtd() {
		return pnlDtd;
	}

	public Float getPnlMtd() {
		return pnlMtd;
	}

	public Float getPnlYtd() {
		return pnlYtd;
	}

	public Float getBeta() {
		return beta;
	}

	public Float getDividend() {
		return dividend;
	}

	public String getBucket() {
		return bucket;
	}

	public String getType() {
		return type;
	}

	public Double getRiskStd() {
		return riskStd;
	}

	public Float getValueNotional() {
		return valueNotional;
	}

	public Float getGrossNotional() {
		return grossNotional;
	}

	public Float getNetNotional() {
		return netNotional;
	}

	public Float getPnlDtdNotional() {
		return pnlDtdNotional;
	}

	public Float getPnlMtdNotional() {
		return pnlMtdNotional;
	}

	public Float getPnlYtdNotional() {
		return pnlYtdNotional;
	}

	public Float getIvar95Hist() {
		return ivar95Hist;
	}

	public Float getIvar95HistNotional() {
		return ivar95HistNotional;
	}

	public Float getEtl1D95Hist() {
		return etl1D95Hist;
	}

	public Float getEtl1D95HistNotional() {
		return etl1D95HistNotional;
	}

	public Float getIvar99Hist() {
		return ivar99Hist;
	}

	public Float getIvar99HistNotional() {
		return ivar99HistNotional;
	}

	public Float getEtl1D99Hist() {
		return etl1D99Hist;
	}

	public Float getEtl1D99HistNotional() {
		return etl1D99HistNotional;
	}

	public Integer getIsAggregated() {
		return isAggregated;
	}

}