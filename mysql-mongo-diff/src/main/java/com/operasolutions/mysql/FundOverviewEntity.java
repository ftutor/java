package com.operasolutions.mysql;

import java.math.BigInteger;

import com.google.common.collect.ComparisonChain;

public class FundOverviewEntity implements Comparable<FundOverviewEntity> {

	public String fundName;
	public String fundId;
	public Long date;
	public Integer posId;
	public String complianceAlert;
	public BigInteger numPositions;
	public Double value;
	public Double gross;
	public Double net;
	public Double pnlDtd;
	public Double pnlMtd;
	public Double pnlYtd;
	public Double beta;
	public Double dividend;
	public String bucket;
	public String type;
	public Double riskStd;

	public Double valueNotional;
	public Double grossNotional;
	public Double netNotional;
	public Double pnlDtdNotional;
	public Double pnlMtdNotional;
	public Double pnlYtdNotional;

	public Double ivar95Hist;
	public Double ivar95HistNotional;

	public Double etl1D95Hist;
	public Double etl1D95HistNotional;

	public Double ivar99Hist;
	public Double ivar99HistNotional;

	public Double etl1D99Hist;
	public Double etl1D99HistNotional;

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public int compareTo(FundOverviewEntity o) {
		return ComparisonChain.start().compare(this.fundName, o.fundName)
				.compare(this.fundId, o.fundId)
				.compare(this.getDate(), o.getDate())
				.compare(this.posId, o.posId)
				.compare(this.complianceAlert, o.complianceAlert)

				.compare(this.numPositions, o.numPositions)
				.compare(this.value, o.value).compare(this.gross, o.gross)
				.compare(this.net, o.net).compare(this.pnlDtd, o.pnlDtd)
				.compare(this.pnlMtd, o.pnlMtd).compare(this.pnlYtd, o.pnlYtd)
				.compare(this.beta, o.beta)
				.compare(this.ivar95Hist, o.ivar95Hist)
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
				.compare(this.ivar95Hist, o.ivar95Hist)
				.compare(this.ivar95HistNotional, o.ivar95HistNotional)
				.compare(this.ivar99Hist, o.ivar99Hist)
				.compare(this.ivar99HistNotional, o.ivar99HistNotional)
				.compare(this.etl1D99Hist, o.etl1D99Hist)
				.compare(this.etl1D99HistNotional, o.etl1D99HistNotional)
				.result();
	}

	public String getFundName() {
		return fundName;
	}

	public String getFundId() {
		return fundId;
	}

	public Integer getPosId() {
		return posId;
	}

	public String getComplianceAlert() {
		return complianceAlert;
	}

	public BigInteger getNumPositions() {
		return numPositions;
	}

	public Double getValue() {
		return value;
	}

	public Double getGross() {
		return gross;
	}

	public Double getNet() {
		return net;
	}

	public Double getPnlDtd() {
		return pnlDtd;
	}

	public Double getPnlMtd() {
		return pnlMtd;
	}

	public Double getPnlYtd() {
		return pnlYtd;
	}

	public Double getBeta() {
		return beta;
	}

	public Double getDividend() {
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

	public Double getValueNotional() {
		return valueNotional;
	}

	public Double getGrossNotional() {
		return grossNotional;
	}

	public Double getNetNotional() {
		return netNotional;
	}

	public Double getPnlDtdNotional() {
		return pnlDtdNotional;
	}

	public Double getPnlMtdNotional() {
		return pnlMtdNotional;
	}

	public Double getPnlYtdNotional() {
		return pnlYtdNotional;
	}

	public Double getIvar95Hist() {
		return ivar95Hist;
	}

	public Double getIvar95HistNotional() {
		return ivar95HistNotional;
	}

	public Double getEtl1D95Hist() {
		return etl1D95Hist;
	}

	public Double getEtl1D95HistNotional() {
		return etl1D95HistNotional;
	}

	public Double getIvar99Hist() {
		return ivar99Hist;
	}

	public Double getIvar99HistNotional() {
		return ivar99HistNotional;
	}

	public Double getEtl1D99Hist() {
		return etl1D99Hist;
	}

	public Double getEtl1D99HistNotional() {
		return etl1D99HistNotional;
	}

	@Override
	public String toString() {
		return "FundOverviewEntity [fundName=" + fundName + ", fundId="
				+ fundId + ", date=" + date + ", posId=" + posId
				+ ", complianceAlert=" + complianceAlert + ", numPositions="
				+ numPositions + ", value=" + value + ", gross=" + gross
				+ ", net=" + net + ", pnlDtd=" + pnlDtd + ", pnlMtd=" + pnlMtd
				+ ", pnlYtd=" + pnlYtd + ", beta=" + beta + ", dividend="
				+ dividend + ", bucket=" + bucket + ", type=" + type
				+ ", riskStd=" + riskStd + ", valueNotional=" + valueNotional
				+ ", grossNotional=" + grossNotional + ", netNotional="
				+ netNotional + ", pnlDtdNotional=" + pnlDtdNotional
				+ ", pnlMtdNotional=" + pnlMtdNotional + ", pnlYtdNotional="
				+ pnlYtdNotional + ", ivar95Hist=" + ivar95Hist
				+ ", ivar95HistNotional=" + ivar95HistNotional
				+ ", etl1D95Hist=" + etl1D95Hist + ", etl1D95HistNotional="
				+ etl1D95HistNotional + ", ivar99Hist=" + ivar99Hist
				+ ", ivar99HistNotional=" + ivar99HistNotional
				+ ", etl1D99Hist=" + etl1D99Hist + ", etl1D99HistNotional="
				+ etl1D99HistNotional + "]";
	}

}
