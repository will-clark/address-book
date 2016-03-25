package org.willclark.addressbook;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.willclark.addressbook.utils.DayUtils;

public class Params {

	private HttpServletRequest request;
	private Map<String, String> map;

	public Params(HttpServletRequest request) {
		this.request = request;
		init();
	}

	public boolean hasQueryString() {
		return (request.getQueryString() != null);
	}

	public boolean isGet() {
		return "GET".equalsIgnoreCase(request.getMethod());
	}

	public boolean isPost() {
		return "POST".equalsIgnoreCase(request.getMethod());
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean isDebug() {
		return getBoolean("debug");
	}

	public void setParam(String name, String value) {
		map.put(name, value);
	}

	public String[] getStrings(String param) {
		List<String> temp = new ArrayList<String>(0);
		String values = get(param);
		if (values != null) {
			for(String each : values.split(",")) {
				temp.add(each);
			}
		}
		return temp.toArray(new String[temp.size()]);
	}
	
	public String getString(String param) {
		return get(param);
	}

	public String getString(String param, String dft) {
		if (get(param) != null) {
			return get(param);
		}
		return dft;
	}

	public boolean getBoolean(String param) {
		String value = get(param);
		if (value != null) {
			if("y".equalsIgnoreCase(value)) return true;
			if("yes".equalsIgnoreCase(value)) return true;
			if("true".equalsIgnoreCase(value)) return true;
		}
		return false;
	}

	public long getLong(String param) {
		return Params.parseLong(get(param));
	}

	public long getLong(String param, long dft) {
		if (get(param) != null) {
			return getLong(param);
		}
		return dft;
	}

	public int getInt(String param) {
		return Params.parseInt(get(param));
	}

	public int getInt(String param, int dft) {
		if (get(param) != null) {
			return getInt(param);
		}
		return dft;
	}

	public double getDouble(String param) {
		return Params.parseDouble(get(param));
	}

	public double getDouble(String param, double dft) {
		if (get(param) != null) {
			return getDouble(param);
		}
		return dft;
	}

	public Date getDate(String param) {
		return getDate(param, DayUtils.INTERNAL_DATE_FORMAT);
	}

	public Date getDate(String param, Date dft) {
		if(getDate(param) != null) {
			return getDate(param);
		}
		return dft;
	}

	public Date getDate(String param, String format) {
		String value = get(param);
		if (value != null && format != null) {
			if (value.length() == format.length()) {
				return DayUtils.parse(value, format);
			}
		}
		return null;
	}

	public String getMonth(String param) {
		return getMonth(param, false);
	}

	public String getMonth(String param, boolean required) {
		return getMatch(param, required, "^((0[1-9])|(1[0-2]))$", "must be a month eg. 01-12");
	}

	public String getYear(String param) {
		return getYear(param, false);
	}

	public String getYear(String param, boolean required) {
		return getMatch(param, required, "[0-9]{4}", "must be a 4 digit number year");
	}

	public String getMatch(String param, boolean required, String regex, String error) {
		String value = get(param);
		if (value != null) {
			if (value.matches(regex)) {
				return value;
			}
		}
		return "";
	}

	private String get(String param) {
		if (map.get(param) == null || map.get(param).equals("")) {
			return null;
		}
		return map.get(param);
	}

	public String toQueryString(String... excluding) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		for(Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (excluding != null && Arrays.asList(excluding).contains(key)) continue;
			if (sb.length() > 0) sb.append("&");
			sb.append(key).append("=").append(value != null ? URLEncoder.encode(value, "UTF-8") : "");
		}

		if (sb.length() > 0) return "?"+sb.toString();
		return "";
	}

	@Override
	public String toString() {
		return map.toString();
	}

	private void init() {
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = request.getParameterMap();
		map = new HashMap<String, String>(0);
		for (String key : params.keySet()) {
			String value = null;
			for (String temp : params.get(key)) {
				if (temp == null) continue;
				temp = temp.trim();
				if (temp.length() == 0) continue;
				if (value == null) {
					value = temp;
				}
				else {
					value += "," + temp;
				}
			}
			map.put(key, value);
		}
	}
	
	public static int parseInt(String param) {
		int result = 0;
		try {
			result = Integer.parseInt(param);
		}
		catch (Exception e) {
			// do nothing
		}
		return result;
	}
	
	public static long parseLong(String param) {
		long result = 0;
		try {
			result = Long.parseLong(param);
		}
		catch (Exception e) {
			// do nothing
		}
		return result;
	}	
	
	public static double parseDouble(String param) {
		double result = 0;
		try {
			result = Double.parseDouble(param);
		}
		catch (Exception e) {
			// do nothing
		}
		return result;
	}
	
}
