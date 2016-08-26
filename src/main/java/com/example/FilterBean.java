package com.example;

import java.util.Date;

import lombok.Data;

@Data
public class FilterBean {
	private MatchType type;
	private Date date;
	
	public enum MatchType {
		A,
		W,
		M,
		T,
		U,
		F,
		D
	}
}
